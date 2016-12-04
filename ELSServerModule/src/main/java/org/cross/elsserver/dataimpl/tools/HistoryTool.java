package org.cross.elsserver.dataimpl.tools;

import java.util.ArrayList;

import org.cross.elscommon.po.HistoryPO;
import org.cross.elscommon.util.ResultMessage;

public interface HistoryTool {
	public ArrayList<HistoryPO> findByOrderNum(String number);
	
	public ResultMessage insert(HistoryPO po, String orderNum);
}
