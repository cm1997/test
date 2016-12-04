package org.cross.elsclient.blimpl.receiptblimpl;

import org.cross.elsclient.vo.ReceiptVO;
import org.cross.elscommon.util.ResultMessage;

public class MockPersonnel {
	
	public ResultMessage addExcutedReceipt(String person, ReceiptVO vo){
		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage checkReceipt(ReceiptVO receiptvo){
		return ResultMessage.SUCCESS;
	}
	
}
