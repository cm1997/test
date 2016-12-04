package org.cross.elsclient.blservice.logblservice;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blfactoryimpl.BLFactoryImpl;
import org.cross.elsclient.blservice.TestNum;
import org.cross.elsclient.blservice.blfactoryservice.BLFactoryService;
import org.cross.elsclient.vo.LogVO;
import org.cross.elscommon.util.ResultMessage;
import org.junit.Before;
import org.junit.Test;

public class LogBLServiceTest {

	BLFactoryService fac;
	LogBLService bl;

	public LogBLServiceTest() {
		try {
			fac = new BLFactoryImpl();
			bl = fac.logBLService();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Before
	public void setUp() throws Exception {
		LogVO logVO1 = new LogVO(TestNum.log1, TestNum.time2, "出库", "陈丹妮1");
		LogVO logVO2 = new LogVO(TestNum.log2, TestNum.time2, "出库", "陈丹妮2");
		bl.add(logVO1);
		bl.add(logVO2);
	}

	@Test
	public void test_show() {
		boolean check = true;
		String startTime = TestNum.time1;
		String endTime = TestNum.time4;
		ArrayList<LogVO> my1 = null;
		try {
			my1 = bl.show(startTime, endTime);
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
	public void test_add() {
		boolean check = true;
		LogVO vo = new LogVO(TestNum.log3, TestNum.time3, "出库", "陈丹妮3");
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

}
