/**
 * 入库单PO
 * @author raychen
 * @date 2015/10/23
 */
package org.cross.elscommon.po;

import java.io.Serializable;

import org.cross.elscommon.util.ReceiptType;

public class Receipt_StockInPO extends ReceiptPO implements Serializable {

	/**
	 * 快递编号
	 */
	private String orderNum;

	/**
	 * 放到仓库的位置
	 */
	private String stockNum;

	private String destination;

	public Receipt_StockInPO(String number, ReceiptType type, String time,
			String orgNum, String perNum, String orderNum, String stockNum,
			String destination) {
		super(number, type, time, orgNum, perNum);
		this.orderNum = orderNum;
		this.stockNum = stockNum;
		this.destination = destination;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getStockNum() {
		return stockNum;
	}

	public void setStockNum(String stockNum) {
		this.stockNum = stockNum;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

}
