package org.cross.elsclient.ui.stockkeeperui.outstock;

import org.cross.elsclient.blservice.stockblservice.StockBLService;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.vo.Receipt_StockInVO;
import org.cross.elsclient.vo.Receipt_StockOutVO;

public class StockOutInfoPanel extends ELSInfoPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Receipt_StockOutVO vo;
	public StockBLService stockbl;
	
	public StockOutInfoPanel(Receipt_StockOutVO vo){
		this.vo = vo;
		init();
	}
	
	@Override
	public void init(){
		super.init();
		
		setTitle("出库单信息");
		addNormalItem("出库单编号", vo.number);
		addNormalItem("快件单编号", vo.goodsNum);
		addNormalItem("出库时间", vo.time);
		addNormalItem("目的地", vo.targetOrgID);
		addNormalItem("中转/装车单号", vo.transNumber);
		addNormalItem("运输方式", vo.vehicle);
		
		container.packHeight();
	}


}
