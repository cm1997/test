package org.cross.elsserver.ui;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;
import org.cross.elscommon.dataservice.goodsdataservice.GoodsDataService;
import org.cross.elsserver.dataimpl.DataFactoryServiceImpl;
import org.cross.elsserver.dataimpl.goodsdataimpl.GoodsDataImpl;

public class MainUITest {

	JFrame mainFrame;
	JTextArea text;
	JButton button;
	JLabel label;
	
	public MainUITest(){
		mainFrame = new JFrame("Server UI");
		mainFrame.setLayout(null);
		
		mainFrame.setBounds(100, 100, 400, 600);
		
		label = new JLabel("test");
		label.setBounds(50, 50, 100, 40);
		mainFrame.getContentPane().add(label);
		
		text = new JTextArea("please input:\n");
		text.setBounds(50, 150, 200, 100);
		mainFrame.getContentPane().add(text);
		
		button = new JButton("send");
		button.setBounds(50, 350, 40, 20);
		mainFrame.getContentPane().add(button);
		
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String [] args) throws RemoteException{
		MainUITest mainUI = new MainUITest();
		GoodsDataService goodsdata;
		DataFactoryService dataFactory = new DataFactoryServiceImpl();
		try {
			goodsdata = dataFactory.getGoodsData();
			LocateRegistry.createRegistry(8885);
			
			Naming.bind("rmi://localhost:8885/goodsdata", goodsdata);
			
			System.out.println("server start successful!");
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
