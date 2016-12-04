package org.cross.elsclient.blimpl.organizationblimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.OrganizationInfo;
import org.cross.elsclient.blservice.organizationblservice.OrganizationBLService;
import org.cross.elsclient.vo.OrganizationVO;
import org.cross.elscommon.dataservice.organizationdataservice.OrganizationDataService;
import org.cross.elscommon.po.OrganizationPO;
import org.cross.elscommon.util.City;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.ResultMessage;

public class OrganizationBLImpl implements OrganizationBLService{

	public OrganizationDataService organizationData;
	public OrganizationInfo organizationInfo;
	
	public OrganizationBLImpl(OrganizationDataService organizationData,OrganizationInfo organizationInfo){
		this.organizationData = organizationData;
		this.organizationInfo = organizationInfo;
	}
	
	@Override
	public ResultMessage add(OrganizationVO vo) throws RemoteException {
		OrganizationPO po = organizationInfo.toOrganizationPO(vo);
		return organizationData.insert(po);
	}

	@Override
	public ResultMessage delete(String number) throws RemoteException {
		return organizationData.delete(number);
	}

	@Override
	public ResultMessage update(OrganizationVO vo) throws RemoteException {
		OrganizationPO po = organizationInfo.toOrganizationPO(vo);
		return organizationData.update(po) ;
	}

	@Override
	public ArrayList<OrganizationVO> show() throws RemoteException {
		ArrayList<OrganizationVO> vos = new ArrayList<OrganizationVO>();
		ArrayList<OrganizationPO> pos = organizationData.show();
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(organizationInfo.toOrganizationVO(pos.get(i)));
		}
		return vos;
	}

	@Override
	public ArrayList<OrganizationVO> findByCity(City city) throws RemoteException {
		ArrayList<OrganizationVO> vos = new ArrayList<OrganizationVO>();
		ArrayList<OrganizationPO> pos = organizationData.findByCity(city);
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(organizationInfo.toOrganizationVO(pos.get(i)));
		}
		return vos;
	}

	@Override
	public ArrayList<OrganizationVO> findByType(OrganizationType type) throws RemoteException {
		ArrayList<OrganizationVO> vos = new ArrayList<OrganizationVO>();
		ArrayList<OrganizationPO> pos = organizationData.findByType(type);
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(organizationInfo.toOrganizationVO(pos.get(i)));
		}
		return vos;
	}

	@Override
	public OrganizationVO findById(String id) throws RemoteException {
		OrganizationPO po = organizationData.findById(id);
		OrganizationVO vo = organizationInfo.toOrganizationVO(po);
		return vo;
	}

}
