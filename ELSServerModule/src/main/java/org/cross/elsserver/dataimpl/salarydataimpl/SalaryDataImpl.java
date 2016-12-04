package org.cross.elsserver.dataimpl.salarydataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.cross.elscommon.dataservice.salarydataservice.SalaryDataService;
import org.cross.elscommon.po.SalaryPO;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.SalaryType;
import org.cross.elscommon.util.StringToType;
import org.cross.elsserver.database.MySQL;

public class SalaryDataImpl extends UnicastRemoteObject implements SalaryDataService {

	MySQL mysql;

	public SalaryDataImpl() throws RemoteException {
		super();
		this.mysql = MySQL.getMysql();
	}

	@Override
	public ResultMessage insert(SalaryPO po) throws RemoteException {
		String sql = "insert ignore into `salary`(`type`, `salaryByMonth`, `addOnce`, `addNum`, `perNum`) values ('"
				+ po.getType().toString() + "'," + po.getSalaryByMonth() + "," + po.getAddOnce() + "," + po.getAddNum()
				+ ",'" + po.getPerNum() + "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(String perNum) throws RemoteException {
		String sql = "delete from `salary` where `perNum` = '" + perNum + "'";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage update(SalaryPO po) throws RemoteException {
		if (delete(po.getPerNum()) == ResultMessage.FAILED)
			return ResultMessage.FAILED;
		return insert(po);
	}

	@Override
	public ArrayList<SalaryPO> show() throws RemoteException {
		String sql = "select * from `salary`";
		ResultSet rs = mysql.query(sql);
		ArrayList<SalaryPO> list = new ArrayList<SalaryPO>();
		SalaryPO po = null;
		while((po=getFromDB(rs))!=null) list.add(po);
		return list;
	}

	@Override
	public SalaryPO findbyPerNum(String perNum) throws RemoteException {
		String sql = "select * from `salary` where `perNum` = '"+perNum+"'";
		ResultSet rs = mysql.query(sql);
		return getFromDB(rs);
	}

	@Override
	public ArrayList<SalaryPO> findByType(SalaryType type) throws RemoteException {
		String sql = "select * from `salary` where `type`='"+type.toString()+"'";
		ResultSet rs = mysql.query(sql);
		ArrayList<SalaryPO> list = new ArrayList<SalaryPO>();
		SalaryPO po = null;
		while((po=getFromDB(rs))!=null) list.add(po);
		return list;
	}

	public SalaryPO getFromDB(ResultSet rs) {
		SalaryPO po = null;
		try {
			if (rs.next()) {
				po = new SalaryPO(StringToType.toSalaryType(rs.getString("type")), rs.getDouble("salaryByMonth"),
						rs.getDouble("addOnce"), rs.getDouble("addNum"), rs.getString("perNum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

}
