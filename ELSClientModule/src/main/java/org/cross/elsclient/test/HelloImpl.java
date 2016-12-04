package org.cross.elsclient.test;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements Ihello{

	protected HelloImpl() throws RemoteException {
//		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String SayHello() throws RemoteException{
		// TODO Auto-generated method stub
		return "Hello world!!";
	}

	@Override
	public String helloTo(String name) throws RemoteException{
		// TODO Auto-generated method stub
		return "你好"+name+"!!";
	}

}
