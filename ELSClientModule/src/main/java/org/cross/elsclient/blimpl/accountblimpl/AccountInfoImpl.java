package org.cross.elsclient.blimpl.accountblimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.AccountInfo;
import org.cross.elsclient.vo.AccountVO;
import org.cross.elscommon.dataservice.accountdataservice.AccountDataService;
import org.cross.elscommon.po.AccountPO;
import org.cross.elscommon.util.ResultMessage;

public class AccountInfoImpl implements AccountInfo {
	AccountDataService accountData;

	public AccountInfoImpl(AccountDataService accountData) {
		this.accountData = accountData;
	}

	@Override
	public AccountVO toAccountVO(AccountPO po) {
		if (po == null) {
			return null;
		}
		AccountVO vo = new AccountVO(po.getName(), po.getAccountNum(),
				po.getBalance());
		return vo;
	}

	@Override
	public AccountPO toAccountPO(AccountVO vo) {
		if (vo == null) {
			return null;
		}
		AccountPO po = new AccountPO(vo.name, vo.account, vo.balance);
		return po;
	}

	@Override
	public ArrayList<AccountVO> toAccVOs(ArrayList<AccountPO> pos) {
		ArrayList<AccountVO> vos = new ArrayList<AccountVO>();
		if (pos == null) {
			return null;
		}
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(toAccountVO(pos.get(i)));
		}
		return vos;
	}

	@Override
	public ArrayList<AccountPO> toAccPOs(ArrayList<AccountVO> vos) {
		ArrayList<AccountPO> pos = new ArrayList<AccountPO>();
		if (vos == null) {
			return null;
		}
		int size = vos.size();
		for (int i = 0; i < size; i++) {
			pos.add(toAccountPO(vos.get(i)));
		}
		return pos;
	}

	@Override
	public ArrayList<AccountVO> show() throws RemoteException {
		ArrayList<AccountVO> vos = new ArrayList<AccountVO>();
		ArrayList<AccountPO> pos = accountData.show();
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(toAccountVO(pos.get(i)));
		}
		return vos;
	}

	@Override
	public ResultMessage addacc(AccountPO po) {
		try {
			return accountData.insert(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}
}
