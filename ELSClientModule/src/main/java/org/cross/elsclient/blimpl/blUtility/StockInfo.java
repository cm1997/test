package org.cross.elsclient.blimpl.blUtility;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.vo.StockAreaVO;
import org.cross.elsclient.vo.StockOperationVO;
import org.cross.elsclient.vo.StockVO;
import org.cross.elscommon.po.StockAreaPO;
import org.cross.elscommon.po.StockOperationPO;
import org.cross.elscommon.po.StockPO;
import org.cross.elscommon.util.ResultMessage;

public interface StockInfo {
	public StockVO toStockVO(StockPO po) throws RemoteException;
	
	public StockPO toStockPO(StockVO vo);
	
	public ArrayList<StockVO> toStockVO(ArrayList<StockPO> pos) throws RemoteException;
	
	public ArrayList<StockPO> toStockPO(ArrayList<StockVO> vos);
	
	public StockAreaVO toStockAreaVO(StockAreaPO po) throws RemoteException;
	
	public StockAreaPO toStockAreaPO(StockAreaVO vo);
	
	public ArrayList<StockAreaPO> toStockAreaPO(ArrayList<StockAreaVO> vos);
	
	public StockOperationVO toStockOperationVO(StockOperationPO po);

//	public StockOperationPO toStockOperationPO(StockOperationVO vo);
	
	public ArrayList<StockVO> showStockVOs() throws RemoteException;
	
	public ResultMessage addsto(StockVO sto);
}
