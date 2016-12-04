/**
 * 车辆管理数据接口
 * @author raychen
 * @date 2015/10/19
 */
package org.cross.elscommon.dataservice.vehicledataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.po.VehiclePO;
import org.cross.elscommon.util.ResultMessage;

public interface VehicleDataService extends Remote{
	public ResultMessage insert(VehiclePO po) throws RemoteException;
	public ResultMessage delete(String number) throws RemoteException;
	public ResultMessage update(VehiclePO po) throws RemoteException;
	public ArrayList<VehiclePO> show() throws RemoteException;
	public VehiclePO findByID(String number) throws RemoteException;
}
