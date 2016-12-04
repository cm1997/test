/**
 * organization全部写好了
 */
package org.cross.elsclient.test;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.OrganizationInfo;
import org.cross.elsclient.blimpl.organizationblimpl.OrganizationBLImpl;
import org.cross.elsclient.blimpl.organizationblimpl.OrganizationInfoImpl;
import org.cross.elsclient.network.Datafactory;
import org.cross.elsclient.vo.OrganizationVO;
import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;
import org.cross.elscommon.util.City;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.ResultMessage;

public class OrganizationBLTest {
	public static void main(String[] args) throws RemoteException{
		DataFactoryService dataFactory = new Datafactory();
		OrganizationInfo orgInfo = new OrganizationInfoImpl(dataFactory.getOrganizationData());
		OrganizationBLImpl orgBLImpl = new OrganizationBLImpl(dataFactory.getOrganizationData(), orgInfo);
		
		System.out.println("========测试addOrg=======");
//		OrganizationVO newOrg = new OrganizationVO(City.BEIJING, OrganizationType.HEADQUARTERS, "O001055522");
//		OrganizationVO newOrg2 = new OrganizationVO(City.GUANGZHOU, OrganizationType.BUSINESSHALL, "O003");
//		OrganizationVO newOrg3 = new OrganizationVO(City.NANJING, OrganizationType.TRANSITCENTER, "O004");
//		OrganizationVO newOrg4 = new OrganizationVO(City.SHANGHAI, OrganizationType.TRANSITCENTER, "O005");
		OrganizationVO newOrg5 = new OrganizationVO(City.NANJING, OrganizationType.BUSINESSHALL, "O006");
		ResultMessage addMessage = orgBLImpl.add(newOrg5);
		if (addMessage == ResultMessage.SUCCESS) {
			System.out.println("增加成功");
		}else {
			System.out.println("增加失败");
		}
//		System.out.println("========测试deleteOrg=======");
//		ResultMessage delMessage = orgBLImpl.delete("O001055522");
//		if (delMessage == ResultMessage.SUCCESS) {
//			System.out.println("删除成功");
//		}else {
//			System.out.println("删除失败");
//		}
//		System.out.println("========测试updateOrg=======");
//		OrganizationVO updateOrg = new OrganizationVO(City.NANJING, OrganizationType.HEADQUARTERS, "O002");
//		ResultMessage updateMessage = orgBLImpl.update(updateOrg);
//		if (updateMessage == ResultMessage.SUCCESS) {
//			System.out.println("更新成功");
//		}else {
//			System.out.println("更新失败");
//		}
//		System.out.println("========测试showOrg=======");
//		ArrayList<OrganizationVO> showOrg = orgBLImpl.show();
//		if (showOrg == null) {
//			System.out.println("null");
//		}else {
//			int size = showOrg.size();
//			for (int i = 0; i < size; i++) {
//				System.out.println(showOrg.get(i).number + " " + showOrg.get(i).city + " "
//						+ showOrg.get(i).type);
//			}
//		}
//		
//		System.out.println("========测试findByType=======");
//		ArrayList<OrganizationVO> typeOrg = orgBLImpl.findByType(OrganizationType.BUSINESSHALL);
//		int size2 = typeOrg.size();
//		for (int i = 0; i < size2; i++) {
//			System.out.println(typeOrg.get(i).number + " " + typeOrg.get(i).city + " "
//					+ typeOrg.get(i).type);
//		}
//		System.out.println("========测试findByCity=======");
//		ArrayList<OrganizationVO> cityOrg = orgBLImpl.findByCity(City.NANJING);
//		int size3 = cityOrg.size();
//		for (int i = 0; i < size3; i++) {
//			System.out.println(cityOrg.get(i).number + " " + cityOrg.get(i).city + " "
//					+ cityOrg.get(i).type);
//		}
//		System.out.println("========测试findByID=======");
//		OrganizationVO idOrg = orgBLImpl.findById("O003");
//		if (idOrg != null) {
//			System.out.println(idOrg.number + " " + idOrg.city + " " + idOrg.type);
//		}else {
//			System.out.println("查找失败");
//		}
	}
}
