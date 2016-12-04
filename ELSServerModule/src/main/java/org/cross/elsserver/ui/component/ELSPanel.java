package org.cross.elsserver.ui.component;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class ELSPanel extends JPanel {
	public CardLayout cl;
	
	public ELSPanel() {
		cl = new CardLayout();
		setLayout(cl);
	}
	
	public void init(){}
	
	/**
	 * 使容器高度自适应组件的大小
	 * @para 
	 * @return void
	 */
	public void packHeight(){
		JComponent buttonComponent = (JComponent)getComponent(getComponentCount()-1);
		
		setSize(getSize().width,buttonComponent.getHeight()+buttonComponent.getLocation().y);
		setPreferredSize(new Dimension(getPreferredSize().width,buttonComponent.getHeight()+buttonComponent.getLocation().y));
	}
}
