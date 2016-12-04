package org.cross.elsclient.blservice.vehicleblservice;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blfactoryimpl.BLFactoryImpl;
import org.cross.elsclient.blservice.TestNum;
import org.cross.elsclient.blservice.blfactoryservice.BLFactoryService;
import org.cross.elsclient.vo.UserVO;
import org.cross.elsclient.vo.VehicleVO;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.UserType;
import org.junit.Before;
import org.junit.Test;

public class VehicleBLServiceTest {

	BLFactoryService fac;
	VehicleBLService bl;

	public VehicleBLServiceTest() {
		try {
			fac = new BLFactoryImpl();
			bl = fac.vehicleBLService();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Before
	public void setUp() throws Exception {
		VehicleVO vo1 = new VehicleVO(TestNum.veh1, "E00000000",
				TestNum.org2, "3265732752", "B6526", "2011-10-2", "2019-2-1",
		null, false);
		VehicleVO vo2 = new VehicleVO(TestNum.veh2, "E00000000",
				TestNum.org2, "3265732752", "B6526", "2011-10-2", "2019-2-1",
		null, false);
		
		bl.add(vo1);
		bl.add(vo2);
	}

	@Test
	public void test_add() {
		boolean check = true;
		VehicleVO vo = new VehicleVO(TestNum.veh3, "E00000000",
				TestNum.org1, "3265732752", "B6526", "2011-10-2", "2019-2-1",
		null, false);
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
		String number = TestNum.veh2;
		ResultMessage my1 = null;
		try {
			my1 = bl.delete(number);
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
		VehicleVO vo = new VehicleVO(TestNum.veh1, "E00000002",
				TestNum.org2, "3265732752", "B6526", "2011-10-2", "2019-2-1",
		null, true);
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
		ArrayList<VehicleVO> my1 = null;
		try {
			my1=bl.show();
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
	public void test_find() {
		boolean check = true;
		ArrayList<VehicleVO> my1 = null;
		String name=TestNum.veh1;
		try {
			my1=bl.find(name);
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
		ArrayList<VehicleVO> my1 = null;
		String orgNum=TestNum.org2;
		try {
			my1=bl.findByOrg(orgNum);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (my1==null) {
			check=false;
		}
		assertTrue(check);
	}


}
