package org.cross.elscommon.dataservice.constantdataservice;

import java.rmi.RemoteException;

import org.cross.elscommon.po.ConstantPO;

public class ConstantDataService_Driver {
	public void drive(ConstantDataService constantDataService) throws RemoteException{
		System.out.println("业务常量：");
		constantDataService.show();
		constantDataService.update(new ConstantPO());
	}
}
