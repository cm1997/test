package org.cross.elsclient.ui.managerui;

import java.rmi.RemoteException;

import org.cross.elsclient.blimpl.blfactoryimpl.BLFactoryImpl;
import org.cross.elsclient.blservice.accountblservice.AccountBLService;
import org.cross.elsclient.blservice.accountblservice.AccountBLService_Stub;
import org.cross.elsclient.blservice.analysisblservice.AnalysisBLService;
import org.cross.elsclient.blservice.analysisblservice.AnalysisBLService_Stub;
import org.cross.elsclient.blservice.blfactoryservice.BLFactoryService;
import org.cross.elsclient.blservice.constantblservice.ConstantBLService;
import org.cross.elsclient.blservice.constantblservice.ConstantBLService_Stub;
import org.cross.elsclient.blservice.logblservice.LogBLService;
import org.cross.elsclient.blservice.logblservice.LogBLService_Stub;
import org.cross.elsclient.blservice.organizationblservice.OrganizationBLService;
import org.cross.elsclient.blservice.organizationblservice.OrganizationBlservice_Stub;
import org.cross.elsclient.blservice.personnelblservice.PersonnelBLService;
import org.cross.elsclient.blservice.personnelblservice.PersonnelBLService_Stub;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService_Stub;
import org.cross.elsclient.blservice.stockblservice.StockBLService;
import org.cross.elsclient.blservice.userblservice.UserBLService;
import org.cross.elsclient.ui.adminui.UserManagePanel;
import org.cross.elsclient.ui.component.ELSFunctionPanel;
import org.cross.elsclient.ui.component.ELSManagePanel;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.counterui.account.AccountManagePanel;
import org.cross.elsclient.ui.counterui.analysis.AnalysisManagePanel;
import org.cross.elsclient.ui.counterui.log.LogManagePanel;
import org.cross.elsclient.ui.managerui.approval.ApprovalManagePanel;
import org.cross.elsclient.ui.managerui.constant.ConstantInfoPanel;
import org.cross.elsclient.ui.managerui.organizationui.OrganizationManagePanel;
import org.cross.elsclient.ui.managerui.payment.PaymentManagePanel;
import org.cross.elsclient.ui.managerui.personnel.PerManagePanel;

public class ManagerFunctionPanel extends ELSFunctionPanel{
	public OrganizationBLService organizationbl;
	public ReceiptBLService receiptbl;
	public PersonnelBLService personelbl;
	public AccountBLService accoutbl;
	public AnalysisBLService analysisbl;
	public ConstantBLService constantbl;
	public LogBLService logbl;
	public StockBLService stockbl;
	
	public ManagerFunctionPanel() {
		organizationbl = new OrganizationBlservice_Stub();
		receiptbl = new ReceiptBLService_Stub();
		accoutbl = new AccountBLService_Stub();
		analysisbl = new AnalysisBLService_Stub();
		constantbl = new ConstantBLService_Stub();
		logbl = new LogBLService_Stub();
		personelbl = new PersonnelBLService_Stub();
		
		try {
			BLFactoryService blFactory = new BLFactoryImpl();
			organizationbl = blFactory.organizationBLService();
			receiptbl = blFactory.receiptBLService();
			accoutbl = blFactory.getAccountBLService();
			analysisbl = blFactory.analysisBLService();
			constantbl = blFactory.constantBLService();
			logbl = blFactory.logBLService();
			personelbl = blFactory.personnelBLService();
			stockbl = blFactory.stockBLService();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		init();
	}
	
	
	@Override
	public void init() {
		super.init();
		
		addFunctionBtn("单据审批", "receiptApproval");
		addFunctionBtn("机构管理", "organization");
		addFunctionBtn("人员管理", "personnel");
		addFunctionBtn("工资管理", "payment");
		addFunctionBtn("账户查看", "account");
		addFunctionBtn("统计分析", "analysis");
		addFunctionBtn("业务常量", "constant");
		addFunctionBtn("系统日志", "log");
		
		addFunctionPanel(new ApprovalManagePanel(receiptbl),"manange", "receiptApproval");
		addFunctionPanel(new OrganizationManagePanel(organizationbl,stockbl),"manange", "organization");
		addFunctionPanel(new PerManagePanel(personelbl),"manange", "personnel");
		addFunctionPanel(new PaymentManagePanel(personelbl),"manange", "payment");
		addFunctionPanel(new AccountManagePanel(accoutbl),"manange", "account");
		addFunctionPanel(new AnalysisManagePanel(analysisbl),"manange", "analysis");
		addFunctionPanel(new ConstantInfoPanel(constantbl),"info", "constant");
		addFunctionPanel(new LogManagePanel(logbl),"manange", "log");
		
		validate();
	}
}
