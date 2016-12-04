/**
 * 人员PO
 * @author Polaris Chen
 * @date 2015/10/19
 */
package org.cross.elscommon.po;

import java.io.Serializable;
import org.cross.elscommon.util.PositionType;

public class PersonnelPO implements Serializable {

	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 人员工号
	 */
	private String number;
	/**
	 * 人员姓名
	 */
	private String name;
	/**
	 * 人员职位
	 */
	private PositionType position;
	/**
	 * 人员所属机构ID
	 */
	private String orgNum;
	/**
	 * 人员工资
	 */
	private double payment;

	private int sex;
	/**
	 * 人员身份证号
	 */
	private String id;

	private String phone;

	private String birth;

	public PersonnelPO(String number, String name, PositionType position,
			String orgNum, double payment, int sex, String id, String phone,
			String birth) {
		super();
		this.number = number;
		this.name = name;
		this.position = position;
		this.orgNum = orgNum;
		this.payment = payment;
		this.sex = sex;
		this.id = id;
		this.phone = phone;
		this.birth = birth;
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

	public PositionType getPosition() {
		return position;
	}

	public void setPosition(PositionType position) {
		this.position = position;
	}

	public String getOrgNum() {
		return orgNum;
	}

	public void setOrgNum(String orgNum) {
		this.orgNum = orgNum;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
