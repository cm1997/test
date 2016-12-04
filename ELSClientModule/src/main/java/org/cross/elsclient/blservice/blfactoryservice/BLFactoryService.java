package org.cross.elsclient.blservice.blfactoryservice;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.accountblservice.AccountBLService;
import org.cross.elsclient.blservice.analysisblservice.AnalysisBLService;
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
import org.cross.elscommon.dataservice.constantdataservice.ConstantDataService;
import org.cross.elscommon.dataservice.salarydataservice.SalaryDataService;

public interface BLFactoryService {
	public UserBLService getUserBLService()throws RemoteException;
	public AccountBLService getAccountBLService()throws RemoteException;
	public AnalysisBLService analysisBLService()throws RemoteException;
	public ConstantBLService constantBLService()throws RemoteException;
	public GoodsBLService goodsBLService()throws RemoteException;
	public InitialBLService initialBLService()throws RemoteException;
	public LogBLService logBLService()throws RemoteException;
	public OrganizationBLService organizationBLService()throws RemoteException;
	public PersonnelBLService personnelBLService()throws RemoteException;
	public ReceiptBLService receiptBLService()throws RemoteException;
	public StockBLService stockBLService()throws RemoteException;
	public VehicleBLService vehicleBLService()throws RemoteException;
	public SalaryDataService salaryDataService()throws RemoteException;
	public ConstantDataService constantDataService()throws RemoteException;
	public NumberBLService numberBLService()throws RemoteException;
	
}
