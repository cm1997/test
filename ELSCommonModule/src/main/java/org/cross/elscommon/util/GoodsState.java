package org.cross.elscommon.util;

public enum GoodsState {
	LIVE, //完好
	DIE,//损坏
	LITTLEDIE,//部分损坏
	MISSING;//遗失
	
	public String toString(){
		switch (this) {
		case LIVE:
			return "完好";
		case DIE:
			return "损坏";
		case LITTLEDIE:
			return "部分损坏";
		case MISSING:
			return "遗失";
		default:
			return null;
		}
	}
}
