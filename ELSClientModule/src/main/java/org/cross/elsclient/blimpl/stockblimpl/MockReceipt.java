//package org.cross.elsclient.blimpl.stockblimpl;
//
//import org.cross.elsclient.blimpl.receiptblimpl.Receipt;
//import org.cross.elsclient.vo.ReceiptVO;
//import org.cross.elscommon.util.ReceiptType;
//import org.cross.elscommon.util.ResultMessage;
//
//public class MockReceipt extends Receipt{
//
//	public ResultMessage add(ReceiptVO vo){
//		if (vo.type == ReceiptType.STOCKOUT) {
//			System.out.println("生成出库单成功");
//			return ResultMessage.SUCCESS;
//		}else if(vo.type == ReceiptType.STOCKIN){
//			System.out.println("生成入库单成功");
//			return ResultMessage.SUCCESS;
//		}
//		return ResultMessage.FAILED;
//	}
//}
