/**
 * 单据管理服务接口
 * @author raychen
 * @date 2015/10/19
 */
package org.cross.elsclient.blservice.receiptblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.util.ApproveType;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elsclient.vo.ReceiptVO;

public interface ReceiptBLService {
	
	/**
	 * 增加单据
	 * @param vo
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMessage add(ReceiptVO vo) throws RemoteException;
	
	/**
	 * 删除单据
	 * @param number,type
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMessage delete(String number,ReceiptType type) throws RemoteException;
	
	/**
	 * 更新单据信息
	 * @param vo
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMessage update(ReceiptVO vo) throws RemoteException;
	
	/**
	 * 显示所有单据信息
	 * @return
	 * @throws RemoteException 
	 */
	public ArrayList<ReceiptVO> show() throws RemoteException;
	
	/**
	 * 根据单据编号查找
	 * @param names
	 * @return
	 * @throws RemoteException 
	 */
	public ReceiptVO findByID(String names) throws RemoteException;
	
	/**
	 * 审批单据
	 * @param vo
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMessage check(ReceiptVO vo, ApproveType approveState) throws RemoteException;
	
	/**
	 * 根据时间查找单据
	 * @throws RemoteException 
	 */
	public ArrayList<ReceiptVO> findByTime(String startTime, String endTime) throws RemoteException;
	
	/**
	 * 根据类型查找单据
	 * @throws RemoteException 
	 */
	public ArrayList<ReceiptVO> findByType(ReceiptType type) throws RemoteException;
	
	/**
	 * 根据时间、类型查找单据
	 * @throws RemoteException 
	 */
	public ArrayList<ReceiptVO> findByTimeAndType(String startTime, String endTime, ReceiptType type) throws RemoteException;
	
	public ArrayList<ReceiptVO> findByUser(String userId) throws RemoteException;
	
	public ArrayList<ReceiptVO> findByOrgan(String organId) throws RemoteException;
}
