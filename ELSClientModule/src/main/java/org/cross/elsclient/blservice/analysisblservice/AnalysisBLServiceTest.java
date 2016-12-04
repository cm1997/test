package org.cross.elsclient.blservice.analysisblservice;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blfactoryimpl.BLFactoryImpl;
import org.cross.elsclient.blservice.TestNum;
import org.cross.elsclient.blservice.blfactoryservice.BLFactoryService;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.AnalysisVO;
import org.cross.elsclient.vo.Receipt_MoneyInVO;
import org.cross.elsclient.vo.Receipt_MoneyOutVO;
import org.cross.elscommon.util.ResultMessage;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.TestName;

public class AnalysisBLServiceTest {

	BLFactoryService fac;
	AnalysisBLService bl;
	ReceiptBLService rbl;

	public AnalysisBLServiceTest() {
		try {
			fac = new BLFactoryImpl();
			bl = fac.analysisBLService();
			rbl = fac.receiptBLService();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Before
	public void setUp() throws Exception {
		ConstantVal.currentReceipts = rbl.show();
		
		//收款单
		ArrayList<String> orders = new ArrayList<String>();
		orders.add(TestNum.rec21);
		orders.add(TestNum.rec22);
		Receipt_MoneyInVO moneyIn1 = new Receipt_MoneyInVO(TestNum.time2, 20, TestNum.per1, TestNum.rec61, orders,
				TestNum.org2, TestNum.use3);

		// 付款单
		String receiverID1 = TestNum.acc1;
		String receiverID2 = TestNum.acc2;
		String senderID = TestNum.acc3;
		String moneyOutPerNum = TestNum.use7;
		String headquatersNum = TestNum.org1;
		Receipt_MoneyOutVO moneyOut1 = new Receipt_MoneyOutVO(TestNum.rec71, TestNum.time2, 2000, receiverID1,
				senderID, "人员工资", "快递员工资", moneyOutPerNum, headquatersNum);
		Receipt_MoneyOutVO moneyOut2 = new Receipt_MoneyOutVO(TestNum.rec72, TestNum.time3, 2100, receiverID2,
				senderID, "人员工资", "快递员工资", moneyOutPerNum, headquatersNum);
		
		rbl.add(moneyIn1);
		rbl.add(moneyOut1);
		rbl.add(moneyOut2);
		
	}

	@Test
	public void test_showMoneyinTable() {
		boolean check = true;
		String beginTime = TestNum.time1;
		String endTime = TestNum.time4;
		ArrayList<Receipt_MoneyInVO> my1 = null;
		try {
			my1 = bl.showMoneyinTable(beginTime, endTime);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (my1==null||my1.size()!=1) {
			check = false;
		}
		
		assertTrue(check);
	}

	@Test
	public void test_showCostBenefitTable() {
		boolean check = true;
		double[] my1 = null;
		my1 = bl.showCostBenefitTable();
		if (my1==null) {
			check = false;
		}
		assertTrue(check);
	}

	@Test
	public void test_showMoneyoutTable() {
		boolean check = true;
		String beginTime = TestNum.time1;
		String endTime = TestNum.time4;
		ArrayList<Receipt_MoneyOutVO> my1=null;
		my1 = bl.showMoneyoutTable(beginTime, endTime);
		if (my1==null||my1.size()!=2) {
			check=false;
		}
		assertTrue(check);
	}
}
