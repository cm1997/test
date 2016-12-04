package org.cross.elsclient.ui.stockkeeperui.observe;

import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;

import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.blservice.stockblservice.StockBLService;
import org.cross.elsclient.ui.businesshallclerkui.ReceiptManageTable;
import org.cross.elsclient.ui.component.ELSButton;
import org.cross.elsclient.ui.component.ELSDatePicker;
import org.cross.elsclient.ui.component.ELSManagePanel;
import org.cross.elsclient.ui.util.ComponentFactory;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.vo.Receipt_TransVO;
import org.cross.elsclient.vo.StockAreaVO;
import org.cross.elsclient.vo.StockCheckVO;
import org.cross.elsclient.vo.StockSeeVO;
import org.cross.elsclient.vo.StockVO;
import org.cross.elsclient.vo.UserVO;

public class StockSeeManagePanel extends ELSManagePanel{
	StockBLService stockbl;
	StockSeeVO stocksee;
	StockVO stock;
	UserVO user;
	
	ELSDatePicker beginDate;
	ELSDatePicker endDate;
	
	StockSeeManageTableFirst listFirst;
	StockSeeManageTableSecond listSecond;
	ELSButton addBtn;
	
	public StockSeeManagePanel(){}
	public StockSeeManagePanel(StockBLService stockbl, UserVO user, StockVO stockvo){
		super();
		this.stockbl = stockbl;
		this.user = user;
		this.stock = stockvo;
		init();
	}
	
	@Override
	public void setSearchPanel(){
		super.setSearchPanel();
		beginDate = ComponentFactory.createDatePicker();
		endDate = ComponentFactory.createDatePicker();

		searchBtn.setText("查看库存情况");
		searchBtn.setMaximumSize(new Dimension(250,
				UIConstant.SEARCHPANEL_HEIGHT));
		searchBtn.addMouseListener(new BtnListener());

		beginDate.setMaximumSize(new Dimension(300,
				UIConstant.SEARCHPANEL_HEIGHT));
		endDate.setMaximumSize(new Dimension(300, UIConstant.SEARCHPANEL_HEIGHT));

		searchPanel.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT, UIConstant.CONTENTPANEL_MARGIN_TOP);
		searchPanel.removeAll();
		searchPanel.add(beginDate);
		searchPanel.add(Box.createHorizontalStrut(10));
		searchPanel.add(endDate);
		searchPanel.add(Box.createHorizontalStrut(10));
		searchPanel.add(searchBtn);

		searchPanel.validate();
	}
	
	@Override
	public void setContentPanel(){
		super.setContentPanel();
		String[] s = {"出库数量","出库金额","入库数量","入库金额","库存数量合计"};
		int[] itemWidth = {100,100,100,100,100};
		listFirst = new StockSeeManageTableFirst(s, itemWidth);
		listFirst.addItem(new StockSeeVO(0, 0, 0, 0, 0, null));
		listFirst.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT,searchPanel.getLocation().y+searchPanel.getHeight()+15);
		container.add(listFirst);
		String[] s2 = {"快件单编号","存放位置"};
		int[] itemWidth2 = {200,200};
		listSecond = new StockSeeManageTableSecond(s2, itemWidth2);
		listSecond.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT,listFirst.getHeight()+listFirst.getLocation().y+15);
		container.add(listSecond);

		try {
			stocksee = stockbl.showStockInfo(stock.number, "1000-1-1", "3000-1-1");
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		listFirst.init();
		listFirst.addItem(stocksee);
		listSecond.init();
		for (int i = 0; i < stocksee.goods.size(); i++) {
			listSecond.addItem(stocksee.goods.get(i));
		}
	}
	

	class BtnListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
//			System.out.println("begin : " + beginDate.getDateString());
//			System.out.println("end : " + endDate.getDateString());
			try {
				stocksee = stockbl.showStockInfo(stock.number, beginDate.getDateString(), endDate.getDateString());
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			listFirst.init();
			listFirst.addItem(stocksee);
			listSecond.init();
			for (int i = 0; i < stocksee.goods.size(); i++) {
				listSecond.addItem(stocksee.goods.get(i));
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}

}
