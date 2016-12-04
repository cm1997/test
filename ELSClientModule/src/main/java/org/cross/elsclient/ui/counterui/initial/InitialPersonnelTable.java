package org.cross.elsclient.ui.counterui.initial;

import java.util.ArrayList;

import org.cross.elsclient.ui.component.ELSManageTable;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.vo.OrganizationVO;
import org.cross.elsclient.vo.PersonnelVO;

public class InitialPersonnelTable extends InitialManageTable{
	ArrayList<PersonnelVO> vos;
	
	public InitialPersonnelTable(String[] name,int[] itemWidth,ArrayList<PersonnelVO> vos){
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
		for (PersonnelVO vo : vos) {
			String item[] = {vo.number,vo.name,vo.position.toString(),vo.orgNum};
			addItemLabel(item);
		}
		container.validate();
	}
	
	@Override
	public void addBtn() {
		super.addBtn();
		ELSPanel parent = GetPanelUtil.getSubFunctionPanel(this, "initial");
		parent.add("addPer",new PerAddPanel(vos));
		parent.cl.show(parent, "addPer");
	}
	
}
