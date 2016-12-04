/**
 * 出库单VO类
 * @author raychen
 * @date 2015/10/22
 */
package org.cross.elsclient.vo;

import java.util.ArrayList;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.VehicleType;

public class Receipt_StockOutVO extends ReceiptVO {
	/**
	 * 快递编号
	 */
	public String goodsNum;

	/**
	 * 目的地(营业厅ID)
	 */
	public String targetOrgID;

	/**
	 * 装运形式
	 */
	public String vehicle;

	/**
	 * 转运单编号
	 */
	public String transNumber;

	public Receipt_StockOutVO(String number,String time,
			String goodsNumber, 
			String targetOrgID, String vehicle, String transNumber, String perNum, String orgNum
			) {
		super(number, ReceiptType.STOCKOUT, time, perNum, orgNum);
		this.goodsNum = goodsNumber;
		this.targetOrgID = targetOrgID;
		this.vehicle = vehicle;
		this.transNumber = transNumber;
	}

}
