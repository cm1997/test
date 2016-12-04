package org.cross.elsclient.blimpl.constantblimpl;

import org.cross.elsclient.blimpl.accountblimpl.MockLog;
import org.cross.elscommon.util.ResultMessage;

public class Constant {
	
	public ResultMessage createLog(String log){
		MockLog mockLog = new MockLog(log);
		return mockLog.createLog();
	}

}
