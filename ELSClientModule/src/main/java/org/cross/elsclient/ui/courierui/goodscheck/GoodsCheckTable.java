package org.cross.elsclient.ui.courierui.goodscheck;

import java.util.ArrayList;

import org.cross.elsclient.ui.component.ELSManageTable;
import org.cross.elsclient.vo.GoodsVO;
import org.cross.elsclient.vo.HistoryVO;

public class GoodsCheckTable extends ELSManageTable{

	public GoodsCheckTable(String[] name, int[] itemWidth) {
		super(name, itemWidth);
		init();
	}
	
	public void addItem(HistoryVO vo1, HistoryVO vo2){
		String triggerPlace = vo1.placeCity.toString()+vo1.placeOrg.toString();
		String triggerTime = vo1.time;
		String arrivePlace = "";
		String arriveTime = "";
		if(vo2!=null){
			arrivePlace = vo2.placeCity.toString()+vo2.placeOrg.toString();
			arriveTime = vo2.time;
			if(arriveTime==null){
				arriveTime = "未到达";
			}
		}
		
		String []item = {triggerPlace,triggerTime,arrivePlace,arriveTime};
		addItemLabel(item);
	}
	
	public void addItem(HistoryVO vo){
		String place = vo.placeCity.toString()+vo.placeOrg.toString();
		String time = vo.time;
		String isArrive;
		
		if(vo.isArrive){
			isArrive = "到达";
		}else{
			isArrive = "出发";
		}
		
		String []item = {place,time,isArrive};
		addItemLabel(item);
	}
}
