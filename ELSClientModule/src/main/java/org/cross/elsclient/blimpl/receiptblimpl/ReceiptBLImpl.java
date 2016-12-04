package org.cross.elsclient.blimpl.receiptblimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.util.HSSFColor.ORANGE;
import org.cross.elscommon.dataservice.receiptdataservice.ReceiptDataService;
import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.util.ApproveType;
import org.cross.elscommon.util.CompareTime;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elsclient.blimpl.blUtility.GoodsInfo;
import org.cross.elsclient.blimpl.blUtility.ReceiptInfo;
import org.cross.elsclient.blimpl.blUtility.StockInfo;
import org.cross.elsclient.blimpl.goodsblimpl.GoodsInfoImpl;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.network.Datafactory;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.ReceiptVO;

public class ReceiptBLImpl implements ReceiptBLService{
	
	ReceiptDataService receiptdata;
	ReceiptInfo receiptInfo;
	
	GoodsInfo goodsInfo;
	
	public ReceiptBLImpl(ReceiptDataService receiptdata, ReceiptInfo receiptInfo, GoodsInfo goodsInfo){
		this.receiptdata = receiptdata;
		this.receiptInfo = receiptInfo;
		
		this.goodsInfo = goodsInfo;
	}
	
	@Override
	public ResultMessage add(ReceiptVO vo) throws RemoteException {
		ReceiptPO po = receiptInfo.toPO(vo);
		if(receiptdata.insert(po) == ResultMessage.FAILED) return ResultMessage.FAILED;
//		switch (vo.type) {
//		//如果是订单，则更新对应goods的orderNum，生成goodspo应在ui层调用goodsbl进行
//		case ORDER:
//			Receipt_OrderPO order = (Receipt_OrderPO)po;
//			goodsInfo.addToOrder(order.getGoodsNum(), order.getNumber());
//			break;
//		//到达单，更新goods
//		case ARRIVE:
//			Receipt_ArrivePO arri = (Receipt_ArrivePO)po;
//			ArrayList<String> argoodslist = arri.getGoodslist();
//			for (int i = 0; i < argoodslist.size(); i++) {
//				goodsInfo.addToArri(argoodslist.get(i), arri.getNumber());
//			}
//			break;
//		//转运单，更新goods
//		case TRANS:
//			Receipt_TransPO trans = (Receipt_TransPO)po;
//			ArrayList<String> trgoodslist = trans.getOrders();
//			for (int i = 0; i < trgoodslist.size(); i++) {
//				goodsInfo.addToArri(trgoodslist.get(i), trans.getNumber());
//			}
//			break;
//		default:
//			break;
//		}
		ConstantVal.currentReceipts = null;
		show();
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(String number,ReceiptType type) throws RemoteException {
		ConstantVal.currentReceipts = null;
		show();
		return receiptdata.delete(number,type);
	}

	@Override
	public ResultMessage update(ReceiptVO vo) throws RemoteException {
		ConstantVal.currentReceipts = null;
		show();
		return receiptdata.update(receiptInfo.toPO(vo));
	}

	@Override
	public ArrayList<ReceiptVO> show() throws RemoteException {
		ArrayList<ReceiptVO> vos = new ArrayList<ReceiptVO>();
		if (ConstantVal.currentReceipts!=null) {
//			System.out.println("show:"+ConstantVal.currentReceipts.size());
			return ConstantVal.currentReceipts;
		}
		ArrayList<ReceiptPO> list = receiptdata.show();
		for (int i = 0; i < list.size(); i++) {
			ReceiptVO vo = receiptInfo.toVO(list.get(i));
			vos.add(vo);
		}
		ConstantVal.currentReceipts = vos;
		return vos;
	}

	@Override
	public ReceiptVO findByID(String names) throws RemoteException {
		ArrayList<ReceiptVO> list = ConstantVal.currentReceipts;
//		ReceiptPO po = receiptdata.findByNum(names);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).number.equals(names)) {
				return list.get(i);
			}
		}
		return null;
//		return receiptInfo.toVO(po);
	}

	@Override
	public ResultMessage check(ReceiptVO vo, ApproveType approveState) throws RemoteException {
		ConstantVal.currentReceipts = null;
		show();
		return receiptdata.updateCheck(vo.number, approveState.toString());
	}

	@Override
	public ArrayList<ReceiptVO> findByTime(String startTime, String endTime) throws RemoteException {
//		ArrayList<ReceiptPO> po = receiptdata.findByTime(startTime, endTime);
		ArrayList<ReceiptVO> vo = new ArrayList<ReceiptVO>();
		for (ReceiptVO receiptVO : ConstantVal.currentReceipts) {
			vo.add(receiptVO);
		}
		Iterator<ReceiptVO> ite = vo.iterator();
		while (ite.hasNext()) {
			ReceiptVO v = ite.next();
			if (CompareTime.compare(v.time, startTime) != 1
					|| CompareTime.compare(endTime, v.time) != 1) {
//				ReceiptPO po = findByNum(rs.getString("number"));
				ite.remove();
			}
		}
//		if (po == null) {
//			return null;
//		}else {
//			int size = po.size();
//			for (int i = 0; i < size; i++) {
//				vo.add(receiptInfo.toVO(po.get(i)));
//			}
//		}
		return vo;
	}

	@Override
	public ArrayList<ReceiptVO> findByType(ReceiptType type) throws RemoteException {
//		ArrayList<ReceiptPO> po = receiptdata.findByType(type);
		ArrayList<ReceiptVO> vo = new ArrayList<ReceiptVO>();
		for (ReceiptVO receiptVO : ConstantVal.currentReceipts) {
			vo.add(receiptVO);
		}
		Iterator<ReceiptVO> ite = vo.iterator();
		while (ite.hasNext()) {
			ReceiptVO v = ite.next();
			if (!v.type.equals(type)){
				ite.remove();
			}
		}
		
//		if (po == null) {
//			return null;
//		}else {
//			int size = po.size();
//			for (int i = 0; i < size; i++) {
//				vo.add(receiptInfo.toVO(po.get(i)));
//			}
//		}
		return vo;
	}

	@Override
	public ArrayList<ReceiptVO> findByTimeAndType(String startTime, String endTime, ReceiptType type) throws RemoteException {
//		ArrayList<ReceiptPO> po = receiptdata.findByTimeAndType(startTime, endTime, type);
		ArrayList<ReceiptVO> vo = findByTime(startTime, endTime);
		Iterator<ReceiptVO> ite = vo.iterator();
		while (ite.hasNext()) {
			ReceiptVO v = ite.next();
			if (!v.type.equals(type)){
				ite.remove();
			}
		}
//		if (po == null) {
//			return null;
//		}else {
//			int size = po.size();
//			for (int i = 0; i < size; i++) {
//				vo.add(receiptInfo.toVO(po.get(i)));
//			}
//		}
		return vo;
	}

	@Override
	public ArrayList<ReceiptVO> findByUser(String userId) throws RemoteException {
		ArrayList<ReceiptVO> vo = new ArrayList<ReceiptVO>();
		for (ReceiptVO receiptVO : ConstantVal.currentReceipts) {
			vo.add(receiptVO);
		}
		Iterator<ReceiptVO> ite = vo.iterator();
		while (ite.hasNext()) {
			ReceiptVO v = ite.next();
			if (!v.perNum.equals(userId)){
				ite.remove();
			}
		}
//		ArrayList<ReceiptPO> polist = receiptdata.findByPerNum(userId);
//		for (int i = 0; i < polist.size(); i++) {
//			volist.add(receiptInfo.toVO(polist.get(i)));
//		}
		return vo;
	}

	@Override
	public ArrayList<ReceiptVO> findByOrgan(String organId) throws RemoteException {
		ArrayList<ReceiptVO> vo = new ArrayList<ReceiptVO>();
		for (ReceiptVO receiptVO : ConstantVal.currentReceipts) {
			vo.add(receiptVO);
		}
		Iterator<ReceiptVO> ite = vo.iterator();
		while (ite.hasNext()) {
			ReceiptVO v = ite.next();
			if (!v.orgNum.equals(organId)){
				ite.remove();
			}
		}
//		ArrayList<ReceiptPO> polist = receiptdata.findByOrgNum(organId);
//		for (int i = 0; i < polist.size(); i++) {
//			volist.add(receiptInfo.toVO(polist.get(i)));
//		}
		return vo;
	}
	
	public static void main(String[] args){
		Datafactory faDatafactory = new Datafactory();
		ReceiptBLImpl impl = null;
		GoodsInfoImpl ginfo = null;
		ReceiptInfoImpl rinfo = null;
		try {
			rinfo = new ReceiptInfoImpl(faDatafactory.getReceiptData());
			ginfo = new GoodsInfoImpl(faDatafactory.getGoodsData(), rinfo);
			rinfo.goodsInfo = ginfo;
			impl = new ReceiptBLImpl(faDatafactory.getReceiptData(), rinfo, ginfo);
			ConstantVal.currentReceipts = impl.show();

			ArrayList<ReceiptVO> list = impl.show();
			list = impl.show();
			System.out.println(list.size());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
