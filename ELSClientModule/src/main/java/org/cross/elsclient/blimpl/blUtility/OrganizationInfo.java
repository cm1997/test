package org.cross.elsclient.blimpl.blUtility;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.vo.OrganizationVO;
import org.cross.elscommon.po.OrganizationPO;
import org.cross.elscommon.util.ResultMessage;

public interface OrganizationInfo {

	public OrganizationVO toOrganizationVO(OrganizationPO po);
	
	public OrganizationPO toOrganizationPO(OrganizationVO vo);
	
	public ArrayList<OrganizationVO> toOrgVOs(ArrayList<OrganizationPO> pos);
	
	public ArrayList<OrganizationPO> toOrgPOs(ArrayList<OrganizationVO> vos);
	
	/**
	 * 显示机构列表
	 * @para 
	 * @return ArrayList<OrganizationVO>
	 * @throws RemoteException 
	 */
	public ArrayList<OrganizationVO> show() throws RemoteException;
	
	public ResultMessage addOrg(OrganizationPO org);
}
