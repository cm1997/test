package org.cross.elsclient.ui.counterui.initial;

import java.text.DecimalFormat;
import java.util.ArrayList;

import org.cross.elsclient.ui.component.ELSManageTable;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.vo.AccountVO;
import org.cross.elsclient.vo.OrganizationVO;

public class InitialAccountTable extends InitialManageTable {
	ArrayList<AccountVO> vos;
	
	public InitialAccountTable(String[] name,int[] itemWidth,ArrayList<AccountVO> vos){
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
		DecimalFormat decimalFormat = new DecimalFormat("#");
		for (AccountVO vo : vos) {
			String item[] = {vo.name,vo.account,decimalFormat.format(vo.balance)+""};
			addItemLabel(item);
		}
		container.validate();
	}
	
	@Override
	public void addBtn() {
		super.addBtn();
		ELSPanel parent = GetPanelUtil.getSubFunctionPanel(this,"initial");
		parent.add("addAccount",new AccountAddPanel(vos));
		parent.cl.show(parent, "addAccount");
	}
}
