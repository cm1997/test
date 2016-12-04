package org.cross.elsclient.blimpl.logblimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.LogInfo;
import org.cross.elsclient.blservice.logblservice.LogBLService;
import org.cross.elsclient.vo.LogVO;
import org.cross.elscommon.dataservice.logdataservice.LogDataService;
import org.cross.elscommon.dataservice.logdataservice.LogDataService_Stub;
import org.cross.elscommon.po.LogPO;
import org.cross.elscommon.util.ResultMessage;

public class LogBLImpl implements LogBLService{
	
	public LogDataService logData;
	public LogInfo logInfo;
	
	public LogBLImpl(LogDataService logData){
		this.logData = logData;
	}
	
	@Override
	public ArrayList<LogVO> show(String startTime, String endTime) throws RemoteException {
		ArrayList<LogVO> vos = new ArrayList<LogVO>();
		ArrayList<LogPO> pos = logData.find(startTime, endTime);
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(logInfo.toLogVO(pos.get(i)));
		}
		return vos;
	}

	@Override
	public ResultMessage add(LogVO vo) throws RemoteException {
		System.out.println("op:"+vo.operator);
		LogPO po = logInfo.toLogPO(vo);
		return logData.insert(po);
	}

}
