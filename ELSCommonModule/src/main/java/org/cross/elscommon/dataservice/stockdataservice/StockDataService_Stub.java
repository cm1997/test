//package org.cross.elscommon.dataservice.stockdataservice;
//
//import java.rmi.RemoteException;
//import java.util.ArrayList;
//
//import org.cross.elscommon.po.GoodsPO;
//import org.cross.elscommon.po.Receipt_OrderPO;
//import org.cross.elscommon.po.StockAreaPO;
//import org.cross.elscommon.po.StockOperationPO;
//import org.cross.elscommon.po.StockPO;
//import org.cross.elscommon.util.City;
//import org.cross.elscommon.util.ResultMessage;
//import org.cross.elscommon.util.StockOperationType;
//import org.cross.elscommon.util.StockType;
//
//public class StockDataService_Stub implements StockDataService{
//	public ArrayList<StockOperationPO> stockOperations;
//	public ArrayList<StockPO> stocks;
//	public ArrayList<StockAreaPO> stockAreas;
//
//	@Override
//	public ResultMessage insert(StockPO po) {
//		// TODO Auto-generated method stub
//		System.out.println("~~~insert successfully~~~");
//		return ResultMessage.SUCCESS;
//	}
//
//	@Override
//	public ResultMessage delete(String id) {
//		// TODO Auto-generated method stub
//		System.out.println("~~~delete successfully~~~");
//		return ResultMessage.SUCCESS;
//	}
//
//	@Override
//	public ResultMessage update(StockPO po) {
//		// TODO Auto-generated method stub
//		System.out.println("~~~update successfully~~~");
//		return ResultMessage.SUCCESS;
//	}
//
//	@Override
//	public boolean find(String id) throws RemoteException {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public ArrayList<StockOperationPO> show(String startTime, String endTime) throws RemoteException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public StockPO findStock(String ID) throws RemoteException {
//		// TODO Auto-generated method stub
//		//增加仓库
//		stocks = new ArrayList<StockPO>();
//		StockPO stock1 = new StockPO("00001", 10);
//		StockPO stock2 = new StockPO("00002", 10);
//		StockPO stock3 = new StockPO("00003", 10);
//		stocks.add(stock1);
//		stocks.add(stock2);
//		stocks.add(stock3);
//		
//		//增加隔间
//		stockAreas = new ArrayList<StockAreaPO>();
//		StockAreaPO area1 = new StockAreaPO(StockType.COMMON, 100);
//		StockAreaPO area2 = new StockAreaPO(StockType.Fast, 100);
//		StockAreaPO area3 = new StockAreaPO(StockType.ECONOMICAL, 100);
//		stockAreas.add(area1);
//		stockAreas.add(area2);
//		stockAreas.add(area3);
//		stock1.setSpecialStockPOs(stockAreas);
//		stock2.setSpecialStockPOs(stockAreas);
//		stock3.setSpecialStockPOs(stockAreas);
//		
//		//增加操作
//		stockOperations = new ArrayList<StockOperationPO>();
//		GoodsPO good1 = new GoodsPO(20, 20, City.BEIJING,StockType.COMMON);
//		GoodsPO good2 = new GoodsPO(20, 20, City.BEIJING,StockType.COMMON);
//		GoodsPO good3 = new GoodsPO(20, 20, City.BEIJING,StockType.COMMON);
//		GoodsPO good4 = new GoodsPO(20, 20, City.BEIJING,StockType.COMMON);
//		Receipt_OrderPO order1 = new Receipt_OrderPO("R120151023000001", "2015-10-25 01:10:10");
//		Receipt_OrderPO order2 = new Receipt_OrderPO("R120151023000002", "2015-10-25 10:10:10");
//		Receipt_OrderPO order3 = new Receipt_OrderPO("R120151023000003", "2015-10-25 10:10:10");
//		Receipt_OrderPO order4 = new Receipt_OrderPO("R120151023000004", "2015-10-25 10:10:10");
//		good1.setOrderPO(order1);
//		good2.setOrderPO(order2);
//		good3.setOrderPO(order3);
//		good4.setOrderPO(order4);
//		StockOperationPO op1 = new StockOperationPO("2015-10-25 10:10:10", StockOperationType.STOCKIN, 
//				good1, 20, StockType.COMMON);
//		StockOperationPO op2 = new StockOperationPO("2015-10-26 09:10:10", StockOperationType.STOCKIN, 
//				good2, 30, StockType.COMMON);
//		StockOperationPO op3 = new StockOperationPO("2015-10-25 22:10:10", StockOperationType.STOCKIN, 
//				good3, 40, StockType.COMMON);
//		StockOperationPO op4 = new StockOperationPO("2015-10-26 10:11:10", StockOperationType.STOCKOUT, 
//				good4, 20, StockType.COMMON);
//		stockOperations.add(op1);
//		stockOperations.add(op2);
//		stockOperations.add(op3);
//		stockOperations.add(op4);
//		stock1.setStockOperations(stockOperations);
//		stock2.setStockOperations(stockOperations);
//		stock3.setStockOperations(stockOperations);
//		for (int i = 0; i < stocks.size(); i++) {
//			if(stocks.get(i).getStockID().equals(ID)) return stocks.get(i);
//		}
////		return stock1;
//		return null;
//	}
//
//}
