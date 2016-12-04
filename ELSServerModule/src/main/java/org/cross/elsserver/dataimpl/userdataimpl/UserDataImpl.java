package org.cross.elsserver.dataimpl.userdataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.cross.elscommon.dataservice.userdataservice.UserDataService;
import org.cross.elscommon.po.UserPO;
import org.cross.elscommon.util.PwdMD5;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;
import org.cross.elscommon.util.UserType;
import org.cross.elsserver.database.MySQL;

public class UserDataImpl extends UnicastRemoteObject implements UserDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MySQL mysql;

	public UserDataImpl() throws RemoteException {
		super();
		this.mysql = MySQL.getMysql();
	}

	@Override
	public ResultMessage insert(UserPO po) throws RemoteException {
		
		String pwd = po.getPassword();
		po.setPassword(PwdMD5.convertMD5(PwdMD5.string2MD5(pwd)));
		
		String sql = "insert ignore into `user`(`number`,`name`,`password`,`type`,`orgNum`) values ('" + po.getNumber()
				+ "','" + po.getName() + "','" + po.getPassword() + "','" + po.getType().toString() + "','"
				+ po.getOrgNum() + "')";
		if (!mysql.execute(sql)) {
			return ResultMessage.FAILED;
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(String id) throws RemoteException {
		String sql = "delete from `user` where `number`='" + id + "'";
		if (!mysql.execute(sql)) {
			return ResultMessage.FAILED;
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage update(UserPO po) throws RemoteException {
		if (delete(po.getNumber()) == ResultMessage.FAILED)
			return ResultMessage.FAILED;
		return insert(po);
	}

	@Override
	public UserPO findById(String id) throws RemoteException {
		String sql = "select * from `user` where `number`='" + id + "'";
		ResultSet rs = mysql.query(sql);
		return getFromDB(rs);
	}

	@Override
	public ArrayList<UserPO> findByType(UserType type) throws RemoteException {
		String sql = "select * from `user` where `type`='" + type.toString() + "'";
		ResultSet rs = mysql.query(sql);
		ArrayList<UserPO> users = new ArrayList<UserPO>();
		UserPO po = null;
		while ((po = getFromDB(rs)) != null)
			users.add(po);
		return users;
	}

	@Override
	public ArrayList<UserPO> findByName(String name) throws RemoteException {
		String sql = "select * from `user` where `name`='" + name + "'";
		ResultSet rs = mysql.query(sql);
		ArrayList<UserPO> users = new ArrayList<UserPO>();
		UserPO po = null;
		while ((po = getFromDB(rs)) != null)
			users.add(po);
		return users;
	}

	@Override
	public ArrayList<UserPO> show() throws RemoteException {
		String sql = "select * from `user`";
		ResultSet rs = mysql.query(sql);
		ArrayList<UserPO> users = new ArrayList<UserPO>();
		UserPO po = null;
		while ((po = getFromDB(rs)) != null)
			users.add(po);
		return users;
	}

	public UserPO getFromDB(ResultSet rs) {
		UserPO po = null;
		try {
			if (rs.next()) {
				String md5 = rs.getString("password");
				md5 = PwdMD5.convertMD5(md5);
//				System.out.println("md5:"+md5);
				po = new UserPO(rs.getString("number"), rs.getString("name"),
						StringToType.toUserType(rs.getString("type")), md5,
						rs.getString("orgNum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

	public static void main(String[] args){
		UserDataImpl impl;
		
		try {
			impl = new UserDataImpl();
			UserPO po = impl.findById("U001");
			System.out.println(po.getName());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
