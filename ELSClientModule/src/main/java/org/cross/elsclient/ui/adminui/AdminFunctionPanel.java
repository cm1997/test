package org.cross.elsclient.ui.adminui;

import java.rmi.RemoteException;

import org.cross.elsclient.blimpl.blfactoryimpl.BLFactoryImpl;
import org.cross.elsclient.blservice.userblservice.UserBLService;
import org.cross.elsclient.blservice.userblservice.UserBLService_Stub;
import org.cross.elsclient.ui.component.ELSButton;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.component.ELSFunctionPanel;

public class AdminFunctionPanel extends ELSFunctionPanel{
	public UserBLService userbl;
	
	public AdminFunctionPanel() {
		super();
		try {
			userbl = new BLFactoryImpl().getUserBLService();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		init();
	}
	
	@Override
	public void init() {
		super.init();
		
		addFunctionBtn("用户管理", "user");
		
		addFunctionPanel(new UserManagePanel(userbl),"manage", "user");
		
		validate();
	}
}
