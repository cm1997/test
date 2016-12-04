package org.cross.elsclient.ui.counterui.initial;

import java.util.ArrayList;

import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.vo.OrganizationVO;
import org.cross.elsclient.vo.VehicleVO;

public class InitialVehicleTable extends InitialManageTable {
	ArrayList<VehicleVO> vos;
	
	public InitialVehicleTable(String[] name,int[] itemWidth,ArrayList<VehicleVO> vos){
		super(name, itemWidth);
		this.vos = vos;
		refresh();
	}
	
	@Override
	public void init(){
		super.init();
		isUpdateAndDelete = false;
	}
	
	@Override
	public void refresh(){
		removeAll();
		init();
		if (vos == null) {
			return;
		}
		for (VehicleVO vo : vos) {
			String item[] = {vo.number,vo.number,vo.buyTime+"~"+vo.lastTime};
			addItemLabel(item);
		}
		container.validate();
	}
	
	@Override
	public void addBtn() {
		super.addBtn();
		ELSPanel parent = GetPanelUtil.getSubFunctionPanel(this, "initial");
		parent.add("addVe",new VehicleAddPanel(vos));
		parent.cl.show(parent, "addVe");
	}
}
