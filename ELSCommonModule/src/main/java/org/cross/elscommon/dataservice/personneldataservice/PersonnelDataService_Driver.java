///**
// * 人员管理数据驱动程序
// * @author Polaris Chen
// * @date 2015/10/19
// */
//package org.cross.elscommon.dataservice.personneldataservice;
//
//import java.rmi.RemoteException;
//import java.util.ArrayList;
//
//import org.cross.elscommon.po.PersonnelPO;
//import org.cross.elscommon.util.PositionType;
//
//public class PersonnelDataService_Driver {
//	public void drive(PersonnelDataService personnelDataService) throws RemoteException {
//		PersonnelPO po = new PersonnelPO("00001", "杰利", PositionType.COUNTER);
//		personnelDataService.insert(po);
//		personnelDataService.delete(po);
//		personnelDataService.update(po);
//
//		System.out.println("显示按工号查找的结果：");
//		ArrayList<PersonnelPO> poList = new ArrayList<PersonnelPO>();
//		poList = personnelDataService.findById("00001");
//		System.out.println(poList.get(0).getName());
//
//		System.out.println("显示按姓名查找的结果：");
//		poList = personnelDataService.findByName("杰利");
//		System.out.println(poList.get(0).getName());
//
//		System.out.println("显示人员：");
//		poList = personnelDataService.show();
//		System.out.println(poList.get(0).getName());
//	}
//
//}
