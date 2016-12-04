/**
 * 转运单VO类（包括装车单、中转单、营业厅派件单）
 * @author raychen
 * @date 2015/10/22
 */
package org.cross.elsclient.vo;

import java.util.ArrayList;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.ReceiptType;

public class Receipt_TransVO extends ReceiptVO {

	/**
	 * 所有快件编号
	 */
	public ArrayList<String> goodsID;

	/**
	 * 运费
	 */
	public double cost;
	
	/**
	 * 中转中心/营业厅汽运编号
	 */
	public String transNum;

	/**
	 * 车次/航班号(车辆代号)
	 */
	public String vehicleNum;

	/**
	 * 到达地(机构ID)
	 */
	public String arriveOrgID;

	/**
	 * 监装员
	 */
	public String observerName;

	/**
	 * 押运员（司机）
	 */
	public String driverName;

	public Receipt_TransVO(String number, String time,
			ArrayList<String> goodsID, double cost, 
			String transNum, String vehicleNum,
			String startOrgID,  String arriveOrgID,
			String observerName, String driverName, String perNum) {
		super(number, ReceiptType.TRANS, time, perNum, startOrgID);
		this.goodsID = goodsID;
		this.cost = cost;
		this.transNum = transNum;
		this.vehicleNum = vehicleNum;
		this.arriveOrgID = arriveOrgID;
		this.observerName = observerName;
		this.driverName = driverName;
	}

}
