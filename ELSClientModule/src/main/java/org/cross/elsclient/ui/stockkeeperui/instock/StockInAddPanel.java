package org.cross.elsclient.ui.stockkeeperui.instock;

import java.rmi.RemoteException;

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
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.GoodsVO;
import org.cross.elsclient.vo.HistoryVO;
import org.cross.elsclient.vo.Receipt_StockInVO;
import org.cross.elsclient.vo.StockVO;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.NumberType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.TimeUtil;

public class StockInAddPanel extends ELSInfoPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Receipt_StockInVO stockinvo;
	StockBLService stockbl;
	ReceiptBLService receiptbl;
	GoodsBLService goodsbl;
	UserVO user;
	StockVO stockvo;
	String number;

	public StockInAddPanel(StockBLService stockbl, ReceiptBLService receiptbl,
			UserVO user, StockVO stockvo, GoodsBLService goodsbl) {
		this.stockbl = stockbl;
		this.receiptbl = receiptbl;
		this.stockvo = stockvo;
		this.goodsbl = goodsbl;
		this.user = user;
		init();
	}

	@Override
	public void init() {
		super.init();
		titlePanel.remove(titlePanel.backBtn);
		setTitle("新增入库单");
		number = ConstantVal.numberbl.getPostNumber(NumberType.RECEIPT);
		/* 0 */addEditableItem("入库单编号", number, false, "number");
		addEditableItem("快件单编号", "", true, InfoType.RECEIPT, "goodsnum");
		addDateItem("入库时间", false, "time");
		addEditableItem("目的地", "", true, InfoType.NAME, "des");
		addEditableItem("仓库区号", "", true, InfoType.STOCKAREA, "areaid");
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
			String areaid = findItem("areaid").toString();
			
			stockinvo = new Receipt_StockInVO(cnumber,
					time, goodsnum,
					des, areaid,
					user.number, user.orgNameID);
			stockbl.intoStock(goodsnum, stockvo.number,
					time, itemLabels.get(4).toString());
			GoodsVO goodsvo = goodsbl.searchGoods(goodsnum);
//			HistoryVO newhistory = new HistoryVO(time,
//					UIConstant.CURRENT_ORG.city, UIConstant.CURRENT_ORG.type,
//					true);
//			goodsvo.history.add(newhistory);
			goodsvo.stockAreaNum = itemLabels.get(4).toString();
			goodsvo.stockNum = stockvo.number;
			goodsbl.updateGoods(goodsvo);
			if (receiptbl.add(stockinvo) == ResultMessage.SUCCESS) {
				try {
					stockvo = stockbl.findStockByOrg(user.orgNameID);
					if(!stockbl.getNeedChange(stockvo.number).isEmpty()){
						StockFunctionPanel parent = (StockFunctionPanel)GetPanelUtil.getFunctionPanel(this);
						parent.alertBtn.setAlert(true);
						if(ELSComfirmDialog.showConfirmDlg(parent, "库存报警", "是否跳转至库存调整界面")){
							parent.setChosenFunction("stockadjust");
						}else{
							parent.setChosenFunction("receipts");
							init();
						}
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				LogUtil.addLog("新增入库单");
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),
						"添加成功");
				ConstantVal.numberbl.addone(NumberType.RECEIPT, number);
				
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
