package org.cross.elscommon.dataservice.datafactoryservice;

import java.rmi.RemoteException;

import org.cross.elscommon.dataservice.accountdataservice.AccountDataService;
import org.cross.elscommon.dataservice.constantdataservice.ConstantDataService;
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

public interface DataFactoryService {

	public StockDataService getStockData() throws RemoteException;

	public GoodsDataService getGoodsData() throws RemoteException;

	public ReceiptDataService getReceiptData() throws RemoteException;

	public VehicleDataService getVehicleData() throws RemoteException;

	public AccountDataService getAccountData() throws RemoteException;

	public OrganizationDataService getOrganizationData() throws RemoteException;

	public PersonnelDataService getPersonnelData() throws RemoteException;

	public LogDataService getlogData() throws RemoteException;

	public InitialDataService getinInitialData() throws RemoteException;

	public UserDataService getuserdaData() throws RemoteException;

	public SalaryDataService getSalaryData() throws RemoteException;

	public ConstantDataService getConstantData() throws RemoteException;

	public NumberDataService getNumberDataService() throws RemoteException;
}
