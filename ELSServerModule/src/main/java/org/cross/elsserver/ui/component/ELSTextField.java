package org.cross.elsserver.ui.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.cross.elsserver.ui.util.UIConstant;


public class ELSTextField extends JTextField{
	public ELSTextField() {
		super();
		init();
	}
	
	public ELSTextField(String defaultValue){
		super(defaultValue);
		init();
	}
	
	public void init(){
		setFont(getFont().deriveFont(20f));
		setForeground(UIConstant.MAINCOLOR);
		setBorder(new ELSEmptyBorder(new Insets(0, 10, 0, 10),UIConstant.MAINCOLOR));
		
	}
}
