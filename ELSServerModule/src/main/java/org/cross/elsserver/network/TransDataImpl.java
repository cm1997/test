package org.cross.elsserver.network;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;
import org.cross.elscommon.util.NetWork;
import org.cross.elsserver.LogUtil;
import org.cross.elsserver.dataimpl.DataFactoryServiceImpl;
import org.cross.elsserver.ui.util.UIConstant;

public class TransDataImpl {
	
	static int count = 0;
	static DataFactoryService datafactory;
	
	public static boolean start(){
		if (count>0) {
			return restart();
		}
		count ++;
		try {
			datafactory = new DataFactoryServiceImpl();
			LocateRegistry.createRegistry(NetWork.port);
			Naming.bind(NetWork.preAddress+NetWork.port+"/stockdata", datafactory.getStockData());
			Naming.bind(NetWork.preAddress+NetWork.port+"/goodsdata", datafactory.getGoodsData());
			Naming.bind(NetWork.preAddress+NetWork.port+"/receiptdata", datafactory.getReceiptData());
			Naming.bind(NetWork.preAddress+NetWork.port+"/vehicledata",datafactory.getVehicleData());
			Naming.bind(NetWork.preAddress+NetWork.port+"/accountdata",datafactory.getAccountData());
			Naming.bind(NetWork.preAddress+NetWork.port+"/organizationdata",datafactory.getOrganizationData());
			Naming.bind(NetWork.preAddress+NetWork.port+"/initialdata",datafactory.getinInitialData());
			Naming.bind(NetWork.preAddress+NetWork.port+"/logdata",datafactory.getlogData());
			Naming.bind(NetWork.preAddress+NetWork.port+"/userdata",datafactory.getuserdaData());
			Naming.bind(NetWork.preAddress+NetWork.port+"/personneldata",datafactory.getPersonnelData());
			Naming.bind(NetWork.preAddress+NetWork.port+"/salarydata",datafactory.getSalaryData());
			Naming.bind(NetWork.preAddress+NetWork.port+"/constantdata",datafactory.getConstantData());
			Naming.bind(NetWork.preAddress+NetWork.port+"/numberdata",datafactory.getNumberDataService());
			UIConstant.LOG.addLog("start server successfully!");
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean stop(){
		try {
			Naming.unbind(NetWork.preAddress+NetWork.port+"/stockdata");
			Naming.unbind(NetWork.preAddress+NetWork.port+"/goodsdata");
			Naming.unbind(NetWork.preAddress+NetWork.port+"/receiptdata");
			Naming.unbind(NetWork.preAddress+NetWork.port+"/vehicledata");
			Naming.unbind(NetWork.preAddress+NetWork.port+"/accountdata");
			Naming.unbind(NetWork.preAddress+NetWork.port+"/organizationdata");
			Naming.unbind(NetWork.preAddress+NetWork.port+"/initialdata");
			Naming.unbind(NetWork.preAddress+NetWork.port+"/logdata");
			Naming.unbind(NetWork.preAddress+NetWork.port+"/userdata");
			Naming.unbind(NetWork.preAddress+NetWork.port+"/personneldata");
			Naming.unbind(NetWork.preAddress+NetWork.port+"/salarydata");
			Naming.unbind(NetWork.preAddress+NetWork.port+"/constantdata");
			Naming.unbind(NetWork.preAddress+NetWork.port+"/numberdata");
			UIConstant.LOG.addLog("server stops......");
			return true;
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean restart(){
		try {
			Naming.rebind(NetWork.preAddress+NetWork.port+"/stockdata", datafactory.getStockData());
			Naming.rebind(NetWork.preAddress+NetWork.port+"/goodsdata", datafactory.getGoodsData());
			Naming.rebind(NetWork.preAddress+NetWork.port+"/receiptdata", datafactory.getReceiptData());
			Naming.rebind(NetWork.preAddress+NetWork.port+"/vehicledata",datafactory.getVehicleData());
			Naming.rebind(NetWork.preAddress+NetWork.port+"/accountdata",datafactory.getAccountData());
			Naming.rebind(NetWork.preAddress+NetWork.port+"/organizationdata",datafactory.getOrganizationData());
			Naming.rebind(NetWork.preAddress+NetWork.port+"/initialdata",datafactory.getinInitialData());
			Naming.rebind(NetWork.preAddress+NetWork.port+"/logdata",datafactory.getlogData());
			Naming.rebind(NetWork.preAddress+NetWork.port+"/userdata",datafactory.getuserdaData());
			Naming.rebind(NetWork.preAddress+NetWork.port+"/personneldata",datafactory.getPersonnelData());
			Naming.rebind(NetWork.preAddress+NetWork.port+"/salarydata",datafactory.getSalaryData());
			Naming.rebind(NetWork.preAddress+NetWork.port+"/constantdata",datafactory.getConstantData());
			Naming.rebind(NetWork.preAddress+NetWork.port+"/numberdata",datafactory.getNumberDataService());
			UIConstant.LOG.addLog("restart server successfully!");
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return false;
	}
}
