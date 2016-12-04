/**
 * 系统日志数据驱动程序
 * @author Polaris Chen
 * @date 2015/10/19
 */
package org.cross.elscommon.dataservice.logdataservice;

import java.rmi.RemoteException;

import org.cross.elscommon.po.LogPO;

public class LogDataService_Driver {

	public void drive(LogDataService logDataService) throws RemoteException {
		System.out.println("显示系统日志：");
		logDataService.insert(new LogPO("L2015101900001", "2015-10-19 14:34:29", "00002汤姆", "查看成本收益表"));
		logDataService.find("2015-10-01", "2015-10-31");
		logDataService.show();
	}
}
