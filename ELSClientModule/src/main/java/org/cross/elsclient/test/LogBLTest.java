package org.cross.elsclient.test;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.LogInfo;
import org.cross.elsclient.blimpl.logblimpl.LogBLImpl;
import org.cross.elsclient.blimpl.logblimpl.LogInfoImpl;
import org.cross.elsclient.network.Datafactory;
import org.cross.elsclient.vo.LogVO;
import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;
import org.cross.elscommon.util.ResultMessage;

public class LogBLTest {

	public static void main(String[] args) throws RemoteException {
		DataFactoryService dataFactory = new Datafactory();
		LogBLImpl logBLImpl = new LogBLImpl(dataFactory.getlogData());
		LogInfo logInfo = new LogInfoImpl();
		logBLImpl.logInfo = logInfo;

		System.out.println("test ---------- show");
		ArrayList<LogVO> show = logBLImpl.show("2015-10-1", "2015-10-2");
		System.out.println(show.size());
		for (int i = 0; i < show.size(); i++) {
			System.out.println(show.get(i).id + " " + show.get(i).operator
					+ " " + show.get(i).time);
		}
		
//		System.out.println("test ---------- add");
//		LogVO logVO = new LogVO("log002", "2015-10-1 19:12", "出库", "陈丹妮。。。");
//		ResultMessage addMessage = logBLImpl.add(logVO);
//		if (addMessage == ResultMessage.SUCCESS) {
//			System.out.println("增加成功");
//		}else {
//			System.out.println("增加失败");
//		}

	}

}
