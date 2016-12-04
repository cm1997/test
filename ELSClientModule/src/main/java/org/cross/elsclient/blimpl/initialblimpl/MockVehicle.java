package org.cross.elsclient.blimpl.initialblimpl;

import java.util.ArrayList;

import org.cross.elsclient.blimpl.vehicleblimpl.Vehicle;
import org.cross.elsclient.vo.VehicleVO;
import org.cross.elscommon.util.ResultMessage;

public class MockVehicle extends Vehicle{
	public ResultMessage createVehicle(ArrayList<VehicleVO> vo){
		ResultMessage resultMessage = ResultMessage.FAILED;
		for (int i = 0; i < vo.size(); i++) {
			resultMessage = add(vo.get(i));
		}
		return resultMessage;
	}
}
