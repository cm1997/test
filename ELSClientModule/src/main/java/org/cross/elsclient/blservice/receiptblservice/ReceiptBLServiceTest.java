package org.cross.elsclient.blservice.receiptblservice;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blfactoryimpl.BLFactoryImpl;
import org.cross.elsclient.blservice.TestNum;
import org.cross.elsclient.blservice.blfactoryservice.BLFactoryService;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.ReceiptVO;
import org.cross.elsclient.vo.Receipt_ArriveVO;
import org.cross.elsclient.vo.Receipt_OrderVO;
import org.cross.elscommon.util.ApproveType;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;
import org.junit.Before;
import org.junit.Test;

public class ReceiptBLServiceTest {


	BLFactoryService fac;
	ReceiptBLService bl;

	public ReceiptBLServiceTest() {
		try {
			fac = new BLFactoryImpl();
			bl = fac.receiptBLService();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Before
	public void setUp() throws Exception {
		Receipt_OrderVO order1 = new Receipt_OrderVO(TestNum.rec21, TestNum.time1, 20, TestNum.time2,
				TestNum.time4, "陈丹妮", "13333333333", null, "江苏省南京市南京大学仙林校区", "南京大学", "陈睿", "南京大学", "江苏省南京市南京大学仙林校区",
				"18351000000", null, TestNum.per1, TestNum.org2);
		Receipt_OrderVO order2 = new Receipt_OrderVO(TestNum.rec22, TestNum.time3, 30, TestNum.time4,
				TestNum.time4, "陈丹妮", "13333333333", null, "江苏省南京市南京大学仙林校区", "南京大学", "陈睿", "南京大学", "江苏省南京市南京大学仙林校区",
				"18351000000", null, TestNum.per1, TestNum.org2);
		
		bl.add(order2);
		bl.add(order1);
		
		ConstantVal.currentReceipts = bl.show();
	}

	@Test
	public void test_add() {
		boolean check = true;
		Receipt_ArriveVO vo = new Receipt_ArriveVO(TestNum.rec11, TestNum.time1, TestNum.org2, TestNum.rec21,
				TestNum.time2, TestNum.org3, TestNum.use3);
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
		String number = TestNum.rec22;
		ReceiptType type = ReceiptType.ORDER;
		ResultMessage my1 = null;
		try {
			my1 = bl.delete(number, type);
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
		Receipt_OrderVO vo = new Receipt_OrderVO(TestNum.rec21, TestNum.time3, 40, TestNum.time4,
				TestNum.time4, "陈丹妮2", "13333333333", null, "江苏省南京市南京大学仙林校区", "南京大学", "陈睿2", "南京大学", "江苏省南京市南京大学仙林校区",
				"18351000000", null, TestNum.per1, TestNum.org2);
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
		ArrayList<ReceiptVO> my1 = null;
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

	@Test
	public void test_findByID() {
		boolean check = true;
		String id = TestNum.rec21;
		ReceiptVO my1 = null;
		try {
			my1 = bl.findByID(id);
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
	public void test_check() {
		boolean check = true;
		ResultMessage my1 = null;
		Receipt_OrderVO vo = new Receipt_OrderVO(TestNum.rec21, TestNum.time3, 40, TestNum.time4,
				"2015-10-03", "陈丹妮2", "13333333333", null, "江苏省南京市南京大学仙林校区", "南京大学", "陈睿2", "南京大学", "江苏省南京市南京大学仙林校区",
				"18351000000", null, TestNum.per1, TestNum.org2);
		ApproveType app = ApproveType.APPROVED;
		try {
			my1 = bl.check(vo, app);
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
	public void test_findByTime() {
		boolean check = true;
		String startTime=TestNum.time1;
		String endTime=TestNum.time1;
		ArrayList<ReceiptVO> my1 = null;
		try {
			my1 = bl.findByTime(startTime, endTime);
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
	public void test_findByType() {
		boolean check = true;
		ReceiptType type = ReceiptType.ORDER;
		ArrayList<ReceiptVO> my1 = null;
		try {
			my1 = bl.findByType(type);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (my1==null||my1.size()!=2) {
			check=false;
		}
		assertTrue(check);
	}

	@Test
	public void test_findByTimeAndType() {
		boolean check = true;
		String startTime=TestNum.time1;
		String endTime=TestNum.time1;
		ReceiptType type = ReceiptType.ORDER;
		ArrayList<ReceiptVO> my1 = null;
		try {
			my1 = bl.findByTimeAndType(startTime, endTime, type);
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
	public void test_findByUser() {
		boolean check = true;
		String userId=TestNum.per1;
		ArrayList<ReceiptVO> my1 = null;
		try {
			my1 = bl.findByUser(userId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (my1==null||my1.size()!=2) {
			check=false;
		}
		assertTrue(check);
	}

	@Test
	public void test_findByOrgan() {
		boolean check = true;
		String organId=TestNum.org2;
		ArrayList<ReceiptVO> my1 = null;
		try {
			my1 = bl.findByOrgan(organId);
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
