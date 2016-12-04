/**
 * 期初建账VO
 * @author Polaris Chen
 * @date 2015/10/23
 */
package org.cross.elsclient.vo;

import java.util.ArrayList;

public class InitialVO {

	/**
	 * 编号
	 */
	public String id;

	/**
	 * 建账日期
	 */
	public String time;

	/**
	 * 账本名称
	 */
	public String initialName;

	/**
	 * 建账人姓名
	 */
	public String perName;

	/**
	 * 建账人编号
	 */
	public String perNumber;
	/**
	 * 机构列表
	 */
	public ArrayList<OrganizationVO> organizations;

	/**
	 * 人员列表
	 */
	public ArrayList<PersonnelVO> personnels;

	/**
	 * 车辆列表
	 */
	public ArrayList<VehicleVO> vehicles;

	/**
	 * 库存列表
	 */
	public ArrayList<StockVO> stocks;

	/**
	 * 账户列表
	 */
	public ArrayList<AccountVO> accounts;

	public InitialVO(String id,String initialName,
			
			ArrayList<OrganizationVO> organizations,
			ArrayList<PersonnelVO> personnels, ArrayList<VehicleVO> vehicles,
			ArrayList<StockVO> stocks, ArrayList<AccountVO> accounts ,String time,String perName, String perNumber) {
		super();
		this.id = id;
		this.time = time;
		this.initialName = initialName;
		this.perName = perName;
		this.perNumber = perNumber;
		this.organizations = organizations;
		this.personnels = personnels;
		this.vehicles = vehicles;
		this.stocks = stocks;
		this.accounts = accounts;
	}

}
