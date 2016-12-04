package org.cross.elsclient.ui.util;

import java.awt.Color;

public class ThemeColor{
	public Color main;
	public Color opacity_10;
	public Color opacity_40;
	public Color opacity_90;
	
	public ThemeColor(int r, int b, int g) {
		main = new Color(r,b,g);
		opacity_10 = new Color(r,b,g,25);
		opacity_40 = new Color(r,b,g,100);
		opacity_90 = new Color(r,b,g,200);
	}
}