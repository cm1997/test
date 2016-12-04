package org.cross.elsclient.ui.businesshallclerkui.trans;

import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.vo.Receipt_TransVO;

public class TransInfoPanel extends ELSInfoPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Receipt_TransVO vo;
	
	public TransInfoPanel(Receipt_TransVO vo){
		this.vo = vo;
		init();
	}
	
	@Override
	public void init(){
		super.init();
		String goodsNum = "";
		for (int i = 0; i < vo.goodsID.size()-1; i++) {
			goodsNum+=vo.goodsID.get(i)+";";
		}
		if(vo.goodsID.size()>0) goodsNum+=vo.goodsID.get(vo.goodsID.size()-1);
		
		setTitle("创建装车单");
		addNormalItem("装车单编号", vo.number);
		addNormalItem("快递单编号", goodsNum);
		addNormalItem("出发地", vo.orgNum);
		addNormalItem("到达地", vo.arriveOrgID);
		addNormalItem("装车时间", vo.time);
		addNormalItem("运输编号", vo.transNum);
		addNormalItem("车辆编号", vo.vehicleNum);
		addNormalItem("监装员", vo.observerName);
		addNormalItem("押运员", vo.driverName);
		addNormalItem("运费", String.valueOf(vo.cost));
		
		container.packHeight();
	}
}
