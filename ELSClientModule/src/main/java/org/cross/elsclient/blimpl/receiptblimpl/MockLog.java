package org.cross.elsclient.blimpl.receiptblimpl;

import org.cross.elsclient.blimpl.logblimpl.Log;
import org.cross.elscommon.util.ResultMessage;

public class MockLog extends Log{
	String log;
	
	public MockLog(String log){
		this.log = log;
	}
	
	public ResultMessage createLog(){
		System.out.println(log);
		System.out.println("Create log successfully.");
		return ResultMessage.SUCCESS;
	}

}
