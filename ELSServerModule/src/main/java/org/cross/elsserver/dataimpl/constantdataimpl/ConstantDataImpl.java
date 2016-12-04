package org.cross.elsserver.dataimpl.constantdataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.cross.elscommon.dataservice.constantdataservice.ConstantDataService;
import org.cross.elscommon.po.ConstantPO;
import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.UserType;
import org.cross.elsserver.database.MySQL;

@SuppressWarnings("serial")
public class ConstantDataImpl extends UnicastRemoteObject implements ConstantDataService {

	MySQL mysql;

	// `price`, `timeByKilo`, `baseMoneyForDRIVER`, `baseMoneyForADMINITER`,
	// `baseMoneyForBUSINESSHALLCLERK`, `baseMoneyForTRANSITCENTERCLERK`,
	// `baseMoneyForCOUNTER`, `baseMoneyForCOURIER`, `baseMoneyForSTOCKKEEPER`,
	// `baseMoneyForMANGER`, `distance_Beijing_Guangzhou`,
	// `distance_Beijing_Shanghai`, `distance_Beijing_Nanjing`,
	// `distance_Guangzhou_Shanghai`, `distance_Guangzhou_Nanjing`,
	// `distance_Nanjing_Shanghai`
	public ConstantDataImpl() throws RemoteException {
		super();
		mysql = MySQL.getMysql();
	}

	@Override
	public ResultMessage update(ConstantPO po) throws RemoteException{
		String sql = "delete from `constant` where 1";
		mysql.execute(sql);
		return insert(po);
	}

	@Override
	public ConstantPO show() throws RemoteException{
		ResultSet rs = mysql.query("select * from `constant`");
		return getFromDB(rs);
	}

	public ResultMessage insert(ConstantPO po) {
		String sql = "insert ignore into `constant`(`price`, `timeByKilo`, `once`, `num` ,`baseMoneyForDRIVER`, `baseMoneyForADMINITER`, `baseMoneyForBUSINESSHALLCLERK`, `baseMoneyForTRANSITCENTERCLERK`, "
				+ "`baseMoneyForCOUNTER`, `baseMoneyForCOURIER`, `baseMoneyForSTOCKKEEPER`, `baseMoneyForMANGER`, `distance_Beijing_Guangzhou`, `distance_Beijing_Shanghai`, `distance_Beijing_Nanjing`,"
				+ " `distance_Guangzhou_Shanghai`, `distance_Guangzhou_Nanjing`, `distance_Nanjing_Shanghai`) values ("
				+ po.getPrice() + "," + po.getTimeBykilo() + "," + po.getOnce() + "," + po.getNum() + ","
				+ po.getBaseMoneyForDRIVER() + "," + po.getBaseMoney(PositionType.ADMINISTRATOR) + ","
				+ po.getBaseMoney(PositionType.BUSINESSHALLCLERK) + ","
				+ po.getBaseMoney(PositionType.TRANSITCENTERCLERK) + "," + po.getBaseMoney(PositionType.COUNTER) + ","
				+ po.getBaseMoney(PositionType.COURIER) + "," + po.getBaseMoney(PositionType.STOCKKEEPER) + ","
				+ po.getBaseMoney(PositionType.MANAGER) + "," + po.getDistance_Beijing_Guangzhou() + ","
				+ po.getDistance_Beijing_Nanjing() + "," + po.getDistance_Beijing_Shanghai() + ","
				+ po.getDistance_Shanghai_Guangzhou() + "," + po.getDistance_Nanjing_Guangzhou() + ","
				+ po.getDistance_Nanjing_Shanghai() + ")";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}

	public ConstantPO getFromDB(ResultSet rs) {
		ConstantPO po = null;
		try {
			if (rs.next()) {
				po = new ConstantPO();
				po.setBaseMoney(PositionType.ADMINISTRATOR, rs.getDouble("baseMoneyForADMINITER"));
				po.setBaseMoney(PositionType.BUSINESSHALLCLERK, rs.getDouble("baseMoneyForBUSINESSHALLCLERK"));
				po.setBaseMoney(PositionType.COUNTER, rs.getDouble("baseMoneyForCOUNTER"));
				po.setBaseMoney(PositionType.COURIER, rs.getDouble("baseMoneyForCOURIER"));
				po.setBaseMoney(PositionType.MANAGER, rs.getDouble("baseMoneyForMANGER"));
				po.setBaseMoney(PositionType.STOCKKEEPER, rs.getDouble("baseMoneyForSTOCKKEEPER"));
				po.setBaseMoney(PositionType.TRANSITCENTERCLERK, rs.getDouble("baseMoneyForTRANSITCENTERCLERK"));
				po.setBaseMoneyForDRIVER(rs.getDouble("baseMoneyForDRIVER"));
				
				po.setOnce(rs.getDouble("once"));
				po.setNum(rs.getDouble("num"));

				po.setPrice(rs.getDouble("price"));
				po.setTimeBykilo(rs.getDouble("timeByKilo"));

				po.setDistance_Beijing_Guangzhou(rs.getDouble("distance_Beijing_Guangzhou"));
				po.setDistance_Beijing_Nanjing(rs.getDouble("distance_Beijing_Nanjing"));
				po.setDistance_Beijing_Shanghai(rs.getDouble("distance_Beijing_Shanghai"));
				po.setDistance_Nanjing_Guangzhou(rs.getDouble("distance_Guangzhou_Nanjing"));
				po.setDistance_Nanjing_Shanghai(rs.getDouble("distance_Nanjing_Shanghai"));
				po.setDistance_Shanghai_Guangzhou(rs.getDouble("distance_Guangzhou_Shanghai"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

	
	public static void main(String [] args) throws RemoteException{
		ConstantPO po = new ConstantPO();
		ConstantDataImpl impl = null;
		try {
			impl = new ConstantDataImpl();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		impl.update(po);
	}
}
