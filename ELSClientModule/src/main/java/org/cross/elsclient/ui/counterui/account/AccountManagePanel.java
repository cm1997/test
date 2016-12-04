package org.cross.elsclient.ui.counterui.account;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;

import org.cross.elsclient.blservice.accountblservice.AccountBLService;
import org.cross.elsclient.blservice.personnelblservice.PersonnelBLService;
import org.cross.elsclient.ui.adminui.UserAddPanel;
import org.cross.elsclient.ui.adminui.UserManagePanel;
import org.cross.elsclient.ui.adminui.UserManageTable;
import org.cross.elsclient.ui.component.ELSButton;
import org.cross.elsclient.ui.component.ELSManagePanel;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.component.ELSTextField;
import org.cross.elsclient.ui.util.ComponentFactory;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.vo.AccountVO;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.util.UserType;

public class AccountManagePanel extends ELSManagePanel {
	AccountBLService accountbl;
	ArrayList<AccountVO> accountVOs;
	AccountManageTable list;
	ELSButton addBtn;
	
	public AccountManagePanel(AccountBLService accountbl) {
		super();
		this.accountbl = accountbl;
		init();
	}
	
	@Override
	public void setContentPanel() {
		// TODO Auto-generated method stub
		super.setContentPanel();
		String[] s = {"账户名称","账户卡号","账户余额"};
		int[] itemWidth = {200,300,150};
		list= new AccountManageTable(s,itemWidth,accountbl);
		list.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT,UIConstant.CONTENTPANEL_MARGIN_TOP*2+UIConstant.SEARCHPANEL_HEIGHT);
		
		try {
			accountVOs = accountbl.show();
			list.init();
			for (AccountVO accountVO : accountVOs) {
				list.addItem(accountVO);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		container.add(list);
		container.packHeight();
	}
	
	@Override
	public void setSearchPanel() {
		addBtn = ComponentFactory.createSearchBtn();
		
		String[] s = {"按账户名称查询", "按账户卡号查询"};
		modeBox.setModel(new DefaultComboBoxModel<String>(s));
		modeBox.addItemListener(new ModeBoxItemListener());
		
		//搜索按钮设置文字和监听
		searchBtn.setText("查找账户");
		searchBtn.addMouseListener(new BtnListener());
		
		//添加按钮设置文字和监听
		addBtn.setText("添加账户");
		addBtn.addMouseListener(new BtnListener());
		
		//添加间隔
		searchPanel.add(Box.createHorizontalStrut(10));
		searchPanel.add(addBtn);
		
		
		searchPanel.validate();
	}
	
	class BtnListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource()==searchBtn){
				if(((String)modeBox.getSelectedItem()).equals("按账户名称查询")){
					String name = searchTextField.getText();
					accountVOs = new ArrayList<>();
					try {
//						userVOs.add(userbl.findById(id));
						accountVOs = accountbl.findByName(name);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					list.init();
					for (AccountVO accountVO : accountVOs) {
						list.addItem(accountVO);
					}
					//容器自适应高度
					container.packHeight();
				} else if(((String)modeBox.getSelectedItem()).equals("按账户卡号查询")){
					String id = searchTextField.getText();
					accountVOs = new ArrayList<>();
					try {
						AccountVO vo = accountbl.findByID(id);
						if(vo!=null){
							accountVOs.add(vo);
						}
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					list.init();
					for (AccountVO accountVO : accountVOs) {
						list.addItem(accountVO);
					}
					//容器自适应高度
					container.packHeight();
					
				}
			}
			
			if (e.getSource() == addBtn){
				//界面统一添加到功能界面(managePanel的父容器)
//				UserAddPanel userAddPanel = new UserAddPanel(userbl);
				ELSPanel parent = (ELSPanel) getParent();
				parent.add("add",new AccoutAddPanel(accountbl));
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
//			if(e.getStateChange()==ItemEvent.SELECTED){
//				String item = (String)modeBox.getSelectedItem();
//				switch (item) {
//				case "按账户名称查询":
//					searchTextField.setVisible(true);
//					idSearchField.setVisible(false);
//					searchPanel.validate();
//					break;
//				case "按账户卡号查询":
//					searchTextField.setVisible(false);
//					idSearchField.setVisible(true);
//					searchPanel.validate();
//					break;
//				default:
//					searchTextField.setVisible(false);
//					break;
//				}
//			}
		}
		
	}
}

	

