package org.cross.elsclient.ui.businesshallclerkui.arri;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.vo.Receipt_ArriveVO;
import org.cross.elsclient.vo.Receipt_TransVO;

public class ArriInfoPanel extends ELSInfoPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Receipt_ArriveVO vo;
	
	public ArriInfoPanel(Receipt_ArriveVO vo){
		this.vo = vo;
		init();
	}
	
	@Override
	public void init(){
		super.init();
		
		setTitle("到达单信息");
		addNormalItem("到达单编号", vo.number);
		addNormalItem("装车/中转单号", vo.transNum);
		addNormalItem("出发地", vo.startOrgID);
		addNormalItem("出发时间", vo.startTime);
		addNormalItem("到达地", vo.orgNum);
		addNormalItem("到达时间", vo.time);
		
		container.packHeight();
	}
}
