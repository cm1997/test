package org.cross.elsclient.blimpl.userblimpl;

import java.rmi.RemoteException;

import org.cross.elsclient.blimpl.blUtility.UserInfo;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.dataservice.userdataservice.UserDataService;
import org.cross.elscommon.po.UserPO;
import org.cross.elscommon.util.StringToType;

public class UserInfoImpl implements UserInfo {
	
	UserDataService userdata;
	
	public UserInfoImpl(UserDataService userdata){
		this.userdata = userdata;
	}

	@Override
	public UserVO toUserVO(UserPO po) {
		if (po == null) {
			return null;
		}
		UserVO vo = new UserVO(po.getNumber(), po.getPassword(), po.getName(),
				po.getType(), po.getOrgNum());
		return vo;
	}

	@Override
	public UserPO toUserPO(UserVO vo) {
		if (vo == null) {
			return null;
		}
		UserPO po = new UserPO(vo.number, vo.name,
				vo.userType, vo.password, vo.orgNameID);
		return po;
	}

	@Override
	public UserVO findUserByNum(String number) {
		try {
			return toUserVO(userdata.findById(number));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
