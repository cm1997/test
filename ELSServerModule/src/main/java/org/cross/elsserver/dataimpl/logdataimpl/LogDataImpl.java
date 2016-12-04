package org.cross.elsserver.dataimpl.logdataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.cross.elscommon.dataservice.logdataservice.LogDataService;
import org.cross.elscommon.po.LogPO;
import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.util.CompareTime;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elsserver.database.MySQL;

public class LogDataImpl extends UnicastRemoteObject implements LogDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MySQL mysql;

	public LogDataImpl() throws RemoteException {
		super();
		mysql = MySQL.getMysql();
	}

	@Override
	public ResultMessage insert(LogPO po) throws RemoteException {
		String sql = "insert ignore into `log`(`number`, `time`, `operator`, `operation`) values ('" + po.getNumber()
				+ "','" + po.getTime() + "','" + po.getOperator() + "','" + po.getOperation() + "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<LogPO> find(String startTime, String endTime) throws RemoteException {
		ArrayList<LogPO> logs = show();
		Iterator<LogPO> ite = logs.iterator();
		while(ite.hasNext()) {
			LogPO po = ite.next();
			if (CompareTime.compare(po.getTime(), startTime) != 1
					|| CompareTime.compare(endTime, po.getTime()) != 1) {
//				ReceiptPO po = findByNum(rs.getString("number"));
				ite.remove();
			}
		}
//		for (int i = 0; i < logs.size(); i++) {
//			boolean con1 = false;
//			boolean con2 = false;
//			if (CompareTime.compare(startTime, logs.get(i).getTime()) == 1)
//				con1 = true;
//			if (CompareTime.compare(logs.get(i).getTime(), endTime) == 1)
//				con2 = true;
//			if (con1 || con2) {
//				logs.remove(i);
//			}
//		}
		return logs;
	}

	@Override
	public ArrayList<LogPO> show() throws RemoteException {
		String sql = "select * from `log`";
		ArrayList<LogPO> logs = new ArrayList<LogPO>();
		ResultSet rs = mysql.query(sql);
		LogPO log = null;
		while ((log = getFromDB(rs)) != null)
			logs.add(log);
		return logs;
	}

	public LogPO getFromDB(ResultSet rs) {
		LogPO po = null;
		try {
			if (rs.next()) {
				po = new LogPO(rs.getString("number"), rs.getString("time"), rs.getString("operator"),
						rs.getString("operation"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

	public static void main(String[] args) throws RemoteException{
		LogDataImpl impl = new LogDataImpl();
		ArrayList<LogPO> show = impl.find("2015-10-4", "2015-12-25");
		for (int i = 0; i < show.size(); i++) {
			System.out.println(show.get(i).getNumber() + " " + show.get(i).getOperation()
					+ " " + show.get(i).getTime());
		}
	}
}
