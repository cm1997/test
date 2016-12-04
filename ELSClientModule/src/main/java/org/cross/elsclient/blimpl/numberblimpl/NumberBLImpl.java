package org.cross.elsclient.blimpl.numberblimpl;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.numberblservice.NumberBLService;
import org.cross.elsclient.network.Datafactory;
import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;
import org.cross.elscommon.dataservice.numberdataservice.NumberDataService;
import org.cross.elscommon.po.NumberPO;
import org.cross.elscommon.util.NumberType;
import org.cross.elscommon.util.ResultMessage;
import org.omg.CORBA.StringHolder;

public class NumberBLImpl implements NumberBLService{
	
	NumberDataService numberdata;
	NumberPO numberpo;
	
	public NumberBLImpl(NumberDataService numberdata){
		this.numberdata = numberdata;
	}

	@Override
	public String getPostNumber(NumberType type) {
		try {
			numberpo = numberdata.show();
			if (numberpo == null) {
				numberpo = new NumberPO();
				numberdata.update(numberpo);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switch (type) {
		case USER:
			return "U"+numberpo.getUserNum();
		case ORGANIZATION:
			return "O"+numberpo.getOrgNum();
		case PERSONNEL:
			return "P"+numberpo.getPerNum();
		case RECEIPT:
			return  "R"+numberpo.getReceiptNum();
		case STOCK:
			return "S"+numberpo.getStockNum();
		case STOCKAREA:
			return "SA"+numberpo.getStockAreaNum();
		case VEHICLE:
			return "V"+numberpo.getVehicleNum();
		case LOG:
			return "L"+numberpo.getLogNum();
		case INITIAL:
			return "I"+numberpo.getInitNum();
			
		default:
			return null;
		}
	}
	
	public String addOne(String number){
		int i = Integer.valueOf(number);
		int l = number.length();
		i ++;
		String left = String.valueOf(i);
		String ans = "";
		for (int j = 0; j < l-left.length(); j++) {
			ans+="0";
		}
		ans+=left;
		return ans;
	}
	
	public NumberPO getPO() throws RemoteException{
		return numberdata.show();
	}
	
	public static void main(String [] args)throws RemoteException{
		DataFactoryService dataFactoryService = new Datafactory();
		NumberDataService numberdata = dataFactoryService.getNumberDataService();
		NumberBLImpl impl = new NumberBLImpl(numberdata);
		String p1 = impl.getPostNumber(NumberType.RECEIPT);
		impl = new NumberBLImpl(dataFactoryService.getNumberDataService());
		String p2 = impl.getPostNumber(NumberType.RECEIPT);
		System.out.println(p1+" "+p2);
	}

	@Override
	public void addone(NumberType type, String number) {
		try {
			numberpo = numberdata.show();
			if (numberpo == null) {
				numberpo = new NumberPO();
				numberdata.update(numberpo);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String n = number.substring(1);
		switch (type) {
		case USER:
			numberpo.setUserNum(addOne(n));
			break;
		case ORGANIZATION:
			numberpo.setOrgNum(addOne(n));
			break;
		case PERSONNEL:
			numberpo.setPerNum(addOne(n));
			break;
		case RECEIPT:
			numberpo.setReceiptNum(addOne(n));
			break;
		case STOCK:
			numberpo.setStockNum(addOne(n));
			break;
		case STOCKAREA:
			numberpo.setStockAreaNum(addOne(n.substring(1)));
			break;
		case VEHICLE:
			numberpo.setVehicleNum(addOne(n));
			break;
		case LOG:
			numberpo.setLogNum(addOne(n));
			break;
		case INITIAL:
			numberpo.setInitNum(addOne(n));
			break;
			
		default:
			break;
		}
		try {
			numberdata.update(numberpo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addsome(NumberType type, String number, int num) {
		for (int i = 0; i < num; i++) {
			addone(type, number);
		}
	}

}
