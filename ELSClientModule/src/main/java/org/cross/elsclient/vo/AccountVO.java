/**
 * 账户VO
 * @author Polaris Chen
 * @date 2015/10/19
 */
package org.cross.elsclient.vo;

public class AccountVO {

	/**
	 * 账户名称
	 */
	public String name;

	/**
	 * 银行卡号
	 */
	public String account;

	/**
	 * 账户余额
	 */
	public double balance;

	/**
	 * 构造方法
	 * 
	 * @param name
	 * @param account
	 * @param balance
	 */
	public AccountVO(String name, String account, double balance) {
		this.name = name;
		this.account = account;
		this.balance = balance;
	}

}
