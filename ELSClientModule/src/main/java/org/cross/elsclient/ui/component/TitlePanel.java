package org.cross.elsclient.ui.component;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.cross.elsclient.ui.util.ComponentFactory;
import org.cross.elsclient.ui.util.UIConstant;

public class TitlePanel extends ELSBox{
	String title;
	public ELSButton backBtn;
	public ELSLabel titleLabel;

	public TitlePanel() {
		super(BoxLayout.X_AXIS);
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
		backBtn = ComponentFactory.createInfoBackBtn();
		backBtn.setMaximumSize(new Dimension(30, 30));
		backBtn.setMinimumSize(new Dimension(30, 30));
		
		titleLabel.setMinimumSize(new Dimension(200, getHeight()));titleLabel.setForeground(Color.white);
		titleLabel.setVerticalAlignment(JLabel.CENTER);
		titleLabel.setHorizontalAlignment(JLabel.LEFT);
		titleLabel.setText(title);
		titleLabel.setForeground(Color.white);
		titleLabel.setFont(UIConstant.MainFont.deriveFont(18f));
		
		this.add(backBtn);
		this.add(Box.createHorizontalStrut(10));
		this.add(titleLabel);
	}
}
