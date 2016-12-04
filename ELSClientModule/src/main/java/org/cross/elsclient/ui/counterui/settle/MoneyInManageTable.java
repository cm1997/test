package org.cross.elsclient.ui.counterui.settle;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;

import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.ui.component.CheckBoxItemLabel;
import org.cross.elsclient.ui.component.ELSCheckBox;
import org.cross.elsclient.ui.component.ELSLabel;
import org.cross.elsclient.ui.component.ELSManageTable;
import org.cross.elsclient.ui.component.InfoItemLabel;
import org.cross.elsclient.ui.component.ManageTableItemLabel;
import org.cross.elsclient.ui.component.ELSManageTable.BtnListener;
import org.cross.elsclient.ui.component.ELSManageTable.ItemListener;
import org.cross.elsclient.ui.component.TableItemLabel;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.vo.Receipt_MoneyInVO;

public class MoneyInManageTable extends ELSManageTable {
	ReceiptBLService receiptbl;
	ArrayList<Receipt_MoneyInVO> vos;
	CheckBoxItemLabel checkBoxHeader;
	
	public MoneyInManageTable(String []name,int []itemWidth,ReceiptBLService receiptbl){
		super(name, itemWidth);
		this.receiptbl = receiptbl;
		init();
	}
	
	public void init(){
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
	
	@Override
	public void addItemLabel(String[] item) {
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
	}
	
	public void addItem(Receipt_MoneyInVO vo){
		vos.add(vo);
		String []item = {vo.number,vo.time,String.valueOf(vo.money)};
		addItemLabel(item);
	}
	
	class checkBoxListener implements java.awt.event.ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			ELSCheckBox box = (ELSCheckBox)e.getItem();
			CheckBoxItemLabel label;
			if(box.isSelected()){
				for (TableItemLabel tableItemLabel : itemLabels) {
					label = (CheckBoxItemLabel)tableItemLabel;
					label.checkBox.setSelected(true);
				}
			}else {
				for (TableItemLabel tableItemLabel : itemLabels) {
					label = (CheckBoxItemLabel)tableItemLabel;
					label.checkBox.setSelected(false);
				}
			}
		}
		
	}
}
