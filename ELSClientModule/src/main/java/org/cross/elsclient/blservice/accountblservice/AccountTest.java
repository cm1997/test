package org.cross.elsclient.blservice.accountblservice;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blfactoryimpl.BLFactoryImpl;
import org.cross.elsclient.blservice.blfactoryservice.BLFactoryService;
import org.cross.elsclient.vo.AccountVO;
import org.cross.elscommon.util.ResultMessage;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {
	BLFactoryService fac;
	AccountBLService bl;

	public AccountTest() {
		try {
			fac = new BLFactoryImpl();
			bl = fac.getAccountBLService();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Before
	public void setUp() throws Exception {
		AccountVO vo1 = new AccountVO("ICBC1", "6227001291082482737", 20000);
		AccountVO vo4 = new AccountVO("ICBC1", "6227001291082482736", 40000);
		AccountVO vo2 = new AccountVO("ICBC2", "6227001291082482738", 10000);
		try {
			bl.add(vo1);
			bl.add(vo2);
			bl.add(vo4);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test_findbyName() {
		ArrayList<AccountVO> my1 = null;
		ArrayList<AccountVO> my2 = null;

		try {
			my1 = bl.findByName("ICBC1");
			my2 = bl.findByName("ICCC");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boolean check = true;

		if (my1 != null && my1.size() == 2) {
			for (AccountVO accvo : my1) {
				if (!accvo.name.equals("ICBC1")) {
					check = false;
					break;
				}
			}
		} else
			check = false;

		if (my2 != null && my2.size() > 0)
			check = false;

		assertTrue(check);
	}

	@Test
	public void test_findbyid() {
		AccountVO my1 = null;
		AccountVO my3 = null;
		try {
			my1 = bl.findByID("6227001291082482737");
			my3 = bl.findByID("6227001291082482735");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boolean check = true;
		if (my1 == null || !my1.account.equals("6227001291082482737")) {
			check = false;
		}
		if (my3 != null) {
			check = false;
		}
		assertTrue(check);
	}

	@Test
	public void test_add() {
		//
		boolean check = true;
		ResultMessage rs = null;

		AccountVO vo1 = new AccountVO("ICBC3", "6227001291082482739", 5000);
		try {
			rs = bl.add(vo1);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rs == ResultMessage.SUCCESS) {
			check = true;
		} else
			check = false;
		assertTrue(check);
	}

	@Test
	public void test_delete() {
		//
		boolean check = true;
		ResultMessage rs = null;

		try {
			rs = bl.delete("6227001291082482738");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (rs == ResultMessage.SUCCESS) {
			check = true;
		} else
			check = false;
		assertTrue(check);
	}

	@Test
	public void test_update() {
		//
		boolean check = true;
		ResultMessage rs = null;
		AccountVO vo1 = new AccountVO("ICBC1", "6227001291082482737", 60000);
		try {
			rs = bl.update(vo1);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (rs == ResultMessage.SUCCESS) {
			check = true;
		} else
			check = false;
		assertTrue(check);
	}

}
