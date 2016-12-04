package org.cross.elsserver.dataimpl.receiptdataimpl;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.po.Receipt_DeliverPO;
import org.cross.elscommon.po.Receipt_MoneyInPO;
import org.cross.elscommon.po.Receipt_OrderPO;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;
import org.cross.elsserver.database.MySQL;
import org.cross.elsserver.dataimpl.tools.ReceiptTool;

public class Receipt_MoneyInDataImpl implements ReceiptTool {

	private MySQL mysql;

	public Receipt_MoneyInDataImpl() {
		this.mysql = MySQL.getMysql();
	}

	@Override
	public ResultMessage insert(ReceiptPO po) {
		Receipt_MoneyInPO realpo = (Receipt_MoneyInPO) po;
		String sql = "insert ignore into `receiptMoneyIn`(`number`, `time`, `money`, `totalMoneyInNum`, `person`) values ('"
				+ realpo.getNumber() + "','" + realpo.getTime() + "'," + realpo.getMoney() + ",'"
				+ realpo.getTotalMoneyInNum() +"','"+ realpo.getPerson()+"')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}

	@Override
	public ReceiptPO getFromDB(ResultSet rs) {
		Receipt_MoneyInPO po = null;
//		String sql = "select * from `receiptMoneyIn` where `number`='" + number + "'";
//		ResultSet rs = mysql.query(sql);
		try {
//			if (rs.next()) {
				po = new Receipt_MoneyInPO(rs.getString("number"), ReceiptType.MONEYIN, rs.getString("time"), null,
						null, rs.getDouble("money"), rs.getString("totalMoneyInNum"), rs.getString("person"));
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
		Receipt_MoneyInDataImpl impl = new Receipt_MoneyInDataImpl();
		
		Receipt_MoneyInPO po = new Receipt_MoneyInPO("R0000009", ReceiptType.MONEYIN, "time", "org", "per", 20, null, "cr");
		if(impl.insert(po) == ResultMessage.SUCCESS) System.out.println("su");
		else System.out.println("fail");
	}

}
