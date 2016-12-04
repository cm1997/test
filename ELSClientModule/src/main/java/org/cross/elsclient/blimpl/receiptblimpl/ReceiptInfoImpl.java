package org.cross.elsclient.blimpl.receiptblimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import org.cross.elsclient.blimpl.blUtility.GoodsInfo;
import org.cross.elsclient.blimpl.blUtility.PersonnelInfo;
import org.cross.elsclient.blimpl.blUtility.ReceiptInfo;
import org.cross.elsclient.blimpl.blUtility.StockInfo;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.ReceiptVO;
import org.cross.elsclient.vo.Receipt_ArriveVO;
import org.cross.elsclient.vo.Receipt_DeliverVO;
import org.cross.elsclient.vo.Receipt_MoneyInVO;
import org.cross.elsclient.vo.Receipt_MoneyOutVO;
import org.cross.elsclient.vo.Receipt_OrderVO;
import org.cross.elsclient.vo.Receipt_StockInVO;
import org.cross.elsclient.vo.Receipt_StockOutVO;
import org.cross.elsclient.vo.Receipt_TotalMoneyInVO;
import org.cross.elsclient.vo.Receipt_TransVO;
import org.cross.elscommon.dataservice.receiptdataservice.ReceiptDataService;
import org.cross.elscommon.po.GoodsPO;
import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.po.Receipt_ArrivePO;
import org.cross.elscommon.po.Receipt_DeliverPO;
import org.cross.elscommon.po.Receipt_MoneyInPO;
import org.cross.elscommon.po.Receipt_MoneyOutPO;
import org.cross.elscommon.po.Receipt_OrderPO;
import org.cross.elscommon.po.Receipt_StockInPO;
import org.cross.elscommon.po.Receipt_StockOutPO;
import org.cross.elscommon.po.Receipt_TotalMoneyInPO;
import org.cross.elscommon.po.Receipt_TransPO;
import org.cross.elscommon.util.CompareTime;
import org.cross.elscommon.util.DeCodeString;
import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.StringToType;

public class ReceiptInfoImpl implements ReceiptInfo {

	ReceiptDataService receiptdata;
	public StockInfo stockInfo;
	public PersonnelInfo personnelInfo;
	public GoodsInfo goodsInfo;

	public ReceiptInfoImpl(ReceiptDataService receiptdata) {
		this.receiptdata = receiptdata;
	}

	@Override
	public ReceiptVO toVO(ReceiptPO po) {
		if (po == null) {
			return null;
		}
		switch (po.getType()) {
		case ORDER:
			Receipt_OrderPO realpo = (Receipt_OrderPO) po;
			Receipt_OrderVO order = new Receipt_OrderVO(realpo.getNumber(),
					realpo.getTime(), realpo.getPrice(),
					realpo.getReceiveTime(), realpo.getExpectTime(),
					realpo.getSenderName(), realpo.getSenderMobile(),
					realpo.getSenderPhone(), realpo.getSenderAdd(),
					realpo.getSenderOrg(), realpo.getReceiverName(),
					realpo.getReceiverOrg(), realpo.getReceiverAdd(),
					realpo.getReceiverPhone(), realpo.getReceiverMobile(),
					realpo.getPerNum(), realpo.getOrgNum());
			order.approveState = realpo.getApproveState();
			order.moneyinNum = realpo.getMoneyInNum();
			return order;
		case ARRIVE:
			Receipt_ArrivePO arripo = (Receipt_ArrivePO) po;
			Receipt_ArriveVO arri = new Receipt_ArriveVO(arripo.getNumber(),
					arripo.getTime(), arripo.getStartPlace(),
					arripo.getTransNum(), arripo.getStartTime(),
					arripo.getOrgNum(), arripo.getPerNum());
			arri.approveState = arripo.getApproveState();
			return arri;
		case TRANS:
			Receipt_TransPO transpo = (Receipt_TransPO) po;
			ArrayList<String> goodslist = new ArrayList<String>();
			ArrayList<GoodsPO> goodspo = new ArrayList<GoodsPO>();
			try {
				goodspo = goodsInfo.findByTransNum(transpo.getNumber());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i = 0; i < goodspo.size(); i++) {
				goodslist.add(goodspo.get(i).getOrderNum());
			}
			Receipt_TransVO transvo = new Receipt_TransVO(transpo.getNumber(),
					transpo.getTime(), goodslist, transpo.getCost(),
					transpo.getTransNum(), transpo.getVeNum(),
					transpo.getStartPlace(), transpo.getArrivePlace(),
					transpo.getObserver(), transpo.getDriver(),
					transpo.getPerNum());
			transvo.approveState = transpo.getApproveState();
			
//			System.out.println("goods in trans:"+transvo.goodsID.size());
			
			return transvo;
		case STOCKIN:
			Receipt_StockInPO stockinpo = (Receipt_StockInPO) po;
			Receipt_StockInVO stockinvo = new Receipt_StockInVO(
					stockinpo.getNumber(), stockinpo.getTime(),
					stockinpo.getOrderNum(), stockinpo.getDestination(),
					stockinpo.getStockNum(), stockinpo.getPerNum(),
					stockinpo.getOrgNum());
			stockinvo.approveState = stockinpo.getApproveState();
			return stockinvo;
		case STOCKOUT:
			Receipt_StockOutPO stockoutpo = (Receipt_StockOutPO) po;
			Receipt_StockOutVO stockoutvo = new Receipt_StockOutVO(
					stockoutpo.getNumber(), stockoutpo.getTime(), null,
					stockoutpo.getDestination(), stockoutpo.getTransType()
							.toString(), stockoutpo.getTransNumber(),
					stockoutpo.getPerNum(), stockoutpo.getOrgNum());
			stockoutvo.approveState = stockoutpo.getApproveState();
			return stockoutvo;
		case MONEYIN:
			Receipt_MoneyInPO moneyinpo = (Receipt_MoneyInPO) po;
			ArrayList<String> moneyingoods = new ArrayList<String>();
			try {
				moneyingoods = findByMoneyin(moneyinpo.getNumber());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Receipt_MoneyInVO moneyinvo = new Receipt_MoneyInVO(
					moneyinpo.getTime(), moneyinpo.getMoney(),
					moneyinpo.getPerson(), moneyinpo.getNumber(), moneyingoods,
					moneyinpo.getOrgNum(), moneyinpo.getPerNum());
			moneyinvo.approveState = moneyinpo.getApproveState();
			return moneyinvo;
		case MONEYOUT:
			Receipt_MoneyOutPO moneyoutpo = (Receipt_MoneyOutPO) po;
			Receipt_MoneyOutVO moneyoutvo = new Receipt_MoneyOutVO(
					moneyoutpo.getNumber(), moneyoutpo.getTime(),
					moneyoutpo.getMoney(), moneyoutpo.getAccountNum(),
					moneyoutpo.getSenderNum(), moneyoutpo.getClause(),
					moneyoutpo.getComments(), moneyoutpo.getPerNum(),
					moneyoutpo.getOrgNum());
			moneyoutvo.approveState = moneyoutpo.getApproveState();
			return moneyoutvo;
		case TOTALMONEYIN:
			Receipt_TotalMoneyInPO totalmoneyinpo = (Receipt_TotalMoneyInPO) po;
			ArrayList<Receipt_MoneyInVO> moneyins = new ArrayList<Receipt_MoneyInVO>();
			try {
				moneyins = findByTotalMoneyIn(totalmoneyinpo.getNumber());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Receipt_TotalMoneyInVO totalMoneyInvo = new Receipt_TotalMoneyInVO(
					totalmoneyinpo.getNumber(), totalmoneyinpo.getTime(),
					totalmoneyinpo.getAccountNum(), totalmoneyinpo.getMoney(),
					moneyins, totalmoneyinpo.getPerNum(),
					totalmoneyinpo.getOrgNum());
			totalMoneyInvo.approveState = totalmoneyinpo.getApproveState();
			return totalMoneyInvo;
		case DELIVER:
			Receipt_DeliverPO delpo = (Receipt_DeliverPO) po;
			Receipt_DeliverVO delvo = new Receipt_DeliverVO(delpo.getNumber(),
					delpo.getTime(), delpo.getOrderNum(), delpo.getName(),
					delpo.getPosterNum(), delpo.getPerNum(), delpo.getOrgNum());
			delvo.approveState = delpo.getApproveState();
			return delvo;
		default:
			return null;
		}
	}

	@Override
	public ReceiptPO toPO(ReceiptVO vo) {
		if (vo == null) {
			return null;
		}
		switch (vo.type) {
		case ORDER:
			Receipt_OrderVO ordervo = (Receipt_OrderVO) vo;
			Receipt_OrderPO orderpo = new Receipt_OrderPO(ordervo.number,
					ordervo.type, ordervo.time, ordervo.orgNum, ordervo.perNum,
					ordervo.cost, ordervo.expectTime, ordervo.senderName,
					ordervo.receiverName, ordervo.senderOrg,
					ordervo.receiverOrg, ordervo.senderAdd,
					ordervo.receiverAdd, ordervo.senderPhone,
					ordervo.receiverPhone, ordervo.senderMobile,
					ordervo.receiverMobile);
			orderpo.setReceiveTime(ordervo.receiveTime);
			orderpo.setMoneyInNum(ordervo.moneyinNum);
			orderpo.setApproveState(vo.approveState);
			return orderpo;
		case TRANS:
			Receipt_TransVO transvo = (Receipt_TransVO) vo;
			Receipt_TransPO transpo = new Receipt_TransPO(transvo.number,
					transvo.type, transvo.time, transvo.orgNum, transvo.perNum,
					transvo.cost, transvo.transNum, transvo.vehicleNum,
					transvo.orgNum, transvo.arriveOrgID, transvo.observerName,
					transvo.driverName);
			transpo.setApproveState(vo.approveState);
			return transpo;
		case ARRIVE:
			Receipt_ArriveVO arrivo = (Receipt_ArriveVO) vo;
			Receipt_ArrivePO arripo = new Receipt_ArrivePO(arrivo.number,
					arrivo.type, arrivo.time, arrivo.orgNum, arrivo.perNum,
					arrivo.startOrgID, arrivo.startTime, arrivo.transNum);// 到达的机构就是单据生成的机构。。
			arripo.setApproveState(vo.approveState);
			return arripo;
		case STOCKIN:
			Receipt_StockInVO stockinvo = (Receipt_StockInVO) vo;
			Receipt_StockInPO stockinpo = new Receipt_StockInPO(
					stockinvo.number, stockinvo.type, stockinvo.time,
					stockinvo.orgNum, stockinvo.perNum, stockinvo.goodsNumber,
					stockinvo.stockAreaNum, stockinvo.targetOrgID);
			stockinpo.setApproveState(stockinvo.approveState);
			return stockinpo;
		case STOCKOUT:
			Receipt_StockOutVO stockoutvo = (Receipt_StockOutVO) vo;

			Receipt_StockOutPO stockoutpo = new Receipt_StockOutPO(
					stockoutvo.number, stockoutvo.type, stockoutvo.time,
					stockoutvo.orgNum, stockoutvo.perNum, stockoutvo.goodsNum,
					stockoutvo.targetOrgID,
					StringToType.toVehicleType(stockoutvo.vehicle),
					stockoutvo.transNumber);
			stockoutpo.setApproveState(stockoutvo.approveState);
			return stockoutpo;
		case MONEYIN:
			Receipt_MoneyInVO moneyinvo = (Receipt_MoneyInVO) vo;
			// totalMoneyIn 暂时是NULL
			Receipt_MoneyInPO moneyinpo = new Receipt_MoneyInPO(
					moneyinvo.number, moneyinvo.type, moneyinvo.time,
					moneyinvo.orgNum, moneyinvo.perNum, moneyinvo.money, null,
					moneyinvo.person);
			moneyinpo.setApproveState(vo.approveState);
			return moneyinpo;
		case MONEYOUT:
			Receipt_MoneyOutVO moneyoutvo = (Receipt_MoneyOutVO) vo;
			Receipt_MoneyOutPO moneyoutpo = new Receipt_MoneyOutPO(
					moneyoutvo.number, moneyoutvo.type, moneyoutvo.time,
					moneyoutvo.orgNum, moneyoutvo.perNum, moneyoutvo.money,
					moneyoutvo.receiveID, moneyoutvo.clause,
					moneyoutvo.comments, moneyoutvo.senderID);
			moneyoutpo.setApproveState(vo.approveState);
			return moneyoutpo;
		case TOTALMONEYIN:
			Receipt_TotalMoneyInVO totalmoneyinvo = (Receipt_TotalMoneyInVO) vo;
			Receipt_TotalMoneyInPO totalMoneyInpo = new Receipt_TotalMoneyInPO(
					totalmoneyinvo.number, totalmoneyinvo.type,
					totalmoneyinvo.time, totalmoneyinvo.orgNum,
					totalmoneyinvo.perNum, totalmoneyinvo.sum,
					totalmoneyinvo.perNameID);
			totalMoneyInpo.setApproveState(vo.approveState);
			return totalMoneyInpo;
		case DELIVER:
			Receipt_DeliverVO delvo = (Receipt_DeliverVO) vo;
			Receipt_DeliverPO delpo = new Receipt_DeliverPO(delvo.number,
					ReceiptType.DELIVER, delvo.time, delvo.orgNum,
					delvo.perNum, delvo.orderNum, delvo.name, delvo.posterNum);
			delpo.setApproveState(vo.approveState);
			return delpo;
		default:
			return null;
		}
	}

	@Override
	public ReceiptVO findByID(String names) throws RemoteException {
		// ReceiptPO po = receiptdata.findByNum(names);
		// return toVO(po);
		ArrayList<ReceiptVO> list = ConstantVal.currentReceipts;
		// ReceiptPO po = receiptdata.findByNum(names);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).number.equals(names)) {
				return list.get(i);
			}
		}
		return null;
	}

	@Override
	public ArrayList<String> findByMoneyin(String moneyinNum)
			throws RemoteException {
		ArrayList<ReceiptPO> orders = receiptdata.findByType(ReceiptType.ORDER);
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < orders.size(); i++) {
			Receipt_OrderPO po = (Receipt_OrderPO) orders.get(i);
			if (po.getMoneyInNum() == moneyinNum) {
				list.add(orders.get(i).getNumber());
			}
		}
		return list;
	}

	@Override
	public ArrayList<ReceiptVO> findByTimeAndType(ReceiptType type,
			String start, String end) throws RemoteException {
		// ArrayList<ReceiptPO> polist = receiptdata.findByTimeAndType(start,
		// end, type);
		// ArrayList<ReceiptVO> vos = new ArrayList<ReceiptVO>();
		// for (int i = 0; i < polist.size(); i++) {
		// vos.add(toVO(polist.get(i)));
		// }
		// return vos;
		ArrayList<ReceiptVO> vo = findByTime(start, end);
		Iterator<ReceiptVO> ite = vo.iterator();
		while (ite.hasNext()) {
			ReceiptVO v = ite.next();
			if (!v.type.equals(type)) {
				ite.remove();
			}
		}
		// if (po == null) {
		// return null;
		// }else {
		// int size = po.size();
		// for (int i = 0; i < size; i++) {
		// vo.add(receiptInfo.toVO(po.get(i)));
		// }
		// }
		return vo;
	}

	@Override
	public ArrayList<ReceiptVO> findByType(ReceiptType type)
			throws RemoteException {
		// ArrayList<ReceiptPO> polist = receiptdata.findByType(type);
		// ArrayList<ReceiptVO> vos = new ArrayList<ReceiptVO>();
		// for (int i = 0; i < polist.size(); i++) {
		// vos.add(toVO(polist.get(i)));
		// }
		// return vos;
		ArrayList<ReceiptVO> vo = new ArrayList<ReceiptVO>();
		for (ReceiptVO receiptVO : ConstantVal.currentReceipts) {
			vo.add(receiptVO);
		}
		Iterator<ReceiptVO> ite = vo.iterator();
		while (ite.hasNext()) {
			ReceiptVO v = ite.next();
			if (!v.type.equals(type)) {
				ite.remove();
			}
		}

		// if (po == null) {
		// return null;
		// }else {
		// int size = po.size();
		// for (int i = 0; i < size; i++) {
		// vo.add(receiptInfo.toVO(po.get(i)));
		// }
		// }
		return vo;
	}

	@Override
	public ArrayList<ReceiptVO> findByTime(String start, String end)
			throws RemoteException {
		// ArrayList<ReceiptPO> polist = receiptdata.findByTime(start, end);
		// ArrayList<ReceiptVO> vos = new ArrayList<ReceiptVO>();
		// for (int i = 0; i < polist.size(); i++) {
		// vos.add(toVO(polist.get(i)));
		// }
		// return vos;
		ArrayList<ReceiptVO> vo = new ArrayList<ReceiptVO>();
		for (ReceiptVO receiptVO : ConstantVal.currentReceipts) {
			vo.add(receiptVO);
		}
		Iterator<ReceiptVO> ite = vo.iterator();
		while (ite.hasNext()) {
			ReceiptVO v = ite.next();
			if (CompareTime.compare(v.time, start) != 1
					|| CompareTime.compare(end, v.time) != 1) {
				// ReceiptPO po = findByNum(rs.getString("number"));
				ite.remove();
			}
		}
		// if (po == null) {
		// return null;
		// }else {
		// int size = po.size();
		// for (int i = 0; i < size; i++) {
		// vo.add(receiptInfo.toVO(po.get(i)));
		// }
		// }
		return vo;
	}

	@Override
	public ArrayList<Receipt_MoneyInVO> findByTotalMoneyIn(String totalmoney)
			throws RemoteException {
		ArrayList<ReceiptPO> orders = receiptdata
				.findByType(ReceiptType.MONEYIN);
		ArrayList<Receipt_MoneyInVO> list = new ArrayList<Receipt_MoneyInVO>();
		for (int i = 0; i < orders.size(); i++) {
			Receipt_MoneyInPO po = (Receipt_MoneyInPO) orders.get(i);
			if (po.getTotalMoneyInNum() == totalmoney) {
				list.add((Receipt_MoneyInVO) toVO(po));
			}
		}
		return list;
	}
}
