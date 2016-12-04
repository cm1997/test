package org.cross.elsclient.blservice.personnelblservice;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blfactoryimpl.BLFactoryImpl;
import org.cross.elsclient.blservice.TestNum;
import org.cross.elsclient.blservice.blfactoryservice.BLFactoryService;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.ResultMessage;
import org.junit.Before;
import org.junit.Test;

public class PersonnelBLServiceTest {

	PersonnelBLService bl;
	BLFactoryService fac;

	public PersonnelBLServiceTest() {
		try {
			fac = new BLFactoryImpl();
			bl = fac.personnelBLService();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Before
	public void setUp() throws Exception {
		ConstantVal.constantbl = ConstantVal.getConstant();
		PersonnelVO newVO = new PersonnelVO(TestNum.per1, "cdn",
				PositionType.ADMINISTRATOR, TestNum.org1, "女", null, null, null);
		PersonnelVO newVO2 = new PersonnelVO(TestNum.per2, "cr",
				PositionType.BUSINESSHALLCLERK, TestNum.org2, "女", null, null, null);
		
		bl.add(newVO2);
		bl.add(newVO);
	}

	@Test
	public void test_findById() {
		boolean check = true;
		String id = TestNum.per1;
		PersonnelVO my1 = null;
		try {
			my1 = bl.findById(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (my1==null) {
			check =false;
		}
		assertTrue(check);
	}

	@Test
	public void test_findByName() {
		boolean check = true;
		String name = "cdn";
		ArrayList<PersonnelVO> my1 = null;
		try {
			my1 = bl.findByName(name);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (my1==null||my1.size()!=1) {
			check=false;
		}
		assertTrue(check);
	}

	@Test
	public void test_findByOrg() {
		boolean check = true;
		String org = TestNum.org1;
		ArrayList<PersonnelVO> my1 = null;
		try {
			my1 = bl.findByOrg(org);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (my1==null||my1.size()!=1) {
			check=false;
		}
		assertTrue(check);
	}

	@Test
	public void test_findByPosition() {
		boolean check = true;
		PositionType type = PositionType.ADMINISTRATOR;
		ArrayList<PersonnelVO> my1 = null;
		try {
			my1 = bl.findByPosition(type);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (my1==null||my1.size()!=1) {
			check=false;
		}
		assertTrue(check);
	}

	@Test
	public void test_add() {
		boolean check = true;
		PersonnelVO vo = new PersonnelVO(TestNum.per3, "crr",
				PositionType.ADMINISTRATOR, TestNum.org2, "女", null, null, null);
		ResultMessage my1 = null;
		try {
			my1 = bl.add(vo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (my1!=ResultMessage.SUCCESS) {
			check=false;
		}
		assertTrue(check);
	}

	@Test
	public void test_delete() {
		boolean check = true;
		String id = TestNum.per2;
		ResultMessage my1 = null;
		try {
			my1 = bl.delete(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (my1!=ResultMessage.SUCCESS) {
			check=false;
		}
		assertTrue(check);
	}

	@Test
	public void test_update() {
		boolean check = true;
		PersonnelVO vo = new PersonnelVO(TestNum.per1, "cdn",
				PositionType.BUSINESSHALLCLERK, TestNum.org1, "女", null, null, null);
		ResultMessage my1 = null;
		try {
			my1 = bl.update(vo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (my1!=ResultMessage.SUCCESS) {
			check=false;
		}
		assertTrue(check);
	}

	@Test
	public void test_show() {
		boolean check = true;
		ArrayList<PersonnelVO> my1 = null;
		try {
			my1 = bl.show();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (my1==null||my1.size()!=2) {
			check=false;
		}
		assertTrue(check);
	}



}
