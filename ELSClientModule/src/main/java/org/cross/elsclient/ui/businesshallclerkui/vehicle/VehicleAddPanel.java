package org.cross.elsclient.ui.businesshallclerkui.vehicle;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.vehicleblservice.VehicleBLService;
import org.cross.elsclient.ui.component.ELSComfirmDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.LogUtil;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.VehicleVO;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.NumberType;
import org.cross.elscommon.util.ResultMessage;

public class VehicleAddPanel extends ELSInfoPanel {
	VehicleBLService vehiclebl;
	VehicleVO vo;
	String number;

	public VehicleAddPanel(VehicleBLService bl) {
		this.vehiclebl = bl;
		init();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();

		number = ConstantVal.numberbl.getPostNumber(NumberType.VEHICLE);
		setTitle("新增车辆信息");
		/* 0 */addEditableItem("车辆编号", number, false, "number");
		addEditableItem("车牌号", "", true, InfoType.NAME, "licence");
		addEditableItem("营业厅编号", UIConstant.CURRENT_USER.orgNameID, false,
				"orgid");
		addDateItem("购买时间", true, "buytime");
		addDateItem("服役时间", true, "lasttime");
		addEditableItem("发动机号", "", true, InfoType.NAME, "enginenum");
		addEditableItem("底盘号", "", true, InfoType.NAME, "basenum");

		addConfirmAndCancelBtn();
		confirmBtn.setText("确认添加");
		cancelBtn.setText("取消添加");

		container.packHeight();
	}

	@Override
	protected void confirm() throws RemoteException {
		if (isAllLegal()) {
			String cnumber = findItem("number").toString();
			String licence = findItem("licence").toString();
			String orgid = findItem("orgid").toString();
			String buytime = findItem("buytime").toString();
			String lasttime = findItem("lasttime").toString();
			String enginenum = findItem("enginenum").toString();
			String basenum = findItem("basenum").toString();
			vo = new VehicleVO(cnumber, licence, orgid, enginenum, basenum,
					buytime, lasttime,
					null, false);
			if (vehiclebl.add(vo) == ResultMessage.SUCCESS) {
				LogUtil.addLog("新增车辆");
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),
						"添加成功");
				ConstantVal.numberbl.addone(NumberType.VEHICLE, number);
				back();
			} else {
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),
						"添加失败");
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
