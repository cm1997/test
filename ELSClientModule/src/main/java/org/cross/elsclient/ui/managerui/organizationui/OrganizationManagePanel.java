package org.cross.elsclient.ui.managerui.organizationui;

import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;

import org.cross.elsclient.blservice.organizationblservice.OrganizationBLService;
import org.cross.elsclient.blservice.stockblservice.StockBLService;
import org.cross.elsclient.ui.component.ELSButton;
import org.cross.elsclient.ui.component.ELSComboBox;
import org.cross.elsclient.ui.component.ELSManagePanel;
import org.cross.elsclient.ui.component.ELSManageTable;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.util.ComponentFactory;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.vo.OrganizationVO;
import org.cross.elscommon.util.StringToType;

public class OrganizationManagePanel extends ELSManagePanel{
	OrganizationBLService organizationbl;
	StockBLService stockbl;
	ArrayList<OrganizationVO> organizationVOs;
	OrganizationManageTable list;
	ELSButton addBtn;
	ELSButton stockBtn;
	ELSComboBox typeComboBox;
	ELSComboBox areaComboBox;
	
	public OrganizationManagePanel(){}
	
	public OrganizationManagePanel(OrganizationBLService organizationbl,StockBLService stockbl) {
		super();
		this.stockbl = stockbl;
		this.organizationbl = organizationbl;
		init();
	}

	
	@Override
	public void setContentPanel() {
		// TODO Auto-generated method stub
		super.setContentPanel();
		String[] s = {"机构编号","地区","类型"};
		int[] itemWidth = {200,100,100};
		list= new OrganizationManageTable(s,itemWidth,organizationbl);
		list.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT,UIConstant.CONTENTPANEL_MARGIN_TOP*2+UIConstant.SEARCHPANEL_HEIGHT);
		container.add(list);
		showAll();
	}
	
	@Override
	public void setSearchPanel() {
		typeComboBox = ComponentFactory.createSearchBox();
		areaComboBox = ComponentFactory.createSearchBox();
		
		String[] s = {"按机构编号查找","按机构地区查找", "按机构类型查找"};
		modeBox.setModel(new DefaultComboBoxModel<String>(s));
		modeBox.addItemListener(new ModeBoxItemListener());
		
		String[] types = {"营业厅","中转中心", "总部"};
		typeComboBox.setModel(new DefaultComboBoxModel<String>(types));
		
		String[] area = {"北京","上海", "南京","广州"};
		areaComboBox.setModel(new DefaultComboBoxModel<String>(area));
		
		searchBtn.setText("查找机构");
		searchBtn.addMouseListener(new BtnListener());
		
		typeComboBox.setVisible(false);
		areaComboBox.setVisible(false);
		
		addBtn = ComponentFactory.createSearchBtn();
		addBtn.setText("添加机构");
		addBtn.addMouseListener(new BtnListener());
		
		stockBtn = ComponentFactory.createSearchBtn();
		stockBtn.setText("添加仓库");
		stockBtn.addMouseListener(new BtnListener());
		
		searchBtn.setPreferredSize(new Dimension(100, UIConstant.SEARCHPANEL_HEIGHT));
		searchBtn.setMaximumSize(new Dimension(150, UIConstant.SEARCHPANEL_HEIGHT));
		searchBtn.setMinimumSize(new Dimension(100, UIConstant.SEARCHPANEL_HEIGHT));
		
		addBtn.setPreferredSize(new Dimension(100, UIConstant.SEARCHPANEL_HEIGHT));
		addBtn.setMaximumSize(new Dimension(150, UIConstant.SEARCHPANEL_HEIGHT));
		addBtn.setMinimumSize(new Dimension(100, UIConstant.SEARCHPANEL_HEIGHT));
		
		stockBtn.setPreferredSize(new Dimension(100, UIConstant.SEARCHPANEL_HEIGHT));
		stockBtn.setMaximumSize(new Dimension(150, UIConstant.SEARCHPANEL_HEIGHT));
		stockBtn.setMinimumSize(new Dimension(100, UIConstant.SEARCHPANEL_HEIGHT));
		
		searchPanel.add(areaComboBox,3);
		searchPanel.add(typeComboBox,3);
		searchPanel.add(Box.createHorizontalStrut(10));
		searchPanel.add(addBtn);
		searchPanel.add(Box.createHorizontalStrut(10));
		searchPanel.add(stockBtn);
		
		searchPanel.validate();
	}
	
	public void showAll(){
		list.init();
		try {
			organizationVOs = organizationbl.show();
			for (OrganizationVO organizationVO : organizationVOs) {
				list.addItem(organizationVO);
			}
			container.packHeight();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	class BtnListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
			if (e.getSource() == searchBtn) {
				switch (((String)modeBox.getSelectedItem())) {
				case "按机构编号查找":
					String id = searchTextField.getText();
					organizationVOs = new ArrayList<>();
					try {
						organizationVOs.add(organizationbl.findById(id));
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					list.init();
					for (OrganizationVO organizationVO : organizationVOs) {
						list.addItem(organizationVO);
					}
					break;
				case "按机构地区查找":
					String area = (String)areaComboBox.getSelectedItem();
					organizationVOs = new ArrayList<>();
					try {
//						System.out.println(StringToType.toCity(area));
						organizationVOs = organizationbl.findByCity(StringToType.toCity(area));
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					list.init();
					for (OrganizationVO organizationVO : organizationVOs) {
						list.addItem(organizationVO);
					}
					break;
					
				case "按机构类型查找":
					String type = (String)typeComboBox.getSelectedItem();
					organizationVOs = new ArrayList<>();
					try {
						organizationVOs = organizationbl.findByType(StringToType.toOrg(type));
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					list.init();
					for (OrganizationVO organizationVO : organizationVOs) {
						list.addItem(organizationVO);
					}
					break;
				default:
					break;
				}
				
			} else if (e.getSource() == addBtn) {
				OrganizationAddPanel addPanel = new OrganizationAddPanel(organizationbl);
				ELSPanel parent = (ELSPanel) getParent();
				parent.add("add",addPanel);
				parent.cl.show(parent, "add");
			} else if (e.getSource() == stockBtn) {
				StockAddPanel addPanel = new StockAddPanel(stockbl);
				ELSPanel parent = (ELSPanel) getParent();
				parent.add("add",addPanel);
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
	
	class ModeBoxItemListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange()==ItemEvent.SELECTED){
				String item = (String)modeBox.getSelectedItem();
				switch (item) {
				case "按机构编号查找":
					searchTextField.setVisible(true);
					typeComboBox.setVisible(false);
					areaComboBox.setVisible(false);
					break;
				case "按机构地区查找":
					searchTextField.setVisible(false);
					typeComboBox.setVisible(false);
					areaComboBox.setVisible(true);
					break;
				case "按机构类型查找":
					searchTextField.setVisible(false);
					typeComboBox.setVisible(true);
					areaComboBox.setVisible(false);
					break;
				default:
					searchTextField.setVisible(false);
					break;
				}
			}
		}
		
	}
}
