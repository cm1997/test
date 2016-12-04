package org.cross.elsserver.ui.util;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;


public class FrameUtil {

	public static void frameInit(JFrame frame){
		Toolkit kit2 = Toolkit.getDefaultToolkit(); // 定义工具包 
		Dimension screenSize = kit2.getScreenSize(); // 获取屏幕的尺寸 
		DragFrameListener drag = new DragFrameListener(frame);
		frame.setUndecorated(true);
		frame.addMouseMotionListener(drag);
		frame.addMouseListener(drag);
		int screenWidth = screenSize.width/2; // 获取屏幕的宽
		int screenHeight = screenSize.height/2; // 获取屏幕的高
		int height = frame.getHeight(); 
		int width = frame.getWidth(); 
		frame.setLocation(screenWidth-width/2, screenHeight-height/2);
	}
	
	public static void frameInit(JDialog frame){
		Toolkit kit2 = Toolkit.getDefaultToolkit(); // 定义工具包 
		Dimension screenSize = kit2.getScreenSize(); // 获取屏幕的尺寸 
		
//		kit2. 
		frame.setUndecorated(true);
		int screenWidth = screenSize.width/2; // 获取屏幕的宽
		int screenHeight = screenSize.height/2; // 获取屏幕的高
		int height = frame.getHeight(); 
		int width = frame.getWidth(); 
		frame.setLocation(screenWidth-width/2, screenHeight-height/2);
		
	}
	
	
}
class DragFrameListener implements MouseListener,MouseMotionListener{
	JFrame frame;
	int oldY;
	int oldX;
	
	public DragFrameListener(JFrame frame){
		this.frame = frame;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		this.frame.setLocation(frame.getLocation().x+e.getX()-oldX,
				frame.getLocation().y+e.getY()-oldY);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		oldX = e.getX();
		oldY = e.getY();
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