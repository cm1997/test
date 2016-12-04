package org.cross.elsclient.blservice.numberblservice;

import java.rmi.RemoteException;

import org.cross.elscommon.po.NumberPO;
import org.cross.elscommon.util.NumberType;
import org.cross.elscommon.util.ResultMessage;

public interface NumberBLService {
	public String getPostNumber(NumberType type);
	public NumberPO getPO()throws RemoteException;
	public void addone(NumberType type,String number);
	public void addsome(NumberType type, String number, int num);
}
