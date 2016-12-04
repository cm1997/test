package org.cross.elsclient.blimpl.blUtility;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.vo.ReceiptVO;
import org.cross.elsclient.vo.Receipt_MoneyInVO;
import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.util.ReceiptType;

public interface ReceiptInfo {
	public ReceiptVO toVO(ReceiptPO po);
	public ReceiptPO toPO(ReceiptVO vo);
	/**
	 * 根据单据编号查找
	 * @param names
	 * @return
	 * @throws RemoteException 
	 */
	public ReceiptVO findByID(String names) throws RemoteException;
	
	public ArrayList<String> findByMoneyin(String moneyinNum) throws RemoteException;
	
	public ArrayList<ReceiptVO> findByTimeAndType(ReceiptType type, String start, String end) throws RemoteException;

	public ArrayList<ReceiptVO> findByType(ReceiptType type) throws RemoteException;
	
	public ArrayList<ReceiptVO> findByTime(String start, String end) throws RemoteException;
	
	public ArrayList<Receipt_MoneyInVO> findByTotalMoneyIn(String totalmoney) throws RemoteException;
	
}
