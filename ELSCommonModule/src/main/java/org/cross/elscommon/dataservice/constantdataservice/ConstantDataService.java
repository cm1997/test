package org.cross.elscommon.dataservice.constantdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.cross.elscommon.po.ConstantPO;
import org.cross.elscommon.util.ResultMessage;

public interface ConstantDataService extends Remote{
	
	/**
	 * 更新业务常量
	 * @para 
	 * @return ResultMessage
	 */
	public ResultMessage update(ConstantPO po) throws RemoteException;
	
	/**
	 * 显示业务常量
	 * @para 
	 * @return 业务常量VO类
	 */
	public ConstantPO show() throws RemoteException;
}
