package org.cross.elsserver.dataimpl.numberdataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.cross.elscommon.dataservice.numberdataservice.NumberDataService;
import org.cross.elscommon.po.NumberPO;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elsserver.database.MySQL;

public class NumberDataImpl extends UnicastRemoteObject implements NumberDataService {

	MySQL mysql;

	public NumberDataImpl() throws RemoteException {
		super();
		mysql = MySQL.getMysql();
	}

	// `goodsNum`, `initNum`, `logNum`, `orgNum`, `perNum`, `userNum`,
	// `receiptNum`, `stockNum`, `stockAreaNum`, `vehicleNum`
	@Override
	public ResultMessage insert(NumberPO po) throws RemoteException {
		String sql = "insert into `number`(`goodsNum`, `initNum`, `logNum`, `orgNum`, `perNum`, `userNum`, `receiptNum`, `stockNum`, `stockAreaNum`, `vehicleNum`) values ('"
				+ po.getGoodsNum() + "','" + po.getInitNum() + "','" + po.getLogNum() + "','" + po.getOrgNum() + "','"
				+ po.getPerNum() + "','" + po.getUserNum() + "','" + po.getReceiptNum() + "','" + po.getStockNum()
				+ "','" + po.getStockAreaNum() + "','" + po.getVehicleNum() + "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage update(NumberPO po) throws RemoteException {
		String sql = "delete from `number` where 1";
		mysql.execute(sql);
		return insert(po);
	}

	@Override
	public NumberPO show() throws RemoteException {
		String sql = "select * from `number`";
		ResultSet rs = mysql.query(sql);
		NumberPO po = null;
		try {
			if (rs.next()) {
				po = new NumberPO(rs.getString("goodsNum"), rs.getString("initNum"), rs.getString("logNum"),
						rs.getString("orgNum"), rs.getString("perNum"), rs.getString("userNum"),
						rs.getString("receiptNum"), rs.getString("stockNum"), rs.getString("stockAreaNum"),
						rs.getString("vehicleNum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

}
