package org.cross.elsclient.blimpl.blUtility;

import java.rmi.RemoteException;

import org.cross.elscommon.po.SalaryPO;
import org.cross.elscommon.util.ResultMessage;

public interface SalaryInfo {
	
	public SalaryPO findbyPerNum(String perNum) throws RemoteException; 

	public ResultMessage addsal(SalaryPO sa);
}
