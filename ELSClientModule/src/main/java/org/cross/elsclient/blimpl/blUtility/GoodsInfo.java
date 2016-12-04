package org.cross.elsclient.blimpl.blUtility;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.vo.GoodsVO;
import org.cross.elsclient.vo.HistoryVO;
import org.cross.elscommon.po.GoodsPO;
import org.cross.elscommon.po.HistoryPO;
import org.cross.elscommon.util.ResultMessage;

public interface GoodsInfo {
	public GoodsVO toGoodsVO(GoodsPO po, ArrayList<HistoryVO> historyVOs);

	public HistoryVO toHistroyVO(HistoryPO po);

	public GoodsPO toGoodsPO(GoodsVO vo);

	public HistoryPO toHistroyPO(HistoryVO vo, String orderNum);

	public ArrayList<GoodsVO> findByStockAreaNum(String stockAreaNum)
			throws RemoteException;

	/**
	 * 根据单号查快件
	 * 
	 * @throws RemoteException
	 */
	public GoodsVO searchGoods(String goodsID) throws RemoteException;

	public ArrayList<GoodsVO> findGoodsFromArea(String stockAreaNum) throws RemoteException;
	
	public ArrayList<GoodsVO> findGoodsByStockNum(String stockNum) throws RemoteException;

	public ArrayList<HistoryVO> toHistroyVO(ArrayList<HistoryPO> pos);
	
	public ResultMessage updateGoods(GoodsPO po) throws RemoteException;
	
	public String findStockAreaNum(String goodsID) throws RemoteException;
	
	public double getCost(String goodsID) throws RemoteException;
	
	public ArrayList<GoodsPO> findByTransNum(String transNum) throws RemoteException;
}
