package org.cross.elsserver.dataimpl.vehicledataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.cross.elscommon.dataservice.vehicledataservice.VehicleDataService;
import org.cross.elscommon.po.VehiclePO;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elsserver.database.MySQL;

public class VehicleDataImpl extends UnicastRemoteObject implements VehicleDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MySQL mysql;

	public VehicleDataImpl() throws RemoteException {
		super();
		this.mysql = MySQL.getMysql();
	}

	@Override
	public ResultMessage insert(VehiclePO veh) throws RemoteException {
		String sql = "insert ignore into `vehicle`(`number`, `engineNum`, `baseNum`, `buyTime`, `lastTime`, `state`, `licence`, `orgNum`) values ('"
				+ veh.getNumber() + "','" + veh.getEngineNum() + "','" + veh.getBaseNum() + "','"+veh.getBuyTime() + "','"
				+ veh.getLastTime() + "',"+veh.isState()+",'" + veh.getLicence() + "','" + veh.getOrgNum() +"')";
		if(mysql.execute(sql)) return ResultMessage.SUCCESS;
		else return ResultMessage.FAILED;
	}

	@Override
	public ResultMessage delete(String number) throws RemoteException {
		String sql = "DELETE FROM `vehicle` WHERE number = '" + number + "'";
		if (mysql.execute(sql)) {
			return ResultMessage.SUCCESS;
		}else {
			return ResultMessage.FAILED;
		}
	}

	public int boolToInt(boolean state){
		if (state) {
			return 1;
		}else {
			return 0;
		}
	}
	@Override
	public ResultMessage update(VehiclePO po) throws RemoteException {
		if(delete(po.getNumber())==ResultMessage.FAILED) return ResultMessage.FAILED;
		return insert(po);
	}

	@Override
	public ArrayList<VehiclePO> show() throws RemoteException {
		String sql = "SELECT * FROM `vehicle`";
		ResultSet rs = mysql.query(sql);
		ArrayList<VehiclePO> list = new ArrayList<VehiclePO>();
		VehiclePO po = null;
		while((po = getFromDB(rs))!=null) list.add(po);
		return list;
	}

	@Override
	public VehiclePO findByID(String number) throws RemoteException {
		String sql = "SELECT * FROM `vehicle` WHERE number = '"+number+"'";
		ResultSet rs = mysql.query(sql);
		return getFromDB(rs);
	}

	public VehiclePO getFromDB(ResultSet rs) throws RemoteException{
		VehiclePO po = null;
		try {
			if(rs.next()){
			po =new VehiclePO(rs.getString("number"), rs.getString("engineNum"),
							rs.getString("baseNum"), rs.getString("buyTime"), rs.getString("lastTime"), null,
							rs.getBoolean("state"), rs.getString("licence"), rs.getString("orgNum"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return po;
	}

	public static void main(String[] args) throws RemoteException {
		VehiclePO vehiclePO = new VehiclePO("V000000003", "EN000002", "BA000002", "2020-01-01", "2032-12-11", null, false, "2010", "O00001");
//		
		VehicleDataImpl vehicleDataImpl = new VehicleDataImpl();
		 vehiclePO = vehicleDataImpl.findByID("1");
		 System.out.println(vehiclePO.getBaseNum());
//		 System.out.println(po.getApparatusNumber());
		// vehicleDataImpl.delete("V000001");
//		vehicleDataImpl.;
	}

}
