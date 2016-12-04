/**
 * 期初建账PO
 * @author Polaris Chen
 * @date 2015/10/23
 */
package org.cross.elscommon.po;

import java.io.Serializable;
import java.util.ArrayList;

public class InitialPO implements Serializable {

	/**
	 * 编号
	 */
	private String number;

	/**
	 * 年份
	 */
	private String time;

	/**
	 * 名称
	 */
	private String name;
	
	private String perNum;

	public InitialPO(String number, String time, String name, String perNum) {
		super();
		this.number = number;
		this.time = time;
		this.name = name;
		this.perNum = perNum;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPerNum() {
		return perNum;
	}

	public void setPerNum(String perNum) {
		this.perNum = perNum;
	}

}
