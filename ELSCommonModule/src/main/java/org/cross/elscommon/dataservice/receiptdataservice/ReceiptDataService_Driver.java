///**
// * 单据数据驱动程序
// * @author raychen
// * @date 2015/10/20
// */
//package org.cross.elscommon.dataservice.receiptdataservice;
//
//import java.rmi.RemoteException;
//
//import org.cross.elscommon.po.ReceiptPO;
//import org.cross.elscommon.util.ReceiptType;
//
//public class ReceiptDataService_Driver {
//	public void drive(ReceiptDataService receiptDataService) throws RemoteException{
//		System.out.println("单据：");
//		receiptDataService.insert(new ReceiptPO("R120151023000001", ReceiptType.ORDER, "2015-10-22 10:23:22"));
//		receiptDataService.delete(new ReceiptPO("R120151023000001", ReceiptType.ORDER, "2015-10-22 10:23:22"));
//		receiptDataService.update(new ReceiptPO("R120151023000001", ReceiptType.ORDER, "2015-10-22 10:23:22"));
//		receiptDataService.findByID("R120151023000001");
//		receiptDataService.findByTime("2015-10-22 10:23:22", "2015-10-23 10:23:22");
//		receiptDataService.findByType(ReceiptType.ORDER);
//		receiptDataService.findByTimeAndType("2015-10-22 10:23:22", "2015-10-23 10:23:22", ReceiptType.ORDER);
//		receiptDataService.show();
//	}
//}
