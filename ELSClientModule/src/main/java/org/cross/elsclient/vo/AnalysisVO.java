package org.cross.elsclient.vo;

import java.util.ArrayList;

public class AnalysisVO {
	/**
	 * 总收入
	 */
	public double moneyIn;
	/**
	 * 总支出
	 */
	public double moneuOut;
	/**
	 * 总利润
	 */
	public double profit;

	/**
	 * 收款单
	 */
	ArrayList<Receipt_MoneyInVO> moneyInVOs;
	/**
	 * 付款单
	 */
	ArrayList<Receipt_MoneyOutVO> moneyOutVOs;

	public AnalysisVO(double moneyIn, double moneuOut, double profit,
			ArrayList<Receipt_MoneyInVO> moneyInVOs,
			ArrayList<Receipt_MoneyOutVO> moneyOutVOs) {
		super();
		this.moneyIn = moneyIn;
		this.moneuOut = moneuOut;
		this.profit = profit;
		this.moneyInVOs = moneyInVOs;
		this.moneyOutVOs = moneyOutVOs;
	}

}
