package org.cross.elsclient.ui.supercounterui;

import org.cross.elsclient.ui.component.ELSFunctionPanel;
import org.cross.elsclient.ui.counterui.CounterFunctionPanel;
import org.cross.elsclient.ui.counterui.account.AccountManagePanel;

public class SuperFunctionPanel extends CounterFunctionPanel {
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		addFunctionBtn("账户管理", "account");
		addFunctionPanel(new AccountManagePanel(accountbl),"manage", "account");
		validate();
	}
}
