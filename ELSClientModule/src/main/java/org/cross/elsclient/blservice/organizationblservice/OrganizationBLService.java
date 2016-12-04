/**
 * 机构逻辑接口
 * @author Moo
 * @date 2015年10月19日
 */

package org.cross.elsclient.blservice.organizationblservice;


import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elsclient.vo.OrganizationVO;



public interface OrganizationBLService {
	/**
	 * 增加机构
	 * @para vo
	 * @return ResultMessage
	 * @throws RemoteException 
	 */
	public ResultMessage add(OrganizationVO vo) throws RemoteException;
	
	/**
	 * 删除机构
	 * @para vo
	 * @return ResultMessage
	 * @throws RemoteException 
	 */
	public ResultMessage delete(String number) throws RemoteException;
	
	/**
	 * 修改机构
	 * @para vo
	 * @return ResultMessage
	 * @throws RemoteException 
	 */
	public ResultMessage update(OrganizationVO vo) throws RemoteException;
	
	/**
	 * 显示机构列表
	 * @para 
	 * @return ArrayList<OrganizationVO>
	 * @throws RemoteException 
	 */
	public ArrayList<OrganizationVO> show() throws RemoteException;
	
	/**
	 * 根据所在城市查找机构
	 * @para city
	 * @return ArrayList<OrganizationVO>
	 * @throws RemoteException 
	 */
	public ArrayList<OrganizationVO> findByCity(City city) throws RemoteException;
	
	/**
	 * 根据机构类型查找机构
	 * @para type
	 * @return ArrayList<OrganizationVO>
	 * @throws RemoteException 
	 */
	public ArrayList<OrganizationVO> findByType(OrganizationType type) throws RemoteException;
	
	/**
	 * 根据ID查找机构
	 * @para id
	 * @return OrganizationVO
	 * @throws RemoteException 
	 */
	public OrganizationVO findById(String id) throws RemoteException;
	
}
