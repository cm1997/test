package org.cross.elsclient.blimpl.initialblimpl;

import java.util.ArrayList;

import org.cross.elsclient.blimpl.accountblimpl.Account;
import org.cross.elsclient.vo.AccountVO;
import org.cross.elscommon.util.ResultMessage;

public class MockAccount extends Account{
		public ResultMessage createAccount(ArrayList<AccountVO> vo){
			ResultMessage resultMessage = ResultMessage.FAILED;
			for (int i = 0; i < vo.size(); i++) {
				resultMessage = add(vo.get(i));
			}
			return resultMessage;
		}
}
