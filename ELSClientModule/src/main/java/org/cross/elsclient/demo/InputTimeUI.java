package org.cross.elsclient.demo;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.cross.elsclient.blservice.stockblservice.StockBLService;
import org.cross.elsclient.vo.StockOperationVO;
import org.cross.elsclient.vo.StockVO;

public class InputTimeUI {
	JFrame timeIn;
	JButton button;
	JTextField startTime;
	JTextField endTime;
	JLabel startTimeLabel;
	JLabel endTimeLabel;
	int width = 500;
	int height = 400;
	
	StockBLService stockbl;
	
	public InputTimeUI(StockBLService stockbl){
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		this.stockbl = stockbl;
		
		timeIn = new JFrame("起止时间输入界面");
		button = new JButton("确认");
		startTime = new JTextField("2015-10-25 10:10:10");
		endTime = new JTextField("2015-10-26 22:10:10");
		startTimeLabel = new JLabel("startTime ：");
		endTimeLabel = new JLabel("endTime ：");
		
		timeIn.setLayout(null);
		
		timeIn.setVisible(true);
		timeIn.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		timeIn.setSize(width, height);
		timeIn.setLocation(w/2 - width/2, h/2 - height/2);
		
		button.addActionListener(new timeInListener());
		
		startTimeLabel.setBounds(10,10,75,20);
		endTimeLabel.setBounds(10,25,70,70);
		startTime.setBounds(75,10,210,20);
		endTime.setBounds(75,50,210,20);
		button.setBounds(10,100,170,50);
		
		timeIn.getContentPane().add(startTimeLabel);
		timeIn.getContentPane().add(endTimeLabel);
		timeIn.getContentPane().add(startTime);
		timeIn.getContentPane().add(endTime);
		timeIn.getContentPane().add(button);
	}
	public class timeInListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
//			ArrayList<StockOperationVO> ops = stockbl.showStockInfo(startTime.getText(), endTime.getText());
//			StockInfoUI stockInfoUI = new StockInfoUI(ops);
		}
		
	}
	
}
