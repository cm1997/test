package org.cross.elsclient.ui.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.cross.elsclient.ui.util.Images;
import org.cross.elsclient.ui.util.UIConstant;

public class FunctionBtn extends ELSButton {
	Color archiveColor;
	Color archiveFont;
	public boolean isArchive;
	ELSLabel text;
	ELSLabel icon;
	ELSLabel arrow;
	ImageIcon normalIcon;
	ImageIcon archiveIcon;
	ImageIcon arrowIcon;
	ImageIcon arrowArchiveIcon;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		isArchive = false;
		backColor = UIConstant.MAINCOLOR;
		archiveColor = Color.white;
		archiveFont = UIConstant.MAINCOLOR;
		setBackground(backColor);
		setForeground(Color.white);
		setOpaque(false);
		setFont(getFont().deriveFont(20f));
		setFont(getFont().deriveFont(Font.PLAIN));
		
		icon = new ELSLabel();
		text = new ELSLabel();
		arrow = new ELSLabel();
		arrowIcon = Images.RIGHT_IMAGEICON;
		arrowArchiveIcon = Images.RIGHT_ACTIVE_IMAGEICON;
		
		this.setLayout(null);
		icon.setBounds(18, 18, 20, 20);
		icon.setVerticalAlignment(JLabel.CENTER);
		text.setBounds(42, 18, 80, 20);
		text.setFont(getFont());
		text.setVerticalAlignment(JLabel.CENTER);
		text.setHorizontalAlignment(JLabel.LEFT);
		text.setForeground(Color.white);
		
		arrow.setBounds(142, 18, 20, 20);
		arrow.setVerticalAlignment(JLabel.CENTER);
		arrow.setIcon(Images.RIGHT_IMAGEICON);
		
		this.add(arrow);
		this.add(icon);
		this.add(text);
	}
	
	public void setBtnText(String text){
		this.text.setText(text);
	}
	
	public void setIcon() {
		normalIcon = Images.getImageIcon(this.getName());
		archiveIcon = Images.getActiveIcon(this.getName());
		icon.setIcon(normalIcon);
	}
	
	
	public void setArchive(boolean isArchive){
		this.isArchive = isArchive;
		if(isArchive){
//			setOpaque(true);
//			setBackground(archiveColor);
			text.setForeground(archiveFont);
			icon.setIcon(archiveIcon);
			arrow.setIcon(arrowArchiveIcon);
			if(getParent()!=null){
				((ELSFunctionPanel)getParent()).repaint();
				((ELSFunctionPanel)getParent()).mask2.repaint();
			}
		}else{
//			setOpaque(false);
//			setBackground(backColor);
			text.setForeground(Color.white);
			icon.setIcon(normalIcon);
			arrow.setIcon(arrowIcon);
			if(getParent()!=null){
				((ELSFunctionPanel)getParent()).repaint();
				((ELSFunctionPanel)getParent()).mask2.repaint();
			}
		}
	}
	@Override
	public void press() {
	}
	
	@Override
	public void release() {
	}
	
	@Override
	public void setName(String name) {
		super.setName(name);
		setIcon();
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		if(isArchive){
			Graphics2D g2d = (Graphics2D)g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.setColor(Color.WHITE);
			int[] xPoints = {168, 168, 180};
			int[] yPoints = {0, 54, 27};
			g2d.fillPolygon(xPoints, yPoints, 3);
			g2d.fillRect(0, 0, 168, 54);
		}
		super.paint(g);
	}
}
