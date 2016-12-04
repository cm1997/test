package org.cross.elscommon.po;

import java.io.Serializable;

public class NumberPO implements Serializable{

	private String goodsNum = "0000000000";

	private String initNum = "000000000";

	private String logNum = "0000000000";

	private String orgNum = "000";

	private String perNum = "000";

	private String userNum = "000";

	private String receiptNum = "0000000";

	private String stockNum = "000";

	private String stockAreaNum = "0000000";

	private String vehicleNum = "000";

	public NumberPO(String goodsNum, String initNum, String logNum,
			String orgNum, String perNum, String userNum, String receiptNum,
			String stockNum, String stockAreaNum, String vehicleNum) {
		super();
		this.goodsNum = goodsNum;
		this.initNum = initNum;
		this.logNum = logNum;
		this.orgNum = orgNum;
		this.perNum = perNum;
		this.userNum = userNum;
		this.receiptNum = receiptNum;
		this.stockNum = stockNum;
		this.stockAreaNum = stockAreaNum;
		this.vehicleNum = vehicleNum;
	}
	
	public NumberPO(){
		
	}

	public String getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}

	public String getInitNum() {
		return initNum;
	}

	public void setInitNum(String initNum) {
		this.initNum = initNum;
	}

	public String getLogNum() {
		return logNum;
	}

	public void setLogNum(String logNum) {
		this.logNum = logNum;
	}

	public String getOrgNum() {
		return orgNum;
	}

	public void setOrgNum(String orgNum) {
		this.orgNum = orgNum;
	}

	public String getPerNum() {
		return perNum;
	}

	public void setPerNum(String perNum) {
		this.perNum = perNum;
	}

	public String getUserNum() {
		return userNum;
	}

	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}

	public String getReceiptNum() {
		return receiptNum;
	}

	public void setReceiptNum(String receiptNum) {
		this.receiptNum = receiptNum;
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

	public String getVehicleNum() {
		return vehicleNum;
	}

	public void setVehicleNum(String vehicleNum) {
		this.vehicleNum = vehicleNum;
	}

}
