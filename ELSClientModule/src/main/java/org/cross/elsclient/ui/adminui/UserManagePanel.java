package org.cross.elsclient.ui.adminui;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.*;
import javax.xml.bind.Marshaller.Listener;

import org.cross.elsclient.blservice.userblservice.UserBLService;
import org.cross.elsclient.ui.component.ELSButton;
import org.cross.elsclient.ui.component.ELSComboBox;
import org.cross.elsclient.ui.component.ELSDatePicker;
import org.cross.elsclient.ui.component.ELSComfirmDialog;
import org.cross.elsclient.ui.component.ELSFunctionPanel;
import org.cross.elsclient.ui.component.ELSManageTable;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.component.ELSTextField;
import org.cross.elsclient.ui.component.ELSManagePanel;
import org.cross.elsclient.ui.util.ComponentFactory;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.util.StringToType;
import org.cross.elscommon.util.UserType;
import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

public class UserManagePanel extends ELSManagePanel {
	UserBLService userbl;
	ArrayList<UserVO> userVOs;
	UserManageTable list;
	ELSComboBox typeCombobox;
	ELSButton addBtn;
	
	public UserManagePanel(){}
	
	public UserManagePanel(UserBLService userbl) {
		super();
		this.userbl = userbl;
		init();
	}

	
	@Override
	public void setContentPanel() {
		// TODO Auto-generated method stub
		super.setContentPanel();
		String[] s = {"编号","姓名","类型"};
		int[] itemWidth = {150,100,200};
		list= new UserManageTable(s,itemWidth,userbl);
		list.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT,UIConstant.CONTENTPANEL_MARGIN_TOP*2+UIConstant.SEARCHPANEL_HEIGHT);
		try {
			userVOs = userbl.show();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list.init();
		if(!userVOs.isEmpty()){
			for (UserVO userVO : userVOs) {
				list.addItem(userVO);
			}
		}
		container.add(list);
		container.packHeight();
		validate();
	}
	
	@Override
	public void setSearchPanel() {
		//默认搜索面板有一个modeBox,一个searchTextField,一个SearchBtn(btn1)
		//另外需要的组件可以用ComponentFactory生成, 不用设置尺寸
		typeCombobox = ComponentFactory.createSearchBox();
		addBtn = ComponentFactory.createSearchBtn();
		
		//设置搜索模式
		String[] s = {"按编号查找", "按姓名查找", "按用户类型查找"};
		modeBox.setModel(new DefaultComboBoxModel<String>(s));
		modeBox.addItemListener(new ModeBoxItemListener());
		
		//设置类型选择的搜索下拉框
		String[] types = {"快递员", "营业厅业务员","中转中心业务员","仓库管理人员","财务人员","高级财务人员","总经理","系统管理员"};
		typeCombobox.setModel(new DefaultComboBoxModel<String>(types));
		
		//搜索按钮设置文字和监听
		searchBtn.setText("查找用户");
		searchBtn.addMouseListener(new BtnListener());
		
		//添加按钮设置文字和监听
		addBtn.setText("添加用户");
		addBtn.addMouseListener(new BtnListener());
		
		//添加间隔
		searchPanel.add(Box.createHorizontalStrut(10));
		searchPanel.add(addBtn);
		
		//除了默认搜索方式外都要设置成不可见
		typeCombobox.setVisible(false);
		
		searchPanel.add(typeCombobox,3);
		searchPanel.validate();
	}
	
	class BtnListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource()==searchBtn){
				if(((String)modeBox.getSelectedItem()).equals("按编号查找")){
					String id = searchTextField.getText();
					userVOs = new ArrayList<>();
					try {
						UserVO vo = userbl.findById(id);
						if(vo!=null){
							userVOs.add(vo);
						}
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
					list.init();
					if(!userVOs.isEmpty()){
						for (UserVO userVO : userVOs) {
							list.addItem(userVO);
						}
					}
					//容器自适应高度
					container.packHeight();
				}else if(((String)modeBox.getSelectedItem()).equals("按姓名查找")){
					String name = searchTextField.getText();
					userVOs = new ArrayList<>();
					try {
						userVOs = userbl.findByName(name);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					list.init();
					for (UserVO userVO : userVOs) {
						list.addItem(userVO);
					}
					//容器自适应高度
					container.packHeight();
				}else if(((String)modeBox.getSelectedItem()).equals("按用户类型查找")){
					String type = (String)typeCombobox.getSelectedItem();
					userVOs = new ArrayList<>();
					try {
						userVOs=userbl.findByType(StringToType.toUserType(type));
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					list.init();
					for (UserVO userVO : userVOs) {
						list.addItem(userVO);
					}
				}
			}
			if (e.getSource() == addBtn){
				//界面统一添加到功能界面(managePanel的父容器)
				UserAddPanel userAddPanel = new UserAddPanel(userbl);
				ELSPanel parent = (ELSPanel) getParent();
				parent.add("add",userAddPanel);
				parent.cl.show(parent, "add");
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	
	/**
	 * 搜索模式的监听类
	 * @author Moo
	 * @date 2015年11月26日
	 */
	class ModeBoxItemListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange()==ItemEvent.SELECTED){
				String item = (String)modeBox.getSelectedItem();
				switch (item) {
				case "按编号查找":
				case "按姓名查找":
					searchTextField.setVisible(true);
					typeCombobox.setVisible(false);
					break;
				case "按用户类型查找":
					searchTextField.setVisible(false);
					typeCombobox.setVisible(true);
					break;
				default:
					searchTextField.setVisible(false);
					break;
				}
			}
		}
		
	}
}
