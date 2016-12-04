package org.cross.elsclient.blimpl.blfactoryimpl;

import java.rmi.RemoteException;

import org.cross.elsclient.blimpl.accountblimpl.AccountBLImpl;
import org.cross.elsclient.blimpl.accountblimpl.AccountInfoImpl;
import org.cross.elsclient.blimpl.analysisblimpl.AnalysisBLImpl;
import org.cross.elsclient.blimpl.blUtility.AccountInfo;
import org.cross.elsclient.blimpl.blUtility.ConstantInfo;
import org.cross.elsclient.blimpl.blUtility.GoodsInfo;
import org.cross.elsclient.blimpl.blUtility.LogInfo;
import org.cross.elsclient.blimpl.blUtility.OrganizationInfo;
import org.cross.elsclient.blimpl.blUtility.PersonnelInfo;
import org.cross.elsclient.blimpl.blUtility.ReceiptInfo;
import org.cross.elsclient.blimpl.blUtility.SalaryInfo;
import org.cross.elsclient.blimpl.blUtility.StockInfo;
import org.cross.elsclient.blimpl.blUtility.UserInfo;
import org.cross.elsclient.blimpl.blUtility.VehicleInfo;
import org.cross.elsclient.blimpl.constantblimpl.ConstantBLImpl;
import org.cross.elsclient.blimpl.constantblimpl.ConstantInfoImpl;
import org.cross.elsclient.blimpl.goodsblimpl.GoodsBLImpl;
import org.cross.elsclient.blimpl.goodsblimpl.GoodsInfoImpl;
import org.cross.elsclient.blimpl.initialblimpl.InitialBLImpl;
import org.cross.elsclient.blimpl.initialblimpl.InitialInfo;
import org.cross.elsclient.blimpl.initialblimpl.InitialInfoImpl;
import org.cross.elsclient.blimpl.logblimpl.LogBLImpl;
import org.cross.elsclient.blimpl.logblimpl.LogInfoImpl;
import org.cross.elsclient.blimpl.numberblimpl.NumberBLImpl;
import org.cross.elsclient.blimpl.organizationblimpl.OrganizationBLImpl;
import org.cross.elsclient.blimpl.organizationblimpl.OrganizationInfoImpl;
import org.cross.elsclient.blimpl.personnelblimpl.PersonnelBLImpl;
import org.cross.elsclient.blimpl.personnelblimpl.PersonnelInfoImpl;
import org.cross.elsclient.blimpl.receiptblimpl.ReceiptBLImpl;
import org.cross.elsclient.blimpl.receiptblimpl.ReceiptInfoImpl;
import org.cross.elsclient.blimpl.salaryblimpl.SalaryBLImpl;
import org.cross.elsclient.blimpl.stockblimpl.StockBLImpl;
import org.cross.elsclient.blimpl.stockblimpl.StockInfoImpl;
import org.cross.elsclient.blimpl.userblimpl.UserBLImpl;
import org.cross.elsclient.blimpl.userblimpl.UserInfoImpl;
import org.cross.elsclient.blimpl.vehicleblimpl.VehicleBLImpl;
import org.cross.elsclient.blimpl.vehicleblimpl.VehicleInfoImpl;
import org.cross.elsclient.blservice.accountblservice.AccountBLService;
import org.cross.elsclient.blservice.analysisblservice.AnalysisBLService;
import org.cross.elsclient.blservice.blfactoryservice.BLFactoryService;
import org.cross.elsclient.blservice.constantblservice.ConstantBLService;
import org.cross.elsclient.blservice.goodsblservice.GoodsBLService;
import org.cross.elsclient.blservice.initialblservice.InitialBLService;
import org.cross.elsclient.blservice.logblservice.LogBLService;
import org.cross.elsclient.blservice.numberblservice.NumberBLService;
import org.cross.elsclient.blservice.organizationblservice.OrganizationBLService;
import org.cross.elsclient.blservice.personnelblservice.PersonnelBLService;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.blservice.stockblservice.StockBLService;
import org.cross.elsclient.blservice.userblservice.UserBLService;
import org.cross.elsclient.blservice.vehicleblservice.VehicleBLService;
import org.cross.elsclient.network.Datafactory;
import org.cross.elscommon.dataservice.accountdataservice.AccountDataService;
import org.cross.elscommon.dataservice.constantdataservice.ConstantDataService;
import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;
import org.cross.elscommon.dataservice.goodsdataservice.GoodsDataService;
import org.cross.elscommon.dataservice.initialdataservice.InitialDataService;
import org.cross.elscommon.dataservice.logdataservice.LogDataService;
import org.cross.elscommon.dataservice.numberdataservice.NumberDataService;
import org.cross.elscommon.dataservice.organizationdataservice.OrganizationDataService;
import org.cross.elscommon.dataservice.personneldataservice.PersonnelDataService;
import org.cross.elscommon.dataservice.receiptdataservice.ReceiptDataService;
import org.cross.elscommon.dataservice.salarydataservice.SalaryDataService;
import org.cross.elscommon.dataservice.stockdataservice.StockDataService;
import org.cross.elscommon.dataservice.userdataservice.UserDataService;
import org.cross.elscommon.dataservice.vehicledataservice.VehicleDataService;

public class BLFactoryImpl implements BLFactoryService{

	DataFactoryService dataFactoryService;

	UserDataService userDataService;
	ReceiptDataService receiptDataService;
	GoodsDataService goodsDataService;
	StockDataService stockDataService;
	PersonnelDataService personnelDataService;
	OrganizationDataService organizationDataService;
	SalaryDataService salaryDataService;
	VehicleDataService vehicleDataService;
	NumberDataService numberDataService;
	AccountDataService accountDataService;
	ConstantDataService constantDataService;
	InitialDataService initialDataService;
	LogDataService logDataService;

	UserInfoImpl userInfo;
	ReceiptInfoImpl receiptInfo;
	GoodsInfoImpl goodsInfo;
	StockInfoImpl stockInfo;
	PersonnelInfoImpl personnelInfo;
	OrganizationInfoImpl organizationInfo;
	SalaryBLImpl salaryInfo;
	VehicleInfoImpl vehicleInfo;
	AccountInfo accountInfo;
	ConstantInfo constantInfo;
	InitialInfoImpl initialInfo;
	LogInfo logInfo;
	
	public BLFactoryImpl() throws RemoteException{
		this.dataFactoryService = new Datafactory();
		
		this.userDataService = dataFactoryService.getuserdaData();
		this.receiptDataService = dataFactoryService.getReceiptData();
		this.goodsDataService = dataFactoryService.getGoodsData();
		this.stockDataService = dataFactoryService.getStockData();
		this.personnelDataService = dataFactoryService.getPersonnelData();
		this.organizationDataService = dataFactoryService.getOrganizationData();
		this.salaryDataService = dataFactoryService.getSalaryData();
		this.vehicleDataService = dataFactoryService.getVehicleData();
		this.numberDataService = dataFactoryService.getNumberDataService();
		this.accountDataService = dataFactoryService.getAccountData();
		this.constantDataService = dataFactoryService.getConstantData();
		this.initialDataService = dataFactoryService.getinInitialData();
		this.logDataService = dataFactoryService.getlogData();
		
		this.userInfo = new UserInfoImpl(userDataService);
		this.receiptInfo = new ReceiptInfoImpl(receiptDataService);
		this.goodsInfo = new GoodsInfoImpl(goodsDataService);
		this.stockInfo = new StockInfoImpl(stockDataService);
		this.salaryInfo = new SalaryBLImpl(salaryDataService);
		this.personnelInfo = new PersonnelInfoImpl(personnelDataService, salaryInfo);
		this.organizationInfo = new OrganizationInfoImpl(organizationDataService);
		this.vehicleInfo = new VehicleInfoImpl(vehicleDataService);
		this.accountInfo = new AccountInfoImpl(accountDataService);
		this.constantInfo = new ConstantInfoImpl();
		this.initialInfo = new InitialInfoImpl(organizationInfo, personnelInfo, vehicleInfo, stockInfo, accountInfo);
		this.initialInfo.initdata = initialDataService;
		this.initialInfo.sal = salaryDataService;
		this.initialInfo.userinfo = userInfo;
		this.logInfo = new LogInfoImpl();
		
		this.receiptInfo.goodsInfo = this.goodsInfo;
		this.receiptInfo.personnelInfo = this.personnelInfo;
		this.receiptInfo.stockInfo = this.stockInfo;
		this.goodsInfo.receiptInfo = this.receiptInfo;
		this.personnelInfo.receiptInfo = this.receiptInfo;
		this.stockInfo.goodsInfo = this.goodsInfo;
		this.stockInfo.orgInfo = this.organizationInfo;
	}
	
	@Override
	public UserBLService getUserBLService() throws RemoteException {
		
		return new UserBLImpl(userDataService, userInfo);
	}

	@Override
	public AccountBLService getAccountBLService() throws RemoteException {
		return new AccountBLImpl(accountDataService, accountInfo);
	}

	@Override
	public AnalysisBLService analysisBLService() throws RemoteException {
		return new AnalysisBLImpl(receiptInfo);
	}

	@Override
	public ConstantBLService constantBLService() throws RemoteException {
		return new ConstantBLImpl(constantDataService, constantInfo);
	}

	@Override
	public GoodsBLService goodsBLService() throws RemoteException {
		return new GoodsBLImpl(goodsDataService, goodsInfo);
	}

	@Override
	public InitialBLService initialBLService() throws RemoteException {
		return new InitialBLImpl(initialDataService, initialInfo, organizationInfo, personnelInfo, vehicleInfo, stockInfo, accountInfo, salaryInfo, salaryDataService);
	}

	@Override
	public LogBLService logBLService() throws RemoteException {
		LogBLImpl logbl = new LogBLImpl(logDataService);
		logbl.logInfo = logInfo;
		return logbl;
	}

	@Override
	public OrganizationBLService organizationBLService() throws RemoteException {
		return new OrganizationBLImpl(organizationDataService, organizationInfo);
	}

	@Override
	public PersonnelBLService personnelBLService() throws RemoteException {
		return new PersonnelBLImpl(personnelDataService, personnelInfo, receiptInfo, salaryInfo, salaryDataService);
	}

	@Override
	public ReceiptBLService receiptBLService() throws RemoteException {
		return new ReceiptBLImpl(this.receiptDataService, this.receiptInfo, this.goodsInfo);
	}

	@Override
	public StockBLService stockBLService() throws RemoteException {
		return new StockBLImpl(this.stockDataService, this.goodsInfo, this.stockInfo, this.receiptInfo);
	}

	@Override
	public VehicleBLService vehicleBLService() throws RemoteException {
		return new VehicleBLImpl(vehicleDataService, vehicleInfo);
	}

	@Override
	public SalaryDataService salaryDataService() throws RemoteException {
		return salaryDataService;
	}

	@Override
	public ConstantDataService constantDataService() throws RemoteException {
		return constantDataService;
	}

	@Override
	public NumberBLService numberBLService() throws RemoteException {
		return new NumberBLImpl(this.numberDataService);
	}

}
