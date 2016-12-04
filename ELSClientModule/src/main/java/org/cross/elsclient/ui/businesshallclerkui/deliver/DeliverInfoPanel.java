package org.cross.elsclient.ui.businesshallclerkui.deliver;

import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.vo.Receipt_DeliverVO;
import org.cross.elsclient.vo.Receipt_TransVO;

public class DeliverInfoPanel extends ELSInfoPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Receipt_DeliverVO delvo;
	
	public DeliverInfoPanel(Receipt_DeliverVO vo){
		this.delvo = vo;
		init();
	}
	
	@Override
	public void init(){
		super.init();
		
		setTitle("派件单信息");
		addNormalItem("派件单编号", delvo.number);
		addNormalItem("快递员编号", delvo.posterNum);
		addNormalItem("快递员姓名", delvo.name);
		
		container.packHeight();
	}

}
