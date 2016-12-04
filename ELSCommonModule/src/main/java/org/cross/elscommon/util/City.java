/**
 * 城市枚举
 * @author Polaris Chen
 * @date 2015/10/23
 */
package org.cross.elscommon.util;

public enum City {
	BEIJING(0) , // 北京
	SHANGHAI(1), // 上海
	NANJING(3), // 南京
	GUANGZHOU(6); // 广州
	
	public int value;
	
	City(int value) {  
        this.value = value;  
    }

	public String toString() {
		switch (this) {
		case BEIJING:
			return "北京";
		case SHANGHAI:
			return "上海";
		case NANJING:
			return "南京";
		case GUANGZHOU:
			return "广州";
		default:
			return null;
		}
	}
	public String getNum(){
		switch (this) {
		case BEIJING:
			return "010";
		case SHANGHAI:
			return "021";
		case NANJING:
			return "025";
		case GUANGZHOU:
			return "020";
		default:
			return null;
		}
	}
	public static String[] toStrings(){
		String type[] = {BEIJING.toString(),SHANGHAI.toString(),NANJING.toString(),GUANGZHOU.toString()};
		
		return type;
	}
}
