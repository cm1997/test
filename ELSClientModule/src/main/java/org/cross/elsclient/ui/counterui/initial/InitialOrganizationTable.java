package org.cross.elsclient.ui.counterui.initial;

import java.util.ArrayList;

import org.cross.elsclient.blimpl.organizationblimpl.Organization;
import org.cross.elsclient.ui.adminui.UserManageTable;
import org.cross.elsclient.ui.component.ELSManageTable;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.vo.OrganizationVO;

public class InitialOrganizationTable extends InitialManageTable{
	ArrayList<OrganizationVO> vos;
	
	public InitialOrganizationTable(String[] name,int[] itemWidth,ArrayList<OrganizationVO> vos){
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
		for (OrganizationVO vo : vos) {
			String item[] = {vo.number,vo.city.toString(),vo.type.toString()};
			addItemLabel(item);
		}
		container.validate();
	}
	
	@Override
	public void addBtn() {
		super.addBtn();
		ELSPanel parent = GetPanelUtil.getSubFunctionPanel(this, "initial");
		parent.add("addOrgan",new OrganAddPanel(vos));
		parent.cl.show(parent, "addOrgan");
	}
}
