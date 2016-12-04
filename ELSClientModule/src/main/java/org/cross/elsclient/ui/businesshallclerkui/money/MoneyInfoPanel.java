package org.cross.elsclient.ui.businesshallclerkui.money;

import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.vo.Receipt_MoneyInVO;

public class MoneyInfoPanel extends ELSInfoPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Receipt_MoneyInVO vo;
	
	public MoneyInfoPanel(Receipt_MoneyInVO vo){
		this.vo = vo;
		init();
	}
	
	@Override
	public void init(){
		super.init();
		
		String goodsNum = "";
		for (int i = 0; i < vo.orderNumbers.size()-1; i++) {
			goodsNum+=vo.orderNumbers.get(i)+";";
		}
		if(vo.orderNumbers.size()>0) goodsNum+=vo.orderNumbers.get(vo.orderNumbers.size()-1);
		
		setTitle("收款单信息");
		addNormalItem("收款单编号", vo.number);
		addNormalItem("快件单号", goodsNum);
		addNormalItem("收款时间", vo.time);
		addNormalItem("收款快递员", vo.perNum);
		addNormalItem("收款金额", String.valueOf(vo.money));
		
		container.packHeight();
	}

}
