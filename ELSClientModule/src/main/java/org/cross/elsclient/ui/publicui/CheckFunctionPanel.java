package org.cross.elsclient.ui.publicui;

import org.cross.elsclient.blimpl.goodsblimpl.Goods;
import org.cross.elsclient.blservice.goodsblservice.GoodsBLService;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.ui.component.ELSFunctionPanel;
import org.cross.elsclient.ui.courierui.goodscheck.GoodsCheckPanel;

public class CheckFunctionPanel extends ELSFunctionPanel{
	public GoodsBLService goodsbl;
	
	public CheckFunctionPanel(GoodsBLService goodsbl) {
		this.goodsbl = goodsbl;
		init();
	}
	
	@Override
	public void init() {
		super.init();
		
		addFunctionBtn("快件查询", "goodsCheck");
		addFunctionPanel(new GoodsCheckPanel(goodsbl), "manage", "goodsCheck");
	}
}
