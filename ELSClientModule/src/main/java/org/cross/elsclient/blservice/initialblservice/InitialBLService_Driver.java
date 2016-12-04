///**
// * 期初建账业务逻辑驱动程序
// * @author Polaris Chen
// * @date 2015/10/23
// */
//package org.cross.elsclient.blservice.initialblservice;
//
//import java.util.ArrayList;
//
//import org.cross.elscommon.util.City;
//import org.cross.elscommon.util.OrganizationType;
//import org.cross.elscommon.util.PositionType;
//import org.cross.elscommon.util.ResultMessage;
//import org.cross.elsclient.vo.OrganizationVO;
//import org.cross.elsclient.vo.PersonnelVO;
//import org.cross.elsclient.vo.VehicleVO;
//import org.cross.elsclient.vo.StockVO;
//import org.cross.elsclient.vo.AccountVO;
//import org.cross.elsclient.vo.InitialVO;
//
//public class InitialBLService_Driver {
//
//	public void drive(InitialBLService initialBLService) {
//		
//		System.out.println("期初建账：");
//		
//		ArrayList<InitialVO> list = initialBLService.show();
//		System.out.println("账本信息：" + list.get(0).id + "；" + list.get(0).name);
//
//		ArrayList<OrganizationVO> organizations = new ArrayList<OrganizationVO>();
//		organizations.add(new OrganizationVO(City.BEIJING, OrganizationType.BUSINESSHALL, "O01001"));
//		
//		ArrayList<PersonnelVO> personnels = new ArrayList<PersonnelVO>();
//		personnels.add(new PersonnelVO("P0100001", "杰利", PositionType.COUNTER));
//		
//		ArrayList<VehicleVO> vehicles = new ArrayList<VehicleVO>();
//		vehicles.add(new VehicleVO("V0100001"));
//		
//		ArrayList<StockVO> stocks = new ArrayList<StockVO>();
//		stocks.add(new StockVO("S00001", 5));
//		
//		ArrayList<AccountVO> accounts = new ArrayList<AccountVO>();
//		accounts.add(new AccountVO("ICBC账户", "6222201234567654321", 500000));
//		
//		InitialVO initial = new InitialVO("I20141", "2014年期初", organizations, personnels, vehicles, stocks, accounts);
//		
//		ResultMessage result = initialBLService.addInitial(initial);
//		if (result == ResultMessage.SUCCESS) {
//			System.out.println("期初建账成功");
//		} else {
//			System.out.println("期初建账失败");
//		}
//		
//		organizations = initialBLService.showOrganization(initial);
//		System.out.println("机构信息：" + organizations.get(0).city + "；" + organizations.get(0).type.toString());
//
//		personnels = initialBLService.showPersonnel(initial);
//		System.out.println("人员信息：" + personnels.get(0).id + "；" + personnels.get(0).name + "；" + personnels.get(0).position.toString());
//
//		vehicles = initialBLService.showVehicle(initial);
//		System.out.println("车辆信息：" + vehicles.get(0).number);
//
//		stocks = initialBLService.showStock(initial);
//		System.out.println("库存信息：" + stocks.get(0).stockIdentifier);
//
//		accounts = initialBLService.showAccount(initial);
//		System.out.println("账户信息：" + accounts.get(0).name + "；" + accounts.get(0).account + "；" + accounts.get(0).balance);
//		
//	}
//	
//}
