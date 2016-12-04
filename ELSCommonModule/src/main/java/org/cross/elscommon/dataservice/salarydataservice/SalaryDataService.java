package org.cross.elscommon.dataservice.salarydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.po.SalaryPO;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.SalaryType;

public interface SalaryDataService extends Remote{

	public ResultMessage insert(SalaryPO po) throws RemoteException;

	public ResultMessage delete(String perNum) throws RemoteException;

	public ResultMessage update(SalaryPO po) throws RemoteException;

	public ArrayList<SalaryPO> show() throws RemoteException;

	public SalaryPO findbyPerNum(String perNum) throws RemoteException;
	
	public ArrayList<SalaryPO> findByType(SalaryType type) throws RemoteException;
}
