//package org.cross.elsclient.blservice.analysisblservice;
//
//import java.util.ArrayList;
//
//import org.cross.elsclient.vo.ReceiptVO;
//
//public class AnalysisBLService_Driver {
//	
//	public void driver(AnalysisBLService analysisBLService){
//		
//		System.out.println("统计分析：");
//		
//		System.out.println("展示成本收益表返回信息：");
//		int ret[] = analysisBLService.showCostBenefitTable();
//		System.out.println("成本："+ret[0]+"元；" + "收益："+ret[1]+"元；" + "利润：" + ret[2] + "元；");
//		
//		
//		System.out.println("展示统计分析表返回信息：");
//		ArrayList<ReceiptVO> moneyinTable = analysisBLService.showMoneyinTable("2015-10-01", "2015-10-13");
//		ArrayList<ReceiptVO> moneyoutTable = analysisBLService.showMoneyoutTable("2015-10-01", "2015-10-13");
//		for (ReceiptVO receiptVO : moneyoutTable) {
//			System.out.println("单据ID: " + receiptVO.number + "；" + "单据类型: " + receiptVO.type.toString() + "；");
//		}
//		for (ReceiptVO receiptVO : moneyinTable) {
//			System.out.println("单据ID: " + receiptVO.number + "；" + "单据类型: " + receiptVO.type.toString() + "；");
//		}
//		
//		
//	}
//}
