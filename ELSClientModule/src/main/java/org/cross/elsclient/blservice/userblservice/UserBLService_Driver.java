//package org.cross.elsclient.blservice.userblservice;
//
//import java.util.ArrayList;
//import org.cross.elscommon.util.ResultMessage;
//import org.cross.elscommon.util.UserType;
//import org.cross.elsclient.vo.UserVO;
//
//public class UserBLService_Driver {
//	
//	public void drive(UserBLService userBLService){
//		
//		ResultMessage result;
//		System.out.print("添加用户返回信息：");
//		result = userBLService.add(new UserVO("12345678","初代奥特曼", UserType.COUNTER));
//		if(result == ResultMessage.SUCCESS){
//			System.out.print("用户添加成功\n");
//		}else{
//			System.out.print("用户添加失败\n");
//		}
//		
//		System.out.print("删除用户返回信息：");
//		result = userBLService.add(new UserVO("12345678", "初代奥特曼", UserType.COUNTER));
//		if(result == ResultMessage.SUCCESS){
//			System.out.print("用户删除成功\n");
//		}else{
//			System.out.print("用户删除失败\n");
//		}
//		
//		System.out.print("修改用户返回信息：");
//		result = userBLService.add(new UserVO("12345678","初代奥特曼", UserType.COUNTER));
//		if(result == ResultMessage.SUCCESS){
//			System.out.print("用户修改成功\n");
//		}else{
//			System.out.print("用户修改失败\n");
//		}
//		
//		System.out.print("显示所有用户：");
//		ArrayList<UserVO> list1 = userBLService.show();
//		for(int i = 0;i<list1.size();i++){
//			System.out.print("用户ID：" + list1.get(i).id + "; ");
//			System.out.print("用户姓名：" + list1.get(i).name + "; ");
//			System.out.print("用户类型：" + list1.get(i).type.toString() + ";\n");
//		}
//		
//		System.out.print("根据ID查找用户：");
//		ArrayList<UserVO> list2 = userBLService.findById("001");
//		for(int i = 0;i<list2.size();i++){
//			System.out.print("用户ID：" + list2.get(i).id + "; ");
//			System.out.print("用户姓名：" + list2.get(i).name + "; ");
//			System.out.print("用户类型：" + list2.get(i).type.toString() + ";\n");
//		}
//		
//		System.out.print("根据姓名查找用户：");
//		ArrayList<UserVO> list3 = userBLService.findByName("奥特之父");
//		for(int i = 0;i<list3.size();i++){
//			System.out.print("用户ID：" + list3.get(i).id + "; ");
//			System.out.print("用户姓名：" + list3.get(i).name + "; ");
//			System.out.print("用户类型：" + list3.get(i).type.toString() + ";\n");
//		}
//		
//		System.out.print("根据类型查找用户：");
//		ArrayList<UserVO> list4 = userBLService.findByType(UserType.COUNTER);
//		for(int i = 0;i<list4.size();i++){
//			System.out.print("用户ID：" + list4.get(i).id + "; ");
//			System.out.print("用户姓名：" + list4.get(i).name + "; ");
//			System.out.print("用户类型：" + list4.get(i).type.toString() + ";\n");
//		}
//		
//		System.out.print("登录结果显示：" + userBLService.login("002", "1111"));
//		
//		System.out.print("注销结果显示：" + userBLService.logout());
//		
//	}
//}
