package org.cross.elsclient.ui.stockkeeperui;

import java.rmi.RemoteException;

import org.cross.elsclient.blimpl.blfactoryimpl.BLFactoryImpl;
import org.cross.elsclient.blservice.blfactoryservice.BLFactoryService;
import org.cross.elsclient.blservice.goodsblservice.GoodsBLService;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService_Stub;
import org.cross.elsclient.blservice.stockblservice.StockBLService;
import org.cross.elsclient.blservice.stockblservice.StockBL_stub;
import org.cross.elsclient.test.StockBLTest;
import org.cross.elsclient.ui.businesshallclerkui.ReceiptManagePanel;
import org.cross.elsclient.ui.businesshallclerkui.arri.ArriAddPanel;
import org.cross.elsclient.ui.businesshallclerkui.trans.TransAddPanel;
import org.cross.elsclient.ui.component.AlertFunctionBtn;
import org.cross.elsclient.ui.component.ELSFunctionPanel;
import org.cross.elsclient.ui.stockkeeperui.adjust.StockAdjustPanel;
import org.cross.elsclient.ui.stockkeeperui.check.StockCheckManagePanel;
import org.cross.elsclient.ui.stockkeeperui.check.StockCheckManageTable;
import org.cross.elsclient.ui.stockkeeperui.instock.StockInAddPanel;
import org.cross.elsclient.ui.stockkeeperui.observe.StockSeeManagePanel;
import org.cross.elsclient.ui.stockkeeperui.outstock.StockOutAddPanel;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.vo.StockVO;
import org.cross.elsclient.vo.UserVO;

public class StockFunctionPanel extends ELSFunctionPanel {

	BLFactoryService blFactoryService;

	public ReceiptBLService receiptbl;
	public StockBLService stockbl;
	public GoodsBLService goodsbl;
	UserVO user;
	StockVO stock;
	public AlertFunctionBtn alertBtn;

	public StockFunctionPanel() {
		super();
		try {
			blFactoryService = new BLFactoryImpl();
			receiptbl = blFactoryService.receiptBLService();
			stockbl = blFactoryService.stockBLService();
			goodsbl = blFactoryService.goodsBLService();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		init();
	}

	@Override
	public void init() {
		super.init();

		this.user = UIConstant.CURRENT_USER;
		try {
			stock = stockbl.findStockByOrg(user.orgNameID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		addFunctionBtn("入库单", "stockin");
		addFunctionBtn("出库单", "stockout");
		addFunctionBtn("库存查看", "stocksee");
		addFunctionBtn("库存盘点", "stockcheck");
		addAlertBtn("库存调整", "stockadjust");
		addFunctionBtn("单据管理", "receipts");
		alertBtn = (AlertFunctionBtn)functionBtns.get(4);
		try {
			if(!stockbl.getNeedChange(stock.number).isEmpty()){
				alertBtn.setAlert(true);
			}else{
				alertBtn.setAlert(false);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		addFunctionPanel(new StockInAddPanel(stockbl, receiptbl, user, stock, goodsbl), "add", "stockin");
		addFunctionPanel(new StockOutAddPanel(stockbl, receiptbl, user, stock, goodsbl), "add", "stockout");
		addFunctionPanel(new StockSeeManagePanel(stockbl, user, stock), "manage", "stocksee");
		addFunctionPanel(new StockCheckManagePanel(stockbl, user, stock), "manage", "stockcheck");
		addFunctionPanel(new StockAdjustPanel(stockbl, user, stock), "add", "stockadjust");

		addFunctionPanel(new ReceiptManagePanel(receiptbl), "manage", "receipts");
	}

}
