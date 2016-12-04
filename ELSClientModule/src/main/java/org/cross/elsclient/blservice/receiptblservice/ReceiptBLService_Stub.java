/**
 * 单据服务桩程序
 * @author raychen
 * @date 2015/10/20
 */
package org.cross.elsclient.blservice.receiptblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.util.ApproveType;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elsclient.vo.ReceiptVO;
import org.cross.elsclient.vo.Receipt_MoneyInVO;

public class ReceiptBLService_Stub implements ReceiptBLService{

	@Override
	public ResultMessage add(ReceiptVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(String number,ReceiptType type) {
		// TODO Auto-generated method stub
		if (number == "R120151023000001") {
			return ResultMessage.SUCCESS;
		}else return ResultMessage.FAILED;
	}

	@Override
	public ResultMessage update(ReceiptVO vo) {
		// TODO Auto-generated method stub
		if (vo.number == "R120151023000001") {
			return ResultMessage.SUCCESS;
		}else return ResultMessage.FAILED;
	}

	@Override
	public ArrayList<ReceiptVO> show() {
		// TODO Auto-generated method stub
		ArrayList<ReceiptVO> list = new ArrayList<ReceiptVO>();
		list.add(new ReceiptVO("R120151023000001", ReceiptType.ORDER, "2015-10-22 10:23:22","P000001","O000001"));
		list.add(new ReceiptVO("R120151023000001", ReceiptType.ORDER, "2015-10-22 10:23:22","P000001","O000001"));
		list.add(new ReceiptVO("R120151023000001", ReceiptType.ORDER, "2015-10-22 10:23:22","P000001","O000001"));
		list.add(new ReceiptVO("R120151023000001", ReceiptType.ORDER, "2015-10-22 10:23:22","P000001","O000001"));
		list.add(new ReceiptVO("R120151023000001", ReceiptType.ORDER, "2015-10-22 10:23:22","P000001","O000001"));
		list.add(new ReceiptVO("R120151023000001", ReceiptType.ORDER, "2015-10-22 10:23:22","P000001","O000001"));
		list.get(0).approveState = ApproveType.APPROVED;
		list.get(0).approveState = ApproveType.NOT_APPROVED;
		return list;
	}

	@Override
	public ReceiptVO findByID(String id) {
		// TODO Auto-generated method stub
		ReceiptVO receipt = new ReceiptVO(id, ReceiptType.ORDER, "2015-10-22 10:23:22","P000001","O000001");
		return receipt;
	}
	
	@Override
	public ArrayList<ReceiptVO> findByTime(String startTime, String endTime) {
		// TODO Auto-generated method stub
		ArrayList<ReceiptVO> list = new ArrayList<ReceiptVO>();
		list.add(new ReceiptVO("R120151023000001", ReceiptType.ORDER, "2015-10-22 10:23:22","P000001","O000001"));
		list.add(new ReceiptVO("R120151023000001", ReceiptType.ORDER, "2015-10-22 10:23:22","P000001","O000001"));
		list.add(new ReceiptVO("R120151023000001", ReceiptType.ORDER, "2015-10-22 10:23:22","P000001","O000001"));
		list.add(new ReceiptVO("R120151023000001", ReceiptType.ORDER, "2015-10-22 10:23:22","P000001","O000001"));
		list.add(new ReceiptVO("R120151023000001", ReceiptType.ORDER, "2015-10-22 10:23:22","P000001","O000001"));
		list.add(new ReceiptVO("R120151023000001", ReceiptType.ORDER, "2015-10-22 10:23:22","P000001","O000001"));
		return list;
	}

	@Override
	public ArrayList<ReceiptVO> findByType(ReceiptType type) {
		// TODO Auto-generated method stub
		ArrayList<ReceiptVO> list = new ArrayList<ReceiptVO>();
		if(type == ReceiptType.MONEYIN){
			list.add((ReceiptVO)new Receipt_MoneyInVO("2015-12-12 10:30", 2000, null, "R000001",null, null, null));
			list.add((ReceiptVO)new Receipt_MoneyInVO("2015-12-12 10:30", 2000, null, "R000001",null, null, null));
			list.add((ReceiptVO)new Receipt_MoneyInVO("2015-12-12 10:30", 2000, null, "R000001",null, null, null));
			list.add((ReceiptVO)new Receipt_MoneyInVO("2015-12-12 10:30", 2000, null, "R000001",null, null, null));
			list.add((ReceiptVO)new Receipt_MoneyInVO("2015-12-12 10:30", 2000, null, "R000001",null, null, null));
			list.add((ReceiptVO)new Receipt_MoneyInVO("2015-12-12 10:30", 2000, null, "R000001",null, null, null));
		}else{
			list.add(new ReceiptVO("R120151023000001", type, "2015-10-22 10:23:22","P000001","O000001"));
			list.add(new ReceiptVO("R120151023000001", type, "2015-10-22 10:23:22","P000001","O000001"));
			list.add(new ReceiptVO("R120151023000001", type, "2015-10-22 10:23:22","P000001","O000001"));
			list.add(new ReceiptVO("R120151023000001", type, "2015-10-22 10:23:22","P000001","O000001"));
			list.add(new ReceiptVO("R120151023000001", type, "2015-10-22 10:23:22","P000001","O000001"));
			list.add(new ReceiptVO("R120151023000001", type, "2015-10-22 10:23:22","P000001","O000001"));
		}
		return list;
	}

	@Override
	public ArrayList<ReceiptVO> findByTimeAndType(String startTime, String endTime, ReceiptType type) {
		// TODO Auto-generated method stub
		ArrayList<ReceiptVO> list = new ArrayList<ReceiptVO>();
		list.add(new ReceiptVO("R120151023000001", type, "2015-10-22 10:23:22","P000001","O000001"));
		return list;
	}

	@Override
	public ResultMessage check(ReceiptVO vo, ApproveType approveState) throws RemoteException {
		return ResultMessage.SUCCESS;
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
