package org.cross.elsclient.demo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import org.cross.elscommon.util.StockOperationType;
import org.cross.elsclient.vo.StockOperationVO;

public class StockInfoUI {
	
	JFrame stockInfo;
	ArrayList<StockOperationVO> ops;
	
	JLabel head;
	JTextArea textArea;
	JButton returnButton;
	
//	public StockInfoUI(ArrayList<StockOperationVO> ops){
//		this.ops = ops;
//		
//		stockInfo = new JFrame("库存查看");
//		stockInfo.setLocation(200, 300);
//		stockInfo.setSize(500,250);
//		stockInfo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		stockInfo.setVisible(true);
//		
//		head = new JLabel("库存信息：");
//		stockInfo.add(head, BorderLayout.NORTH);
//		
//		textArea = new JTextArea();
//		stockInfo.add(textArea, BorderLayout.CENTER);
//		
//		returnButton = new JButton("return");
//		stockInfo.add(returnButton, BorderLayout.SOUTH);
//		returnButton.addActionListener(new returnAct());
//		
//		show();
//	}
//
//	public void show(){
//		int in=0, out=0;
//		double inmoney=0, outmoney=0;
//		textArea.append("\n");
//		textArea.append("快件信息：（包括编号、出/入库时间、金额、存放位置）\n");
//		for (int i = 0; i < ops.size(); i++) {
//			StockOperationVO vo = ops.get(i);
//			if (vo.type == StockOperationType.STOCKIN) {
//				in++;
//				inmoney += vo.money;
//			}else {
//				out++;
//				outmoney += vo.money;
//			}
//			textArea.append(vo.good.orderNumber+"  "+vo.time+"  "+vo.type.toString()+"  "
//			+vo.money+"  "+vo.place.toString()+"\n");
//		}
//		textArea.append("入库数量："+ in+"  金额："+inmoney+"\n");
//		textArea.append("出库数量："+out+"  金额："+outmoney+"\n");
//	}
	
	public class ceturnAct implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			stockInfo.setVisible(false);
		}
		
	}
}
