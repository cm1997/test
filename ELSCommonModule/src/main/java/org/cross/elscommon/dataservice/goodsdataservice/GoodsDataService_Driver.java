///**
// * 快件管理数据接口的驱动程序
// * @author danni
// * @date 2015/10/22
// */
//package org.cross.elscommon.dataservice.goodsdataservice;
//
//import java.rmi.RemoteException;
//
//import org.cross.elscommon.po.GoodsPO;
//import org.cross.elscommon.po.Receipt_OrderPO;
//import org.cross.elscommon.util.City;
//import org.cross.elscommon.util.StockType;
//
//public class GoodsDataService_Driver {
//	public void driver(GoodsDataService goodsDataService) throws RemoteException{
//		
//		GoodsPO goods = new GoodsPO(45, 43, City.NANJING,StockType.COMMON);
//		Receipt_OrderPO receipt = new Receipt_OrderPO("R120151023000004", "2015-10-25 10:10:10");
//		goods.setOrderNumber(receipt.getNumber());
//		
//		System.out.println("更新快件信息");
//		goodsDataService.update(goods);
//		
//		System.out.println("按编号查找并显示快件信息");
//		goodsDataService.show(goods.getOrderNumber());
//	}
//
//}
