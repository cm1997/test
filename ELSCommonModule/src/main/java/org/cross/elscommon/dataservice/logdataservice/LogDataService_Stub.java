/**
 * 系统日志数据桩程序
 * @author Polaris Chen
 * @date 2015/10/19
 */
package org.cross.elscommon.dataservice.logdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.po.LogPO;
import org.cross.elscommon.util.ResultMessage;

public class LogDataService_Stub implements LogDataService {

	@Override
	public ResultMessage insert(LogPO po) throws RemoteException {
		System.out.println("增加系统日志成功");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<LogPO> find(String time1, String time2)
			throws RemoteException {
		ArrayList<LogPO> result = new ArrayList<LogPO>();
		System.out.println("查找系统日志成功");
		return result;
	}

	@Override
	public ArrayList<LogPO> show() throws RemoteException {
		ArrayList<LogPO> result = new ArrayList<LogPO>();
		System.out.println("显示系统日志成功");
		return result;
	}

}
