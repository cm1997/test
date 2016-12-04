package org.cross.elsclient.ui.component;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Paint;
import java.awt.PaintContext;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.ColorModel;

import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.cross.elsclient.ui.util.UIConstant;

public class TableItemLabel extends ELSBox{
	int width;
	int height;
	
	public TableItemLabel(){
		super(BoxLayout.X_AXIS);
	}
	
	public TableItemLabel(int axis) {
		super(axis);
	}

	public void init(){
		width = UIConstant.CONTAINER_WIDTH;
		height = UIConstant.MANAGETABLE_ITEM_HEIGHT;
		
		this.setOpaque(true);
		this.setBackground(UIConstant.TABLEBACK_OPACITY);
		this.setPreferredSize(new Dimension(width ,height));
		this.setMaximumSize(new Dimension(width,height));
		this.setMinimumSize(new Dimension(width,height));
		this.setBorder(new ItemBorder(0, 10, 0, 0));
	}
	
}
class ItemBorder extends EmptyBorder{
	
	public ItemBorder(Insets borderInsets) {
		super(borderInsets);
		// TODO Auto-generated constructor stub
	}
	
	public ItemBorder(int top, int left, int bottom, int right) {
		super(top, left, bottom, right);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void paintBorder(Component c, Graphics g, int x, int y,
			int width, int height) {
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(UIConstant.MAINCOLOR_OPACITY_40);
		
		g2d.fillRect(x, y+height-2, width+1, 2);
		
	}
	
}
