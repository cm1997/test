//package org.cross.elscommon.dataservice.organizationdataservice;
//
//import org.cross.elscommon.po.OrganizationPO;
//import org.cross.elscommon.util.City;
//import org.cross.elscommon.util.OrganizationType;
//
//public class OrganizationDataService_Driver {
//	
//	public void drive(OrganizationDataService_Stub organizationDataService_Stub){
//		
//		organizationDataService_Stub.insert(new OrganizationPO(City.BEIJING, OrganizationType.BUSINESSHALL, "001"));
//		organizationDataService_Stub.delete(new OrganizationPO(City.BEIJING, OrganizationType.BUSINESSHALL, "001"));
//		organizationDataService_Stub.update(new OrganizationPO(City.BEIJING, OrganizationType.BUSINESSHALL, "001"));
//		organizationDataService_Stub.findByCity(City.BEIJING);
//		organizationDataService_Stub.findById("001");
//		organizationDataService_Stub.findByType(OrganizationType.BUSINESSHALL);
//		organizationDataService_Stub.show();
//		
//	}
//}
