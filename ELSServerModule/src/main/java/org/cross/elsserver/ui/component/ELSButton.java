package org.cross.elsserver.ui.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class ELSButton extends JLabel {
	Color backColor = Color.GRAY;
	Color pressColor = Color.DARK_GRAY;
	ImageIcon icon;
	
	public ELSButton() {
		super();
		init();
	}
	
	public ELSButton(String string){
		super(string);
		init();
	}
	
	public void init(){
		setOpaque(true);
		setBackground(Color.gray);
		setForeground(Color.WHITE);
		setFont(getFont().deriveFont(20f));
		setVerticalAlignment(JLabel.CENTER);
		setHorizontalAlignment(JLabel.CENTER);
//		setFocusable(false);
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				release();
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				press();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				requestFocus();
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				click();
			}
		});
	}
	
	public void setColor(Color bg){
		setBackground(bg);
		backColor = bg;
		pressColor = bg.darker();
	}
	
	public void click(){
		setBackground(backColor);
	}
	
	public void press(){
		setSize(getWidth()-6, getHeight()-6);
		setLocation(getX()+3, getY()+3);
		for (Component c : getComponents()) {
			c.setLocation(c.getX()-3, c.getY()-3);
		}
		setPreferredSize(new Dimension(getPreferredSize().width-6, getPreferredSize().height-6));
		getRootPane().repaint();
		setBackground(pressColor);
	}
	
	public void release(){
		setSize(getWidth()+6, getHeight()+6);
		setLocation(getX()-3, getY()-3);
		for (Component c : getComponents()) {
			c.setLocation(c.getX()+3, c.getY()+3);
		}
		setPreferredSize(new Dimension(getPreferredSize().width+6, getPreferredSize().height+6));
		getRootPane().repaint();
		setBackground(backColor);
	}

}
