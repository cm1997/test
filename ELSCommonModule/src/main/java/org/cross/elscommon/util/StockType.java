package org.cross.elscommon.util;

public enum StockType {
	
	Fast, //特快
	COMMON,//标准快递
	ECONOMICAL;//经济快递
	
	public String toString() {
		switch (this) {
		case Fast:
			return "特快仓库";
		case COMMON:
			return "标准快递仓库";
		case ECONOMICAL:
			return "经济快递仓库";
		default:
			return null;
		}
	}
	
	public String toGoodsString() {
		switch (this) {
		case Fast:
			return "特快快件";
		case COMMON:
			return "标准快件";
		case ECONOMICAL:
			return "经济快件";
		default:
			return null;
		}
	}
	
	public static String[] toStrings(){
		String result[] = {Fast.toString(),COMMON.toString(),ECONOMICAL.toString()};
		return result;
	}
	
	public static String[] toGoodsStrings(){
		String result[] = {Fast.toGoodsString(),COMMON.toGoodsString(),ECONOMICAL.toGoodsString()};
		return result;
	}
	

}
