package org.cross.elsclient.ui.counterui.cost;

import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.Receipt_MoneyOutVO;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.NumberType;

public class MoneyOutInfoPanel extends ELSInfoPanel {
	Receipt_MoneyOutVO vo;
	
	public MoneyOutInfoPanel(Receipt_MoneyOutVO vo) {
		this.vo = vo;
		init();
	}
	
	@Override
	public void init() {
		super.init();
		
		setTitle("付款单信息");
		addNormalItem("付款单编号",vo.number);
		addNormalItem("条目", vo.clause);
		addNormalItem("付款人",vo.receiveID);
		addNormalItem("付款账号",vo.senderID);
		addNormalItem("付款金额",vo.money+"");
		addNormalItem("付款时间", vo.time);
		addNormalItem("备注", vo.comments);
		addNormalItem("建单人",vo.perNum);
		addNormalItem("所属机构", vo.orgNum);
	}
	
}
