package org.cross.elsclient.blservice.analysisblservice;

import java.util.ArrayList;

import org.cross.elscommon.util.ReceiptType;
import org.cross.elsclient.vo.ReceiptVO;
import org.cross.elsclient.vo.Receipt_MoneyInVO;
import org.cross.elsclient.vo.Receipt_MoneyOutVO;

public class AnalysisBLService_Stub implements AnalysisBLService {

	@Override
	public double[] showCostBenefitTable() {
		double result[] = {40000,80000,40000};
		
		return result;
	}


	@Override
	public ArrayList<Receipt_MoneyInVO> showMoneyinTable(String beginTime,
			String endTime) {
		ArrayList<Receipt_MoneyInVO> table = new ArrayList<Receipt_MoneyInVO>();
		
		table.add(new Receipt_MoneyInVO("2015-12-12 10:30", 2000, null, "R000001",null, null, null));
		table.add(new Receipt_MoneyInVO("2015-12-12 10:30", 2000, null, "R000001",null, null, null));
		table.add(new Receipt_MoneyInVO("2015-12-12 10:30", 2000, null, "R000001",null, null, null));
		table.add(new Receipt_MoneyInVO("2015-12-12 10:30", 2000, null, "R000001",null, null, null));
		table.add(new Receipt_MoneyInVO("2015-12-12 10:30", 2000, null, "R000001",null, null, null));
		table.add(new Receipt_MoneyInVO("2015-12-12 10:30", 2000, null, "R000001",null, null, null));
		table.add(new Receipt_MoneyInVO("2015-12-12 10:30", 2000, null, "R000001",null, null, null));
		
		
		return table;
	}

	@Override
	public ArrayList<Receipt_MoneyOutVO> showMoneyoutTable(String beginTime,
			String endTime) {
		ArrayList<Receipt_MoneyOutVO> table = new ArrayList<Receipt_MoneyOutVO>();
		
		table.add(new Receipt_MoneyOutVO("R000001", beginTime, 2000, null, "6222201234567654321", null, null,"P000001","O0000001"));
		table.add(new Receipt_MoneyOutVO("R000001", beginTime, 2000, null, "6222201234567654321", null, null,"P000001","O0000001"));
		table.add(new Receipt_MoneyOutVO("R000001", beginTime, 2000, null, "6222201234567654321", null, null,"P000001","O0000001"));
		table.add(new Receipt_MoneyOutVO("R000001", beginTime, 2000, null, "6222201234567654321", null, null,"P000001","O0000001"));
		table.add(new Receipt_MoneyOutVO("R000001", beginTime, 2000, null, "6222201234567654321", null, null,"P000001","O0000001"));
		table.add(new Receipt_MoneyOutVO("R000001", beginTime, 2000, null, "6222201234567654321", null, null,"P000001","O0000001"));
		
		return table;
	}

}
