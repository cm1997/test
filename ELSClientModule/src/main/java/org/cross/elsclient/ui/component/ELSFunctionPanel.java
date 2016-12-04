package org.cross.elsclient.ui.component;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

import org.cross.elsclient.ui.adminui.UserManagePanel;
import org.cross.elsclient.ui.util.ComponentFactory;
import org.cross.elsclient.ui.util.Images;
import org.cross.elsclient.ui.util.UIConstant;

public class ELSFunctionPanel extends ELSPanel {
	public ELSPanel contentPanel;
	public ArrayList<FunctionBtn> functionBtns = new ArrayList<>();
	public ArrayList<ELSPanel> functionPanels = new ArrayList<>();
	ELSLabel logo;
	ELSButton exitBtn;
	ELSButton minusBtn;
	ELSButton setBtn;
	ELSLabel mask1;
	ELSLabel mask2;
	ELSLabel posLabel;
	ELSLabel idLabel;
	ELSLabel avatarLabel;
	
	/**
	 * 功能控制面板需要先实例化BL对象再执行init()
	 * @author:Moo
	 * @para:
	 */
	public ELSFunctionPanel() {}
	
	public void init(){
		removeAll();
		functionBtns = new ArrayList<>();
		functionPanels = new ArrayList<>();
		setSize(UIConstant.WINDOW_WIDTH,UIConstant.WINDOW_HEIGHT);
		setLayout(null);
//		setBackground(UIConstant.MAINCOLOR);
		setOpaque(false);
		
		contentPanel = new ELSPanel();
		contentPanel.setBounds(168, 100, 856, 668);
		contentPanel.setOpaque(false);
		
		logo = new ELSLabel();
		logo.setSize(225,44);
		logo.setLocation(27, 30);
		logo.setIcon(Images.LOGO_IMAGEICON);
		
		exitBtn = ComponentFactory.createExitBtn(true);
		exitBtn.setLocation(994, 10);
		setBtn = ComponentFactory.createSettingBtn();
		setBtn.setLocation(900,7);
		minusBtn = ComponentFactory.createWindowMinusBtn();
		minusBtn.setLocation(964, 10);
		
		posLabel = new ELSLabel();
		idLabel = new ELSLabel();
		avatarLabel = new ELSLabel();
		if(UIConstant.CURRENT_USER!=null){
			posLabel.setText(UIConstant.CURRENT_USER.userType.toString());
			idLabel.setText(UIConstant.CURRENT_USER.number);
			avatarLabel.setIcon(Images.getAvatar(UIConstant.CURRENT_USER.userType));
		}
		posLabel.setHorizontalAlignment(JLabel.LEFT);
		posLabel.setBounds(850, 40, 140, 20);
		posLabel.setFont(UIConstant.MainFont.deriveFont(20f));
		posLabel.setForeground(Color.white);
		idLabel.setHorizontalAlignment(JLabel.LEFT);
		idLabel.setBounds(850, 70, 140, 20);
		idLabel.setFont(UIConstant.MainFont.deriveFont(20f));
		idLabel.setForeground(Color.white);
		avatarLabel.setBounds(790, 40, 50, 50);
		
		
		mask1 = new ELSLabel();
		mask2 = new ELSLabel();
		mask1.setOpaque(true);
		mask2.setOpaque(true);
		mask1.setBackground(new Color(90,96,116,20));
		mask2.setBackground(new Color(90,96,116,20));
		mask1.setBounds(0, 0, UIConstant.WINDOW_WIDTH, 100);
		mask2.setBounds(0,100,168,668);
		
		this.add(contentPanel);
		this.add(posLabel);
		this.add(idLabel);
		this.add(avatarLabel);
		this.add(logo);
		this.add(exitBtn);
		this.add(minusBtn);
		this.add(setBtn);
		this.add(mask1);
		this.add(mask2);
	}
	
	
	/**
	 * 添加功能按钮，functionName要与功能面板中参数的functionName相同
	 * @para text-显示的文字, functionName-功能名称
	 * @return void
	 */
	public void addFunctionBtn(String text,String functionName){
		FunctionBtn btn = (FunctionBtn)ComponentFactory.createFunctionBtn();
		
		btn.setBtnText(text);
		btn.setName(functionName);
		btn.addMouseListener(new FuncBtnListener());
		if(functionBtns.isEmpty()){
			btn.setArchive(true);
		}		
		
		functionBtns.add(btn);
		
		btn.setBounds(0, 100+54*functionBtns.indexOf(btn), 200, 54);
		this.add(btn,2);
	}
	
	/**
	 * 添加报警按钮
	 * @para text-按钮文字，text-功能名称
	 * @return void
	 */
	public void addAlertBtn(String text,String functionName){
		AlertFunctionBtn btn = new AlertFunctionBtn();
		btn.setBtnText(text);
		btn.setName(functionName);
		btn.addMouseListener(new FuncBtnListener());
		if(functionBtns.isEmpty()){
			btn.setArchive(true);
		}		
		
		functionBtns.add(btn);
		
		btn.setBounds(0, 100+54*functionBtns.indexOf(btn), 200, 54);
		this.add(btn,2);
	}
	
	/**
	 * 添加功能面板，functionName要与功能按钮中参数的functionName相同，默认面板名称为manage,add,update等
	 * @para panel-功能面板,name-默认面板名称, functionName-功能名称
	 * @return void
	 */
	public void addFunctionPanel(Container panel,String name, String functionName){
		ELSPanel container = new ELSPanel();
		container.setBackground(Color.white);
		container.setName(functionName);
		container.setOpaque(false);
		
		functionPanels.add(container);
		container.add(panel,name);
		contentPanel.add(container,functionName);
	}
	
	/**
	 * 跳转子功能界面
	 * @para functionName-功能名称
	 * @return void
	 */
	public void setChosenFunction(String functionName){
		for (FunctionBtn elsButton : functionBtns) {
			if(elsButton.getName()!=functionName){
				elsButton.setArchive(false);
			}else {
				elsButton.setArchive(true);
			}
		}
		for (ELSPanel panel : functionPanels) {
			if(panel.getName()==functionName){
				Component cs[] = panel.getComponents();
				for (Component component : cs) {
					if(component instanceof ELSPanel){
						((ELSPanel)component).init();
					} else if(component instanceof ELSScrollPane){
						((ELSScrollPane)component).init();
					}
				}
			}
		}
		
		contentPanel.cl.show(contentPanel, functionName);
	}
	
	/**
	 * 获取子功能界面
	 * @para name-功能名称
	 * @return ELSPanel
	 */
	public ELSPanel getSubFunctionPanel(String name){
		for (ELSPanel elsPanel : functionPanels) {
			if(elsPanel.getName().equals(name)){
				return elsPanel;
			}
		}
		return null;
	}
	
	class FuncBtnListener implements MouseListener{
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			FunctionBtn btn = (FunctionBtn)e.getSource();
			if(!btn.isArchive){
				setChosenFunction(btn.getName());
			}else{
				btn.setArchive(true);
			}
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(UIConstant.BACK_IMG.getImage(), 0, 0, null);
		super.paint(g);
	}
}
