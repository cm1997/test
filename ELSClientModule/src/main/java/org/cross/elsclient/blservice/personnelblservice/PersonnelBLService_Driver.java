///**
// * 人员管理业务逻辑驱动程序
// * @author Polaris Chen
// * @date 2015/10/19
// */
//package org.cross.elsclient.blservice.personnelblservice;
//
//import java.util.ArrayList;
//
//import org.cross.elscommon.util.PositionType;
//import org.cross.elscommon.util.ResultMessage;
//import org.cross.elsclient.vo.PersonnelVO;
//
//public class PersonnelBLService_Driver {
//	public void drive(PersonnelBLService personnelBLService) {
//		PersonnelVO vo = new PersonnelVO("00001", "杰利", PositionType.COUNTER);
//
//		ResultMessage result;
//		result = personnelBLService.add(vo);
//		if (result == ResultMessage.SUCCESS)
//			System.out.println("添加人员成功");
//
//		result = personnelBLService.delete(vo);
//		if (result == ResultMessage.SUCCESS)
//			System.out.println("删除人员成功");
//
//		result = personnelBLService.update(vo);
//		if (result == ResultMessage.SUCCESS)
//			System.out.println("更新人员成功");
//		
//		ArrayList<PersonnelVO> voList;
//		voList = personnelBLService.findById("00001");
//		System.out.println(voList.get(0).name);
//
//		voList = personnelBLService.findByName("杰利");
//		System.out.println(voList.get(0).id);
//
//		voList = personnelBLService.show();
//		System.out.println(voList.get(0).name);
//		System.out.println(voList.get(1).name);
//	}
//
//}
