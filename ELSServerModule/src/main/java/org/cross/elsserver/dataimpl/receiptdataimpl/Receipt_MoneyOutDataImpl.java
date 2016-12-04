package org.cross.elsserver.dataimpl.receiptdataimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.po.Receipt_MoneyOutPO;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;
import org.cross.elsserver.database.MySQL;
import org.cross.elsserver.dataimpl.tools.ReceiptTool;

public class Receipt_MoneyOutDataImpl implements ReceiptTool {

	private MySQL mysql;

	public Receipt_MoneyOutDataImpl() {
		this.mysql = MySQL.getMysql();
	}

	@Override
	public ResultMessage insert(ReceiptPO po) {
		Receipt_MoneyOutPO realpo = (Receipt_MoneyOutPO) po;
		String sql = "insert ignore into `receiptMoneyOut`(`number`, `time`, `money`, `accountNum`, `clause`, `comments`, `sender`) values ('"
				+ realpo.getNumber() + "','" + realpo.getTime() + "'," + realpo.getMoney() + ",'"
				+ realpo.getAccountNum() + "','" + realpo.getClause() + "','" + realpo.getComments() +"','"+realpo.getSenderNum()+ "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		else
			return ResultMessage.SUCCESS;
	}

	@Override
	public ReceiptPO getFromDB(ResultSet rs) {
		Receipt_MoneyOutPO po = null;
//		String sql = "select * from `receiptMoneyOut` where `number`='" + number + "'";
//		ResultSet rs = mysql.query(sql);
		try {
//			if (rs.next()) {
				po = new Receipt_MoneyOutPO(rs.getString("number"), ReceiptType.MONEYOUT, rs.getString("time"), null,
						null, rs.getDouble("money"), rs.getString("accountNum"), rs.getString("clause"),
						rs.getString("comments"), rs.getString("sender"));
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
