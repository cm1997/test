package org.cross.elsserver.ui.util;

import java.awt.Component;
import java.awt.Window;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class GetPanelUtil {
	/**
	 * 返回主窗口
	 * @para c-任意一个组件
	 * @return JFrame
	 */
	public static JFrame getMainFrame(JComponent c){
		JFrame frame = (JFrame)SwingUtilities.getWindowAncestor(c);
		return frame;
	}
	
}
