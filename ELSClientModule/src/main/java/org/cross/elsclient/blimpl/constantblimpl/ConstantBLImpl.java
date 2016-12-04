package org.cross.elsclient.blimpl.constantblimpl;

import java.rmi.RemoteException;

import org.cross.elsclient.blimpl.blUtility.ConstantInfo;
import org.cross.elsclient.blservice.constantblservice.ConstantBLService;
import org.cross.elsclient.vo.ConstantVO;
import org.cross.elscommon.dataservice.constantdataservice.ConstantDataService;
import org.cross.elscommon.dataservice.constantdataservice.ConstantDataService_Stub;
import org.cross.elscommon.po.ConstantPO;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.UserType;

public class ConstantBLImpl implements ConstantBLService{

	public ConstantDataService constantData;
	public ConstantInfo constantInfo;
	
	public ConstantBLImpl(ConstantDataService constantData,ConstantInfo constantInfo){
		this.constantData = constantData;
		this.constantInfo = constantInfo;
	}
	
	@Override
	public ResultMessage update(ConstantVO vo) {
		ConstantPO po = constantInfo.toConstantPO(vo);
		try {
			return constantData.update(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	@Override
	public ConstantVO show() {
		ConstantVO vo = null;
		try {
			ConstantPO po = constantData.show();
			if(po == null) return null;
			vo = constantInfo.toConstantVO(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}

}
