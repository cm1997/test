package org.cross.elsclient.ui.stockkeeperui.observe;

import java.util.ArrayList;

import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.blservice.stockblservice.StockBLService;
import org.cross.elsclient.ui.businesshallclerkui.trans.TransInfoPanel;
import org.cross.elsclient.ui.component.ELSManageTable;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.vo.GoodsVO;
import org.cross.elsclient.vo.Receipt_TransVO;
import org.cross.elsclient.vo.StockAreaVO;
import org.cross.elsclient.vo.StockSeeVO;
import org.cross.elsclient.vo.StockVO;

public class StockSeeManageTableFirst extends ELSManageTable {
	ArrayList<StockSeeVO> stockSeeVOs;

	public StockSeeManageTableFirst() {
		super();
	}

	public StockSeeManageTableFirst(String[] name, int[] itemWidth) {
		super(name, itemWidth);
		init();
	}

	@Override
	public void init() {
		super.init();
		isUpdateAndDelete = false;
	}

	public void addItem(StockSeeVO vo) {
		stockSeeVOs = new ArrayList<StockSeeVO>();
		stockSeeVOs.add(vo);
		String[] item = { String.valueOf(vo.goodsOut), String.valueOf(vo.moneyOut), String.valueOf(vo.goodsIn),
				String.valueOf(vo.moneyIn), String.valueOf(vo.totalInStock) };
		addItemLabel(item);
	}

}
