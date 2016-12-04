package org.cross.elsclient.ui.adminui;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.userblservice.UserBLService;
import org.cross.elsclient.ui.component.ELSDatePicker;
import org.cross.elsclient.ui.component.ELSComfirmDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.LogUtil;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.NumberType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;

public class UserAddPanel extends ELSInfoPanel{
	UserVO vo;
	UserBLService bl;
	String getone;
	
	public UserAddPanel(UserBLService bl) {
		this.bl = bl;
		init();
	}
	
	@Override
	public void init() {
		super.init();
		
		//ELSInfoPanel提供了三种添加条目的类型:文字，编辑框，下拉框
		//要拿到其中的信息，要调用对应的itemLabel.toString()的方法
		setTitle("新增用户");
		getone = ConstantVal.getNumber().getPostNumber(NumberType.USER);
		addEditableItem("用户名",getone , false,"id");
		addChangeItem("姓名","", true,InfoType.NAME,"name");
		String items[] = {"快递员", "营业厅业务员","中转中心业务员","仓库管理人员","财务人员","高级财务人员","总经理","系统管理员"};
		addComboxItem("职位", items, true,"position");
		addEditableItem("密码", "", true,InfoType.PASSWORD,"password");
		addEditableItem("所属机构", "", true,InfoType.NAME,"organ");
		
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认添加");
		cancelBtn.setText("取消添加");
		
	}
	
	@Override
	protected void confirm() throws RemoteException {
		if(isAllLegal()){
			String id = findItem("id").toString();
			String name = findItem("name").toString();
			String position = findItem("position").toString();
			String password = findItem("password").toString();
			String organ = findItem("organ").toString();
			
			vo = new UserVO(id, password, name, StringToType.toUserType(position), organ);
			if(bl.add(vo)==ResultMessage.SUCCESS){
				ConstantVal.numberbl.addone(NumberType.USER, getone);
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"添加成功");
				LogUtil.addLog("新增用户");
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
