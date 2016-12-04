package org.cross.elsserver.dataimpl.goodsdataimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.cross.elscommon.po.HistoryPO;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;
import org.cross.elsserver.database.MySQL;
import org.cross.elsserver.dataimpl.tools.HistoryTool;

public class HistoryDataImpl implements HistoryTool {

	MySQL mysql;

	public HistoryDataImpl() {
		mysql = MySQL.getMysql();
	}

	@Override
	public ArrayList<HistoryPO> findByOrderNum(String number) {
		ArrayList<HistoryPO> list = new ArrayList<HistoryPO>();
		String sql = "select * from `history` where `orderNum` = '" + number + "'";
		ResultSet rs = mysql.query(sql);
		try {
			while (rs.next()) {
				HistoryPO po = new HistoryPO(rs.getString("time"), StringToType.toCity(rs.getString("placeCity")),
						StringToType.toOrg(rs.getString("placeOrg")), rs.getBoolean("isArrive"), number);
				list.add(po);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ResultMessage insert(HistoryPO po, String orderNum) {
		String sql = "insert ignore into `history`(`time`,`placeCity`,`placeOrg`,`isArrive`,`orderNum`) values ('"
				+po.getTime()+"','"
				+po.getPlaceCity().toString()+"','"
				+po.getPlaceOrg().toString()+"',"
				+po.isArrive()+",'"
				+orderNum+"')";
		if (mysql.execute(sql)) {
			return ResultMessage.SUCCESS;
		}else return ResultMessage.FAILED;
	}

}
