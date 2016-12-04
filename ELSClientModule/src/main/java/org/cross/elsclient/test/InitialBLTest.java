package org.cross.elsclient.test;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.accountblimpl.AccountInfoImpl;
import org.cross.elsclient.blimpl.blUtility.SalaryInfo;
import org.cross.elsclient.blimpl.initialblimpl.InitialBLImpl;
import org.cross.elsclient.blimpl.initialblimpl.InitialInfo;
import org.cross.elsclient.blimpl.initialblimpl.InitialInfoImpl;
import org.cross.elsclient.blimpl.organizationblimpl.OrganizationInfoImpl;
import org.cross.elsclient.blimpl.personnelblimpl.PersonnelInfoImpl;
import org.cross.elsclient.blimpl.salaryblimpl.SalaryBLImpl;
import org.cross.elsclient.blimpl.stockblimpl.StockInfoImpl;
import org.cross.elsclient.blimpl.vehicleblimpl.VehicleInfoImpl;
import org.cross.elsclient.network.Datafactory;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.AccountVO;
import org.cross.elsclient.vo.ConstantVO;
import org.cross.elsclient.vo.InitialVO;
import org.cross.elsclient.vo.OrganizationVO;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elsclient.vo.StockVO;
import org.cross.elsclient.vo.VehicleVO;
import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;
import org.cross.elscommon.util.City;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.ResultMessage;

public class InitialBLTest {

	public static void main(String[] args) throws RemoteException {
		
		ConstantVal.CONSTANT = new ConstantVO();
		
		DataFactoryService dataFactory = new Datafactory();
		SalaryInfo salaryInfo = new SalaryBLImpl(dataFactory.getSalaryData());
		OrganizationInfoImpl orginfo = new OrganizationInfoImpl(
				dataFactory.getOrganizationData());
		PersonnelInfoImpl personnelInfo = new PersonnelInfoImpl(
				dataFactory.getPersonnelData(), salaryInfo);
		VehicleInfoImpl vehicleInfo = new VehicleInfoImpl(
				dataFactory.getVehicleData());
		StockInfoImpl stockInfo = new StockInfoImpl(dataFactory.getStockData());
		AccountInfoImpl accountInfo = new AccountInfoImpl(
				dataFactory.getAccountData());
		InitialInfoImpl initialInfo = new InitialInfoImpl(orginfo,
				personnelInfo, vehicleInfo, stockInfo, accountInfo);
		InitialBLImpl initialBLImpl = new InitialBLImpl(
				dataFactory.getinInitialData(), initialInfo, orginfo,
				personnelInfo, vehicleInfo, stockInfo, accountInfo, salaryInfo, dataFactory.getSalaryData());

//		System.out.println("---test-add---");
//		ArrayList<OrganizationVO> orgVO = new ArrayList<OrganizationVO>();
//		orgVO.add(new OrganizationVO(City.BEIJING,
//				OrganizationType.BUSINESSHALL, "O00010272"));
//		ArrayList<PersonnelVO> perVO = new ArrayList<PersonnelVO>();
//		perVO.add(new PersonnelVO("P0001", "cr", PositionType.ADMINISTRATOR,
//				"O0002", "男", null, null, null));
//		ArrayList<VehicleVO> vehicleVOs = new ArrayList<VehicleVO>();
//		vehicleVOs.add(new VehicleVO("V00001", null, null, null, null,
//				"2015-01-01", "2019-01-01", null, false));
//		ArrayList<StockVO> stockVOs = new ArrayList<StockVO>();
//		stockVOs.add(new StockVO("S00023", 10000, 0, 0, 0, 0, 0, 0, "O02502837",null));
//		ArrayList<AccountVO> accountVOs = new ArrayList<AccountVO>();
//		accountVOs.add(new AccountVO("chenr", "26352717288939", 923726332));
//
//		InitialVO newVO = new InitialVO("I928392", "2015账本", orgVO, perVO,
//				vehicleVOs, stockVOs, accountVOs, "2015-01-01", "cdn", "P00293");
//		ResultMessage addMessage = initialBLImpl.addInitial(newVO);
//		if (addMessage == ResultMessage.SUCCESS) {
//			System.out.println("增加成功");
//		} else {
//			System.out.println("增加失败");
//		}

		System.out.println("---test-show---");
		ArrayList<InitialVO> show = initialBLImpl.show();
		if (show == null) {
			System.out.println("是空的啊");
		} else {
			int size = show.size();
			for (int i = 0; i < size; i++) {
				System.out.println(show.get(i).perName + " " + show.get(i).time
						+ " " + show.get(i).id);
			}
		}

		System.out.println("---test-showOrg---");
		ArrayList<OrganizationVO> org = initialBLImpl
				.showOrganization("I928392");
		for (int i = 0; i < org.size(); i++) {
			System.out.println(org.get(i).number + " " + org.get(i).type + " "
					+ org.get(i).city);
		}

		System.out.println("---test-showPersonnel---");
		ArrayList<PersonnelVO> pers = initialBLImpl.showPersonnel("I928392");
		for (int i = 0; i < pers.size(); i++) {
			System.out.println(pers.get(i).name + " " + pers.get(i).birthday
					+ " " + pers.get(i).sex);
		}
		System.out.println("---test-showVehicle---");
		ArrayList<VehicleVO> vehicle = initialBLImpl.showVehicle("I001");
		for (int i = 0; i < vehicle.size(); i++) {
			System.out.println(vehicle.get(i).number + " "
					+ vehicle.get(i).buyTime + " " + vehicle.get(i).lastTime);
		}

		System.out.println("---test-showStock---");
		ArrayList<StockVO> stock = initialBLImpl.showStock("I928392");
		for (int i = 0; i < stock.size(); i++) {
			System.out
					.println(stock.get(i).number + " " + stock.get(i).totalAreas);
		}

		System.out.println("---test-showAccount---");
		ArrayList<AccountVO> account = initialBLImpl.showAccount("I928392");
		for (int i = 0; i < account.size(); i++) {
			System.out.println(account.get(i).name + " "
					+ account.get(i).account + " " + account.get(i).balance);
		}
	}
}
