package org.cross.elsclient.blimpl.blUtility;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elscommon.po.PersonnelPO;
import org.cross.elscommon.po.SalaryPO;
import org.cross.elscommon.util.ResultMessage;

public interface PersonnelInfo {

	public PersonnelVO toPersonnelVO(PersonnelPO po, SalaryPO salary);

	public PersonnelPO toPersonnelPO(PersonnelVO vo);

	/**
	 * 显示所有人员信息
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<PersonnelVO> show() throws RemoteException;

	/**
	 * 根据人员工号查找姓名
	 * 
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public String findNameById(String id) throws RemoteException;
	
	public ResultMessage addPer(PersonnelVO per);

}
