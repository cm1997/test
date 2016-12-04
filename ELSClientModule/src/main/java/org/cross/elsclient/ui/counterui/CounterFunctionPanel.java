package org.cross.elsclient.ui.counterui;

import java.rmi.RemoteException;

import org.cross.elsclient.blimpl.blfactoryimpl.BLFactoryImpl;
import org.cross.elsclient.blservice.accountblservice.AccountBLService;
import org.cross.elsclient.blservice.accountblservice.AccountBLService_Stub;
import org.cross.elsclient.blservice.analysisblservice.AnalysisBLService;
import org.cross.elsclient.blservice.analysisblservice.AnalysisBLService_Stub;
import org.cross.elsclient.blservice.blfactoryservice.BLFactoryService;
import org.cross.elsclient.blservice.initialblservice.InitialBLService;
import org.cross.elsclient.blservice.initialblservice.InitialBLService_Stub;
import org.cross.elsclient.blservice.logblservice.LogBLService;
import org.cross.elsclient.blservice.logblservice.LogBLService_Stub;
import org.cross.elsclient.blservice.organizationblservice.OrganizationBLService;
import org.cross.elsclient.blservice.personnelblservice.PersonnelBLService;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService_Stub;
import org.cross.elsclient.blservice.stockblservice.StockBLService;
import org.cross.elsclient.blservice.vehicleblservice.VehicleBLService;
import org.cross.elsclient.ui.businesshallclerkui.ReceiptManagePanel;
import org.cross.elsclient.ui.component.ELSFunctionPanel;
import org.cross.elsclient.ui.component.ELSManagePanel;
import org.cross.elsclient.ui.counterui.account.AccountManagePanel;
import org.cross.elsclient.ui.counterui.analysis.AnalysisManagePanel;
import org.cross.elsclient.ui.counterui.cost.MoneyOutAddPanel;
import org.cross.elsclient.ui.counterui.initial.InitialCheckPanel;
import org.cross.elsclient.ui.counterui.initial.InitialManagePanel;
import org.cross.elsclient.ui.counterui.log.LogManagePanel;
import org.cross.elsclient.ui.counterui.settle.MoneyInManagePanel;

public class CounterFunctionPanel extends ELSFunctionPanel{
	protected ReceiptBLService receiptbl;
	protected PersonnelBLService personnelbl;
	protected AccountBLService accountbl;
	protected LogBLService logbl;
	protected AnalysisBLService analysisbl;
	protected InitialBLService initialbl;
	protected OrganizationBLService organizationbl;
	protected StockBLService stockbl;
	protected VehicleBLService vehiclebl;
	
	public CounterFunctionPanel() {
//		receiptbl = new ReceiptBLService_Stub();
//		analysisbl = new AnalysisBLService_Stub();
//		initialbl = new InitialBLService_Stub();
//		logbl = new LogBLService_Stub();
//		accountbl = new AccountBLService_Stub();
		try {
			BLFactoryService blFactory = new BLFactoryImpl();
			receiptbl = blFactory.receiptBLService();
			analysisbl = blFactory.analysisBLService();
			initialbl = blFactory.initialBLService();
			logbl = blFactory.logBLService();
			accountbl = blFactory.getAccountBLService();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		init();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		
		addFunctionBtn("成本管理", "cost");
		addFunctionBtn("结算管理", "settle");
		addFunctionBtn("期初建账", "initial");
		addFunctionBtn("统计分析", "analysis");
		addFunctionBtn("系统日志", "log");
		addFunctionBtn("查看单据", "receipts");
		
		addFunctionPanel(new MoneyOutAddPanel(receiptbl,personnelbl,accountbl),"add", "cost");
		addFunctionPanel(new MoneyInManagePanel(receiptbl),"add", "settle");
		addFunctionPanel(new AccountManagePanel(accountbl),"manage", "account");
		addFunctionPanel(new InitialCheckPanel(initialbl, stockbl, organizationbl, personnelbl, accountbl, vehiclebl),"manage", "initial");
		addFunctionPanel(new AnalysisManagePanel(analysisbl),"add", "analysis");
		addFunctionPanel(new LogManagePanel(logbl),"manage", "log");
		addFunctionPanel(new ReceiptManagePanel(receiptbl), "manage","receipts");
		
		validate();
		
	}
	
}
