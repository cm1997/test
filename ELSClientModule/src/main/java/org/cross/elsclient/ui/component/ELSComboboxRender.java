package org.cross.elsclient.ui.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicBorders;

import org.cross.elsclient.ui.util.UIConstant;

public class ELSComboboxRender implements ListCellRenderer{
	DefaultListCellRenderer defauleRender = new DefaultListCellRenderer();

	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		JLabel render = (JLabel)defauleRender.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		render.setSize(render.getWidth(),40);
		render.setPreferredSize(render.getSize());
		render.setFont(UIConstant.MainFont.deriveFont(18f));
		render.setHorizontalAlignment(JLabel.LEFT);
		render.setBorder(new EmptyBorder(0, 10, 0, 0));
		if(isSelected){
			render.setBackground(UIConstant.MAINCOLOR);
			render.setForeground(Color.WHITE);
		}else{
			render.setForeground(UIConstant.MAINCOLOR);
			render.setBackground(Color.WHITE);
		}
		
		return render;
	}
	

}

