package org.cross.elsclient.ui.component;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JCheckBox;
import javax.swing.plaf.basic.BasicCheckBoxUI;

import org.cross.elsclient.ui.util.Images;

public class ELSCheckBox extends JCheckBox{

	public ELSCheckBox() {
		super();
		init();
	}

	public ELSCheckBox(Action a) {
		super(a);
		init();
	}

	public ELSCheckBox(Icon icon, boolean selected) {
		super(icon, selected);
		init();
	}

	public ELSCheckBox(Icon icon) {
		super(icon);
		init();
	}

	public ELSCheckBox(String text, boolean selected) {
		super(text, selected);
		init();
	}

	public ELSCheckBox(String text, Icon icon, boolean selected) {
		super(text, icon, selected);
		init();
	}

	public ELSCheckBox(String text, Icon icon) {
		super(text, icon);
		init();
	}

	public ELSCheckBox(String text) {
		super(text);
		init();
	}
	
	public void init(){
		this.setOpaque(false);
		this.setIcon(Images.CHECK_IMAGEICON);
		this.setSelectedIcon(Images.CHECK_CHOSEN_IMAGEICON);
	}

}
