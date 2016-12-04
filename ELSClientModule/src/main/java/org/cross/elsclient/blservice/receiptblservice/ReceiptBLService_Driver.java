///**
// * 单据服务驱动程序
// * @author raychen
// * @date 2015/10/20
// */
//package org.cross.elsclient.blservice.receiptblservice;
//
//import java.util.ArrayList;
//
//import org.cross.elscommon.util.ResultMessage;
//import org.cross.elscommon.util.ReceiptType;
//import org.cross.elsclient.vo.ReceiptVO;
//
//public class ReceiptBLService_Driver {
//	public void drive(ReceiptBLService receiptBLService){
//		
//		ResultMessage result;
//		
//		System.out.println("增加单据的返回信息：");
//		result = receiptBLService.add(new ReceiptVO("R120151023000001", ReceiptType.ORDER, "2015-10-22 10:23:22"));
//		if (result == ResultMessage.SUCCESS) {
//			System.out.println("添加成功！");
//		}else {
//			System.out.println("添加失败");
//		}
//		
//		System.out.println("删除单据的返回信息：");
//		result = receiptBLService.delete(new ReceiptVO("R120151023000001", ReceiptType.ORDER, "2015-10-22 10:23:22"));
//		if (result == ResultMessage.SUCCESS) {
//			System.out.println("删除成功！");
//		}else {
//			System.out.println("删除失败");
//		}
//		
//		System.out.println("修改单据的返回信息：");
//		result = receiptBLService.update(new ReceiptVO("R120151023000001", ReceiptType.ORDER, "2015-10-22 10:23:22"));
//		if (result == ResultMessage.SUCCESS) {
//			System.out.println("修改成功！");
//		}else {
//			System.out.println("修改失败");
//		}
//		
//		System.out.println("根据编号查询单据：");
//		System.out.println(receiptBLService.findByID("R120151023000001"));
//		
//		System.out.println("显示单据信息：");
//		ArrayList<ReceiptVO> list2 = receiptBLService.show();
//		for (int i = 0; i < list2.size(); i++) {
//			System.out.println("单据编号："+list2.get(i).number);
//		}
//
//		System.out.println("根据时间查询单据：");
//		ArrayList<ReceiptVO> list = receiptBLService.findByTime("2015-10-22 10:23:22", "2015-10-23 10:23:22");
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println("单据编号："+list2.get(i).number);
//		}
//
//		System.out.println("根据类型查询单据：");
//		ArrayList<ReceiptVO> list3 = receiptBLService.findByType(ReceiptType.ORDER);
//		for (int i = 0; i < list3.size(); i++) {
//			System.out.println("单据编号："+list3.get(i).number);
//		}
//
//		System.out.println("根据时间和类型查询单据：");
//		ArrayList<ReceiptVO> list4 = receiptBLService.findByTimeAndType("2015-10-22 10:23:22", "2015-10-23 10:23:22", ReceiptType.ORDER);
//		for (int i = 0; i < list4.size(); i++) {
//			System.out.println("单据编号："+list2.get(i).number);
//		}
//		
//		System.out.println("审批情况：");
//		result = receiptBLService.check(new ReceiptVO("00001", ReceiptType.ORDER, "2015-10-22 10:23:22"));
//		if (result ==  ResultMessage.SUCCESS) {
//			System.out.println("审批通过！");
//		}else {
//			System.out.println("审批未通过！");
//		}
//	}
//}
