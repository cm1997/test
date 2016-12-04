package org.cross.elsclient.ui.businesshallclerkui.deliver;

import java.awt.Window.Type;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.receiptblimpl.Receipt_Order;
import org.cross.elsclient.blimpl.userblimpl.User;
import org.cross.elsclient.blservice.goodsblservice.GoodsBLService;
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
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elsclient.vo.Receipt_ArriveVO;
import org.cross.elsclient.vo.Receipt_DeliverVO;
import org.cross.elsclient.vo.Receipt_OrderVO;
import org.cross.elsclient.vo.Receipt_TransVO;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.util.City;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.NumberType;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.TimeUtil;

public class DeliverAddPanel extends ELSInfoPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Receipt_DeliverVO delvo;
	ReceiptBLService receiptbl;
	GoodsBLService goodsbl;
	UserVO user;
	String number;

	public DeliverAddPanel(ReceiptBLService receiptbl, UserVO user,
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
		setTitle("新增派件单");
		number = ConstantVal.numberbl.getPostNumber(NumberType.RECEIPT);
		/* 0 */addEditableItem("派件单编号", number, false, "number");
		addDateItem("派件时间", false, "time");
		addEditableItem("快件单编号", "", true, InfoType.RECEIPT, "goodsnum");
		addEditableItem("快递员工号", "", true, InfoType.PERSONNEL, "pernum");
		addEditableItem("快递员姓名", "", true, InfoType.NAME, "name");
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认添加");
		cancelBtn.setText("查看单据");
		container.packHeight();
	}

	@Override
	protected void confirm() throws RemoteException {
		if (isAllLegal()) {
			String cnumber = findItem("number").toString();
			String ctime = TimeUtil.getCurrentTime();;
			String goodsnum = findItem("goodsnum").toString();
			String pernum = findItem("pernum").toString();
			String name = findItem("name").toString();
			delvo = new Receipt_DeliverVO(cnumber,
					ctime, goodsnum,
					name, pernum,
					user.number, user.orgNameID);
			GoodsVO goods = goodsbl.searchGoods(goodsnum);
			// 要获得当前用户的信息
			HistoryVO historyVO = new HistoryVO(ctime,
					UIConstant.CURRENT_ORG.city, UIConstant.CURRENT_ORG.type,
					false);
			goods.history.add(historyVO);
			goods.placeCity = UIConstant.CURRENT_ORG.city;
			goods.placeOrg = UIConstant.CURRENT_ORG.type;
			goods.delNum = cnumber;
			goodsbl.updateGoods(goods);
			if (receiptbl.add(delvo) == ResultMessage.SUCCESS) {
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),
						"添加成功");
				ConstantVal.numberbl.addone(NumberType.RECEIPT, number);
				LogUtil.addLog("新增派件单");
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
