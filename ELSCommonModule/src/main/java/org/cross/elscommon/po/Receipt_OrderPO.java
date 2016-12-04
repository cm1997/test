/**
 * 订单PO类
 * @author raychen
 * @date 2015/10/21
 */
package org.cross.elscommon.po;

import org.cross.elscommon.util.ReceiptType;

public class Receipt_OrderPO extends ReceiptPO {

	/**
	 * 费用
	 */
	private double price;

	/**
	 * 收件时间
	 */
	private String receiveTime;

	/**
	 * 预计到达时间
	 */
	private String expectTime;

	private String senderName;

	private String receiverName;

	private String senderOrg;

	private String receiverOrg;

	private String senderAdd;

	private String receiverAdd;

	private String senderPhone;

	private String receiverPhone;

	private String senderMobile;

	private String receiverMobile;
	
	private String moneyInNum;

	public Receipt_OrderPO(String number, ReceiptType type, String time,
			String orgNum, String perNum, double price,
			String expectTime, String senderName,
			String receiverName, String senderOrg, String receiverOrg,
			String senderAdd, String receiverAdd, String senderPhone,
			String receiverPhone, String senderMobile, String receiverMobile) {
		super(number, type, time, orgNum, perNum);
		this.price = price;
		this.receiveTime = null;
		this.expectTime = expectTime;
		this.senderName = senderName;
		this.receiverName = receiverName;
		this.senderOrg = senderOrg;
		this.receiverOrg = receiverOrg;
		this.senderAdd = senderAdd;
		this.receiverAdd = receiverAdd;
		this.senderPhone = senderPhone;
		this.receiverPhone = receiverPhone;
		this.senderMobile = senderMobile;
		this.receiverMobile = receiverMobile;
		this.moneyInNum = null;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(String receiveTime) {
		this.receiveTime = receiveTime;
	}

	public String getExpectTime() {
		return expectTime;
	}

	public void setExpectTime(String expectTime) {
		this.expectTime = expectTime;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getSenderOrg() {
		return senderOrg;
	}

	public void setSenderOrg(String senderOrg) {
		this.senderOrg = senderOrg;
	}

	public String getReceiverOrg() {
		return receiverOrg;
	}

	public void setReceiverOrg(String receiverOrg) {
		this.receiverOrg = receiverOrg;
	}

	public String getSenderAdd() {
		return senderAdd;
	}

	public void setSenderAdd(String senderAdd) {
		this.senderAdd = senderAdd;
	}

	public String getReceiverAdd() {
		return receiverAdd;
	}

	public void setReceiverAdd(String receiverAdd) {
		this.receiverAdd = receiverAdd;
	}

	public String getSenderPhone() {
		return senderPhone;
	}

	public void setSenderPhone(String senderPhone) {
		this.senderPhone = senderPhone;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public String getSenderMobile() {
		return senderMobile;
	}

	public void setSenderMobile(String senderMobile) {
		this.senderMobile = senderMobile;
	}

	public String getReceiverMobile() {
		return receiverMobile;
	}

	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}

	public String getMoneyInNum() {
		return moneyInNum;
	}

	public void setMoneyInNum(String moneyInNum) {
		this.moneyInNum = moneyInNum;
	}

}
