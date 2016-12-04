/**
 * user真的全部写好了
 */
package org.cross.elsclient.test;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.UserInfo;
import org.cross.elsclient.blimpl.userblimpl.UserBLImpl;
import org.cross.elsclient.blimpl.userblimpl.UserInfoImpl;
import org.cross.elsclient.network.Datafactory;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;
import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.UserType;

public class UserBLTest {

	public static void main(String[] args) throws RemoteException {
		DataFactoryService dataFactory = new Datafactory();
		UserInfo userInfo = new UserInfoImpl(dataFactory.getuserdaData());
		UserBLImpl userBLImpl = new UserBLImpl(dataFactory.getuserdaData(),
				userInfo);

		System.out.println("=======测试addUser========");
		UserVO newVo = new UserVO("U01025003", "123321", "陈丹妮",
				UserType.ADMINISTRATOR, "O02501002");
		ResultMessage addMessage = userBLImpl.add(newVo);
		if (addMessage == ResultMessage.SUCCESS) {
			System.out.println("增加成功");
		} else {
			System.out.println("增加失败");
		}
//		 System.out.println("=======测试deleteUser========");
//		 ResultMessage delMessage = userBLImpl.delete("U01025003");
//		 if (delMessage == ResultMessage.SUCCESS) {
//		 System.out.println("删除成功");
//		 }else {
//		 System.out.println("删除失败");
//		 }
		System.out.println("=======测试updateUser========");
		UserVO upDateVo = new UserVO("U01025003", "123321", "陈丹妮",
				UserType.BUSINESSHALLCLERK, "O02501002");
		ResultMessage updateMessage = userBLImpl.update(upDateVo);
		if (updateMessage == ResultMessage.SUCCESS) {
			System.out.println("更新成功");
		} else {
			System.out.println("更新失败");
		}
		System.out.println("=======测试findByName========");
		ArrayList<UserVO> nameVo = userBLImpl.findByName("陈丹妮");
		int size = nameVo.size();
		for (int i = 0; i < size; i++) {
			System.out.println(nameVo.get(i).number + " " + nameVo.get(i).name
					+ " " + nameVo.get(i).userType.toString());
		}
		if (size == 0) {
			System.out.println("查找失败");
		}
		System.out.println("=======测试findByType========");
		ArrayList<UserVO> typeVo = userBLImpl
				.findByType(UserType.ADMINISTRATOR);
		if (typeVo != null) {
			int size1 = typeVo.size();
			for (int i = 0; i < size1; i++) {
				System.out.println(typeVo.get(i).number + " "
						+ typeVo.get(i).name + " "
						+ typeVo.get(i).userType.toString());
			}
		} else {
			System.out.println("查找失败");
		}
		System.out.println("=======测试findByID========");
		UserVO idVo = userBLImpl.findById("U01025001");
		if (idVo != null) {
			System.out.println(idVo.number + " " + idVo.name + " "
					+ idVo.userType.toString());
		} else {
			System.out.println("查找失败");
		}
		System.out.println("=======测试show========");
		ArrayList<UserVO> show = userBLImpl.show();
		int size2 = show.size();
		for (int i = 0; i < size2; i++) {
			System.out.println(show.get(i).number + " " + show.get(i).name
					+ " " + show.get(i).userType.toString());
		}
		if (size2 == 0) {
			System.out.println("空的");
		}
		System.out.println("=======测试login========");
		UserType userType = userBLImpl.login("U01025003", "123321");
		if (userType == null) {
			System.out.println("登陆失败");
		} else {
			System.out.println(userType.toString());
		}
	}
}
