/**
 * 账户管理数据接口
 * @author Polaris Chen
 * @date 2015/10/19
 */
package org.cross.elscommon.dataservice.accountdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.po.AccountPO;
import org.cross.elscommon.util.ResultMessage;

public interface AccountDataService extends Remote{

	/**
	 * 按id查找
	 * @para ID
	 * @return AccountPO
	 */
	public AccountPO findbyID(String ID) throws RemoteException;
	/**
	 * 按账户名查找
	 * @para 
	 * @return ArrayList<AccountPO>
	 */
	public ArrayList<AccountPO> findbyName(String name) throws RemoteException;

	/**
	 * 添加账户
	 * @para po
	 * @return ResultMessage
	 */
	public ResultMessage insert(AccountPO po) throws RemoteException;

	/**
	 * 删除账户
	 * @para 
	 * @return ResultMessage
	 */
	public ResultMessage delete(String id) throws RemoteException;

	/**
	 * 更新账户
	 * @para 
	 * @return ResultMessage
	 */
	public ResultMessage update(AccountPO po) throws RemoteException;

	/**
	 * 显示所有账户
	 * @para 
	 * @return ArrayList<AccountPO>
	 */
	public ArrayList<AccountPO> show() throws RemoteException;
}
