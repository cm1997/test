package org.cross.elsclient.blimpl.organizationblimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.OrganizationInfo;
import org.cross.elsclient.vo.OrganizationVO;
import org.cross.elscommon.dataservice.organizationdataservice.OrganizationDataService;
import org.cross.elscommon.po.AccountPO;
import org.cross.elscommon.po.OrganizationPO;
import org.cross.elscommon.util.City;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.ResultMessage;

public class OrganizationInfoImpl implements OrganizationInfo {

	OrganizationDataService orgData;

	public OrganizationInfoImpl(OrganizationDataService orgData) {
		this.orgData = orgData;
	}

	@Override
	public OrganizationVO toOrganizationVO(OrganizationPO po) {
		if (po == null) {
			return null;
		}
		OrganizationVO vo = new OrganizationVO(po.getCity(), po.getType(),
				po.getNumber());
		return vo;
	}

	@Override
	public OrganizationPO toOrganizationPO(OrganizationVO vo) {
		if (vo == null) {
			return null;
		}
		OrganizationPO po = new OrganizationPO(vo.city, vo.number, vo.type);
		return po;
	}

	@Override
	public ArrayList<OrganizationVO> toOrgVOs(ArrayList<OrganizationPO> pos) {
		ArrayList<OrganizationVO> vos = new ArrayList<OrganizationVO>();
		if (pos == null) {
			return null;
		}
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(toOrganizationVO(pos.get(i)));
		}
		return vos;
	}

	@Override
	public ArrayList<OrganizationPO> toOrgPOs(ArrayList<OrganizationVO> vos) {
		ArrayList<OrganizationPO> pos = new ArrayList<OrganizationPO>();
		if (vos == null) {
			return null;
		}
		int size = vos.size();
		for (int i = 0; i < size; i++) {
			pos.add(toOrganizationPO(vos.get(i)));
		}
		return pos;
	}

	@Override
	public ArrayList<OrganizationVO> show() throws RemoteException {
		ArrayList<OrganizationPO> pos = orgData.show();
		ArrayList<OrganizationVO> vos = toOrgVOs(pos);
		return vos;
	}

	@Override
	public ResultMessage addOrg(OrganizationPO org) {
		try {
			return orgData.insert(org);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

}
