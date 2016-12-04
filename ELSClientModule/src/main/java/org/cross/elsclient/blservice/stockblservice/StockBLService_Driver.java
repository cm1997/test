///**
// * 库存管理业务逻辑的驱动程序
// * @author danni
// * @date 2015/10/20
// */
//package org.cross.elsclient.blservice.stockblservice;
//
//import java.util.ArrayList;
//
//import org.cross.elscommon.util.ResultMessage;
//import org.cross.elscommon.util.StockType;
//import org.cross.elsclient.vo.StockAreaVO;
//import org.cross.elsclient.vo.StockOperationVO;
//import org.cross.elsclient.vo.StockVO;
//
//public class StockBLService_Driver {
//	public void drive(StockBLService stockBLService){
//		
//		System.out.println("~~~生成库存快照~~~");
//		ArrayList<StockVO> stocks = stockBLService.showStockCheck();
////		System.out.println("仓库类型 ： " + stocks.get(0).stockType);
//		System.out.println("仓库总容量 ： " + stocks.get(0).numOfBooths);
//		System.out.println("仓库已用容量 ： " + stocks.get(0).usedBooths);
////		System.out.println("仓库中存放的快递 ： " + stocks.get(0).goodsList.get(0));
//			
//		System.out.println("~~~库存查看~~~");
//		ArrayList<StockOperationVO> list = stockBLService.showStockInfo("2015-10-22 10:23:22", "2015-10-22 10:26:22");
////		System.out.println("起始时间 ： " + list.get(0).startTime);
////		System.out.println("终止时间 ： " + list.get(0).endTime);
////		System.out.println("出库数量 ： " + list.get(0).numOut);
////		System.out.println("出库数量 ： " + list.get(0).numIn);
////		System.out.println("出库金额 ： " + list.get(0).moneyOut);
////		System.out.println("入库金额 ： " + list.get(0).moneyIn);
////		System.out.println("库存数量 ： " + list.get(0).numInStock);
//		System.out.println("存储位置 ： ");
//		
//		System.out.println("~~~导出库存信息表格~~~");
//		ResultMessage resultMessage = stockBLService.exportStockCheck();
//		if (resultMessage == ResultMessage.SUCCESS) {
//			System.out.println("导出成功");
//		}else{
//			System.out.println("导出失败");
//		}
//		
//		System.out.println("~~~查询特定仓库是否有空余~~~");
////		ResultMessage ifEnough = stockBLService.stockEnough(StockType.Fast);
////		if (ifEnough == ResultMessage.SUCCESS) {
////			System.out.println("有空余的");
////		}else{
////			System.out.println("没有空余了");
////		}
//		
//		System.out.println("~~~查询特定仓库容量信息~~~");
////		StockAreaVO stockCapacity = stockBLService.stockCapacity(StockType.Fast);
//		StockAreaVO tempAreaVO = new StockAreaVO(StockType.Fast, 100);
//		System.out.println("仓库类型 ： " + tempAreaVO.stockType.toString());
//		System.out.println("仓库总容量 ： " + tempAreaVO.totalCapacity);
//		System.out.println("仓库已用容量 ： " + tempAreaVO.usedCapacity);
//		
//		System.out.println("~~~核实快件信息~~~");
//		ResultMessage goodsMessage = stockBLService.checkGoods("R120151020000002");
//		if (goodsMessage == ResultMessage.SUCCESS) {
//			System.out.println("快件在仓库里");
//		}else{
//			System.out.println("快件不在仓库里");
//		}
//		
//
//		System.out.println("~~~快件入库~~~");
//		ResultMessage intoStockMessage = stockBLService.intoStock("1234567778");
//		if (intoStockMessage == ResultMessage.SUCCESS) {
//			System.out.println("入库成功");
//		}else{
//			System.out.println("入库失败");
//		}
//		
//		System.out.println("~~~快件出库~~~");
//		ResultMessage outStockMessage = stockBLService.outStock("1234567778");
//		if (outStockMessage == ResultMessage.SUCCESS) {
//			System.out.println("出库成功");
//		}else{
//			System.out.println("出库失败");
//		}
//	}
//	
//}
