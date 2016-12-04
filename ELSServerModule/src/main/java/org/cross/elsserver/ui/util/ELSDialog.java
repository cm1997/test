package org.cross.elsserver.ui.util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.cross.elsserver.ui.component.ELSButton;
import org.cross.elsserver.ui.component.ELSLabel;
import org.cross.elsserver.ui.component.ELSTextField;

public class ELSDialog extends JDialog {
	private static ELSDialog instance = new ELSDialog();
	private boolean ret;
	private ELSTextField field;
	private static ELSButton okBtn;
	private static ELSButton cancelBtn;
	private static ELSLabel textLabel;
	private static ELSLabel titleLabel;

	private ELSDialog() {
		setModal(true);// 当对话框显示时候其他窗口不能获得焦点
		this.setUndecorated(true);
//		this.setLayout(null);
		setSize(UIConstant.DIALOG_WIDTH,UIConstant.DIALOG_HEIGHT);
//		this.setLocation(200, 200);
//		FrameUtil.frameInit(this);

		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		panel.setLayout(null);
		
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
		titleLabel.setBackground(UIConstant.MAINCOLOR);
		titleLabel.setOpaque(true);
		titleLabel.setSize(UIConstant.DIALOG_WIDTH,48);
		titleLabel.setLocation(0, 0);
		titleLabel.setHorizontalAlignment(JLabel.LEFT);
		titleLabel.setVerticalAlignment(JLabel.CENTER);
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(UIConstant.MainFont.deriveFont(18f));
		
		textLabel = new ELSLabel();
		textLabel.setSize(UIConstant.DIALOG_WIDTH,48);
		textLabel.setLocation(0, 110);
		textLabel.setHorizontalAlignment(JLabel.CENTER);
		textLabel.setVerticalAlignment(JLabel.CENTER);
		textLabel.setFont(UIConstant.MainFont.deriveFont(18f));
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				ret = false;
			}
		});
		
		panel.add(okBtn);
		panel.add(cancelBtn);
		panel.add(titleLabel);
		panel.add(textLabel);
		
		add(panel);
		
//		pack();
		setResizable(false);
	}

	public static boolean showConfirmDlg(Component comp,String title,String text) {
//		instance = new ELSDialog();
		instance.titleLabel.setText("   " + title);
		instance.textLabel.setText(text);
		instance.setLocationRelativeTo(comp);// 使得对话框显示在comp的中间
		instance.setVisible(true);// 显示对话框时候，调用它的线程被阻塞
		return instance.ret;// 直到对话框不显示时才返回，而时候ret已经被设置好了
	}

	class BtnListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == okBtn){
				ret = true;
			}else if (e.getSource() == cancelBtn)
				ret = false;
			setVisible(false);
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
}
