/**
 * 车辆服务桩程序
 * @author raychen
 * @date 2015/10/20
 */
package org.cross.elsclient.blservice.vehicleblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.util.ResultMessage;
import org.cross.elsclient.vo.VehicleVO;

public class VehicleBLService_Stub implements VehicleBLService{

	@Override
	public ResultMessage add(VehicleVO vo) {
		// TODO Auto-generated method stub
		if (vo.number == "00001") {
			return ResultMessage.SUCCESS;
		}else {
			return ResultMessage.FAILED;
		}
	}

	@Override
	public ResultMessage delete(String st) {
		// TODO Auto-generated method stub
		if (st == "00001") {
			return ResultMessage.SUCCESS;
		}else {
			return ResultMessage.FAILED;
		}
	}

	@Override
	public ResultMessage update(VehicleVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<VehicleVO> show() {
		// TODO Auto-generated method stub
		ArrayList<VehicleVO> list = new ArrayList<VehicleVO>();
		list.add(new VehicleVO("V0000001", "粤U007456", "O000001", null, null, "2015-10-13", "2015-12-12", null, true));
		list.add(new VehicleVO("V0000001", "粤U007456", "O000001", null, null, "2015-10-13", "2015-12-12", null, true));
		return list;
	}

	@Override
	public ArrayList<VehicleVO> find(String name) {
		// TODO Auto-generated method stub
		ArrayList<VehicleVO> list = new ArrayList<VehicleVO>();
		list.add(new VehicleVO(name, "粤U007456", "O000001", null, null, "2015-10-13", "2015-12-12", null, true));
		list.add(new VehicleVO(name, "粤U007456", "O000001", null, null, "2015-10-13", "2015-12-12", null, true));
		list.add(new VehicleVO(name, "粤U007456", "O000001", null, null, "2015-10-13", "2015-12-12", null, true));
		return list;
	}

	@Override
	public ArrayList<VehicleVO> findByOrg(String orgNum) throws RemoteException {
		ArrayList<VehicleVO> list = new ArrayList<VehicleVO>();
		list.add(new VehicleVO("V0000001", "粤U007456", orgNum, null, null, "2015-10-13", "2015-12-12", null, true));
		list.add(new VehicleVO("V0000001", "粤U007456", orgNum, null, null, "2015-10-13", "2015-12-12", null, true));
		list.add(new VehicleVO("V0000001", "粤U007456", orgNum, null, null, "2015-10-13", "2015-12-12", null, true));
		return list;
	}

}
