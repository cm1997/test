package org.cross.elsserver.dataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

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
import org.cross.elsserver.dataimpl.accountdataimpl.AccountDataImpl;
import org.cross.elsserver.dataimpl.constantdataimpl.ConstantDataImpl;
import org.cross.elsserver.dataimpl.goodsdataimpl.GoodsDataImpl;
import org.cross.elsserver.dataimpl.initialdataimpl.InitialDataImpl;
import org.cross.elsserver.dataimpl.logdataimpl.LogDataImpl;
import org.cross.elsserver.dataimpl.numberdataimpl.NumberDataImpl;
import org.cross.elsserver.dataimpl.organizationdataimpl.OrganizationDataImpl;
import org.cross.elsserver.dataimpl.personneldataimpl.PersonnelDataImpl;
import org.cross.elsserver.dataimpl.receiptdataimpl.ReceiptDataImpl;
import org.cross.elsserver.dataimpl.salarydataimpl.SalaryDataImpl;
import org.cross.elsserver.dataimpl.stockdataimpl.StockDataImpl;
import org.cross.elsserver.dataimpl.userdataimpl.UserDataImpl;
import org.cross.elsserver.dataimpl.vehicledataimpl.VehicleDataImpl;

public class DataFactoryServiceImpl extends UnicastRemoteObject implements DataFactoryService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DataFactoryServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public StockDataService getStockData() throws RemoteException {
		return new StockDataImpl();
	}

	@Override
	public GoodsDataService getGoodsData() throws RemoteException {
		return new GoodsDataImpl();
	}

	@Override
	public ReceiptDataService getReceiptData() throws RemoteException {
		return new ReceiptDataImpl();
	}

	@Override
	public VehicleDataService getVehicleData() throws RemoteException {
		return new VehicleDataImpl();
	}

	@Override
	public AccountDataService getAccountData() throws RemoteException {
		return new AccountDataImpl();
	}

	@Override
	public OrganizationDataService getOrganizationData() throws RemoteException {
		return new OrganizationDataImpl();
	}

	@Override
	public PersonnelDataService getPersonnelData() throws RemoteException {
		return new PersonnelDataImpl();
	}

	@Override
	public LogDataService getlogData() throws RemoteException {
		return new LogDataImpl();
	}

	@Override
	public InitialDataService getinInitialData() throws RemoteException {
		return new InitialDataImpl();
	}

	@Override
	public UserDataService getuserdaData() throws RemoteException {
		return new UserDataImpl();
	}

	@Override
	public SalaryDataService getSalaryData() throws RemoteException {
		return new SalaryDataImpl();
	}

	@Override
	public ConstantDataService getConstantData() throws RemoteException {
		return new ConstantDataImpl();
	}

	@Override
	public NumberDataService getNumberDataService() throws RemoteException {
		return new NumberDataImpl();
	}

}
