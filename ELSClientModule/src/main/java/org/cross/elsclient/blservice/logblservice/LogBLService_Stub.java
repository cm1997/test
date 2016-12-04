/**
 * 系统日志业务逻辑桩程序
 * @author Polaris Chen
 * @date 2015/10/19
 */
package org.cross.elsclient.blservice.logblservice;

import java.util.ArrayList;

import org.cross.elscommon.util.ResultMessage;
import org.cross.elsclient.vo.LogVO;

public class LogBLService_Stub implements LogBLService {

	@Override
	public ArrayList<LogVO> show(String startTime, String endTime) {
		ArrayList<LogVO> logVOList = new ArrayList<LogVO>();
		logVOList.add(new LogVO("L2015101900001", "2015-10-19 14:34:29", "00002汤姆", "查看成本收益表"));
		logVOList.add(new LogVO("L2015101900002", "2015-10-19 18:20:23", "00001杰利", "查看ICBC账户"));
		logVOList.add(new LogVO("L2015101900002", "2015-10-19 18:20:23", "00001杰利", "查看ICBC账户"));
		logVOList.add(new LogVO("L2015101900002", "2015-10-19 18:20:23", "00001杰利", "查看ICBC账户"));
		logVOList.add(new LogVO("L2015101900002", "2015-10-19 18:20:23", "00001杰利", "查看ICBC账户"));
		logVOList.add(new LogVO("L2015101900002", "2015-10-19 18:20:23", "00001杰利", "查看ICBC账户"));
		logVOList.add(new LogVO("L2015101900002", "2015-10-19 18:20:23", "00001杰利", "查看ICBC账户"));
		return logVOList;
	}

	@Override
	public ResultMessage add(LogVO vo) {

		return ResultMessage.SUCCESS;
	}

}
