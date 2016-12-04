package org.cross.elsclient.blimpl.salaryblimpl;

import java.rmi.RemoteException;

import org.cross.elsclient.blimpl.blUtility.SalaryInfo;
import org.cross.elscommon.dataservice.salarydataservice.SalaryDataService;
import org.cross.elscommon.po.SalaryPO;
import org.cross.elscommon.util.ResultMessage;

public class SalaryBLImpl implements SalaryInfo{
	SalaryDataService salaryData;
	
	public SalaryBLImpl(SalaryDataService salaryData){
		this.salaryData = salaryData;
	}
	
	@Override
	public SalaryPO findbyPerNum(String perNum) throws RemoteException {
		SalaryPO po = salaryData.findbyPerNum(perNum);
		return po;
	}

	@Override
	public ResultMessage addsal(SalaryPO sa) {
		try {
			return salaryData.insert(sa);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

}
