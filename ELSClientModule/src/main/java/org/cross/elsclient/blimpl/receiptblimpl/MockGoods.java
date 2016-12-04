//package org.cross.elsclient.blimpl.receiptblimpl;
//
//import org.cross.elsclient.blimpl.goodsblimpl.Goods;
//import org.cross.elsclient.vo.GoodsVO;
//import org.cross.elscommon.po.GoodsPO;
//import org.cross.elscommon.util.City;
//import org.cross.elscommon.util.ResultMessage;
//import org.cross.elscommon.util.StockType;
//
//public class MockGoods extends Goods{
//	public GoodsPO toPO(GoodsVO vo){
//		return new GoodsPO(20, 20, City.NANJING, StockType.COMMON);
//	}
//	
//	public ResultMessage update(GoodsPO po){
//		return ResultMessage.SUCCESS;
//	}
//	
//	public ResultMessage add(GoodsPO po){
//		return ResultMessage.SUCCESS;
//	}
//	
//	public GoodsPO findByID(String id){
//		return new GoodsPO(20, 10, City.BEIJING, StockType.COMMON);
//	}
//}
