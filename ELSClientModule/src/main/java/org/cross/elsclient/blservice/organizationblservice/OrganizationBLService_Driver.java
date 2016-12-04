//package org.cross.elsclient.blservice.organizationblservice;
//
//import java.util.ArrayList;
//
//import org.cross.elscommon.util.City;
//import org.cross.elscommon.util.OrganizationType;
//import org.cross.elscommon.util.ResultMessage;
//import org.cross.elsclient.vo.OrganizationVO;
//
//
//public class OrganizationBLService_Driver {
//	
//	public void drive(OrganizationBLService organizationBLService){
//		
//		ResultMessage result;
//		System.out.print("添加机构返回信息：");
//		result = organizationBLService.add(new OrganizationVO(City.BEIJING, OrganizationType.BUSINESSHALL, "001"));
//		if(result == ResultMessage.SUCCESS){
//			System.out.print("机构添加成功\n");
//		}else{
//			System.out.print("机构添加失败\n");
//		}
//		
//		System.out.print("删除机构返回信息：");
//		result = organizationBLService.add(new OrganizationVO(City.BEIJING, OrganizationType.BUSINESSHALL, "001"));
//		if(result == ResultMessage.SUCCESS){
//			System.out.print("机构删除成功\n");
//		}else{
//			System.out.print("机构删除失败\n");
//		}
//		
//		System.out.print("修改机构返回信息：");
//		result = organizationBLService.add(new OrganizationVO(City.BEIJING, OrganizationType.BUSINESSHALL, "001"));
//		if(result == ResultMessage.SUCCESS){
//			System.out.print("机构修改成功\n");
//		}else{
//			System.out.print("机构修改失败\n");
//		}
//		
//		System.out.print("显示所有机构：");
//		ArrayList<OrganizationVO> list1 = organizationBLService.show();
//		for(int i = 0;i<list1.size();i++){
//			System.out.print("机构地区：" + list1.get(i).city + "; ");
//			System.out.print("机构类型：" + list1.get(i).type.toString() + "; ");
//			System.out.print("机构ID：" + list1.get(i).id + ";\n");
//		}
//		
//		System.out.println("根据地区查找机构：");
//		ArrayList<OrganizationVO> list2 = organizationBLService.findByCity(City.BEIJING);
//		for(int i = 0;i<list2.size();i++){
//			System.out.print("机构地区：" + list2.get(i).city + "; ");
//			System.out.print("机构类型：" + list2.get(i).type.toString() + "; ");
//			System.out.println("机构ID：" + list2.get(i).id + ";\n");
//		}
//		
//		System.out.print("根据类型查找机构：");
//		ArrayList<OrganizationVO> list3 = organizationBLService.findByType(OrganizationType.BUSINESSHALL);
//		for(int i = 0;i<list3.size();i++){
//			System.out.print("机构地区：" + list3.get(i).city + "; ");
//			System.out.print("机构类型：" + list3.get(i).type.toString() + "; ");
//			System.out.print("机构ID：" + list3.get(i).id + ";\n");
//		}
//		
//		System.out.println("根据ID查找机构：");
//		ArrayList<OrganizationVO> list4 = organizationBLService.findByType(OrganizationType.BUSINESSHALL);
//		for(int i = 0;i<list4.size();i++){
//			System.out.print("机构地区：" + list4.get(i).city + "; ");
//			System.out.print("机构类型：" + list4.get(i).type.toString() + "; ");
//			System.out.print("机构ID：" + list4.get(i).id + ";\n");
//		}
//		
//		System.out.println("显示两个机构间的距离：");
//		int distance = organizationBLService.showDistance(new OrganizationVO(City.BEIJING, OrganizationType.BUSINESSHALL, "001"),
//				new OrganizationVO(City.BEIJING, OrganizationType.BUSINESSHALL, "002"));
//		System.out.println(distance + "km");
//	}
//}
