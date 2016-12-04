/**
 * 系统日志业务逻辑接口
 * @author Polaris Chen
 * @date 2015/10/19
 */
package org.cross.elsclient.blservice.logblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.util.ResultMessage;
import org.cross.elsclient.vo.LogVO;

public interface LogBLService {

	/**
	 * 查看系统日志
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws RemoteException 
	 */
	public ArrayList<LogVO> show(String startTime, String endTime) throws RemoteException;

	/**
	 * 添加系统日志
	 * 
	 * @param vo
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMessage add(LogVO vo) throws RemoteException;

}
