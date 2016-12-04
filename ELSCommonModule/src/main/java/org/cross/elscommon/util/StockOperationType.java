package org.cross.elscommon.util;

public enum StockOperationType {
	STOCKOUT, // 出库
	STOCKIN;// 入库
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		switch (this) {
		case STOCKOUT:
			return "出库";
		case STOCKIN:
			return "入库";
		default:
			return null;
		}
	} 
}
