package org.cross.elsclient.blimpl.receiptblimpl;

import org.cross.elsclient.blimpl.vehicleblimpl.Vehicle;
import org.cross.elscommon.util.ResultMessage;

public class MockVehicle extends Vehicle{
	
	public ResultMessage setInuse(String vehicleNumber){
		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage setOutuse(String vehicleNumber){
		return ResultMessage.SUCCESS;
	}
}
