package org.cross.elsclient.ui.counterui.initial;

import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

import org.cross.elsclient.blimpl.initialblimpl.InitialBLImpl;
import org.cross.elsclient.blservice.accountblservice.AccountBLService;
import org.cross.elsclient.blservice.initialblservice.InitialBLService;
import org.cross.elsclient.blservice.organizationblservice.OrganizationBLService;
import org.cross.elsclient.blservice.personnelblservice.PersonnelBLService;
import org.cross.elsclient.blservice.stockblservice.StockBLService;
import org.cross.elsclient.blservice.vehicleblservice.VehicleBLService;
import org.cross.elsclient.ui.component.ELSManagePanel;
import org.cross.elsclient.ui.component.ELSManageTable;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.vo.InitialVO;

public class InitialManagePanel extends ELSManagePanel{
	InitialBLService initialbl;
	StockBLService stockbl;
	OrganizationBLService organbl;
	PersonnelBLService personnelbl;
	AccountBLService accountbl;
	VehicleBLService vehiclebl;
	InitialVO currentVO;
	ArrayList<InitialManageTable> lists;
	InitialInfoTable infoList;
	InitialOrganizationTable organList;
	InitialAccountTable accountList;
	InitialPersonnelTable personnelList;
	InitialStockTable stockList;
	InitialVehicleTable veList;
	
	public InitialManagePanel(InitialBLService initialbl,
			StockBLService stockbl, OrganizationBLService organbl,
			PersonnelBLService personnelbl, AccountBLService accountbl,
			VehicleBLService vehiclebl) {
		super();
		this.initialbl = initialbl;
		this.stockbl = stockbl;
		this.organbl = organbl;
		this.personnelbl = personnelbl;
		this.accountbl = accountbl;
		this.vehiclebl = vehiclebl;
	}
	
	@Override
	public void setContentPanel() {
		super.setContentPanel();
		String[] infoName = {"账本编号","建账人","建账时间"};
		int[] infoWidth = {200,200,200}; 
		infoList = new InitialInfoTable(infoName, infoWidth,currentVO);
		infoList.refresh();
//		infoList.addItemLabel(new String[]{CurrentVO.id,CurrentVO.initialName,CurrentVO.time});
		infoList.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT, searchPanel.getHeight()+searchPanel.getLocation().y+10);
		infoList.addBtn.setVisible(false);
		
		String[] organName = {"机构编号","地区","类型"};
		int[] organWidth = {200,100,200}; 
		organList = new InitialOrganizationTable(organName, organWidth,currentVO.organizations);
		organList.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT, infoList.getHeight()+infoList.getLocation().y+10);
		
		String[] personName = {"人员编号","姓名","职位","所属机构"};
		int[] personWidth = {200,100,200,200};
		personnelList = new InitialPersonnelTable(personName,personWidth, currentVO.personnels);
		personnelList.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT, organList.getHeight()+organList.getLocation().y+10);
		
		String[] vehicleName = {"车辆编号","车辆号","服役时间"};
		int[] vehicleWidth = {200,150,200};
		veList = new InitialVehicleTable(vehicleName,vehicleWidth, currentVO.vehicles);
		veList.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT, personnelList.getHeight()+personnelList.getLocation().y+10);
		
		String[] accountName = {"账户名称","账户卡号","账户余额"};
		int[] accountWidth = {200,300,150};
		accountList = new InitialAccountTable(accountName,accountWidth, currentVO.accounts);
		accountList.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT, veList.getHeight()+veList.getLocation().y+10);
		
		//库存表待定
		String[] stockName = {"仓库编号","库存空间"};
		int[] stockWidth = {200,100};
		stockList = new InitialStockTable(stockName,stockWidth, currentVO.stocks);
		stockList.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT, accountList.getHeight()+accountList.getLocation().y+10);
		
		lists = new ArrayList<>();
		
		lists.add(infoList);
		lists.add(organList);
		lists.add(personnelList);
		lists.add(veList);
		lists.add(accountList);
		lists.add(stockList);
		
		for (int i = 0;i<lists.size();i++){
			lists.get(i).isAddBtnVisible = false;
			lists.get(i).addBtn.setVisible(false);
			container.add(lists.get(i));
		}
		container.packHeight();
	}
	
	public void refresh(){
		infoList.vo = currentVO;
		organList.vos = currentVO.organizations;
		personnelList.vos = currentVO.personnels;
		accountList.vos = currentVO.accounts;
		veList.vos = currentVO.vehicles;
		stockList.vos = currentVO.stocks;
		
		for (InitialManageTable initialManageTable : lists) {
			initialManageTable.refresh();
		}
		
		organList.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT, infoList.getHeight()+infoList.getLocation().y+10);
		personnelList.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT, organList.getHeight()+organList.getLocation().y+10);
		veList.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT, personnelList.getHeight()+personnelList.getLocation().y+10);
		accountList.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT, veList.getHeight()+veList.getLocation().y+10);
		stockList.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT, accountList.getHeight()+accountList.getLocation().y+10);
		
		container.packHeight();
	}
}
