package org.cross.elsclient.ui.managerui.personnel;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.personnelblservice.PersonnelBLService;
import org.cross.elsclient.ui.component.ELSComfirmDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.LogUtil;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;

public class PerUpdatePanel extends ELSInfoPanel{
	PersonnelVO vo;
	PersonnelBLService personelbl;
	
	public PerUpdatePanel(PersonnelVO vo,PersonnelBLService personnelbl) {
		super();
		this.personelbl = personnelbl;
		this.vo = vo;
		init();
	}
	
	@Override
	public void init() {
		super.init();
		
		setTitle("更改人员信息");
		addEditableItem("人员编号", vo.number, false,"id");
		addEditableItem("姓名", vo.name, true,InfoType.NAME,"name");
		addComboxItem("性别",new String[]{"男","女"} , vo.sex,true,"sex");
		addEditableItem("身份证", vo.id, true,InfoType.IDCARD,"idcard");
		String []position = PositionType.toStrings();
		addEditableItem("所属机构ID", vo.orgNum, true,InfoType.ID,"organ");
		addComboxItem("职位", position, vo.position.toString(),true,"position");
		addDateItem("出生日期", true,"birth");
		addEditableItem("手机", vo.phone, true,InfoType.TELEPHONE,"phone");
		
		
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认添加");
		cancelBtn.setText("取消添加");
		setBackPanel("add");
	}
	
	@Override
	protected void confirm() throws RemoteException {
		super.confirm();
		if(isAllLegal()){
			String id = findItem("id").toString();
			String name = findItem("name").toString();
			String sex = findItem("sex").toString();
			String idcard = findItem("idcard").toString();
			String orgNum = findItem("organ").toString();
			PositionType position = StringToType.toPositionType(findItem("position").toString());
			String birthday = findItem("birth").toString();
			String phone = findItem("phone").toString();
			vo.number = id;
			vo.name = name;
			vo.sex = sex;
			vo.id = idcard;
			vo.orgNum = orgNum;
			vo.position = position;
			vo.birthday = birthday;
			vo.phone = phone;
			if(personelbl.update(vo)==ResultMessage.SUCCESS){
				LogUtil.addLog("更新人员");
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this), "修改成功");
				back();
			}else {
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this), "修改失败");
			}
		}
	}
	
	@Override
	protected void cancel() {
		// TODO Auto-generated method stub
		super.cancel();
		if(ELSComfirmDialog.showConfirmDlg(GetPanelUtil.getFunctionPanel(this),
				"取消添加", "确认退出新增界面？")){
			back();
		}
	}
}
