package org.cross.elsserver.dataimpl.personneldataimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.cross.elscommon.po.DriverPO;
import org.cross.elscommon.po.PersonnelPO;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;
import org.cross.elsserver.database.MySQL;

public class DriverDataImpl{
	private MySQL mysql;

	public DriverDataImpl() {
		this.mysql = MySQL.getMysql();
	}

	public ResultMessage insert(PersonnelPO po) {
		DriverPO dpo = (DriverPO) po;
		String sql = "insert ignore into `driver`(`number`, `liceneStart`, `liceneEnd`) values ('"
				+ dpo.getNumber() + "','" + dpo.getLicenceStart() + "','" + dpo.getLicenceEnd()
				+ "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}

	public DriverPO getFromDB(String number) {
		String sql = "select * from `personnel` where `number`='" + number + "'";
		DriverPO po = null;
		ResultSet rs = mysql.query(sql);
		try {
			if (rs.next()) {
				po = new DriverPO(rs.getString("number"), rs.getString("name"),
						StringToType.toPositionType(rs.getString("position")), rs.getString("orgNum"),
						rs.getDouble("payment"), rs.getInt("sex"), rs.getString("id"), rs.getString("phone"),
						rs.getString("birth"),null,null);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql = "select * from `driver` where `number`='"+number+"'";
		rs = mysql.query(sql);
		try {
			if (rs.next()) {
				po.setLicenceStart(rs.getString("liceneStart"));
				po.setLicenceEnd(rs.getString("liceneEnd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}
	
	public ResultMessage delete(String number){
		String sql = "delete from `driver` where `number`='"+number+"'";
		if (!mysql.execute(sql)) {
			return ResultMessage.FAILED;
		}
		return ResultMessage.SUCCESS;
	}
}
