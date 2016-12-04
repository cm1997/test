/**
 * 历史轨迹VO类
 * @author raychen
 * @date 2015/10/23
 */
package org.cross.elsclient.vo;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.OrganizationType;

public class HistoryVO {
	/**
	 * 到达某地/从某地发出的时间
	 */
	public String time;
	
	/**
	 * 地点,城市
	 */
	public City placeCity;
	
	/**
	 * 地点,机构
	 */
	public OrganizationType placeOrg;
	
	/**
	 * 是到达或发出
	 */
	public boolean isArrive;

	/**
	 * 构造方法
	 * @param time
	 * @param placeCity
	 * @param placeOrg
	 * @param isArrive
	 */
	public HistoryVO(String time, City placeCity, OrganizationType placeOrg, boolean isArrive) {
		super();
		this.time = time;
		this.placeCity = placeCity;
		this.placeOrg = placeOrg;
		this.isArrive = isArrive;
	}
	
}

