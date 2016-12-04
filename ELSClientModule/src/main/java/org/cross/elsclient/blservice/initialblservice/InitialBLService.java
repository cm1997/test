/**
 * 期初建账业务逻辑接口
 * @author Polaris Chen
 * @date 2015/10/23
 */
package org.cross.elsclient.blservice.initialblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.util.ResultMessage;
import org.cross.elsclient.vo.OrganizationVO;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elsclient.vo.VehicleVO;
import org.cross.elsclient.vo.StockVO;
import org.cross.elsclient.vo.AccountVO;
import org.cross.elsclient.vo.InitialVO;

public interface InitialBLService {

	/**
	 * 返回所有账本
	 * 
	 * @return 账本列表
	 * @throws RemoteException 
	 */
	public ArrayList<InitialVO> show() throws RemoteException;

	/**
	 * 初始化建账
	 * 
	 * @param vo
	 * @return 建账成功与否消息
	 * @throws RemoteException 
	 */
	public ResultMessage addInitial(InitialVO vo) throws RemoteException;

	/**
	 * 返回对应账本机构信息
	 * 
	 * @param vo
	 * @return 机构列表
	 * @throws RemoteException 
	 */
	public ArrayList<OrganizationVO> showOrganization(String initialID) throws RemoteException;

	/**
	 * 返回对应账本人员信息
	 * 
	 * @param vo
	 * @return 人员列表
	 * @throws RemoteException 
	 */
	public ArrayList<PersonnelVO> showPersonnel(String initialID) throws RemoteException;

	/**
	 * 返回对应账本车辆信息
	 * 
	 * @param vo
	 * @return 车辆列表
	 * @throws RemoteException 
	 */
	public ArrayList<VehicleVO> showVehicle(String initialID) throws RemoteException;

	/**
	 * 返回对应账本库存信息
	 * 
	 * @param vo
	 * @return 库存列表
	 * @throws RemoteException 
	 */
	public ArrayList<StockVO> showStock(String initialID) throws RemoteException;

	/**
	 * 返回对应账本账户信息
	 * 
	 * @param vo
	 * @return 账户列表
	 * @throws RemoteException 
	 */
	public ArrayList<AccountVO> showAccount(String initialID) throws RemoteException;
}
