/**
 * 营业厅收款单VO类
 * @author raychen
 * @date 2015/10/22
 */
package org.cross.elsclient.vo;

import java.util.ArrayList;

import org.cross.elscommon.util.ReceiptType;

public class Receipt_MoneyInVO extends ReceiptVO {

	/**
	 * 收款金额
	 */
	public double money;

	/**
	 * 收款快递员
	 */
	public String person;

	/**
	 * 所有订单条形码号
	 */
	public ArrayList<String> orderNumbers;

	public Receipt_MoneyInVO(String time,
			double money, String person,String number,
			ArrayList<String> orderNumbers,
			String businessHallNameID, String perNum) {
		super(number, ReceiptType.MONEYIN, time, perNum, businessHallNameID);
		this.money = money;
		this.person = person;
		this.orderNumbers = orderNumbers;
	}

}
