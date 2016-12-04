package org.cross.elsclient.ui.component;

import java.awt.Color;

import org.cross.elsclient.ui.util.UIConstant;

public class ELSToggleBtn extends ELSButton{
	boolean isSelected = false;
	
	public void setSelected(boolean isSelected){
		this.isSelected = isSelected;
		if(isSelected){
			setColor(UIConstant.MAINCOLOR_OPACITY_90);
			setForeground(Color.white);
		}else{
			setColor(Color.white);
			setForeground(UIConstant.MAINCOLOR_OPACITY_90);
		}
	}
}
