package org.cross.elsclient.ui.courierui;

import java.rmi.RemoteException;

import org.cross.elsclient.blimpl.blfactoryimpl.BLFactoryImpl;
import org.cross.elsclient.blimpl.goodsblimpl.GoodsBLImpl;
import org.cross.elsclient.blservice.blfactoryservice.BLFactoryService;
import org.cross.elsclient.blservice.goodsblservice.GoodsBLService;
import org.cross.elsclient.blservice.goodsblservice.GoodsBLService_Driver;
import org.cross.elsclient.blservice.goodsblservice.GoodsBLService_Stub;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService_Stub;
import org.cross.elsclient.ui.adminui.UserManagePanel;
import org.cross.elsclient.ui.businesshallclerkui.ReceiptManagePanel;
import org.cross.elsclient.ui.component.ELSFunctionPanel;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.courierui.goodscheck.GoodsCheckPanel;
import org.cross.elsclient.ui.courierui.receive.ExpressReceivePanel;
import org.cross.elsclient.ui.courierui.send.SendUpdatePanel;

public class CourierFunctionPanel extends ELSFunctionPanel{
	public ReceiptBLService receiptbl;
	public GoodsBLService goodsbl;
	
	public CourierFunctionPanel() {
		super();
//		receiptbl = new ReceiptBLService_Stub();
//		goodsbl = new GoodsBLService_Stub();
		BLFactoryService blFactory;
		try {
			blFactory = new BLFactoryImpl();
			receiptbl = blFactory.receiptBLService();
			goodsbl = blFactory.goodsBLService();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		init();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		addFunctionBtn("揽收快递", "receive");
		addFunctionBtn("派送快递", "expressSend");
		addFunctionBtn("查看订单", "goodsCheck");
		addFunctionBtn("查看单据", "receipts");
		
		addFunctionPanel(new ExpressReceivePanel(receiptbl,goodsbl), "manage","receive");
		addFunctionPanel(new SendUpdatePanel(receiptbl,goodsbl), "manage","expressSend");
		addFunctionPanel(new GoodsCheckPanel(goodsbl), "manage","goodsCheck");
		addFunctionPanel(new ReceiptManagePanel(receiptbl), "manage", "receipts");
	}
	
}
