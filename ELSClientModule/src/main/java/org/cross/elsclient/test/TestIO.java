//package org.cross.elsclient.test;
//
//import java.rmi.RemoteException;
//import java.util.ArrayList;
//
//import org.cross.elsclient.network.Datafactory;
//import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;
//import org.cross.elscommon.dataservice.goodsdataservice.GoodsDataService;
//import org.cross.elscommon.dataservice.stockdataservice.StockDataService;
//import org.cross.elscommon.po.GoodsPO;
//import org.cross.elscommon.po.HistoryPO;
//import org.cross.elscommon.po.Receipt_OrderPO;
//import org.cross.elscommon.po.StockAreaPO;
//import org.cross.elscommon.po.StockPO;
//import org.cross.elscommon.util.City;
//import org.cross.elscommon.util.SerIO;
//import org.cross.elscommon.util.StockType;
//
//public class TestIO {
//	public static void main(String[] args) throws RemoteException {
////		HistoryPO h1 = new HistoryPO("2013", City.BEIJING);
////		HistoryPO h2 = new HistoryPO("2012", City.NANJING);
////		ArrayList<HistoryPO> hs = new ArrayList<HistoryPO>();
////		hs.add(h1);
////		hs.add(h2);
////		SerIO.writePO(hs, "History.ser");
////		ArrayList<HistoryPO> obs = (ArrayList<HistoryPO>)SerIO.readPO("History.ser");
////		System.out.println(obs.get(0).getTime());
//		DataFactoryService datafactory = new Datafactory();
//		//---------------------Goods----------------------------
//
//		GoodsPO good1 = new GoodsPO(20, 20, City.BEIJING,StockType.COMMON);
//		GoodsPO good2 = new GoodsPO(20, 20, City.BEIJING,StockType.COMMON);
//		GoodsPO good3 = new GoodsPO(20, 20, City.BEIJING,StockType.COMMON);
//		GoodsPO good4 = new GoodsPO(20, 20, City.BEIJING,StockType.Fast);
//		Receipt_OrderPO order1 = new Receipt_OrderPO("R120151023000001", "2015-10-25 01:10:10");
//		Receipt_OrderPO order2 = new Receipt_OrderPO("R120151023000002", "2015-10-25 02:10:10");
//		Receipt_OrderPO order3 = new Receipt_OrderPO("R120151023000003", "2015-10-25 03:10:10");
//		Receipt_OrderPO order4 = new Receipt_OrderPO("R120151023000004", "2015-10-25 04:10:10");
//		good1.setOrderNumber(order1.getNumber());
//		good2.setOrderNumber(order2.getNumber());
//		good3.setOrderNumber(order3.getNumber());
//		good4.setOrderNumber(order4.getNumber());
//		good1.setHistoryPO(new HistoryPO(order1.getTime(), good1.getCurrentLocate()));
//		good2.setHistoryPO(new HistoryPO(order2.getTime(), good2.getCurrentLocate()));
//		good3.setHistoryPO(new HistoryPO(order3.getTime(), good3.getCurrentLocate()));
//		good4.setHistoryPO(new HistoryPO(order4.getTime(), good4.getCurrentLocate()));
//		
//		GoodsDataService goodsdata = datafactory.getGoodsData();
//		goodsdata.insert(good1);
//		goodsdata.insert(good2);
//		goodsdata.insert(good3);
//		goodsdata.insert(good4);
//		
//		System.out.println(good1.getOrderNumber()+"++++++++++++");
//		GoodsPO goods = goodsdata.show("R120151023000002");
//		System.out.println(goods.getOrderNumber());
//		
//		System.out.println("goodsok");
//		
//	    //----------------------Stock---------------------------
//		StockPO stock1 = new StockPO("S00001", 10);
//		StockPO stock2 = new StockPO("S00002", 10);
//		StockPO stock3 = new StockPO("S00003", 10);
//		
//		ArrayList<StockAreaPO> stockAreaPOs1 = new ArrayList<StockAreaPO>();
//		ArrayList<StockAreaPO> stockAreaPOs2 = new ArrayList<StockAreaPO>();
//		ArrayList<StockAreaPO> stockAreaPOs3 = new ArrayList<StockAreaPO>();
//		StockAreaPO stock_1_fast = new StockAreaPO(StockType.Fast, 1000);
//		StockAreaPO stock_1_common = new StockAreaPO(StockType.COMMON, 1000);
//		StockAreaPO stock_1_economical = new StockAreaPO(StockType.ECONOMICAL, 1000);
//		StockAreaPO stock_2_fast = new StockAreaPO(StockType.Fast, 1000);
//		StockAreaPO stock_2_common = new StockAreaPO(StockType.COMMON, 1000);
//		StockAreaPO stock_2_economical = new StockAreaPO(StockType.ECONOMICAL, 1000);
//		StockAreaPO stock_3_fast = new StockAreaPO(StockType.Fast, 1000);
//		StockAreaPO stock_3_common = new StockAreaPO(StockType.COMMON, 1000);
//		StockAreaPO stock_3_economical = new StockAreaPO(StockType.ECONOMICAL, 1000);
//		stockAreaPOs1.add(stock_1_fast);
//		stockAreaPOs1.add(stock_1_common);
//		stockAreaPOs1.add(stock_1_economical);
//		stock1.setUsedArea(stock1.getUsedArea() + 3);
//		stockAreaPOs2.add(stock_2_fast);
//		stockAreaPOs2.add(stock_2_common);
//		stockAreaPOs2.add(stock_2_economical);
//		stock1.setUsedArea(stock1.getUsedArea() + 3);
//		stockAreaPOs3.add(stock_3_fast);
//		stockAreaPOs3.add(stock_3_common);
//		stockAreaPOs3.add(stock_3_economical);
//		stock1.setUsedArea(stock1.getUsedArea() + 3);
//		stock1.setSpecialStockPOs(stockAreaPOs1);
//		stock2.setSpecialStockPOs(stockAreaPOs2);
//		stock3.setSpecialStockPOs(stockAreaPOs3);
//
//		StockDataService stockDataService = datafactory.getStockData();
//		stockDataService.insert(stock1);
//		stockDataService.insert(stock2);
//		stockDataService.insert(stock3);
//		
//		StockPO stock = stockDataService.findStock("S00002");
//		System.out.println(stock.getStockID());
//	}
//}
