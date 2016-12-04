package org.cross.elsclient.blimpl.goodsblimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.GoodsInfo;
import org.cross.elsclient.blimpl.blUtility.ReceiptInfo;
import org.cross.elsclient.vo.GoodsVO;
import org.cross.elsclient.vo.HistoryVO;
import org.cross.elsclient.vo.Receipt_OrderVO;
import org.cross.elscommon.dataservice.goodsdataservice.GoodsDataService;
import org.cross.elscommon.po.GoodsPO;
import org.cross.elscommon.po.HistoryPO;
import org.cross.elscommon.util.ResultMessage;

public class GoodsInfoImpl implements GoodsInfo {

	GoodsDataService goodsData;
	public ReceiptInfo receiptInfo;

	public GoodsInfoImpl(GoodsDataService goodsData) {
		this.goodsData = goodsData;
	}
	
	public GoodsInfoImpl(GoodsDataService goodsData,ReceiptInfo receiptInfo) {
		this.goodsData = goodsData;
		this.receiptInfo = receiptInfo;
	}

	@Override
	public GoodsVO toGoodsVO(GoodsPO po, ArrayList<HistoryVO> historyVOs) {
		if (po == null) {
			return null;
		}
		GoodsVO goodsVO = new GoodsVO(po.getOrderNum(), po.getGoodsType(),
				po.getPlaceCity(), po.getPlaceOrg(), po.getWeight(),
				po.getVolume());

		goodsVO.state = po.getState();
		goodsVO.history = historyVOs;
		goodsVO.orderNum = po.getOrderNum();
		goodsVO.stockAreaNum = po.getStockAreaNum();
		goodsVO.stockNum = po.getStockNum();
		goodsVO.delNum = po.getDelNum();
		goodsVO.arriNum = po.getArriNum();
		goodsVO.transNum = po.getTransNum();
		return goodsVO;
	}

	@Override
	public HistoryVO toHistroyVO(HistoryPO po) {
		if (po == null) {
			return null;
		}
		HistoryVO historyVO = new HistoryVO(po.getTime(), po.getPlaceCity(),
				po.getPlaceOrg(), po.isArrive());
		return historyVO;
	}

	@Override
	public GoodsPO toGoodsPO(GoodsVO vo) {
		if (vo == null) {
			return null;
		}
		GoodsPO goodsPO = new GoodsPO(vo.goodsType, vo.placeCity, vo.placeOrg,
				vo.state, vo.weight, vo.volume, vo.number);
		goodsPO.setArriNum(vo.arriNum);
		goodsPO.setDelNum(vo.delNum);
		goodsPO.setTransNum(vo.transNum);
		goodsPO.setStockAreaNum(vo.stockAreaNum);
		goodsPO.setStockNum(vo.stockNum);
		goodsPO.setState(vo.state);
		return goodsPO;
	}

	@Override
	public HistoryPO toHistroyPO(HistoryVO vo, String orderNum) {
		if (vo == null) {
			return null;
		}
		HistoryPO historyPO = new HistoryPO(vo.time, vo.placeCity, vo.placeOrg,
				vo.isArrive, orderNum);
		return historyPO;
	}

	public ArrayList<HistoryVO> getHistroyVOs(String goodsID)
			throws RemoteException {
		ArrayList<HistoryPO> historyPOs = goodsData.findHistory(goodsID);
		ArrayList<HistoryVO> historyVOs = new ArrayList<HistoryVO>();
		int size = historyPOs.size();
		for (int i = 0; i < size; i++) {
			historyVOs.add(toHistroyVO(historyPOs.get(i)));
		}
		return historyVOs;
	}

	@Override
	public GoodsVO searchGoods(String goodsID) throws RemoteException {
		System.out.println(goodsID);
		GoodsPO po = goodsData.findByNum(goodsID);
		GoodsVO vo = toGoodsVO(po, getHistroyVOs(goodsID));
		return vo;
	}

	@Override
	public ArrayList<GoodsVO> findByStockAreaNum(String stockAreaNum)
			throws RemoteException {
		ArrayList<GoodsPO> goodsPOs = goodsData
				.findByStockAreaNum(stockAreaNum);
		ArrayList<GoodsVO> goodsVOs = new ArrayList<GoodsVO>();
		int size = goodsPOs.size();
		for (int i = 0; i < size; i++) {
			ArrayList<HistoryVO> historyVOs = getHistroyVOs(goodsPOs.get(i)
					.getOrderNum());
			goodsVOs.add(toGoodsVO(goodsPOs.get(i), historyVOs));
		}
		return goodsVOs;
	}

	public ArrayList<GoodsVO> toGoodsVO(ArrayList<GoodsPO> pos)
			throws RemoteException {
		if (pos == null) {
			return null;
		}
		ArrayList<GoodsVO> vos = new ArrayList<GoodsVO>();
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			ArrayList<HistoryPO> histroy = goodsData.findHistory(pos.get(i).getOrderNum());
			vos.add(toGoodsVO(pos.get(i),toHistroyVO(histroy)));
		}
		return vos;
	}
	
	@Override
	public ArrayList<GoodsVO> findGoodsFromArea(String stockAreaNum) throws RemoteException {
		ArrayList<GoodsPO> po = goodsData.findByStockAreaNum(stockAreaNum);
		return toGoodsVO(po);
	}

	@Override
	public ArrayList<HistoryVO> toHistroyVO(ArrayList<HistoryPO> pos) {
		if (pos == null) {
			return null;
		}
		ArrayList<HistoryVO> vos = new ArrayList<HistoryVO>();
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(toHistroyVO(pos.get(i)));
		}
		return vos;
	}

	@Override
	public String findStockAreaNum(String goodsID) throws RemoteException {
		GoodsPO po = goodsData.findByNum(goodsID);
		return po.getStockAreaNum();
	}

	@Override
	public double getCost(String goodsID) throws RemoteException {
//		return 0;
		double cost = 0;
		Receipt_OrderVO order = (Receipt_OrderVO) receiptInfo.findByID(goodsID);
		if (order != null) {
			cost = order.cost;
		}
		return cost;
	}

	@Override
	public ArrayList<GoodsVO> findGoodsByStockNum(String stockNum)
			throws RemoteException {
		ArrayList<GoodsPO> goodsPOs = goodsData.findByStockNum(stockNum);
		ArrayList<GoodsVO> goodsVOs = toGoodsVO(goodsPOs);
		return goodsVOs;
	}

	@Override
	public ResultMessage updateGoods(GoodsPO po) throws RemoteException {
		return goodsData.update(po);
	}

	@Override
	public ArrayList<GoodsPO> findByTransNum(String transNum) throws RemoteException {
		return goodsData.findByTransNum(transNum);
	}

	

}
