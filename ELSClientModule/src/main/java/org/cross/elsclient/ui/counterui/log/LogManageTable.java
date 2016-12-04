package org.cross.elsclient.ui.counterui.log;

import java.util.ArrayList;

import org.cross.elsclient.blservice.logblservice.LogBLService;
import org.cross.elsclient.blservice.userblservice.UserBLService;
import org.cross.elsclient.ui.component.ELSManageTable;
import org.cross.elsclient.vo.LogVO;
import org.cross.elsclient.vo.UserVO;

public class LogManageTable extends ELSManageTable{
	LogBLService logbl;
	ArrayList<LogVO> vos;
	
	public LogManageTable(String[] name, int[] itemWidth,LogBLService logbl) {
		super(name, itemWidth);
		this.logbl = logbl;
		init();
	}
	
	@Override
	public void init() {
		super.init();
		vos = new ArrayList<>();
	}
	
	public void addItem(LogVO vo){
		vos.add(vo);
		
		String[] item = {vo.time,vo.operator,vo.content};
		addItemLabel(item);
		
	}
}
