package org.cross.elsserver.dataimpl.stockdataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.cross.elscommon.dataservice.stockdataservice.StockDataService;
import org.cross.elscommon.po.StockAreaPO;
import org.cross.elscommon.po.StockOperationPO;
import org.cross.elscommon.po.StockPO;
import org.cross.elscommon.util.CompareTime;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;
import org.cross.elsserver.database.MySQL;

//import com.mysql.fabric.xmlrpc.base.Array;

@SuppressWarnings("serial")
public class StockDataImpl extends UnicastRemoteObject implements StockDataService {

	private MySQL mysql;

	public StockDataImpl() throws RemoteException {
		super();
		this.mysql = MySQL.getMysql();
	}

	@Override
	public ResultMessage insertStock(StockPO po) throws RemoteException {
		String sql = "insert ignore into `stock`(`number`, `totalAreas`, `usedAreas`, `numOut`, `numIn`, `moneyOut`, `moneyIn`, `numInStock`, `orgNum`) values ('"
				+ po.getNumber() + "'," + po.getTotalAreas() + "," + po.getUsedAreas() + "," + po.getNumOut() + ","
				+ po.getNumIn() + "," + po.getMoneyOut() + "," + po.getMoneyIn() + "," + po.getNumInStock() + ",'"
				+ po.getOrgNum() + "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage updateStock(StockPO po) throws RemoteException {
		String sql = "delete from `stock` where `number` = '" + po.getNumber()+"'";
		if(!mysql.execute(sql)) return ResultMessage.FAILED;
		return insertStock(po);
	}

	@Override
	public StockPO findStockByNumber(String number) throws RemoteException {
		String sql = "select * from `stock` where `number`='"+number+"'";
		ResultSet rs = mysql.query(sql);
		return getStockFromDB(rs);
	}

	@Override
	public StockPO findStockByOrg(String orgNum) throws RemoteException {
		String sql = "select * from `stock` where `orgNum`='"+orgNum+"'";
		ResultSet rs = mysql.query(sql);
		return getStockFromDB(rs);
	}

	@Override
	public ArrayList<StockPO> showStock() throws RemoteException {
		String sql = "select * from `stock`";
		ResultSet rs = mysql.query(sql);
		ArrayList<StockPO> list =new ArrayList<StockPO>();
		StockPO po = null;
		while((po=getStockFromDB(rs))!=null) list.add(po);
		return list;
	}

	@Override
	public ResultMessage insertStockArea(StockAreaPO po) throws RemoteException {
		String sql = "insert ignore into `stockArea`(`number`, `totalCapacity`, `usedCapacity`, `type`, `stockNum`) values ('"
				+ po.getNumber() + "'," + po.getTotalCapacity() + "," + po.getUsedCapacity() + ",'"
				+ po.getStockType().toString() + "','" + po.getStockNum() + "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage updateStockArea(StockAreaPO po) throws RemoteException {
		String sql = "delete from `stockArea` where `number`='"+po.getNumber()+"'";
		if(!mysql.execute(sql)) return ResultMessage.FAILED;
		return insertStockArea(po);
	}

	@Override
	public StockAreaPO findStockAreaByNumber(String number) throws RemoteException {
		String sql = "select * from `stockArea` where `number`='"+number+"'";
		ResultSet rs = mysql.query(sql);
		return getStockAreaFromDB(rs);
	}

	@Override
	public ArrayList<StockAreaPO> findStockAreaByStock(String stockNum) throws RemoteException {
		String sql = "select * from `stockArea` where `stockNum` = '"+stockNum+"'";
		ResultSet rs = mysql.query(sql);
		ArrayList<StockAreaPO> list =new ArrayList<StockAreaPO>();
		StockAreaPO po = null;
		while((po=getStockAreaFromDB(rs))!=null) list.add(po);
		return list;
	}

	@Override
	public ArrayList<StockAreaPO> showStockArea() throws RemoteException {
		String sql = "select * from `stockArea`";
		ResultSet rs = mysql.query(sql);
		ArrayList<StockAreaPO> list =new ArrayList<StockAreaPO>();
		StockAreaPO po = null;
		while((po=getStockAreaFromDB(rs))!=null) list.add(po);
		return list;
	}

	@Override
	public ResultMessage insertStockOP(StockOperationPO po) throws RemoteException {
		String sql = "insert ignore into `stockOperation`(`time`, `opType`, `goodsNum`, `money`, `stockType`, `stockAreaNum`,`stockNum`) values ('"
				+ po.getTime() + "','" + po.getOpType().toString() + "','" + po.getGoodsNum() + "'," + po.getMoney()
				+ ",'" + po.getStockType().toString() + "','" + po.getStockAreaNum() + "','" + po.getStockNum() + "')";
		if(!mysql.execute(sql)) return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<StockOperationPO> findStockOPByStock(String stockNum) throws RemoteException {
		String sql = "select * from `stockOperation` where `stockNum` = '"+stockNum+"'";
		ResultSet rs = mysql.query(sql);
		ArrayList<StockOperationPO> list =new ArrayList<StockOperationPO>();
		StockOperationPO po = null;
		while((po=getStockOPFromDB(rs))!=null) list.add(po);
		return list;
	}

	@Override
	public ArrayList<StockOperationPO> findStockOPByTime(String startTime, String endTime) throws RemoteException {
		ArrayList<StockOperationPO> list = showStockOP();
		for (int i = 0; i < list.size(); i++) {
			if (CompareTime.compare(startTime, list.get(i).getTime()) == 1 || CompareTime.compare(list.get(i).getTime(), endTime) == 1){
				list.remove(i);
			}
		}
		return list;
	}

	@Override
	public ArrayList<StockOperationPO> showStockOP() throws RemoteException {
		String sql = "select * from `stockOperation`";
		ResultSet rs = mysql.query(sql);
		ArrayList<StockOperationPO> list =new ArrayList<StockOperationPO>();
		StockOperationPO po = null;
		while((po=getStockOPFromDB(rs))!=null) list.add(po);
		return list;
	}

	public StockPO getStockFromDB(ResultSet rs) {
		// `number`, `totalAreas`, `usedAreas`, `numOut`, `numIn`, `moneyOut`,
		// `moneyIn`, `numInStock`, `orgNum`
		StockPO po = null;
		try {
			if (rs.next()) {
				po = new StockPO(rs.getString("number"), rs.getInt("totalAreas"), rs.getString("orgNum"));
				po.setMoneyIn(rs.getDouble("moneyIn"));
				po.setMoneyOut(rs.getDouble("moneyOut"));
				po.setNumIn(rs.getInt("numIn"));
				po.setNumOut(rs.getInt("numOut"));
				po.setUsedAreas(rs.getInt("usedAreas"));
				po.setNumInStock(rs.getInt("numInStock"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

	public StockAreaPO getStockAreaFromDB(ResultSet rs) {
		// `number`, `totalCapacity`, `usedCapacity`, `type`, `stockNum`
		StockAreaPO po = null;
		try {
			if (rs.next()) {
				po = new StockAreaPO(rs.getString("number"), StringToType.toGoodsType(rs.getString("type")),
						rs.getInt("totalCapacity"), rs.getString("stockNum"));
				po.setUsedCapacity(rs.getInt("usedCapacity"));
//				System.out.println(po.getStockType());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

	public StockOperationPO getStockOPFromDB(ResultSet rs) {
		// `time`, `opType`, `goodsNum`, `money`, `stockType`, `stockAreaNum`,
		// `stockNum`
		StockOperationPO po = null;
		try {
			if (rs.next()) {
				po = new StockOperationPO(rs.getString("time"), StringToType.toStockOperation(rs.getString("opType")),
						rs.getString("goodsNum"), rs.getDouble("money"),
						StringToType.toGoodsType(rs.getString("stockType")), rs.getString("stockNum"),
						rs.getString("stockAreaNum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

	@Override
	public ArrayList<StockOperationPO> findStockOPByTimeAndStock(String stockNum, String startTime, String endTime)
			throws RemoteException {
		ArrayList<StockOperationPO> list = new ArrayList<StockOperationPO>();
		list = findStockOPByTime(startTime, endTime);
//		System.out.println("data/opsize:"+list.size());
		for (int i = 0; i < list.size(); i++) {
			StockOperationPO po = list.get(i);
//			System.out.println(i+"  "+po.getStockNum());
			if (!po.getStockNum().equals(stockNum)) {
				list.remove(i);
			}
		}
		return list;
	}
	
	public static void main(String[] args){
		try {
			StockDataImpl stockDataImpl = new StockDataImpl();
//			StockAreaPO po = stockDataImpl.findStockAreaByNumber("SA00001");
//			StockPO stockPO = stockDataImpl.findStockByNumber("S001");
//			System.out.println(po.getNumber() + " " + po.getStockType());
//			System.out.println(stockPO.getNumber());
//			ArrayList<StockOperationPO> operationPOs = stockDataImpl.findStockOPByTime("2015-10-23 10:12:01", "2015-12-12 10:20:01");
//			ArrayList<StockAreaPO> areaPOs = stockDataImpl.findStockAreaByStock("S0032902");
//			System.out.println(CompareTime.compare("2015-10-23 10:12:01", "2015-12-12 10:20:01"));
//			System.out.println(CompareTime.compare("2015-10-23 10:12",operationPOs.get(0).getTime()));
//			System.out.println(operationPOs.size());
			ArrayList<StockOperationPO> ops1 = stockDataImpl.findStockOPByTime("2015-12-18", "2015-12-19");
			ArrayList<StockOperationPO> ops = stockDataImpl.findStockOPByTimeAndStock("S001","2015-12-18", "2015-12-19");
			System.out.println(ops.size());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
