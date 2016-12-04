package org.cross.elsserver.ui;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.FontUIResource;

import org.cross.elscommon.util.NetWork;
import org.cross.elsserver.ui.component.ELSPanel;
import org.cross.elsserver.ui.util.FrameUtil;
import org.cross.elsserver.ui.util.UIConstant;


public class MainUI extends JFrame {

	public static void main(String[] args) {
		try {
			FontUIResource fontUIResource = new FontUIResource(new Font("苹方 粗体",
					Font.TRUETYPE_FONT, 15));
			for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys
					.hasMoreElements();) {
				Object key = keys.nextElement();
				Object value = UIManager.get(key);
				if (value instanceof FontUIResource) {
					UIManager.put(key, fontUIResource);
				}
			}
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();  
//        String[] fontName = e.getAvailableFontFamilyNames();  
//        for(int i = 0; i<fontName.length ; i++)  
//        {  
//            System.out.println(fontName[i]);  
//        }  
		
		NetWork.setpreAddress();

		JFrame jf = new JFrame();
		ELSPanel mainPanel = new ELSPanel();
		jf.setSize(UIConstant.WINDOW_WIDTH, UIConstant.WINDOW_HEIGHT);
		FrameUtil.frameInit(jf);
		com.sun.awt.AWTUtilities.setWindowOpaque(jf, false);
		
		mainPanel.add(new ELSServerPanel(), "main");
		mainPanel.setOpaque(false);
		jf.getContentPane().add(mainPanel);	
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
