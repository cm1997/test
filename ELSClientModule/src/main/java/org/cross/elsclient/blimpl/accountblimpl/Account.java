package org.cross.elsclient.blimpl.accountblimpl;

import org.cross.elsclient.vo.AccountVO;
import org.cross.elscommon.util.ResultMessage;

public class Account {
	
	public ResultMessage createLog(String log){
		MockLog mockLog = new MockLog(log);
		return mockLog.createLog();
	}
	
	public ResultMessage add(AccountVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
