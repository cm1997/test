package org.cross.elsclient.ui.adminui;

import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.util.InfoType;

public class UserInfoPanel extends ELSInfoPanel {
	UserVO vo;
	
	public UserInfoPanel(UserVO vo) {
		this.vo = vo;
		init();
	}
	
	@Override
	public void init() {
		super.init();
		
		setTitle("用户信息");
		addNormalItem("用户名", vo.number);
		addNormalItem("姓名", vo.name);
		addNormalItem("职位", vo.userType.toString());
		addNormalItem("密码", vo.password);
		addNormalItem("所属机构", vo.orgNameID);

		container.packHeight();
	}
	
}
