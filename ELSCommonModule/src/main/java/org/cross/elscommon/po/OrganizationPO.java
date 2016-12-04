package org.cross.elscommon.po;

import java.io.Serializable;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.OrganizationType;

/**
 * 机构PO类
 * 
 * @author Moo
 * @date 2015年10月19日
 */
public class OrganizationPO implements Serializable {

	/**
	 * 所在城市
	 */
	private City city;

	/**
	 * 机构ID
	 */
	private String number;

	/**
	 * 机构类型
	 */
	private OrganizationType type;

	public OrganizationPO(City city, String number, OrganizationType type) {
		super();
		this.city = city;
		this.number = number;
		this.type = type;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public OrganizationType getType() {
		return type;
	}

	public void setType(OrganizationType type) {
		this.type = type;
	}

}
