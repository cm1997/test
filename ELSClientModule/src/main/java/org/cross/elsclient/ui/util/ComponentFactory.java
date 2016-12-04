package org.cross.elsclient.ui.util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;

import org.cross.elsclient.ui.MainUI;
import org.cross.elsclient.ui.component.ELSButton;
import org.cross.elsclient.ui.component.ELSComboBox;
import org.cross.elsclient.ui.component.ELSDatePicker;
import org.cross.elsclient.ui.component.ELSComfirmDialog;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.component.ELSSettingDialog;
import org.cross.elsclient.ui.component.ELSTextField;
import org.cross.elsclient.ui.component.FunctionBtn;

public class ComponentFactory {

	/**
	 * 创建功能选择按钮
	 * 
	 * @para
	 * @return ELSButton
	 */
	public static ELSButton createFunctionBtn() {
		return new FunctionBtn();
	}

	/**
	 * 创建信息展示界面返回按钮
	 * 
	 * @para
	 * @return ELSButton
	 */
	public static ELSButton createInfoBackBtn() {
		ELSButton btn = new ELSButton();
		btn.setOpaque(false);
		btn.setIcon(Images.BACK_IMAGEICON);
		btn.setFocusable(false);
		btn.setName("back");

		return btn;
	}

	/**
	 * 创建信息展示界面确认按钮
	 * 
	 * @para
	 * @return ELSButton
	 */
	public static ELSButton createConfirmBtn() {
		ELSButton btn = new ELSButton();
		btn.setColor(UIConstant.COMFIRM_BTN_COLOR);

		return btn;
	}
	
	

	/**
	 * 创建信息展示界面取消按钮
	 * 
	 * @para
	 * @return ELSButton
	 */
	public static ELSButton createCancelBtn() {
		ELSButton btn = new ELSButton();
		btn.setColor(UIConstant.NORMAL_BTN_COLOR);

		return btn;
	}

	/**
	 * 创建管理表界面修改按钮
	 * 
	 * @para
	 * @return ELSButton
	 */
	public static ELSButton createUpdateBtn() {
		ELSButton updateBtn = new ELSButton();
		updateBtn.setOpaque(false);
		updateBtn.setFocusable(false);
		updateBtn.setIcon(Images.UPDATE_IMAGEICON);
		updateBtn.setPreferredSize(new Dimension(30, 30));
		updateBtn.setMaximumSize(new Dimension(30, 30));
		updateBtn.setMinimumSize(new Dimension(30, 30));
		updateBtn.setName("update");
		return updateBtn;
	}

	/**
	 * 创建管理表界面删除按钮
	 * 
	 * @para
	 * @return ELSButton
	 */
	public static ELSButton createDeleteBtn() {
		ELSButton deleteBtn = new ELSButton();
		deleteBtn.setOpaque(false);
		deleteBtn.setFocusable(false);
		deleteBtn.setIcon(Images.DELETE_IMAGEICON);
		deleteBtn.setPreferredSize(new Dimension(30, 30));
		deleteBtn.setMaximumSize(new Dimension(30, 30));
		deleteBtn.setMinimumSize(new Dimension(30, 30));
		deleteBtn.setName("delete");
		return deleteBtn;
	}

	/**
	 * 创建搜索栏搜索框
	 * 
	 * @para
	 * @return ELSButton
	 */
	public static ELSTextField createSearchTextField() {
		ELSTextField searchTextField = new ELSTextField();

		searchTextField.setPreferredSize(new Dimension(300,
				UIConstant.SEARCHPANEL_HEIGHT));
		// searchTextField.setMaximumSize(new Dimension(50,
		// searchPanel.getHeight()));
		searchTextField.setMinimumSize(new Dimension(200,
				UIConstant.SEARCHPANEL_HEIGHT));

		return searchTextField;
	}

	/**
	 * 创建搜索栏日历控件
	 * 
	 * @para
	 * @return ELSButton
	 */
	public static ELSDatePicker createDatePicker() {
		ELSDatePicker datePicker = new ELSDatePicker();
		datePicker.setMaximumSize(new Dimension(200,
				UIConstant.SEARCHPANEL_HEIGHT));
		datePicker.setMinimumSize(new Dimension(150,
				UIConstant.SEARCHPANEL_HEIGHT));
		return datePicker;
	}

	/**
	 * 创建搜索栏下拉框
	 * 
	 * @para
	 * @return ELSButton
	 */
	public static ELSComboBox createSearchBox() {
		ELSComboBox box = new ELSComboBox();
		// box.setMaximumSize(new Dimension(200,
		// UIConstant.SEARCHPANEL_HEIGHT));
		box.setMinimumSize(new Dimension(200, UIConstant.SEARCHPANEL_HEIGHT));
		return box;
	}

	/**
	 * 创建搜索栏按钮
	 * 
	 * @para
	 * @return ELSButton
	 */
	public static ELSButton createSearchBtn() {
		ELSButton btn = new ELSButton();
		btn.setPreferredSize(new Dimension(150, UIConstant.SEARCHPANEL_HEIGHT));
		btn.setMaximumSize(new Dimension(200, UIConstant.SEARCHPANEL_HEIGHT));
		btn.setMinimumSize(new Dimension(100, UIConstant.SEARCHPANEL_HEIGHT));
		btn.setColor(UIConstant.NORMAL_BTN_COLOR);
		return btn;
	}
	
	public static ELSButton createPlusBtn() {
		ELSButton btn = new ELSButton();
		btn.setOpaque(false);
		btn.setSize(30, 30);
		btn.setPreferredSize(new Dimension(30, 30));
		btn.setMaximumSize(new Dimension(30, 30));
		btn.setMinimumSize(new Dimension(30, 30));
		btn.setIcon(Images.ADD_IMAGEICON);
		return btn;
	}
	
	public static ELSButton createMinusBtn() {
		ELSButton btn = new ELSButton();
		btn.setOpaque(false);
		btn.setSize(30, 30);
		btn.setPreferredSize(new Dimension(30, 30));
		btn.setMaximumSize(new Dimension(30, 30));
		btn.setMinimumSize(new Dimension(30, 30));
		btn.setIcon(Images.MINUS_IMAGEICON);
		return btn;
	}

	public static ELSButton createWindowMinusBtn() {
		ELSButton btn = new ELSButton();
		btn.setOpaque(false);
		btn.setSize(20, 20);
		btn.setIcon(Images.WINDOW_MINUS_IMAGEICON);
		btn.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				MainUI.FRAME.setExtendedState(JFrame.ICONIFIED);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});

		return btn;
	}

	public static ELSButton createExitBtn(boolean isShowDialog) {
		ELSButton btn = new ELSButton();
		btn.setOpaque(false);
		btn.setSize(20, 20);
		btn.setName("exit");
		btn.setIcon(Images.EXIT_IMAGEICON);
		btn.addMouseListener(new BtnListener(isShowDialog, btn));
		return btn;
	}
	
	public static ELSButton createExportBtn(){
		ELSButton btn = new ELSButton();
		btn.setOpaque(false);
		btn.setIcon(Images.EXPORT_IMAGEICON);
		btn.setPreferredSize(new Dimension(30,30));
		btn.setMaximumSize(new Dimension(30,30));
		btn.setMinimumSize(new Dimension(30,30));
		btn.setName("export");
		btn.addMouseListener(new BtnListener(true, btn));
		return btn;
	}
	
	public static ELSButton createSettingBtn(){
		ELSButton btn = new ELSButton();
		btn.setOpaque(false);
		btn.setSize(60,25);
		btn.setText("设置");
		btn.setFont(UIConstant.MainFont.deriveFont(18f));
		btn.setName("setting");
		btn.addMouseListener(new BtnListener(true, btn));
		return btn;
	}

	public static ELSButton createInitialAddBtn() {
		ELSButton addBtn = new ELSButton();
		addBtn.setOpaque(false);
		addBtn.setFocusable(false);
		addBtn.setIcon(Images.ADD_IMAGEICON);
		addBtn.setPreferredSize(new Dimension(30, 30));
		addBtn.setMaximumSize(new Dimension(30, 30));
		addBtn.setMinimumSize(new Dimension(30, 30));
		return addBtn;
	}
	
	
}
class BtnListener implements MouseListener{
	boolean isShow;
	ELSButton btn;
	public BtnListener(boolean isShow, ELSButton btn) {
		super();
		this.isShow = isShow;
		this.btn = btn;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(btn.getName().equals("exit")){
			if(isShow){
				if (ELSComfirmDialog.showConfirmDlg(((JComponent) e.getSource())
						.getParent().getParent(), "退出系统", "确认退出ELS物流管理系统？","退出","注销")) {
					System.exit(0);
				}else{
					ELSPanel parent = (ELSPanel)GetPanelUtil.getFunctionPanel(btn).getParent();
					parent.cl.show(parent, "login");
					parent.remove((ELSPanel)GetPanelUtil.getFunctionPanel(btn));
				}
			}else{
				System.exit(0);
			}
		}else if(btn.getName().equals("export")){
			
		}else if(btn.getName().equals("setting")){
			ELSSettingDialog.showDialog(btn.getParent());
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}
	
}
