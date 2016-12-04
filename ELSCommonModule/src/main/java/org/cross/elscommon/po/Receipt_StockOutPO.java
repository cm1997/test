/**
 * 出库单PO
 * @author raychen
 * @date 2015/10/23
 */
package org.cross.elscommon.po;

import java.io.Serializable;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.VehicleType;

public class Receipt_StockOutPO extends ReceiptPO implements Serializable {

	/**
	 * 快递编号
	 */
	private String orderNum;

	/**
	 * 目的地
	 */
	private String destination;

	/**
	 * 装运形式
	 */
	private VehicleType transType;

	/**
	 * 转运单编号
	 */
	private String transNumber;

	public Receipt_StockOutPO(String number, ReceiptType type, String time,
			String orgNum, String perNum, String orderNum, String destination,
			VehicleType transType, String transNumber) {
		super(number, type, time, orgNum, perNum);
		this.orderNum = orderNum;
		this.destination = destination;
		this.transType = transType;
		this.transNumber = transNumber;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public VehicleType getTransType() {
		return transType;
	}

	public void setTransType(VehicleType transType) {
		this.transType = transType;
	}

	public String getTransNumber() {
		return transNumber;
	}

	public void setTransNumber(String transNumber) {
		this.transNumber = transNumber;
	}

}
