package org.cross.elsclient.ui.component;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JLabel;

import org.cross.elsclient.ui.util.ComponentFactory;
import org.cross.elsclient.ui.util.UIConstant;

public class EditTableItemLabel extends TableItemLabel{
	public ArrayList<ELSTextField> labels;
	
	public void init(String []item,int []itemWidth){
		init();
		
		labels = new ArrayList<>();
		ELSTextField tempLabel = new ELSTextField();
		
		for (int i = 0; i < item.length; i++) {
			tempLabel = new ELSTextField("" + item[i]);
			tempLabel.setFont(tempLabel.getFont().deriveFont(18f));
			tempLabel.setPreferredSize(new Dimension(itemWidth[i]-10,UIConstant.MANAGETABLE_ITEM_HEIGHT));
			tempLabel.setMaximumSize(new Dimension(itemWidth[i]-10,UIConstant.MANAGETABLE_ITEM_HEIGHT));
			tempLabel.setMinimumSize(new Dimension(itemWidth[i]-10,UIConstant.MANAGETABLE_ITEM_HEIGHT));
			tempLabel.setHorizontalAlignment(JLabel.LEFT);
			labels.add(tempLabel);
			this.add(tempLabel);
			this.add(Box.createHorizontalStrut(10));
		}
	}
}
