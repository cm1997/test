//package org.cross.elsclient.test;
//
//import java.rmi.RemoteException;
//
//import org.cross.elsclient.blservice.accountblservice.AccountBLService_Driver;
//import org.cross.elsclient.blservice.accountblservice.AccountBLService_Stub;
//import org.cross.elsclient.blservice.analysisblservice.AnalysisBLService_Driver;
//import org.cross.elsclient.blservice.analysisblservice.AnalysisBLService_Stub;
//import org.cross.elsclient.blservice.constantblservice.ConstanceBLService_Driver;
//import org.cross.elsclient.blservice.constantblservice.ConstantBLService_Stub;
//import org.cross.elsclient.blservice.goodsblservice.GoodsBLService_Driver;
//import org.cross.elsclient.blservice.goodsblservice.GoodsBLService_Stub;
//import org.cross.elsclient.blservice.initialblservice.InitialBLService_Driver;
//import org.cross.elsclient.blservice.initialblservice.InitialBLService_Stub;
//import org.cross.elsclient.blservice.logblservice.LogBLService_Driver;
//import org.cross.elsclient.blservice.logblservice.LogBLService_Stub;
//import org.cross.elsclient.blservice.organizationblservice.OrganizationBLService_Driver;
//import org.cross.elsclient.blservice.organizationblservice.OrganizationBlservice_Stub;
//import org.cross.elsclient.blservice.personnelblservice.PersonnelBLService_Driver;
//import org.cross.elsclient.blservice.personnelblservice.PersonnelBLService_Stub;
//import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService_Driver;
//import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService_Stub;
//import org.cross.elsclient.blservice.stockblservice.StockBLService_Driver;
//import org.cross.elsclient.blservice.stockblservice.StockBLService_Stub;
//import org.cross.elsclient.blservice.userblservice.UserBLService_Driver;
//import org.cross.elsclient.blservice.userblservice.UserBLService_Stub;
//import org.cross.elsclient.blservice.vehicleblservice.VehicleBLService_Driver;
//import org.cross.elsclient.blservice.vehicleblservice.VehicleBLService_Stub;
//
//public class TestBLDriver {
//	public static void main(String [] args) throws RemoteException{
//		System.out.println("测试驱动开始");
//		System.out.println("-----------------------------");
//		
//		System.out.println("账户管理驱动测试：");
//		System.out.println("-----------------------------");
//		AccountBLService_Driver accountBLDriver = new AccountBLService_Driver();
//		accountBLDriver.drive(new AccountBLService_Stub());
//		System.out.println("-----------------------------");
//
//		System.out.println("查看统计分析驱动测试：");
//		System.out.println("-----------------------------");
//		AnalysisBLService_Driver analysisBLDriver = new AnalysisBLService_Driver();
//		analysisBLDriver.driver(new AnalysisBLService_Stub());
//		System.out.println("-----------------------------");
//
//		System.out.println("制定常量驱动测试：");
//		System.out.println("-----------------------------");
//		ConstanceBLService_Driver constantBLDriver = new ConstanceBLService_Driver();
//		constantBLDriver.drive(new ConstantBLService_Stub());
//		System.out.println("-----------------------------");
//
//		System.out.println("快件管理驱动测试：");
//		System.out.println("-----------------------------");
//		GoodsBLService_Driver goodsBLDriver = new GoodsBLService_Driver();
//		goodsBLDriver.drive(new GoodsBLService_Stub());
//		System.out.println("-----------------------------");
//
//		System.out.println("期初建账驱动测试：");
//		System.out.println("-----------------------------");
//		InitialBLService_Driver initialBLDriver = new InitialBLService_Driver();
//		initialBLDriver.drive(new InitialBLService_Stub());
//		System.out.println("-----------------------------");
//
//		System.out.println("系统日志管理驱动测试：");
//		System.out.println("-----------------------------");
//		LogBLService_Driver logBLDriver = new LogBLService_Driver();
//		logBLDriver.drive(new LogBLService_Stub());
//		System.out.println("-----------------------------");
//
//		System.out.println("机构管理驱动测试：");
//		System.out.println("-----------------------------");
//		OrganizationBLService_Driver organizationBLDriver = new OrganizationBLService_Driver();
//		organizationBLDriver.drive(new OrganizationBlservice_Stub());
//		System.out.println("-----------------------------");
//
//		System.out.println("人员管理驱动测试：");
//		System.out.println("-----------------------------");
//		PersonnelBLService_Driver personnelBLDriver = new PersonnelBLService_Driver();
//		personnelBLDriver.drive(new PersonnelBLService_Stub());
//		System.out.println("-----------------------------");
//
//		System.out.println("单据管理驱动测试：");
//		System.out.println("-----------------------------");
//		ReceiptBLService_Driver receiptBLDriver = new ReceiptBLService_Driver();
//		receiptBLDriver.drive(new ReceiptBLService_Stub());
//		System.out.println("-----------------------------");
//
//		System.out.println("库存管理驱动测试：");
//		System.out.println("-----------------------------");
//		StockBLService_Driver stockBLDriver = new StockBLService_Driver();
//		stockBLDriver.drive(new StockBLService_Stub());
//		System.out.println("-----------------------------");
//
//		System.out.println("车辆管理驱动测试：");
//		System.out.println("-----------------------------");
//		VehicleBLService_Driver vehicleBLDriver = new VehicleBLService_Driver();
//		vehicleBLDriver.drive(new VehicleBLService_Stub());
//		System.out.println("-----------------------------");
//
//		System.out.println("用户管理驱动测试：");
//		System.out.println("-----------------------------");
//		UserBLService_Driver userBLDriver = new UserBLService_Driver();
//		userBLDriver.drive(new UserBLService_Stub());
//		System.out.println("-----------------------------");
//		
//		System.out.println("-----------------------------");
//		System.out.println("测试驱动结束");
//	}
//}
