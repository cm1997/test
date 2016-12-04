//package org.cross.elsclient.blimpl.analysisblimpl;
//
//import java.util.ArrayList;
//
//import org.cross.elsclient.blimpl.accountblimpl.MockLog;
//import org.cross.elsclient.blservice.analysisblservice.AnalysisBLService;
//import org.cross.elsclient.demo.StockInfoUI.returnAct;
//import org.cross.elsclient.vo.ReceiptVO;
//import org.cross.elsclient.vo.Receipt_MoneyInVO;
//import org.cross.elsclient.vo.Receipt_MoneyOutVO;
//import org.cross.elscommon.util.ReceiptType;
//import org.cross.elscommon.util.ResultMessage;
//
//public class Analysis {
//	
//	public ResultMessage createLog(String log){
//		MockLog mockLog = new MockLog(log);
//		return mockLog.createLog();
//	}
//
//	public int[] showCostBenefitTable() {
//		int moneyIn = 0;
//		int moneyOut = 0;
//		int profit = 0;
//		int[] res = new int[3];
//		MockReceipt receipt = new MockReceipt();
//		ArrayList<ReceiptVO> in = receipt.findByType(ReceiptType.MONEYIN);
//		ArrayList<ReceiptVO> out = receipt.findByType(ReceiptType.MONEYOUT);
//		for (int i = 0; i < in.size(); i++) {
//			moneyIn += ((Receipt_MoneyInVO)in.get(i)).money;
//		}
//		for (int i = 0; i < out.size(); i++) {
//			moneyOut += ((Receipt_MoneyOutVO)out.get(i)).money;
//		}
//		profit = moneyIn - moneyOut;
//		res[0] = moneyIn;
//		res[1] = moneyOut;
//		res[2] = profit;
//		return res;
//	}
//
//	public ArrayList<ReceiptVO> showMoneyinTable(String beginTime,
//			String endTime) {
//		MockReceipt receipt = new MockReceipt();
//		return receipt.findByType(ReceiptType.MONEYIN);
//	}
//
//	public ArrayList<ReceiptVO> showMoneyoutTable(String beginTime,
//			String endTime) {
//		MockReceipt receipt = new MockReceipt();
//		return receipt.findByType(ReceiptType.MONEYOUT);
//	}
//
//}
