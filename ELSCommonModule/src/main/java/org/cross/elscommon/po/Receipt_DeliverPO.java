package org.cross.elscommon.po;

import org.cross.elscommon.util.ReceiptType;

public class Receipt_DeliverPO extends ReceiptPO {

	private String orderNum;

	private String name;

	private String posterNum;

	public Receipt_DeliverPO(String number, ReceiptType type, String time,
			String orgNum, String perNum, String orderNum, String name,
			String posterNum) {
		super(number, type, time, orgNum, perNum);
		this.orderNum = orderNum;
		this.name = name;
		this.posterNum = posterNum;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosterNum() {
		return posterNum;
	}

	public void setPosterNum(String posterNum) {
		this.posterNum = posterNum;
	}

}
