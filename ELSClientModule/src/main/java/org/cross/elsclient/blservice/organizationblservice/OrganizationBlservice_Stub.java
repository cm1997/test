package org.cross.elsclient.blservice.organizationblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elsclient.vo.OrganizationVO;

public class OrganizationBlservice_Stub implements OrganizationBLService {

	@Override
	public ResultMessage add(OrganizationVO vo) {
		if(vo.city == City.BEIJING && vo.type == OrganizationType.BUSINESSHALL){
			return ResultMessage.FAILED;
		}
		return ResultMessage.SUCCESS;
		
	}

	@Override
	public ResultMessage update(OrganizationVO vo) {
		if(vo.city == City.BEIJING && vo.type == OrganizationType.BUSINESSHALL){
			return ResultMessage.FAILED;
		}
		
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<OrganizationVO> show() {
		ArrayList<OrganizationVO> list = new ArrayList<OrganizationVO>();
		list.add(new OrganizationVO(City.BEIJING, OrganizationType.BUSINESSHALL,"O000001" ));
		list.add(new OrganizationVO(City.SHANGHAI, OrganizationType.TRANSITCENTER,"O000002" ));
		list.add(new OrganizationVO(City.GUANGZHOU, OrganizationType.TRANSITCENTER,"O000003" ));
		list.add(new OrganizationVO(City.NANJING, OrganizationType.TRANSITCENTER,"O000004" ));
		return list;
	}

	@Override
	public ArrayList<OrganizationVO> findByCity(City city) {
		ArrayList<OrganizationVO> list = new ArrayList<OrganizationVO>();
		list.add(new OrganizationVO(city, OrganizationType.BUSINESSHALL,"O000001" ));
		list.add(new OrganizationVO(city, OrganizationType.BUSINESSHALL,"O000001" ));
		list.add(new OrganizationVO(city, OrganizationType.BUSINESSHALL,"O000001" ));
		list.add(new OrganizationVO(city, OrganizationType.BUSINESSHALL,"O000001" ));
		return list;
	}

	@Override
	public ArrayList<OrganizationVO> findByType(OrganizationType type) {
		ArrayList<OrganizationVO> list = new ArrayList<OrganizationVO>();
		list.add(new OrganizationVO(City.BEIJING, type ,"O000001" ));
		list.add(new OrganizationVO(City.BEIJING, type ,"O000001" ));
		list.add(new OrganizationVO(City.BEIJING, type ,"O000001" ));
		list.add(new OrganizationVO(City.BEIJING, type ,"O000001" ));
		return list;
	}


	@Override
	public ResultMessage delete(String number) throws RemoteException {
		return ResultMessage.SUCCESS;
	}

	@Override
	public OrganizationVO findById(String id) throws RemoteException {
		return new OrganizationVO(City.BEIJING, OrganizationType.BUSINESSHALL, id);
	}

}
