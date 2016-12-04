package org.cross.elsserver.dataimpl.tools;

import java.sql.ResultSet;

import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.util.ResultMessage;

public interface ReceiptTool {
	public ResultMessage insert(ReceiptPO po);
	public ReceiptPO getFromDB(ResultSet rs);
}
