package org.cross.elsclient.blimpl.blUtility;

import org.cross.elsclient.vo.ConstantVO;
import org.cross.elscommon.po.ConstantPO;

public interface ConstantInfo {

	public ConstantVO toConstantVO(ConstantPO po);
	
	public ConstantPO toConstantPO(ConstantVO vo);
}
