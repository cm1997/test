/**
 * 快件信息管理的桩程序
 * @author danni
 * @date 2015/10/20
 */
package org.cross.elsclient.blservice.goodsblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.GoodsState;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StockType;
import org.cross.elsclient.vo.GoodsVO;
import org.cross.elsclient.vo.HistoryVO;

public class GoodsBLService_Stub implements GoodsBLService{

	@Override
	public ResultMessage updateGoods(GoodsVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<HistoryVO> findGoods(String id) {
		// TODO Auto-generated method stub
//		GoodsVO goods = new GoodsVO(id, null, null, null, 10, 10);
		ArrayList<HistoryVO> list = new ArrayList<>();
		
		list.add(new HistoryVO("2015-10-01 10:51", City.BEIJING, OrganizationType.BUSINESSHALL, true));
		list.add(new HistoryVO("2015-10-01 10:21", City.BEIJING, OrganizationType.BUSINESSHALL, false));
		list.add(new HistoryVO("2015-10-01 10:41", City.BEIJING, OrganizationType.BUSINESSHALL, false));
		list.add(new HistoryVO("2015-10-01 10:31", City.BEIJING, OrganizationType.BUSINESSHALL, true));
		list.add(new HistoryVO("2015-10-01 11:21", City.BEIJING, OrganizationType.BUSINESSHALL, false));
		list.add(new HistoryVO(null, City.BEIJING, OrganizationType.BUSINESSHALL, true));
		
		return list;
	}

	@Override
	public ResultMessage addGoods(GoodsVO goods) throws RemoteException {
		return ResultMessage.SUCCESS;
	}

	@Override
	public GoodsVO searchGoods(String goodsID) throws RemoteException {
		return new GoodsVO(goodsID, null, null, null, 10, 10);
	}
	
}
