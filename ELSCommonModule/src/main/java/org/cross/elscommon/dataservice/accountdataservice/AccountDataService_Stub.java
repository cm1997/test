///**
// * 账户管理数据桩程序
// * @author Polaris Chen
// * @date 2015/10/19
// */
//package org.cross.elscommon.dataservice.accountdataservice;
//
//import java.rmi.RemoteException;
//import java.util.ArrayList;
//
//import org.cross.elscommon.po.AccountPO;
//import org.cross.elscommon.util.ResultMessage;
//
//public class AccountDataService_Stub implements AccountDataService {
//
//	@Override
//	public ArrayList<AccountPO> find(String name) throws RemoteException {
//		ArrayList<AccountPO> list = new ArrayList<AccountPO>();
//		list.add(new AccountPO(name, "6222201234567654321", 50000));
//		return list;
//	}
//
//	@Override
//	public ResultMessage insert(AccountPO po) throws RemoteException {
//		System.out.println("增加账户成功");
//		return ResultMessage.SUCCESS;
//	}
//
//	@Override
//	public ResultMessage delete(AccountPO po) throws RemoteException {
//		if (po.getName().equals("ICBC账户")) {
//			System.out.println("删除账户成功");
//			return ResultMessage.SUCCESS;
//		}
//		System.out.println("删除账户失败");
//		return ResultMessage.FAILED;
//	}
//
//	@Override
//	public ResultMessage update(AccountPO po) throws RemoteException {
//		if (po.getName().equals("ICBC账户")) {
//			System.out.println("更新账户成功");
//			return ResultMessage.SUCCESS;
//		}
//		System.out.println("更新账户失败");
//		return ResultMessage.FAILED;
//	}
//
//	@Override
//	public ArrayList<AccountPO> show() throws RemoteException {
//		ArrayList<AccountPO> list = new ArrayList<AccountPO>();
//		list.add(new AccountPO("ICBC账户", "6222201234567654321", 50000));
//		list.add(new AccountPO("CCB账户", "6222201234567654322", 50000));
//		return list;
//	}
//
//}
