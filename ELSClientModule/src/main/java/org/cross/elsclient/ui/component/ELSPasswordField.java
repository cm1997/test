package org.cross.elsclient.ui.component;

import javax.swing.JPasswordField;
import javax.swing.text.Document;

import org.cross.elsclient.ui.util.UIConstant;

public class ELSPasswordField extends JPasswordField{

	public ELSPasswordField() {
		super();
		init();
	}

	public ELSPasswordField(Document doc, String txt, int columns) {
		super(doc, txt, columns);
		init();
	}

	public ELSPasswordField(int columns) {
		super(columns);
		init();
	}

	public ELSPasswordField(String text, int columns) {
		super(text, columns);
		init();
	}

	public ELSPasswordField(String text) {
		super(text);
		init();
	}
	
	public void init(){
		setBorder(new ELSEmptyBorder(0,10,0,10, UIConstant.MAINCOLOR));
		
	}
}
