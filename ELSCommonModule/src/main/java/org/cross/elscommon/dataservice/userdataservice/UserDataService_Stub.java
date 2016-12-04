//package org.cross.elscommon.dataservice.userdataservice;
//
//import java.util.ArrayList;
//
//import org.cross.elscommon.po.UserPO;
//import org.cross.elscommon.util.ResultMessage;
//import org.cross.elscommon.util.UserType;
//
//public class UserDataService_Stub implements UserDataService {
//
//	@Override
//	public ResultMessage insert(UserPO po) {
//		System.out.println("Insert Succeed!\n");
//		return ResultMessage.SUCCESS;
//	}
//
//	@Override
//	public ResultMessage delete(UserPO po) {
//		System.out.println("Delete Succeed!\n");
//		return ResultMessage.SUCCESS;
//	}
//
//	@Override
//	public ResultMessage update(UserPO po) {
//		System.out.println("Update Succeed!\n");
//		return ResultMessage.SUCCESS;
//	}
//
//	@Override
//	public ArrayList<UserPO> findById(String id) {
//		System.out.println("FindById Succeed!\n");
//		ArrayList<UserPO> list = new ArrayList<UserPO>();
//		list.add(new UserPO("12345678","艾斯奥特曼", UserType.BUSINESSHALLCLERK));
//		return list;
//	}
//
//	@Override
//	public ArrayList<UserPO> findByType(UserType type) {
//		System.out.println("FindById Succeed!\n");
//		ArrayList<UserPO> list = new ArrayList<UserPO>();
//		list.add(new UserPO("12345678", "泰罗奥特曼", type));
//		return list;
//	}
//
//	@Override
//	public ArrayList<UserPO> findByName(String name) {
//		System.out.println("FindById Succeed!\n");
//		ArrayList<UserPO> list = new ArrayList<UserPO>();
//		list.add(new UserPO("12345678", name, UserType.BUSINESSHALLCLERK));
//		return list;
//	}
//
//	@Override
//	public ArrayList<UserPO> show() {
//		System.out.println("FindById Succeed!\n");
//		ArrayList<UserPO> list = new ArrayList<UserPO>();
//		list.add(new UserPO("12345678","佐菲奥特曼", UserType.BUSINESSHALLCLERK));
//		return list;
//	}
//
//}
