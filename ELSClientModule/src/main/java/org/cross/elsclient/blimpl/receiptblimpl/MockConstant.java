package org.cross.elsclient.blimpl.receiptblimpl;

import org.cross.elsclient.blimpl.constantblimpl.Constant;
import org.cross.elscommon.po.ConstantPO;
import org.cross.elscommon.util.City;

public class MockConstant extends Constant{
	
	ConstantPO cons;
	
	public MockConstant(){
		cons = new ConstantPO();
	}
	
	public String expectTime(City s1, City s2){
		double time = cons.getTimeBykilo()*cons.getDistance(s1, s2);
		return String.valueOf(time);
	}
	
	public double price(City c1, City c2, double weight){
		return cons.getPrice()*weight*cons.getDistance(c1, c2);
	}
}
