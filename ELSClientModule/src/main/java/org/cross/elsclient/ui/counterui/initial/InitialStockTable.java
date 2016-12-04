package org.cross.elsclient.ui.counterui.initial;

import java.util.ArrayList;

import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.vo.OrganizationVO;
import org.cross.elsclient.vo.StockVO;

public class InitialStockTable extends InitialManageTable {
	ArrayList<StockVO> vos;

	public InitialStockTable(String[] name, int[] itemWidth,ArrayList<StockVO> vos) {
		super(name, itemWidth);
		this.vos = vos;
		refresh();
	}
	
	@Override
	public void init(){
		super.init();
		isUpdateAndDelete = false;
	}
	
	@Override
	public void refresh(){
		removeAll();
		init();
		if (vos == null) {
			return;
		}
		for (StockVO vo : vos) {
			String item[] = {vo.number,vo.totalAreas+""};
			addItemLabel(item);
		}
	}
	
	@Override
	public void addBtn() {
		super.addBtn();
		ELSPanel parent = GetPanelUtil.getSubFunctionPanel(this, "initial");
		parent.add("addStock",new StockAddPanel(vos));
		parent.cl.show(parent, "addStock");
	}

}
