package org.cross.elsclient.demo;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.cross.elsclient.blservice.stockblservice.StockBLService;

public class StockUI {
	
	JFrame stockFunctionSelect;
	JButton button;
	int width = 500;
	int height = 400;
	
	StockBLService stockbl;
	
	public StockUI(StockBLService stockbl){
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		this.stockbl = stockbl;
		
		stockFunctionSelect = new JFrame("仓库管理功能选择");
		button = new JButton("库存查看");
		
		stockFunctionSelect.setLayout(null);
		
		button.addActionListener(new functionSelectListener());
		
		button.setBounds(200,125,100,100);
		
		stockFunctionSelect.setSize(width, height);
		stockFunctionSelect.setVisible(true);
		stockFunctionSelect.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		stockFunctionSelect.setLocation(w/2 - width/2, h/2 - height/2);
		
		stockFunctionSelect.getContentPane().add(button);
	}
	
	public class functionSelectListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			InputTimeUI timeinUI = new InputTimeUI(stockbl);
		}
	}

}
