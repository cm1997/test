package org.cross.elsclient.ui.counterui.analysis;

import java.util.ArrayList;

import org.cross.elsclient.blservice.analysisblservice.AnalysisBLService;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService_Stub;
import org.cross.elsclient.ui.component.ELSManageTable;
import org.cross.elsclient.vo.ReceiptVO;
import org.cross.elsclient.vo.Receipt_MoneyInVO;
import org.cross.elsclient.vo.Receipt_MoneyOutVO;

public class AnalysisManageTable extends ELSManageTable{
	AnalysisBLService analysisbl;
	ArrayList<ReceiptVO> vos;
	
	public AnalysisManageTable() {
		// TODO Auto-generated constructor stub
	}
	
	AnalysisManageTable(String[] name,int[] itemWidth,AnalysisBLService analysisbl){
		super(name, itemWidth);
		this.analysisbl = analysisbl;
		init();
	}
	
	@Override
	public void init() {
		super.init();
		vos = new ArrayList<>();
	}
	
	public void addItem(ReceiptVO vo){
		if(vo instanceof Receipt_MoneyInVO){
			Receipt_MoneyInVO moneyVO = (Receipt_MoneyInVO) vo;
			String[] item = {moneyVO.number,moneyVO.type.toString(),moneyVO.time,""+moneyVO.money};
			addItemLabel(item);
		}else if(vo instanceof Receipt_MoneyOutVO) {
			Receipt_MoneyOutVO moneyVO = (Receipt_MoneyOutVO) vo;
			String[] item = {moneyVO.number,moneyVO.type.toString(),moneyVO.time,""+moneyVO.money};
			addItemLabel(item);
		}else{
			String[] item = {vo.number,vo.type.toString(),vo.time,"2000"};
			addItemLabel(item);
		}
	}
}
