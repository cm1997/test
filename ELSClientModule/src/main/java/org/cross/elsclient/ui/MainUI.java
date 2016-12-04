package org.cross.elsclient.ui;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.FontUIResource;

import org.cross.elsclient.blservice.constantblservice.ConstantBLService;
import org.cross.elsclient.blservice.constantblservice.ConstantBLService_Stub;
import org.cross.elsclient.ui.adminui.AdminFunctionPanel;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.component.ELSFunctionPanel;
import org.cross.elsclient.ui.managerui.ManagerFunctionPanel;
import org.cross.elsclient.ui.util.FrameUtil;
import org.cross.elsclient.ui.util.ProgressGlassPane;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.util.ConstantVal;

public class MainUI extends JFrame {
	public static JFrame FRAME;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new SwingWorker<Boolean, Boolean>() {

			@Override
			protected Boolean doInBackground() throws Exception {
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
				try {
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
			
//				GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();  
//                String[] fontName = e.getAvailableFontFamilyNames();  
//		        for(int i = 0; i<fontName.length ; i++)  
//		        {  
//		            System.out.println(fontName[i]);  
//		        }  

				JFrame jf = new JFrame();
				FRAME = jf;
				ELSPanel mainPanel = new ELSPanel();
				jf.setSize(UIConstant.WINDOW_WIDTH, UIConstant.WINDOW_HEIGHT);
				FrameUtil.frameInit(jf);
				com.sun.awt.AWTUtilities.setWindowOpaque(jf, false);
				
				
				mainPanel.add(new LoginPanel(), "login");
				mainPanel.setOpaque(false);
				jf.getContentPane().add(mainPanel);	
				jf.setVisible(true);
				jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jf.setGlassPane(new ProgressGlassPane());
//				jf.getGlassPane().setVisible(true);
				return null;
			}
			
		});
	}
		
}
