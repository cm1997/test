/**
 * 车辆管理服务接口
 * @author raychen
 * @date 2015/10/19
 */
package org.cross.elsclient.blservice.vehicleblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.util.ResultMessage;
import org.cross.elsclient.vo.VehicleVO;

public interface VehicleBLService {
	
	/**
	 * 增加车辆信息
	 * @param vo
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMessage add(VehicleVO vo) throws RemoteException;
	
	/**
	 * 删除车辆信息
	 * @param number
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMessage delete(String number) throws RemoteException;
	
	/**
	 * 更新车辆信息
	 * @param vo
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMessage update(VehicleVO vo) throws RemoteException;
	
	/**
	 * 显示车辆信息
	 * @return
	 * @throws RemoteException 
	 */
	public ArrayList<VehicleVO> show() throws RemoteException;
	
	/**
	 * 根据名称模糊查找
	 * @param name
	 * @return
	 * @throws RemoteException 
	 */
	public ArrayList<VehicleVO> find(String name) throws RemoteException;
	
	public ArrayList<VehicleVO> findByOrg(String orgNum) throws RemoteException;
}
