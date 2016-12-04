package org.cross.elsclient.ui.managerui.personnel;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.text.Position;

import org.cross.elsclient.blservice.personnelblservice.PersonnelBLService;
import org.cross.elsclient.ui.component.ELSComfirmDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.counterui.initial.InitialManagePanel;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.LogUtil;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.DriverVO;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elscommon.po.SalaryPO;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.NumberType;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.SalaryType;
import org.cross.elscommon.util.StringToType;

public class PerAddPanel extends ELSInfoPanel {
	PersonnelVO vo;
	PersonnelBLService personelbl;
	String number;
	
	public PerAddPanel(PersonnelBLService personnelbl) {
		super();
		this.personelbl = personnelbl;
		init();
	}
	
	@Override
	public void init() {
		super.init();
		setTitle("新增人员");
		number = ConstantVal.numberbl.getPostNumber(NumberType.PERSONNEL);
		addEditableItem("人员编号", number, true,"id");
		addEditableItem("姓名", "", true,InfoType.NAME,"name");
		addComboxItem("性别",new String[]{"男","女"} , true,"sex");
		addEditableItem("身份证", "", true,InfoType.IDCARD,"idcard");
		String []position = PositionType.toStrings();
		addEditableItem("所属机构ID", "", true,InfoType.ORGANIZATION,"organ");
		addComboxItem("职位", position, true,"position");
		addDateItem("出生日期", true,"birth");
		addEditableItem("手机", "", true,InfoType.TELEPHONE,"phone");
		
		
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
			
			if(position!=PositionType.DRIVER){
				vo = new PersonnelVO(id, name, position, orgNum, sex, idcard, phone, birthday);
			}else{
				vo = new DriverVO(id, name, position, orgNum, sex, idcard, phone, birthday, new SalaryPO(SalaryType.ADDONCE, ConstantVal.constantbl.show().baseMoneyForDriver, 20, 0, id), null, null);
			}
			if(personelbl.add(vo)==ResultMessage.SUCCESS){
				LogUtil.addLog("新增人员");
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this), "添加成功");
				ConstantVal.numberbl.addone(NumberType.PERSONNEL, number);
				back();
			}else {
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this), "添加失败");
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
