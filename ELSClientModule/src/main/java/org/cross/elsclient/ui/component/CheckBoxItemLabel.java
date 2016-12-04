package org.cross.elsclient.ui.component;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.cross.elsclient.ui.util.Images;

public class CheckBoxItemLabel extends ManageTableItemLabel{
	public ELSCheckBox checkBox;
	
	public CheckBoxItemLabel() {
		super();
	}

	public CheckBoxItemLabel(int axis) {
		super(axis);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(String[] item, int[] itemWidth, boolean isUpdateAndDelete) {
		checkBox = new ELSCheckBox();
		checkBox.addItemListener(new BoxListener());
		checkBox.addMouseListener(new BoxListener());
//		checkBox.setRolloverIcon(new ImageIcon("img/test-icon2.png"));
		this.add(checkBox);
		this.add(Box.createHorizontalStrut(20));
		super.init(item, itemWidth, isUpdateAndDelete);
	}
	
	class BoxListener implements ItemListener,MouseListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			getParent().repaint();
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			getParent().repaint();
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			getParent().repaint();

		}

		@Override
		public void mouseExited(MouseEvent e) {
			getParent().repaint();

		}

	}
}
