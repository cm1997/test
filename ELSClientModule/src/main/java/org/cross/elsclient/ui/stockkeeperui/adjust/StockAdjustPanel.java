package org.cross.elsclient.ui.stockkeeperui.adjust;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blservice.stockblservice.StockBLService;
import org.cross.elsclient.ui.component.ELSComfirmDialog;
import org.cross.elsclient.ui.component.ELSFunctionPanel;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.stockkeeperui.StockFunctionPanel;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.LogUtil;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.vo.StockAreaVO;
import org.cross.elsclient.vo.StockVO;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;

public class StockAdjustPanel extends ELSInfoPanel {

	StockBLService stockbl;
	UserVO user;
	StockVO stockvo;
	
	StockAreaTable areaTable;

	public StockAdjustPanel(StockBLService stockbl, UserVO user, StockVO stockvo) {
		this.stockbl = stockbl;
		this.stockvo = stockvo;
		init();
	}

	@Override
	public void init() {
//		System.out.println("in");
		super.init();
		titlePanel.remove(titlePanel.backBtn);

		// 需呀find
		String[] it1 = null;
		String[] it2 = null;
		ArrayList<String> it1s;
		ArrayList<String> it2s;
		try {
			it2s = stockbl.getChangeableArea(stockvo.number);
			it2 = new String[it2s.size()];
			for (int i = 0; i < it2.length; i++) {
				it2[i] = it2s.get(i);
			}
			it1s = stockbl.getNeedChange(stockvo.number);
			it1 = new String[it1s.size()];
			for (int i = 0; i < it1.length; i++) {
				it1[i] = it1s.get(i);
			}

		} catch (RemoteException e) {
			e.printStackTrace();
		}		
		setTitle("调整库存");
		/* 0 */addComboxItem("需要调整的类型", it1, true, "needs");
		addComboxItem("需要配合的仓库", it2, true, "change");
		
		String[] s = {"仓库小间编号","仓库小间类型","用量"};
		int[] itemWidth = {250,200,100};
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认调整");
		cancelBtn.setVisible(false);
		
		areaTable = new StockAreaTable(s, itemWidth);
		ArrayList<StockAreaVO> vos = stockvo.stockAreaVOs;
		for (StockAreaVO vo : vos) {
			areaTable.addItem(vo);
		}
		areaTable.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT,300);
		container.add(areaTable);
		
		container.packHeight();
	}

	@Override
	protected void confirm() throws RemoteException {
		if (isAllLegal()) {
			String id = findItem("change").toString();
			String type = findItem("needs").toString();
			if (stockbl.stockAdjust(id, StringToType.toGoodsType(type)) == ResultMessage.SUCCESS) {
				if(stockbl.getNeedChange(stockvo.number).isEmpty()){
					StockFunctionPanel parent = (StockFunctionPanel)GetPanelUtil.getFunctionPanel(this);
					parent.alertBtn.setAlert(false);
				}
				LogUtil.addLog("库存调整");
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),
						"调整成功");
//				ELSFunctionPanel parent = GetPanelUtil.getFunctionPanel(this);
//				// parent.contentPanel.cl.show(parent.contentPanel, "receipts");
//				parent.setChosenFunction("receipts");
				init();
			} else {
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),
						"调整失败");
			}
		}
	}
}
