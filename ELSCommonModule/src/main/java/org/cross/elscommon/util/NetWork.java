package org.cross.elscommon.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetWork {
	public static int port = 8885;
	public static String local = "127.0.0.1";
	public static String current_ip = "127.0.0.1";
	public static String preAddress = "rmi://localhost:";
	
	public static void setClient(String ip, int p){
		current_ip = ip;
		port = p;
		preAddress = "rmi://"+current_ip+":";
	}
	
	public static void setpreAddress(){
		try {
			current_ip =  InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		preAddress = "rmi://"+current_ip+":";
	}
	
	public static void main(String [] args){
		String ip = null;
		 try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println(ip);
	}
}
