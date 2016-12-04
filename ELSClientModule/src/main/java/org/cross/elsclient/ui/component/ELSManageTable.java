package org.cross.elsclient.ui.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import org.cross.elsclient.ui.adminui.UserInfoPanel;
import org.cross.elsclient.ui.adminui.UserManagePanel;
import org.cross.elsclient.ui.adminui.UserUpdatePanel;
import org.cross.elsclient.ui.util.ComponentFactory;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.vo.UserVO;

public class ELSManageTable extends ELSPanel {
	protected String[] name;
	public ManageTableItemLabel header;
	protected ELSBox container;
	protected ELSLabel tempLabel;
	public ArrayList<TableItemLabel> itemLabels;
	protected int[] itemWidth;
	int width;
	int height;
	public int gap;
	protected Font font;
	public boolean isUpdateAndDelete;

	public ELSManageTable(){
		width = UIConstant.CONTENTPANEL_WIDTH;
		height = UIConstant.MANAGETABLE_ITEM_HEIGHT;
	}
	
	/**
	 * 
	 * @author:Moo
	 * @para: name-表头名，itemWidth-列宽
	 */
	public ELSManageTable(String[] name, int[] itemWidth) {
		super();
		this.name = name;
		this.itemWidth = itemWidth;
		width = UIConstant.CONTENTPANEL_WIDTH;
		height = UIConstant.MANAGETABLE_ITEM_HEIGHT;
	}

	public void init() {
		removeAll();
		
		itemLabels = new ArrayList<>();
		container = new ELSBox(BoxLayout.Y_AXIS);
		header = new ManageTableItemLabel(BoxLayout.X_AXIS);
		gap = 20;
		font = getFont().deriveFont(18f);
		isUpdateAndDelete = false;

		setSize(new Dimension(width, UIConstant.MANAGETABLE_ITEM_HEIGHT));
		setBorder(null);
		setBackground(null);
		setOpaque(false);
		
		container.setSize(width,UIConstant.MANAGETABLE_ITEM_HEIGHT);

		//表头初始化
		header.init(name,itemWidth,false);
		header.setBackground(UIConstant.MAINCOLOR_OPACITY_40);
		header.setFont(font);
		for (ELSLabel label : header.labels) {
			label.setForeground(Color.WHITE);
		}
		
		container.add(header);
		add(container);
		validate();
		repaint();
	}
	
	/**
	 * 添加条目
	 * @para item-条目项
	 * @return void
	 */
	public void addItemLabel(String[] item) {
		ManageTableItemLabel itemLabel = new ManageTableItemLabel(BoxLayout.X_AXIS);
		itemLabel.init(item,itemWidth,isUpdateAndDelete);
		itemLabel.setFont(font);
		itemLabel.addMouseListener(new ItemListener(itemLabel));
		itemLabel.updateBtn.addMouseListener(new BtnListener(itemLabel));
		itemLabel.deleteBtn.addMouseListener(new BtnListener(itemLabel));
		
		itemLabels.add(itemLabel);
		container.add(itemLabel);
		packHeight();
		validate();
		repaint();
	}
	
	/**
	 * 点击信息按钮的响应事件，需要被重写
	 * @para index-对应条目的序号
	 * @return void
	 */
	public void infoBtn(int index){
	}
	
	/**
	 * 点击修改按钮的响应事件，如果添加了修改按钮则需要被重写
	 * @para index-对应条目的序号
	 * @return void
	 */
	public void updateBtn(int index){
	}
	
	/**
	 * 点击删除按钮的响应事件，如果添加了删除按钮则需要被重写
	 * @para index-对应条目的序号
	 * @return void
	 */
	public void deleteBtn(int index){
	}
	
	public class ItemListener implements MouseListener{
		ManageTableItemLabel itemLabel;
		
		public ItemListener(ManageTableItemLabel itemLabel) {
			this.itemLabel = itemLabel;
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			int index = itemLabels.indexOf(itemLabel);
			infoBtn(index);
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
			if(isUpdateAndDelete){
				itemLabel.updateBtn.setVisible(true);
				itemLabel.deleteBtn.setVisible(true);
				repaint();
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if(isUpdateAndDelete){
				itemLabel.updateBtn.setVisible(false);
				itemLabel.deleteBtn.setVisible(false);
				repaint();
			}
		}
	}
	
	public class BtnListener implements MouseListener{
		ManageTableItemLabel itemLabel;
		
		public BtnListener(ManageTableItemLabel itemLabel) {
			this.itemLabel = itemLabel;
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			ELSButton btn = (ELSButton)e.getSource();
			int index = itemLabels.indexOf(itemLabel);
			
			if(btn.getName()=="update"){
				updateBtn(index);
			}else if(btn.getName()=="delete"){
				if(ELSComfirmDialog.showConfirmDlg(SwingUtilities.getWindowAncestor(ELSManageTable.this), "删除","是否删除")){
					deleteBtn(index);
				}
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
			if(isUpdateAndDelete){
				itemLabel.updateBtn.setVisible(true);
				itemLabel.deleteBtn.setVisible(true);
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if(isUpdateAndDelete){
				itemLabel.updateBtn.setVisible(false);
				itemLabel.deleteBtn.setVisible(false);
			}
		}
	}
	
	@Override
	public void packHeight() {
		container.setSize(getWidth(),container.getComponentCount()*UIConstant.MANAGETABLE_ITEM_HEIGHT);
		setSize(getWidth(),container.getComponentCount()*UIConstant.MANAGETABLE_ITEM_HEIGHT);
	}
	
}
