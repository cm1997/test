///**
// * 仓库管理数据接口的驱动程序
// * @author danni
// * @date 2015/10/22
// */
//package org.cross.elscommon.dataservice.stockdataservice;
//
//import java.rmi.RemoteException;
//
//import org.cross.elscommon.po.StockPO;
//
//public class StockDataService_Driver {
//	public void driver(StockDataService stockDataService) throws RemoteException{
//		
//		StockPO stockPO = new StockPO("S00001",30);
//		
//		System.out.println("增加仓库");
//		stockDataService.insert(stockPO);
//		
//		System.out.println("删除仓库");
//		stockDataService.delete("S00001");
//		
//		System.out.println("更新仓库");
//		stockDataService.update(stockPO);
//		
//		System.out.println("显示仓库操作信息");
//		stockDataService.show("2015-10-25 10:10:10", "2015-10-26 10:10:10");
//		
//		System.out.println("模糊查找快件");
//		stockDataService.find("63247893");
//		
//		System.out.println("寻找仓库");
//		stockDataService.findStock("00001");
//	}
//
//}
