/**
 * 机构数据接口
 * @author Moo
 * @date 2015年10月20日
 */
package org.cross.elscommon.dataservice.organizationdataservice;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.po.OrganizationPO;
import org.cross.elscommon.util.City;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.ResultMessage;

public interface OrganizationDataService extends Remote{
	/**
	 * 增加机构
	 * @para vo
	 * @return ResultMessage
	 */
	public ResultMessage insert(OrganizationPO po) throws RemoteException;
	
	/**
	 * 删除机构
	 * @para vo
	 * @return ResultMessage
	 */
	public ResultMessage delete(String id) throws RemoteException;

	/**
	 * 修改机构
	 * @para vo
	 * @return ResultMessage
	 */
	public ResultMessage update(OrganizationPO po) throws RemoteException;

	/**
	 * 根据所在城市查找机构
	 * @para city
	 * @return ArrayList<OrganizationVO>
	 */
	public ArrayList<OrganizationPO> findByCity(City city) throws RemoteException;
	
	/**
	 * 根据机构类型查找机构
	 * @para type
	 * @return ArrayList<OrganizationVO>
	 */
	public ArrayList<OrganizationPO> findByType(OrganizationType type) throws RemoteException;
	
	/**
	 * 根据ID查找机构
	 * @para id
	 * @return ArrayList<OrganizationVO>
	 */
	public OrganizationPO findById(String id) throws RemoteException;

	/**
	 * 显示机构列表
	 * @para 
	 * @return ArrayList<OrganizationVO>
	 */
	public ArrayList<OrganizationPO> show() throws RemoteException;

}
