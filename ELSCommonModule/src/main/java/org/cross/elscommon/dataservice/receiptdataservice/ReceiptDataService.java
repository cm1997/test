/**
 * 单据管理数据接口
 * @author raychen
 * @date 2015/10/19
 */
package org.cross.elscommon.dataservice.receiptdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;

public interface ReceiptDataService extends Remote{
	/**
	 * 添加单据
	 * @para 
	 * @return ResultMessage
	 */
	public ResultMessage insert(ReceiptPO po) throws RemoteException;
	/**
	 * 删除单据
	 * @para 
	 * @return ResultMessage
	 */
	public ResultMessage delete(String number, ReceiptType type) throws RemoteException;
	/**
	 * 审批单据
	 * @para 
	 * @return ResultMessage
	 */
	public ResultMessage updateCheck(String number,String state) throws RemoteException;
	/**
	 * 更新单据
	 * @para 
	 * @return ResultMessage
	 */
	public ResultMessage update(ReceiptPO po)throws RemoteException;
	public ArrayList<ReceiptPO> show() throws RemoteException;
	public ReceiptPO findByNum(String number) throws RemoteException; 
	public ArrayList<ReceiptPO> findByTime(String startTime, String endTime) throws RemoteException;
	public ArrayList<ReceiptPO> findByType(ReceiptType type) throws RemoteException;
	public ArrayList<ReceiptPO> findByTimeAndType(String startTime, String endTime, ReceiptType type) throws RemoteException;
	public ArrayList<ReceiptPO> findByPerNum(String perNum) throws RemoteException;
	public ArrayList<ReceiptPO> findByOrgNum(String orgNum) throws RemoteException;
}
