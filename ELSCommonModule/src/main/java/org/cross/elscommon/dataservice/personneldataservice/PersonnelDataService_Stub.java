///**
// * 人员管理数据桩程序
// * @author Polaris Chen
// * @date 2015/10/19
// */
//package org.cross.elscommon.dataservice.personneldataservice;
//
//import java.rmi.RemoteException;
//import java.util.ArrayList;
//
//import org.cross.elscommon.po.PersonnelPO;
//import org.cross.elscommon.util.OrganizationType;
//import org.cross.elscommon.util.PositionType;
//import org.cross.elscommon.util.ResultMessage;
//
//public class PersonnelDataService_Stub implements PersonnelDataService {
//
//	@Override
//	public ResultMessage insert(PersonnelPO po) throws RemoteException {
//		System.out.println("增加人员成功");
//		return ResultMessage.SUCCESS;
//	}
//
//	@Override
//	public ResultMessage delete(PersonnelPO po) throws RemoteException {
//		System.out.println("删除人员成功");
//		return ResultMessage.SUCCESS;
//	}
//
//	@Override
//	public ResultMessage update(PersonnelPO po) throws RemoteException {
//		System.out.println("更新人员成功");
//		return ResultMessage.SUCCESS;
//	}
//
//	@Override
//	public ArrayList<PersonnelPO> findByName(String name) throws RemoteException {
//		ArrayList<PersonnelPO> poList = new ArrayList<PersonnelPO>();
//		poList.add(new PersonnelPO("00001", name, PositionType.COUNTER, OrganizationType.BUSINESSHALL,"0000000001"));
//
//		return poList;
//	}
//
//	@Override
//	public ArrayList<PersonnelPO> findById(String id) throws RemoteException {
//		ArrayList<PersonnelPO> poList = new ArrayList<PersonnelPO>();
//		poList.add(new PersonnelPO(id, "杰利", PositionType.COUNTER,OrganizationType.BUSINESSHALL,"0000000001"));
//
//		return poList;
//	}
//
//	@Override
//	public ArrayList<PersonnelPO> show() throws RemoteException {
//		ArrayList<PersonnelPO> poList = new ArrayList<PersonnelPO>();
//		poList.add(new PersonnelPO("00001", "杰利", PositionType.COUNTER, OrganizationType.BUSINESSHALL, "0000000001"));
//
//		return poList;
//	}
//
//}
