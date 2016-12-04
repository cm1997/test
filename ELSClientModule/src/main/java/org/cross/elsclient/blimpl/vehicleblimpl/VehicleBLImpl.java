package org.cross.elsclient.blimpl.vehicleblimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.VehicleInfo;
import org.cross.elsclient.blservice.vehicleblservice.VehicleBLService;
//import org.cross.elsclient.blservice.vehicleblservice.VehicleBLService_Stub;
import org.cross.elsclient.vo.VehicleVO;
import org.cross.elscommon.dataservice.vehicledataservice.VehicleDataService;
import org.cross.elscommon.po.VehiclePO;
import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.ResultMessage;

public class VehicleBLImpl implements VehicleBLService{

	public VehicleDataService vehicleData;
	public VehicleInfo vehicleInfo;
	
	public VehicleBLImpl(VehicleDataService vehicleData,VehicleInfo vehicleInfo){
		this.vehicleData = vehicleData;
		this.vehicleInfo = vehicleInfo;
	}
	
	@Override
	public ResultMessage add(VehicleVO vo) throws RemoteException {
		VehiclePO po = vehicleInfo.toVehiclePO(vo);
		return vehicleData.insert(po);
	}

	@Override
	public ResultMessage delete(String number) throws RemoteException {
		return vehicleData.delete(number);
	}

	@Override
	public ResultMessage update(VehicleVO vo) throws RemoteException {
		VehiclePO po = vehicleInfo.toVehiclePO(vo);
		return vehicleData.update(po);
	}

	@Override
	public ArrayList<VehicleVO> show() throws RemoteException {
		ArrayList<VehicleVO> vos = new ArrayList<VehicleVO>();
		ArrayList<VehiclePO> pos = vehicleData.show();
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(vehicleInfo.toVehicleVO(pos.get(i)));
		}
		return vos;
	}

	@Override
	public ArrayList<VehicleVO> find(String id) throws RemoteException {
		VehiclePO po = vehicleData.findByID(id);
		VehicleVO vo = vehicleInfo.toVehicleVO(po);
		ArrayList<VehicleVO> vos = new ArrayList<VehicleVO>();
		if (vo == null) {
			return null;
		}
		vos.add(vo);
		return vos;
	}

	@Override
	public ArrayList<VehicleVO> findByOrg(String orgNum) throws RemoteException {
		ArrayList<VehiclePO> pos = vehicleData.show();
		ArrayList<VehicleVO> vos = new ArrayList<VehicleVO>();
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			if (pos.get(i).getOrgNum().equals(orgNum)) {
				vos.add(vehicleInfo.toVehicleVO(pos.get(i)));
			}
		}
		return vos;
	}

}
