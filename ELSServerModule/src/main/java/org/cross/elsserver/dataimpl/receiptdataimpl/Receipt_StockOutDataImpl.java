package org.cross.elsserver.dataimpl.receiptdataimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.po.Receipt_StockOutPO;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;
import org.cross.elsserver.database.MySQL;
import org.cross.elsserver.dataimpl.tools.ReceiptTool;

public class Receipt_StockOutDataImpl implements ReceiptTool {

	private MySQL mysql;

	public Receipt_StockOutDataImpl() {
		this.mysql = MySQL.getMysql();
	}

	@Override
	public ResultMessage insert(ReceiptPO po) {
		Receipt_StockOutPO realpo = (Receipt_StockOutPO) po;
		String sql = "insert ignore into `receiptStockOut`(`number`, `time`, `orderNum`, `transNum`, `transType`, `destination`) values ('"
				+ realpo.getNumber() + "','" + realpo.getTime() + "','" + realpo.getOrderNum() + "','"
				+ realpo.getTransNumber() + "','" + realpo.getTransType().toString() + "','" + realpo.getDestination()
				+ "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		else
			return ResultMessage.SUCCESS;
	}

	@Override
	public ReceiptPO getFromDB(ResultSet rs) {
		Receipt_StockOutPO po = null;
//		String sql = "select * from `receiptStockOut` where `number`='" + number + "'";
//		ResultSet rs = mysql.query(sql);
		try {
//			if (rs.next()) {
				po = new Receipt_StockOutPO(rs.getString("number"), ReceiptType.STOCKOUT, rs.getString("time"), null, null,
						rs.getString("orderNum"), rs.getString("destination"),
						StringToType.toVehicleType(rs.getString("transType")), rs.getString("transNum"));
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
