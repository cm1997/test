package org.cross.elsclient.ui.util;

import java.rmi.RemoteException;
import java.util.concurrent.TimeUnit;

import org.cross.elsclient.blimpl.blfactoryimpl.BLFactoryImpl;
import org.cross.elsclient.blservice.blfactoryservice.BLFactoryService;
import org.cross.elsclient.blservice.logblservice.LogBLService;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.LogVO;
import org.cross.elscommon.util.NumberType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.TimeUtil;

public class LogUtil {
	public static LogBLService LOGBL;
	
	public static void initLogBl(){
		try {
			BLFactoryService blFactory = new BLFactoryImpl();
			LOGBL = blFactory.logBLService();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void addLog(String operation){
		try {
			String number = ConstantVal.numberbl.getPostNumber(NumberType.LOG);
			ResultMessage rs = LOGBL.add(new LogVO(number, TimeUtil.getCurrentTime(), UIConstant.CURRENT_USER.number, operation));
			if (rs == ResultMessage.SUCCESS) {
				ConstantVal.numberbl.addone(NumberType.LOG, number);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
