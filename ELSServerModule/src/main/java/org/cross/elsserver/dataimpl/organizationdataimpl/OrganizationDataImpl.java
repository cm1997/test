package org.cross.elsserver.dataimpl.organizationdataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.cross.elscommon.dataservice.organizationdataservice.OrganizationDataService;
import org.cross.elscommon.po.OrganizationPO;
import org.cross.elscommon.util.City;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;
import org.cross.elsserver.database.MySQL;

public class OrganizationDataImpl extends UnicastRemoteObject implements OrganizationDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MySQL mysql;

	public OrganizationDataImpl() throws RemoteException {
		super();
		this.mysql = MySQL.getMysql();
	}

	@Override
	public ResultMessage insert(OrganizationPO po)  throws RemoteException{
		String sql = "insert ignore into `organization`(`number`,`city`,`type`) values ('" + po.getNumber() + "','"
				+ po.getCity().toString() + "','" + po.getType().toString() + "')";
		if (!mysql.execute(sql)) {
			return ResultMessage.FAILED;
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(String number)  throws RemoteException{
		String sql = "delete from `organization` where `number`='" + number + "'";
		if (!mysql.execute(sql)) {
			return ResultMessage.FAILED;
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage update(OrganizationPO po)  throws RemoteException{
		String sql = "update `organization` set `city`='" + po.getCity().toString() + "', `type`='"
				+ po.getType().toString() + "' where `number`='" + po.getNumber() + "'";
		if (!mysql.execute(sql)) {
			return ResultMessage.FAILED;
		}
		return ResultMessage.SUCCESS;

	}

	@Override
	public ArrayList<OrganizationPO> findByCity(City city) throws RemoteException {
		String sql = "select * from `organization` where `city`='"+city.toString()+"'";
		ResultSet rs = mysql.query(sql);
		ArrayList<OrganizationPO> orgs = new ArrayList<OrganizationPO>();
		OrganizationPO org = null;
		while ((org=getFromDB(rs))!=null) orgs.add(org);
		return orgs;
	}

	@Override
	public ArrayList<OrganizationPO> findByType(OrganizationType type)  throws RemoteException{
		String sql = "select * from `organization` where `type`='"+type.toString()+"'";
		ResultSet rs = mysql.query(sql);
		ArrayList<OrganizationPO> orgs = new ArrayList<OrganizationPO>();
		OrganizationPO org = null;
		while ((org=getFromDB(rs))!=null) orgs.add(org);
		return orgs;
	}

	@Override
	public OrganizationPO findById(String id)  throws RemoteException{
		String sql = "select * from `organization` where `number`='"+id+"'";
		ResultSet rs = mysql.query(sql);
		return getFromDB(rs);
	}

	@Override
	public ArrayList<OrganizationPO> show()  throws RemoteException{
		String sql = "select * from `organization`";
		ResultSet rs = mysql.query(sql);
		ArrayList<OrganizationPO> orgs = new ArrayList<OrganizationPO>();
		OrganizationPO org = null;
		while ((org=getFromDB(rs))!=null) orgs.add(org);
		return orgs;
	}

	public OrganizationPO getFromDB(ResultSet rs) {
		OrganizationPO po = null;
		try {
			if (rs.next()) {
				po = new OrganizationPO( StringToType.toCity(rs.getString("city")),rs.getString("number"),
						StringToType.toOrg(rs.getString("type")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

}
