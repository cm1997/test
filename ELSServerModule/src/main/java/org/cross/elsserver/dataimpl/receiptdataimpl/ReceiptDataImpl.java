package org.cross.elsserver.dataimpl.receiptdataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

import org.cross.elscommon.dataservice.receiptdataservice.ReceiptDataService;
import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.po.Receipt_DeliverPO;
import org.cross.elscommon.po.Receipt_OrderPO;
import org.cross.elscommon.po.Receipt_StockOutPO;
import org.cross.elscommon.po.Receipt_TransPO;
import org.cross.elscommon.util.CompareTime;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;
import org.cross.elsserver.database.MySQL;

@SuppressWarnings("serial")
public class ReceiptDataImpl extends UnicastRemoteObject implements
		ReceiptDataService {

	private MySQL mysql;
	private Receipt_OrderDataImpl order;
	private Receipt_ArriDataImpl arri;
	private Receipt_TransDataImpl trans;
	private Receipt_StockInDataImpl stockin;
	private Receipt_StockOutDataImpl stockout;
	private Receipt_MoneyInDataImpl moneyin;
	private Receipt_MoneyOutDataImpl moneyout;
	private Receipt_TotalMoneyInDataImpl totalmoneyin;
	private Receipt_DelDataImpl del;

	public ReceiptDataImpl() throws RemoteException {
		super();
		this.order = new Receipt_OrderDataImpl();
		this.arri = new Receipt_ArriDataImpl();
		this.trans = new Receipt_TransDataImpl();
		this.stockin = new Receipt_StockInDataImpl();
		this.stockout = new Receipt_StockOutDataImpl();
		this.moneyin = new Receipt_MoneyInDataImpl();
		this.moneyout = new Receipt_MoneyOutDataImpl();
		this.totalmoneyin = new Receipt_TotalMoneyInDataImpl();
		this.del = new Receipt_DelDataImpl();
		this.mysql = MySQL.getMysql();
	}

	@Override
	public ResultMessage insert(ReceiptPO po) throws RemoteException {
		String sql = "insert ignore into `receipt`(`number`, `type`, `time`, `approveState`, `perNum`, `orgNum`) values ('"
				+ po.getNumber()
				+ "','"
				+ po.getType().toString()
				+ "','"
				+ po.getTime()
				+ "','"
				+ po.getApproveState().toString()
				+ "','" + po.getPerNum() + "','" + po.getOrgNum() + "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		switch (po.getType()) {
		case ORDER:
			return order.insert(po);
		case TRANS:
			return trans.insert(po);
		case ARRIVE:
			return arri.insert(po);
		case STOCKIN:
			return stockin.insert(po);
		case STOCKOUT:
			return stockout.insert(po);
		case MONEYIN:
			return moneyin.insert(po);
		case MONEYOUT:
			return moneyout.insert(po);
		case TOTALMONEYIN:
			return totalmoneyin.insert(po);
		case DELIVER:
			return del.insert(po);
		default:
			break;
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(String number, ReceiptType type)
			throws RemoteException {
		String sql = "delete from `receipt` where `number` = '" + number + "'";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		sql = "delete from `" + Typetotable.gettable(type)
				+ "` where `number`='" + number + "'";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage updateCheck(String number, String state)
			throws RemoteException {
		String sql = "update `receipt` set `approveState`='" + state
				+ "' where `number`='" + number + "'";
		if (mysql.execute(sql))
			return ResultMessage.SUCCESS;
		else
			return ResultMessage.FAILED;
	}

	@Override
	public ArrayList<ReceiptPO> show() throws RemoteException {
		ArrayList<ReceiptPO> list = new ArrayList<ReceiptPO>();
		list = findreceipts("", "", true);
		return list;
	}

	@Override
	public ReceiptPO findByNum(String number) throws RemoteException {
		ArrayList<ReceiptPO> list = new ArrayList<ReceiptPO>();
		list = findreceipts("number", number, false);
		return list.get(0);
	}

	@Override
	public ArrayList<ReceiptPO> findByTime(String startTime, String endTime)
			throws RemoteException {
		ArrayList<ReceiptPO> receipts = new ArrayList<ReceiptPO>();
		receipts = show();
		Iterator<ReceiptPO> ite = receipts.iterator();
		while(ite.hasNext()) {
			ReceiptPO po = ite.next();
			if (CompareTime.compare(po.getTime(), startTime) != 1
					|| CompareTime.compare(endTime, po.getTime()) != 1) {
				ite.remove();
			}
		}
		return receipts;
	}

	@Override
	public ArrayList<ReceiptPO> findByType(ReceiptType type)
			throws RemoteException {
		ArrayList<ReceiptPO> receipts = new ArrayList<ReceiptPO>();
		receipts = findreceipts("type", type.toString(), false);
		return receipts;
	}

	@Override
	public ArrayList<ReceiptPO> findByTimeAndType(String startTime,
			String endTime, ReceiptType type) throws RemoteException {
		ArrayList<ReceiptPO> receipts = new ArrayList<ReceiptPO>();
//		ArrayList<ReceiptPO> needtoremove = new ArrayList<ReceiptPO>();
		receipts = findByTime(startTime, endTime);
		Iterator<ReceiptPO> ite = receipts.iterator();
		while(ite.hasNext()){
			ReceiptPO po = ite.next();
			if (!po.getType().equals(type)) {
				ite.remove();
			}
		}
		return receipts;
	}

	@Override
	public ResultMessage update(ReceiptPO po) throws RemoteException {
		if (delete(po.getNumber(), po.getType()) == ResultMessage.FAILED)
			return ResultMessage.FAILED;
		return insert(po);
	}

	@Override
	public ArrayList<ReceiptPO> findByPerNum(String perNum)
			throws RemoteException {
		ArrayList<ReceiptPO> list = new ArrayList<ReceiptPO>();
		list = findreceipts("perNum", perNum, false);
		return list;
	}

	@Override
	public ArrayList<ReceiptPO> findByOrgNum(String orgNum)
			throws RemoteException {
		ArrayList<ReceiptPO> list = new ArrayList<ReceiptPO>();
		list = findreceipts("orgNum", orgNum, false);
		return list;
	}

	public ArrayList<ReceiptPO> findreceipts(String table, String num, boolean show){
		String app = "";
		if (!show) {
			app = " and receipt."+table+"= '"+num+"'";
		}
		ArrayList<ReceiptPO> list = new ArrayList<ReceiptPO>();
		String sql = "select * from receipt,receiptarrive where receipt.number = receiptarrive.number"+app;
		ResultSet rs_arri = mysql.query(sql);
		getpos(list, rs_arri);
		sql = "select * from receipt,receiptdeliver where receipt.number = receiptdeliver.number"+app;
		ResultSet rs_del = mysql.query(sql);
		getpos(list, rs_del);
		sql = "select * from receipt,receiptmoneyin where receipt.number = receiptmoneyin.number"+app;
		ResultSet rs_min = mysql.query(sql);
		getpos(list, rs_min);
		sql = "select * from receipt,receiptmoneyout where receipt.number = receiptmoneyout.number"+app;
		ResultSet rs_mout = mysql.query(sql);
		getpos(list, rs_mout);
		sql = "select * from receipt,receiptorder where receipt.number = receiptorder.number"+app;
		ResultSet rs_ord = mysql.query(sql);
		getpos(list, rs_ord);
		sql = "select * from receipt,receiptstockin where receipt.number = receiptstockin.number"+app;
		ResultSet rs_sin = mysql.query(sql);
		getpos(list, rs_sin);
		sql = "select * from receipt,receiptstockout where receipt.number = receiptstockout.number"+app;
		ResultSet rs_sout = mysql.query(sql);
		getpos(list, rs_sout);
		sql = "select * from receipt,receipttotalmoneyin where receipt.number = receipttotalmoneyin.number"+app;
		ResultSet rs_tmin = mysql.query(sql);
		getpos(list, rs_tmin);
		sql = "select * from receipt,receipttrans where receipt.number = receipttrans.number"+app;
		ResultSet rs_tra = mysql.query(sql);
		getpos(list, rs_tra);
		return list;
	}
	
	public void getpos(ArrayList<ReceiptPO> list, ResultSet rs){
		try {
			while (rs.next()) {
				ReceiptType type = StringToType.toReceiptType(rs
						.getString("type"));
				if (type == null) {
					continue;
				}
				ReceiptPO po = null;
				switch (type) {
				case ORDER:
					po = order.getFromDB(rs);
					break;
				case TRANS:
					po = trans.getFromDB(rs);
					break;
				case ARRIVE:
					po = arri.getFromDB(rs);
					break;
				case STOCKIN:
					po = stockin.getFromDB(rs);
					break;
				case STOCKOUT:
					po = stockout.getFromDB(rs);
					break;
				case MONEYIN:
					po = moneyin.getFromDB(rs);
					break;
				case MONEYOUT:
					po = moneyout.getFromDB(rs);
					break;
				case TOTALMONEYIN:
					po = totalmoneyin.getFromDB(rs);
					break;
				case DELIVER:
					po = del.getFromDB(rs);
					break;
				default:
				}
				list.add(po);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws RemoteException {
		ReceiptDataImpl impl = new ReceiptDataImpl();
		ArrayList<ReceiptPO> list = impl.findByTimeAndType("2014-1-1", "2016-1-1",ReceiptType.MONEYIN);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getType());
		}
		System.out.println(list.size());
	}

}
