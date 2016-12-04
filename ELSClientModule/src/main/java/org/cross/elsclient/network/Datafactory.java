package org.cross.elsclient.network;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

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
import org.cross.elscommon.util.NetWork;

public class Datafactory implements DataFactoryService{

	@Override
	public StockDataService getStockData() throws RemoteException {
		// TODO Auto-generated method stub
		
		StockDataService stockdata = null;
		
		try {
			stockdata = (StockDataService)Naming.lookup(NetWork.preAddress+NetWork.port+"/stockdata");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
		return stockdata;
	}

	@Override
	public GoodsDataService getGoodsData() throws RemoteException {
		GoodsDataService goodsdata = null;
		
		try {
			goodsdata = (GoodsDataService)Naming.lookup(NetWork.preAddress+NetWork.port+"/goodsdata");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
		return goodsdata;
	}

	@Override
	public ReceiptDataService getReceiptData() throws RemoteException {
		
		ReceiptDataService receiptdata = null;
		
		try {
			receiptdata = (ReceiptDataService)Naming.lookup(NetWork.preAddress+NetWork.port+"/receiptdata");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return receiptdata;
		
	}

	@Override
	public VehicleDataService getVehicleData() throws RemoteException {
		VehicleDataService vehicleData = null;
		try {
			vehicleData = (VehicleDataService)Naming.lookup(NetWork.preAddress+NetWork.port+"/vehicledata");
		} catch (MalformedURLException | NotBoundException e) {
			e.printStackTrace();
		}
		return vehicleData;
	}

	@Override
	public AccountDataService getAccountData() throws RemoteException {
		AccountDataService accountData = null;
		try {
			accountData = (AccountDataService) Naming.lookup(NetWork.preAddress+NetWork.port+"/accountdata");
		} catch (MalformedURLException | NotBoundException e) {
			e.printStackTrace();
		}
		return accountData;
	}

	@Override
	public OrganizationDataService getOrganizationData() throws RemoteException {
		OrganizationDataService organizationData = null;
		try {
			organizationData = (OrganizationDataService) Naming.lookup(NetWork.preAddress+NetWork.port+"/organizationdata");
		} catch (MalformedURLException | NotBoundException e) {
			e.printStackTrace();
		}
		return organizationData;
	}

	@Override
	public PersonnelDataService getPersonnelData() throws RemoteException {
		PersonnelDataService personnelDataService = null;
		try {
			personnelDataService = (PersonnelDataService)Naming.lookup(NetWork.preAddress+NetWork.port+"/personneldata");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return personnelDataService;
	}

	@Override
	public LogDataService getlogData() throws RemoteException {
		LogDataService logDataService = null;
		try {
			logDataService = (LogDataService)Naming.lookup(NetWork.preAddress+NetWork.port+"/logdata");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return logDataService;
	}

	@Override
	public InitialDataService getinInitialData() throws RemoteException {
		InitialDataService initialDataService = null;
		try {
			initialDataService = (InitialDataService)Naming.lookup(NetWork.preAddress+NetWork.port+"/initialdata");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return initialDataService;
	}

	@Override
	public UserDataService getuserdaData() throws RemoteException {
		UserDataService userDataService = null;
		try {
			userDataService = (UserDataService)Naming.lookup(NetWork.preAddress+NetWork.port+"/userdata");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return userDataService;
	}

	@Override
	public SalaryDataService getSalaryData() throws RemoteException {
		SalaryDataService salaryDataService = null;
		try {
			salaryDataService = (SalaryDataService)Naming.lookup(NetWork.preAddress+NetWork.port+"/salarydata");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return salaryDataService;
	}

	@Override
	public ConstantDataService getConstantData() throws RemoteException {
		ConstantDataService constantDataService = null;
		try {
			constantDataService = (ConstantDataService)Naming.lookup(NetWork.preAddress+NetWork.port+"/constantdata");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return constantDataService;
	}

	@Override
	public NumberDataService getNumberDataService() throws RemoteException {
		NumberDataService numberdata = null;
		try {
			numberdata = (NumberDataService)Naming.lookup(NetWork.preAddress+NetWork.port+"/numberdata");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return numberdata;
	}

}
