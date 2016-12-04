package org.cross.elsserver.dataimpl.receiptdataimpl;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.po.Receipt_DeliverPO;
import org.cross.elscommon.po.Receipt_OrderPO;
import org.cross.elscommon.po.Receipt_TransPO;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;
import org.cross.elsserver.database.MySQL;
import org.cross.elsserver.dataimpl.tools.ReceiptTool;

public class Receipt_TransDataImpl implements ReceiptTool {

	private MySQL mysql;

	public Receipt_TransDataImpl() {
		this.mysql = MySQL.getMysql();
	}

	@Override
	public ResultMessage insert(ReceiptPO po) {
		Receipt_TransPO pos = (Receipt_TransPO) po;
		String sql = "insert ignore into `receiptTrans`(`number`, `time`, `transNum`, `veNum`, `startPlace`, `endPlace`, `observer`, `driver`, `cost`) values ('"
				+ pos.getNumber() + "','" + pos.getTime() + "','" + pos.getTransNum() + "','" + pos.getVeNum() + "','"
				+ pos.getStartPlace() + "','" + pos.getArrivePlace() + "','" + pos.getObserver() + "','"
				+ pos.getDriver() + "'," + pos.getCost() + ")";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}

	@Override
	public ReceiptPO getFromDB(ResultSet rs) {
		Receipt_TransPO po = null;
//		String sql = "select * from `receiptTrans` where `number`='" + number + "'";
//		ResultSet rs = mysql.query(sql);
		try {
//			if (rs.next()) {
				po = new Receipt_TransPO(rs.getString("number"), ReceiptType.TRANS, rs.getString("time"), null, null,
						rs.getDouble("cost"), rs.getString("transNum"), rs.getString("veNum"),
						rs.getString("startPlace"), rs.getString("endPlace"), rs.getString("observer"),
						rs.getString("driver"));
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		sql = "select * from `receipt` where `number`='" + number + "'";
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
		Receipt_TransDataImpl impl = new Receipt_TransDataImpl();
//		Receipt_TransPO po = impl.
	}

}
