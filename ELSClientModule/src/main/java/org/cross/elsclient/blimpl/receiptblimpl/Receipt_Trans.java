//package org.cross.elsclient.blimpl.receiptblimpl;
//
//import org.cross.elsclient.vo.Receipt_TransVO;
//import org.cross.elscommon.po.GoodsPO;
//import org.cross.elscommon.po.HistoryPO;
//import org.cross.elscommon.po.PersonnelPO;
//import org.cross.elscommon.po.Receipt_TransPO;
//import org.cross.elscommon.util.City;
//import org.cross.elscommon.util.GoodsState;
//import org.cross.elscommon.util.OrganizationType;
//import org.cross.elscommon.util.PositionType;
//import org.cross.elscommon.util.ResultMessage;
//
//public class Receipt_Trans {
//	
//	/**
//	 * 增加转运单，调用order寻找goods，更新GoodsPO的state、history，如果是中转中心要出库，更新VehiclePO
//	 * @param vo
//	 * @return
//	 */
//	public ResultMessage add(Receipt_TransVO vo){
//		
//		Receipt_TransVO trans = (Receipt_TransVO)vo;
//		
//		MockGoods goodsUT = new MockGoods();
//		MockStock stockUT = new MockStock();
//
//		String check = vo.number;
//		if(check.charAt(1) == '1'){
//			for (int i = 0; i < vo.orders.size(); i++) {
//				String good = vo.orders.get(i);
//				if(stockUT.outStock(good, check) == ResultMessage.FAILED) return ResultMessage.FAILED;
//			}
//		}
//		
//		MockVehicle vehicleUT = new MockVehicle();
//		vehicleUT.setInuse(vo.vehicleNumber);
//		
//		for(int i=0; i< vo.orders.size(); i++){
//			GoodsPO po = goodsUT.findByID(vo.orders.get(i));
//			po.setCurrentLocate(trans.startCity);
//			po.setGoodsState(GoodsState.LITTLEDIE);
//			HistoryPO history = new HistoryPO(vo.time, trans.startCity, trans.org, false);
//			po.setHistoryPO(history);
//			if(goodsUT.update(po)!=ResultMessage.SUCCESS) return ResultMessage.FAILED;
//		}
//		
//		return ResultMessage.SUCCESS;
//	}
//	
//	public Receipt_TransPO findByID(String id){
//		return new Receipt_TransPO("time", "localnumber", "vehiclenumber",
//				City.BEIJING, City.NANJING, 
//				new PersonnelPO("id", "cjj1", PositionType.ADMINISTRATOR, OrganizationType.BUSINESSHALL, "orgid"), 
//				new PersonnelPO("id", "cjj2", PositionType.ADMINISTRATOR, OrganizationType.BUSINESSHALL, "orgid")
//		, "transnumber", OrganizationType.BUSINESSHALL);
//	}
//}
