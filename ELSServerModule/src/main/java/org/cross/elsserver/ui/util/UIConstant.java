package org.cross.elsserver.ui.util;

import java.awt.Color;
import java.awt.Font;

import org.cross.elsserver.ui.LogTable;


public class UIConstant {
	public static int WINDOW_WIDTH = 1024;
	public static int WINDOW_HEIGHT = 768;
	
	public static int CONTENTPANEL_WIDTH = 820;
	public static int CONTENTPANEL_HEIGHT = 632;
	public static int CONTENTPANEL_MARGIN_LEFT = 18;
	public static int CONTENTPANEL_MARGIN_TOP = 18;
	
	public static int CONTAINER_WIDTH = 856;
	public static int CONTAINER_HEIGHT = 668;
	
//	public static int MANAGETABLE_HEIGHT = 700;
	public static int MANAGETABLE_ITEM_HEIGHT = 48;
	
	public static int SEARCHPANEL_HEIGHT = 48;
	
	public static int DIALOG_WIDTH = 420;
	public static int DIALOG_HEIGHT = 270;
	
	public static int BTN_WIDTH = 142;
	public static int BTN_HEIGHT = 48;
	
	public static Color MAINCOLOR = Color.decode("#5a6074");
	public static Color MAINCOLOR_OPACITY_10 = new Color(90, 96, 116, 25);
	public static Color MAINCOLOR_OPACITY_40 = new Color(90, 96, 116, 100);
	public static Color MAINCOLOR_OPACITY_90 = new Color(90, 96, 116, 200);
	public static Color TABLEBACK = Color.decode("#f4f5f7");
	public static Color TABLEBACK_OPACITY = new Color(244, 245, 247, 20);
	public static Color COMFIRM_BTN_COLOR = Color.decode("#7ED09D");
	public static Color NORMAL_BTN_COLOR = Color.decode("#7EBCD0");
	public static Color CANCEL_BTN_COLOR = Color.decode("#E57979");
	
	public static Font MainFont = new Font("苹方 粗体",Font.TRUETYPE_FONT, 15);
	public static LogTable LOG;
}
