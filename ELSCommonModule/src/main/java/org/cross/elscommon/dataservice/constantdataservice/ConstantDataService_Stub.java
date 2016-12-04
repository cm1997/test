package org.cross.elscommon.dataservice.constantdataservice;

import org.cross.elscommon.po.ConstantPO;
import org.cross.elscommon.util.ResultMessage;

public class ConstantDataService_Stub implements ConstantDataService{

	@Override
	public ResultMessage update(ConstantPO po) {
		System.out.println("更新常量成功");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ConstantPO show() {
		// TODO Auto-generated method stub
		System.out.println("显示业务常量成功");
		return new ConstantPO();
	}

}
