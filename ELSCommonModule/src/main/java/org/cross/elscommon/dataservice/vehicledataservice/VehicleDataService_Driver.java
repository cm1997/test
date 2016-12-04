///**
// * 车辆数据驱动程序
// * @author raychen
// * @date 2015/10/20
// */
//package org.cross.elscommon.dataservice.vehicledataservice;
//
//import java.rmi.RemoteException;
//
//import org.cross.elscommon.po.VehiclePO;
//
//public class VehicleDataService_Driver {
//	public void drive(VehicleDataService vehicleDataService) throws RemoteException{
//		 System.out.println("车辆信息：");
//		 vehicleDataService.insert(new VehiclePO("00001"));
//		 vehicleDataService.delete(new VehiclePO("00001"));
//		 vehicleDataService.update(new VehiclePO("00001"));
//		 vehicleDataService.find("00001");
//		 vehicleDataService.show();
//	}
//}
