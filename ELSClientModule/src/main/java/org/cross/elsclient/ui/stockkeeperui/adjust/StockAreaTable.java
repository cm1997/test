package org.cross.elsclient.ui.stockkeeperui.adjust;

import java.util.ArrayList;

import org.cross.elsclient.ui.component.ELSManageTable;
import org.cross.elsclient.vo.GoodsVO;
import org.cross.elsclient.vo.StockAreaVO;

public class StockAreaTable extends ELSManageTable{
	
	ArrayList<StockAreaVO> vos;
	
	public StockAreaTable(String[] name, int[] itemWidth){
		super(name, itemWidth);
		init();
	}
	
	@Override
	public void init(){
		super.init();
		vos = new ArrayList<StockAreaVO>();
		isUpdateAndDelete = false;
	}
	
	public void addItem(StockAreaVO vo){
		vos.add(vo);
		double p = (double)vo.usedCapacity/vo.totalCapacity*100;
		String[] item = {vo.number,vo.stockType.toString(), p+"%"};
		addItemLabel(item);
	}

}
