/**
 * 大仓库中区的PO
 * @author danni
 * @date 2015/10/22
 */
package org.cross.elscommon.po;

import java.io.Serializable;
import java.util.ArrayList;

import org.cross.elscommon.util.StockType;

public class StockAreaPO implements Serializable {

	/**
	 * 仓库小间编号
	 */
	private String number;

	/**
	 * 特定仓库类型
	 */
	private StockType stockType;

	/**
	 * 特定仓库总容量
	 */
	private int totalCapacity;

	/**
	 * 特定仓库已用容量
	 */
	private int usedCapacity;
	
	private String stockNum;

	public StockAreaPO(String number, StockType stockType, int totalCapacity, String stockNum) {
		super();
		this.number = number;
		this.stockType = stockType;
		this.totalCapacity = totalCapacity;
		this.setStockNum(stockNum);
		this.usedCapacity = 0;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public StockType getStockType() {
		return stockType;
	}

	public void setStockType(StockType stockType) {
		this.stockType = stockType;
	}

	public int getTotalCapacity() {
		return totalCapacity;
	}

	public void setTotalCapacity(int totalCapacity) {
		this.totalCapacity = totalCapacity;
	}

	public int getUsedCapacity() {
		return usedCapacity;
	}

	public void setUsedCapacity(int usedCapacity) {
		this.usedCapacity = usedCapacity;
	}

	public String getStockNum() {
		return stockNum;
	}

	public void setStockNum(String stockNum) {
		this.stockNum = stockNum;
	}

}
