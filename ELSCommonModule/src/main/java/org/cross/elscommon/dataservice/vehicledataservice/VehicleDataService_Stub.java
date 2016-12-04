///**
// * 车辆数据桩程序
// * @author raychen
// * @date 2015/10/20
// */
//package org.cross.elscommon.dataservice.vehicledataservice;
//
//import java.util.ArrayList;
//
//import org.cross.elscommon.po.VehiclePO;
//import org.cross.elscommon.util.ResultMessage;
//
//public class VehicleDataService_Stub implements VehicleDataService{
//
//	@Override
//	public ResultMessage insert(VehiclePO po) {
//		// TODO Auto-generated method stub
//		if (po.getNumber() == "00001") {
//			System.out.println("insert succeed!");
//		}else {
//			System.out.println("insert failed");
//		}
//		return ResultMessage.SUCCESS;
//	}
//
//	@Override
//	public ResultMessage delete(VehiclePO po) {
//		// TODO Auto-generated method stub
//		if (po.getNumber() == "00001") {
//			System.out.println("delete succeed!");
//		}else {
//			System.out.println("delete failed");
//		}
//		return ResultMessage.SUCCESS;
//	}
//
//	@Override
//	public ResultMessage update(VehiclePO po) {
//		// TODO Auto-generated method stub
//		System.out.println("update succeed!");
//		return ResultMessage.SUCCESS;
//	}
//
//	@Override
//	public ArrayList<VehiclePO> show() {
//		// TODO Auto-generated method stub
//		ArrayList<VehiclePO> list = new ArrayList<VehiclePO>();
//		list.add(new VehiclePO("00001"));
//		list.add(new VehiclePO("00002"));
//		return list;
//	}
//
//	@Override
//	public ArrayList<VehiclePO> find(String name) {
//		// TODO Auto-generated method stub
//		ArrayList<VehiclePO> list = new ArrayList<VehiclePO>();
//		list.add(new VehiclePO("00001"));
//		return list;
//	}
//	
//}
