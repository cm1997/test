package org.cross.elsserver.ui.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;


public class ELSScrollPane extends JScrollPane{

	public ELSScrollPane() {
		super();
		initComponent();
	}

	public ELSScrollPane(Component view, int vsbPolicy, int hsbPolicy) {
		super(view, vsbPolicy, hsbPolicy);
		initComponent();
	}

	public ELSScrollPane(Component view) {
		super(view);
		initComponent();
	}

	public ELSScrollPane(int vsbPolicy, int hsbPolicy) {
		super(vsbPolicy, hsbPolicy);
		initComponent();
	}

	public void init(){}
	
	public void initComponent(){
		setBorder(null);
		setOpaque(false);
		JScrollBar bar = getVerticalScrollBar();
		bar.setUI(new ELSScrollPaneUI());
		bar.setBorder(null);
		bar.setOpaque(false);
		bar.setPreferredSize(new Dimension(15,bar.getPreferredSize().height));
		bar.setMaximumSize(new Dimension(15,bar.getPreferredSize().height));
		bar.setMinimumSize(new Dimension(15,bar.getPreferredSize().height));
		bar.setSize(15,bar.getHeight());
		getViewport().setOpaque(false);
	}
	
	public void packHeight(){
		if(getViewport().getComponent(0)!=null&&getViewport().getComponent(0) instanceof ELSPanel){
			ELSPanel component = (ELSPanel)getViewport().getComponent(0);
			component.packHeight();
		}
	}
}
