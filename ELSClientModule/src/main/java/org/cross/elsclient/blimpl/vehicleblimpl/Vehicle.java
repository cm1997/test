package org.cross.elsclient.blimpl.vehicleblimpl;

import org.cross.elsclient.blimpl.accountblimpl.MockLog;
import org.cross.elsclient.vo.VehicleVO;
import org.cross.elscommon.util.ResultMessage;

public class Vehicle {
	
	public ResultMessage createLog(String log){
		MockLog mockLog = new MockLog(log);
		return mockLog.createLog();
	}
	
	public ResultMessage add(VehicleVO vo) {
		return ResultMessage.SUCCESS;
	}

}
