package org.cross.elsclient.vo;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.OrganizationType;

/**
 * 机构VO类
 * 
 * @author Moo
 * @date 2015年10月19日
 */
public class OrganizationVO {
	/**
	 * 所在城市
	 */
	public City city;

	/**
	 * 机构编号
	 */
	public String number;

	/**
	 * 机构类型
	 */
	public OrganizationType type;

	public OrganizationVO(City city, OrganizationType type, String number) {
		super();
		this.city = city;
		this.number = number;
		this.type = type;
	}

}
