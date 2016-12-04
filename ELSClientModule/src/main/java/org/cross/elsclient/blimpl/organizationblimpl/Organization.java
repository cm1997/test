package org.cross.elsclient.blimpl.organizationblimpl;

import org.cross.elsclient.blimpl.accountblimpl.MockLog;
import org.cross.elsclient.vo.OrganizationVO;
import org.cross.elscommon.util.ResultMessage;

public class Organization {
	
	public ResultMessage createLog(String log){
		MockLog mockLog = new MockLog(log);
		return mockLog.createLog();
	}

	public ResultMessage add(OrganizationVO vo) {
		return ResultMessage.SUCCESS;
	}
}
