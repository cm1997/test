package org.cross.elsclient.ui.transitcenterclerkui;

import java.rmi.RemoteException;

import org.cross.elsclient.blimpl.blfactoryimpl.BLFactoryImpl;
import org.cross.elsclient.blservice.blfactoryservice.BLFactoryService;
import org.cross.elsclient.blservice.goodsblservice.GoodsBLService;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService_Stub;
import org.cross.elsclient.blservice.stockblservice.StockBLService;
import org.cross.elsclient.network.Datafactory;
import org.cross.elsclient.ui.businesshallclerkui.ReceiptManagePanel;
import org.cross.elsclient.ui.businesshallclerkui.arri.ArriAddPanel;
import org.cross.elsclient.ui.businesshallclerkui.trans.TransAddPanel;
import org.cross.elsclient.ui.component.ELSFunctionPanel;
import org.cross.elsclient.ui.stockkeeperui.observe.StockSeeManagePanel;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.vo.StockVO;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;

public class TransmitFunctionPanel extends ELSFunctionPanel {
	public ReceiptBLService receiptbl;
	public GoodsBLService goodsbl;
	BLFactoryService blFactoryService;
	UserVO user;
	StockBLService stockbl;
	StockVO stockvo;
	
	public TransmitFunctionPanel() {
		super();
		try {
			blFactoryService = new BLFactoryImpl();
			receiptbl = blFactoryService.receiptBLService();
			goodsbl = blFactoryService.goodsBLService();
			stockbl = blFactoryService.stockBLService();
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
		try {
			stockvo = stockbl.findStockByOrg(user.orgNameID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		addFunctionBtn("接收单", "arrive");
		addFunctionBtn("装运单", "trans");
		addFunctionBtn("库存查看", "stocksee");
		addFunctionBtn("单据管理", "receipts");
		
		addFunctionPanel(new ArriAddPanel(receiptbl, user, goodsbl), "add","arrive");
		addFunctionPanel(new TransAddPanel(receiptbl, user, goodsbl), "add","trans");
		addFunctionPanel(new StockSeeManagePanel(stockbl, user, stockvo), "manage", "stocksee");
		
		addFunctionPanel(new ReceiptManagePanel(receiptbl), "manage", "receipts");
	}

}
