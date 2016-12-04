package org.cross.elsclient.blservice.constantblservice;

import java.rmi.RemoteException;

import org.cross.elscommon.util.ResultMessage;
import org.cross.elsclient.vo.ConstantVO;

public interface ConstantBLService {
	
	/**
	 * 更新业务常量
	 * @para 
	 * @return ResultMessage
	 * @throws RemoteException 
	 */
	public ResultMessage update(ConstantVO vo) throws RemoteException;
	
	/**
	 * 显示业务常量
	 * @para 
	 * @return 业务常量VO类
	 * @throws RemoteException 
	 */
	public ConstantVO show();
	
}
