/**
 * 到达单PO
 * @author raychen
 * @date 2015/20/23
 */
package org.cross.elscommon.po;

import org.cross.elscommon.util.ReceiptType;

@SuppressWarnings("serial")
public class Receipt_ArrivePO extends ReceiptPO {

	/**
	 * 出发地
	 */
	private String startPlace;

	private String startTime;

	/**
	 * 转运单编号
	 */
	private String transNum;

	public Receipt_ArrivePO(String number, ReceiptType type, String time, String orgNum, String perNum,
			String startPlace, String startTime, String transNum) {
		super(number, type, time, orgNum, perNum);
		this.startPlace = startPlace;
		this.startTime = startTime;
		this.transNum = transNum;
	}

	public String getStartPlace() {
		return startPlace;
	}

	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getTransNum() {
		return transNum;
	}

	public void setTransNum(String transNum) {
		this.transNum = transNum;
	}

}
