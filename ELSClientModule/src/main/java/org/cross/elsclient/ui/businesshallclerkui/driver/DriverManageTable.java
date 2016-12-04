package org.cross.elsclient.ui.businesshallclerkui.driver;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blservice.personnelblservice.PersonnelBLService;
import org.cross.elsclient.ui.component.ELSManageTable;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.LogUtil;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.DriverVO;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.util.ResultMessage;

public class DriverManageTable extends ELSManageTable{
	PersonnelBLService personnelbl;
	ArrayList<DriverVO> vos;
	UserVO user;

	public DriverManageTable() {
		super();
	}

	public DriverManageTable(String[] name, int[] itemWidth,
			PersonnelBLService personnelBLService, UserVO user) {
		super(name, itemWidth);
		this.personnelbl = personnelBLService;
		this.user = user;
		init();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		vos = new ArrayList<>();
		isUpdateAndDelete = true;
	}

	public void addItem(DriverVO vo) {
		vos.add(vo);
		int index = vos.indexOf(vo);

		String[] item = { vo.number, vo.name, vo.sex, vo.phone + vo.orgNum };
		addItemLabel(item);
	}

	@Override
	public void infoBtn(int index) {
		super.infoBtn(index);
		ELSPanel contentPanel = GetPanelUtil.getSubFunctionPanel(this, "driver");
		DriverVO vo = vos.get(index);
		contentPanel.add(new DriverInfoPanel(vo, user), "info");
		contentPanel.cl.show(contentPanel, "info");
	}

	@Override
	public void updateBtn(int index) {
		super.updateBtn(index);
		ELSPanel contentPanel = GetPanelUtil.getSubFunctionPanel(this, "driver");

		contentPanel.add(new DriverUpdatePanel(vos.get(index),
				personnelbl), "update");
		contentPanel.cl.show(contentPanel, "update");
	}

	@Override
	public void deleteBtn(int index) {
		super.deleteBtn(index);
		try {
			if (personnelbl.delete(vos.get(index).number) == ResultMessage.SUCCESS) {
				LogUtil.addLog("删除司机");
				container.remove(itemLabels.get(index));
				itemLabels.remove(index);
				vos.remove(index);
				
				//自适应高度
				packHeight();
				((ELSPanel)getParent()).packHeight();
				
				container.validate();
				container.repaint();
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this), "删除成功");
			}else{
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this), "删除失败");
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
