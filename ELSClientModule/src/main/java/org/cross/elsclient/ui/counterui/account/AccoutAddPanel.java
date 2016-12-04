package org.cross.elsclient.ui.counterui.account;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.accountblservice.AccountBLService;
import org.cross.elsclient.ui.component.ELSComfirmDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.LogUtil;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.AccountVO;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.NumberType;
import org.cross.elscommon.util.ResultMessage;

public class AccoutAddPanel extends ELSInfoPanel{
	AccountVO vo;
	AccountBLService bl;
	public AccoutAddPanel(AccountBLService bl) {
		super();
		this.bl = bl;
		init();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		
		setTitle("新增账户");
		addEditableItem("账户名称","", true,InfoType.NAME,"name");
		addEditableItem("账户卡号", "", true,InfoType.NUM,"account");
		addEditableItem("账户余额", "", true,InfoType.NUM,"balance");
		
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认添加");
		cancelBtn.setText("取消添加");
	}
	
	@Override
	protected void confirm() throws RemoteException {
		if(isAllLegal()){
			
			String name = findItem("name").toString();
			String account =findItem("account").toString();
			double balance = Double.valueOf(findItem("balance").toString());
			
			vo = new AccountVO(name, account, balance);
			if(bl.add(vo)==ResultMessage.SUCCESS){
				LogUtil.addLog("新增账户");
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"添加成功");
				back();
			}else{
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"添加失败");
			}
		}
	}
	
	@Override
	protected void cancel() {
		if(ELSComfirmDialog.showConfirmDlg(GetPanelUtil.getFunctionPanel(this), "取消新增", "确认退出新增界面？")){
			back();
		}
	}

}
