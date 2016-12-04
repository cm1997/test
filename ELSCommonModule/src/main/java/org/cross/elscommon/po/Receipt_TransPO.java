/**
 * 转运单PO
 * @author raychen
 * @date 2015/10/23
 */
package org.cross.elscommon.po;

import java.util.ArrayList;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.ReceiptType;

public class Receipt_TransPO extends ReceiptPO {

	/**
	 * 运费
	 */
	private double cost;

	/**
	 * 中转中心/营业厅汽运编号
	 */
	private String transNum;

	/**
	 * 车次/航班号(车辆代号)
	 */
	private String veNum;

	/**
	 * 出发地
	 */
	private String startPlace;

	/**
	 * 到达地
	 */
	private String arrivePlace;

	/**
	 * 监装员
	 */
	private String observer;

	/**
	 * 押运员（司机）
	 */
	private String driver;

	public Receipt_TransPO(String number, ReceiptType type, String time,
			String orgNum, String perNum, double cost, String transNum,
			String veNum, String startPlace, String arrivePlace,
			String observer, String driver) {
		super(number, type, time, orgNum, perNum);
		this.cost = cost;
		this.transNum = transNum;
		this.veNum = veNum;
		this.startPlace = startPlace;
		this.arrivePlace = arrivePlace;
		this.observer = observer;
		this.driver = driver;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getTransNum() {
		return transNum;
	}

	public void setTransNum(String transNum) {
		this.transNum = transNum;
	}

	public String getVeNum() {
		return veNum;
	}

	public void setVeNum(String veNum) {
		this.veNum = veNum;
	}

	public String getStartPlace() {
		return startPlace;
	}

	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}

	public String getArrivePlace() {
		return arrivePlace;
	}

	public void setArrivePlace(String arrivePlace) {
		this.arrivePlace = arrivePlace;
	}

	public String getObserver() {
		return observer;
	}

	public void setObserver(String observer) {
		this.observer = observer;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

}
