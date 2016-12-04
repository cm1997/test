package org.cross.elsclient.ui.counterui.initial;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.ui.component.ELSComfirmDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.AccountVO;
import org.cross.elsclient.vo.VehicleVO;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.NumberType;
import org.cross.elscommon.util.VehicleType;

public class VehicleAddPanel extends ELSInfoPanel{
	ArrayList<VehicleVO> vos;
	VehicleVO vo;
	String number;
	
	public VehicleAddPanel(ArrayList<VehicleVO> vos) {
		super();
		this.vos = vos;
		init();
	}
	
	@Override
	public void init() {
		super.init();
		
		setTitle("新增车辆");
		number = ConstantVal.numberbl.getPostNumber(NumberType.VEHICLE);
		/* 0 */addEditableItem("车辆编号", number, false, "number");
		addEditableItem("车牌号", "", true, InfoType.NAME, "licence");
		addEditableItem("营业厅编号", "",true,InfoType.ORGANIZATION,
				"orgid");
		addDateItem("购买时间", true, "buytime");
		addDateItem("服役时间", true, "lasttime");
		addEditableItem("发动机号", "", true, InfoType.NAME, "enginenum");
		addEditableItem("底盘号", "", true, InfoType.NAME, "basenum");
		
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认添加");
		cancelBtn.setText("取消添加");
		setBackPanel("add");
	}
	
	@Override
	protected void confirm() throws RemoteException {
		super.confirm();
		if(isAllLegal()){
			String cnumber = findItem("number").toString();
			String licence = findItem("licence").toString();
			String orgid = findItem("orgid").toString();
			String buytime = findItem("buytime").toString();
			String lasttime = findItem("lasttime").toString();
			String enginenum = findItem("enginenum").toString();
			String basenum = findItem("basenum").toString();
			
			vo = new VehicleVO(number, licence, orgid, enginenum, basenum, buytime, lasttime, null, false);
			vos.add(vo);
			ConstantVal.numberbl.addone(NumberType.VEHICLE, number);
			((InitialManagePanel)GetPanelUtil.getSubFunctionPanel(this, "initial").getComponent(1)).refresh();
			ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this), "添加成功");
			back();
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
