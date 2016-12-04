package org.cross.elsclient.blservice.vehicleblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.vo.VehicleVO;
import org.cross.elscommon.util.ResultMessage;

public class Vehicle_stub implements VehicleBLService{

	@Override
	public ResultMessage add(VehicleVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(String number) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(VehicleVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VehicleVO> show() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VehicleVO> find(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VehicleVO> findByOrg(String orgNum) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
