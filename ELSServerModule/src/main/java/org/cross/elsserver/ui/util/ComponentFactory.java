package org.cross.elsserver.ui.util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

import org.cross.elsserver.ui.component.ELSButton;


public class ComponentFactory {
	
	public static ELSButton createExitBtn(){
		ELSButton btn = new ELSButton();
		btn.setOpaque(false);
		btn.setSize(20,20);
		btn.setIcon(Images.EXIT_IMAGEICON);
		btn.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(ELSDialog.showConfirmDlg(GetPanelUtil.getMainFrame((JComponent)e.getSource()), "退出系统", "确认退出ELS服务端？")){
					System.exit(0);
				}
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
		});
		
		return btn;
	}
	
	
	
	/**
	 * 创建搜索栏按钮
	 * @para 
	 * @return ELSButton
	 */
	public static ELSButton createSearchBtn(){
		ELSButton btn = new ELSButton();
		btn.setSize(141,48);
		btn.setPreferredSize(new Dimension(150, UIConstant.SEARCHPANEL_HEIGHT));
		btn.setMaximumSize(new Dimension(250, UIConstant.SEARCHPANEL_HEIGHT));
		btn.setMinimumSize(new Dimension(150, UIConstant.SEARCHPANEL_HEIGHT));
		btn.setColor(UIConstant.NORMAL_BTN_COLOR);
		return btn;
	}
	
	
}
