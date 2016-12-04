/**
 * 人员管理数据接口
 * @author Polaris Chen
 * @date 2015/10/19
 */
package org.cross.elscommon.dataservice.personneldataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.po.PersonnelPO;
import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.ResultMessage;

public interface PersonnelDataService extends Remote{

	/**
	 * 根据id查找人员
	 * @para 
	 * @return PersonnelPO
	 */
	public PersonnelPO findById(String id) throws RemoteException;

	/**
	 * 根据机构编号查找人员
	 * @para 
	 * @return ArrayList<PersonnelPO>
	 */
	public ArrayList<PersonnelPO> findByOrg(String orgNum) throws RemoteException;
	
	/**
	 * 根据人员职位查找
	 * @para 
	 * @return ArrayList<PersonnelPO>
	 */
	public ArrayList<PersonnelPO> findByPosition(PositionType position) throws RemoteException;
	
	/**
	 * 根据人员姓名查找
	 * @para 
	 * @return ArrayList<PersonnelPO>
	 */
	public ArrayList<PersonnelPO> findByName(String name) throws RemoteException;

	/**
	 * 添加人员
	 * @para 
	 * @return ResultMessage
	 */
	public ResultMessage insert(PersonnelPO po) throws RemoteException;

	/**
	 * 删除人员
	 * @para 
	 * @return ResultMessage
	 */
	public ResultMessage delete(String id) throws RemoteException;

	/**
	 * 更新人员
	 * @para 
	 * @return ResultMessage
	 */
	public ResultMessage update(PersonnelPO po) throws RemoteException;

	/**
	 * 显示所有人员
	 * @para 
	 * @return ArrayList<PersonnelPO>
	 */
	public ArrayList<PersonnelPO> show() throws RemoteException;
	
}
