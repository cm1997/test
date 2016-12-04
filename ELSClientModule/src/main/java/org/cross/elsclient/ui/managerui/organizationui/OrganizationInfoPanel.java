package org.cross.elsclient.ui.managerui.organizationui;

import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.vo.OrganizationVO;

public class OrganizationInfoPanel extends ELSInfoPanel{
	OrganizationVO vo;
	
	public OrganizationInfoPanel(OrganizationVO vo){
		this.vo = vo;
		init();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		
		setTitle("机构详细信息");
		addNormalItem("机构编号", vo.number);
		addNormalItem("地区", vo.city.toString());
		addNormalItem("类型", vo.type.toString());
		container.packHeight();
	}
}
