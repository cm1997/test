package org.cross.elsclient.ui.adminui;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.userblservice.UserBLService;
import org.cross.elsclient.ui.component.ELSButton;
import org.cross.elsclient.ui.component.ELSComfirmDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.ComponentFactory;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.LogUtil;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;

public class UserUpdatePanel extends ELSInfoPanel{
	UserVO vo;
	UserBLService userbl;
	
	public UserUpdatePanel(UserVO vo, UserBLService bl) {
		this.vo = vo;
		this.userbl = bl;
		init();
	}
	
	@Override
	public void init() {
		super.init();
		String items[] = {"快递员", "营业厅业务员","中转中心业务员","仓库管理人员","财务人员","高级财务人员","总经理","系统管理员"};
		
		//ELSInfoPanel提供了三种添加条目的类型:文字，编辑框，下拉框
		//要拿到其中的信息，要调用对应的itemLabel.toString()的方法
		setTitle("修改用户");
		addEditableItem("用户名", vo.number, false,"id");
		addEditableItem("姓名", vo.name, true,InfoType.NAME,"name");
		addComboxItem("职位", items,vo.userType.toString(), true,"position");
		addEditableItem("密码", vo.password, true,InfoType.PASSWORD,"password");
		addEditableItem("所属机构", vo.orgNameID, true,InfoType.NAME,"organ");
		//添加确认和取消按钮
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认修改");
		cancelBtn.setText("取消修改");
	}
	
	@Override
	protected void confirm() throws RemoteException {
		
		if(isAllLegal()){
			String id = findItem("id").toString();
			String name = findItem("name").toString();
			String position = findItem("position").toString();
			String password = findItem("password").toString();
			String organ = findItem("organ").toString();
			
			vo.number = id;
			vo.name = name;
			vo.password = password;
			vo.userType = StringToType.toUserType(position);
			vo.orgNameID = organ;
			if(userbl.update(vo)==ResultMessage.SUCCESS){
				LogUtil.addLog("更新用户");
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"更新成功");
				back();
			}else{
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"更新失败");
			}
		}
	}
	
	@Override
	protected void cancel() {
		super.cancel();
		if(ELSComfirmDialog.showConfirmDlg(GetPanelUtil.getFunctionPanel(this), "取消更新", "确认退出更新界面？")){
			back();
		}
	}
}
