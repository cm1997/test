package org.cross.elsserver.ui.component;

import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.plaf.basic.BasicScrollPaneUI;

import org.cross.elsserver.ui.util.UIConstant;


public class ELSScrollPaneUI extends BasicScrollBarUI {
	
	@Override
	protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				    RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(UIConstant.MAINCOLOR);
        g2d.setComposite(AlphaComposite.getInstance(  
                AlphaComposite.SRC_OVER, 0.5f));  
		g2d.fillRoundRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height,0,0);
	}
	
	@Override
	protected void paintDecreaseHighlight(Graphics g) {
		// TODO Auto-generated method stub
	}
	@Override
	protected void paintIncreaseHighlight(Graphics g) {
		// TODO Auto-generated method stub
	}
	
	@Override
	protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
	}
	
	@Override
	protected JButton createIncreaseButton(int orientation) {
		JButton btn = new JButton();
		incrGap = 0;
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);
		btn.setOpaque(false);
		btn.setPreferredSize(new Dimension(0, 0));
		return btn;
	}
	
	@Override
	protected JButton createDecreaseButton(int orientation) {
		JButton btn = new JButton();
		decrGap = 0;
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);
		btn.setOpaque(false);
		btn.setPreferredSize(new Dimension(0, 0));
		return btn;
	}
	
	@Override
	public void installUI(JComponent c) {
		super.installUI(c);
		scrollbar.remove(incrButton);
		scrollbar.remove(decrButton);
	}
	
}
