package org.cross.elsclient.ui.counterui.account;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.accountblservice.AccountBLService;
import org.cross.elsclient.ui.component.ELSComfirmDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.LogUtil;
import org.cross.elsclient.vo.AccountVO;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.ResultMessage;

public class AccountUpdatePanel extends ELSInfoPanel{
	AccountVO vo;
	AccountBLService bl;
	
	public AccountUpdatePanel(AccountVO vo,AccountBLService bl) {
		super();
		this.vo = vo;
		this.bl = bl;
		init();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		
		setTitle("修改账户");
		addEditableItem("账户名称", vo.name, true,InfoType.NAME,"name");
		addEditableItem("账户卡号", vo.account, false,"account");
//		addEditableItem("账户余额", String.valueOf(vo.balance), true,InfoType.NUM);
		addEditableItem("账户余额", String.valueOf(vo.balance), false,"balance");
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认修改");
		cancelBtn.setText("取消修改");
	}
	
	@Override
	protected void confirm() throws RemoteException {
		if(isAllLegal()){
			String name = findItem("name").toString();
			String account =findItem("account").toString();
			double balance = Double.valueOf(findItem("balance").toString());
			
			vo.name = name;
			vo.account = account;
			vo.balance = balance;
			
			if(bl.update(vo)==ResultMessage.SUCCESS){
				LogUtil.addLog("更新账户");
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"修改成功");
				back();
			}else{
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"修改失败");
			}
		}
	}
	
	@Override
	protected void cancel() {
		if(ELSComfirmDialog.showConfirmDlg(GetPanelUtil.getFunctionPanel(this), "取消修改", "确认退出修改界面？")){
			back();
		}
	}
}
