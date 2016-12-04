package org.cross.elsclient.blservice.initialblservice;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blfactoryimpl.BLFactoryImpl;
import org.cross.elsclient.blservice.TestNum;
import org.cross.elsclient.blservice.blfactoryservice.BLFactoryService;
import org.cross.elsclient.blservice.userblservice.UserBLService;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.AccountVO;
import org.cross.elsclient.vo.InitialVO;
import org.cross.elsclient.vo.OrganizationVO;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elsclient.vo.StockVO;
import org.cross.elsclient.vo.UserVO;
import org.cross.elsclient.vo.VehicleVO;
import org.cross.elscommon.util.City;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.UserType;
import org.junit.Before;
import org.junit.Test;

public class InitialBLServiceTest {

	BLFactoryService fac;
	InitialBLService bl;
	UserBLService ubl;

	public InitialBLServiceTest() {
		try {
			fac = new BLFactoryImpl();
			bl = fac.initialBLService();
			ubl = fac.getUserBLService();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Before
	public void setUp() throws Exception {
		
		ConstantVal.constantbl = ConstantVal.getConstant();
		
		ArrayList<OrganizationVO> orgVO = new ArrayList<OrganizationVO>();
		orgVO.add(new OrganizationVO(City.BEIJING,
				OrganizationType.BUSINESSHALL, TestNum.org1));
		ArrayList<PersonnelVO> perVO = new ArrayList<PersonnelVO>();
		perVO.add(new PersonnelVO(TestNum.per1, "cr", PositionType.ADMINISTRATOR,
				TestNum.org1, "男", null, null, null));
		ArrayList<VehicleVO> vehicleVOs = new ArrayList<VehicleVO>();
		vehicleVOs.add(new VehicleVO(TestNum.veh1, null, null, null, null,
				"2015-01-01", "2019-01-01", null, false));
		ArrayList<StockVO> stockVOs = new ArrayList<StockVO>();
		stockVOs.add(new StockVO(TestNum.sto1, 10000, 0, 0, 0, 0, 0, 0,
				TestNum.org1, null));
		ArrayList<AccountVO> accountVOs = new ArrayList<AccountVO>();
		accountVOs.add(new AccountVO("chenr", TestNum.acc1, 923726332));

		InitialVO newVO = new InitialVO(TestNum.init1, "2015账本", orgVO, perVO,
				vehicleVOs, stockVOs, accountVOs, TestNum.time1, "cdn", TestNum.use7);
		
		UserVO uvo = new UserVO(TestNum.use7, "123456", "cr", UserType.ADMINISTRATOR, TestNum.org1);
		ubl.add(uvo);
		bl.addInitial(newVO);
	}

	@Test
	public void test_show() {
		boolean check = true;
		ArrayList<InitialVO> my1 = null;
		try {
			my1 = bl.show();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (bl==null) {
			check = false;
		}
		assertTrue(check);
	}

	@Test
	public void test_addInitial() {
		boolean check = true;
		ResultMessage my1 = null;
		
		ArrayList<OrganizationVO> orgVO = new ArrayList<OrganizationVO>();
		orgVO.add(new OrganizationVO(City.BEIJING,
				OrganizationType.BUSINESSHALL, TestNum.org2));
		ArrayList<PersonnelVO> perVO = new ArrayList<PersonnelVO>();
		perVO.add(new PersonnelVO(TestNum.per2, "cr", PositionType.ADMINISTRATOR,
				TestNum.org2, "男", null, null, null));
		ArrayList<VehicleVO> vehicleVOs = new ArrayList<VehicleVO>();
		vehicleVOs.add(new VehicleVO(TestNum.veh2, null, null, null, null,
				"2015-01-01", "2019-01-01", null, false));
		ArrayList<StockVO> stockVOs = new ArrayList<StockVO>();
		stockVOs.add(new StockVO(TestNum.sto2, 10000, 0, 0, 0, 0, 0, 0,
				TestNum.org2, null));
		ArrayList<AccountVO> accountVOs = new ArrayList<AccountVO>();
		accountVOs.add(new AccountVO("chenr", TestNum.acc2, 923726332));

		InitialVO vo = new InitialVO(TestNum.init2, "2015账本", orgVO, perVO,
				vehicleVOs, stockVOs, accountVOs, TestNum.time2, "cdn", TestNum.use7);
		try {
			my1 = bl.addInitial(vo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (my1!=ResultMessage.SUCCESS) {
			check = false;
		}
		assertTrue(check);
	}

	@Test
	public void test_showOrganization() {
		boolean check = true;
		ArrayList<OrganizationVO> my1 = null;
		String id = TestNum.init1;
		try {
			my1 = bl.showOrganization(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (my1==null) {
			check = false;
		}
		assertTrue(check);
	}

	@Test
	public void test_showPersonnel() {
		boolean check = true;
		ArrayList<PersonnelVO> my1 = null;
		String id = TestNum.init1;
		try {
			my1 = bl.showPersonnel(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (my1==null) {
			check = false;
		}
		assertTrue(check);
	}

	@Test
	public void test_showVehicle() {
		boolean check = true;
		ArrayList<VehicleVO> my1 = null;
		String id = TestNum.init1;
		try {
			my1 = bl.showVehicle(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (my1==null) {
			check = false;
		}
		assertTrue(check);
	}

	@Test
	public void test_showStock() {
		boolean check = true;
		ArrayList<StockVO> my1 = null;
		String id = TestNum.init1;
		try {
			my1 = bl.showStock(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (my1==null) {
			check = false;
		}
		assertTrue(check);
	}

	@Test
	public void test_showAccount() {
		boolean check = true;
		ArrayList<AccountVO> my1 = null;
		String id = TestNum.init1;
		try {
			my1 = bl.showAccount(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (my1==null) {
			check = false;
		}
		assertTrue(check);
	}

}
