package org.cross.elsclient.ui.businesshallclerkui;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.ui.adminui.UserManageTable;
import org.cross.elsclient.ui.businesshallclerkui.arri.ArriInfoPanel;
import org.cross.elsclient.ui.businesshallclerkui.deliver.DeliverInfoPanel;
import org.cross.elsclient.ui.businesshallclerkui.money.MoneyInfoPanel;
import org.cross.elsclient.ui.businesshallclerkui.trans.TransInfoPanel;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSManageTable;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.counterui.cost.MoneyOutInfoPanel;
import org.cross.elsclient.ui.counterui.settle.TotalInfoPanel;
import org.cross.elsclient.ui.courierui.receive.ExpressReceivePanel;
import org.cross.elsclient.ui.courierui.receive.OrderInfoPanel;
import org.cross.elsclient.ui.stockkeeperui.instock.StockInInfoPanel;
import org.cross.elsclient.ui.stockkeeperui.outstock.StockOutInfoPanel;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.vo.ReceiptVO;
import org.cross.elsclient.vo.Receipt_ArriveVO;
import org.cross.elsclient.vo.Receipt_DeliverVO;
import org.cross.elsclient.vo.Receipt_MoneyInVO;
import org.cross.elsclient.vo.Receipt_MoneyOutVO;
import org.cross.elsclient.vo.Receipt_OrderVO;
import org.cross.elsclient.vo.Receipt_StockInVO;
import org.cross.elsclient.vo.Receipt_StockOutVO;
import org.cross.elsclient.vo.Receipt_TotalMoneyInVO;
import org.cross.elsclient.vo.Receipt_TransVO;
import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.util.ReceiptType;

public class ReceiptManageTable extends ELSManageTable{
	ArrayList<ReceiptVO> receiptvos;
	
	public ReceiptManageTable(){super();}
	public ReceiptManageTable(String[] name, int[] itemWidth){
		super(name, itemWidth);
		init();
	}
	
	@Override
	public void init(){
		super.init();
		receiptvos = new ArrayList<ReceiptVO>();
		isUpdateAndDelete = false;
	}
	
	public void addItem(ReceiptVO vo){
		receiptvos.add(vo);
		String[] item = {vo.number,vo.type.toString(),vo.time,vo.approveState.toString()};
		addItemLabel(item);
	}
	
	@Override
	public void infoBtn(int index){
		super.infoBtn(index);
		ELSPanel contentPanel = GetPanelUtil.getSubFunctionPanel(this, "receipts");
		ReceiptVO vo = receiptvos.get(index);
		switch (vo.type) {
		case TRANS:
			contentPanel.add("info", new TransInfoPanel((Receipt_TransVO)vo));
			break;
		case ORDER:
			Receipt_OrderVO order = (Receipt_OrderVO)vo;
			contentPanel.add("info", new OrderInfoPanel(order));
			break;
		case ARRIVE:
			contentPanel.add("info", new ArriInfoPanel((Receipt_ArriveVO)vo));
			break;
		case DELIVER:
			contentPanel.add("info", new DeliverInfoPanel((Receipt_DeliverVO)vo));
			break;
		case MONEYIN:
			contentPanel.add("info", new MoneyInfoPanel((Receipt_MoneyInVO)vo));
			break;
		case MONEYOUT:
			contentPanel.add("info", new MoneyOutInfoPanel((Receipt_MoneyOutVO)vo));
			break;
		case STOCKIN:
			contentPanel.add("info", new StockInInfoPanel((Receipt_StockInVO)vo));
			break;
		case STOCKOUT:
			contentPanel.add("info", new StockOutInfoPanel((Receipt_StockOutVO)vo));
			break;
		case TOTALMONEYIN:
			contentPanel.add("info", new TotalInfoPanel((Receipt_TotalMoneyInVO)vo));
			break;
		default:
			break;
		}
		contentPanel.cl.show(contentPanel, "info");
	}
}
