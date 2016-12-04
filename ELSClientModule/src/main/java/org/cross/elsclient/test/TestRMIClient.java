package org.cross.elsclient.test;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class TestRMIClient {

    public static void main(String args[]){ 
        try { 
            //在RMI服务注册表中查找名称为RHello的对象，并调用其上的方法 
            Ihello rhello =(Ihello) Naming.lookup("rmi://localhost:8886/RHello"); 
            System.out.println(rhello.SayHello()); 
            System.out.println(rhello.helloTo("dnn")); 
        } catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
    } 
}
