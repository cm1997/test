package org.cross.elsserver.dataimpl.receiptdataimpl;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.po.Receipt_OrderPO;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;
import org.cross.elsserver.database.MySQL;
import org.cross.elsserver.dataimpl.tools.ReceiptTool;

public class Receipt_OrderDataImpl implements ReceiptTool {

	private MySQL mysql;

	public Receipt_OrderDataImpl() {
		this.mysql = MySQL.getMysql();
	}

	public ResultMessage insert(ReceiptPO pop) {
		Receipt_OrderPO po = (Receipt_OrderPO) pop;
		String sql = "insert ignore into `receiptOrder`(`number`, `time`, `price`, `receiveTime`, `expectTime`, `moneyInNum`, `senderName`, `receiverName`, `senderAdd`, `receiverAdd`, `senderOrg`, `receiverOrg`, `senderPhone`, `receiverPhone`, `senderMobile`, `receiverMobile`) values ('"
				+ po.getNumber() + "','" + po.getTime() + "'," + po.getPrice() + ",'" 
				+ po.getReceiveTime() + "','" + po.getExpectTime() + "','" + po.getMoneyInNum() + "','"
				+ po.getSenderName() + "','" + po.getReceiverName() + "','" + po.getSenderAdd() + "','"
				+ po.getReceiverAdd() + "','" + po.getSenderOrg() + "','" + po.getReceiverOrg() + "','"
				+ po.getSenderPhone() + "','" +po.getReceiverPhone()+"','"+ po.getSenderMobile() + "','" + po.getReceiverMobile() + "')";
		if (!mysql.execute(sql)) {
			return ResultMessage.FAILED;
		} else
			return ResultMessage.SUCCESS;
	}

	public ReceiptPO getFromDB(ResultSet rs) {
		Receipt_OrderPO po = null;
//		String sql = "select * from `receiptOrder` where `number`='" + number + "'";
//		ResultSet rs = mysql.query(sql);
		try {
//			if (rs.next()) {
				po = new Receipt_OrderPO(rs.getString("number"), ReceiptType.ORDER, rs.getString("time"), null, null,
						rs.getDouble("price"), rs.getString("expectTime"),
						rs.getString("senderName"), rs.getString("receiverName"), rs.getString("senderOrg"),
						rs.getString("receiverOrg"), rs.getString("senderAdd"), rs.getString("receiverAdd"),
						rs.getString("senderPhone"), rs.getString("receiverPhone"), rs.getString("senderMobile"),
						rs.getString("receiverMobile"));
				po.setReceiveTime(rs.getString("receiveTime"));
				po.setMoneyInNum(rs.getString("moneyInNum"));
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
		Receipt_OrderDataImpl impl = new Receipt_OrderDataImpl();
		Receipt_OrderPO order1 = new Receipt_OrderPO("R0000001",ReceiptType.ORDER, "2015-10-01 19:30", "O001","P001", 20, 
				"2015-10-03", "陈丹妮", "陈睿", "南京大学", "南京大学","江苏省南京市南京大学仙林校区", "江苏省南京市南京大学仙林校区",
				"934782738", "83247376", "13333333333", "18351000000");
		if(impl.insert(order1) == ResultMessage.SUCCESS) System.out.println("su");
		else System.out.println("fail");
	}
	
}
