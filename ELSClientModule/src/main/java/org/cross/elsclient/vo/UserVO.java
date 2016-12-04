package org.cross.elsclient.vo;

import org.cross.elscommon.util.UserType;

public class UserVO {
	/**
	 * 用户id 格式为U00001 第一位数字代表用户类型：0快递员；1营业厅业务员；2中转中心业务员；3仓库管理员；4财务人员；5总经理；6系统管理员
	 */
	public String number;

	/**
	 * 用户姓名
	 */
	public String name;

	/**
	 * 所属机构name+id
	 */
	public String orgNameID;

	/**
	 * 用户职位
	 */
	public UserType userType;

	public String password;

	public UserVO(String number, String password, String name, UserType position, String orgNameID) {
		super();
		this.number = number;
		this.name = name;
		this.orgNameID = orgNameID;
		this.userType = position;
		this.password = password;
	}

}
