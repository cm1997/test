package org.cross.elsclient.blservice.goodsblservice;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blfactoryimpl.BLFactoryImpl;
import org.cross.elsclient.blservice.TestNum;
import org.cross.elsclient.blservice.blfactoryservice.BLFactoryService;
import org.cross.elsclient.vo.GoodsVO;
import org.cross.elsclient.vo.HistoryVO;
import org.cross.elscommon.util.City;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StockType;
import org.junit.Before;
import org.junit.Test;

public class GoodsBLServiceTest {

	BLFactoryService fac;
	GoodsBLService bl;

	public GoodsBLServiceTest() {
		try {
			fac = new BLFactoryImpl();
			bl = fac.goodsBLService();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Before
	public void setUp() throws Exception {
		GoodsVO goods1 = new GoodsVO(TestNum.rec21, StockType.COMMON, City.NANJING,
				OrganizationType.BUSINESSHALL, 50, 30);
		HistoryVO history = new HistoryVO(TestNum.time1, City.NANJING, OrganizationType.BUSINESSHALL, false);
		goods1.history.add(history);
		
		bl.addGoods(goods1);
	}

	@Test
	public void test_addGoods() {
		boolean check = true;
		ResultMessage my1 = null;
		ResultMessage my2 = null;
		GoodsVO goods2 = new GoodsVO(TestNum.rec22, StockType.Fast, City.NANJING,
				OrganizationType.BUSINESSHALL, 2, 30);
		GoodsVO goods3 = new GoodsVO(TestNum.rec22, StockType.Fast, City.NANJING,
				OrganizationType.BUSINESSHALL, 2, 30);
		try {
			my1 = bl.addGoods(goods2);
			my2 = bl.addGoods(goods3);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (my1!=ResultMessage.SUCCESS || my2!=ResultMessage.FAILED) {
			check = false;
		}
		assertTrue(check);
	}

	@Test
	public void test_updateGoods() {
		boolean check = true;
		ResultMessage my1 = null;
		HistoryVO newh = new HistoryVO(TestNum.time2, City.BEIJING, OrganizationType.TRANSITCENTER, true);
		try {
			GoodsVO goods = bl.searchGoods(TestNum.rec21);
			goods.history.add(newh);
			my1 = bl.updateGoods(goods);
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
	public void test_findGoods() {
		boolean check = true;
		String number = TestNum.rec21;
		ArrayList<HistoryVO> my1 = null;
		try {
			my1 = bl.findGoods(number);
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
	public void test_searchGoods() {
		boolean check = true;
		String number = TestNum.rec21;
		GoodsVO my1 = null;
		try {
			my1 = bl.searchGoods(number);
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
