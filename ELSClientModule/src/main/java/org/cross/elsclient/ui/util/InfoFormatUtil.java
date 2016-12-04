package org.cross.elsclient.ui.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.ResultMessage;

public class InfoFormatUtil {
	private static Pattern numericPattern = Pattern.compile("^[0-9\\-]+$");
	
	public static String CheckFormat(String src,InfoType type){
		if(CheckString(src)!=null){
			return CheckString(src);
		}
		
		switch (type) {
		case NAME:
			return CheckString(src);
		case IDCARD:
			return CheckIDCardFormat(src);//待更改
		case CELLPHONE:
			return CheckCellPhoneFormat(src);
		case NUM:
			return CheckNumFormat(src);
		case PASSWORD:
			return CheckPasswordFormat(src);
		case RECEIPT:
			return checkReceipt(src);//待更改
		case ORGANIZATION:
			return checkOrgan(src);//待更改
		case PERSONNEL:
			return checkPersonnel(src);//待更改
		case STOCKAREA:
			return checkStockArea(src);//待更改
		case PURENUM:
			return CheckPureNumFormat(src);
		default:
			break;
		}
		
		return null;
	}
	
	public static String CheckString(String src){
		if(src.isEmpty()){
			return "信息为空";
		}else {
			return null;
		}
	}
	
	public static String CheckIDCardFormat(String src){
		
		if(CheckNumFormat(src)!=null){
			return CheckNumFormat(src);
		}else if(src.length()!=18){
				return "身份证长度错误!";
		}

		return null;
	}
	
	public static String CheckCellPhoneFormat(String src){
		
		if(CheckNumFormat(src)!=null){
			return CheckNumFormat(src);
		}else if(src.length()!=11){
				return "手机长度错误!";
		}
		return null;
	}
	
	public static String CheckPasswordFormat(String src){
		String result = "";
		
//		if(!isContainUppercase(src)){
//			result += "不包含大写字母 ";
//		}
//		if(!isContainLowwercase(src)){
//			result += "不包含小写字母 ";
//		}
//		if(!isContainNum(src)){
//			result += "不包含数字 ";
//		}
		
		if(result.equals("")){
			return null;
		}else{
			return result;
		}
	}
	
	public static String CheckNumFormat(String src){
		 char c[] = src.toCharArray();
		 
		 for (char ch : c) {
			if(ch<'0'||ch>'9'){
				if(ch!='.'){
					return "包含非数字字符";
				}
			}
		}
		return null;
	}
	
	public static String CheckPureNumFormat(String src){
		 char c[] = src.toCharArray();
		 
		 for (char ch : c) {
			if(ch<'0'||ch>'9'){
				return "包含非数字字符";
			}
		}
		return null;
	}
	
	public static String checkPersonnel(String src){
		if(src.charAt(0)!='P'){
			return "人员编号应以P开头";
		}else if(src.length()!=8){
			return "编号长度应为8位";
		}else if(!isContainNum(src.substring(1,src.length()))){
			return "含非法字符";
		}
		
//		String sub = src.substring(1, 3);
//		if(sub.charAt(0)!='0'||sub.charAt(1)=='9'){
//			return "该人员类型不存在(1~2位)";
//		}
//		
//		sub = src.substring(3, 6);
//		if(!sub.equals("010")||!sub.equals("021")||!sub.equals("020")||!sub.equals("015")){
//			return "该城市不存在(3~5位)";
//		}
		
		return null;
	}
	
	public static String checkOrgan(String src){
		if(src.charAt(0)!='O'){
			return "机构编号应以O开头";
		}else if(src.length()!=8){
			return "编号长度应为8位";
		}else if(!isContainNum(src.substring(1,src.length()))){
			return "含非法字符";
		}
		
//		String sub = src.substring(1, 4);
//		if(!sub.equals("010")||!sub.equals("021")||!sub.equals("020")||!sub.equals("015")){
//			return "该城市不存在(1~3位)";
//		}
		
		return null;
	}
	
	public static String checkReceipt(String src){
		if(src.charAt(0)!='R'){
			return "单据编号应以R开头";
		}else if(src.length()!=8){
			return "编号长度应为8位";
		}else if(!isContainNum(src.substring(1,src.length()))){
			return "含非法字符";
		}
		
		return null;
	}
	
	public static String checkStockArea(String src){
		if(!src.substring(0, 2).equals("SA")){
			return "单据编号应以SA开头";
		}else if(src.length()!=11){
			return "编号长度应为11位";
		}else if(!isContainNum(src.substring(1,src.length()))){
			return "含非法字符";
		}
		return null;
	}
	
	public static boolean isContainUppercase(String src){
		boolean result = false;
		char c[] = src.toCharArray();
		
		for (char ch : c) {
			if(ch>='A'&&ch<='Z'){
				result = true;
				break;
			}
		}
		
		return result;
	}
	public static boolean isContainLowwercase(String src){
		boolean result = false;
		char c[] = src.toCharArray();
		
		for (char ch : c) {
			if(ch>='a'&&ch<='z'){
				result = true;
				break;
			}
		}
		return result;
	}
	public static boolean isContainNum(String src){
		boolean result = false;
		char c[] = src.toCharArray();
		
		for (char ch : c) {
			if(ch>='0'&&ch<='9'){
				result = true;
				break;
			}
		}
		return result;
	}
	
}
