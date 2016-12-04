package org.cross.elsclient.ui.businesshallclerkui;

import java.rmi.RemoteException;

import org.cross.elsclient.blimpl.blfactoryimpl.BLFactoryImpl;
import org.cross.elsclient.blimpl.organizationblimpl.OrganizationBLImpl;
import org.cross.elsclient.blservice.blfactoryservice.BLFactoryService;
import org.cross.elsclient.blservice.goodsblservice.GoodsBLService;
import org.cross.elsclient.blservice.goodsblservice.GoodsBLService_Stub;
import org.cross.elsclient.blservice.organizationblservice.OrganizationBLService;
import org.cross.elsclient.blservice.personnelblservice.PersonnelBLService;
import org.cross.elsclient.blservice.personnelblservice.PersonnelBLService_Stub;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService_Stub;
import org.cross.elsclient.blservice.receiptblservice.Receipt_Stub;
import org.cross.elsclient.blservice.vehicleblservice.VehicleBLService;
import org.cross.elsclient.blservice.vehicleblservice.VehicleBLService_Stub;
import org.cross.elsclient.blservice.vehicleblservice.Vehicle_stub;
import org.cross.elsclient.ui.businesshallclerkui.arri.ArriAddPanel;
import org.cross.elsclient.ui.businesshallclerkui.deliver.DeliverAddPanel;
import org.cross.elsclient.ui.businesshallclerkui.driver.DriverManagePanel;
import org.cross.elsclient.ui.businesshallclerkui.money.MoneyAddPanel;
import org.cross.elsclient.ui.businesshallclerkui.trans.TransAddPanel;
import org.cross.elsclient.ui.businesshallclerkui.vehicle.VehicleManagePanel;
import org.cross.elsclient.ui.component.ELSFunctionPanel;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.vo.UserVO;

public class BusinessFunctionPanel extends ELSFunctionPanel{
	public ReceiptBLService receiptbl;
	public VehicleBLService vehiclebl;
	public GoodsBLService goodsbl;
	public PersonnelBLService personnelbl;
	public OrganizationBLService organizationbl;
	BLFactoryService blFactoryService;
	UserVO user;
	
	public BusinessFunctionPanel() {
		super();
		
		try {
			this.blFactoryService = new BLFactoryImpl();
			receiptbl = blFactoryService.receiptBLService();
			vehiclebl = blFactoryService.vehicleBLService();
			goodsbl = blFactoryService.goodsBLService();
			personnelbl = blFactoryService.personnelBLService();
			organizationbl = blFactoryService.organizationBLService();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user = UIConstant.CURRENT_USER;
		init();
	}
	@Override
	public void init() {
		super.init();
		addFunctionBtn("到达单", "arrive");
		addFunctionBtn("装车单", "trans");
		addFunctionBtn("收款单", "moneyin");
		addFunctionBtn("派件单", "send");
		addFunctionBtn("车辆管理", "vehicle");
		addFunctionBtn("司机管理", "driver");
		addFunctionBtn("单据管理", "receipts");
		
		addFunctionPanel(new ArriAddPanel(receiptbl, user, goodsbl), "add","arrive");
		addFunctionPanel(new TransAddPanel(receiptbl, user, goodsbl), "add","trans");
		addFunctionPanel(new MoneyAddPanel(receiptbl, user), "add","moneyin");
		addFunctionPanel(new DeliverAddPanel(receiptbl, user, goodsbl), "add","send");
		addFunctionPanel(new VehicleManagePanel(vehiclebl), "manage","vehicle");
		addFunctionPanel(new DriverManagePanel(personnelbl, user), "manage","driver");
		
		addFunctionPanel(new ReceiptManagePanel(receiptbl), "manage", "receipts");
	}
}
