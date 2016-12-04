/**
 * 总收款单VO类
 * @author raychen
 * @date 2015/10/22
 */
package org.cross.elsclient.vo;

import java.util.ArrayList;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.ReceiptType;

public class Receipt_TotalMoneyInVO extends ReceiptVO {

	/**
	 * 收款人name+id
	 */
	public String perNameID;

	/**
	 * 总收款金额
	 */
	public double sum;

	/**
	 * 收款单
	 */
	public ArrayList<Receipt_MoneyInVO> receipt_Moneyins;

	public Receipt_TotalMoneyInVO(String number,  String time,
			String perNameID, double sum,
			ArrayList<Receipt_MoneyInVO> receipt_Moneyins,String perNum,
			String orgNum) {
		super(number, ReceiptType.TOTALMONEYIN, time, perNum, orgNum);
		this.perNameID = perNameID;
		this.sum = sum;
		this.receipt_Moneyins = receipt_Moneyins;
	}

}
