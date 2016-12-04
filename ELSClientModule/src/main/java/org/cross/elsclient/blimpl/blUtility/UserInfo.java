package org.cross.elsclient.blimpl.blUtility;

import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.po.UserPO;

public interface UserInfo {

	public UserVO toUserVO(UserPO po);
	
	public UserPO toUserPO(UserVO vo);
	
	public UserVO findUserByNum(String number);
}
