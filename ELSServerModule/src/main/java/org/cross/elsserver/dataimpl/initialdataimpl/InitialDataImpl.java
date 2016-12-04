package org.cross.elsserver.dataimpl.initialdataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.cross.elscommon.dataservice.initialdataservice.InitialDataService;
import org.cross.elscommon.po.AccountPO;
import org.cross.elscommon.po.InitialPO;
import org.cross.elscommon.po.OrganizationPO;
import org.cross.elscommon.po.PersonnelPO;
import org.cross.elscommon.po.StockPO;
import org.cross.elscommon.po.VehiclePO;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;
import org.cross.elsserver.database.MySQL;

public class InitialDataImpl extends UnicastRemoteObject implements InitialDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MySQL mysql;

	public InitialDataImpl() throws RemoteException {
		super();
		mysql = MySQL.getMysql();
	}

	@Override
	public ResultMessage insert(InitialPO po) throws RemoteException {
		String sql = "insert ignore into `initial`(`number`, `time`, `name`, `perNum`) values('" + po.getNumber() + "','"
				+ po.getTime() + "','" + po.getName() +"','"+po.getPerNum()+ "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<InitialPO> show() throws RemoteException {
		String sql = "select * from `initial`";
		ResultSet rs = mysql.query(sql);
		ArrayList<InitialPO> list = new ArrayList<InitialPO>();
		try {
			while (rs.next()) {
				InitialPO po = findByID(rs.getString("number"));
				list.add(po);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public InitialPO findByID(String initialID) throws RemoteException {
		String sql = "select * from `initial` where `number`='" + initialID + "'";
		ResultSet rs = mysql.query(sql);
		InitialPO po = null;
		try {
			if (rs.next()) {
				po = new InitialPO(initialID, rs.getString("time"), rs.getString("name"), rs.getString("perNum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

	public ArrayList<OrganizationPO> findInitOrganizations(String initialNum) {
		ArrayList<OrganizationPO> orgs = new ArrayList<OrganizationPO>();
		String sql = "select * from `initial_organization` where `initialNum`='" + initialNum + "'";
		ResultSet rs = mysql.query(sql);
		try {
			while (rs.next()) {
				OrganizationPO org = new OrganizationPO(StringToType.toCity(rs.getString("city")),
						rs.getString("number"), StringToType.toOrg(rs.getString("type")));
				orgs.add(org);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orgs;
	}

	public ArrayList<VehiclePO> findInitVehicles(String initialNum) {
		ArrayList<VehiclePO> vehs = new ArrayList<VehiclePO>();
		String sql = "select * from `initial_vehicle` where `initialNum`='" + initialNum + "'";
		ResultSet rs = mysql.query(sql);
		try {
			while (rs.next()) {
				VehiclePO veh = new VehiclePO(rs.getString("number"), rs.getString("engineNum"),
						rs.getString("baseNum"), rs.getString("buyTime"), rs.getString("lastTime"), null,
						rs.getBoolean("state"), rs.getString("licence"), rs.getString("orgNum"));
				vehs.add(veh);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vehs;
	}

	public ArrayList<PersonnelPO> findInitPersonnels(String initialNum) {
		ArrayList<PersonnelPO> pers = new ArrayList<PersonnelPO>();
		String sql = "select * from `initial_personnel` where `initialNum`='" + initialNum + "'";
		ResultSet rs = mysql.query(sql);
		try {
			while (rs.next()) {
				PersonnelPO per = new PersonnelPO(rs.getString("number"), rs.getString("name"),
						StringToType.toPositionType(rs.getString("position")), rs.getString("orgNum"),
						rs.getDouble("payment"), rs.getInt("sex"), rs.getString("id"), rs.getString("phone"),
						rs.getString("birth"));
				pers.add(per);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pers;
	}

	public ArrayList<StockPO> findInitStocks(String initialNum) {
		ArrayList<StockPO> stos = new ArrayList<StockPO>();
		String sql = "select * from `initial_stock` where `initialNum`='" + initialNum + "'";
		ResultSet rs = mysql.query(sql);
		try {
			while (rs.next()) {
				StockPO sto = new StockPO(rs.getString("number"), rs.getInt("numInStock"), rs.getString("orgNum"));
				stos.add(sto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stos;
	}

	public ArrayList<AccountPO> findInitAccounts(String initialNum) {
		ArrayList<AccountPO> accs = new ArrayList<AccountPO>();
		String sql = "select * from `initial_account` where `initialNum`='" + initialNum + "'";
		ResultSet rs = mysql.query(sql);
		try {
			while (rs.next()) {
				AccountPO acc = new AccountPO(rs.getString("name"), rs.getString("accountNum"), rs.getDouble("balance"));
				accs.add(acc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accs;
	}

	@Override
	public ResultMessage insertInitAccount(AccountPO acc, String initNum) throws RemoteException {
		String sql = "insert ignore into `initial_account`(`name`, `accountNum`, `balance`, `initialNum`) values ('"
				+ acc.getName() + "','" + acc.getAccountNum() + "'," + acc.getBalance() + ",'" + initNum + "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage insertInitVehicle(VehiclePO veh, String initNum) throws RemoteException {
		String sql = "insert ignore into `initial_vehicle`(`number`, `engineNum`, `baseNum`, `buyTime`, `lastTime`, `state`, `licence`, `orgNum`, `initialNum`) values ('"
				+ veh.getNumber() + "','" + veh.getEngineNum() + "','" + veh.getBaseNum() +"','"+ veh.getBuyTime() + "','"
				+ veh.getLastTime() + "'," + veh.isState() + ",'" + veh.getLicence() + "','" + veh.getOrgNum() + "','"
				+ initNum + "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage insertInitOrganization(OrganizationPO po, String initNum) throws RemoteException {
		String sql = "insert ignore into `initial_organization`(`number`, `city`, `type`, `initialNum`) values ('"
				+ po.getNumber() + "','" + po.getCity().toString() + "','" + po.getType().toString() + "','" + initNum
				+ "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage insertInitPersonnel(PersonnelPO per, String initNum) throws RemoteException {
		String sql = "insert ignore into `initial_personnel`(`number`, `name`, `position`, `orgNum`, `payment`,`sex`,`id`,`phone`,`birth`,`initialNum`) values ('"
				+ per.getNumber() + "','" + per.getName() + "','" + per.getPosition().toString() + "','"
				+ per.getOrgNum() + "'," + per.getPayment() + "," + per.getSex() + ",'" + per.getId() + "','"
				+ per.getPhone() + "','" + per.getBirth() + "','" + initNum + "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage insertInitStock(StockPO sto, String initNum) throws RemoteException {
		String sql = "insert ignore into `initial_stock`(`number`, `numInStock`, `orgNum`, `initialNum`) values ('"
				+ sto.getNumber() + "','" + sto.getNumInStock() + "','" + sto.getOrgNum() + "','" + initNum + "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}
	
	public static void main(String[] args) throws RemoteException{
		InitialDataImpl impl = new InitialDataImpl();
		InitialPO po = new InitialPO("I001", "2012", "TTT", "CDN");
		VehiclePO pp = new VehiclePO("v0001", null, null, null, null, null, false, null, null);
//		if(impl.insertInitVehicle(pp, "I001") == ResultMessage.SUCCESS) System.out.println("su");
//		else {
//			System.out.println("fa");
//		}
		ArrayList<AccountPO> ppo = impl.findInitAccounts("I928392");
		System.out.println(ppo.size());
	}
}
