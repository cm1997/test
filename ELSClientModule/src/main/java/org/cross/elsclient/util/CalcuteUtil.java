package org.cross.elsclient.util;

import java.util.ArrayList;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.StockType;

public class CalcuteUtil {
	
	public static double calcutePrice(StockType type,double distance,double weight, String packCost){
		double result;
		result = ConstantVal.constantbl.show().price*distance*weight;
		switch (type) {
		case Fast:
			result*=1.2;
			break;
		case ECONOMICAL:
			result*=0.8;
		default:
			break;
		}
		switch (packCost) {
		case "纸箱(5元)":
			result+=5;
			break;
		case "木箱(10元)":
			result+=10;
			break;
		case "快递袋(1元)":
			result+=1;
			break;
		default:
			break;
		}
		
		return result;
	}
	
}
