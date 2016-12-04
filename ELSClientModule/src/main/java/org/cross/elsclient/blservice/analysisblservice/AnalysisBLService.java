package org.cross.elsclient.blservice.analysisblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.vo.Receipt_MoneyInVO;
import org.cross.elsclient.vo.Receipt_MoneyOutVO;

public interface AnalysisBLService {
	
	/**
	 * 展示成本收益表
	 * @param 
	 * @return 成本收益表（依次为成本，收益，利润）
	 */
	public double[] showCostBenefitTable();
	
	/**
	 * 展示收款单
	 * @param beginTime, endTime
	 * @return 收款单
	 * @throws RemoteException 
	 */
	public ArrayList<Receipt_MoneyInVO> showMoneyinTable(String beginTime, String endTime) throws RemoteException;
	
	/**
	 * 展示付款单
	 * @param beginTime, endTime
	 * @return 付款单
	 */
	public ArrayList<Receipt_MoneyOutVO> showMoneyoutTable(String beginTime, String endTime);
	
}
