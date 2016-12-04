package org.cross.elscommon.util;

public class MyTime {
	public int year;
	public int month;
	public int day;
	
	public int hour;
	public int min;
	public int sec;
	
	public MyTime(int year, int month, int day, int hour, int min, int sec) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.min = min;
		this.sec = sec;
	}
	
	public int compareOne(int a, int b){
		if(a>b) return 1;
		if(a<b) return -1;
		return 0;
	}
	
	public int compareWith(MyTime time){
		int c1 = compareOne(year, time.year);
		if(c1!=0) return c1;
		int c2 = compareOne(month, time.month);
		if(c2!=0) return c2;
		int c3 = compareOne(day, time.day);
		if(c3!=0) return c3;
		
		int c4 = compareOne(hour, time.hour);
		if(c4!=0) return c4;
		int c5 = compareOne(min, time.min);
		if(c5!=0) return c5;
		return compareOne(sec, time.sec);
	}
	
	public void print(){
		System.out.println(year+" "+month+" "+day+" "+hour+" "+min+" "+sec);
	}
}
