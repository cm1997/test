package org.cross.elsclient.ui.component;

import java.awt.Color;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import org.cross.elsclient.ui.util.UIConstant;

public class BackgroundBtn extends ELSButton{
	boolean isSelected = false;
	Border border;
	
	@Override
	public void init() {
		super.init();
		setOpaque(false);
		border = new LineBorder(UIConstant.CANCEL_BTN_COLOR, 3);
	}
	
	public void setSelected(boolean isSelected){
		this.isSelected = isSelected;
		if(isSelected){
			setBorder(border);
		}else{
			setBorder(null);
		}
	}
}
