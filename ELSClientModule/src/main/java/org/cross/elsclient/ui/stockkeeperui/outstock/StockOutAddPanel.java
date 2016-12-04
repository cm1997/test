package org.cross.elsclient.ui.stockkeeperui.outstock;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blservice.goodsblservice.GoodsBLService;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.blservice.stockblservice.StockBLService;
import org.cross.elsclient.ui.businesshallclerkui.ReceiptManagePanel;
import org.cross.elsclient.ui.component.ELSComfirmDialog;
import org.cross.elsclient.ui.component.ELSFunctionPanel;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.stockkeeperui.StockFunctionPanel;
import org.cross.elsclient.ui.util.ConstantValue;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.LogUtil;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.GoodsVO;
import org.cross.elsclient.vo.Receipt_StockOutVO;
import org.cross.elsclient.vo.StockVO;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.NumberType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.TimeUtil;

public class StockOutAddPanel extends ELSInfoPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Receipt_StockOutVO stockoutvo;
	StockBLService stockbl;
	ReceiptBLService receiptbl;
	GoodsBLService goodsbl;
	UserVO user;
	StockVO stockvo;
	String number;

	public StockOutAddPanel(StockBLService stockbl, ReceiptBLService receiptbl,
			UserVO user, StockVO stockvo, GoodsBLService goodsbl) {
		this.stockbl = stockbl;
		this.receiptbl = receiptbl;
		this.user = user;
		this.stockvo = stockvo;
		this.goodsbl = goodsbl;
		init();
	}

	@Override
	public void init() {
		super.init();
		titlePanel.remove(titlePanel.backBtn);
		String[] it1 = { "汽车", "飞机", "火车" };
		setTitle("新增出库单");
		number = ConstantVal.numberbl.getPostNumber(NumberType.RECEIPT);
		/* 0 */addEditableItem("出库单编号", number, false, "number");
		addEditableItem("快件单编号", "", true, InfoType.RECEIPT, "goodsnum");
		addDateItem("出库时间", false, "time");
		addEditableItem("目的地", "", true, InfoType.NAME, "des");
		addEditableItem("中转/装车单号", "", true, InfoType.RECEIPT, "transnum");
		addComboxItem("运输方式", it1, true, "vehtype");
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认添加");
		cancelBtn.setText("查看单据");
		container.packHeight();
	}

	@Override
	protected void confirm() throws RemoteException {
		if (isAllLegal()) {
			String cnumber = findItem("number").toString();
			String goodsnum = findItem("goodsnum").toString();
			String time = TimeUtil.getCurrentTime();
			String des = findItem("des").toString();
			String transnum = findItem("transnum").toString();
			String vehtype = findItem("vehtype").toString();
			stockoutvo = new Receipt_StockOutVO(cnumber,
					time, goodsnum,
					des, vehtype,
					transnum, user.number, user.orgNameID);
			stockbl.outStock(itemLabels.get(1).toString(), stockvo.number,
					itemLabels.get(2).toString());
			GoodsVO goodsvo = goodsbl.searchGoods(goodsnum);
			goodsvo.stockNum = "null";
			goodsvo.stockAreaNum = "null";
			goodsbl.updateGoods(goodsvo);
			if (receiptbl.add(stockoutvo) == ResultMessage.SUCCESS) {
				stockvo = stockbl.findStockByOrg(user.orgNameID);
				if(stockbl.getNeedChange(stockvo.number).isEmpty()){
					StockFunctionPanel parent = (StockFunctionPanel)GetPanelUtil.getFunctionPanel(this);
					parent.alertBtn.setAlert(false);
				}
				stockvo = stockbl.findStock(stockvo.number);
				LogUtil.addLog("新增出库单");
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),
						"添加成功");
				ELSFunctionPanel parent = GetPanelUtil.getFunctionPanel(this);
				ConstantVal.numberbl.addone(NumberType.RECEIPT, number);
				// parent.contentPanel.cl.show(parent.contentPanel, "receipts");
				parent.setChosenFunction("receipts");
				init();
			} else {
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),
						"添加失败");
			}
		}
	}

	@Override
	protected void cancel() {
		if (ELSComfirmDialog.showConfirmDlg(GetPanelUtil.getFunctionPanel(this),
				"取消新增", "确认放弃新增单据？")) {
			ELSFunctionPanel parent = GetPanelUtil.getFunctionPanel(this);
			// parent.contentPanel.cl.show(parent.contentPanel, "receipts");
			parent.setChosenFunction("receipts");
			init();
		}
	}

}
