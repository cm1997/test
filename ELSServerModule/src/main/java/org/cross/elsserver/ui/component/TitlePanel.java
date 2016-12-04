package org.cross.elsserver.ui.component;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.cross.elsserver.ui.util.ComponentFactory;
import org.cross.elsserver.ui.util.UIConstant;


public class TitlePanel extends ELSBox{
	String title;
	public ELSButton backBtn;
	public ELSLabel titleLabel;

	public TitlePanel() {
		super(BoxLayout.X_AXIS);
	}
	
	public TitlePanel(String title){
		super(BoxLayout.X_AXIS);
		init(title);
	}
	
	public void init(String title){
		this.setSize(UIConstant.CONTENTPANEL_WIDTH, 50);
		this.setPreferredSize(new Dimension(UIConstant.CONTENTPANEL_WIDTH, 50));
		this.setMaximumSize(new Dimension(UIConstant.CONTENTPANEL_WIDTH, 50));
		this.setMinimumSize(new Dimension(UIConstant.CONTENTPANEL_WIDTH, 50));
		this.setSize(UIConstant.CONTENTPANEL_WIDTH, 50);
		this.setOpaque(true);
		this.setBackground(UIConstant.MAINCOLOR_OPACITY_40);
		
		titleLabel = new ELSLabel();
		
		titleLabel.setMinimumSize(new Dimension(200, getHeight()));titleLabel.setForeground(Color.white);
		titleLabel.setVerticalAlignment(JLabel.CENTER);
		titleLabel.setHorizontalAlignment(JLabel.LEFT);
		titleLabel.setText(title);
		titleLabel.setForeground(Color.white);
		
		this.add(Box.createHorizontalStrut(10));
		this.add(titleLabel);
	}
}
