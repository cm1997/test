package org.cross.elsclient.vo;

import org.cross.elscommon.util.ReceiptType;

public class Receipt_DeliverVO extends ReceiptVO{
	
	public String orderNum;

	public String name;

	public String posterNum;

	public Receipt_DeliverVO(String number, String time,
			String orderNum, String name, String posterNum, String perNum, String orgNum) {
		super(number, ReceiptType.DELIVER, time, perNum, orgNum);
		this.orderNum = orderNum;
		this.name = name;
		this.posterNum = posterNum;
	}
	
	
}
