///**
// * 账户管理业务逻辑驱动程序
// * @author Polaris Chen
// * @date 2015/10/19
// */
//package org.cross.elsclient.blservice.accountblservice;
//
//import java.rmi.RemoteException;
//import java.util.ArrayList;
//
//import org.cross.elscommon.util.ResultMessage;
//import org.cross.elsclient.vo.AccountVO;
//
//public class AccountBLService_Driver {
//
//	public void drive(AccountBLService accountBLService) throws RemoteException {
//
//		ResultMessage result;
//		System.out.println("添加账户的返回信息：");
//		result = accountBLService.add(new AccountVO("ICBC账户",
//				"6222201234567654321", 50000));
//		if (result == ResultMessage.SUCCESS)
//			System.out.println("账户添加成功");
//		else
//			System.out.println("账户添加失败");
//
//		System.out.println("删除账户的返回信息：");
//		result = accountBLService.delete(new AccountVO("ICBC账户",
//				"6222201234567654321", 50000));
//		if (result == ResultMessage.SUCCESS)
//			System.out.println("账户删除成功");
//		else
//			System.out.println("账户删除失败");
//
//		System.out.println("更新账户的返回信息：");
//		result = accountBLService.update(new AccountVO("CCB账户",
//				"6222201234567654322", 50000));
//		if (result == ResultMessage.SUCCESS)
//			System.out.println("账户更新成功");
//		else
//			System.out.println("账户更新失败");
//
//		System.out.println("根据名称查找账户：");
//		ArrayList<AccountVO> list1 = accountBLService.find("ICBC账户");
//		System.out.println("账户名称：" + list1.get(0).name + "；银行卡号："
//				+ list1.get(0).account + "；账户余额：" + list1.get(0).balance
//				+ "");
//
//		System.out.println("显示所有账户：");
//		ArrayList<AccountVO> list2 = accountBLService.show();
//		System.out.println("账户名称：" + list2.get(0).name + "；银行卡号："
//				+ list2.get(0).account + "；账户余额：" + list2.get(0).balance
//				+ "");
//		System.out.println("账户名称：" + list2.get(1).name + "；银行卡号："
//				+ list1.get(0).account + "；账户余额：" + list2.get(1).balance
//				+ "");
//
//	}
//}
