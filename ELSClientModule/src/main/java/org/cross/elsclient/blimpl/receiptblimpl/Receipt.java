//package org.cross.elsclient.blimpl.receiptblimpl;
//
//import org.cross.elsclient.blimpl.accountblimpl.MockLog;
//import org.cross.elsclient.vo.ReceiptVO;
//import org.cross.elsclient.vo.Receipt_ArriveVO;
//import org.cross.elsclient.vo.Receipt_MoneyInVO;
//import org.cross.elsclient.vo.Receipt_MoneyOutVO;
//import org.cross.elsclient.vo.Receipt_OrderVO;
//import org.cross.elsclient.vo.Receipt_StockInVO;
//import org.cross.elsclient.vo.Receipt_StockOutVO;
//import org.cross.elsclient.vo.Receipt_TotalMoneyInVO;
//import org.cross.elsclient.vo.Receipt_TransVO;
//import org.cross.elscommon.util.ReceiptType;
//import org.cross.elscommon.util.ResultMessage;
//
//public class Receipt {
//	//收款付款单、到达转运单、入库出库单、订单、总收款单
//	
//	Receipt_Order order;
//	Receipt_Trans trans;
//	Receipt_TotalMoneyIn totalMoneyIn;
//	Receipt_MoneyIn moneyIn;
//	Receipt_StockOut stockOut;
//	Receipt_Arrive arrive;
//	Receipt_MoneyOut moneyOut;
//	Receipt_StockIn stockIn;
//	
//	public Receipt(){
//		order = new Receipt_Order();
//		trans = new Receipt_Trans();
//		totalMoneyIn = new Receipt_TotalMoneyIn();
//		moneyIn = new Receipt_MoneyIn();
//		moneyOut = new Receipt_MoneyOut();
//		stockIn = new Receipt_StockIn();
//		stockOut = new Receipt_StockOut();
//		arrive = new Receipt_Arrive();
//	}
//	
//	public ResultMessage add(String personnel, ReceiptVO vo) {
//		
//		MockPersonnel personnelUT = new MockPersonnel();
//		personnelUT.addExcutedReceipt(personnel, vo);
//		
//		if(vo.type == ReceiptType.ORDER){
//			return order.add((Receipt_OrderVO)vo);
//		}else if(vo.type == ReceiptType.TRANS){
//			return trans.add((Receipt_TransVO)vo);
//		}else if(vo.type == ReceiptType.ARRIVE){
//			return arrive.add((Receipt_ArriveVO)vo);
//		}else if(vo.type == ReceiptType.TOTALMONEYIN){
//			return totalMoneyIn.add((Receipt_TotalMoneyInVO)vo);
//		}else if(vo.type == ReceiptType.MONEYIN){
//			return moneyIn.add((Receipt_MoneyInVO)vo);
//		}else if(vo.type == ReceiptType.MONEYOUT){
//			return moneyOut.add((Receipt_MoneyOutVO)vo);
//		}else if(vo.type == ReceiptType.STOCKIN){
//			return stockIn.add((Receipt_StockInVO)vo);
//		}else if(vo.type == ReceiptType.STOCKOUT){
//			return stockOut.add((Receipt_StockOutVO)vo);
//		}
//		return ResultMessage.FAILED;
//	}
//
//	public ResultMessage update(ReceiptVO vo) {
//		if (vo.type == ReceiptType.ORDER) {
//			return order.update((Receipt_OrderVO)vo);
//		}
//		return ResultMessage.FAILED;
//	}
//
//	public ResultMessage check(ReceiptVO vo) {
//		MockPersonnel personnel = new MockPersonnel();
//		return personnel.checkReceipt(vo);
//	}
//	
//	public ResultMessage createLog(String log){
//		MockLog mockLog = new MockLog(log);
//		return mockLog.createLog();
//	}
//	
//}
