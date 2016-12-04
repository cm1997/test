/**
 * 总收款单PO
 * @author raychen
 * @date 2015/10/23
 */
package org.cross.elscommon.po;

import java.io.Serializable;
import java.util.ArrayList;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.ReceiptType;

public class Receipt_TotalMoneyInPO extends ReceiptPO implements Serializable {

	/**
	 * 总收款金额
	 */
	private double money;

	private String accountNum;

	public Receipt_TotalMoneyInPO(String number, ReceiptType type, String time,
			String orgNum, String perNum, double money, String accountNum) {
		super(number, type, time, orgNum, perNum);
		this.money = money;
		this.accountNum = accountNum;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

}
