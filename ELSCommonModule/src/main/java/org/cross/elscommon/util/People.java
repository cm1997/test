package org.cross.elscommon.util;

public class People {

	/**
	 * 寄/收件人姓名
	 */
	public String name;
	
	/**
	 * 寄/收件人地址
	 */
	public String address;
	
	/**
	 * 寄/收件人电话
	 */
	public String phone;
		
	/**
	 * 构造方法
	 * @param name
	 * @param address
	 * @param phone
	 */
	public People(String name, String address, String phone){
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	
}
