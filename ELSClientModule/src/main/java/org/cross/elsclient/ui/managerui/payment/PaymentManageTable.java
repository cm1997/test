package org.cross.elsclient.ui.managerui.payment;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blservice.personnelblservice.PersonnelBLService;
import org.cross.elsclient.ui.component.ELSManageTable;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.managerui.personnel.PerInfoPanel;
import org.cross.elsclient.ui.managerui.personnel.PerUpdatePanel;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.LogUtil;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elscommon.util.ResultMessage;

public class PaymentManageTable extends ELSManageTable{
	PersonnelBLService personnelbl;
	ArrayList<PersonnelVO> vos;

	public PaymentManageTable(String[] name, int[] itemWidth,
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
		String item[] = {vo.number, vo.name, vo.position.toString(),vo.salary.getSalaryByMonth()+""};
		addItemLabel(item);
	}


	@Override
	public void updateBtn(int index) {
		// TODO Auto-generated method stub
		super.updateBtn(index);
		ELSPanel contentPanel = GetPanelUtil.getSubFunctionPanel(this, "payment");
		contentPanel.add("update", new PaymentUpdatePanel(vos.get(index), personnelbl));
		contentPanel.cl.show(contentPanel, "update");
	}

	@Override
	public void deleteBtn(int index) {
		super.deleteBtn(index);
		try {
			if(personnelbl.delete(vos.get(index).id)==ResultMessage.SUCCESS){
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
