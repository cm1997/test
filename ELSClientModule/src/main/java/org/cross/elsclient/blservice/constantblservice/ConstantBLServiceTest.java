package org.cross.elsclient.blservice.constantblservice;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.cross.elsclient.blimpl.blfactoryimpl.BLFactoryImpl;
import org.cross.elsclient.blservice.blfactoryservice.BLFactoryService;
import org.cross.elsclient.vo.ConstantVO;
import org.cross.elscommon.util.ResultMessage;
import org.junit.Before;
import org.junit.Test;
import org.omg.PortableInterceptor.SUCCESSFUL;

public class ConstantBLServiceTest {

	BLFactoryService fac;
	ConstantBLService bl;

	public ConstantBLServiceTest() {
		try {
			fac = new BLFactoryImpl();
			bl = fac.constantBLService();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test_update() {
		boolean check = true;
		ResultMessage my1=null;
		ConstantVO vo = new ConstantVO();
		try {
			my1 = bl.update(vo);
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
	public void test_show() {
		boolean check = true;
		ConstantVO my1 = null;
		my1 = bl.show();
		if (my1==null) {
			check = false;
		}
		assertTrue(check);
	}

}
