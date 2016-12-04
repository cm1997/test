package org.cross.elscommon.util;

public enum SalaryType {
	BYMONTHONLY, //按月
	ADDONCE, // 计次
	ADDNUM; //提成

	@Override
	public String toString() {
		switch (this){
		case BYMONTHONLY:
			return "按月";
		case ADDNUM:
			return "提成";
		case ADDONCE:
			return "计次";
		default:
			return null;
		}
	} 
	
	
}
