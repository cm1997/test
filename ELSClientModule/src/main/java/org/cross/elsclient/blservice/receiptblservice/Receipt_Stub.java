package org.cross.elsclient.blservice.receiptblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elsclient.vo.ReceiptVO;
import org.cross.elsclient.vo.Receipt_MoneyInVO;
import org.cross.elsclient.vo.Receipt_TransVO;
import org.cross.elscommon.util.ApproveType;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;

public class Receipt_Stub implements ReceiptBLService{
	
	ArrayList<ReceiptVO> receiptlist;
	
	public Receipt_Stub(){
		receiptlist = new ArrayList<ReceiptVO>();
//		Receipt_MoneyInVO test1 = new Receipt_MoneyInVO("2013-1-2 10:21:12", 20.1, new PersonnelVO("P00001", "灿海", PositionType.COURIER, OrganizationType.BUSINESSHALL, "O00001"), "R0100001");
//		receiptlist.add(test1);
	}

	@Override
	public ResultMessage add(ReceiptVO vo) throws RemoteException {
		for (int i = 0; i < receiptlist.size(); i++) {
			if (receiptlist.get(i).number.equals(vo.number)) {
				return ResultMessage.FAILED;
			}
		}
		receiptlist.add(vo);
		System.out.println("add:");
		print();
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(String number, ReceiptType type) throws RemoteException {
		for (int i = 0; i < receiptlist.size(); i++) {
			if (receiptlist.get(i).number.equals(number)) {
				receiptlist.remove(i);
				System.out.println("delete");
				print();
				return ResultMessage.SUCCESS;
			}
		}
		return ResultMessage.FAILED;
	}

	@Override
	public ResultMessage update(ReceiptVO vo) throws RemoteException {
		for (int i = 0; i < receiptlist.size(); i++) {
			if (receiptlist.get(i).number.equals(vo.number)) {
				receiptlist.remove(i);
				receiptlist.add(vo);
				System.out.println("update:"+vo.number);
				print();
				return ResultMessage.SUCCESS;
			}
		}
		return ResultMessage.FAILED;
	}

	@Override
	public ArrayList<ReceiptVO> show() throws RemoteException {
		return receiptlist;
	}

	@Override
	public ReceiptVO findByID(String names) throws RemoteException {
		for (int i = 0; i < receiptlist.size(); i++) {
			if (receiptlist.get(i).number.equals(names)) {
				return receiptlist.get(i);
			}
		}
		return null;
	}

	@Override
	public ResultMessage check(ReceiptVO vo, ApproveType approveState) throws RemoteException {
		for (int i = 0; i < receiptlist.size(); i++) {
			if (vo.number.equals(receiptlist.get(i).number)) {
				receiptlist.get(i).approveState = approveState;
				System.out.println("check:");
				print();
				return ResultMessage.SUCCESS;
			}
		}
		return ResultMessage.FAILED;
	}

	@Override
	public ArrayList<ReceiptVO> findByTime(String startTime, String endTime) throws RemoteException {
//		ArrayList<ReceiptVO> findbyTime = new ArrayList<ReceiptVO>();
//		for (int i = 0; i < receiptlist.size(); i++) {
//			
//		}
		return null;
	}

	@Override
	public ArrayList<ReceiptVO> findByType(ReceiptType type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ReceiptVO> findByTimeAndType(String startTime, String endTime, ReceiptType type)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void print(){
		for (int i = 0; i < receiptlist.size(); i++) {
			System.out.println(receiptlist.get(i).number+"  "+receiptlist.get(i).type.toString()+"  "+receiptlist.get(i).time+"  "+receiptlist.get(i).approveState.toString());
		}
		System.out.println("-----------------------");
	}

	@Override
	public ArrayList<ReceiptVO> findByUser(String userId)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ReceiptVO> findByOrgan(String organId)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
