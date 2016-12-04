package org.cross.elsclient.blservice.userblservice;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blfactoryimpl.BLFactoryImpl;
import org.cross.elsclient.blservice.TestNum;
import org.cross.elsclient.blservice.blfactoryservice.BLFactoryService;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.UserType;
import org.junit.Before;
import org.junit.Test;

public class UserBLServiceTest {

	BLFactoryService fac;
	UserBLService bl;

	public UserBLServiceTest() {
		try {
			fac = new BLFactoryImpl();
			bl = fac.getUserBLService();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Before
	public void setUp() throws Exception {
		UserVO vo1 = new UserVO(TestNum.use1, "123321", "陈丹",
				UserType.BUSINESSHALLCLERK, TestNum.org1);
		UserVO vo2 = new UserVO(TestNum.use2, "123321", "陈丹妮",
				UserType.ADMINISTRATOR, TestNum.org2);

		bl.add(vo1);
		bl.add(vo2);
	}

	@Test
	public void test_add() {
		boolean check = true;
		ResultMessage my1 = null;
		UserVO vo = new UserVO(TestNum.use3, "123321", "陈丹妮尼",
				UserType.ADMINISTRATOR, TestNum.org3);
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
		ResultMessage my1 = null;
		String id = TestNum.use2;
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
		ResultMessage my1 = null;
		UserVO vo = new UserVO(TestNum.use1, "123", "陈丹",
				UserType.BUSINESSHALLCLERK, TestNum.org1);
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
	public void test_findByName() {
		boolean check = true;
		ArrayList<UserVO> my1 = null;
		String name = "陈丹";
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
	public void test_findByType() {
		boolean check = true;
		ArrayList<UserVO> my1 = null;
		UserType type = UserType.BUSINESSHALLCLERK;
		try {
			my1 = bl.findByType(type);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (my1==null) {
			check=false;
		}
		assertTrue(check);
	}

	@Test
	public void test_findById() {
		boolean check = true;
		UserVO my1 = null;
		String id = TestNum.use1;
		try {
			my1 = bl.findById(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (my1==null) {
			check=false;
		}
		assertTrue(check);
	}

	@Test
	public void test_show() {
		boolean check = true;
		ArrayList<UserVO> my1 = null;
		try {
			my1 = bl.show();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (my1==null) {
			check=false;
		}
		assertTrue(check);
	}

	@Test
	public void test_login() {
		boolean check = true;
		UserType my1 = null;
		String id = TestNum.use1;
		String password =  "123";
		try {
			my1 = bl.login(id, password);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (my1!=UserType.BUSINESSHALLCLERK) {
			check = false;
		}
		assertTrue(check);
	}

}
