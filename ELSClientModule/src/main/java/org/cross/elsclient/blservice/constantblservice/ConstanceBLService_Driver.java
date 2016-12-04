package org.cross.elsclient.blservice.constantblservice;

import java.rmi.RemoteException;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elsclient.vo.ConstantVO;
import org.omg.PortableInterceptor.SUCCESSFUL;

public class ConstanceBLService_Driver {

	public void drive(ConstantBLService constantBLService) throws RemoteException{
		System.out.println("制定业务常量返回信息：");
		
		System.out.println("更改业务常量：");
		if(constantBLService.update(new ConstantVO()) == ResultMessage.SUCCESS){
			System.out.println("更新价格常量成功");
		}else{
			System.out.println("更新价格常量失败");
		}
		System.out.println();
		
		System.out.println("展示业务常量：");
		ConstantVO vo = constantBLService.show();
		System.out.println("价格：" + vo.price + "元；");
		System.out.println("北京-上海：" + vo.distance_Beijing_Shanghai + "km;");
		System.out.println("北京-南京：" + vo.distance_Beijing_Nanjing + "km;");
		System.out.println("北京-广州：" + vo.distance_Beijing_Guangzhou + "km;");
		System.out.println("广州-上海：" + vo.distance_Shanghai_Guangzhou + "km;");
		System.out.println("南京-上海：" + vo.distance_Nanjing_Shanghai + "km;");
		System.out.println("南京-广州：" + vo.distance_Nanjing_Guangzhou + "km;");
		System.out.println();
		
	}
}
