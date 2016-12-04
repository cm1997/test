package org.cross.elscommon.util;

public enum OrganizationType {
	BUSINESSHALL, // 营业厅
	TRANSITCENTER, // 中转中心
	HEADQUARTERS;// 总部

	public String toString() {
		switch (this) {
		case BUSINESSHALL:
			return "营业厅";
		case TRANSITCENTER:
			return "中转中心";
		case HEADQUARTERS:
			return "总部";
		default:
			return null;
		}
	} 
	
	
	public static String[] toStrings(){
		String types[] = {BUSINESSHALL.toString(),TRANSITCENTER.toString(),HEADQUARTERS.toString()};
		return types;
	}
}
