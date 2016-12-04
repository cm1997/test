package org.cross.elsclient.blimpl.stockblimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.GoodsInfo;
import org.cross.elsclient.blimpl.blUtility.OrganizationInfo;
import org.cross.elsclient.blimpl.blUtility.StockInfo;
import org.cross.elsclient.vo.GoodsVO;
import org.cross.elsclient.vo.StockAreaVO;
import org.cross.elsclient.vo.StockOperationVO;
import org.cross.elsclient.vo.StockVO;
import org.cross.elscommon.dataservice.stockdataservice.StockDataService;
import org.cross.elscommon.po.StockAreaPO;
import org.cross.elscommon.po.StockOperationPO;
import org.cross.elscommon.po.StockPO;
import org.cross.elscommon.util.ResultMessage;

public class StockInfoImpl implements StockInfo {

	public GoodsInfo goodsInfo;
	public OrganizationInfo orgInfo;
	public StockDataService stockData;

	public StockInfoImpl(StockDataService stockData) {
		this.stockData = stockData;
	}

	public StockInfoImpl(GoodsInfo goodsInfo, OrganizationInfo orgInfo,
			StockDataService stockData) {
		this.goodsInfo = goodsInfo;
		this.orgInfo = orgInfo;
		this.stockData = stockData;
	}

	@Override
	public StockVO toStockVO(StockPO po) throws RemoteException {
		if (po == null) {
			return null;
		}
		ArrayList<StockAreaPO> areaPOs = stockData.findStockAreaByStock(po
				.getNumber());
		ArrayList<StockAreaVO> areaVOs = toStockAreaVO(areaPOs);
		StockVO stockVO = new StockVO(po.getNumber(), po.getTotalAreas(),
				po.getUsedAreas(), po.getNumOut(), po.getNumIn(),
				po.getMoneyOut(), po.getMoneyIn(), po.getNumInStock(),
				po.getOrgNum(), areaVOs);
		return stockVO;
	}

	public ArrayList<StockAreaVO> toStockAreaVO(ArrayList<StockAreaPO> pos)
			throws RemoteException {
		ArrayList<StockAreaVO> vos = new ArrayList<StockAreaVO>();
		if (pos == null) {
			return vos;
		}
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(toStockAreaVO(pos.get(i)));
		}
		return vos;
	}

	@Override
	public StockAreaVO toStockAreaVO(StockAreaPO po) throws RemoteException {
		if (po == null) {
			return null;
		}
		ArrayList<GoodsVO> goodsList = goodsInfo.findByStockAreaNum(po
				.getNumber());
		StockAreaVO vo = new StockAreaVO(po.getNumber(), po.getStockNum(),
				po.getStockType(), po.getTotalCapacity(), po.getUsedCapacity(),
				goodsList);
		vo.usedCapacity = po.getUsedCapacity();
		vo.goodsList = goodsList;

		return vo;
	}

	@Override
	public StockOperationVO toStockOperationVO(StockOperationPO po) {
		if (po == null) {
			return null;
		}
		StockOperationVO stockOperationVO = new StockOperationVO(po.getTime(),
				po.getOpType(), po.getGoodsNum(), po.getMoney(),
				po.getStockType());
		return stockOperationVO;
	}

	@Override
	public StockPO toStockPO(StockVO vo) {
		if (vo == null) {
			return null;
		}
		StockPO stockPO = new StockPO(vo.number, vo.totalAreas, vo.orgNum);
		stockPO.setUsedAreas(vo.usedAreas);
		stockPO.setNumOut(vo.outNum);
		stockPO.setNumIn(vo.inNum);
		stockPO.setMoneyOut(vo.outMoney);
		stockPO.setMoneyIn(vo.inMoney);
		stockPO.setNumInStock(vo.numInStock);
		return stockPO;
	}

	@Override
	public StockAreaPO toStockAreaPO(StockAreaVO vo) {
		if (vo == null) {
			return null;
		}
		StockAreaPO po = new StockAreaPO(vo.number, vo.stockType,
				vo.totalCapacity, vo.stockNum);
		po.setUsedCapacity(vo.usedCapacity);
		return po;
	}

	// @Override
	// public StockOperationPO toStockOperationPO(StockOperationVO vo) {
	// if (vo == null) {
	// return null;
	// }
	// StockOperationPO stockOperationPO = new StockOperationPO(vo.time,
	// vo.type, vo.goodNum, vo.money, vo., vo.,vo.)
	// return stockOperationPO;
	// }

	@Override
	public ArrayList<StockVO> toStockVO(ArrayList<StockPO> pos) throws RemoteException {
		if (pos == null) {
			return null;
		}
		ArrayList<StockVO> vos = new ArrayList<StockVO>();
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(toStockVO(pos.get(i)));
		}
		return vos;
	}

	@Override
	public ArrayList<StockPO> toStockPO(ArrayList<StockVO> vos) {
		if (vos == null) {
			return null;
		}
		ArrayList<StockPO> pos = new ArrayList<StockPO>();
		int size = vos.size();
		for (int i = 0; i < size; i++) {
			pos.add(toStockPO(vos.get(i)));
		}
		return pos;
	}

	@Override
	public ArrayList<StockVO> showStockVOs() throws RemoteException {
		ArrayList<StockPO> pos = stockData.showStock();
		ArrayList<StockVO> vos = toStockVO(pos);
		return vos;
	}

	@Override
	public ArrayList<StockAreaPO> toStockAreaPO(ArrayList<StockAreaVO> vos) {
		ArrayList<StockAreaPO> pos = new ArrayList<StockAreaPO>();
		if (vos == null) {
			return pos;
		}
		int size = vos.size();
		for (int i = 0; i < size; i++) {
			pos.add(toStockAreaPO(vos.get(i)));
		}
		return pos;
	}

	@Override
	public ResultMessage addsto(StockVO sto) {
		StockPO po = toStockPO(sto);
		ArrayList<StockAreaPO> areapos = toStockAreaPO(sto.stockAreaVOs);
		ResultMessage addStock = ResultMessage.FAILED;
		try {
			addStock = stockData.insertStock(po);
			ResultMessage addArea = ResultMessage.SUCCESS;
			for (int i = 0; i < areapos.size(); i++) {
				addArea = stockData.insertStockArea(areapos.get(i));
				if (addArea != ResultMessage.SUCCESS) {
					return ResultMessage.FAILED;
				}
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return addStock;
	}

}
