package org.cross.elsclient.blservice.constantblservice;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elsclient.vo.ConstantVO;

public class ConstantBLService_Stub implements ConstantBLService {



	@Override
	public ConstantVO show() {
		return new ConstantVO();
	}

	@Override
	public ResultMessage update(ConstantVO vo) {
		return ResultMessage.SUCCESS;
	}

}
