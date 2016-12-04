/**
 * 库存PO类
 * @author danni
 * @date 2015/10/24
 */
package org.cross.elscommon.po;

import java.io.Serializable;
import java.util.ArrayList;

public class StockPO implements Serializable {

	/**
	 * 仓库编号
	 */
	private String number;

	/**
	 * 仓库总间数
	 */
	private int totalAreas;

	/**
	 * 仓库已用间数
	 */
	private int usedAreas;

	/**
	 * 出库数量
	 */
	private int numOut;

	/**
	 * 入库数量
	 */
	private int numIn;

	/**
	 * 出库金额
	 */
	private double moneyOut;

	/**
	 * 入库金额
	 */
	private double moneyIn;

	/**
	 * 库存数量
	 */
	private int numInStock;

	private String orgNum;

	public StockPO(String number, int totalAreas, String orgNum) {
		super();
		this.number = number;
		this.totalAreas = totalAreas;
		this.setOrgNum(orgNum);
		this.usedAreas = 0;
		this.numOut = 0;
		this.numIn = 0;
		this.moneyOut = 0;
		this.moneyIn = 0;
		this.numInStock = 0;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getTotalAreas() {
		return totalAreas;
	}

	public void setTotalAreas(int totalAreas) {
		this.totalAreas = totalAreas;
	}

	public int getUsedAreas() {
		return usedAreas;
	}

	public void setUsedAreas(int usedAreas) {
		this.usedAreas = usedAreas;
	}

	public int getNumOut() {
		return numOut;
	}

	public void setNumOut(int numOut) {
		this.numOut = numOut;
	}

	public int getNumIn() {
		return numIn;
	}

	public void setNumIn(int numIn) {
		this.numIn = numIn;
	}

	public double getMoneyOut() {
		return moneyOut;
	}

	public void setMoneyOut(double moneyOut) {
		this.moneyOut = moneyOut;
	}

	public double getMoneyIn() {
		return moneyIn;
	}

	public void setMoneyIn(double moneyIn) {
		this.moneyIn = moneyIn;
	}

	public int getNumInStock() {
		return numInStock;
	}

	public void setNumInStock(int numInStock) {
		this.numInStock = numInStock;
	}

	public String getOrgNum() {
		return orgNum;
	}

	public void setOrgNum(String orgNum) {
		this.orgNum = orgNum;
	}

}
