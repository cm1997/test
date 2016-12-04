package org.cross.elsclient.ui.stockkeeperui.observe;

import java.util.ArrayList;

import org.cross.elsclient.ui.component.ELSManageTable;
import org.cross.elsclient.vo.GoodsVO;

public class StockSeeManageTableSecond extends ELSManageTable{

	ArrayList<GoodsVO> goods;
	
	public StockSeeManageTableSecond(){
		super();
	}
	public StockSeeManageTableSecond(String[] name, int[] itemWidth){
		super(name, itemWidth);
		init();
	}
	
	@Override
	public void init(){
		super.init();
		goods = new ArrayList<GoodsVO>();
		isUpdateAndDelete = false;
	}
	
	public void addItem(GoodsVO vo){
		goods.add(vo);
		String[] item = {vo.number, vo.stockAreaNum};
		addItemLabel(item);
	}

}
