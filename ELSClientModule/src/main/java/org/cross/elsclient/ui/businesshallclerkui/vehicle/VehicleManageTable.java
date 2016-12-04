package org.cross.elsclient.ui.businesshallclerkui.vehicle;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.Box;

import org.cross.elsclient.blservice.vehicleblservice.VehicleBLService;
import org.cross.elsclient.ui.adminui.UserInfoPanel;
import org.cross.elsclient.ui.adminui.UserManagePanel;
import org.cross.elsclient.ui.adminui.UserUpdatePanel;
import org.cross.elsclient.ui.component.ELSButton;
import org.cross.elsclient.ui.component.ELSManageTable;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.ComponentFactory;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.LogUtil;
import org.cross.elsclient.vo.UserVO;
import org.cross.elsclient.vo.VehicleVO;
import org.cross.elscommon.util.ResultMessage;

public class VehicleManageTable extends ELSManageTable {
	VehicleBLService vehiclebl;
	ArrayList<VehicleVO> vos;

	public VehicleManageTable() {
		super();
	}

	public VehicleManageTable(String[] name, int[] itemWidth,
			VehicleBLService vehiclebl) {
		super(name, itemWidth);
		this.vehiclebl = vehiclebl;
		init();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		vos = new ArrayList<VehicleVO>();
		isUpdateAndDelete = true;
	}

	public void addItem(VehicleVO vo) {
		vos.add(vo);

		String[] item = { vo.number, vo.number, vo.buyTime + "~" + vo.lastTime };
		addItemLabel(item);

	}

	@Override
	public void infoBtn(int index) {
		System.out.println("in");
		super.infoBtn(index);
		ELSPanel contentPanel = GetPanelUtil.getSubFunctionPanel(this,"vehicle");
		VehicleVO vo = vos.get(index);
		contentPanel.add("info",new VehicleInfoPanel(vo));
		contentPanel.cl.show(contentPanel, "info");
	}

	@Override
	public void updateBtn(int index) {
		super.updateBtn(index);
		ELSPanel contentPanel = GetPanelUtil.getSubFunctionPanel(this, "vehicle");

		contentPanel.add("update",new VehicleUpdatePanel(vos.get(index),
				vehiclebl));
		contentPanel.cl.show(contentPanel, "update");
	}

	@Override
	public void deleteBtn(int index) {
		try {
			if (vehiclebl.delete(vos.get(index).number) == ResultMessage.SUCCESS) {
				LogUtil.addLog("删除车辆");
				container.remove(itemLabels.get(index));
				itemLabels.remove(index);

				vos.remove(index);
				packHeight();
				((ELSPanel)getParent()).packHeight();
				container.validate();
				container.repaint();
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this), "删除成功");
			}
			else {
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this), "删除失败");
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
