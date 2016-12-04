///**
// * 账户管理数据驱动程序
// * @author Polaris Chen
// * @date 2015/10/19
// */
//package org.cross.elscommon.dataservice.accountdataservice;
//
//import java.rmi.RemoteException;
//
//import org.cross.elscommon.po.AccountPO;
//
//public class AccountDataService_Driver {
//
//	public void drive(AccountDataService accountDataService)
//			throws RemoteException {
//
//		AccountPO po1 = new AccountPO("ICBC账户", "6222201234567654321", 50000);
//		AccountPO po2 = new AccountPO("CCB账户", "6222201234567654322", 50000);
//		accountDataService.find("ICBC账户");
//
//		System.out.println("账户处理消息：");
//		accountDataService.insert(po1);
//		accountDataService.delete(po1);
//		accountDataService.delete(po2);
//		accountDataService.update(po1);
//		accountDataService.update(po2);
//		accountDataService.show();
//
//	}
//}
