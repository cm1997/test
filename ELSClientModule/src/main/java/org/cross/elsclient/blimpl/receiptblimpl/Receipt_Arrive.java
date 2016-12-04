//package org.cross.elsclient.blimpl.receiptblimpl;
//
//import org.cross.elsclient.vo.Receipt_ArriveVO;
//import org.cross.elscommon.po.GoodsPO;
//import org.cross.elscommon.po.HistoryPO;
//import org.cross.elscommon.po.Receipt_TransPO;
//import org.cross.elscommon.util.GoodsState;
//import org.cross.elscommon.util.ResultMessage;
//
//public class Receipt_Arrive {
//	
//	/**
//	 * 增加到达单，更新GoodsPO,更新VehiclePO
//	 * @param vo
//	 * @return
//	 */
//	public ResultMessage add(Receipt_ArriveVO vo){
//		MockGoods goodsUT = new MockGoods();
//		
//		MockVehicle vehicleUT = new MockVehicle();
//		Receipt_Trans trans = new Receipt_Trans();
//		
//		Receipt_TransPO transPO = trans.findByID(vo.transNumber);
//		
//		vehicleUT.setOutuse(transPO.getVehicleNumber());
//		
//		for (int i = 0; i < vo.goods.size(); i++) {
//			GoodsPO po = goodsUT.toPO(vo.goods.get(i));
//			po.setCurrentLocate(vo.city);
//			po.setGoodsState(GoodsState.DIE);
//			HistoryPO history = new HistoryPO(vo.time, vo.city,vo.org,true);
//			po.setHistoryPO(history);
//			if(goodsUT.update(po) == ResultMessage.FAILED) return ResultMessage.FAILED;
//		}
//		
//		return ResultMessage.SUCCESS;
//	}
//	
//}
