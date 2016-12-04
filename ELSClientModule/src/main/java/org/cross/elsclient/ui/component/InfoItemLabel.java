package org.cross.elsclient.ui.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.cross.elsclient.blimpl.initialblimpl.InitialBLImpl;
import org.cross.elsclient.ui.util.Images;
import org.cross.elsclient.ui.util.InfoFormatUtil;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elscommon.util.InfoType;

public class InfoItemLabel extends ELSLabel{
	public ELSLabel nameLabel;
	public ELSTextField inputLabel;
	public ELSComboBox comboBox;
	public ELSLabel textLabel;
	public ELSLabel iconLabel;
	public boolean isLegal;
	public int type;
	public InfoType infoType;
	public ELSDatePicker datePicker;
	public ELSButton autoBtn;
	public int nameItemWidth;
	public int textItemWidth;
	public int boxItemWidth;
	public int dateItemWidth;
	public int gap;
	public Color textColor;
	
	public InfoItemLabel() {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setMaximumSize(new Dimension(UIConstant.CONTENTPANEL_WIDTH, UIConstant.MANAGETABLE_ITEM_HEIGHT));
		this.setMinimumSize(new Dimension(UIConstant.CONTENTPANEL_WIDTH, UIConstant.MANAGETABLE_ITEM_HEIGHT));
		this.isLegal = true;
		nameItemWidth = 130;
		textItemWidth = 300;
		boxItemWidth = 200;
		dateItemWidth = 200;
		gap = 25;
		textColor = Color.white;
	}
	
	public void initNormal(String name, String content){
		type = 1;
		nameLabel = new ELSLabel(name);
		ELSLabel contentLabel = new ELSLabel(content);
		
		nameLabel.setPreferredSize(new Dimension(nameItemWidth, UIConstant.MANAGETABLE_ITEM_HEIGHT));
		nameLabel.setMaximumSize(new Dimension(nameItemWidth, UIConstant.MANAGETABLE_ITEM_HEIGHT));
		nameLabel.setVerticalAlignment(JLabel.CENTER);
		nameLabel.setHorizontalAlignment(JLabel.RIGHT);
		nameLabel.setFont(nameLabel.getFont().deriveFont(18f));
		nameLabel.setForeground(textColor);

		contentLabel.setPreferredSize(new Dimension(textItemWidth, UIConstant.MANAGETABLE_ITEM_HEIGHT));
		contentLabel.setMaximumSize(new Dimension(textItemWidth, UIConstant.MANAGETABLE_ITEM_HEIGHT));
		contentLabel.setVerticalAlignment(JLabel.CENTER);
		contentLabel.setHorizontalAlignment(JLabel.LEFT);
		contentLabel.setFont(getFont().deriveFont(18f));
		contentLabel.setForeground(textColor);

//		this.add(Box.createHorizontalStrut(30));
		this.add(nameLabel);
		this.add(Box.createHorizontalStrut(gap));
		this.add(contentLabel);
	}
	
	public void initEditable(String name, String defaultValue,
			boolean isEditable){
		type = 2;
		
		nameLabel = new ELSLabel(name);
		inputLabel = new ELSTextField(defaultValue);
		inputLabel.setEditable(isEditable);

		nameLabel.setPreferredSize(new Dimension(nameItemWidth, UIConstant.MANAGETABLE_ITEM_HEIGHT));
		nameLabel.setMaximumSize(new Dimension(nameItemWidth, UIConstant.MANAGETABLE_ITEM_HEIGHT));
		nameLabel.setVerticalAlignment(JLabel.CENTER);
		nameLabel.setHorizontalAlignment(JLabel.RIGHT);
		nameLabel.setFont(nameLabel.getFont().deriveFont(18f));
		nameLabel.setForeground(textColor);

		inputLabel.setPreferredSize(new Dimension(textItemWidth, UIConstant.MANAGETABLE_ITEM_HEIGHT - 15));
		inputLabel.setMaximumSize(new Dimension(textItemWidth, UIConstant.MANAGETABLE_ITEM_HEIGHT - 15));
		inputLabel.setHorizontalAlignment(JTextField.LEFT);
		inputLabel.setFont(getFont().deriveFont(18f));
//		this.add(Box.createHorizontalStrut(30));
		this.add(nameLabel);
		this.add(Box.createHorizontalStrut(gap));
		this.add(inputLabel);
	}
	
	public void initEditable(String name, String defaultValue,
			boolean isEditable, InfoType type){
		initEditable(name, defaultValue, isEditable);
		
		infoType = type;
		iconLabel = new ELSLabel();
		textLabel = new ELSLabel();
		
		iconLabel.setMaximumSize(new Dimension(UIConstant.MANAGETABLE_ITEM_HEIGHT, UIConstant.MANAGETABLE_ITEM_HEIGHT));
		iconLabel.setMinimumSize(new Dimension(UIConstant.MANAGETABLE_ITEM_HEIGHT, UIConstant.MANAGETABLE_ITEM_HEIGHT));

		// textLabel.setMaximumSize(new Dimension(itemHeight*6, itemHeight));
		textLabel.setMinimumSize(new Dimension(getHeight() * 3, UIConstant.MANAGETABLE_ITEM_HEIGHT));
		textLabel.setHorizontalAlignment(JLabel.LEFT);
		textLabel.setVerticalAlignment(JLabel.CENTER);
		textLabel.setFont(getFont().deriveFont(15f));
		textLabel.setForeground(Color.orange);

		isLegal = checkFormat();
		
		inputLabel.addFocusListener(new TextFormatListener(inputLabel, iconLabel, textLabel, type));
		this.add(iconLabel);
		this.add(textLabel);
	}
	
	public void initBox(String name, String[] items, boolean isEditable){
		type = 4;
		
		nameLabel = new ELSLabel(name);
		comboBox = new ELSComboBox();
		comboBox.setEnabled(isEditable);

		nameLabel.setPreferredSize(new Dimension(nameItemWidth, UIConstant.MANAGETABLE_ITEM_HEIGHT));
		nameLabel.setMaximumSize(new Dimension(nameItemWidth, UIConstant.MANAGETABLE_ITEM_HEIGHT));
		nameLabel.setVerticalAlignment(JLabel.CENTER);
		nameLabel.setHorizontalAlignment(JLabel.RIGHT);
		nameLabel.setFont(nameLabel.getFont().deriveFont(18f));
		nameLabel.setForeground(textColor);

		comboBox.setModel(new DefaultComboBoxModel<>(items));
		comboBox.setPreferredSize(new Dimension(boxItemWidth, UIConstant.MANAGETABLE_ITEM_HEIGHT - 15));
		comboBox.setMaximumSize(new Dimension(boxItemWidth, UIConstant.MANAGETABLE_ITEM_HEIGHT - 15));
		comboBox.setFont(getFont().deriveFont(18f));

//		this.add(Box.createHorizontalStrut(30));
		this.add(nameLabel);
		this.add(Box.createHorizontalStrut(gap));
		this.add(comboBox);
	}
	
	public void initBox(String name, String[] items,String defaultValue, boolean isEditable){
		initBox(name, items, isEditable);
		for (String string : items) {
			if(string.equals(defaultValue)){
				comboBox.setSelectedItem(string);
			}
		}
	}
	
	public void initDatePicker(String name, boolean isEditable){
		type = 5;
		
		nameLabel = new ELSLabel(name);
		datePicker = new ELSDatePicker();
		datePicker.setEnabled(isEditable);

		nameLabel.setPreferredSize(new Dimension(nameItemWidth, UIConstant.MANAGETABLE_ITEM_HEIGHT));
		nameLabel.setMaximumSize(new Dimension(nameItemWidth, UIConstant.MANAGETABLE_ITEM_HEIGHT));
		nameLabel.setVerticalAlignment(JLabel.CENTER);
		nameLabel.setHorizontalAlignment(JLabel.RIGHT);
		nameLabel.setFont(nameLabel.getFont().deriveFont(18f));
		nameLabel.setForeground(textColor);

		datePicker.setPreferredSize(new Dimension(dateItemWidth, UIConstant.MANAGETABLE_ITEM_HEIGHT - 15));
		datePicker.setMaximumSize(new Dimension(dateItemWidth, UIConstant.MANAGETABLE_ITEM_HEIGHT - 15));
		datePicker.setFont(getFont().deriveFont(18f));

//		this.add(Box.createHorizontalStrut(30));
		this.add(nameLabel);
		this.add(Box.createHorizontalStrut(gap));
		this.add(datePicker);
	}
	
	public void initAuto(String name, String defaultValue,
			boolean isEditable,InfoType type){
		initEditable(name, defaultValue, isEditable,type);
	}
	
	@Override
	public String toString() {
		switch (type) {
		case 2:
		case 3:
			return inputLabel.getText();
		case 4:
			return (String)comboBox.getSelectedItem();
		case 5:
			return datePicker.getDateString();
		default:
			break;
		}
		return null;
	}
	
	class TextFormatListener implements FocusListener {
		ELSTextField inputLabel;
		ELSLabel iconLabel;
		ELSLabel textLabel;
		InfoType type;

		public TextFormatListener(ELSTextField inputLabel, ELSLabel iconLabel,
				ELSLabel textLabel, InfoType type) {
			super();
			this.inputLabel = inputLabel;
			this.iconLabel = iconLabel;
			this.textLabel = textLabel;
			this.type = type;
		}

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			String src = inputLabel.getText();
			String result = InfoFormatUtil.CheckFormat(src, type);
			check();
		}

	}
	
	public boolean checkFormat(){
		if(infoType==null){
			return true;
		}
		
		String result = InfoFormatUtil.CheckFormat(toString(), infoType);
		if(result==null){
			isLegal = true;
			return true;
		}else{
			isLegal = false;
			return false;
		}
		
	}
	
	public boolean check(){
		if(infoType==null){
			return true;
		}
		if(checkFormat()){
			iconLabel.setIcon(Images.CORRECT_IMAGEICON);
			textLabel.setText("");
			return true;
		}else{
			iconLabel.setIcon(Images.WARNING_IMAGEICON);
			textLabel.setText(InfoFormatUtil.CheckFormat(toString(),infoType));
			return false;
		}
	}

}
