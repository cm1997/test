package org.cross.elsclient.blimpl.receiptblimpl;

import org.cross.elsclient.vo.Receipt_StockInVO;
import org.cross.elscommon.util.ResultMessage;

public class Receipt_StockIn {
	public ResultMessage add(Receipt_StockInVO vo){
		MockStock stock = new MockStock();
		return stock.intoStock(vo.goodsNumber);
	}
}
