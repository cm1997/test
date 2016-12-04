package org.cross.elsclient.blservice.organizationblservice;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blfactoryimpl.BLFactoryImpl;
import org.cross.elsclient.blservice.TestNum;
import org.cross.elsclient.blservice.blfactoryservice.BLFactoryService;
import org.cross.elsclient.vo.OrganizationVO;
import org.cross.elscommon.util.City;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.ResultMessage;
import org.junit.Before;
import org.junit.Test;

public class OrganizationBLServiceTest {

	BLFactoryService fac;
	OrganizationBLService bl;

	public OrganizationBLServiceTest() {
		try {
			fac = new BLFactoryImpl();
			bl = fac.organizationBLService();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Before
	public void setUp() throws Exception {
		OrganizationVO newOrg = new OrganizationVO(City.BEIJING,
				OrganizationType.HEADQUARTERS, TestNum.org1);
		OrganizationVO newOrg2 = new OrganizationVO(City.GUANGZHOU,
				OrganizationType.BUSINESSHALL, TestNum.org2);

		bl.add(newOrg);
		bl.add(newOrg2);
	}

	@Test
	public void test_add() {
		boolean check = true;
		OrganizationVO vo = new OrganizationVO(City.NANJING,
				OrganizationType.TRANSITCENTER, TestNum.org3);
		ResultMessage my1 = null;
		try {
			my1 = bl.add(vo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (my1 != ResultMessage.SUCCESS) {
			check = false;
		}
		assertTrue(check);
	}

	@Test
	public void test_delete() {
		boolean check = true;
		String number = TestNum.org2;
		ResultMessage my1 = null;
		try {
			my1 = bl.delete(number);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (my1 != ResultMessage.SUCCESS) {
			check = false;
		}
		assertTrue(check);
	}

	@Test
	public void test_update() {
		boolean check = true;
		OrganizationVO vo = new OrganizationVO(City.GUANGZHOU,
				OrganizationType.HEADQUARTERS, TestNum.org1);
		ResultMessage my1 = null;
		try {
			my1 = bl.update(vo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (my1 != ResultMessage.SUCCESS) {
			check = false;
		}
		assertTrue(check);
	}

	@Test
	public void test_show() {
		boolean check = true;
		ArrayList<OrganizationVO> my1 = null;
		try {
			my1 = bl.show();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (my1 == null || my1.size() != 2) {
			check = false;
		}
		assertTrue(check);
	}

	@Test
	public void test_findByCity() {
		boolean check = true;
		City city = City.BEIJING;
		ArrayList<OrganizationVO> my1 = null;
		try {
			my1 = bl.findByCity(city);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (my1 == null || my1.size() != 1) {
			check = false;
		}
		assertTrue(check);
	}

	@Test
	public void test_findByType() {
		boolean check = true;
		OrganizationType type = OrganizationType.BUSINESSHALL;
		ArrayList<OrganizationVO> my1 = null;
		try {
			my1 = bl.findByType(type);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (my1 == null || my1.size() != 1) {
			check = false;
		}
		assertTrue(check);
	}

	@Test
	public void test_findById() {
		boolean check = true;
		OrganizationVO my1 = null;
		String number = TestNum.org1;
		try {
			my1 = bl.findById(number);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (my1 == null) {
			check = false;
		}
		assertTrue(check);
	}

}
