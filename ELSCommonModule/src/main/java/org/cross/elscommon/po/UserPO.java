package org.cross.elscommon.po;

import java.io.Serializable;

import org.cross.elscommon.util.UserType;

public class UserPO implements Serializable {

	/**
	 * 用户id 格式为U00001 第一位数字代表用户类型：0快递员；1营业厅业务员；2中转中心业务员；3仓库管理员；4财务人员；5总经理；6系统管理员
	 */
	private String number;

	/**
	 * 用户姓名
	 */
	private String name;

	/**
	 * 用户类型
	 */
	private UserType type;

	private String password;

	private String orgNum;

	public UserPO(String number, String name, UserType type, String password,
			String orgNum) {
		super();
		this.number = number;
		this.name = name;
		this.type = type;
		this.password = password;
		this.orgNum = orgNum;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOrgNum() {
		return orgNum;
	}

	public void setOrgNum(String orgNum) {
		this.orgNum = orgNum;
	}

}
