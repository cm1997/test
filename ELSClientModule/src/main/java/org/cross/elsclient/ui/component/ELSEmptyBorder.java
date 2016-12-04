package org.cross.elsclient.ui.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.EmptyBorder;

public class ELSEmptyBorder extends EmptyBorder {
	Color color;

	public ELSEmptyBorder(Insets borderInsets,Color color) {
		super(borderInsets);
		this.color = color;
	}
	
	
	public ELSEmptyBorder(int top, int left, int bottom, int right,Color color) {
		super(top, left, bottom, right);
		this.color = color;
	}


	@Override
	public void paintBorder(Component c, Graphics g, int x, int y,
			int width, int height) {
		g.setColor(color);
		g.drawRect(x, y, width-1, height-1);
	}
	
}
