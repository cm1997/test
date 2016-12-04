package org.cross.elsclient.ui.counterui.initial;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;

import org.cross.elsclient.ui.component.ELSButton;
import org.cross.elsclient.ui.component.ELSManageTable;
import org.cross.elsclient.ui.util.ComponentFactory;

public class InitialManageTable extends ELSManageTable{
	public ELSButton addBtn;
	public boolean isAddBtnVisible = true;
	
	public InitialManageTable(String[] name,int[] itemWidth) {
		super(name, itemWidth);
	}
	
	@Override
	public void init() {
		super.init();
		addBtn = ComponentFactory.createInitialAddBtn();
		addBtn.addMouseListener(new AddBtnListener());
		addBtn.setVisible(isAddBtnVisible);
		header.add(Box.createHorizontalGlue());
		header.add(addBtn);
	}

	public void refresh(){}
	
	public void addBtn(){}
	
	public class AddBtnListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			addBtn();
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
