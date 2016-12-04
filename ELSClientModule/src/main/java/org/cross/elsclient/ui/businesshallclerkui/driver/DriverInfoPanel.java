package org.cross.elsclient.ui.businesshallclerkui.driver;

import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.vo.DriverVO;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elsclient.vo.UserVO;
import org.cross.elsclient.vo.VehicleVO;

public class DriverInfoPanel extends ELSInfoPanel{

	DriverVO vo;
	UserVO user;
	
	public DriverInfoPanel(DriverVO vo, UserVO user) {
		this.vo = vo;
		this.user = user;
		init();
	}
	
	@Override
	public void init() {
		super.init();
		
		setTitle("司机详细信息");
		addNormalItem("司机编号", vo.number);
		addNormalItem("姓名", vo.name);
		addNormalItem("性别", vo.sex);
		addNormalItem("身份证号码", vo.id);
		addNormalItem("手机", vo.phone);
		addNormalItem("出生日期", vo.birthday);
		addNormalItem("行驶证开始", vo.licenceStart);
		addNormalItem("行驶证期限", vo.licenceEnd);
	}
}
