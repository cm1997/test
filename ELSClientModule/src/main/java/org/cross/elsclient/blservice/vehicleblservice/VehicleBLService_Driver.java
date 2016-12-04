///**
// * 车辆服务驱动程序
// * @author raychen
// * @date 2015/10/20
// */
//package org.cross.elsclient.blservice.vehicleblservice;
//
//import java.util.ArrayList;
//
//import org.cross.elscommon.util.ResultMessage;
//import org.cross.elsclient.vo.VehicleVO;
//
//public class VehicleBLService_Driver {
//	public void drive(VehicleBLService vehicleBLService){
//		ResultMessage resultMessage;
//		System.out.println("添加车辆信息：");
//		resultMessage = vehicleBLService.add(new VehicleVO("00001"));
//		if (resultMessage == ResultMessage.SUCCESS) {
//			System.out.println("信息添加成功");
//		}else {
//			System.out.println("信息添加失败！");
//		}
//		
//		System.out.println("删除车辆信息：");
//		resultMessage = vehicleBLService.delete(new VehicleVO("00001"));
//		if (resultMessage == ResultMessage.SUCCESS) {
//			System.out.println("删除信息成功");
//		}else {
//			System.out.println("删除失败！");
//		}
//		
//		System.out.println("更改车辆信息：");
//		resultMessage = vehicleBLService.update(new VehicleVO("00001"));
//		if (resultMessage == ResultMessage.SUCCESS) {
//			System.out.println("更改信息成功");
//		}else {
//			System.out.println("更改失败！");
//		}
//		
//		System.out.println("查找商品：");
//		ArrayList<VehicleVO> list = vehicleBLService.find("00001");
//		System.out.println("商品编号："+list.get(0).number);
//		
//		System.out.println("显示所有商品商品：");
//		ArrayList<VehicleVO> list2 = vehicleBLService.find("00001");
//		System.out.println("商品编号："+list2.get(0).number);
//	}
//}
