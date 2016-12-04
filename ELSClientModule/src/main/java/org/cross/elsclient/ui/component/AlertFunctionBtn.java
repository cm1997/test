package org.cross.elsclient.ui.component;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import org.cross.elsclient.ui.util.Images;

public class AlertFunctionBtn extends FunctionBtn {
	boolean isAlert = false;
	
	public void setAlert(boolean isAlert){
		if(isAlert){
			arrowIcon = Images.ALERT_IMAGEICON;
			arrowArchiveIcon = Images.ALERT_IMAGEICON;
		}else{
			arrowIcon = Images.RIGHT_IMAGEICON;
			arrowArchiveIcon = Images.RIGHT_ACTIVE_IMAGEICON;
		}
		setArchive(isArchive);
	}
	
}
