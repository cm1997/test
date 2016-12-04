package org.cross.elsclient.blimpl.goodsblimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.accountblimpl.MockLog;
import org.cross.elsclient.vo.HistoryVO;
import org.cross.elscommon.util.GoodsState;
import org.cross.elscommon.util.ResultMessage;

public class Goods {

	public ResultMessage createLog(String log){
		MockLog mockLog = new MockLog(log);
		return mockLog.createLog();
	}

}
