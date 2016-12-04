package org.cross.elsclient.ui.managerui.personnel;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blservice.personnelblservice.PersonnelBLService;
import org.cross.elsclient.ui.component.ELSComfirmDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.counterui.initial.InitialManagePanel;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.PositionType;

public class PerInfoPanel extends ELSInfoPanel {
	PersonnelVO vo;
	
	public PerInfoPanel(PersonnelVO vo) {
		super();
		this.vo = vo;
		init();
	}
	
	@Override
	public void init() {
		super.init();
		
		setTitle("人员信息");
		addNormalItem("人员编号",vo.number);
		addNormalItem("姓名", vo.name);
		addNormalItem("性别", vo.sex);
		addNormalItem("身份证",vo.id);
		addNormalItem("所属机构ID", vo.orgNum);
		addNormalItem("职位", vo.position.toString());
		addNormalItem("出生日期", vo.birthday);
		addNormalItem("手机号码", vo.phone);
	}
}
