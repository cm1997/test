package org.cross.elsserver.dataimpl.goodsdataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.cross.elscommon.dataservice.goodsdataservice.GoodsDataService;
import org.cross.elscommon.po.GoodsPO;
import org.cross.elscommon.po.HistoryPO;
import org.cross.elscommon.util.City;
import org.cross.elscommon.util.GoodsState;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StockType;
import org.cross.elscommon.util.StringToType;
import org.cross.elsserver.database.MySQL;
import org.cross.elsserver.dataimpl.tools.HistoryTool;

public class GoodsDataImpl extends UnicastRemoteObject implements GoodsDataService {

	private HistoryTool historyTool;
	MySQL mysql;

	public GoodsDataImpl() throws RemoteException {
		super();
		this.historyTool = new HistoryDataImpl();
		mysql = MySQL.getMysql();
	}

	@Override
	public ResultMessage addHistory(String number, HistoryPO history) throws RemoteException {
		return historyTool.insert(history, number);
	}

	@Override
	public ResultMessage insert(GoodsPO po) throws RemoteException {
		String sql = "insert ignore into `goods`(`number`, `type`, `placeCity`, `placeOrg`, `state`, `weight`, `volume`) values ('"
				+ po.getOrderNum() + "','" + po.getGoodsType().toString() + "','" + po.getPlaceCity().toString() + "','"+po.getPlaceOrg().toString()+"','"
				+ po.getState().toString() + "'," + po.getWeight() + "," + po.getVolume() + ")";
		if (mysql.execute(sql)) {
			return ResultMessage.SUCCESS;
		}else return ResultMessage.FAILED;
	}

	@Override
	public ResultMessage update(GoodsPO po) throws RemoteException {
		String sql = "update `goods` set `state`='"+po.getState().toString()+"' where `number`='"+po.getOrderNum()+"'";
		if(!mysql.execute(sql)) return ResultMessage.FAILED;
		if (po.getStockAreaNum()!=null) {
			sql = "update `goods` set `stockAreaNum`='"+po.getStockAreaNum()+"' where `number`='"+po.getOrderNum()+"'";
			if(!mysql.execute(sql)) return ResultMessage.FAILED;
		}
		if (po.getStockNum()!=null) {
			sql = "update `goods` set `stockNum`='"+po.getStockNum()+"' where `number`='"+po.getOrderNum()+"'";
			if(!mysql.execute(sql)) return ResultMessage.FAILED;
		}
		if (po.getArriNum()!=null) {
			sql = "update `goods` set `arriNum`='"+po.getArriNum()+"' where `number`='"+po.getOrderNum()+"'";
			if(!mysql.execute(sql)) return ResultMessage.FAILED;
		}
		if (po.getTransNum()!=null) {
			sql = "update `goods` set `transNum`='"+po.getTransNum()+"' where `number`='"+po.getOrderNum()+"'";
			if(!mysql.execute(sql)) return ResultMessage.FAILED;
		}
		if (po.getDelNum()!=null) {
			sql = "update `goods` set `delNum`='"+po.getDelNum()+"' where `number`='"+po.getOrderNum()+"'";
			if(!mysql.execute(sql)) return ResultMessage.FAILED;
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public GoodsPO findByNum(String number) throws RemoteException {
		String sql = "select * from `goods` where `number`='"+number+"'";
		ResultSet rs = mysql.query(sql);
		return getGoodsFromDB(rs);
	}

	@Override
	public ArrayList<GoodsPO> findByStockAreaNum(String stockAreaNum) throws RemoteException {
		return findGoods("stockAreaNum",stockAreaNum);
	}

	@Override
	public ArrayList<GoodsPO> findByStockNum(String stockNum) throws RemoteException {
		return findGoods("stockNum",stockNum);
	}

	@Override
	public ArrayList<GoodsPO> findByTransNum(String transNum) throws RemoteException {
		return findGoods("transNum",transNum);
	}

	@Override
	public ArrayList<GoodsPO> findByArriNum(String arriNum) throws RemoteException {
		return findGoods("arriNum",arriNum);
	}

	@Override
	public ArrayList<GoodsPO> findByDelNum(String delNum) throws RemoteException {
		return findGoods("delNum",delNum);
	}

	@Override
	public ArrayList<HistoryPO> findHistory(String number) throws RemoteException {
		return historyTool.findByOrderNum(number);
	}
	
	public ArrayList<GoodsPO> findGoods(String tableNum, String number){
		ArrayList<GoodsPO> list = new ArrayList<GoodsPO>();
		String sql = "select * from `goods` where `"+tableNum+"` ='"+number+"'";
		ResultSet rs = mysql.query(sql);
		GoodsPO po = null;
		while ((po=getGoodsFromDB(rs))!=null) list.add(po);
		return list;	
	}

	// 可能会get到一些null
	public GoodsPO getGoodsFromDB(ResultSet rs) {
		GoodsPO po = null;
		try {
			if (rs.next()) {
				po = new GoodsPO(StringToType.toGoodsType(rs.getString("type")),
						StringToType.toCity(rs.getString("placeCity")), StringToType.toOrg(rs.getString("placeOrg")),
						StringToType.toGoodsState(rs.getString("state")), rs.getInt("weight"), rs.getInt("volume"),
						rs.getString("number"));
				po.setArriNum(rs.getString("arriNum"));
				po.setDelNum(rs.getString("delNum"));
				po.setTransNum(rs.getString("transNum"));
				po.setStockAreaNum(rs.getString("stockAreaNum"));
				po.setStockNum(rs.getString("stockNum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}
	
	public static void main(String[] args) throws RemoteException{
		GoodsPO goods = new GoodsPO(StockType.COMMON, City.NANJING,OrganizationType.BUSINESSHALL, GoodsState.LITTLEDIE, 20, 20, "G009");
		goods.setStockNum("null");
		GoodsDataImpl impl = new GoodsDataImpl();
		goods.setPlaceCity(City.BEIJING);
		if(impl.update(goods) == ResultMessage.SUCCESS) System.out.println("su");
		else System.out.println("fa");
		
		ArrayList<GoodsPO> goodsPOs = impl.findByStockAreaNum("SA00002");
		System.out.println(goodsPOs.size());
	}

}
