package org.cross.elsclient.blservice.stockblservice;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blfactoryimpl.BLFactoryImpl;
import org.cross.elsclient.blservice.TestNum;
import org.cross.elsclient.blservice.blfactoryservice.BLFactoryService;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.StockAreaVO;
import org.cross.elsclient.vo.StockCheckVO;
import org.cross.elsclient.vo.StockSeeVO;
import org.cross.elsclient.vo.StockVO;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StockState;
import org.cross.elscommon.util.StockType;
import org.junit.Before;
import org.junit.Test;

public class StockBLServiceTest {

	BLFactoryService fac;
	StockBLService bl;
	ReceiptBLService rbl;

	public StockBLServiceTest() {
		try {
			fac = new BLFactoryImpl();
			bl =fac.stockBLService();
			rbl = fac.receiptBLService();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Before
	public void setUp() throws Exception {
		StockAreaVO area1 = new StockAreaVO(TestNum.sta11, TestNum.sto1, StockType.COMMON, 100, 0, null);
		StockAreaVO area2 = new StockAreaVO(TestNum.sta12, TestNum.sto1, StockType.COMMON, 100, 0, null);
		StockAreaVO area3 = new StockAreaVO(TestNum.sta21, TestNum.sto1, StockType.ECONOMICAL, 100, 0, null);
		StockAreaVO area4 = new StockAreaVO(TestNum.sta31, TestNum.sto1, StockType.Fast, 100, 0, null);
		ArrayList<StockAreaVO> areas = new ArrayList<StockAreaVO>();
		areas.add(area1); 
		areas.add(area2);
		areas.add(area3);
		areas.add(area4);
		StockVO stockVO = new StockVO(TestNum.sto1, 400, 4, 0, 0, 0, 0, 0, TestNum.org2,areas);
		
		bl.intoStock(TestNum.rec22, TestNum.sto1, TestNum.time1, TestNum.sta11);
		
		bl.addStock(stockVO);
		
		ConstantVal.currentReceipts = rbl.show();
	}

	@Test
	public void test_addStock() {
		boolean check = true;
		ResultMessage my1 = null;
		StockAreaVO area1 = new StockAreaVO(TestNum.sta22, TestNum.sto2, StockType.ECONOMICAL, 100, 0, null);
		StockAreaVO area2 = new StockAreaVO(TestNum.sta23, TestNum.sto2, StockType.ECONOMICAL, 100, 0, null);
		StockAreaVO area3 = new StockAreaVO(TestNum.sta13, TestNum.sto2, StockType.COMMON, 100, 0, null);
		StockAreaVO area4 = new StockAreaVO(TestNum.sta32, TestNum.sto2, StockType.Fast, 100, 0, null);
		ArrayList<StockAreaVO> areas = new ArrayList<StockAreaVO>();
		areas.add(area1); 
		areas.add(area2);
		areas.add(area3);
		areas.add(area4);
		StockVO vo = new StockVO(TestNum.sto2, 400, 4, 0, 0, 0, 0, 0, TestNum.org4,areas);
		
		try {
			my1 = bl.addStock(vo);
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
	public void test_intoStock() {
		boolean check = true;
		ResultMessage my1 = null;
		String goodsID=TestNum.rec21;
		String stockID=TestNum.sto1;
		String time=TestNum.time1;
		String stockAreaNum=TestNum.sta21;
		try {
			my1 = bl.intoStock(goodsID, stockID, time, stockAreaNum);
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
	public void test_outStock() {
		boolean check = true;
		ResultMessage my1 = null;
		String goodsID=TestNum.rec22;
		String stockID=TestNum.sto1;
		String time=TestNum.time1;
		try {
			my1 = bl.outStock(goodsID, stockID, time);
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
	public void test_stockAdjust() {
		boolean check = true;
		ResultMessage my1 = null;
		String stockID=TestNum.sto1;
		StockType stockType=StockType.ECONOMICAL;
		try {
			my1 = bl.stockAdjust(stockID, stockType);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (my1==ResultMessage.SUCCESS) {
			check=false;
		}
		assertTrue(check);
	}

	@Test
	public void test_showStockCheck() {
		boolean check = true;
		ArrayList<StockCheckVO> my1 = null;
		String stockID=TestNum.sto1;
		try {
			my1 = bl.showStockCheck(stockID);
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
	public void test_showStockInfo() {
		boolean check = true;
		StockSeeVO my1 = null;
		String stockID=TestNum.sto1;
		String time1=TestNum.time1;
		String time2=TestNum.time4;
		try {
			my1 = bl.showStockInfo(stockID, time1, time2);
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
	public void test_findStock() {
		boolean check = true;
		StockVO my1 = null;
		String ID=TestNum.sto1;
		try {
			my1 = bl.findStock(ID);
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
	public void test_stockCapacity() {
		boolean check = true;
		ArrayList<StockAreaVO> my1 = null;
		String id=TestNum.sto1;
		StockType type=StockType.ECONOMICAL;
		try {
			my1 = bl.stockCapacity(id, type);
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
	public void test_stockAlert() {
		boolean check = true;
		StockState my1 = null;
		String stockAreaID=TestNum.sta11;
		StockType stockType=StockType.COMMON;
		try {
			my1 = bl.stockAlert(stockAreaID, stockType);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (my1!=StockState.NORMAL) {
			check=false;
		}
		assertTrue(check);
	}

	@Test
	public void test_getChangeableArea() {
		boolean check = true;
		ArrayList<String> my1 = null;
		String stockID=TestNum.sto1;
		try {
			my1 = bl.getChangeableArea(stockID);
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
	public void test_findStockByOrg() {
		boolean check = true;
		StockVO my1 = null;
		String orgNum=TestNum.org2;
		try {
			my1 = bl.findStockByOrg(orgNum);
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
	public void test_getNeedChange() {
		boolean check = true;
		ArrayList<String> my1 = null;
		String stockID=TestNum.sto1;
		try {
			my1 = bl.getNeedChange(stockID);
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
