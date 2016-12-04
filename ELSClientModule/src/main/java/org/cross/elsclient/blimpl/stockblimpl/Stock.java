//package org.cross.elsclient.blimpl.stockblimpl;
//
//import java.rmi.RemoteException;
//import java.util.ArrayList;
//
//import org.cross.elsclient.blimpl.accountblimpl.MockLog;
//import org.cross.elsclient.blservice.stockblservice.StockBLService;
//import org.cross.elsclient.demo.StockInfoUI.returnAct;
//import org.cross.elsclient.vo.GoodsVO;
//import org.cross.elsclient.vo.ReceiptVO;
//import org.cross.elsclient.vo.StockAreaVO;
//import org.cross.elsclient.vo.StockOperationVO;
//import org.cross.elsclient.vo.StockVO;
//import org.cross.elscommon.util.ReceiptType;
//import org.cross.elscommon.util.ResultMessage;
//import org.cross.elscommon.util.StockType;
//
//public class Stock {
//
//	public ResultMessage checkGoods(String goodsID, String stockID)
//			throws RemoteException {
//		MockGoods mockGoods = new MockGoods();
//		GoodsVO vo = mockGoods.searchGoods(goodsID);
//		if (vo != null ) {
//			return ResultMessage.SUCCESS;
//		}
//		return ResultMessage.FAILED;
//	}
//
//	public ResultMessage intoStock(String goodsID, String stockID)
//			throws RemoteException {
//		MockReceipt mockReceipt = new MockReceipt();
//		ReceiptVO vo = new ReceiptVO("000001", ReceiptType.STOCKIN, "2015-10-10...");
//		return mockReceipt.add(vo);
//	}
//
//	public ResultMessage outStock(String goodsID, String stockID)
//			throws RemoteException {
//		MockReceipt mockReceipt = new MockReceipt();
//		ReceiptVO vo = new ReceiptVO("000001", ReceiptType.STOCKOUT, "2015-10-10...");
//		return mockReceipt.add(vo);
//	}
//
//	public ResultMessage createLog(String log){
//		MockLog mockLog = new MockLog(log);
//		return mockLog.createLog();
//	}
//	
//	public ResultMessage add(StockVO vo){
//		return ResultMessage.SUCCESS;
//	}
//}
