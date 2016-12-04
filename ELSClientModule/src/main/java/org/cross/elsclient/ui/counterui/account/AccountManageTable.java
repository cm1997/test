package org.cross.elsclient.ui.counterui.account;

import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import org.cross.elsclient.blservice.accountblservice.AccountBLService;
import org.cross.elsclient.ui.adminui.UserInfoPanel;
import org.cross.elsclient.ui.adminui.UserUpdatePanel;
import org.cross.elsclient.ui.component.ELSManagePanel;
import org.cross.elsclient.ui.component.ELSManageTable;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.LogUtil;
import org.cross.elsclient.vo.AccountVO;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.util.ResultMessage;

public class AccountManageTable extends ELSManageTable{
	ArrayList<AccountVO> vos;
	AccountBLService accountbl;
	
	public AccountManageTable(String[] name, int[] itemWidth,AccountBLService accountbl) {
		super(name, itemWidth);
		this.accountbl = accountbl;
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
	public void addItem(AccountVO vo){
		vos.add(vo);
		DecimalFormat decimalFormat = new DecimalFormat("#");
		String[] item = {vo.name,vo.account,String.valueOf(decimalFormat.format(vo.balance))};
		addItemLabel(item);
		
	}
	
//	@Override
//	public void infoBtn(int index) {
//		super.infoBtn(index);
//		//界面统一添加到功能界面(managePanel的父容器)
//		ELSPanel contentPanel  = GetPanelUtil.getSubFunctionPanel(this, 0);
//		AccountVO vo = vos.get(index);
//		contentPanel.add("info",new Account(vo));
//		contentPanel.cl.show(contentPanel, "info");
//	}
	
	@Override
	public void updateBtn(int index) {
		super.updateBtn(index);
		//界面统一添加到功能界面(managePanel的父容器)
		ELSPanel contentPanel  = GetPanelUtil.getSubFunctionPanel(this, "account");
		
		contentPanel.add("update",new AccountUpdatePanel(vos.get(index), accountbl));
		contentPanel.cl.show(contentPanel, "update");
	}
	
	@Override
	public void deleteBtn(int index) {
		try {
			if(accountbl.delete(vos.get(index).account)==ResultMessage.SUCCESS){
				//从展示层删除该项
				container.remove(itemLabels.get(index));
				itemLabels.remove(index);
				vos.remove(index);
				
				//自适应高度
				packHeight();
				((ELSPanel)getParent()).packHeight();
				
				container.validate();
				container.repaint();
				LogUtil.addLog("删除账户");
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this), "删除成功");
			}else{
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this), "删除失败");
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
