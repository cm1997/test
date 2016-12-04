package org.cross.elsclient.ui.managerui.personnel;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;

import org.cross.elsclient.blservice.personnelblservice.PersonnelBLService;
import org.cross.elsclient.ui.component.ELSButton;
import org.cross.elsclient.ui.component.ELSComboBox;
import org.cross.elsclient.ui.component.ELSManagePanel;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.util.ComponentFactory;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elscommon.util.StringToType;

public class PerManagePanel extends ELSManagePanel {
	PersonnelBLService personnelbl;
	ArrayList<PersonnelVO> personnelVOs;
	PerManageTable list;
	ELSComboBox typeCombobox;
	ELSButton addBtn;

	public PerManagePanel(PersonnelBLService personnelbl) {
		super();
		this.personnelbl = personnelbl;
		init();
	}

	@Override
	public void setContentPanel() {
		// TODO Auto-generated method stub
		super.setContentPanel();

		String[] name = { "人员编号", "姓名", "职位", "所属机构" };
		int[] itemWidth = { 150, 150, 150, 200 };
		list = new PerManageTable(name, itemWidth, personnelbl);
		list.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT,
				UIConstant.CONTENTPANEL_MARGIN_TOP * 2
						+ UIConstant.SEARCHPANEL_HEIGHT);
		container.add(list);
		showAll();
	}

	@Override
	public void setSearchPanel() {
		// TODO Auto-generated method stub
		super.setSearchPanel();
		typeCombobox = ComponentFactory.createSearchBox();
		addBtn = ComponentFactory.createSearchBtn();

		String s[] = { "按人员编号查找", "按人员姓名查找", "按人员职位查找" };
		modeBox.setModel(new DefaultComboBoxModel<String>(s));
		modeBox.addItemListener(new ModeBoxItemListener());

		String[] types = { "快递员", "营业厅业务员", "中转中心业务员", "仓库管理人员", "财务人员",
				"高级财务人员", "总经理", "系统管理员","司机" };
		typeCombobox.setModel(new DefaultComboBoxModel<String>(types));

		searchBtn.setText("查找人员");
		searchBtn.addMouseListener(new BtnListener());

		addBtn.setText("添加人员");
		addBtn.addMouseListener(new BtnListener());

		searchPanel.add(Box.createHorizontalStrut(10));
		searchPanel.add(addBtn);
		
		typeCombobox.setVisible(false);
		
		searchPanel.add(typeCombobox,3);
		searchPanel.validate();
	}
	
	public void showAll(){
		list.init();
		try {
			personnelVOs = personnelbl.show();
			for (PersonnelVO personnelVO : personnelVOs) {
				list.addItem(personnelVO);
			}
			container.packHeight();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	class BtnListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

			if (e.getSource() == searchBtn) {
				if (((String) modeBox.getSelectedItem()).equals("按人员编号查找")) {
					String id = searchTextField.getText();
					personnelVOs = new ArrayList<>();
					try {
						PersonnelVO vo = personnelbl.findById(id);
						if(vo!=null){
							personnelVOs.add(vo);
						}
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					list.init();
					for (PersonnelVO personnelVO : personnelVOs) {
						list.addItem(personnelVO);
					}
					// 容器自适应高度
					container.packHeight();
				} else if (((String) modeBox.getSelectedItem()).equals("按人员姓名查找")) {
					String name = searchTextField.getText();
					personnelVOs = new ArrayList<>();
					try {
						// userVOs.add(userbl.findById(id));
						personnelVOs = personnelbl.findByName(name);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					list.init();
					for (PersonnelVO personnelVO : personnelVOs) {
						list.addItem(personnelVO);
					}
					// 容器自适应高度
					container.packHeight();
				} else if (((String) modeBox.getSelectedItem()).equals("按人员职位查找")) {
					String tpye = (String)typeCombobox.getSelectedItem();
					personnelVOs = new ArrayList<>();
					try {
						personnelVOs = personnelbl.findByPosition(StringToType.toPositionType((String)typeCombobox.getSelectedItem()));
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					list.init();
					for (PersonnelVO personnelVO : personnelVOs) {
						list.addItem(personnelVO);
					}
					// 容器自适应高度
					container.packHeight();
					
				}
			}
			if (e.getSource() == addBtn) {
				PerAddPanel perAddPanel = new PerAddPanel(personnelbl);
				ELSPanel parent = (ELSPanel) getParent();
				parent.add("add", perAddPanel);
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
	 * 
	 * @author Moo
	 * @date 2015年11月26日
	 */
	class ModeBoxItemListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				String item = (String) modeBox.getSelectedItem();
				switch (item) {
				case "按人员编号查找":
				case "按人员姓名查找":
					searchTextField.setVisible(true);
					typeCombobox.setVisible(false);
					break;
				case "按人员职位查找":
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
