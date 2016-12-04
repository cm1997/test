package org.cross.elsclient.ui.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import org.cross.elsclient.ui.LoginPanel;
import org.cross.elsclient.ui.MainUI;
import org.cross.elsclient.ui.component.ELSComfirmDialog.BtnListener;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.Images;
import org.cross.elsclient.ui.util.ThemeColors;
import org.cross.elsclient.ui.util.UIConstant;

public class ELSSettingDialog extends JDialog {
	private static ELSSettingDialog instance = new ELSSettingDialog();
	private boolean ret;
	private ELSLabel titleLabel;
	private ArrayList<BackgroundBtn> backBtns;
	private ELSButton okBtn;
	private ELSButton cancelBtn;
	
	public ELSSettingDialog(){
		setModal(true);// 当对话框显示时候其他窗口不能获得焦点
		this.setUndecorated(true);
		setSize(600,400);
		com.sun.awt.AWTUtilities.setWindowOpaque(this, false);
		
		backBtns = new ArrayList<>();
		
		ELSLabel panel = new ELSLabel();
		panel.setOpaque(true);
		panel.setBackground(new Color(255, 255, 255, 80));
		panel.setLayout(null);
		
		titleLabel = new ELSLabel("  主题设置");
		titleLabel.setBackground(UIConstant.MAINCOLOR_OPACITY_90);
		titleLabel.setOpaque(true);
		titleLabel.setSize(getWidth(),48);
		titleLabel.setLocation(0, 0);
		titleLabel.setHorizontalAlignment(JLabel.LEFT);
		titleLabel.setVerticalAlignment(JLabel.CENTER);
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(UIConstant.MainFont.deriveFont(18f));
		
		ELSLabel backTextLabel = new ELSLabel("背景设置");
		backTextLabel.setBounds(0, 100, getWidth(), 30);
		backTextLabel.setFont(UIConstant.MainFont.deriveFont(22f));
		backTextLabel.setForeground(Color.white);
		
		
		okBtn = new ELSButton("确定");
		okBtn.setSize(UIConstant.BTN_WIDTH,UIConstant.BTN_HEIGHT);
		okBtn.setColor(UIConstant.COMFIRM_BTN_COLOR);
		okBtn.setLocation(144, 314);
		okBtn.setName("ok");
		okBtn.addMouseListener(new BtnListener(okBtn));
		
		cancelBtn = new ELSButton("取消");
		cancelBtn.setSize(UIConstant.BTN_WIDTH,UIConstant.BTN_HEIGHT);
		cancelBtn.setColor(UIConstant.NORMAL_BTN_COLOR);
		cancelBtn.setLocation(314, 314);
		cancelBtn.setName("cancel");
		cancelBtn.addMouseListener(new BtnListener(cancelBtn));
		
		int num = Images.BG_GROUP.length;
		for(int i = 0;i<num;i++){
			ImageIcon img = Images.BG_GROUP[i];
			BufferedImage buf = new BufferedImage(120, 100, Image.SCALE_DEFAULT);
			buf.getGraphics().drawImage(img.getImage(),0,0, buf.getWidth(), buf.getHeight(), null);
			ImageIcon read = new ImageIcon(buf);
			BackgroundBtn btn = new BackgroundBtn();
			btn.setBounds(32+i*139, 150, read.getIconWidth(), read.getIconHeight());
			btn.setIcon(read);
			btn.setName("back");
			btn.border = new LineBorder(ThemeColors.COLOR_GROUP[i].main, 3);
			btn.addMouseListener(new BtnListener(btn));
			backBtns.add(btn);
			panel.add(btn);
		}
		
		panel.add(okBtn);
		panel.add(cancelBtn);
		panel.add(backTextLabel);
		panel.add(titleLabel);
		this.add(panel);
	}

	public static boolean showDialog(Component comp) {
		MainUI.FRAME.getGlassPane().setVisible(true);
		for(int i = 0;i<Images.BG_GROUP.length;i++){
			if(UIConstant.BACK_IMG==Images.BG_GROUP[i]){
				instance.backBtns.get(i).setSelected(true);
			}
		}
		instance.titleLabel.setBackground(UIConstant.MAINCOLOR_OPACITY_90);
		instance.setLocationRelativeTo(comp);// 使得对话框显示在comp的中间
		instance.setVisible(true);// 显示对话框时候，调用它的线程被阻塞
		return instance.ret;// 直到对话框不显示时才返回，而时候ret已经被设置好了
	}
	
	class BtnListener implements MouseListener {
		ELSButton btn;

		public BtnListener(ELSButton btn) {
			super();
			this.btn = btn;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if(btn.getName().equals("back")){
				BackgroundBtn back = (BackgroundBtn)btn;
				for (BackgroundBtn backgroundBtn : backBtns) {
					backgroundBtn.setSelected(false);
				}
				instance.titleLabel.setBackground(ThemeColors.COLOR_GROUP[backBtns.indexOf(back)].opacity_90);
				back.setSelected(true);
			}else if (btn.getName().equals("ok")){
				for(int i= 0;i<backBtns.size();i++){
					if(backBtns.get(i).isSelected==true){
						UIConstant.BACK_IMG = Images.BG_GROUP[i];
						UIConstant.MAINCOLOR = ThemeColors.COLOR_GROUP[i].main;
						UIConstant.MAINCOLOR_OPACITY_10 = ThemeColors.COLOR_GROUP[i].opacity_10;
						UIConstant.MAINCOLOR_OPACITY_40 = ThemeColors.COLOR_GROUP[i].opacity_40;
						UIConstant.MAINCOLOR_OPACITY_90 = ThemeColors.COLOR_GROUP[i].opacity_90;
					}
				}
				GetPanelUtil.getFunctionPanel((JComponent)MainUI.FRAME.getComponent(0)).init();
				GetPanelUtil.getLoginPanel((JComponent)MainUI.FRAME.getComponent(0)).titleLabel.setBackground(UIConstant.MAINCOLOR_OPACITY_40);
				setVisible(false);
				MainUI.FRAME.getGlassPane().setVisible(false);
				MainUI.FRAME.getContentPane().revalidate();
			}else if(btn.getName().equals("cancel")){
				setVisible(false);
				MainUI.FRAME.getGlassPane().setVisible(false);
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
}
