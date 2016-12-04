package org.cross.elsclient.ui.util;
import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.cross.elsclient.ui.MainUI;

public class ProgressGlassPane extends JComponent{

	private BufferedImage backDrop = null;//���屳��ͼƬ
	private BufferedImage backDropNew = null;//ģ����Ĵ��屳��ͼƬ
    private Color backColor=new Color(0, 0, 0, 50);//���������ɫ
	private int radius =30;//�����㷨�뾶
//	private JSlider radiusSlider;
	
	public ProgressGlassPane() {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
		
//		JPanel panel=new JPanel(new FlowLayout());
//		
//		panel.setOpaque(false);
//		
//        radiusSlider = new JSlider(2, 50, 25);
//        
//        radiusSlider.setOpaque(false);//����͸��
//        
//        radiusSlider.addChangeListener(new ChangeListener() {
//            public void stateChanged(ChangeEvent e) {
//                setRadius(radiusSlider.getValue());
//            }
//        });
//        
//        panel.add(radiusSlider);
//        panel.add(getColorLabel(null));
//        panel.add(getColorLabel(Color.red));
//        panel.add(getColorLabel(Color.green));
//        panel.add(getColorLabel(Color.blue));
//        panel.add(getColorLabel(Color.pink));
//        panel.add(getColorLabel(Color.yellow));
//        panel.add(getColorLabel(Color.ORANGE));
//        panel.add(getColorLabel(Color.white));
//        add(panel,BorderLayout.SOUTH);
        
//        JPanel closePanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
//        closePanel.setOpaque(false);
//        JButton b=new JButton("�ر�");
//        b.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				Main.getMainFrame().getGlassPane().setVisible(false);
//			}
//		});
//        closePanel.add(b);
//        add(closePanel,BorderLayout.NORTH);
//		addMouseMotionListener(new MouseMotionAdapter() {});
	}

	@Override
	public void setVisible(boolean visible) {//��дsetVisible����
		// TODO Auto-generated method stub
        if (visible) {
//        	setRadius(radiusSlider.getValue());
        	flushBackDrop();
        } else {
            if (backDropNew != null) {
            	backDropNew.flush();
            }
            backDropNew = null;
        }
		super.setVisible(visible);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g.create();
		if (backDropNew != null) {
			g2.drawImage(backDropNew, 0, 0, getWidth(), getHeight(), radius,radius, backDropNew.getWidth() - radius,backDropNew.getHeight() - radius, Color.white, null);
		}
		if (backColor != null) {
			g2.setColor(backColor);
			g2.setComposite(AlphaComposite.SrcOver.derive(0.1f));// ����͸����
			g2.fillRect(0, 0, getWidth(), getHeight());
		}
		g2.dispose();
	}
	
	private void flushBackDrop() {
		// TODO Auto-generated method stub
		backDrop = new BufferedImage(MainUI.FRAME.getRootPane().getWidth(),MainUI.FRAME.getRootPane().getHeight(),BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = backDrop.createGraphics();
		MainUI.FRAME.getRootPane().paint(g2); 
		g2.dispose();

		backDropNew = new BufferedImage(backDrop.getWidth() + 2 * radius,backDrop.getHeight() + 2 * radius, BufferedImage.TYPE_INT_ARGB);
		g2 = backDropNew.createGraphics();
		g2.drawImage(backDrop, radius, radius, null);
		g2.dispose();
//		
//		long start = System.nanoTime();
		backDropNew = changeImageWidth(backDropNew, backDropNew.getWidth() / 4);
		backDropNew = getGaussianBlurFilter(radius / 4, true).filter(backDropNew,null);
		backDropNew = getGaussianBlurFilter(radius / 4, false).filter(backDropNew,null);
		backDropNew = changeImageWidth(backDropNew, backDropNew.getWidth() * 4);
//		long delay = System.nanoTime() - start;
//		System.out.println("time = " + (delay / 1000.0f / 1000.0f)+ "ms for radius = " + radius);
		
//		try {
//			ImageIO.write(backDropNew, "png", new File("img/tmp.png"));
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
	}
	
	
	
    public static BufferedImage changeImageWidth(BufferedImage image, int width) {
        float ratio = (float) image.getWidth() / (float) image.getHeight();
        int height = (int) (width / ratio);
        
        BufferedImage temp = new BufferedImage(width, height,  image.getType());
        Graphics2D g2 = temp.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(image, 0, 0, temp.getWidth(), temp.getHeight(), null);
        g2.dispose();

        return temp;
    }
    
    public static ConvolveOp getGaussianBlurFilter(int radius,  boolean horizontal) {
        if (radius < 1) {
            throw new IllegalArgumentException("Radius must be >= 1");
        }
        
        int size = radius * 2 +1;
        float[] data = new float[size];
        
        float sigma = radius / 3.0f;
        float twoSigmaSquare = 2.0f * sigma * sigma;
        float sigmaRoot = (float) Math.sqrt(twoSigmaSquare * Math.PI);
        float total = 0.0f;
        
        for (int i = -radius; i <= radius; i++) {
            float distance = i * i;
            int index = i + radius;
            data[index] = (float) Math.exp(-distance / twoSigmaSquare) / sigmaRoot;
            total += data[index];
        }
        
        for (int i = 0; i < data.length; i++) {
            data[i] /= total;
        }        
        
        Kernel kernel = null;
        if (horizontal) {
            kernel = new Kernel(size, 1, data);
        } else {
            kernel = new Kernel(1, size, data);
        }
        return new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
    }

	public void setRadius(int radius) {
		this.radius = radius;
		 if (backDropNew != null) {
			 backDropNew.flush();
         }
		 backDropNew = null;
		flushBackDrop();
		repaint();
	}
    
	
	public void setBackColor(Color backColor) {
		this.backColor = backColor;
		 if (backDropNew != null) {
			 backDropNew.flush();
         }
		 backDropNew = null;
		flushBackDrop();
		repaint();
	}

}
