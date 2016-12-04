package org.cross.elsclient.blimpl.receiptblimpl;

import org.cross.elscommon.util.ResultMessage;

public class MockAccount {
	
	public ResultMessage adjustMoney(String id, double money){
		return ResultMessage.SUCCESS;
	}
	
}
