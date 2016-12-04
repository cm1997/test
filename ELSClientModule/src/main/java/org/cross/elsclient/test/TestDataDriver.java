//package org.cross.elsclient.test;
//
//import java.rmi.RemoteException;
//
//import org.cross.elscommon.dataservice.accountdataservice.AccountDataService_Driver;
//import org.cross.elscommon.dataservice.accountdataservice.AccountDataService_Stub;
//import org.cross.elscommon.dataservice.constantdataservice.ConstantDataService_Driver;
//import org.cross.elscommon.dataservice.constantdataservice.ConstantDataService_Stub;
//import org.cross.elscommon.dataservice.goodsdataservice.GoodsDataService_Driver;
//import org.cross.elscommon.dataservice.goodsdataservice.GoodsDataService_Stub;
//import org.cross.elscommon.dataservice.initialdataservice.InitialDataService_Driver;
//import org.cross.elscommon.dataservice.initialdataservice.InitialDataService_Stub;
//import org.cross.elscommon.dataservice.logdataservice.LogDataService_Driver;
//import org.cross.elscommon.dataservice.logdataservice.LogDataService_Stub;
//import org.cross.elscommon.dataservice.organizationdataservice.OrganizationDataService_Driver;
//import org.cross.elscommon.dataservice.organizationdataservice.OrganizationDataService_Stub;
////import org.cross.elscommon.dataservice.personneldataservice.PersonnelDataService_Driver;
////import org.cross.elscommon.dataservice.personneldataservice.PersonnelDataService_Stub;
//import org.cross.elscommon.dataservice.receiptdataservice.ReceiptDataService_Driver;
//import org.cross.elscommon.dataservice.receiptdataservice.ReceiptDataService_Stub;
//import org.cross.elscommon.dataservice.stockdataservice.StockDataService_Driver;
//import org.cross.elscommon.dataservice.userdataservice.UserDataService_Driver;
//import org.cross.elscommon.dataservice.userdataservice.UserDataService_Stub;
//import org.cross.elscommon.dataservice.vehicledataservice.VehicleDataService_Driver;
//import org.cross.elscommon.dataservice.vehicledataservice.VehicleDataService_Stub;
//
//public class TestDataDriver {
//	public static void main(String [] args) throws RemoteException{
//		System.out.println("测试驱动开始");
//		System.out.println("-----------------------------");
//		
//		System.out.println("账户管理驱动测试：");
//		System.out.println("-----------------------------");
//		AccountDataService_Driver accountDataDriver = new AccountDataService_Driver();
//		accountDataDriver.drive(new AccountDataService_Stub());
//		System.out.println("-----------------------------");
//
//		System.out.println("制定常量驱动测试：");
//		System.out.println("-----------------------------");
//		ConstantDataService_Driver constantDataDriver = new ConstantDataService_Driver();
//		constantDataDriver.drive(new ConstantDataService_Stub());
//		System.out.println("-----------------------------");
//
//		System.out.println("快件管理驱动测试：");
//		System.out.println("-----------------------------");
//		GoodsDataService_Driver goodsDataDriver = new GoodsDataService_Driver();
//		goodsDataDriver.driver(new GoodsDataService_Stub());
//		System.out.println("-----------------------------");
//
//		System.out.println("期初建账驱动测试：");
//		System.out.println("-----------------------------");
//		InitialDataService_Driver initialDataDriver = new InitialDataService_Driver();
//		initialDataDriver.drive(new InitialDataService_Stub());
//		System.out.println("-----------------------------");
//
//		System.out.println("系统日志管理驱动测试：");
//		System.out.println("-----------------------------");
//		LogDataService_Driver logDataDriver = new LogDataService_Driver();
//		logDataDriver.drive(new LogDataService_Stub());
//		System.out.println("-----------------------------");
//
//		System.out.println("机构管理驱动测试：");
//		System.out.println("-----------------------------");
//		OrganizationDataService_Driver organizationDataDriver = new OrganizationDataService_Driver();
//		organizationDataDriver.drive(new OrganizationDataService_Stub());
//		System.out.println("-----------------------------");
//
////		System.out.println("人员管理驱动测试：");
////		System.out.println("-----------------------------");
////		PersonnelDataService_Driver personnelDataDriver = new PersonnelDataService_Driver();
////		personnelDataDriver.drive(new PersonnelDataService_Stub());
////		System.out.println("-----------------------------");
//
//		System.out.println("单据管理驱动测试：");
//		System.out.println("-----------------------------");
//		ReceiptDataService_Driver receiptDataDriver = new ReceiptDataService_Driver();
//		receiptDataDriver.drive(new ReceiptDataService_Stub());
//		System.out.println("-----------------------------");
//
//		System.out.println("库存管理驱动测试：");
//		System.out.println("-----------------------------");
//		StockDataService_Driver stockDataDriver = new StockDataService_Driver();
////		stockDataDriver.driver(new StockDataService_Stub());
//		System.out.println("-----------------------------");
//
//		System.out.println("车辆管理驱动测试：");
//		System.out.println("-----------------------------");
//		VehicleDataService_Driver vehicleDataDriver = new VehicleDataService_Driver();
//		vehicleDataDriver.drive(new VehicleDataService_Stub());
//		System.out.println("-----------------------------");
//
//		System.out.println("用户管理驱动测试：");
//		System.out.println("-----------------------------");
//		UserDataService_Driver userDataDriver = new UserDataService_Driver();
//		userDataDriver.drive(new UserDataService_Stub());
//		System.out.println("-----------------------------");
//		
//		System.out.println("-----------------------------");
//		System.out.println("测试驱动结束");
//		
//	}
//}
