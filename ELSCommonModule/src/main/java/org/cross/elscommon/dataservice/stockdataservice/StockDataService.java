/**
 * 仓库管理数据接口
 * @author danni
 * @date 2015/10/19
 */
package org.cross.elscommon.dataservice.stockdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.po.StockAreaPO;
import org.cross.elscommon.po.StockOperationPO;
import org.cross.elscommon.po.StockPO;
import org.cross.elscommon.util.ResultMessage;

public interface StockDataService extends Remote{
	public ResultMessage insertStock(StockPO po) throws RemoteException;
	public ResultMessage updateStock(StockPO po) throws RemoteException;
	public StockPO findStockByNumber(String number) throws RemoteException;
	public StockPO findStockByOrg(String orgNum) throws RemoteException;
	public ArrayList<StockPO> showStock() throws RemoteException;
	
	public ResultMessage insertStockArea(StockAreaPO po) throws RemoteException;
	public ResultMessage updateStockArea(StockAreaPO po) throws RemoteException;
	public StockAreaPO findStockAreaByNumber(String number) throws RemoteException;
	public ArrayList<StockAreaPO> findStockAreaByStock(String stockNum) throws RemoteException;
	public ArrayList<StockAreaPO> showStockArea() throws RemoteException;

	public ResultMessage insertStockOP(StockOperationPO po) throws RemoteException;
	public ArrayList<StockOperationPO> findStockOPByStock(String stockNum) throws RemoteException;
	public ArrayList<StockOperationPO> findStockOPByTime(String startTime, String endTime) throws RemoteException;
	public ArrayList<StockOperationPO> findStockOPByTimeAndStock(String stockNum, String startTime, String endTime) throws RemoteException;
	public ArrayList<StockOperationPO> showStockOP()throws RemoteException;
}

