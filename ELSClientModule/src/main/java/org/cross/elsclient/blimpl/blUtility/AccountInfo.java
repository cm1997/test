package org.cross.elsclient.blimpl.blUtility;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.vo.AccountVO;
import org.cross.elsclient.vo.VehicleVO;
import org.cross.elscommon.po.AccountPO;
import org.cross.elscommon.po.VehiclePO;
import org.cross.elscommon.util.ResultMessage;

public interface AccountInfo {
	public AccountVO toAccountVO(AccountPO po);

	public AccountPO toAccountPO(AccountVO vo);
	
	public ArrayList<AccountVO> toAccVOs(ArrayList<AccountPO> pos);

	public ArrayList<AccountPO> toAccPOs(ArrayList<AccountVO> vos);
	
	/**
	 * 显示所有账户信息
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<AccountVO> show() throws RemoteException;
	
	public ResultMessage addacc(AccountPO po);

}
