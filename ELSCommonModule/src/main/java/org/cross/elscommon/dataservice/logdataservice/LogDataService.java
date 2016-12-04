/**
 * 系统日志数据接口
 * @author Polaris Chen
 * @date 2015/10/19
 */
package org.cross.elscommon.dataservice.logdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.po.LogPO;
import org.cross.elscommon.util.ResultMessage;

public interface LogDataService extends Remote{

	/**
	 * 添加系统日志
	 * @para 
	 * @return ResultMessage
	 */
	public ResultMessage insert(LogPO po) throws RemoteException;

	/**
	 * 查找系统日志
	 * @para 
	 * @return ArrayList<LogPO>
	 */
	public ArrayList<LogPO> find(String startTime, String endTime) throws RemoteException;

	/**
	 * 展示系统日志
	 * @para 
	 * @return ArrayList<LogPO>
	 */
	public ArrayList<LogPO> show() throws RemoteException;
}
