/**
 * 快件管理数据接口
 * @author danni
 * @date 2015/10/22
 */
package org.cross.elscommon.dataservice.goodsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.po.GoodsPO;
import org.cross.elscommon.po.HistoryPO;
import org.cross.elscommon.util.ResultMessage;

public interface GoodsDataService extends Remote{

	/**
	 * 添加历史数据
	 * @para 
	 * @return ResultMessage
	 */
	public ResultMessage addHistory(String number, HistoryPO history)throws RemoteException;
	/**
	 * 展示历史数据
	 * @para 
	 * @return ArrayList<HistoryPO>
	 */
	public ArrayList<HistoryPO> findHistory(String number) throws RemoteException;
	
	/**
	 * 添加快件
	 * @para 
	 * @return ResultMessage
	 */
	public ResultMessage insert(GoodsPO po)throws RemoteException;
	
	/**
	 * 更新快件
	 * @para 
	 * @return ResultMessage
	 */
	public ResultMessage update(GoodsPO po)throws RemoteException;
	
	/**
	 * 根据快件编号查看历史轨迹
	 * @para 
	 * @return GoodsPO
	 */
	public GoodsPO findByNum(String number)throws RemoteException;
	/**
	 * 根据仓库小间查找
	 * @para 
	 * @return ArrayList<GoodsPO>
	 */
	public ArrayList<GoodsPO> findByStockAreaNum(String stockAreaNum)throws RemoteException;
	/**
	 * 根据仓库查找
	 * @para 
	 * @return ArrayList<GoodsPO>
	 */
	public ArrayList<GoodsPO> findByStockNum(String stockNum)throws RemoteException;
	/**
	 * 根据装车单编号查找
	 * @para 
	 * @return ArrayList<GoodsPO>
	 */
	public ArrayList<GoodsPO> findByTransNum(String transNum)throws RemoteException;
	/**
	 * 根据到达单查找
	 * @para 
	 * @return ArrayList<GoodsPO>
	 */
	public ArrayList<GoodsPO> findByArriNum(String arriNum)throws RemoteException;
	/**
	 * 根据派件单号查找
	 * @para 
	 * @return ArrayList<GoodsPO>
	 */
	public ArrayList<GoodsPO> findByDelNum(String delNum)throws RemoteException;
}
