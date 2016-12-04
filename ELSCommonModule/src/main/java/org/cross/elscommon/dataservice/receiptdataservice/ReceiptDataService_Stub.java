///**
// * 单据数据桩程序
// * @author raychen
// * @date 2015/10/20
// */
//package org.cross.elscommon.dataservice.receiptdataservice;
//
//import java.rmi.RemoteException;
//import java.rmi.server.UnicastRemoteObject;
//import java.util.ArrayList;
//
//import org.cross.elscommon.po.ReceiptPO;
//import org.cross.elscommon.util.ReceiptType;
//import org.cross.elscommon.util.ResultMessage;
//
//public class ReceiptDataService_Stub extends UnicastRemoteObject implements ReceiptDataService{
//
//	public ReceiptDataService_Stub() throws RemoteException {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	@Override
//	public ResultMessage insert(ReceiptPO po) {
//		// TODO Auto-generated method stub
//		if (po.getNumber() == "R120151023000001") {
//			System.out.println("insert succeed!");
//		}else System.out.println("insert failed!");
//		return ResultMessage.SUCCESS;
//	}
//
//	@Override
//	public ResultMessage delete(ReceiptPO po) {
//		// TODO Auto-generated method stub
//		if (po.getNumber() == "R120151023000001") {
//			System.out.println("delete succeed!");
//		}else System.out.println("delete failed!");
//		return ResultMessage.SUCCESS;
//	}
//
//	@Override
//	public ResultMessage update(ReceiptPO po) {
//		// TODO Auto-generated method stub
//		if (po.getNumber() == "R120151023000001") {
//			System.out.println("update succeed!");
//		}else System.out.println("update failed!");
//		return ResultMessage.SUCCESS;
//	}
//
//	@Override
//	public ArrayList<ReceiptPO> show() {
//		// TODO Auto-generated method stub
//		ArrayList<ReceiptPO> list = new ArrayList<ReceiptPO>();
//		list.add(new ReceiptPO("R120151023000001", ReceiptType.ORDER, "2015-10-22 10:23:22"));
//		return list;
//	}
//
//	@Override
//	public ReceiptPO findByID(String names) {
//		// TODO Auto-generated method stub
//		ReceiptPO receipt = new ReceiptPO("R120151023000001", ReceiptType.ORDER, "2015-10-22 10:23:22");
//		return receipt;
//	}
//
//
//	@Override
//	public ArrayList<ReceiptPO> findByTime(String startTime, String endTime) throws RemoteException {
//		// TODO Auto-generated method stub
//		ArrayList<ReceiptPO> list = new ArrayList<ReceiptPO>();
//		list.add(new ReceiptPO("R120151023000001", ReceiptType.ORDER, "2015-10-22 10:23:22"));
//		return list;
//	}
//
//	@Override
//	public ArrayList<ReceiptPO> findByType(ReceiptType type) throws RemoteException {
//		// TODO Auto-generated method stub
//		ArrayList<ReceiptPO> list = new ArrayList<ReceiptPO>();
//		list.add(new ReceiptPO("R120151023000001", ReceiptType.ORDER, "2015-10-22 10:23:22"));
//		return list;
//	}
//
//	@Override
//	public ArrayList<ReceiptPO> findByTimeAndType(String startTime, String endTime, ReceiptType type)
//			throws RemoteException {
//		ArrayList<ReceiptPO> list = new ArrayList<ReceiptPO>();
//		list.add(new ReceiptPO("R120151023000001", ReceiptType.ORDER, "2015-10-22 10:23:22"));
//		return list;
//	}
//
//}
