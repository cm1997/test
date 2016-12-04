package org.cross.elsclient.ui.businesshallclerkui.vehicle;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;

import org.cross.elsclient.blservice.userblservice.UserBLService;
import org.cross.elsclient.blservice.vehicleblservice.VehicleBLService;
import org.cross.elsclient.ui.adminui.AdminFunctionPanel;
import org.cross.elsclient.ui.businesshallclerkui.BusinessFunctionPanel;
import org.cross.elsclient.ui.component.ELSButton;
import org.cross.elsclient.ui.component.ELSManagePanel;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.util.ComponentFactory;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.vo.UserVO;
import org.cross.elsclient.vo.VehicleVO;


public class VehicleManagePanel extends ELSManagePanel{
	VehicleBLService vehiclebl;
	ArrayList<VehicleVO> vehicleVOs;
	VehicleManageTable list;
	ELSButton addBtn;
	
	public VehicleManagePanel(){}
	
	public VehicleManagePanel(VehicleBLService vehiclebl) {
		super();
		this.vehiclebl = vehiclebl;
		init();
	}
	
	@Override
	public void setContentPanel() {
		// TODO Auto-generated method stub
		super.setContentPanel();
		String[] s = {"车辆编号","车牌号","服役时间"};
		int[] itemWidth = {150,150,400};
		list= new VehicleManageTable(s,itemWidth,vehiclebl);
		try {
			vehicleVOs = vehiclebl.show();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(VehicleVO vo: vehicleVOs){
			list.addItem(vo);
		}
		list.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT,UIConstant.CONTENTPANEL_MARGIN_TOP*2+UIConstant.SEARCHPANEL_HEIGHT);
		container.add(list);
	}
	
	@Override
	public void setSearchPanel() {
		String[] s = {"按车辆编号查询"};
		modeBox.setModel(new DefaultComboBoxModel<String>(s));
		modeBox.addItemListener(new ModeBoxItemListener());
		
		searchBtn.setText("查找车辆");
		searchBtn.addMouseListener(new BtnListener());
		
		addBtn = ComponentFactory.createSearchBtn();
		addBtn.setText("添加车辆");
		addBtn.addMouseListener(new BtnListener());
		
		searchPanel.add(Box.createHorizontalStrut(10));
		searchPanel.add(addBtn);
		
		searchPanel.validate();
	}
	
	class BtnListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
			if(((String)modeBox.getSelectedItem()).equals("按车辆编号查询")){
				if(e.getSource()==searchBtn){
					String id = searchTextField.getText();
					vehicleVOs = new ArrayList<VehicleVO>();
					try {
						if(id.equals("")) vehicleVOs = vehiclebl.show();
						else vehicleVOs = vehiclebl.find(id);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					list.init();
					for (VehicleVO  vehicleVO: vehicleVOs) {
						list.addItem(vehicleVO);
					}
					container.packHeight();
				}else if (e.getSource() == addBtn){
					VehicleAddPanel vehicleAddPanel = new VehicleAddPanel(vehiclebl);
					ELSPanel parent = (ELSPanel) getParent();
					parent.add(vehicleAddPanel,"add");
					parent.cl.show(parent, "add");
				}
				
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
				case "按车辆编号查询":
					searchTextField.setVisible(true);
					break;
				default:
					searchTextField.setVisible(false);
					break;
				}
			}
		}
		
	}
}
	
