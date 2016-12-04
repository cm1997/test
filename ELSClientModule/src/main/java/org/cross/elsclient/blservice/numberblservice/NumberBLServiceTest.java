package org.cross.elsclient.blservice.numberblservice;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.cross.elsclient.blimpl.blfactoryimpl.BLFactoryImpl;
import org.cross.elsclient.blservice.blfactoryservice.BLFactoryService;
import org.cross.elscommon.po.NumberPO;
import org.cross.elscommon.util.NumberType;
import org.junit.Before;
import org.junit.Test;

public class NumberBLServiceTest {


	BLFactoryService fac;
	NumberBLService bl;

	public NumberBLServiceTest() {
		try {
			fac = new BLFactoryImpl();
			bl = fac.numberBLService();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test_getPostNumber() {
		boolean check = true;
		String my1 = null;
		my1 = bl.getPostNumber(NumberType.INITIAL);
		if (!my1.equals("I000000012")) {
			check = false;
		}
		assertTrue(check);
	}

	@Test
	public void test_getPO() {
		boolean check = true;
		NumberPO my1 = null;
		try {
			my1 = bl.getPO();
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
