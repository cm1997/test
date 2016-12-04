package org.cross.elsclient.ui.businesshallclerkui.trans;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

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
import org.cross.elsclient.vo.Receipt_TransVO;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.util.City;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.NumberType;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;
import org.cross.elscommon.util.TimeUtil;


public class TransAddPanel extends ELSInfoPanel {
	Receipt_TransVO vo;
	ReceiptBLService bl;
	GoodsBLService goodsbl;
	UserVO user;
	String number;

	public TransAddPanel(ReceiptBLService receiptbl, UserVO user,
			GoodsBLService goodsbl) {
		this.bl = receiptbl;
		this.user = user;
		this.goodsbl = goodsbl;
		init();
	}

	@Override
	public void init() {
		super.init();
		titlePanel.remove(titlePanel.backBtn);
		String it1[] = { "南京", "北京", "上海", "广州" };
		// String it2[] = { "营业厅", "中转中心" };
		// String it3[] = ConstantValue.getUnusedVehicle();
		// String it4[] = ConstantValue.getUnusedDriver();
		// String it5[] = ConstantValue.getUnusedObserver();

		setTitle("新增装车单");
		number = ConstantVal.numberbl.getPostNumber(NumberType.RECEIPT);
		/* 0 */addEditableItem("装车单编号", number, false, "number");
//		addEditableItem("快件单编号", "", true, InfoType.NAME, "goodsnum");
		addChangeItem("快件单编号", "", true, InfoType.NAME, "goodsnum");
		addEditableItem("出发地", user.orgNameID, false, "startplace");
		addComboxItem("到达城市", it1, true, "arricity");
		addEditableItem("到达机构", "", true, InfoType.NAME, "arriorg");
		/* 5 */addDateItem("装车时间", false, "time");
		addEditableItem("运输编号", "", true, InfoType.NAME, "transnum");
		addEditableItem("车辆编号", "", true, InfoType.NAME, "vehnum");
		addEditableItem("押运员", "", true, InfoType.NAME, "driver");
		addEditableItem("监装员", "", true, InfoType.NAME, "observer");
		addEditableItem("运费($)", "", true, InfoType.NUM, "cost");
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
			String startplace = findItem("startplace").toString();
			String arricity = findItem("arricity").toString();
			String arriorg = findItem("arriorg").toString();
			String time = TimeUtil.getCurrentTime();
			String transnum = findItem("transnum").toString();
			String vehnum = findItem("vehnum").toString();
			String driver = findItem("driver").toString();
			String observer = findItem("observer").toString();
			String cost = findItem("cost").toString();
			ArrayList<String> goods = new ArrayList<String>();
//			String[] temp = goodsnum.split(";");
			for (int i = 0; i < extraLabels.size(); i++) {
				goods.add(extraLabels.get(i).toString());
			}
			vo = new Receipt_TransVO(cnumber, time, goods, Double.valueOf(cost), transnum,
					vehnum, startplace,
					arriorg, driver,
					observer, user.number);
			// System.out.println(goods.size());
			for (int i = 0; i < goods.size(); i++) {
				// System.out.println(goods.get(i));
				GoodsVO goodsvo = goodsbl.searchGoods(goods.get(i));
				HistoryVO historyVO = new HistoryVO(time, UIConstant.CURRENT_ORG.city,
						UIConstant.CURRENT_ORG.type, false);
				System.out.println(goodsvo);
				goodsvo.history.add(historyVO);
				goodsvo.placeCity = UIConstant.CURRENT_ORG.city;
				goodsvo.placeOrg = UIConstant.CURRENT_ORG.type;
				goodsvo.transNum = cnumber;
				goodsbl.updateGoods(goodsvo);
			}
			if (bl.add(vo) == ResultMessage.SUCCESS) {
				LogUtil.addLog("新增转运单");
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),
						"添加成功");
				ELSFunctionPanel parent = GetPanelUtil.getFunctionPanel(this);
				ConstantVal.numberbl.addone(NumberType.RECEIPT, number);
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
