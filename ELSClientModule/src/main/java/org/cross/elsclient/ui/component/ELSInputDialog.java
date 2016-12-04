package org.cross.elsclient.ui.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import org.cross.elsclient.blservice.initialblservice.InitialBLService;
import org.cross.elsclient.demo.MainFrame;
import org.cross.elsclient.ui.LoginPanel;
import org.cross.elsclient.ui.MainUI;
import org.cross.elsclient.ui.util.FrameUtil;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.Images;
import org.cross.elsclient.ui.util.ProgressGlassPane;
import org.cross.elsclient.ui.util.UIConstant;

public class ELSInputDialog extends JDialog {
	private static ELSInputDialog instance = new ELSInputDialog();
	protected String ret;
	protected static ELSTextField field;
	protected static ELSButton okBtn;
	protected static ELSButton cancelBtn;
	protected static ELSLabel textLabel;
	protected static ELSLabel titleLabel;

	protected ELSInputDialog() {
		setModal(true);// 当对话框显示时候其他窗口不能获得焦点
		this.setUndecorated(true);
//		this.setLayout(null);
		setSize(UIConstant.DIALOG_WIDTH,UIConstant.DIALOG_HEIGHT);
//		this.setLocation(200, 200);
//		FrameUtil.frameInit(this);
		com.sun.awt.AWTUtilities.setWindowOpaque(this, false);
		
		ELSLabel panel = new ELSLabel();
		panel.setOpaque(true);
		panel.setBackground(new Color(255, 255, 255, 80));
		panel.setLayout(null);
//		panel.setIcon(Images.DIALOG_BG_IMAGE);
		
		okBtn = new ELSButton("确定");
		okBtn.setSize(UIConstant.BTN_WIDTH,UIConstant.BTN_HEIGHT);
		okBtn.setColor(UIConstant.CANCEL_BTN_COLOR);
		okBtn.setLocation(64, 208);
		okBtn.addMouseListener(new BtnListener());
		
		cancelBtn = new ELSButton("取消");
		cancelBtn.setSize(UIConstant.BTN_WIDTH,UIConstant.BTN_HEIGHT);
		cancelBtn.setColor(UIConstant.NORMAL_BTN_COLOR);
		cancelBtn.setLocation(214, 208);
		cancelBtn.addMouseListener(new BtnListener());
		
		titleLabel = new ELSLabel();
		titleLabel.setBackground(UIConstant.MAINCOLOR_OPACITY_90);
		titleLabel.setOpaque(true);
		titleLabel.setSize(getWidth(),48);
		titleLabel.setLocation(0, 0);
		titleLabel.setHorizontalAlignment(JLabel.LEFT);
		titleLabel.setVerticalAlignment(JLabel.CENTER);
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(UIConstant.MainFont.deriveFont(18f));
		
		textLabel = new ELSLabel();
		textLabel.setSize(100,48);
		textLabel.setLocation(0, 110);
		textLabel.setHorizontalAlignment(JLabel.CENTER);
		textLabel.setVerticalAlignment(JLabel.CENTER);
		textLabel.setForeground(Color.white);
		textLabel.setFont(UIConstant.MainFont.deriveFont(18f));
		
		field = new ELSTextField();
		field.setBounds(100,110,200,48);
		field.setFont(UIConstant.MainFont.deriveFont(18f));
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				ret = "";
			}
		});
		
		panel.add(okBtn);
		panel.add(cancelBtn);
		panel.add(titleLabel);
		panel.add(textLabel);
		panel.add(field);
		add(panel);
		setResizable(false);
	}
	
	public static void init(){
		
	}

	public static String showInputDlg(Component comp,String title,String text) {
		if(comp.getParent()!=null){
			if(!(comp.getParent() instanceof LoginPanel)){
				MainUI.FRAME.getGlassPane().setVisible(true);
			}
		}else{
			MainUI.FRAME.getGlassPane().setVisible(true);
		}
		instance.titleLabel.setText("   " + title);
		instance.textLabel.setText(text);
		instance.titleLabel.setBackground(UIConstant.MAINCOLOR_OPACITY_90);
		instance.setLocationRelativeTo(comp);// 使得对话框显示在comp的中间
		instance.setVisible(true);// 显示对话框时候，调用它的线程被阻塞
		return instance.ret;// 直到对话框不显示时才返回，而时候ret已经被设置好了
	}

	class BtnListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == okBtn){
				ok();
			}else if (e.getSource() == cancelBtn){
				cancel();
			}
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	public void ok(){
		ret = instance.field.getText();
		setVisible(false);
		MainUI.FRAME.getGlassPane().setVisible(false);
	}
	
	public void cancel(){
		ret = "";
		setVisible(false);
		MainUI.FRAME.getGlassPane().setVisible(false);
	}
}
