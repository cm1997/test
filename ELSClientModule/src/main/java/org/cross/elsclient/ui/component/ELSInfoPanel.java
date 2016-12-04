package org.cross.elsclient.ui.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.print.DocFlavor.INPUT_STREAM;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeListener;

import org.cross.elsclient.blimpl.blfactoryimpl.BLFactoryImpl;
import org.cross.elsclient.blimpl.numberblimpl.NumberBLImpl;
import org.cross.elsclient.blservice.blfactoryservice.BLFactoryService;
import org.cross.elsclient.blservice.numberblservice.NumberBLService;
import org.cross.elsclient.blservice.numberblservice.NumberBLService_Stub;
import org.cross.elsclient.ui.util.ComponentFactory;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.InfoFormatUtil;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elscommon.util.InfoType;

public class ELSInfoPanel extends ELSScrollPane {
	protected ELSPanel container;
	protected TitlePanel titlePanel;
	protected ELSBox infoPanel;
	protected ArrayList<InfoItemLabel> itemLabels;
	protected ArrayList<InfoItemLabel> extraLabels;
	protected int itemHeight;
	protected String backName;
	protected ELSButton confirmBtn;
	protected ELSButton cancelBtn;
	protected ELSBox btnBox;
	protected NumberBLService numberbl;

	@Override
	public void init() {
		itemHeight = 50;
		itemLabels = new ArrayList<>();
		extraLabels = new ArrayList<>();
		numberbl = new NumberBLService_Stub();

		container = new ELSPanel();
		titlePanel = new TitlePanel();
		infoPanel = new ELSBox(BoxLayout.Y_AXIS);
		confirmBtn = ComponentFactory.createConfirmBtn();
		cancelBtn = ComponentFactory.createCancelBtn();

		setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		setSize(UIConstant.CONTENTPANEL_WIDTH
				+ UIConstant.CONTENTPANEL_MARGIN_LEFT * 2,
				UIConstant.CONTENTPANEL_HEIGHT
						+ UIConstant.CONTENTPANEL_MARGIN_TOP * 2);
		setOpaque(false);

		container.setPreferredSize(new Dimension(
				UIConstant.CONTENTPANEL_WIDTH
				+ UIConstant.CONTENTPANEL_MARGIN_LEFT * 2,
				UIConstant.CONTENTPANEL_HEIGHT
				+ UIConstant.CONTENTPANEL_MARGIN_TOP * 2));
		container.setLayout(null);
		container.setBackground(Color.white);
		container.setOpaque(false);

		titlePanel.init("Title");
		titlePanel.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT, UIConstant.CONTENTPANEL_MARGIN_TOP);
		titlePanel.titleLabel.setFont(getFont().deriveFont(18f));
		titlePanel.backBtn.addMouseListener(new BtnListener());

		infoPanel.setSize(getWidth(), 20);
		infoPanel.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT, 70);

		container.add(titlePanel);
		container.add(infoPanel);

		this.getViewport().add(container);
		this.getViewport().setOpaque(false);
	}

	/**
	 * 添加不需编辑的条目
	 * 
	 * @para name-条目名, content-条目内容
	 * @return void
	 */
	public void addNormalItem(String name, String content) {
		InfoItemLabel itemLabel = new InfoItemLabel();
		itemLabel.initNormal(name, content);
		itemLabel.setName("");
		itemLabels.add(itemLabel);
//		contentLabels.add(contentLabel);
		infoPanel.setSize(infoPanel.getWidth(), infoPanel.getHeight()
				+ itemHeight);
		infoPanel.add(itemLabel);
	}

	/**
	 * 添加可编辑的输入条目
	 * 
	 * @para name-条目名, defaultValue-默认值, isEditable-是否可编辑
	 * @return void
	 */
	public void addEditableItem(String name, String defaultValue,
			boolean isEditable,String itemName) {
		InfoItemLabel itemLabel = new InfoItemLabel();
		itemLabel.initEditable(name, defaultValue, isEditable);;
		itemLabel.setName(itemName);

		itemLabels.add(itemLabel);
//		inputLabels.add(inputLabel);

		infoPanel.setSize(infoPanel.getWidth(), infoPanel.getHeight()
				+ itemHeight);
		infoPanel.add(itemLabel);
	}

	/**
	 * 添加可编辑的输入条目
	 * 
	 * @para name-条目名, defaultValue-默认值, isEditable-是否可编辑, type-信息类型(不需判断则为null)
	 * @return void
	 */
	public InfoItemLabel addEditableItem(String name, String defaultValue,
			boolean isEditable, InfoType type,String itemName) {
		InfoItemLabel itemLabel = new InfoItemLabel();
		itemLabel.initEditable(name, defaultValue, isEditable,type);;
		itemLabel.setName(itemName);
		itemLabels.add(itemLabel);
//		inputLabels.add(inputLabel);

		infoPanel.setSize(infoPanel.getWidth(), infoPanel.getHeight()
				+ itemHeight);
		infoPanel.add(itemLabel);
		return itemLabel;
	}

	/**
	 * 添加下拉框条目
	 * 
	 * @para name-条目名, items-下拉框内容, isEditable-是否可编辑
	 * @return void
	 */
	public void addComboxItem(String name, String[] items, boolean isEditable,String itemName) {
		InfoItemLabel itemLabel = new InfoItemLabel();
		itemLabel.initBox(name, items, isEditable);
		itemLabel.setName(itemName);
		itemLabels.add(itemLabel);

		infoPanel.setSize(infoPanel.getWidth(), infoPanel.getHeight()
				+ itemHeight);
		infoPanel.add(itemLabel);
	}
	
	public void addComboxItem(String name, String[] items,String defaultValue, boolean isEditable,String itemName) {
		InfoItemLabel itemLabel = new InfoItemLabel();
		itemLabel.initBox(name, items,defaultValue, isEditable);
		itemLabel.setName(itemName);
		itemLabels.add(itemLabel);

		infoPanel.setSize(infoPanel.getWidth(), infoPanel.getHeight()
				+ itemHeight);
		infoPanel.add(itemLabel);
	}
	
	public void addAutoItem(String name, String defaultValue,
			boolean isEditable,InfoType type,String itemName){
		InfoItemLabel itemLabel = new InfoItemLabel();
		itemLabel.initAuto(name, defaultValue, isEditable,type);
		itemLabel.setName(itemName);
		itemLabels.add(itemLabel);
		itemLabel.inputLabel.addFocusListener(new AutoListener(itemLabel));;

		infoPanel.setSize(infoPanel.getWidth(), infoPanel.getHeight()
				+ itemHeight);
		infoPanel.add(itemLabel);
	}
	
	public void addAutoItem(String name, String[] items,String defaultValue, boolean isEditable,String itemName){
		addComboxItem(name, items, defaultValue, isEditable, itemName);
		itemLabels.get(itemLabels.size()-1).addFocusListener(new AutoListener(itemLabels.get(itemLabels.size()-1)));
	}
	
	public void addChangeItem(String name, String defaultValue,
			boolean isEditable,InfoType type,String itemName){
		InfoItemLabel label = addEditableItem(name, defaultValue, isEditable, type,itemName);
		ELSButton btn = ComponentFactory.createPlusBtn();
		btn.addMouseListener(new ChangeBtnListener(label, btn));
		btn.setName("add");
		label.add(btn,3);
		extraLabels.add(label);
	}
	
	/**
	 * 添加日期条目
	 * @para name-条目名, isEditable-是否可编辑
	 * @return void
	 */
	public void addDateItem(String name, boolean isEditable,String itemName) {
		InfoItemLabel itemLabel = new InfoItemLabel();
		itemLabel.initDatePicker(name, isEditable);
		itemLabel.setName(itemName);
		itemLabels.add(itemLabel);

		infoPanel.setSize(infoPanel.getWidth(), infoPanel.getHeight()
				+ itemHeight);
		infoPanel.add(itemLabel);
	}

	/**
	 * 添加确认与取消按钮，一般单纯展示信息的界面不需调用此方法
	 * 
	 * @para
	 * @return void
	 */
	public void addConfirmAndCancelBtn() {
		ELSLabel itemLabel = new ELSLabel();

		itemLabel.setLayout(new BoxLayout(itemLabel, BoxLayout.X_AXIS));
		itemLabel
				.setMaximumSize(new Dimension(infoPanel.getWidth(), itemHeight));
		itemLabel
				.setMinimumSize(new Dimension(infoPanel.getWidth(), itemHeight));
		// itemLabel.setOpaque(true);
		// itemLabel.setBackground(Color.white);

		confirmBtn.setPreferredSize(new Dimension(141, UIConstant.MANAGETABLE_ITEM_HEIGHT));
		confirmBtn.setMaximumSize(new Dimension(141,  UIConstant.MANAGETABLE_ITEM_HEIGHT));
		confirmBtn.setMinimumSize(new Dimension(141,  UIConstant.MANAGETABLE_ITEM_HEIGHT));
		confirmBtn.addMouseListener(new BtnListener());
		confirmBtn.setColor(UIConstant.COMFIRM_BTN_COLOR);

		cancelBtn.setPreferredSize(new Dimension(141, UIConstant.MANAGETABLE_ITEM_HEIGHT));
		cancelBtn.setMaximumSize(new Dimension(141,  UIConstant.MANAGETABLE_ITEM_HEIGHT));
		cancelBtn.setMinimumSize(new Dimension(141,  UIConstant.MANAGETABLE_ITEM_HEIGHT));
		cancelBtn.addMouseListener(new BtnListener());
		cancelBtn.setColor(UIConstant.NORMAL_BTN_COLOR);
		
		itemLabel.add(Box.createHorizontalStrut(8));
		itemLabel.add(confirmBtn);
		itemLabel.add(Box.createHorizontalStrut(8));
		itemLabel.add(cancelBtn);

		infoPanel.setSize(infoPanel.getWidth(), infoPanel.getHeight()
				+ itemHeight * 2);
		infoPanel.add(Box.createVerticalStrut(itemHeight));
		infoPanel.add(itemLabel);
	}

	/**
	 * 设置界面标题
	 * 
	 * @para
	 * @return void
	 */
	public void setTitle(String title) {
		titlePanel.titleLabel.setText(title);
	}

	/**
	 * 设置返回的界面
	 * 
	 * @para name-界面的名称
	 * @return void
	 */
	public void setBackPanel(String name) {
		backName = name;
	}

	/**
	 * 执行返回界面
	 * 
	 * @para
	 * @return void
	 */
	public void back() {
		ELSPanel parent = (ELSPanel) getParent();
		Component cs[] = parent.getComponents();
		for (Component component : cs) {
			if(component instanceof ELSPanel){
				((ELSPanel)component).init();
			} else if(component instanceof ELSScrollPane){
				((ELSScrollPane)component).init();
			}
		}
		if (backName == null) {
			parent.cl.first(parent);
		} else {
			parent.cl.show(parent, backName);
		}
		parent.remove(ELSInfoPanel.this);
		
	}

	/**
	 * 返回是否含有非法信息的值
	 * @para 
	 * @return void
	 */
	public boolean isAllLegal(){
		boolean result = true;
		for (InfoItemLabel infoItemLabel : itemLabels) {
			if(!infoItemLabel.check()){
				result = false;
			}
		}
		return result;
	}
	
	/**
	 * 执行确认按钮的方法，若是执行了addConfirmAndCancelBtn(),需要重写这一方法
	 * 
	 * @para
	 * @return void
	 */
	protected void confirm() throws RemoteException {

	}

	/**
	 * 执行取消按钮的方法，若是执行了addConfirmAndCancelBtn(),需要重写这一方法
	 * 
	 * @para
	 * @return void
	 */
	protected void cancel() {}
	
	/**
	 * 自动生成item失去焦点是调用的方法
	 * @para text-该item的内容
	 * @return void
	 */
	public void auto(String text){}
	
	public InfoItemLabel findItem(String name){
		for (InfoItemLabel infoItemLabel : itemLabels) {
			if(infoItemLabel.getName().equals(name)){
				return infoItemLabel;
			}
		}
		return null;
	}
	
	
	class AutoListener implements FocusListener{
		InfoItemLabel label;
		
		public AutoListener(InfoItemLabel label) {
			this.label = label;
		}
		@Override
		public void focusGained(FocusEvent e) {}

		@Override
		public void focusLost(FocusEvent e) {
			if(label.checkFormat()){
				auto(label.toString());
				for (InfoItemLabel infoItemLabel : itemLabels) {
					infoItemLabel.validate();
				}
			}
		}
		
	}

	class BtnListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == titlePanel.backBtn) {
				repaint();
				if (ELSComfirmDialog.showConfirmDlg(
						GetPanelUtil.getMainFrame(ELSInfoPanel.this), "退出",
						"确认退出？")) {
					back();
				}
			} else if (e.getSource() == confirmBtn) {
				try {
					confirm();
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			} else if (e.getSource() == cancelBtn) {
				cancel();
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}

	}

	/**
	 * 动态添加删除条目的监听类
	 * @author Moo
	 * @date 2015年12月25日
	 */
	class ChangeBtnListener implements MouseListener{
		InfoItemLabel label;
		ELSButton btn;
		
		public ChangeBtnListener(InfoItemLabel label, ELSButton btn) {
			super();
			this.label = label;
			this.btn = btn;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if(btn.getName().equals("add")){
				InfoItemLabel newLabel = new InfoItemLabel();
				newLabel.initEditable("", "", true,label.infoType);
				newLabel.setName("extra");
				ELSButton delBtn = ComponentFactory.createMinusBtn();
				newLabel.add(delBtn,3);
				delBtn.addMouseListener(new ChangeBtnListener(newLabel, delBtn));
				delBtn.setName("del");
				itemLabels.add(itemLabels.indexOf(label)+1, newLabel);
				extraLabels.add(newLabel);
				infoPanel.setSize(infoPanel.getWidth(), infoPanel.getHeight()
						+ itemHeight);
				infoPanel.add(newLabel,itemLabels.indexOf(label)+1);
				infoPanel.validate();
				container.packHeight();
			}else if(btn.getName().equals("del")){
				infoPanel.remove(label);
				itemLabels.remove(label);
				extraLabels.remove(label);
				infoPanel.setSize(infoPanel.getWidth(), infoPanel.getHeight()
						- itemHeight);
				infoPanel.validate();
				container.packHeight();
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}
	}

}
