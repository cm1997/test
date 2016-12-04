package org.cross.elsclient.ui.adminui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import org.cross.elsclient.blservice.userblservice.UserBLService;
import org.cross.elsclient.ui.component.ELSButton;
import org.cross.elsclient.ui.component.ELSManageTable;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.ComponentFactory;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.LogUtil;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.util.ResultMessage;

public class UserManageTable extends ELSManageTable{
	UserBLService userbl;
	ArrayList<UserVO> vos;
	
	public UserManageTable(){
		super();
	}
	
	public UserManageTable(String[] name, int[] itemWidth,UserBLService userbl) {
		super(name, itemWidth);
		this.userbl = userbl;
		init();
	}
	
	@Override
	public void init() {
		super.init();
		vos = new ArrayList<>();
		//如需要条目拥有删除修改按钮，则把isUpdateAndDelete设为true
		isUpdateAndDelete = true;
	}
	
	
	/**
	 * 添加具体vo条目
	 * @para vo
	 * @return void
	 */
	public void addItem(UserVO vo){
		vos.add(vo);
		System.out.println("h");
		System.out.println(vo.number);
		System.out.println(vo.name);
		System.out.println(vo.userType);
		String[] item = {vo.number,vo.name,vo.userType.toString()};
		addItemLabel(item);
		
	}
	
	@Override
	public void infoBtn(int index) {
		super.infoBtn(index);
		//界面统一添加到功能界面(managePanel的父容器)
		ELSPanel contentPanel  = GetPanelUtil.getSubFunctionPanel(this, "user");
		UserVO vo = vos.get(index);
		contentPanel.add("info",new UserInfoPanel(vo));
		contentPanel.cl.show(contentPanel, "info");
	}
	
	@Override
	public void updateBtn(int index) {
		super.updateBtn(index);
		//界面统一添加到功能界面(managePanel的父容器)
		ELSPanel contentPanel  = GetPanelUtil.getSubFunctionPanel(this, "user");
		
		contentPanel.add("update",new UserUpdatePanel(vos.get(index),userbl));
		contentPanel.cl.show(contentPanel, "update");
	}
	
	@Override
	public void deleteBtn(int index) {
		try {
			if(userbl.delete(vos.get(index).number)==ResultMessage.SUCCESS){
				//从展示层删除该项
				container.remove(itemLabels.get(index));
				itemLabels.remove(index);
				vos.remove(index);
				
				//自适应高度
				packHeight();
				((ELSPanel)getParent()).packHeight();
				
				container.validate();
				container.repaint();
				LogUtil.addLog("删除用户");
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this), "删除成功");
			}else{
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this), "删除失败");
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
