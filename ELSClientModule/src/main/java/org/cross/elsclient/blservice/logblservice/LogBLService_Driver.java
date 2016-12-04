/**
 * 系统日志业务逻辑驱动程序
 * @author Polaris Chen
 * @date 2015/10/19
 */
package org.cross.elsclient.blservice.logblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.util.ResultMessage;
import org.cross.elsclient.vo.LogVO;

public class LogBLService_Driver {

	public void drive(LogBLService logBLService) throws RemoteException {
		ArrayList<LogVO> logvolist = logBLService.show("2015-10-01", "2015-10-31");
		System.out.println("显示系统日志：");
		System.out.println(logvolist.get(0).id);
		System.out.println(logvolist.get(1).id);

		ResultMessage result = logBLService.add(new LogVO("L2015101900001", "2015-10-19 14:34:29", "00002汤姆", "查看成本收益表"));
		if (result == ResultMessage.SUCCESS) {
			System.out.println("添加系统日志成功");
		}
	}
}
