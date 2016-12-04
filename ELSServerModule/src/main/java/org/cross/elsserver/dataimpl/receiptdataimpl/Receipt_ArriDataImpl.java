package org.cross.elsserver.dataimpl.receiptdataimpl;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.po.Receipt_ArrivePO;
import org.cross.elscommon.po.Receipt_OrderPO;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;
import org.cross.elsserver.database.MySQL;
import org.cross.elsserver.dataimpl.tools.ReceiptTool;

public class Receipt_ArriDataImpl implements ReceiptTool {

	private MySQL mysql;

	public Receipt_ArriDataImpl() {
		this.mysql = MySQL.getMysql();
	}

	@Override
	public ResultMessage insert(ReceiptPO po) {
		Receipt_ArrivePO arrivePO = (Receipt_ArrivePO) po;
		String sql = "insert ignore into `receiptArrive`(`time`, `number`, `startCity`, `transNum`, `startTime`) values ('"
				+ arrivePO.getTime() + "','" + arrivePO.getNumber() + "','" + arrivePO.getStartPlace()
				+ "','" + arrivePO.getTransNum() + "','" + arrivePO.getStartTime()
				+ "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}

	@Override
	public ReceiptPO getFromDB(ResultSet rs) {
//		String sql = "select * from `receiptArrive` where `number`='" + number + "'";
		Receipt_ArrivePO po = null;
//		ResultSet rs = mysql.query(sql);
		try {
//			if (rs.next()) {
				po = new Receipt_ArrivePO(rs.getString("number"), ReceiptType.ARRIVE, rs.getString("time"), null, null,
						rs.getString("startCity"), rs.getString("startTime"), rs.getString("transNum"));
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		sql = "select * from `receipt` where `number`='"+number+"'";
//		rs = mysql.query(sql);
		try {
//			if (rs.next()) {
				po.setApproveState(StringToType.toApproveType(rs.getString("approveState")));
				po.setOrgNum(rs.getString("orgNum"));
				po.setPerNum(rs.getString("perNum"));
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}
	public static void main(String[] args) throws RemoteException{
		Receipt_ArriDataImpl impl = new Receipt_ArriDataImpl();
		Receipt_ArrivePO arrive1 = new Receipt_ArrivePO("R0000003", ReceiptType.ARRIVE,"2015-12-08 23:58", "O001","P002", "O002",
				"2015-12-08 20:01","R0000011");
		if(impl.insert(arrive1) == ResultMessage.SUCCESS) System.out.println("su");
		else System.out.println("fail");
	}

}
