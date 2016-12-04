package org.cross.elsclient.ui.courierui.receive;

import org.cross.elsclient.blservice.goodsblservice.GoodsBLService;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.courierui.receive.ExpressReceivePanel.PriceItemListener;
import org.cross.elsclient.ui.courierui.receive.ExpressReceivePanel.PriceListener;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.GoodsVO;
import org.cross.elsclient.vo.Receipt_OrderVO;
import org.cross.elscommon.util.City;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.NumberType;
import org.cross.elscommon.util.StockType;

public class OrderInfoPanel extends ELSInfoPanel{
	Receipt_OrderVO orderVO;
//	GoodsVO goodsVO;
	
	public OrderInfoPanel(Receipt_OrderVO orderVO) {
		super();
		this.orderVO = orderVO;
		init();
//		this.goodsVO = goodsVO;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		String packType[] = {"纸箱(5元)","木箱(10元)","快递袋(1元)"};
		
		
		setTitle("快件单信息");
		addNormalItem("快件单编号",orderVO.number);
		addNormalItem("寄件人姓名", orderVO.senderName);
		addNormalItem("寄件人地址", orderVO.senderAdd);
		addNormalItem("寄件人单位", orderVO.senderOrg);
		addNormalItem("寄件人电话", orderVO.senderPhone);
		//5
		addNormalItem("寄件人手机", orderVO.senderMobile);
		addNormalItem("收件人姓名", orderVO.receiverName);
		addNormalItem("收件人地址", orderVO.receiverAdd);
		addNormalItem("收件人单位", orderVO.receiverOrg);
		addNormalItem("收件人电话", orderVO.receiverPhone);
		//10
		addNormalItem("收件人手机", orderVO.receiverMobile);
//		addNormalItem("快递类型", goodsVO.goodsType.toGoodsString());
		addNormalItem("价格", orderVO.cost+"");
		addNormalItem("建单人编号",orderVO.perNum);
		//20
		addNormalItem("所属机构",orderVO.orgNum);
		
		container.packHeight();
	}
}
