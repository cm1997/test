package org.cross.elsclient.ui.stockkeeperui.check;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.Box;

import org.cross.elsclient.blservice.stockblservice.StockBLService;
import org.cross.elsclient.ui.component.ELSButton;
import org.cross.elsclient.ui.component.ELSComfirmDialog;
import org.cross.elsclient.ui.component.ELSDatePicker;
import org.cross.elsclient.ui.component.ELSManagePanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.counterui.analysis.AnalysisManagePanel;
import org.cross.elsclient.ui.util.ComponentFactory;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.util.ExportExcel;
import org.cross.elsclient.vo.StockCheckVO;
import org.cross.elsclient.vo.StockVO;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.util.ResultMessage;

public class StockCheckManagePanel extends ELSManagePanel{

	StockBLService stockbl;
	ArrayList<StockCheckVO> checkvos;
	StockVO stock;
	UserVO user;
	ELSButton outbtn;
	
	ELSDatePicker beginDate;
	ELSDatePicker endDate;
	
	StockCheckManageTable list;
	
	public StockCheckManagePanel(){}
	public StockCheckManagePanel(StockBLService stockbl, UserVO user, StockVO stockvo){
		super();
		this.stockbl = stockbl;
		this.user = user;
		this.stock = stockvo;
		this.checkvos = new ArrayList<StockCheckVO>();
		
		try {
			if(stockvo!=null) checkvos = stockbl.showStockCheck(stockvo.number);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		init();
	}
	

	@Override
	public void setContentPanel(){
		super.setContentPanel();
		String[] name = {"快件单编号","入库时间","目的地","所属小间"};
		int[] itemWidth = {200,200,100,200};
		list = new StockCheckManageTable(name, itemWidth);
		list.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT,UIConstant.CONTENTPANEL_MARGIN_TOP);
		for(StockCheckVO check : checkvos){
			list.addItem(check);
		}
		outbtn = ComponentFactory.createExportBtn();
		outbtn.addMouseListener(new BtnListener());
		list.header.add(Box.createHorizontalGlue());
		list.header.add(outbtn);
		list.header.add(Box.createHorizontalStrut(10));
		container.add(list);
		container.remove(searchPanel);
	}
	
	class BtnListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			if(ELSComfirmDialog.showConfirmDlg(GetPanelUtil.getFunctionPanel(StockCheckManagePanel.this), "导出报表", "是否导出库存盘点")){
				String name[] = {"快件单号","入库时间","目的地","所属小间"};
				ArrayList<String[]> datas = new ArrayList<>();
				for (StockCheckVO stockCheckVO : checkvos) {
					String data[] = {stockCheckVO.goodsNumber, stockCheckVO.inTime, stockCheckVO.targetCity , stockCheckVO.stockAreaNum};
					datas.add(data);
				}
				if(ExportExcel.exportExcel(name, datas, "库存盘点")==ResultMessage.SUCCESS){
					ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(StockCheckManagePanel.this), "导出库存盘点成功");
				}
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
