package org.cross.elsclient.ui.stockkeeperui.check;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.Box;

import org.cross.elsclient.ui.component.ELSButton;
import org.cross.elsclient.ui.component.ELSComfirmDialog;
import org.cross.elsclient.ui.component.ELSManageTable;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.counterui.analysis.AnalysisManagePanel;
import org.cross.elsclient.ui.util.ComponentFactory;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.util.ExportExcel;
import org.cross.elsclient.vo.StockCheckVO;
import org.cross.elscommon.util.ResultMessage;

public class StockCheckManageTable extends ELSManageTable{
	
	public StockCheckManageTable(){
		super();
	}
	public StockCheckManageTable(String[] name, int[] itemWidth){
		super(name, itemWidth);
		init();
	}
	
	@Override
	public void init(){
		super.init();
		isUpdateAndDelete = false;
	}
	
	public void addItem(StockCheckVO check){
		String[] item = {check.goodsNumber, check.inTime, check.targetCity , check.stockAreaNum};
		addItemLabel(item);
	}

	
}
