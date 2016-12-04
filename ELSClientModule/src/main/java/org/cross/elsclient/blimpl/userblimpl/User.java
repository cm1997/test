package org.cross.elsclient.blimpl.userblimpl;

import org.cross.elsclient.blimpl.accountblimpl.MockLog;
import org.cross.elscommon.util.ResultMessage;

public class User {
	
	public ResultMessage createLog(String log){
		MockLog mockLog = new MockLog(log);
		return mockLog.createLog();
	}

}
