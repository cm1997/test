package org.cross.elsclient.ui.managerui.approval;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;

import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.ui.adminui.UserInfoPanel;
import org.cross.elsclient.ui.component.CheckBoxItemLabel;
import org.cross.elsclient.ui.component.ELSCheckBox;
import org.cross.elsclient.ui.component.ELSLabel;
import org.cross.elsclient.ui.component.ELSManageTable;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.component.ManageTableItemLabel;
import org.cross.elsclient.ui.component.TableItemLabel;
import org.cross.elsclient.ui.component.ELSManageTable.BtnListener;
import org.cross.elsclient.ui.component.ELSManageTable.ItemListener;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.vo.ReceiptVO;
import org.cross.elsclient.vo.UserVO;

public class ApprovalManageTable extends ELSManageTable {
	ReceiptBLService receiptbl;
	ArrayList<ReceiptVO> vos;
	CheckBoxItemLabel checkBoxHeader;

	public ApprovalManageTable(String name[],int itemWidth[],ReceiptBLService receiptbl) {
		super(name, itemWidth);
		this.receiptbl = receiptbl;
		init();
	}
	
	@Override
	public void init() {
		super.init();
		vos = new ArrayList<>();
		isUpdateAndDelete = false;
		
		checkBoxHeader = new CheckBoxItemLabel();
		checkBoxHeader.init(name,itemWidth,false);
		checkBoxHeader.setFont(font);
		checkBoxHeader.setBackground(UIConstant.MAINCOLOR_OPACITY_40);
		for (ELSLabel label : checkBoxHeader.labels) {
			label.setForeground(Color.WHITE);
		}
		checkBoxHeader.checkBox.addItemListener(new checkBoxListener());
		container.remove(header);
		container.add(checkBoxHeader,0);
		validate();
	}
	
	public void addItem(ReceiptVO vo){
		vos.add(vo);
		
		String[] item = {vo.number,vo.type.toString(),vo.time,vo.approveState.toString()};
		addItemLabel(item);
	}
	
	@Override
	public void addItemLabel(String[] item) {
		boolean check = false;
		for (String string : item) {
			if(string.equals("尚未审批")){
				check = true;
			}
		}
		if(check){
			CheckBoxItemLabel itemLabel = new CheckBoxItemLabel();
			itemLabel.init(item,itemWidth,isUpdateAndDelete);
			itemLabel.setFont(font);
			itemLabel.addMouseListener(new ItemListener(itemLabel));
			itemLabel.updateBtn.addMouseListener(new BtnListener(itemLabel));
			itemLabel.deleteBtn.addMouseListener(new BtnListener(itemLabel));
			
			itemLabels.add(itemLabel);
			container.add(itemLabel);
			packHeight();
			validate();
			repaint();
		}else{
			ManageTableItemLabel itemLabel = new ManageTableItemLabel(BoxLayout.X_AXIS);
			itemLabel.init(item,itemWidth,isUpdateAndDelete);
			itemLabel.setFont(font);
			itemLabel.addMouseListener(new ItemListener(itemLabel));
			itemLabel.updateBtn.addMouseListener(new BtnListener(itemLabel));
			itemLabel.deleteBtn.addMouseListener(new BtnListener(itemLabel));
			
			itemLabel.add(Box.createHorizontalStrut(50),0);
			itemLabels.add(itemLabel);
			container.add(itemLabel);
			packHeight();
			validate();
			repaint();
			
		}
	}
	
	@Override
	public void infoBtn(int index) {
		super.infoBtn(index);
		ELSPanel contentPanel  = GetPanelUtil.getSubFunctionPanel(this, "receiptApproval");
		ReceiptVO vo = vos.get(index);
		contentPanel.add("info",new ApprovalInfoPanel(vo,receiptbl));
		contentPanel.cl.show(contentPanel, "info");
	}
	
	class checkBoxListener implements java.awt.event.ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			ELSCheckBox box = (ELSCheckBox)e.getItem();
			CheckBoxItemLabel label;
			if(box.isSelected()){
				for (TableItemLabel tableItemLabel : itemLabels) {
					if(tableItemLabel instanceof CheckBoxItemLabel){
						label = (CheckBoxItemLabel)tableItemLabel;
						label.checkBox.setSelected(true);
					}
				}
			}else {
				for (TableItemLabel tableItemLabel : itemLabels) {
					if(tableItemLabel instanceof CheckBoxItemLabel){
						label = (CheckBoxItemLabel)tableItemLabel;
						label.checkBox.setSelected(false);
					}
				}
			}
		}
		
	}
}
