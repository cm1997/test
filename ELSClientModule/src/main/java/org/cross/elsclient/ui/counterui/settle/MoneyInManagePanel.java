package org.cross.elsclient.ui.counterui.settle;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;

import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.ui.component.CheckBoxItemLabel;
import org.cross.elsclient.ui.component.ELSButton;
import org.cross.elsclient.ui.component.ELSDatePicker;
import org.cross.elsclient.ui.component.ELSComfirmDialog;
import org.cross.elsclient.ui.component.ELSManagePanel;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.component.TableItemLabel;
import org.cross.elsclient.ui.counterui.cost.MoneyOutAddPanel;
import org.cross.elsclient.ui.util.ComponentFactory;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.vo.ReceiptVO;
import org.cross.elsclient.vo.Receipt_MoneyInVO;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.UserType;

public class MoneyInManagePanel extends ELSManagePanel {
	ReceiptBLService receiptbl;
	ArrayList<ReceiptVO> moneyInVOs;
	MoneyInManageTable list;
	ELSButton addBtn;
	ELSDatePicker beginDate;
	ELSDatePicker endDate;

	public MoneyInManagePanel() {
	}

	public MoneyInManagePanel(ReceiptBLService receiptbl) {
		super();
		this.receiptbl = receiptbl;
		init();
	}

	@Override
	public void setContentPanel() {
		super.setContentPanel();

		String[] name = { "单据编号", "收款时间", "金额" };
		int[] itemWidth = { 150, 200, 100 };
		list = new MoneyInManageTable(name, itemWidth, receiptbl);
		list.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT,
				UIConstant.CONTENTPANEL_MARGIN_TOP * 2
						+ UIConstant.SEARCHPANEL_HEIGHT);
		
		container.add(list);
		showAll();
	}

	@Override
	public void setSearchPanel() {
		// TODO Auto-generated method stub
		super.setSearchPanel();
		addBtn = ComponentFactory.createSearchBtn();
		beginDate = ComponentFactory.createDatePicker();
		endDate = ComponentFactory.createDatePicker();

		String[] s = { "按单据编号查找", "按营业厅查找", "按时间查找" };
		modeBox.setModel(new DefaultComboBoxModel<String>(s));
		modeBox.addItemListener(new ModeBoxItemListener());

		searchBtn.setText("查找单据");
		searchBtn.addMouseListener(new BtnListener());

		addBtn.setText("合计单据");
		addBtn.addMouseListener(new BtnListener());

		searchPanel.add(Box.createHorizontalStrut(10));
		searchPanel.add(addBtn);
		beginDate.setVisible(false);
		endDate.setVisible(false);

		searchPanel.add(endDate, 3);
		searchPanel.add(Box.createHorizontalStrut(5), 3);
		searchPanel.add(beginDate, 3);
		searchPanel.validate();
	}
	
	public void showAll(){
		list.init();
		moneyInVOs = new ArrayList<>();
		// 需修改
		 try {
			ArrayList<ReceiptVO> receiptVOs = receiptbl.show();
			for (ReceiptVO receiptVO : receiptVOs) {
				if(receiptVO!=null){
					if(receiptVO instanceof Receipt_MoneyInVO){
						moneyInVOs.add(receiptVO); 
					}
				}
			}
		} catch (RemoteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		for (ReceiptVO receipt : moneyInVOs) {
			Receipt_MoneyInVO receipt_MoneyInVO = (Receipt_MoneyInVO) receipt;
			String[] item = { "" + receipt.number,
					receipt.time,
					receipt_MoneyInVO.money+"" };
			list.addItemLabel(item);
		}
		container.packHeight();
	}

	class BtnListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

			if (e.getSource() == searchBtn) {
				if (((String) modeBox.getSelectedItem()).equals("按单据编号查找")) {
					String id = searchTextField.getText();
					list.init();
					moneyInVOs = new ArrayList<>();
					// 需修改
					 try {
						ReceiptVO receiptVO = receiptbl.findByID(searchTextField.getText());
						if(receiptVO!=null){
							if(receiptVO instanceof Receipt_MoneyInVO){
								moneyInVOs.add(receiptbl.findByID(searchTextField.getText()));
							}
						}
					} catch (RemoteException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					for (ReceiptVO receipt : moneyInVOs) {
						Receipt_MoneyInVO receipt_MoneyInVO = (Receipt_MoneyInVO) receipt;
						String[] item = { "" + receipt.number,
								receipt.time,
								receipt_MoneyInVO.money+"" };
						list.addItemLabel(item);
					}
					list.validate();
					
					container.packHeight();
				} else if (((String) modeBox.getSelectedItem()).equals("按时间查找")) {
					moneyInVOs = new ArrayList<>();
					try {
						moneyInVOs = receiptbl.findByTimeAndType(beginDate.getDateString(), endDate.getDateString(), ReceiptType.MONEYIN);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					list.init();
					for (ReceiptVO receipt : moneyInVOs) {
						Receipt_MoneyInVO receipt_MoneyInVO = (Receipt_MoneyInVO) receipt;
						String[] item = { "" + receipt.number,
								receipt.time,
								receipt_MoneyInVO.money+"" };
						list.addItemLabel(item);
					}
					list.validate();
					container.packHeight();

				} else if (((String) modeBox.getSelectedItem())
						.equals("按营业厅查找")) {
					String orgNum = searchTextField.getText();
					moneyInVOs = new ArrayList<>();
					try {
						ArrayList<ReceiptVO> tempvos = receiptbl.findByOrgan(orgNum);
						for (ReceiptVO receiptVO : tempvos) {
							if(receiptVO instanceof Receipt_MoneyInVO){
								moneyInVOs.add(receiptVO);
							}
						}
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					list.init();
					for (ReceiptVO receipt : moneyInVOs) {
						Receipt_MoneyInVO receipt_MoneyInVO = (Receipt_MoneyInVO) receipt;
						String[] item = { "" + receipt.number,
								receipt.time,
								receipt_MoneyInVO.money+"" };
						list.addItemLabel(item);
					}
					list.validate();
					container.packHeight();
				}
			}
			if (e.getSource() == addBtn) {
				ArrayList<Receipt_MoneyInVO> vos = new ArrayList<>();
				CheckBoxItemLabel checkLabel;
				for (TableItemLabel itemLabel : list.itemLabels) {
					checkLabel = (CheckBoxItemLabel) itemLabel;
					if (checkLabel.checkBox.isSelected()) {
						vos.add((Receipt_MoneyInVO) moneyInVOs
								.get(list.itemLabels.indexOf(itemLabel)));
					}
				}
				if (!vos.isEmpty()) {
					TotalAddPanel addPanel = new TotalAddPanel(receiptbl, vos);
					ELSPanel parent = (ELSPanel) MoneyInManagePanel.this
							.getParent();
					parent.add("add", addPanel);
					parent.cl.show(parent, "add");
				} else {
					ELSComfirmDialog.showConfirmDlg(GetPanelUtil
							.getFunctionPanel(MoneyInManagePanel.this), "创建失败",
							"请选择任意单据");
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

	/**
	 * 搜索模式的监听类
	 * 
	 * @author Moo
	 * @date 2015年11月26日
	 */
	class ModeBoxItemListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				String item = (String) modeBox.getSelectedItem();
				switch (item) {
				case "按单据编号查找":
					searchTextField.setVisible(true);
					beginDate.setVisible(false);
					endDate.setVisible(false);
					break;
				case "按时间查找":
					searchTextField.setVisible(false);
					beginDate.setVisible(true);
					endDate.setVisible(true);
					break;
				case "按营业厅查找":
					searchTextField.setVisible(true);
					beginDate.setVisible(false);
					endDate.setVisible(false);
					break;
				default:
					searchTextField.setVisible(false);
					break;
				}
			}
		}

	}
}
