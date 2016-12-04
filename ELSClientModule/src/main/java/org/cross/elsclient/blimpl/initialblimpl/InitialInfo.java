package org.cross.elsclient.blimpl.initialblimpl;

import java.rmi.RemoteException;

import org.cross.elsclient.vo.InitialVO;
import org.cross.elscommon.po.InitialPO;

public interface InitialInfo {

	public InitialVO toInitialVO(InitialPO po) throws RemoteException;
	
	public InitialPO toInitialPO(InitialVO vo);
	
}
