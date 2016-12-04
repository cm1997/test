package org.cross.elscommon.util;

public class CompareTime {
	
	public static int compare(String first, String second){
		MyTime time1 = getTime(first);
		MyTime time2 = getTime(second);
		return time1.compareWith(time2);
//		return 0;
	}
	
	public static MyTime getTime(String time){
//		System.out.println(time);
		String[] temp = time.split(" ");
		String[] temp1 = temp[0].split("-");
		String[] temp2 = new String[3];
		temp2[0] = "0";
		temp2[1] = "0";
		temp2[2] = "0";
		if(temp.length == 2) {String[] temp3 = temp[1].split(":");
		temp2[0] = temp3[0];
		temp2[1] = temp3[1];
		if (temp3.length == 3) {
			temp2[2] = temp3[2];
		}}
		
		return new MyTime(Integer.parseInt(temp1[0]), Integer.parseInt(temp1[1]), 
				Integer.parseInt(temp1[2]), Integer.parseInt(temp2[0]), 
				Integer.parseInt(temp2[1]), Integer.parseInt(temp2[2]));
	}
	
	public static void main(String[] args){
		System.out.println(compare("2015-10-23 10:12:01", "2015-12-12 10:20:01"));
	}
}
