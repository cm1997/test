package org.cross.elsclient.ui.managerui.payment;

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
import org.cross.elscommon.util.SalaryType;

public class PaymentUpdatePanel extends ELSInfoPanel{
	PersonnelVO vo;
	PersonnelBLService personelbl;
	SalaryType type;
	
	public PaymentUpdatePanel(PersonnelVO vo,PersonnelBLService personnelbl) {
		super();
		this.personelbl = personnelbl;
		this.vo = vo;
		init();
	}
	
	@Override
	public void init() {
		super.init();
		type = vo.salary.getType();
		
		setTitle("制定薪资策略");
		addEditableItem("人员编号", vo.number, false,"id");
		addEditableItem("姓名", vo.name, false,InfoType.NAME,"name");
		addEditableItem("工资类型", vo.salary.getType().toString(), false,"salaryType");
		addEditableItem("基础工资", vo.salary.getSalaryByMonth()+"", true,InfoType.NUM,"basic");
		switch (type) {
		case ADDONCE:
			addEditableItem("按次金额", vo.salary.getAddOnce()+"", true,InfoType.NUM,"once");
			break;
		case ADDNUM:
			addEditableItem("提成", vo.salary.getAddNum()+"", true,InfoType.NUM,"num");
			break;
		default:
			break;
		}
		
		
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认修改");
		cancelBtn.setText("取消修改");
		setBackPanel("add");
	}
	
	@Override
	protected void confirm() throws RemoteException {
		super.confirm();
		if(isAllLegal()){
			double basic = Double.valueOf(findItem("basic").toString());
			vo.salary.setSalaryByMonth(basic);
			switch (type) {
			case ADDNUM:
				double addnum = Double.valueOf(findItem("num").toString());
				vo.salary.setAddNum(addnum);
				break;
			case ADDONCE:
				double addonce = Double.valueOf(findItem("once").toString());
				vo.salary.setAddOnce(addonce);
				break;
			default:
				break;
			}
			if(personelbl.update(vo)==ResultMessage.SUCCESS){
				LogUtil.addLog("制定薪资策略");
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
