/**
 * 账户PO
 * @author Polaris Chen
 * @date 2015/10/19
 */
package org.cross.elscommon.po;

import java.io.Serializable;

public class AccountPO implements Serializable {

	/**
	 * 账户名称
	 */
	private String name;
	/**
	 * 银行卡号
	 */
	private String accountNum;
	/**
	 * 账户余额
	 */
	private double balance;

	/**
	 * 构造方法
	 * @param name
	 * @param accountNum
	 * @param balance
	 */
	public AccountPO(String name, String accountNum, double balance) {
		super();
		this.name = name;
		this.accountNum = accountNum;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
