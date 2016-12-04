/**
 * 库存操作PO类
 * @author danni
 * @date 2015/10/25
 */
package org.cross.elscommon.po;

import java.io.Serializable;

import org.cross.elscommon.util.StockOperationType;
import org.cross.elscommon.util.StockType;

public class StockOperationPO implements Serializable {

	/**
	 * 时间
	 */
	private String time;

	/**
	 * 类型（出入库）
	 */
	private StockOperationType opType;

	/**
	 * 快件编号
	 */
	private String goodsNum;

	/**
	 * 金额
	 */
	private double money;

	/**
	 * 存放小间类型
	 */
	private StockType stockType;

	private String stockNum;

	private String stockAreaNum;

	public StockOperationPO(String time, StockOperationType opType, String goodsNum, double money, StockType stockType,
			String stockNum, String stockAreaNum) {
		super();
		this.time = time;
		this.opType = opType;
		this.goodsNum = goodsNum;
		this.money = money;
		this.stockType = stockType;
		this.stockNum = stockNum;
		this.stockAreaNum = stockAreaNum;
	}

	public String getStockNum() {
		return stockNum;
	}

	public void setStockNum(String stockNum) {
		this.stockNum = stockNum;
	}

	public String getStockAreaNum() {
		return stockAreaNum;
	}

	public void setStockAreaNum(String stockAreaNum) {
		this.stockAreaNum = stockAreaNum;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public StockOperationType getOpType() {
		return opType;
	}

	public void setOpType(StockOperationType opType) {
		this.opType = opType;
	}

	public String getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public StockType getStockType() {
		return stockType;
	}

	public void setStockType(StockType stockType) {
		this.stockType = stockType;
	}

}
