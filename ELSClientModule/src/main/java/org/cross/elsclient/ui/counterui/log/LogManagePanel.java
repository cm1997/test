package org.cross.elsclient.ui.counterui.log;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.sound.sampled.AudioFormat.Encoding;
import javax.swing.Box;

import org.cross.elsclient.blservice.logblservice.LogBLService;
import org.cross.elsclient.ui.adminui.UserAddPanel;
import org.cross.elsclient.ui.adminui.UserManageTable;
import org.cross.elsclient.ui.component.ELSDatePicker;
import org.cross.elsclient.ui.component.ELSComfirmDialog;
import org.cross.elsclient.ui.component.ELSManagePanel;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.counterui.analysis.AnalysisManagePanel;
import org.cross.elsclient.ui.util.ComponentFactory;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.vo.LogVO;
import org.cross.elsclient.vo.ReceiptVO;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.util.UserType;

public class LogManagePanel extends ELSManagePanel{
	LogBLService logbl;
	ArrayList<LogVO> logvos; 
	LogManageTable list;
	ELSDatePicker beginDate;
	ELSDatePicker endDate;
	
	public LogManagePanel(LogBLService logbl) {
		super();
		this.logbl = logbl;
		init();
	}
	
	@Override
	public void setContentPanel() {
		// TODO Auto-generated method stub
		super.setContentPanel();
		String[] s = {"操作时间","操作人员","操作内容"};
		int[] itemWidth = {200,150,200};
		list= new LogManageTable(s,itemWidth,logbl);
		list.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT,UIConstant.CONTENTPANEL_MARGIN_TOP*2+UIConstant.SEARCHPANEL_HEIGHT);
		container.add(list);
		show();
	}
	
	@Override
	public void setSearchPanel() {
		// TODO Auto-generated method stub
		super.setSearchPanel();
		beginDate = ComponentFactory.createDatePicker();
		endDate = ComponentFactory.createDatePicker();
		
		searchBtn.setText("查看系统日志");
		searchBtn.setMaximumSize(new Dimension(250, UIConstant.SEARCHPANEL_HEIGHT));
		searchBtn.addMouseListener(new BtnListener());
		
		beginDate.setMaximumSize(new Dimension(300, UIConstant.SEARCHPANEL_HEIGHT));
		endDate.setMaximumSize(new Dimension(300, UIConstant.SEARCHPANEL_HEIGHT));
		
		searchPanel.removeAll();
		searchPanel.add(beginDate);
		searchPanel.add(Box.createHorizontalStrut(10));
		searchPanel.add(endDate);
		searchPanel.add(Box.createHorizontalStrut(10));
		searchPanel.add(searchBtn);
		
		searchPanel.validate();
		
	}
	
	public void show(){
		list.init();
		try {
			logvos = logbl.show("0001-01-01", "3000-12-30");
			for (LogVO logVO : logvos) {
				list.addItem(logVO);
			}
			container.packHeight();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	class BtnListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			if(beginDate.getDate().compareTo(endDate.getDate())<1){
				logvos = new ArrayList<>();
				list.init();
				try {
//					System.out.println(beginDate.getDateString()+" 00:00"+endDate.getDateString()+" 23:59");
					logvos = logbl.show(beginDate.getDateString(), endDate.getDateString());
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (LogVO logVO : logvos) {
					list.addItem(logVO);
				}
				container.packHeight();
			}else{
				ELSComfirmDialog.showConfirmDlg(GetPanelUtil.getMainFrame(LogManagePanel.this), "时间矛盾", "起始时间大于结束时间");
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
