package org.cross.elsclient.test;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Ihello extends Remote{
	public String SayHello() throws RemoteException;
	public String helloTo(String name) throws RemoteException;
}
