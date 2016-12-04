/**
 * 人员管理业务逻辑接口
 * @author Polaris Chen
 * @date 2015/10/19
 */
package org.cross.elsclient.blservice.personnelblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elsclient.vo.PersonnelVO;

public interface PersonnelBLService {

	/**
	 * 根据人员工号查找
	 * 
	 * @param id
	 * @return
	 * @throws RemoteException 
	 */
	public PersonnelVO findById(String id) throws RemoteException;

	/**
	 * 根据人员姓名查找
	 * 
	 * @param name
	 * @return
	 * @throws RemoteException 
	 */
	public ArrayList<PersonnelVO> findByName(String name) throws RemoteException;
	
	public ArrayList<PersonnelVO> findByOrg(String number) throws RemoteException;
	
	public ArrayList<PersonnelVO> findByPosition(PositionType position) throws RemoteException;

	/**
	 * 增加人员
	 * 
	 * @param vo
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMessage add(PersonnelVO vo) throws RemoteException;

	/**
	 * 删除人员
	 * 
	 * @param vo
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMessage delete(String id) throws RemoteException;

	/**
	 * 更新人员信息
	 * 
	 * @param vo
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMessage update(PersonnelVO vo) throws RemoteException;

	/**
	 * 显示所有人员信息
	 * 
	 * @return
	 * @throws RemoteException 
	 */
	public ArrayList<PersonnelVO> show() throws RemoteException;
}
