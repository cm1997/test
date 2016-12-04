package org.cross.elsclient.ui.component;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.Icon;
import javax.swing.JLabel;

import org.cross.elsclient.ui.util.UIConstant;

public class ELSLabel extends JLabel{

	public ELSLabel() {
		super();
		init();
	}

	public ELSLabel(Icon image, int horizontalAlignment) {
		super(image, horizontalAlignment);
		init();	
		}

	public ELSLabel(Icon image) {
		super(image);
		init();
		}

	public ELSLabel(String text, Icon icon, int horizontalAlignment) {
		super(text, icon, horizontalAlignment);
		init();
	}

	public ELSLabel(String text, int horizontalAlignment) {
		super(text, horizontalAlignment);
		init();
	}

	public ELSLabel(String text) {
		super(text);
		init();
	}
	
	void init(){
		setVerticalAlignment(JLabel.CENTER);
		setHorizontalAlignment(JLabel.CENTER);
		setForeground(UIConstant.MAINCOLOR);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}
}
