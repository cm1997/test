package org.cross.elsclient.ui.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.sql.rowset.serial.SerialArray;
import javax.swing.*;
import javax.xml.bind.Marshaller.Listener;

import org.cross.elsclient.blservice.userblservice.UserBLService;
import org.cross.elsclient.ui.util.ComponentFactory;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.vo.UserVO;
import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

public class ELSManagePanel extends ELSScrollPane {
	protected ELSPanel container;
	protected ELSBox searchPanel;
	protected ELSComboBox modeBox;
	protected ELSButton searchBtn;
	protected ELSTextField searchTextField;

//	public ELSManagePanel() {
//		init();
//	}
	
	
	@Override
	public void init() {
		setSize(UIConstant.CONTAINER_WIDTH,UIConstant.CONTAINER_WIDTH);
		setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		container = new ELSPanel();
		searchPanel = new ELSBox(BoxLayout.X_AXIS);
		modeBox = new ELSComboBox();
		searchTextField = new ELSTextField();
		searchBtn = ComponentFactory.createSearchBtn();
		
		container.setPreferredSize(new Dimension(UIConstant.CONTAINER_WIDTH,UIConstant.CONTAINER_HEIGHT));
		container.setLayout(null);
		container.setBackground(Color.WHITE);
		container.setOpaque(false);
		
		searchPanel.setSize(UIConstant.CONTENTPANEL_WIDTH,48);
//		searchPanel.setLayout(null);
		searchPanel.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT, UIConstant.CONTENTPANEL_MARGIN_TOP);
		
		
		modeBox.setPreferredSize(new Dimension(187, UIConstant.SEARCHPANEL_HEIGHT));
		modeBox.setMaximumSize(new Dimension(187, UIConstant.SEARCHPANEL_HEIGHT));
		modeBox.setMinimumSize(new Dimension(187,UIConstant.SEARCHPANEL_HEIGHT));
		
		searchTextField.setPreferredSize(new Dimension(300, UIConstant.SEARCHPANEL_HEIGHT));
//		searchTextField.setMaximumSize(new Dimension(50, searchPanel.getHeight()));
		searchTextField.setMinimumSize(new Dimension(200,UIConstant.SEARCHPANEL_HEIGHT));
		
		searchBtn.setPreferredSize(new Dimension(150, UIConstant.SEARCHPANEL_HEIGHT));
		searchBtn.setMaximumSize(new Dimension(250, UIConstant.SEARCHPANEL_HEIGHT));
		searchBtn.setMinimumSize(new Dimension(150, UIConstant.SEARCHPANEL_HEIGHT));
		
		searchPanel.add(modeBox);
		searchPanel.add(Box.createHorizontalStrut(10));
		searchPanel.add(searchTextField);
		searchPanel.add(Box.createGlue());
		searchPanel.add(Box.createHorizontalStrut(10));
		searchPanel.add(searchBtn);
//		searchPanel.add(Box.createHorizontalStrut(10));
		
		setTitle();
		setSearchPanel();
		container.add(searchPanel);
		setContentPanel();
		this.setViewport(new JViewport());
		this.getViewport().add(container);
		this.getViewport().setOpaque(false);
		this.getViewport().validate();
	}
	
	/**
	 * 对搜索栏进行设置
	 * @para 
	 * @return void
	 */
	public void setSearchPanel(){
		
	}
	
	/**
	 * 对内容栏进行设置
	 * @para 
	 * @return void
	 */
	public void setContentPanel(){
		
	}
	
	public void setTitle(){}
	
}
