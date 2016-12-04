package org.cross.elsclient.ui.businesshallclerkui.vehicle;

import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.vo.UserVO;
import org.cross.elsclient.vo.VehicleVO;

public class VehicleInfoPanel extends ELSInfoPanel {
	VehicleVO vo;
	
	public VehicleInfoPanel(VehicleVO vo) {
		this.vo = vo;
		init();
	}
	
	@Override
	public void init() {
		super.init();
		
		setTitle("车辆详细信息");
		addNormalItem("车牌编号", vo.number);
		addNormalItem("车牌号", vo.licence);
		addNormalItem("营业厅编号", UIConstant.CURRENT_USER.orgNameID);
		addNormalItem("购买时间", vo.buyTime);
		addNormalItem("服役时间", vo.buyTime+"~"+vo.lastTime);
		addNormalItem("发动机号", vo.engineNumber);
		addNormalItem("底盘号", vo.baseNumber);
		
		container.packHeight();
	}
	
}
