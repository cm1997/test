package org.cross.elsclient.ui.businesshallclerkui.arri;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.goodsblservice.GoodsBLService;
import org.cross.elsclient.blservice.organizationblservice.OrganizationBLService;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.ui.businesshallclerkui.ReceiptManagePanel;
import org.cross.elsclient.ui.component.ELSComfirmDialog;
import org.cross.elsclient.ui.component.ELSFunctionPanel;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.ConstantValue;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.LogUtil;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.GoodsVO;
import org.cross.elsclient.vo.HistoryVO;
import org.cross.elsclient.vo.Receipt_ArriveVO;
import org.cross.elsclient.vo.Receipt_TransVO;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.util.City;
import org.cross.elscommon.util.GoodsState;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.NumberType;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;
import org.cross.elscommon.util.TimeUtil;

public class ArriAddPanel extends ELSInfoPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Receipt_ArriveVO arrivo;
	ReceiptBLService receiptbl;
	GoodsBLService goodsbl;
	UserVO user;
	String number;

	public ArriAddPanel(ReceiptBLService receiptbl, UserVO user,
			GoodsBLService goodsbl) {
		this.receiptbl = receiptbl;
		this.user = user;
		this.goodsbl = goodsbl;
		init();
	}

	@Override
	public void init() {
		super.init();

		titlePanel.remove(titlePanel.backBtn);

		String it1[] = { "南京", "北京", "上海", "广州" };

		number = ConstantVal.numberbl.getPostNumber(NumberType.RECEIPT);
		setTitle("新增到达单");
		/* 0 */addEditableItem("到达单编号", number, false, "number");
		/* 1 */addEditableItem("装车/中转单号", "", true, InfoType.RECEIPT, "transnum");
		/* 2 */addEditableItem("出发机构", "", true, InfoType.ORGANIZATION, "startorg");
		/* 3 */addDateItem("出发时间", true, "starttime");
		/* 4 */addEditableItem("到达机构", user.orgNameID, false, "arriorg");
		/* 5 */addDateItem("到达时间", false, "arritime");
		/* 6 */addConfirmAndCancelBtn();
		confirmBtn.setText("确认添加");
		cancelBtn.setText("查看单据");
		container.packHeight();
	}

	@Override
	protected void confirm() throws RemoteException {
		if (isAllLegal()) {
			String cnumber = findItem("number").toString();
			String transnum = findItem("transnum").toString();
			String startorg = findItem("startorg").toString();
			String starttime = findItem("starttime").toString();
			String carriorg = findItem("arriorg").toString();
			String arritime = TimeUtil.getCurrentTime();
			
			arrivo = new Receipt_ArriveVO(cnumber,
					arritime, startorg,
					transnum, starttime,
					carriorg , user.number);
			Receipt_TransVO transvo = (Receipt_TransVO) receiptbl
					.findByID(transnum);

			for (int i = 0; i < transvo.goodsID.size(); i++) {
				GoodsVO goods = goodsbl.searchGoods(transvo.goodsID.get(i));
				// 更新goods
				HistoryVO historyVO = new HistoryVO(arritime, UIConstant.CURRENT_ORG.city,
						UIConstant.CURRENT_ORG.type, true);
				goods.history.add(historyVO);
				goods.placeCity = UIConstant.CURRENT_ORG.city;
				goods.placeOrg = UIConstant.CURRENT_ORG.type;
				goods.arriNum = cnumber;
				goodsbl.updateGoods(goods);
			}
			if (receiptbl.add(arrivo) == ResultMessage.SUCCESS) {
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),
						"添加成功");
				ConstantVal.numberbl.addone(NumberType.RECEIPT, number);
				LogUtil.addLog("新增到达单");
				ELSFunctionPanel parent = GetPanelUtil.getFunctionPanel(this);
				// parent.contentPanel.cl.show(parent.contentPanel, "receipts");
				parent.setChosenFunction("receipts");
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
		}
	}

}
