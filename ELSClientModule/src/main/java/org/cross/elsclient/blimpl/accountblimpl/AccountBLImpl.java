package org.cross.elsclient.blimpl.accountblimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.AccountInfo;
import org.cross.elsclient.blservice.accountblservice.AccountBLService;
import org.cross.elsclient.vo.AccountVO;
import org.cross.elscommon.dataservice.accountdataservice.AccountDataService;
import org.cross.elscommon.po.AccountPO;
import org.cross.elscommon.util.ResultMessage;

public class AccountBLImpl implements AccountBLService{

	public AccountDataService accountData;
	public AccountInfo accountInfo;
	
	public AccountBLImpl(AccountDataService accountData,AccountInfo accountInfo) {
		this.accountData = accountData;
		this.accountInfo = accountInfo;
	}
	@Override
	public ArrayList<AccountVO> findByName(String name) throws RemoteException {
		ArrayList<AccountPO> accountPOs = accountData.findbyName(name);
		ArrayList<AccountVO> accountVOs = new ArrayList<AccountVO>();
		if (accountPOs == null) {
			return null;
		}
		int size = accountPOs.size();
		for (int i = 0; i < size; i++) {
			accountVOs.add(accountInfo.toAccountVO(accountPOs.get(i)));
		}
		return accountVOs;
	}

	@Override
	public AccountVO findByID(String ID) throws RemoteException {
		AccountPO accountPO = accountData.findbyID(ID);
		AccountVO accountVO = accountInfo.toAccountVO(accountPO);
		return accountVO;
	}
	
	@Override
	public ResultMessage add(AccountVO vo) throws RemoteException {
		AccountPO po = accountInfo.toAccountPO(vo);
		return accountData.insert(po);
	}

	@Override
	
	public ResultMessage delete(String ID) throws RemoteException {
		return accountData.delete(ID);
	}

	@Override
	public ResultMessage update(AccountVO vo) throws RemoteException {
		AccountPO po = accountInfo.toAccountPO(vo);
		return accountData.update(po);
	}

	@Override
	public ArrayList<AccountVO> show() throws RemoteException {
		ArrayList<AccountVO> vos = new ArrayList<AccountVO>();
		ArrayList<AccountPO> pos = accountData.show();
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(accountInfo.toAccountVO(pos.get(i)));
		}
		return vos;
	}
}
