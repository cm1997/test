/**
 * 期初建账数据接口
 * @author Polaris Chen
 * @date 2015/10/23
 */
package org.cross.elscommon.dataservice.initialdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.po.AccountPO;
import org.cross.elscommon.po.InitialPO;
import org.cross.elscommon.po.OrganizationPO;
import org.cross.elscommon.po.PersonnelPO;
import org.cross.elscommon.po.StockPO;
import org.cross.elscommon.po.VehiclePO;
import org.cross.elscommon.util.ResultMessage;

public interface InitialDataService extends Remote{

	public ResultMessage insert(InitialPO po) throws RemoteException;
	public ResultMessage insertInitAccount(AccountPO po, String initNum) throws RemoteException;
	public ResultMessage insertInitVehicle(VehiclePO po, String initNum) throws RemoteException;
	public ResultMessage insertInitOrganization(OrganizationPO po, String initNum) throws RemoteException;
	public ResultMessage insertInitPersonnel(PersonnelPO po, String initNum) throws RemoteException;
	public ResultMessage insertInitStock(StockPO po, String initNum) throws RemoteException;

	public ArrayList<InitialPO> show() throws RemoteException;

	public InitialPO findByID(String initialID) throws RemoteException;
	public ArrayList<AccountPO> findInitAccounts(String initialID) throws RemoteException;
	public ArrayList<OrganizationPO> findInitOrganizations(String initialID) throws RemoteException;
	public ArrayList<PersonnelPO> findInitPersonnels(String initialID) throws RemoteException;
	public ArrayList<VehiclePO> findInitVehicles(String initialID) throws RemoteException;
	public ArrayList<StockPO> findInitStocks(String initialID) throws RemoteException;
}
