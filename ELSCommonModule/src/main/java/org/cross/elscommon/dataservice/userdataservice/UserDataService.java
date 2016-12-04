/**
 * 用户数据接口
 * @author Moo
 * @date 2015年10月19日
 */
package org.cross.elscommon.dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.po.UserPO;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.UserType;


public interface UserDataService extends Remote
{
	/**
	 * 增加用户
	 * @para vo
	 * @return ResultMessage
	 */
	public ResultMessage insert(UserPO po) throws RemoteException;
	
	/**
	 * 删除用户
	 * @para vo
	 * @return ResultMessage
	 */
	public ResultMessage delete(String id) throws RemoteException;
	
	/**
	 * 修改用户
	 * @para vo
	 * @return ResultMessage
	 */
	public ResultMessage update(UserPO po) throws RemoteException;
	
	/**
	 * 根据ID模糊查找
	 * @para name
	 * @return ArrayList<UserVO>
	 */
	public UserPO findById(String id) throws RemoteException;
	
	/**
	 * 根据用户类型模糊查找
	 * @para type
	 * @return ArrayList<UserVO>
	 */
	public ArrayList<UserPO> findByType(UserType type) throws RemoteException;
	
	/**
	 * 根据名字模糊查找
	 * @para name
	 * @return ArrayList<UserVO>
	 */
	public ArrayList<UserPO> findByName(String name) throws RemoteException;
	
	/**
	 * 显示所有用户列表
	 * @para 
	 * @return ArrayList<UserVO>
	 */
	public ArrayList<UserPO> show() throws RemoteException;

}
