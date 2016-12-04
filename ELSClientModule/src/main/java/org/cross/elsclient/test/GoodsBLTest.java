/**
 * goods全部写好了
 */
package org.cross.elsclient.test;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.GoodsInfo;
import org.cross.elsclient.blimpl.blUtility.ReceiptInfo;
import org.cross.elsclient.blimpl.goodsblimpl.GoodsBLImpl;
import org.cross.elsclient.blimpl.goodsblimpl.GoodsInfoImpl;
import org.cross.elsclient.blimpl.receiptblimpl.ReceiptBLImpl;
import org.cross.elsclient.network.Datafactory;
import org.cross.elsclient.vo.GoodsVO;
import org.cross.elsclient.vo.HistoryVO;
import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;
import org.cross.elscommon.dataservice.goodsdataservice.GoodsDataService;
import org.cross.elscommon.po.GoodsPO;
import org.cross.elscommon.util.City;
import org.cross.elscommon.util.GoodsState;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StockType;

public class GoodsBLTest {
	public static void main(String[] args) throws RemoteException {
		// 新建Goods
		GoodsVO goods1 = new GoodsVO("G0000000001", StockType.COMMON, City.NANJING,
				OrganizationType.BUSINESSHALL, 50, 30);
		GoodsVO goods2 = new GoodsVO("G0000000002", StockType.Fast, City.NANJING,
				OrganizationType.BUSINESSHALL, 2, 30);

		DataFactoryService datafactory = new Datafactory();
		GoodsInfo goodsInfo = new GoodsInfoImpl(datafactory.getGoodsData());
		GoodsBLImpl goodsBLImpl = new GoodsBLImpl(datafactory.getGoodsData(),
				goodsInfo);

		System.out.println("=======增加快件（addGoods）=======");
		GoodsVO goodsVO = new GoodsVO("R0000003", StockType.COMMON, City.NANJING,
				OrganizationType.BUSINESSHALL, 12, 22);
		ResultMessage addResultMessage = goodsBLImpl.addGoods(goodsVO);
		if (addResultMessage == ResultMessage.SUCCESS) {
			System.out.println("增加成功！");
		} else {
			System.out.println("增加失败！");
		}

		System.out.println("=======测试快件查询（findGoods）=======");
		GoodsVO vo = goodsBLImpl.searchGoods("G002");
//		System.out.println(vo.number);
		ArrayList<HistoryVO> history = goodsBLImpl.findGoods("G001");
		if (history == null) {
			System.out.println("查找失败");
		} else {
			for (int i = 0; i < history.size(); i++) {
				System.out.println("途经 ： " + history.get(i).placeCity
						+ "   时间 ： " + history.get(i).time);
			}
		}

		System.out.println("=======测试更新快件信息（位置和状态）(updateGoods)=======");
		HistoryVO newHistroy = new HistoryVO("2015-11-2 12:39:10",
				City.BEIJING, OrganizationType.BUSINESSHALL, true);
		goodsVO.history.add(newHistroy);
		ResultMessage resultMessage = goodsBLImpl.updateGoods(goodsVO);
		if (resultMessage == ResultMessage.SUCCESS) {
			System.out.println("更新成功");
		} else {
			System.out.println("更新失败");
		}
		// --------看看成功了没----------
		ArrayList<HistoryVO> history2 = goodsBLImpl.findGoods("G002");
		for (int i = 0; i < history2.size(); i++) {
			System.out.println("途经 ： " + history2.get(i).placeCity + "   时间 ： "
					+ history2.get(i).time);
		}
		System.out.println("=======测试得到快件所有信息(searchGoods)=======");
		GoodsVO goods = goodsBLImpl.searchGoods("G003");
		if (goods != null) {
			System.out.println("search successfully");
		}

	}

}
