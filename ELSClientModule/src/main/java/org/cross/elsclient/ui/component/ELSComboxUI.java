package org.cross.elsclient.ui.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

import org.cross.elsclient.ui.util.Images;
import org.cross.elsclient.ui.util.UIConstant;

public class ELSComboxUI extends BasicComboBoxUI {

	@Override
	protected JButton createArrowButton() {
		JButton btn = new JButton();
		btn.setOpaque(false);
		btn.setFocusable(false);
		btn.setIcon(Images.DOWN_ACTIVE_IMAGEICON);
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);
		btn.setSize(5, 5);
		btn.setMaximumSize(btn.getSize());
		btn.setMinimumSize(btn.getSize());
		btn.setPreferredSize(btn.getSize());
		return btn;
	}

	protected ComboPopup createPopup() {
		BasicComboPopup popup = new BasicComboPopup(comboBox) {
			public void paintBorder(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setColor(UIConstant.MAINCOLOR);
				g2.drawRoundRect(0, -arrowButton.getHeight(), getWidth() - 1,
						getHeight() + arrowButton.getHeight() - 1, 0, 0);
			}
			
		};
		return popup;
	}
	
	@Override
	public void paintCurrentValueBackground(Graphics g, Rectangle bounds,
			boolean hasFocus) {
		g.setColor(Color.white);
		g.fillRect(bounds.x,bounds.y,bounds.width,bounds.height);
	}
}
