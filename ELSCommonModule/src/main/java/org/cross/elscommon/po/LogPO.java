/**
 * 系统日志PO
 * @author Polaris Chen
 * @date 2015/10/19
 */
package org.cross.elscommon.po;

import java.io.Serializable;

public class LogPO implements Serializable {

	/**
	 * 编号
	 */
	private String number;

	/**
	 * 操作时间
	 */
	private String time;

	/**
	 * 操作人员
	 */
	private String operator;

	/**
	 * 操作内容
	 */
	private String operation;

	public LogPO(String number, String time, String operator, String operation) {
		super();
		this.number = number;
		this.time = time;
		this.operator = operator;
		this.operation = operation;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

}
