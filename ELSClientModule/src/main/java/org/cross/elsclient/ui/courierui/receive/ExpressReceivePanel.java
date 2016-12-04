package org.cross.elsclient.ui.courierui.receive;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.rmi.RemoteException;
import java.util.Calendar;

import javax.rmi.CORBA.Tie;

import org.cross.elsclient.blservice.goodsblservice.GoodsBLService;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.ui.component.ELSComfirmDialog;
import org.cross.elsclient.ui.component.ELSFunctionPanel;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.LogUtil;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.util.CalcuteUtil;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.GoodsVO;
import org.cross.elsclient.vo.HistoryVO;
import org.cross.elsclient.vo.Receipt_OrderVO;
import org.cross.elscommon.util.City;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.NumberType;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StockType;
import org.cross.elscommon.util.StringToType;
import org.cross.elscommon.util.TimeUtil;

public class ExpressReceivePanel extends ELSInfoPanel{
	Receipt_OrderVO orderVO;
	GoodsVO goodsVO;
	ReceiptBLService receiptbl;
	GoodsBLService goodsbl;
	String number;
	
	public ExpressReceivePanel(ReceiptBLService receiptbl,GoodsBLService goodsbl) {
		this.receiptbl = receiptbl;
		this.goodsbl = goodsbl;
		init();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		String packType[] = {"纸箱(5元)","木箱(10元)","快递袋(1元)"};
		
		setTitle("创建快件单");
		number = ConstantVal.numberbl.getPostNumber(NumberType.RECEIPT);
		addEditableItem("快件单编号",number , false,"id");
		addEditableItem("寄件人姓名", "", true,InfoType.NAME,"sendName");
		addEditableItem("寄件人地址", "", true,InfoType.NAME,"sendAd");
		addEditableItem("寄件人单位", "", true,InfoType.NAME,"sendUnit");
		addEditableItem("寄件人电话", "", true,InfoType.TELEPHONE,"sendPhone");
		//5
		addEditableItem("寄件人手机", "", true,InfoType.CELLPHONE,"sendCell");
		addEditableItem("收件人姓名", "", true,InfoType.NAME,"reName");
		addEditableItem("收件人地址", "", true,InfoType.NAME,"reAd");
		addEditableItem("收件人单位", "", true,InfoType.NAME,"reUnit");
		addEditableItem("收件人电话", "", true,InfoType.TELEPHONE,"rePhone");
		//10
		addEditableItem("收件人手机", "", true,InfoType.CELLPHONE,"reCell");
		addComboxItem("出发城市", City.toStrings(), true,"from");
		addComboxItem("到达城市", City.toStrings(), true,"to");
		addComboxItem("快递类型", StockType.toGoodsStrings(), true,"type");
		addEditableItem("货物件数", "1", true,InfoType.PURENUM,"num");
		//15
		addAutoItem("货物重量(kg)", "", true,InfoType.NUM,"weight");
		addAutoItem("体积(长/cm)", "", true, InfoType.NUM, "length");
		addAutoItem("体积(宽/cm)", "", true, InfoType.NUM, "width");
		addAutoItem("体积(高/cm)", "", true, InfoType.NUM, "height");
		addComboxItem("包装类型",packType, true,"pack");
		addEditableItem("价格", "", false,"price");
		addEditableItem("预计到达时间", "", false,"time");
		addEditableItem("建单人编号", UIConstant.CURRENT_USER.number, false,InfoType.ID,"per");
		//20
		addEditableItem("所属机构", UIConstant.CURRENT_USER.orgNameID, false,InfoType.ID,"organ");
		
		findItem("weight").inputLabel.addFocusListener(new PriceListener());
		findItem("length").inputLabel.addFocusListener(new PriceListener());
		findItem("width").inputLabel.addFocusListener(new PriceListener());
		findItem("height").inputLabel.addFocusListener(new PriceListener());
		findItem("from").comboBox.addItemListener(new PriceItemListener());
		findItem("to").comboBox.addItemListener(new PriceItemListener());
		findItem("type").comboBox.addItemListener(new PriceItemListener());
		findItem("pack").comboBox.addItemListener(new PriceItemListener());
		
		titlePanel.remove(titlePanel.backBtn);
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认创建");
		cancelBtn.setText("查看单据");
		container.packHeight();
	}
	
	@Override
	protected void confirm() throws RemoteException {
		if(isAllLegal()){
			String number = findItem("id").toString();
			String senderName = findItem("sendName").toString();
			String senderAdd = findItem("sendAd").toString();
			String senderOrg = findItem("sendUnit").toString();
			String senderPhone = findItem("sendPhone").toString();
			String senderMobile = findItem("sendCell").toString();
			String receiverName = findItem("reName").toString();
			String receiverAdd = findItem("reAd").toString();
			String receiverOrg = findItem("reUnit").toString();
			String receiverPhone = findItem("rePhone").toString();
			String receiverMobile = findItem("reCell").toString();
			City startCity = StringToType.toCity(findItem("from").toString());
			City endCity = StringToType.toCity(findItem("to").toString());
			StockType goodsType = StringToType.toGoodsType(findItem("type").toString());
			int volume = Integer.valueOf(findItem("num").toString());
			int weight = Integer.valueOf(findItem("weight").toString());
			int cost = Integer.valueOf(findItem("price").toString());
			String perNum = findItem("per").toString();
			String orgNum = findItem("organ").toString();
			
			
			goodsVO = new GoodsVO(number, goodsType,startCity, OrganizationType.BUSINESSHALL, weight, volume);
			orderVO = new Receipt_OrderVO(number, TimeUtil.getCurrentTime(), cost, TimeUtil.getCurrentTime(), null, senderName, senderMobile, senderPhone, senderAdd, senderOrg, receiverName, receiverOrg, receiverAdd, receiverPhone, receiverMobile, perNum, orgNum);
			goodsVO.history.add(new HistoryVO(TimeUtil.getCurrentTime(), startCity, OrganizationType.BUSINESSHALL, false));
			if(receiptbl.add(orderVO)==ResultMessage.SUCCESS&&goodsbl.addGoods(goodsVO)==ResultMessage.SUCCESS&&goodsbl.updateGoods(goodsVO)==ResultMessage.SUCCESS){
				LogUtil.addLog("揽收快件");
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"添加成功");
				ConstantVal.numberbl.addone(NumberType.RECEIPT, number);
				init();
			}else{
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"添加失败");
			}
		}
	}
	
	@Override
	protected void cancel() {
		if(ELSComfirmDialog.showConfirmDlg(GetPanelUtil.getFunctionPanel(this), "取消新增", "确认退出新增界面？")){
			ELSFunctionPanel parent = GetPanelUtil.getFunctionPanel(this);
			this.init();
			parent.setChosenFunction("receipts");
		}
	}
	
	public void price() {
		if(findItem("width").checkFormat()&&findItem("height").checkFormat()&&findItem("length").checkFormat()&&findItem("weight").checkFormat()){
			double length = Double.valueOf(findItem("length").toString());
			double width = Double.valueOf(findItem("width").toString());
			double height = Double.valueOf(findItem("height").toString());
			double weight = Double.valueOf(findItem("weight").toString());
			if(weight<(length*width*height/5000)){
				weight = length*width*height/5000;
			}
			StockType goodsType = StringToType.toGoodsType(findItem("type").toString());
			City startCity = StringToType.toCity(findItem("from").toString());
			City endCity = StringToType.toCity(findItem("to").toString());
			String packCost = findItem("pack").toString();
			int result = (int)CalcuteUtil.calcutePrice(goodsType, ConstantVal.CONSTANT.getDistance(startCity, endCity), weight, packCost);
			findItem("price").inputLabel.setText(result+"");
		}else if(findItem("weight").checkFormat()){
			StockType goodsType = StringToType.toGoodsType(findItem("type").toString());
			City startCity = StringToType.toCity(findItem("from").toString());
			City endCity = StringToType.toCity(findItem("to").toString());
			double weight = Double.valueOf(findItem("weight").toString());
			String packCost = findItem("pack").toString();
			int result = (int)CalcuteUtil.calcutePrice(goodsType, ConstantVal.CONSTANT.getDistance(startCity, endCity), weight, packCost);
			findItem("price").inputLabel.setText(result+"");
		}
	}
	public void time(){
		City startCity = StringToType.toCity(findItem("from").toString());
		City endCity = StringToType.toCity(findItem("to").toString());
		int result = (int)(ConstantVal.CONSTANT.getDistance(startCity, endCity)*ConstantVal.CONSTANT.timeBykilo);
		findItem("time").inputLabel.setText(TimeUtil.getAfterTime(result));
	}
	
	class PriceListener implements FocusListener{

		@Override
		public void focusGained(FocusEvent e) {}

		@Override
		public void focusLost(FocusEvent e) {
			price();
		}
	}
	class PriceItemListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange()==e.SELECTED){
				price();
			}
			if(e.getSource()==itemLabels.get(11).comboBox||e.getSource()==itemLabels.get(12).comboBox){
				time();
			}
		}
		
	}
	
}
