package org.cross.elsclient.ui.managerui.organizationui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.Box;

import org.cross.elsclient.blservice.organizationblservice.OrganizationBLService;
import org.cross.elsclient.ui.adminui.UserInfoPanel;
import org.cross.elsclient.ui.adminui.UserUpdatePanel;
import org.cross.elsclient.ui.component.ELSButton;
import org.cross.elsclient.ui.component.ELSManageTable;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.ComponentFactory;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.LogUtil;
import org.cross.elsclient.vo.OrganizationVO;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.util.ResultMessage;

public class OrganizationManageTable extends ELSManageTable {
	OrganizationBLService organizationbl;
	ArrayList<OrganizationVO> vos;
	
	public OrganizationManageTable(String[] name, int[] itemWidth,OrganizationBLService organizationbl) {
		super(name, itemWidth);
		this.organizationbl = organizationbl;
		init();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		isUpdateAndDelete = true;
		vos = new ArrayList<>();
	}
	
	public void addItem(OrganizationVO vo){
		vos.add(vo);
		
		String[] item = {vo.number,vo.city.toString(),vo.type.toString()};
		addItemLabel(item);
	}
	
	@Override
	public void infoBtn(int index) {
		super.infoBtn(index);
		//界面统一添加到功能界面(managePanel的父容器)
		ELSPanel contentPanel  = GetPanelUtil.getSubFunctionPanel(this, "organization");
		OrganizationVO vo = vos.get(index);
		contentPanel.add("info",new OrganizationInfoPanel(vo));
		contentPanel.cl.show(contentPanel, "info");
	}
	
	@Override
	public void updateBtn(int index) {
		super.updateBtn(index);
		//界面统一添加到功能界面(managePanel的父容器)
		ELSPanel contentPanel  = GetPanelUtil.getSubFunctionPanel(this, "organization");
		
		contentPanel.add("update",new OrganizationUpdatePanel(vos.get(index),organizationbl));
		contentPanel.cl.show(contentPanel, "update");
	}
	
	@Override
	public void deleteBtn(int index) {
		try {
			if(organizationbl.delete(vos.get(index).number)==ResultMessage.SUCCESS){
				//从展示层删除该项
				container.remove(itemLabels.get(index));
				itemLabels.remove(index);
				vos.remove(index);
				
				//自适应高度
				packHeight();
				((ELSPanel)getParent()).packHeight();
				
				container.validate();
				container.repaint();
				LogUtil.addLog("删除机构");
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this), "删除成功");
			}else{
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this), "删除失败");
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
