package org.cross.elsclient.ui.businesshallclerkui.driver;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.personnelblservice.PersonnelBLService;
import org.cross.elsclient.ui.component.ELSComfirmDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.LogUtil;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.DriverVO;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.NumberType;
import org.cross.elscommon.util.ResultMessage;

public class DriverUpdatePanel extends ELSInfoPanel {
	DriverVO vo;
	PersonnelBLService personnelBLService;

	public DriverUpdatePanel(DriverVO vo, PersonnelBLService bl) {
		this.vo = vo;
		this.personnelBLService = bl;
		init();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		String[] it1 = { "男", "女" };

		setTitle("更新司机信息");
		addEditableItem("司机编号", vo.number, false, "number");
		addEditableItem("姓名", vo.name, true, InfoType.NAME, "name");
		addComboxItem("性别", it1, true, "sex");
		addEditableItem("身份证号码", vo.id, true, InfoType.IDCARD, "id");
		addEditableItem("手机", vo.phone, true, InfoType.TELEPHONE, "phone");
		addDateItem("出生日期", true, "birth");
		addDateItem("行驶证开始", true, "licencestart");
		addDateItem("行驶证期限", true, "licencetime");

		addConfirmAndCancelBtn();
		confirmBtn.setText("确认修改");
		cancelBtn.setText("取消修改");
	}

	@Override
	protected void confirm() throws RemoteException {
		if (isAllLegal()) {
			vo.name = findItem("name").toString();
			vo.sex = findItem("sex").toString();
			vo.id = findItem("id").toString();
			vo.phone = findItem("phone").toString();
			vo.birthday = findItem("birth").toString();
			vo.licenceStart = findItem("licencestart").toString();
			vo.licenceEnd = findItem("licencetime").toString();
			if (personnelBLService.update(vo) == ResultMessage.SUCCESS) {
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),
						"修改成功");
				LogUtil.addLog("更新司机");
				back();
			} else {
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),
						"修改失败");
			}
		}
	}

	@Override
	protected void cancel() {
		if (ELSComfirmDialog.showConfirmDlg(GetPanelUtil.getFunctionPanel(this),
				"取消新增", "确认放弃新增单据？")) {
			back();
		}
	}

}
