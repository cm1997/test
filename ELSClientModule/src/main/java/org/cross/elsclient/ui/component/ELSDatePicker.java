package org.cross.elsclient.ui.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.ComboBoxUI;

import org.cross.elsclient.ui.util.Images;
import org.cross.elsclient.ui.util.UIConstant;

public class ELSDatePicker extends JPanel {
	private JTextField tfDate;
	private JButton button;
	private JDialog dlg;
	private JPanel paCalendar;
	private boolean show;
	private JComboBox cboYear;
	private JComboBox cboMonth;
	private JLabel[] lbls = new JLabel[7];
	private ELSToggleBtn[] toggles = new ELSToggleBtn[42];
	private Border border;
	private Color bgColor;
	private int width = 150, height = 42;
	private int year;
	private int month;
	private int date;
	private int dayOfWeek;
	private String[] week = { "日", "一", "二", "三", "四", "五", "六" };
	private boolean isShowTime;

	public ELSDatePicker() {
		year = Calendar.getInstance().get(Calendar.YEAR);
		month = Calendar.getInstance().get(Calendar.MONTH) + 1;
		date = Calendar.getInstance().get(Calendar.DATE);
		dayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
		isShowTime = false;
		initUI();
		initDateDialog();
		updateField();
	}

	private void initUI() {
		setBackground(Color.white);
		
		tfDate = new JTextField();
		tfDate.setEditable(false);
		tfDate.setBackground(Color.WHITE);
		tfDate.setHorizontalAlignment(JTextField.CENTER);
		tfDate.setFont(UIConstant.MainFont.deriveFont(18f));
		tfDate.setForeground(UIConstant.MAINCOLOR);
		border = tfDate.getBorder();
		tfDate.setBorder(null);

		button = new JButton();
		button.setPreferredSize(new Dimension(height, height));
		button.setOpaque(false);
		button.setFocusable(false);
		button.setIcon(Images.DOWN_ACTIVE_IMAGEICON);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (show == false) {
					dlg.setLocation(ELSDatePicker.this.getLocationOnScreen().x,
							ELSDatePicker.this.getLocationOnScreen().y
									+ ELSDatePicker.this.getMaximumSize().height);
					dlg.setAlwaysOnTop(true);
					dlg.setVisible(true);
				} else {
					dlg.dispose();
				}
				updateField();
				show = !show;
			}
		});

		this.bgColor = this.getBackground();

		this.setOpaque(true);
		this.setLayout(new BorderLayout(0, 0));
		this.setBorder(border);
		this.add(tfDate, BorderLayout.CENTER);
		this.add(button, BorderLayout.EAST);
	}

	private void initDateDialog() {
		dlg = new JDialog();
		dlg.setUndecorated(true);
		paCalendar = new JPanel(new BorderLayout());
		paCalendar.setBorder(this.border);
		paCalendar.setBackground(this.bgColor);

		int borderWidth = 3;
		// 初始化两个下拉组件用于年和月的选择
		JPanel paHeader = new JPanel(new GridLayout(1, 2, borderWidth,
				borderWidth));
		paHeader.setOpaque(false);
		paHeader.setPreferredSize(new Dimension(this.width, this.height
				));
		paHeader.setBorder(BorderFactory.createEmptyBorder(borderWidth,
				borderWidth, borderWidth, borderWidth));
		paHeader.add(cboYear = new ELSComboBox());
		paHeader.add(cboMonth = new ELSComboBox());
		initYearModel();
		initMonthModel();
		paCalendar.add(paHeader, BorderLayout.NORTH);

		// 初始化日期组件
		JPanel paDay = new JPanel();
		paDay.setOpaque(false);
		paDay.setPreferredSize(new Dimension(this.height * 7, this.height * 7));
		initDate(paDay);
		paCalendar.add(paDay, BorderLayout.CENTER);

		dlg.setContentPane(paCalendar);
		dlg.pack();
		dlg.addWindowFocusListener(new WindowAdapter() {
			public void windowLostFocus(WindowEvent e) {
				dlg.dispose();
			}
		});
	}

	private void initYearModel() {
		for (int y = 1970; y < 2033; y++)
			cboYear.addItem(y);
		cboYear.setSelectedItem(year);
		cboYear.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				year = Integer.parseInt(cboYear.getSelectedItem().toString());
				updateComponent();
			}

		});
	}

	private void initMonthModel() {
		for (int m = 1; m <= 12; m++)
			cboMonth.addItem(m);
		cboMonth.setSelectedItem(month);
		cboMonth.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				month = Integer.parseInt(cboMonth.getSelectedItem().toString());
				updateComponent();
			}
		});
	}

	private void initDate(JPanel pa) {
		pa.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		// 显示日历的标签栏
		for (int i = 0; i < week.length; i++) {
			lbls[i] = new JLabel(week[i]);
			lbls[i].setHorizontalAlignment(SwingConstants.CENTER);
			lbls[i].setOpaque(false);
			lbls[i].setFont(getFont());
			lbls[i].setForeground(UIConstant.MAINCOLOR_OPACITY_90);
			lbls[i].setPreferredSize(new Dimension(this.height, this.height));
			pa.add(lbls[i]);
		}
		// 加载日历按钮
		for (int i = 0; i < 42; i++) {
			toggles[i] = new ELSToggleBtn();
//			toggles[i].setBorder(BorderFactory
//					.createLineBorder(Color.LIGHT_GRAY));
			toggles[i].setSelected(false);
			toggles[i]
					.setPreferredSize(new Dimension(this.height, this.height));
			toggles[i].addMouseListener(new SelectListener());
			pa.add(toggles[i]);
		}
		updateComponent();
	}

	private void updateComponent() {
		if (cboYear == null || cboMonth == null)
			return;
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, 1);
		// 根据当月的第一天是星期几来判断日历按钮的数字该从第几个按钮开始显示
		int off = cal.get(Calendar.DAY_OF_WEEK) - 1;
		// 计算当月总共有几天
		int end = 30;
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
				|| month == 10 || month == 12)
			end = 31;
		if (month == 2) {
			if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
				end = 29;
			else
				end = 28;
		}
		for (int i = 0; i < 42; i++) {
			if (i >= off && i <= end + off - 1) {
				int day = i - off + 1;
				toggles[i].setText(day + "");
				toggles[i].setEnabled(true);
			} else {
				toggles[i].setText("");
				toggles[i].setEnabled(false);
			}
		}
		for (ELSToggleBtn elsToggleBtn : toggles) {
			elsToggleBtn.setSelected(false);
		}
		// 使当天的按钮呈现被按下的效果
		int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + off - 1;
		toggles[day].setSelected(true);
	}

	// 更新文本框内的文字
	private void updateField() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.year + "-");
		builder.append(this.month + "-");
		builder.append(this.date );
		Calendar cal = Calendar.getInstance();
		cal.set(this.year, this.month - 1, this.date);
//		if(isShowTime){
//			builder.append(this.)
//		}
//		builder.append(" 星期" + week[cal.get(Calendar.DAY_OF_WEEK) - 1]);
		tfDate.setText(builder.toString());
	}

	public void setShowTime(boolean isShowTime){
		isShowTime = true;
		updateField();
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(this.width, this.height);
	}

	public void setPreferredSize(Dimension preferredSize) {
		super.setPreferredSize(preferredSize);
		this.width = (int) preferredSize.getWidth();
		this.height = (int) preferredSize.getHeight();
		initUI();
		initDateDialog();
		updateField();
	}

	public void setBackground(Color bg) {
		super.setBackground(bg);
		this.bgColor = bg;
	}

	public void setBorder(Border border) {
		super.setBorder(border);
		if (paCalendar != null)
			paCalendar.setBorder(border);
	}

	public void setButtonUI(String clzUIName) {
		try {
			button.setUI((ButtonUI) Class.forName(clzUIName).newInstance());
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

//	public void setDateButtonUI(String clzUIName) {
//		try {
//			for (int i = 0; i < 42; i++)
//				toggles[i].setUI((ButtonUI) Class.forName(clzUIName)
//						.newInstance());
//		} catch (InstantiationException | IllegalAccessException
//				| ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public void setComboBoxUI(String clzUIName) {
		try {
			cboYear.setUI((ComboBoxUI) Class.forName(clzUIName).newInstance());
			cboMonth.setUI((ComboBoxUI) Class.forName(clzUIName).newInstance());
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void setLableColor(Color fg, Color bg) {
		for (int i = 0; i < lbls.length; i++) {
			lbls[i].setForeground(fg);
			lbls[i].setBackground(bg);
		}
	}

	public void setIcon(Image icon) {
		button.setIcon(new ImageIcon(icon));
	}

	public int getYear() {
		return this.year;
	}

	public int getMonth() {
		return this.month;
	}

	public int getDateOfWeek() {
		return this.date;
	}

	public String getDateString() {
		Calendar cal = Calendar.getInstance();
		cal.set(this.year, this.month-1, this.date);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(cal.getTime());
	}
	
	public Date getDate(){
		Calendar cal = Calendar.getInstance();
		cal.set(this.year, this.month-1, this.date);
		return cal.getTime();
	}
	
	public void setDate(String date){
		String dates[] = date.split("-");
		this.year = Integer.valueOf(dates[0]);
		this.month = Integer.valueOf(dates[1]);
		this.date = Integer.valueOf(dates[2]);
		updateField();
	}
	
	class SelectListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			for (ELSToggleBtn elsToggleBtn : toggles) {
				elsToggleBtn.setSelected(false);
			}
			((ELSToggleBtn) e.getSource()).setSelected(true);
			date = Integer.parseInt(((ELSToggleBtn) e.getSource())
					.getText().toString());
			dlg.dispose();
			updateField();
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
