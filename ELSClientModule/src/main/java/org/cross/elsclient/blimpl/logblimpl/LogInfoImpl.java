package org.cross.elsclient.blimpl.logblimpl;

import org.cross.elsclient.blimpl.blUtility.LogInfo;
import org.cross.elsclient.vo.LogVO;
import org.cross.elscommon.po.LogPO;

public class LogInfoImpl implements LogInfo{

	@Override
	public LogVO toLogVO(LogPO po) {
		LogVO vo = new LogVO(po.getNumber(), po.getTime(), po.getOperator(),
				po.getOperation());
		return vo;
	}

	@Override
	public LogPO toLogPO(LogVO vo) {
		LogPO po = new LogPO(vo.id, vo.time, vo.operator, vo.content);
		return po;
	}

}
