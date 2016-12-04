//package org.cross.elsclient.blimpl.initialblimpl;
//
//import java.util.ArrayList;
//
//import org.cross.elsclient.blimpl.stockblimpl.Stock;
//import org.cross.elsclient.vo.StockVO;
//import org.cross.elscommon.util.ResultMessage;
//
//public class MockStock extends Stock{
//	public ResultMessage createStock(ArrayList<StockVO> vo){
//		ResultMessage resultMessage = ResultMessage.FAILED;
//		for (int i = 0; i < vo.size(); i++) {
//			resultMessage = add(vo.get(i));
//		}
//		return resultMessage;
//	}
//	
//	public ResultMessage add(StockVO vo){
//		return ResultMessage.SUCCESS;
//	}
//}
