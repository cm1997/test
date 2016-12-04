package org.cross.elsclient.demo;

import java.awt.BorderLayout;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.cross.elsclient.vo.StockVO;
import org.cross.elscommon.dataservice.goodsdataservice.GoodsDataService;

public class LoginUI {
	
	JFrame logFrame;
	JButton button;
	JTextField name;
	JTextField password;
	JLabel nameLabel;
	JLabel passwordLabel;
	int width = 500;
	int height = 400;
	
	JTextArea show;
	public GoodsDataService goodsdata;
	JButton getButton;
	
	UIFactory uiFactory;
	
	public LoginUI(UIFactory uiFactory){
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		this.uiFactory = uiFactory;
		
		logFrame = new JFrame("登陆界面");
		button = new JButton("确认登陆");
		name = new JTextField("00001");
		password = new JTextField("*********");
		nameLabel = new JLabel("用户名 ：");
		passwordLabel = new JLabel("密码 ：");
		
		logFrame.setLayout(null);
		
		logFrame.setVisible(true);
		logFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		logFrame.setSize(width, height);
		logFrame.setLocation(w/2 - width/2, h/2 - height/2);
		
		
		button.addActionListener(new logListener());
		
		nameLabel.setBounds(10,10,60,20);
		passwordLabel.setBounds(10,25,60,70);
		name.setBounds(65,10,200,20);
		password.setBounds(65,50,200,20);
		button.setBounds(10,100,170,50);
		
		show = new JTextArea("will show:\n");
		show.setBounds(20, 200, 200, 100);
		getButton = new JButton("get");
		getButton.setBounds(20, 300, 50, 20);
		
		logFrame.getContentPane().add(nameLabel);
		logFrame.getContentPane().add(passwordLabel);
		logFrame.getContentPane().add(name);
		logFrame.getContentPane().add(password);
		logFrame.getContentPane().add(button);
		logFrame.getContentPane().add(show);
		logFrame.getContentPane().add(getButton);

	}
	
	public class logListener implements ActionListener{
		

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			StockUI select = uiFactory.getStockUI();
			try {
				select.stockbl.findStock(name.getText().trim());
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block 
				e1.printStackTrace();
			}
			
//			logFrame.getContentPane().add(select.stockFunctionSelect);
		}
		
	}

}
