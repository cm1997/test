package org.cross.elsclient.blimpl.vehicleblimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.VehicleInfo;
import org.cross.elsclient.vo.VehicleVO;
import org.cross.elscommon.dataservice.vehicledataservice.VehicleDataService;
import org.cross.elscommon.po.VehiclePO;
import org.cross.elscommon.util.ResultMessage;

public class VehicleInfoImpl implements VehicleInfo{

	VehicleDataService vehicleData;
	
	public VehicleInfoImpl(VehicleDataService vehicleData){
		this.vehicleData = vehicleData;
	}
	
	@Override
	public VehicleVO toVehicleVO(VehiclePO po) {
		if (po == null) {
			return null;
		}
		VehicleVO vo = new VehicleVO(po.getNumber(), po.getLicence(), po.getOrgNum(), po.getEngineNum(), po.getBaseNum(), po.getBuyTime(), po.getLastTime(), po.getImage(),po.isState());
		return vo;
	}

	@Override
	public VehiclePO toVehiclePO(VehicleVO vo) {
		if (vo == null) {
			return null;
		}
		VehiclePO po = new VehiclePO(vo.number, vo.engineNumber, vo.baseNumber, vo.buyTime, vo.lastTime, vo.image, vo.inUse, vo.licence, vo.businessHallNum);
		return po;
	}

	@Override
	public ArrayList<VehicleVO> toVehVOs(ArrayList<VehiclePO> pos) {
		ArrayList<VehicleVO> vos = new ArrayList<VehicleVO>();
		if (pos == null) {
			return null;
		}
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(toVehicleVO(pos.get(i)));
		}
		return vos;
	}

	@Override
	public ArrayList<VehiclePO> toVehPOs(ArrayList<VehicleVO> vos) {
		ArrayList<VehiclePO> pos = new ArrayList<VehiclePO>();
		if (vos == null) {
			return null;
		}
		int size = vos.size();
		for (int i = 0; i < size; i++) {
			pos.add(toVehiclePO(vos.get(i)));
		}
		return pos;
	}

	@Override
	public ArrayList<VehicleVO> show() throws RemoteException {
		ArrayList<VehicleVO> vos = new ArrayList<VehicleVO>();
		ArrayList<VehiclePO> pos = vehicleData.show();
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(toVehicleVO(pos.get(i)));
		}
		return vos;
	}

	@Override
	public ResultMessage addVeh(VehiclePO veh) {
		try {
			return vehicleData.insert(veh);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

}
