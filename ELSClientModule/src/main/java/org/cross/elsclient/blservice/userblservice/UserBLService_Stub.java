package org.cross.elsclient.blservice.userblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.UserType;
import org.cross.elsclient.vo.UserVO;

public class UserBLService_Stub implements UserBLService {

	@Override
	public ResultMessage add(UserVO vo) {
		if(vo.name.equals("雷欧奥特曼")){
			return ResultMessage.FAILED;
		}
		return ResultMessage.SUCCESS;
	}



	@Override
	public ResultMessage update(UserVO vo) {
		if(vo.name.equals("阿斯特拉奥特曼")&&vo.number.equals("001")){
			return ResultMessage.FAILED;
		}
		
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<UserVO> findByName(String name) {
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		list.add(new UserVO("U0000001","12345678", name, UserType.COUNTER,"O0000001"));
		list.add(new UserVO("U0000001","12345678", name, UserType.COUNTER,"O0000001"));
		list.add(new UserVO("U0000001","12345678", name, UserType.COUNTER,"O0000001"));
		list.add(new UserVO("U0000001","12345678", name, UserType.COUNTER,"O0000001"));
		list.add(new UserVO("U0000001","12345678", name, UserType.COUNTER,"O0000001"));
		list.add(new UserVO("U0000001","12345678", name, UserType.COUNTER,"O0000001"));
		
		return list;
	}

	@Override
	public ArrayList<UserVO> findByType(UserType type) {
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		list.add(new UserVO("U0000001","12345678", "迪迦",type,"O0000001"));
		list.add(new UserVO("U0000001","12345678", "迪迦",type,"O0000001"));
		list.add(new UserVO("U0000001","12345678", "迪迦",type,"O0000001"));
		list.add(new UserVO("U0000001","12345678", "迪迦",type,"O0000001"));
		list.add(new UserVO("U0000001","12345678", "迪迦",type,"O0000001"));
		list.add(new UserVO("U0000001","12345678", "迪迦",type,"O0000001"));
		list.add(new UserVO("U0000001","12345678", "迪迦",type,"O0000001"));
		
		
		return list;
	}

	

	@Override
	public ArrayList<UserVO> show() {
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		list.add(new UserVO("U0000001","12345678", "迪迦",UserType.COUNTER,"O0000001"));
		list.add(new UserVO("U0000001","12345678", "迪迦",UserType.COUNTER,"O0000001"));
		list.add(new UserVO("U0000001","12345678", "迪迦",UserType.COUNTER,"O0000001"));
		list.add(new UserVO("U0000001","12345678", "迪迦",UserType.COUNTER,"O0000001"));
		list.add(new UserVO("U0000001","12345678", "迪迦",UserType.COUNTER,"O0000001"));
		list.add(new UserVO("U0000001","12345678", "迪迦",UserType.COUNTER,"O0000001"));
		list.add(new UserVO("U0000001","12345678", "迪迦",UserType.COUNTER,"O0000001"));
		list.add(new UserVO("U0000001","12345678", "迪迦",UserType.COUNTER,"O0000001"));
		list.add(new UserVO("U0000001","12345678", "迪迦",UserType.COUNTER,"O0000001"));
		list.add(new UserVO("U0000001","12345678", "迪迦",UserType.COUNTER,"O0000001"));
		list.add(new UserVO("U0000001","12345678", "迪迦",UserType.COUNTER,"O0000001"));
		
		
		return list;
	}

	@Override
	public UserType login(String id, String password) {
		switch (id) {
		case "1":
			return UserType.ADMINISTRATOR;
		case "2":
			return UserType.BUSINESSHALLCLERK;
		case "3":
			return UserType.TRANSITCENTERCLERK;
		case "4":
			return UserType.COURIER;
		case "5":
			return UserType.STOCKKEEPER;
		case "6":
			return UserType.COUNTER;
		case "7":
			return UserType.SUPERCOUNTER;
		case "8":
			return UserType.MANAGER;
		default:
			break;
		}
		
		
		return UserType.ADMINISTRATOR;
	}


	@Override
	public ResultMessage delete(String id) throws RemoteException {
		return ResultMessage.SUCCESS;
	}

	@Override
	public UserVO findById(String id) throws RemoteException {
		return new UserVO("U0000001","12345678", "迪迦奥特曼", UserType.COUNTER,"O000001");
	}

}
