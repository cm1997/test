package org.cross.elsclient.test;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.ConstantInfo;
import org.cross.elsclient.blimpl.constantblimpl.ConstantBLImpl;
import org.cross.elsclient.blimpl.constantblimpl.ConstantInfoImpl;
import org.cross.elsclient.network.Datafactory;
import org.cross.elsclient.vo.ConstantVO;
import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;
import org.cross.elscommon.util.ResultMessage;

public class ConstantBLTest {

	public static void main(String[] args) throws RemoteException {
		DataFactoryService dataFactory = new Datafactory();
		ConstantInfo constantInfo = new ConstantInfoImpl();
		ConstantBLImpl constantBLImpl = new ConstantBLImpl(
				dataFactory.getConstantData(), constantInfo);

//		System.out.println("test ------- update");
//		ConstantVO newVO = new ConstantVO();
//		newVO.baseMoneyForADMINISTRATOR = 50001;
//		ResultMessage updateMessage = constantBLImpl.update(newVO); 
//		if (updateMessage == ResultMessage.SUCCESS) {
//			System.out.println("更新成功");
//		} else {
//			System.out.println("更新失败");
//		}
		System.out.println("test ------- show");
		ConstantVO show = constantBLImpl.show();
		if(show == null) System.out.println("fail");else 
		System.out.println(show.baseMoneyForADMINISTRATOR + " "
				+ show.distance_Beijing_Guangzhou + " " + show.price);
	} 

}
