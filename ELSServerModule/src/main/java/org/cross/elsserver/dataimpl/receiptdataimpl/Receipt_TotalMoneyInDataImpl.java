package org.cross.elsserver.dataimpl.receiptdataimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.po.Receipt_TotalMoneyInPO;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;
import org.cross.elsserver.database.MySQL;
import org.cross.elsserver.dataimpl.tools.ReceiptTool;

public class Receipt_TotalMoneyInDataImpl implements ReceiptTool {
	private MySQL mysql;

	public Receipt_TotalMoneyInDataImpl() {
		this.mysql = MySQL.getMysql();
	}

	@Override
	public ResultMessage insert(ReceiptPO po) {
		Receipt_TotalMoneyInPO realpo = (Receipt_TotalMoneyInPO) po;
		String sql = "insert ignore into `receiptTotalMoneyIn`(`number`, `time`, `money`, `accountNum`) values ('"
				+ realpo.getNumber() + "','" + realpo.getTime() + "'," + realpo.getMoney() + ",'"
				+ realpo.getAccountNum() + "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}

	@Override
	public ReceiptPO getFromDB(ResultSet rs) {
		Receipt_TotalMoneyInPO po = null;
//		String sql = "select * from `receiptTotalMoneyIn` where `number`='" + number + "'";
//		ResultSet rs = mysql.query(sql);
		try {
//			if (rs.next()) {
				po = new Receipt_TotalMoneyInPO(rs.getString("number"), ReceiptType.TOTALMONEYIN, rs.getString("time"), null, null,
						rs.getDouble("money"), rs.getString("accountNum"));
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

}
