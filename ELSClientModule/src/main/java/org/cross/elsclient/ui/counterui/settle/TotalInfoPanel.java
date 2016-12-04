package org.cross.elsclient.ui.counterui.settle;

import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.vo.Receipt_TotalMoneyInVO;

public class TotalInfoPanel extends ELSInfoPanel{
	Receipt_TotalMoneyInVO vo;
	
	public TotalInfoPanel(Receipt_TotalMoneyInVO vo) {
		this.vo = vo;
		init();
	}
	
	@Override
	public void init() {
		super.init();
		setTitle("总收款单信息");
		addNormalItem("总收款单编号", vo.number);
		addNormalItem("收款单数量", vo.receipt_Moneyins.size()+"");
		addNormalItem("收款人", vo.perNameID);
		addNormalItem("收款金额", vo.sum+"");
		addNormalItem("建单人", vo.perNameID);
		addNormalItem("所属机构", vo.orgNum);
		
	}
	
}
