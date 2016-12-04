package org.cross.elsclient.demo;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.cross.elscommon.dataservice.goodsdataservice.GoodsDataService;

public class MainFrame {
	
	public static void main(String [] args){
		
		UIFactory ui = new UIFactory();
		LoginUI loginUI = new LoginUI(ui);
		System.out.println("1");
		
		try {
			GoodsDataService goods = (GoodsDataService)Naming.lookup("rmi://localhost:8885/goodsdata");
			
			loginUI.goodsdata = goods;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
