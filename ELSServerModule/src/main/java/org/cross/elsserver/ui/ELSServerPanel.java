package org.cross.elsserver.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.cross.elscommon.util.DatabaseConstant;
import org.cross.elscommon.util.NetWork;
import org.cross.elsserver.database.MySQL;
import org.cross.elsserver.network.TransDataImpl;
import org.cross.elsserver.ui.component.ELSButton;
import org.cross.elsserver.ui.component.ELSLabel;
import org.cross.elsserver.ui.component.ELSPanel;
import org.cross.elsserver.ui.component.ELSTextField;
import org.cross.elsserver.ui.component.TitlePanel;
import org.cross.elsserver.ui.util.ComponentFactory;
import org.cross.elsserver.ui.util.ELSDialog;
import org.cross.elsserver.ui.util.Images;
import org.cross.elsserver.ui.util.UIConstant;

import com.mysql.fabric.Server;

public class ELSServerPanel extends ELSPanel{
	ELSLabel logo;
	ELSButton exitBtn;
	ELSLabel title;
	ELSLabel infoLabel;
	ELSTextField portField;
	ELSLabel stateLabel;
	ELSButton changeBtn;
	ELSLabel ipLabel;
	ELSButton launchBtn;
	ELSButton stopBtn;
	TitlePanel logTitle;
	LogTable logTable;
	boolean isLaunched;
	
	public ELSServerPanel() {
		init();
	}
	
	public void init(){
		super.init();
		//member var initial
		logo = new ELSLabel();
		exitBtn = ComponentFactory.createExitBtn();
		title = new ELSLabel();
		infoLabel = new ELSLabel();
		portField = new ELSTextField();
		stateLabel = new ELSLabel();
		ipLabel = new ELSLabel();
		changeBtn = ComponentFactory.createSearchBtn();
		launchBtn = ComponentFactory.createSearchBtn();
		stopBtn = ComponentFactory.createSearchBtn();
		logTitle = new TitlePanel("服务器Log");
		logTable = new LogTable();
		isLaunched = false;
		UIConstant.LOG = logTable;
		
		this.setOpaque(false);
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		this.setForeground(Color.white);
		
		logo.setSize(225,44);
		logo.setLocation(27, 30);
		logo.setIcon(Images.LOGO_IMAGEICON);
		
		exitBtn.setLocation(984, 20);
	
		title.setBounds(0, 0, UIConstant.WINDOW_WIDTH, 100);
		title.setBackground(new Color(90,96,116,20));
		title.setOpaque(true);
		title.setLayout(null);
		
		
		infoLabel.setText("服务器信息:");
		infoLabel.setBounds(UIConstant.CONTENTPANEL_MARGIN_LEFT, 120, 110, 48);
		infoLabel.setHorizontalAlignment(JLabel.LEFT);
		infoLabel.setFont(getFont().deriveFont(18f));
		infoLabel.setForeground(Color.white);
		
		stateLabel.setText("服务器状态:未启动");
		stateLabel.setBounds(544, 120, 150, 48);
		stateLabel.setHorizontalAlignment(JLabel.LEFT);
		stateLabel.setFont(getFont().deriveFont(18f));
		stateLabel.setForeground(UIConstant.MAINCOLOR);
		stateLabel.setForeground(Color.white);
		
		ipLabel.setText(NetWork.current_ip);
		ipLabel.setBounds(125, 120, 160, 48);
		ipLabel.setHorizontalAlignment(JLabel.LEFT);
		ipLabel.setFont(getFont().deriveFont(18f));
		ipLabel.setForeground(Color.white);
		
		portField.setText(NetWork.port+"");
		portField.setBounds(285, 120, 80, 48);
		portField.setFont(getFont().deriveFont(18f));
		
		changeBtn.setLocation(380, 120);
		changeBtn.setText("更改端口");
		changeBtn.addMouseListener(new ELSListener());
		
		launchBtn.setLocation(708, 120);
		launchBtn.setText("启动服务");
		launchBtn.setColor(UIConstant.COMFIRM_BTN_COLOR);
		launchBtn.addMouseListener(new ELSListener());
		stopBtn.addMouseListener(new ELSListener());
		
		stopBtn.setLocation(864, 120);
		stopBtn.setText("停止服务");
		
		logTitle.setBounds(UIConstant.CONTENTPANEL_MARGIN_LEFT,183,UIConstant.WINDOW_WIDTH-2*UIConstant.CONTENTPANEL_MARGIN_LEFT,48);
		
		title.add(logo);
		title.add(exitBtn);
		title.validate();
		this.add(title);
		this.add(infoLabel);
		this.add(stateLabel);
		this.add(ipLabel);
		this.add(changeBtn);
		this.add(portField);
		this.add(changeBtn);
		this.add(launchBtn);
		this.add(stopBtn);
		this.add(logTitle);
		this.add(logTable);
	}
	
	public void launch(){
		if(!isLaunched){
			logTable.init();
			logTable.addLog("服务器回送地址: "+NetWork.current_ip);
			logTable.addLog("服务器内网地址: "+NetWork.local);
			logTable.addLog("===================================");
			if(TransDataImpl.start()){
				stateLabel.setText("服务器状态:已启动");
				isLaunched = true;
			}
		}
	}
	public void stop(){
		if(isLaunched){
			if(TransDataImpl.stop()){
				stateLabel.setText("服务器状态:已停止");
				isLaunched = false;
			}
		}
	}
	
	class ELSListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource().equals(launchBtn)) {
				launch();
			}else if (e.getSource().equals(stopBtn)) {
				stop();
			}else if (e.getSource().equals(changeBtn)) {
				NetWork.port = Integer.valueOf(portField.getText());
				stop();
				launch();
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
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(Images.BG_IMAGE, 0, 0, null);
	}
}
