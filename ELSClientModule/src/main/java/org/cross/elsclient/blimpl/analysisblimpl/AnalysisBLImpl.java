package org.cross.elsclient.blimpl.analysisblimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.ReceiptInfo;
import org.cross.elsclient.blservice.analysisblservice.AnalysisBLService;
import org.cross.elsclient.vo.ReceiptVO;
import org.cross.elsclient.vo.Receipt_MoneyInVO;
import org.cross.elsclient.vo.Receipt_MoneyOutVO;
import org.cross.elscommon.po.Receipt_MoneyInPO;
import org.cross.elscommon.util.ReceiptType;

public class AnalysisBLImpl implements AnalysisBLService {

	ReceiptInfo receiptInfo;

	public AnalysisBLImpl(ReceiptInfo receiptInfo) {
		this.receiptInfo = receiptInfo;
	}

	@Override
	public double[] showCostBenefitTable() {
		int moneyIn = 0,moneyOut = 0,profit = 0;
		try {
			ArrayList<ReceiptVO> moneyInVOs = receiptInfo.findByType(ReceiptType.MONEYIN);
			ArrayList<ReceiptVO> moneyOutVOs = receiptInfo.findByType(ReceiptType.MONEYOUT);
			int inSize = moneyInVOs.size();
			int outSize = moneyOutVOs.size();
			for (int i = 0; i < inSize; i++) {
				Receipt_MoneyInVO temp = (Receipt_MoneyInVO)moneyInVOs.get(i);
				moneyIn += temp.money;
			}
			for (int i = 0; i < outSize; i++) {
				Receipt_MoneyOutVO temp = (Receipt_MoneyOutVO)moneyOutVOs.get(i);
				moneyOut += temp.money;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		profit = moneyIn - moneyOut;
		double[] d = new double[3];
		d[0] = moneyOut;
		d[1] = moneyIn;
		d[2] = profit;
		return d;
	}

	@Override
	public ArrayList<Receipt_MoneyInVO> showMoneyinTable(String beginTime,
			String endTime) {
		ArrayList<ReceiptVO> receiptVOs = null;
		try {
			receiptVOs = receiptInfo.findByTimeAndType(
					ReceiptType.MONEYIN, beginTime, endTime);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int size = receiptVOs.size();
		ArrayList<Receipt_MoneyInVO> moneyInVOs = new ArrayList<Receipt_MoneyInVO>();
		for (int i = 0; i < size; i++) {
			moneyInVOs.add((Receipt_MoneyInVO) receiptVOs.get(i));
		}
		return moneyInVOs;
	}

	@Override
	public ArrayList<Receipt_MoneyOutVO> showMoneyoutTable(String beginTime,
			String endTime) {
		ArrayList<ReceiptVO> receiptVOs = null;
		try {
			receiptVOs = receiptInfo.findByTimeAndType(ReceiptType.MONEYOUT, beginTime, endTime);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int size = receiptVOs.size();
		ArrayList<Receipt_MoneyOutVO> moneyOutVOs = new ArrayList<Receipt_MoneyOutVO>();
		for (int i = 0; i < size; i++) {
			moneyOutVOs.add((Receipt_MoneyOutVO)receiptVOs.get(i));
		}
		return moneyOutVOs;
	}

}
