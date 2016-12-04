package org.cross.elsserver.dataimpl.receiptdataimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.po.Receipt_StockInPO;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;
import org.cross.elsserver.database.MySQL;
import org.cross.elsserver.dataimpl.tools.ReceiptTool;

public class Receipt_StockInDataImpl implements ReceiptTool {

	private MySQL mysql;

	public Receipt_StockInDataImpl() {
		this.mysql = MySQL.getMysql();
	}

	@Override
	public ResultMessage insert(ReceiptPO pos) {
		Receipt_StockInPO po = (Receipt_StockInPO) pos;
		String sql = "insert ignore into `receiptStockIn`(`number`, `time`,`orderNum`, `stockAreaNum`, `destination`) values ('"
				+ po.getNumber() + "','" + po.getTime() + "','" + po.getOrderNum() + "','" + po.getStockNum() + "','"
				+ po.getDestination() + "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}

	@Override
	public ReceiptPO getFromDB(ResultSet rs) {
		Receipt_StockInPO po = null;
//		String sql = "select * from `receiptStockIn` where `number`='" + number + "'";
//		ResultSet rs = mysql.query(sql);
		try {
//			if (rs.next()) {
				po = new Receipt_StockInPO(rs.getString("number"), ReceiptType.STOCKIN, rs.getString("time"), null, null,
						rs.getString("orderNum"), rs.getString("stockAreaNum"), rs.getString("destination"));
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
