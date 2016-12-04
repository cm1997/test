/**
 * 订单VO类
 * @author raychen
 * @date 2015/10/22
 */
package org.cross.elsclient.vo;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.People;
import org.cross.elscommon.util.ReceiptType;

public class Receipt_OrderVO extends ReceiptVO {

	/**
	 * 费用
	 */
	public double cost;

	/**
	 * 收件时间
	 */
	public String receiveTime;

	/**
	 * 预计到达时间
	 */
	public String expectTime;

	/**
	 * 寄件人姓名
	 */
	public String senderName;

	/**
	 * 寄件人手机
	 */
	public String senderMobile;

	/**
	 * 寄件人电话
	 */
	public String senderPhone;
	/**
	 * 寄件人地址
	 */
	public String senderAdd;
	/**
	 * 寄件人单位
	 */
	public String senderOrg;

	public String receiverName;

	public String receiverOrg;

	public String receiverAdd;

	public String receiverPhone;

	public String receiverMobile;

	public String moneyinNum;
	
	public Receipt_OrderVO(String number, String time, double cost, String receiveTime,
			String expectTime, String senderName, String senderMobile, String senderPhone, String senderAdd,
			String senderOrg, String receiverName, String receiverOrg, String receiverAdd, String receiverPhone,
			String receiverMobile, String perNum, String orgNum) {
		super(number, ReceiptType.ORDER, time, perNum, orgNum);
		this.cost = cost;
		this.receiveTime = receiveTime;
		this.expectTime = expectTime;
		this.senderName = senderName;
		this.senderMobile = senderMobile;
		this.senderPhone = senderPhone;
		this.senderAdd = senderAdd;
		this.senderOrg = senderOrg;
		this.receiverName = receiverName;
		this.receiverOrg = receiverOrg;
		this.receiverAdd = receiverAdd;
		this.receiverPhone = receiverPhone;
		this.receiverMobile = receiverMobile;
		
		this.moneyinNum = null;
	}

}
