package org.cross.elsclient.ui.component;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class ELSComboBoxDIY extends ELSPanel{
	JPanel selectList;
	JButton selectBtn;
	JLabel currentItem;
	String[] items;
	ArrayList<JLabel> itemsLabel;
	int visableItemNum = 5;
	int width;
	int height;
	boolean isOpen;
	Font font;
	
	public ELSComboBoxDIY(int width, int height, String[] items) {
		this.width = width;
		this.height = height;
		this.items = items;
		
		init();
	}
	
	public void init(){
		isOpen = false;
		selectList = new JPanel();
		selectBtn = new JButton();
		currentItem = new JLabel(items[0]);
		font = new Font("YaHei", Font.PLAIN, (int)(height*0.5));

		setLayout(null);
		setSize(width,height);
		setLocation(0,0);
		
		selectList.setLayout(null);
		selectList.setSize(getWidth(),getHeight()*items.length);
		selectList.setLocation(0,getHeight());
		
		selectBtn.setSize((int)(getWidth()*0.2),getHeight());
		selectBtn.setLocation((int)(getWidth()*0.8), 0);
		selectBtn.addMouseListener(new selectBtnListener());
		
		currentItem.setSize((int)(getWidth()*0.8),getHeight());
		currentItem.setLocation(0, 0);
		currentItem.setFont(font);
		currentItem.addMouseListener(new selectBtnListener());
		
		JLabel tempLabel;
		itemsLabel = new ArrayList<>();
		for(int i = 0;i<items.length;i++){
			tempLabel = new JLabel(items[i]);
			tempLabel.setSize(getWidth(),getHeight());
			tempLabel.setLocation(0, getHeight()*i);
			tempLabel.addMouseListener(new selectItemListener(tempLabel));
			itemsLabel.add(tempLabel);
			selectList.add(tempLabel);
		}
		
		add(currentItem);
		add(selectBtn);
		add(selectList);
	}
	
	public void openOrClose(){
		if(isOpen){
			setSize(width, height);
			isOpen = false;
			validate();
			repaint();
		}else{
			setSize(width, height+selectList.getHeight());
			isOpen = true;
			validate();
			repaint();
		}
	}
	
	public int getCurrentIndex(){
		String current = currentItem.getText();
		for(int i = 0;i<itemsLabel.size();i++){
			if(current.equals(itemsLabel.get(i).getText())){
				return i;
			}
		}
		return -1;
	}
	
	public String getCurrent(){
		return currentItem.getText();
	}
	
	public void addListener(MouseListener listener){
		for (JLabel jLabel : itemsLabel) {
			jLabel.addMouseListener(listener);
		}
	}
	
	class selectBtnListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			openOrClose();
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
	
	class selectItemListener implements MouseListener{
		JLabel item = new JLabel();
		
		public selectItemListener(JLabel item) {
			super();
			this.item = item;
		}


		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			currentItem.setText(item.getText());
			openOrClose();
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
	
}
