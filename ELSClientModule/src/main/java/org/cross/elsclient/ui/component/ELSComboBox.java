package org.cross.elsclient.ui.component;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

import org.cross.elsclient.ui.util.UIConstant;

public class ELSComboBox extends JComboBox{
	public ELSComboBox() {
		setFocusable(false);
		init();
	}
	
	public void init(){
		setUI(new ELSComboxUI());
		setRenderer(new ELSComboboxRender());
		setBorder(new LineBorder(UIConstant.MAINCOLOR));
		setFont(UIConstant.MainFont.deriveFont(18f));
		setBackground(Color.white);
		setForeground(UIConstant.MAINCOLOR);
	}
	
	
}
