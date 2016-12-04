package org.cross.elsclient.blimpl.blUtility;

import org.cross.elsclient.vo.LogVO;
import org.cross.elscommon.po.LogPO;

public interface LogInfo {

	public LogVO toLogVO(LogPO po);
	
	public LogPO toLogPO(LogVO vo);
	
}
