//package org.cross.elscommon.dataservice.organizationdataservice;
//
//import java.util.ArrayList;
//
//import org.cross.elscommon.po.OrganizationPO;
//import org.cross.elscommon.util.City;
//import org.cross.elscommon.util.OrganizationType;
//import org.cross.elscommon.util.ResultMessage;
//
//public class OrganizationDataService_Stub implements OrganizationDataService{
//
//	@Override
//	public ResultMessage insert(OrganizationPO po) {
//		System.out.println("Insert Succeed!\n");
//		return ResultMessage.SUCCESS;
//		
//	}
//
//	@Override
//	public ResultMessage delete(OrganizationPO po) {
//		System.out.println("Delete Succeed!\n");
//		return ResultMessage.SUCCESS;
//	}
//
//	@Override
//	public ResultMessage update(OrganizationPO po) {
//		System.out.println("Update Succeed!\n");
//		return ResultMessage.SUCCESS;
//	}
//
//	@Override
//	public ArrayList<OrganizationPO> findByCity(City city) {
//		System.out.println("FindByCity Succeed!\n");
//		ArrayList<OrganizationPO> list = new ArrayList<OrganizationPO>();
//		list.add(new OrganizationPO(city, OrganizationType.BUSINESSHALL, "001"));
//		return list;
//	}
//
//	@Override
//	public ArrayList<OrganizationPO> findByType(OrganizationType type) {
//		System.out.println("FindByType Succeed!\n");
//		ArrayList<OrganizationPO> list = new ArrayList<OrganizationPO>();
//		list.add(new OrganizationPO(City.BEIJING, type, "001"));
//		return list;
//	}
//
//	@Override
//	public ArrayList<OrganizationPO> findById(String id) {
//		System.out.println("FindById Succeed!\n");
//		ArrayList<OrganizationPO> list = new ArrayList<OrganizationPO>();
//		list.add(new OrganizationPO(City.BEIJING, OrganizationType.BUSINESSHALL, id));
//		return list;
//	}
//
//	@Override
//	public ArrayList<OrganizationPO> show() {
//		System.out.println("Show Succeed!\n");
//		ArrayList<OrganizationPO> list = new ArrayList<OrganizationPO>();
//		list.add(new OrganizationPO(City.BEIJING, OrganizationType.BUSINESSHALL, "001"));
//		return list;
//	}
//
//}
