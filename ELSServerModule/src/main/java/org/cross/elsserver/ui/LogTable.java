package org.cross.elsserver.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.TextArea;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.BadLocationException;

import org.cross.elsserver.ui.component.ELSPanel;
import org.cross.elsserver.ui.component.ELSScrollPane;
import org.cross.elsserver.ui.component.ELSTextArea;
import org.cross.elsserver.ui.util.UIConstant;

public class LogTable extends ELSScrollPane{
	ELSPanel container;
	ELSTextArea textArea;
	int width;
	int height;
	int lineCount;
	
	public LogTable() {
		init();
	}
	
	@Override
	public void init() {
		super.init();
		container = new ELSPanel();
		textArea = new ELSTextArea();
		width = UIConstant.WINDOW_WIDTH-2*UIConstant.CONTENTPANEL_MARGIN_LEFT;
		height = 522;
		lineCount=0;
		
		this.setOpaque(false);
		this.getViewport().setOpaque(false);
		this.setBounds(17, 230, width, height);
		this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		container.setPreferredSize(new Dimension(width,height));
		container.setLayout(new BorderLayout());
		container.setOpaque(false);
		getVerticalScrollBar().addMouseMotionListener(new MyChangeListener());
		
		textArea.setBackground(UIConstant.MAINCOLOR_OPACITY_10);
		textArea.setOpaque(false);
		textArea.setEditable(false);
		textArea.setFont(getFont().deriveFont(18f));
		textArea.setForeground(Color.WHITE);
		container.setPreferredSize(textArea.getPreferredScrollableViewportSize());
		
		container.add(textArea);
		this.getViewport().add(container);
		
		textArea.setText("===================================");
	}
	
	public void addLog(String logStr){
		textArea.setText(textArea.getText()+"\n"+logStr);
//		if(textArea.getLineCount()>21){
//			container.setPreferredSize(new Dimension(width,container.getPreferredSize().height+textArea.getFont().getSize()+9));
//		}
		container.setPreferredSize(textArea.getPreferredScrollableViewportSize());
		Point p = new Point();
	    p.setLocation(0, container.getPreferredSize().height);
	    this.getViewport().setViewPosition(p);
		container.repaint();
	}
	
	class MyChangeListener implements MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			repaint();
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		
	}
}
