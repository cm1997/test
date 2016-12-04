package org.cross.elsclient.blimpl.stockblimpl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.cross.elsclient.blimpl.blUtility.GoodsInfo;
import org.cross.elsclient.blimpl.blUtility.ReceiptInfo;
import org.cross.elsclient.blimpl.blUtility.StockInfo;
import org.cross.elsclient.blservice.stockblservice.StockBLService;
import org.cross.elscommon.dataservice.stockdataservice.StockDataService;
import org.cross.elscommon.po.GoodsPO;
import org.cross.elscommon.po.StockAreaPO;
import org.cross.elscommon.po.StockOperationPO;
import org.cross.elscommon.po.StockPO;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StockOperationType;
import org.cross.elscommon.util.StockState;
import org.cross.elscommon.util.StockType;
import org.cross.elsclient.network.Datafactory;
import org.cross.elsclient.vo.GoodsVO;
import org.cross.elsclient.vo.Receipt_OrderVO;
import org.cross.elsclient.vo.StockAreaVO;
import org.cross.elsclient.vo.StockCheckVO;
import org.cross.elsclient.vo.StockSeeVO;
import org.cross.elsclient.vo.StockVO;

public class StockBLImpl implements StockBLService {

	public StockDataService stockData;
	GoodsInfo goodsInfo;
	StockInfo stockInfo;
	ReceiptInfo receiptInfo;

	public StockBLImpl(StockDataService stockData, GoodsInfo goodsInfo,
			StockInfo stockInfo, ReceiptInfo receiptInfo) {
		this.stockData = stockData;
		this.goodsInfo = goodsInfo;
		this.stockInfo = stockInfo;
		this.receiptInfo = receiptInfo;
	}

	@Override
	public ArrayList<StockCheckVO> showStockCheck(String stockID)
			throws RemoteException {
		// Calendar c = Calendar.getInstance();
		// SimpleDateFormat smd = new SimpleDateFormat("y-MM-dd");
		// String time = smd.format(c.getTime());
		ArrayList<StockCheckVO> checkVOs = new ArrayList<StockCheckVO>();
		ArrayList<StockOperationPO> operationPOs = stockData
				.findStockOPByStock(stockID);

		ArrayList<StockAreaPO> areaPO = stockData.findStockAreaByStock(stockID);
		int size = areaPO.size();

		for (int i = 0; i < size; i++) {
//			System.out.println("area num :" + areaPO.get(i).getNumber());
			ArrayList<GoodsVO> goodsPOs = goodsInfo.findGoodsFromArea(areaPO
					.get(i).getNumber());

			if (goodsPOs == null)
				continue;

			int size1 = goodsPOs.size();
//			System.out.println("goods size : " + size1);
			for (int j = 0; j < size1; j++) {
//				System.out.println("instock:"+goodsPOs.get(j).number+" "+areaPO.get(i).getNumber());
				String inTime = "";
				for (int j2 = 0; j2 < operationPOs.size(); j2++) {
					if (operationPOs.get(j2).getGoodsNum().equals(goodsPOs.get(j).number))
						inTime = operationPOs.get(j2).getTime();
				}

				Receipt_OrderVO order = (Receipt_OrderVO) receiptInfo
						.findByID(goodsPOs.get(j).number);
				if (order == null) {
					continue;
				}
				String targetCity = order.receiverAdd;
				StockCheckVO check = new StockCheckVO(goodsPOs.get(j).number,
						inTime, targetCity, areaPO.get(i).getNumber());
				checkVOs.add(check);
//				System.out.println("checkvos size : " + checkVOs.size());
			}
		}
		return checkVOs;
	}

	@Override
	public StockSeeVO showStockInfo(String stockID, String time1, String time2)
			throws RemoteException {
		ArrayList<StockOperationPO> stockOperationPOs = stockData
				.findStockOPByTimeAndStock(stockID, time1, time2);
//		System.out.println("opsize:"+stockOperationPOs.size());
		int totalInStock = stockData.findStockByNumber(stockID).getNumInStock();
		int numIn = 0, numOut = 0, moneyIn = 0, moneyOut = 0;
		int size = stockOperationPOs.size();
		for (int i = 0; i < size; i++) {
			if (stockOperationPOs.get(i).getOpType() == StockOperationType.STOCKIN) {
				numIn++;
				moneyIn += stockOperationPOs.get(i).getMoney();
			} else if (stockOperationPOs.get(i).getOpType() == StockOperationType.STOCKOUT) {
				numOut++;
				moneyOut += stockOperationPOs.get(i).getMoney();
			}
		}
		ArrayList<GoodsVO> goods = goodsInfo.findGoodsByStockNum(stockID);
		StockSeeVO stockSeeVO = new StockSeeVO(numIn, numOut, moneyIn,
				moneyOut, totalInStock, goods);
		return stockSeeVO;
	}

	@Override
	public StockVO findStock(String ID) throws RemoteException {
		StockPO stockPO = stockData.findStockByNumber(ID);
		if (stockPO == null) {
			return null;
		}
		StockVO stockVO = stockInfo.toStockVO(stockPO);
		return stockVO;
	}

	@Override
	public ResultMessage exportStockCheck() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<StockAreaVO> stockCapacity(String id, StockType type)
			throws RemoteException {
		ArrayList<StockAreaVO> vo = new ArrayList<StockAreaVO>();
		StockPO stock = stockData.findStockByNumber(id);
		if (stock == null) {
			return null;
		}
		ArrayList<StockAreaPO> po = stockData.findStockAreaByStock(id);
		if (po == null) {
			return null;
		}
		int size = po.size();
		for (int i = 0; i < size; i++) {
			if (po.get(i).getStockType() == type) {
				vo.add(stockInfo.toStockAreaVO(po.get(i)));
			}
		}
		return vo;
	}

	@Override
	public ResultMessage intoStock(String goodsID, String stockID, String time,
			String stockAreaNum) throws RemoteException {
		ResultMessage updateMessage = ResultMessage.SUCCESS;
		GoodsVO goodsVO = goodsInfo.searchGoods(goodsID);
		if (goodsVO == null) {
//			System.out.println("goodsVo = null");
			return ResultMessage.FAILED;
		}
		String areaNum = goodsInfo.findStockAreaNum(goodsID);
		if ((areaNum != null) && (!areaNum.equals("null")))
			return ResultMessage.FAILED;
		StockPO stockPO = stockData.findStockByNumber(stockID);

		if (stockPO == null) {
			return ResultMessage.FAILED;
		}
		StockAreaPO areaPO = stockData.findStockAreaByNumber(stockAreaNum);
		if (areaPO == null) {
			return ResultMessage.FAILED;
		}
		StockOperationPO operationPO = new StockOperationPO(time,
				StockOperationType.STOCKIN, goodsID,
				goodsInfo.getCost(goodsID), goodsVO.goodsType, stockID,
				stockAreaNum);
		updateMessage = stockData.insertStockOP(operationPO);
		if (updateMessage != ResultMessage.SUCCESS)
			return ResultMessage.FAILED;

		GoodsPO goodsPO = goodsInfo.toGoodsPO(goodsVO);
		goodsPO.setStockAreaNum(stockAreaNum);
		goodsPO.setStockNum(stockID);
		updateMessage = goodsInfo.updateGoods(goodsPO);
		if (updateMessage != ResultMessage.SUCCESS)
			return ResultMessage.FAILED;

		areaPO.setUsedCapacity(areaPO.getUsedCapacity() + 1);
		updateMessage = stockData.updateStockArea(areaPO);
		if (updateMessage != ResultMessage.SUCCESS)
			return ResultMessage.FAILED;

		stockPO.setMoneyIn(stockPO.getMoneyIn() + goodsInfo.getCost(goodsID));
		stockPO.setNumIn(stockPO.getNumIn() + 1);
		stockPO.setNumInStock(stockPO.getNumInStock() + 1);
		updateMessage = stockData.updateStock(stockPO);
		if (updateMessage != ResultMessage.SUCCESS)
			return ResultMessage.FAILED;

		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage outStock(String goodsID, String stockID, String time)
			throws RemoteException {
		ResultMessage stockOut = ResultMessage.SUCCESS;
		String areaNum = goodsInfo.findStockAreaNum(goodsID);
		if (areaNum == null)
			return ResultMessage.FAILED;

		GoodsVO goodsVO = goodsInfo.searchGoods(goodsID);
		if (goodsVO == null)
			return ResultMessage.FAILED;
		StockAreaPO areaPO = stockData.findStockAreaByNumber(areaNum);
		if (areaPO == null)
			return ResultMessage.FAILED;

//		System.out.println("areapo stockNum     " + areaPO.getStockNum());

		if (!areaPO.getStockNum().equals(stockID)) {
			return ResultMessage.FAILED;
		}

		StockOperationPO operationPO = new StockOperationPO(time,
				StockOperationType.STOCKOUT, goodsID,
				goodsInfo.getCost(goodsID), goodsVO.goodsType, stockID, areaNum);
		stockOut = stockData.insertStockOP(operationPO);
		if (stockOut != ResultMessage.SUCCESS)
			return ResultMessage.FAILED;

		GoodsPO goodsPO = goodsInfo.toGoodsPO(goodsVO);
		goodsPO.setStockAreaNum("null");
		goodsPO.setStockNum("null");
		stockOut = goodsInfo.updateGoods(goodsPO);
		if (stockOut != ResultMessage.SUCCESS)
			return ResultMessage.FAILED;

		areaPO.setUsedCapacity(areaPO.getUsedCapacity() - 1);
		stockOut = stockData.updateStockArea(areaPO);
		if (stockOut != ResultMessage.SUCCESS)
			return ResultMessage.FAILED;

		StockPO stockPO = stockData.findStockByNumber(stockID);
		stockPO.setMoneyOut(stockPO.getMoneyOut() + goodsInfo.getCost(goodsID));
		stockPO.setNumOut(stockPO.getNumOut() + 1);
		stockPO.setNumInStock(stockPO.getNumInStock() - 1);
		stockOut = stockData.updateStock(stockPO);
		if (stockOut != ResultMessage.SUCCESS)
			return ResultMessage.FAILED;

		return ResultMessage.SUCCESS;
	}

	@Override
	public StockState stockAlert(String stockID, StockType stockType)
			throws RemoteException {
		ArrayList<StockAreaVO> areaVOs = stockCapacity(stockID, stockType);
		if (areaVOs == null) {
			System.out.println("找不到仓库");
			return StockState.NORMAL;
		}
		int size = areaVOs.size();
		int total = 0;
		int used = 0;
		for (int i = 0; i < size; i++) {
			total += areaVOs.get(i).totalCapacity;
			used += areaVOs.get(i).usedCapacity;
		}
		if (10 * used >= 9 * total) {
			return StockState.ALERT;
		}
		return StockState.NORMAL;
	}

	@Override
	public ResultMessage stockAdjust(String stockAreaID, StockType stockType)
			throws RemoteException {
		StockAreaPO areaPO = stockData.findStockAreaByNumber(stockAreaID);
		if (areaPO == null) {
			return ResultMessage.FAILED;
		}
		areaPO.setStockType(stockType);
		return stockData.updateStockArea(areaPO);
	}

	@Override
	public ResultMessage addStock(StockVO vo) throws RemoteException {
		StockPO po = stockInfo.toStockPO(vo);
		ArrayList<StockAreaPO> areapos = stockInfo
				.toStockAreaPO(vo.stockAreaVOs);
		ResultMessage addStock = stockData.insertStock(po);
		ResultMessage addArea = ResultMessage.SUCCESS;
		for (int i = 0; i < areapos.size(); i++) {
			addArea = stockData.insertStockArea(areapos.get(i));
			if (addArea != ResultMessage.SUCCESS) {
				return ResultMessage.FAILED;
			}
		}
		return addStock;
	}

	// @Override
	// public ResultMessage deleteStock(String stockID) throws RemoteException {
	// return stockData.delete(stockID);
	// }

	@Override
	public ArrayList<String> getChangeableArea(String stockID)
			throws RemoteException {
		ArrayList<String> areaNum = new ArrayList<String>();
		ArrayList<StockAreaPO> areaPOs = stockData
				.findStockAreaByStock(stockID);
		if (areaPOs == null) {
			return null;
		}
		int size = areaPOs.size();
		for (int i = 0; i < size; i++) {
			if (areaPOs.get(i).getUsedCapacity() == 0) {
				areaNum.add(areaPOs.get(i).getNumber());
			}
		}
		return areaNum;
	}

	@Override
	public StockVO findStockByOrg(String orgNum) throws RemoteException {
		StockPO po = stockData.findStockByOrg(orgNum);
		return stockInfo.toStockVO(po);
	}
	

	@Override
	public ArrayList<String> getNeedChange(String stockID)
			throws RemoteException {
		ArrayList<String> type = new ArrayList<String>();
		if (stockAlert(stockID, StockType.COMMON) == StockState.ALERT) {
			type.add("标准快递仓库");
		}
		if (stockAlert(stockID, StockType.Fast) == StockState.ALERT) {
			type.add("特快仓库");
		}
		if (stockAlert(stockID, StockType.ECONOMICAL) == StockState.ALERT) {
			type.add("经济快递仓库");
		}
		return type;
	}

}
