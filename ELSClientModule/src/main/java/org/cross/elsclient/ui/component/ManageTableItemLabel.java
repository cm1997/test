package org.cross.elsclient.ui.component;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JLabel;

import org.cross.elsclient.ui.component.ELSManageTable.BtnListener;
import org.cross.elsclient.ui.component.ELSManageTable.ItemListener;
import org.cross.elsclient.ui.util.ComponentFactory;
import org.cross.elsclient.ui.util.UIConstant;

public class ManageTableItemLabel extends TableItemLabel{
	String item[];
	public ArrayList<ELSLabel> labels;
	public ELSButton updateBtn;
	public ELSButton deleteBtn;

	public ManageTableItemLabel(){
		super();
	}
	
	public ManageTableItemLabel(int axis) {
		super(axis);
		// TODO Auto-generated constructor stub
	}
	
	public void init(String []item,int []itemWidth,boolean isUpdateAndDelete){
		init();
		
		this.item = item;
		labels = new ArrayList<>();
		ELSLabel tempLabel = new ELSLabel();
		updateBtn = ComponentFactory.createUpdateBtn();
		deleteBtn = ComponentFactory.createDeleteBtn();
		
		for (int i = 0; i < item.length; i++) {
			tempLabel = new ELSLabel(" " + item[i]);
			tempLabel.setFont(UIConstant.MainFont.deriveFont(18f));
			tempLabel.setForeground(Color.WHITE);
			tempLabel.setPreferredSize(new Dimension(itemWidth[i],UIConstant.MANAGETABLE_ITEM_HEIGHT));
			tempLabel.setMaximumSize(new Dimension(itemWidth[i],UIConstant.MANAGETABLE_ITEM_HEIGHT));
			tempLabel.setMinimumSize(new Dimension(itemWidth[i],UIConstant.MANAGETABLE_ITEM_HEIGHT));
			tempLabel.setVerticalAlignment(JLabel.CENTER);
			tempLabel.setHorizontalAlignment(JLabel.LEFT);
			labels.add(tempLabel);
			this.add(tempLabel);
		}
		
		if(isUpdateAndDelete){
			updateBtn = ComponentFactory.createUpdateBtn();
			deleteBtn = ComponentFactory.createDeleteBtn();
			
			updateBtn.setVisible(false);
			
			deleteBtn.setVisible(false);
			
			this.add(Box.createHorizontalGlue());
			this.add(updateBtn);
			this.add(Box.createHorizontalStrut(20));
			this.add(deleteBtn);
			this.add(Box.createHorizontalStrut(20));
			this.validate();
			repaint();
			
		}
	}
	
}
