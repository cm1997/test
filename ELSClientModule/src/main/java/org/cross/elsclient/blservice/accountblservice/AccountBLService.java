/**
 * 账户管理业务逻辑接口
 * @author Polaris Chen
 * @date 2015/10/19
 */
package org.cross.elsclient.blservice.accountblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.util.ResultMessage;
import org.cross.elsclient.vo.AccountVO;

public interface AccountBLService {

	/**
	 * 根据账户名称模糊查找账户
	 * 
	 * @param name
	 * @return
	 * @throws RemoteException 
	 */
	public ArrayList<AccountVO> findByName(String name) throws RemoteException;

	/**
	 * 根据账户ID模糊查找账户
	 * 
	 * @param ID
	 * @return
	 * @throws RemoteException 
	 */
	public AccountVO findByID(String ID) throws RemoteException;

	/**
	 * 增加账户
	 * 
	 * @param vo
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMessage add(AccountVO vo) throws RemoteException;

	/**
	 * 删除账户
	 * 
	 * @param ID
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMessage delete(String ID) throws RemoteException;

	/**
	 * 更新账户
	 * 
	 * @param vo
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMessage update(AccountVO vo) throws RemoteException;

	/**
	 * 显示所有账户信息
	 * 
	 * @return
	 * @throws RemoteException 
	 */
	public ArrayList<AccountVO> show() throws RemoteException;
}
