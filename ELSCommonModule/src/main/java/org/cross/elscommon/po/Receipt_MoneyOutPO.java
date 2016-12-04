/**
 * 付款单PO
 * @author raychen
 * @date 2015/10/23
 */
package org.cross.elscommon.po;

import java.io.Serializable;

import org.cross.elscommon.util.ReceiptType;

public class Receipt_MoneyOutPO extends ReceiptPO implements Serializable {

	/**
	 * 付款金额
	 */
	private double money;

	/**
	 * 付款账号
	 */
	private String accountNum;
	
	/**
	 * 付出账号
	 */
	private String senderNum;
	
	/**
	 * 条目
	 */
	private String clause;

	/**
	 * 备注
	 */
	private String comments;

	public Receipt_MoneyOutPO(String number, ReceiptType type, String time,
			String orgNum, String perNum, double money, String accountNum,
			String clause, String comments, String senderNum) {
		super(number, type, time, orgNum, perNum);
		this.money = money;
		this.accountNum = accountNum;
		this.clause = clause;
		this.comments = comments;
		this.senderNum = senderNum;
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

	public String getClause() {
		return clause;
	}

	public void setClause(String clause) {
		this.clause = clause;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getSenderNum() {
		return senderNum;
	}

	public void setSenderNum(String senderNum) {
		this.senderNum = senderNum;
	}

}
