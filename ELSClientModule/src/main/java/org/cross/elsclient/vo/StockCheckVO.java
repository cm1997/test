package org.cross.elsclient.vo;


public class StockCheckVO {
	
	/**
	 * 快件编号
	 */
	public String goodsNumber;
	
	/**
	 * 入库日期
	 */
	public String inTime;
	
	/**
	 * 目的地
	 */
	public String targetCity;
	
	/**
	 * 区号
	 */
	public String stockAreaNum;
	
	public StockCheckVO(String goodsNum,String inTime,String targetCity,String stockAreaNum){
		this.goodsNumber = goodsNum;
		this.inTime = inTime;
		this.targetCity = targetCity;
		this.stockAreaNum = stockAreaNum;
	}
}
