package org.cross.elsclient.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.util.Enumeration;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.basic.BasicBorders;

import org.cross.elsclient.ui.component.ELSDatePicker;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.FrameUtil;
import org.cross.elsclient.ui.util.UIConstant;

public class TestFrame {
	
	public static void main(String[] args) {
		try {
			FontUIResource fontUIResource = new FontUIResource(new Font("YouYuan",
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
		JFrame jf = new JFrame();
		ELSPanel mainPanel = new ELSPanel();
		jf.setSize(UIConstant.WINDOW_WIDTH, UIConstant.WINDOW_HEIGHT);
//		FrameUtil.frameInit(jf);
//		jf.setEnabled(false);
//		mainPanel.add(new LoginPanel(), "login");
		mainPanel.setLayout(null);
		
		ELSDatePicker date = new ELSDatePicker();
		date.setSize(200,30);
		date.setLocation(0, 0);
		mainPanel.add(date);
		mainPanel.setOpaque(false);
		
		JButton btn = new JButton("hhhhhh");
		btn.setBounds(0, 100, 50, 50);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JButton btn = (JButton)e.getSource();
				ELSStateBar.showStateBar((JComponent)btn.getParent(), "hhhhhhh");
			}
		});
		mainPanel.add(btn);
		
//		JTextField jt = new JTextField();
//		jt.setSize(200,50);
//		jt.setLocation(50,50);
//		jt.setBorder(new MyBorder(Color.BLUE, Color.green, Color.red, Color.CYAN));
//		mainPanel.add(jt);
//		MyBorder border = new MyBorder(Color.BLUE, Color.green, Color.red, Color.CYAN);
//		border.getBorderInsets(jt, new Insets(jt., left, bottom, right));
		
		
//		jf.setBackground(null);
		jf.setUndecorated(true);
		jf.setBackground(null);
//		jf.setOpacity(0f);
		jf.getContentPane().add(mainPanel);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
}
class MyBorder extends BasicBorders.FieldBorder{
	
	public MyBorder(Color shadow, Color darkShadow, Color highlight,
			Color lightHighlight) {
		super(shadow, darkShadow, highlight, lightHighlight);
	}
	
	@Override
	public void paintBorder(Component c, Graphics g, int x, int y,
			int width, int height) {
		Graphics2D g2d = (Graphics2D) g;
		GradientPaint paint = new GradientPaint(0, 0, Color.BLACK, width, height, Color.GREEN);
		g2d.setPaint(paint);
		g2d.drawRect(x, y, width-1, height-1);
		
	}
	
}
