package org.cross.elsclient.blimpl.initialblimpl;

import java.util.ArrayList;

import org.cross.elsclient.blimpl.organizationblimpl.Organization;
import org.cross.elsclient.vo.OrganizationVO;
import org.cross.elscommon.util.ResultMessage;

public class MockOrganization extends Organization{
	public ResultMessage createOragination(ArrayList<OrganizationVO> vo){
		ResultMessage resultMessage = ResultMessage.FAILED;
		for (int i = 0; i < vo.size(); i++) {
			resultMessage = add(vo.get(i));
		}
		return resultMessage;
	}
}
