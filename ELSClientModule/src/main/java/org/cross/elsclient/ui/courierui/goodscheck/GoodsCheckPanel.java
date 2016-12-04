package org.cross.elsclient.ui.courierui.goodscheck;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;

import org.cross.elsclient.blservice.goodsblservice.GoodsBLService;
import org.cross.elsclient.ui.adminui.UserManageTable;
import org.cross.elsclient.ui.component.ELSManagePanel;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.vo.GoodsVO;
import org.cross.elsclient.vo.HistoryVO;

public class GoodsCheckPanel extends ELSManagePanel{
	GoodsBLService goodsbl;
	ArrayList<HistoryVO> historyVOs;
	GoodsCheckTable list;
	
	public GoodsCheckPanel(GoodsBLService goodsbl) {
		this.goodsbl = goodsbl;
		init();
	}
	
	@Override
	public void setContentPanel() {
		super.setContentPanel();
		
//		String[] s = {"出发地","出发时间","到达地","到达时间"};
//		int[] itemWidth = {100,200,100,200};
		String[] s = {"地点","时间","轨迹类型"};
		int[] itemWidth = {200,200,200};
		list= new GoodsCheckTable(s, itemWidth);
		list.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT,UIConstant.CONTENTPANEL_MARGIN_TOP*2+UIConstant.SEARCHPANEL_HEIGHT);
		container.add(list);
	}
	
	@Override
	public void setSearchPanel() {
		searchPanel.remove(modeBox);
		searchPanel.remove(0);
		
		searchBtn.setText("查询订单状态");
		searchBtn.addMouseListener(new BtnListener());
		
		searchPanel.validate();
	}
	
	class BtnListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			try {
				historyVOs = new ArrayList<>();
				historyVOs.addAll(goodsbl.findGoods(searchTextField.getText()));
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			list.init();
			if(!historyVOs.isEmpty()){
				Collections.sort(historyVOs, new Comparator<HistoryVO>() {

					@Override
					public int compare(HistoryVO o1, HistoryVO o2) {
						SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm" );
						Date date1;
						Date date2;
						if(o1.time==null){
							return 1;
						}else if(o2.time==null){
							return -1;
						}
						
						try {
							date1 = sdf.parse(o1.time);
							date2 = sdf.parse(o2.time);
							return date1.compareTo(date2);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return 0;
					}
				});
//				for(int i = 0;i<historyVOs.size();i=i+2){
//					if(i+1==historyVOs.size()){
//						list.addItem(historyVOs.get(i), null);
//					}else{
//						list.addItem(historyVOs.get(i), historyVOs.get(i+1));
//					}
//				}
				for(int i = 0;i<historyVOs.size();i++){
					list.addItem(historyVOs.get(i));
				}
				container.packHeight();
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
