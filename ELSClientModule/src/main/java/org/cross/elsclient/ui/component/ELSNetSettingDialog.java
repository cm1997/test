package org.cross.elsclient.ui.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JLabel;

import org.cross.elsclient.ui.LoginPanel;
import org.cross.elsclient.ui.MainUI;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elscommon.util.NetWork;

public class ELSNetSettingDialog extends JDialog{
	private static ELSNetSettingDialog instance = new ELSNetSettingDialog();
	protected String ret;
	protected static ELSTextField ipField;
	protected static ELSTextField portField;
	protected static ELSButton okBtn;
	protected static ELSButton cancelBtn;
	protected static ELSLabel textLabel1;
	protected static ELSLabel textLabel2;
	protected static ELSLabel titleLabel;

	protected ELSNetSettingDialog() {
		setModal(true);// 当对话框显示时候其他窗口不能获得焦点
		this.setUndecorated(true);
//		this.setLayout(null);
		setSize(UIConstant.DIALOG_WIDTH,UIConstant.DIALOG_HEIGHT);
//		this.setLocation(200, 200);
//		FrameUtil.frameInit(this);
		com.sun.awt.AWTUtilities.setWindowOpaque(this, false);
		
		ELSLabel panel = new ELSLabel();
		panel.setOpaque(true);
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);
//		panel.setIcon(Images.DIALOG_BG_IMAGE);
		
		okBtn = new ELSButton("确定");
		okBtn.setSize(UIConstant.BTN_WIDTH,UIConstant.BTN_HEIGHT);
		okBtn.setColor(UIConstant.COMFIRM_BTN_COLOR);
		okBtn.setLocation(64, 208);
		okBtn.addMouseListener(new BtnListener());
		
		cancelBtn = new ELSButton("取消");
		cancelBtn.setSize(UIConstant.BTN_WIDTH,UIConstant.BTN_HEIGHT);
		cancelBtn.setColor(UIConstant.NORMAL_BTN_COLOR);
		cancelBtn.setLocation(214, 208);
		cancelBtn.addMouseListener(new BtnListener());
		
		titleLabel = new ELSLabel("  网络设置");
		titleLabel.setBackground(UIConstant.MAINCOLOR_OPACITY_90);
		titleLabel.setOpaque(true);
		titleLabel.setSize(getWidth(),48);
		titleLabel.setLocation(0, 0);
		titleLabel.setHorizontalAlignment(JLabel.LEFT);
		titleLabel.setVerticalAlignment(JLabel.CENTER);
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(UIConstant.MainFont.deriveFont(18f));
		
		textLabel1 = new ELSLabel("IP");
		textLabel1.setSize(100,48);
		textLabel1.setLocation(0, 80);
		textLabel1.setHorizontalAlignment(JLabel.CENTER);
		textLabel1.setVerticalAlignment(JLabel.CENTER);
		textLabel1.setForeground(UIConstant.MAINCOLOR);
		textLabel1.setFont(UIConstant.MainFont.deriveFont(18f));
		
		textLabel2 = new ELSLabel("PORT");
		textLabel2.setSize(100,48);
		textLabel2.setLocation(0,140);
		textLabel2.setHorizontalAlignment(JLabel.CENTER);
		textLabel2.setVerticalAlignment(JLabel.CENTER);
		textLabel2.setForeground(UIConstant.MAINCOLOR);
		textLabel2.setFont(UIConstant.MainFont.deriveFont(18f));
		
		ipField = new ELSTextField();
		ipField.setBounds(100,80,250,48);
		ipField.setFont(UIConstant.MainFont.deriveFont(18f));
		
		portField = new ELSTextField();
		portField.setBounds(100,140,250,48);
		portField.setFont(UIConstant.MainFont.deriveFont(18f));
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				ret = "";
			}
		});
		
		panel.add(okBtn);
		panel.add(cancelBtn);
		panel.add(titleLabel);
		panel.add(textLabel1);
		panel.add(textLabel2);
		panel.add(ipField);
		panel.add(portField);
		add(panel);
		setResizable(false);
	}
	
	/**
	 * 显示网络设置界面
	 * @para 
	 * @return String
	 */
	public static String showNetDig(Component comp) {
		instance.ipField.setText(NetWork.current_ip);
		instance.portField.setText(NetWork.port+"");
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
		ret = instance.ipField.getText()+"+"+instance.portField.getText();
		NetWork.setClient(instance.ipField.getText(), Integer.valueOf(instance.portField.getText()));
		setVisible(false);
	}
	
	public void cancel(){
		ret = "";
		setVisible(false);
	}
}
