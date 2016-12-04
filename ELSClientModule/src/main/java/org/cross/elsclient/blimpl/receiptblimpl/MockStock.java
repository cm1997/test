package org.cross.elsclient.blimpl.receiptblimpl;

import org.cross.elscommon.util.ResultMessage;

public class MockStock {
	public ResultMessage intoStock(String id){
		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage outStock(String goodsid, String stockid){
		return ResultMessage.SUCCESS;
	}
}
