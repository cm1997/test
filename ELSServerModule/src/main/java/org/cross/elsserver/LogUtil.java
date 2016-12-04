package org.cross.elsserver;

import java.rmi.RemoteException;

import org.cross.elscommon.po.NumberPO;
import org.cross.elsserver.dataimpl.numberdataimpl.NumberDataImpl;

public class LogUtil {
	static NumberPO number;
	
	public static String logNum(){
		NumberDataImpl numberdata = null;
		try {
			numberdata = new NumberDataImpl();
			if(number==null) number = numberdata.show();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res = number.getLogNum();
		int a = Integer.parseInt(res.substring(1));
		a++;
		number.setLogNum(String.valueOf(a));
		try {
			numberdata.update(number);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
}
