package org.cross.elsclient.blservice.stockblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.vo.StockAreaVO;
import org.cross.elsclient.vo.StockCheckVO;
import org.cross.elsclient.vo.StockSeeVO;
import org.cross.elsclient.vo.StockVO;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StockState;
import org.cross.elscommon.util.StockType;

public class StockBL_stub implements StockBLService{

	@Override
	public ResultMessage addStock(StockVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<StockCheckVO> showStockCheck(String stockID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StockSeeVO showStockInfo(String stockID, String time1, String time2) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StockVO findStock(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage exportStockCheck() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<StockAreaVO> stockCapacity(String id, StockType type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage intoStock(String goodsID, String stockID, String time, String stockAreaNum)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage outStock(String goodsID, String stockID, String time) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StockState stockAlert(String stockAreaID, StockType stockType) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage stockAdjust(String stockID, StockType stockType) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getChangeableArea(String stockID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StockVO findStockByOrg(String orgNum) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getNeedChange(String stockID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
