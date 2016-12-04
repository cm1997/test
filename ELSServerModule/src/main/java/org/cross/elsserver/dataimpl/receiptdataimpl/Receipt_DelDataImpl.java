package org.cross.elsserver.dataimpl.receiptdataimpl;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.po.Receipt_DeliverPO;
import org.cross.elscommon.po.Receipt_OrderPO;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;
import org.cross.elsserver.database.MySQL;
import org.cross.elsserver.dataimpl.tools.ReceiptTool;

public class Receipt_DelDataImpl implements ReceiptTool {

	private MySQL mysql;

	public Receipt_DelDataImpl() {
		this.mysql = MySQL.getMysql();
	}

	@Override
	public ResultMessage insert(ReceiptPO po) {
		Receipt_DeliverPO delpo = (Receipt_DeliverPO) po;
		String sql = "insert ignore into `receiptDeliver`(`number`, `orderNum`, `name`, `posterNum`, `time`) values ('"
				+ delpo.getNumber() + "','" + delpo.getOrderNum() + "','" + delpo.getName() + "','"
				+ delpo.getPosterNum() + "','" + delpo.getTime() + "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}

	@Override
	public ReceiptPO getFromDB(ResultSet rs) {
//		String sql = "select * from `receiptDeliver` where `number`='" + number + "'";
		Receipt_DeliverPO po = null;
//		ResultSet rs = mysql.query(sql);
		try {
//			if (rs.next()) {
				po = new Receipt_DeliverPO(rs.getString("number"), ReceiptType.DELIVER, rs.getString("time"), null, null,
						rs.getString("orderNum"), rs.getString("name"), rs.getString("posterNum"));
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
		Receipt_DelDataImpl impl =  new Receipt_DelDataImpl();
		Receipt_OrderPO order1 = new Receipt_OrderPO("R0000001",ReceiptType.ORDER, "2015-10-01 19:30", "O001","P001", 20, 
				"2015-10-03", "陈丹妮", "陈睿", "南京大学", "南京大学","江苏省南京市南京大学仙林校区", "江苏省南京市南京大学仙林校区",
				"934782738", "83247376", "13333333333", "18351000000");
		Receipt_DeliverPO delpo = new Receipt_DeliverPO("R0000002", ReceiptType.DELIVER, "time", "org", "per", "order", "cr", "cdn");
		if(impl.insert(delpo) == ResultMessage.SUCCESS) System.out.println("su");
		else System.out.println("fail");
	}

}
