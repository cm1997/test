/**
 * 库存操作VO类
 * @author danni
 * @date 2015/10/25
 */
package org.cross.elsclient.vo;

import org.cross.elscommon.util.StockOperationType;
import org.cross.elscommon.util.StockType;

public class StockOperationVO {
	/**
	 * 时间
	 */
	public String time;
	
	/**
	 * 类型（出入库）
	 */
	public StockOperationType type;
	
	/**
	 * 快件编号
	 */
	public String goodNum;
	
	/**
	 * 金额
	 */
	public double money;
	
	/**
	 * 存放小间类型
	 */
	public StockType stockType;

	public StockOperationVO(String time, StockOperationType type, String goodNum, double money, StockType place) {
		super();
		this.time = time;
		this.type = type;
		this.goodNum = goodNum;
		this.money = money;
		this.stockType = place;
	}
	
}
