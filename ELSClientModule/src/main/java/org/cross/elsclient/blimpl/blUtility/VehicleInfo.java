package org.cross.elsclient.blimpl.blUtility;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.vo.VehicleVO;
import org.cross.elscommon.po.VehiclePO;
import org.cross.elscommon.util.ResultMessage;

public interface VehicleInfo {

	public VehicleVO toVehicleVO(VehiclePO po);

	public VehiclePO toVehiclePO(VehicleVO vo);
	
	public ArrayList<VehicleVO> toVehVOs(ArrayList<VehiclePO> pos);
	
	public ArrayList<VehiclePO> toVehPOs(ArrayList<VehicleVO> vos);

	/**
	 * 显示车辆信息
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<VehicleVO> show() throws RemoteException;

	public ResultMessage addVeh(VehiclePO veh);
}
