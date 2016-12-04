package org.cross.elsclient.ui.managerui.personnel;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blservice.personnelblservice.PersonnelBLService;
import org.cross.elsclient.ui.component.ELSManageTable;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.LogUtil;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elscommon.util.ResultMessage;

public class PerManageTable extends ELSManageTable {
	PersonnelBLService personnelbl;
	ArrayList<PersonnelVO> vos;

	public PerManageTable(String[] name, int[] itemWidth,
			PersonnelBLService personnelbl) {
		super(name, itemWidth);
		this.personnelbl = personnelbl;
		init();
	}

	@Override
	public void init() {
		super.init();
		vos = new ArrayList<>();
		isUpdateAndDelete = true;
	}

	public void addItem(PersonnelVO vo) {
		vos.add(vo);

		String item[] = { vo.number, vo.name, vo.position.toString(),
				vo.orgNum};
		addItemLabel(item);
	}

	@Override
	public void infoBtn(int index) {
		// TODO Auto-generated method stub
		super.infoBtn(index);
		// 界面统一添加到功能界面(managePanel的父容器)
		ELSPanel contentPanel = GetPanelUtil.getSubFunctionPanel(this, "personnel");
		PersonnelVO vo = vos.get(index);
		contentPanel.add("info", new PerInfoPanel(vo));
		contentPanel.cl.show(contentPanel, "info");
	}

	@Override
	public void updateBtn(int index) {
		// TODO Auto-generated method stub
		super.updateBtn(index);
		ELSPanel contentPanel = GetPanelUtil.getSubFunctionPanel(this, "personnel");
		contentPanel.add("update", new PerUpdatePanel(vos.get(index), personnelbl));
		contentPanel.cl.show(contentPanel, "update");
	}

	@Override
	public void deleteBtn(int index) {
		super.deleteBtn(index);
		try {
			if(personnelbl.delete(vos.get(index).number)==ResultMessage.SUCCESS){
				//从展示层删除该项
				container.remove(itemLabels.get(index));
				itemLabels.remove(index);
				vos.remove(index);
				
				//自适应高度
				packHeight();
				((ELSPanel)getParent()).packHeight();
				
				container.validate();
				container.repaint();
				LogUtil.addLog("删除人员");
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this), "删除成功");
			}else{
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this), "删除失败");
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
