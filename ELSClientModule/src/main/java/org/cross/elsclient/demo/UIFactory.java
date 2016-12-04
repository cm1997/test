package org.cross.elsclient.demo;

import java.rmi.RemoteException;

import org.cross.elsclient.blimpl.blUtility.GoodsInfo;
import org.cross.elsclient.blimpl.blUtility.ReceiptInfo;
import org.cross.elsclient.blimpl.goodsblimpl.GoodsBLImpl;
import org.cross.elsclient.blimpl.receiptblimpl.ReceiptBLImpl;
import org.cross.elsclient.blimpl.stockblimpl.StockBLImpl;
import org.cross.elsclient.blservice.stockblservice.StockBLService;
import org.cross.elsclient.network.Datafactory;
import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;

public class UIFactory {
	
	StockBLService stockbl;
	GoodsInfo goodsInfo;
	ReceiptInfo receiptInfo;
	
	DataFactoryService dataFactory;
	
//	public UIFactory(){
//		dataFactory = new Datafactory();
//		try {
////			goodsInfo = new GoodsBLImpl(dataFactory.getGoodsData());
////			receiptInfo = new ReceiptBLImpl(goodsInfo, dataFactory.getReceiptData());
////			stockbl = new StockBLImpl(dataFactory.getStockData(), goodsInfo);
////		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public StockUI getStockUI(){
		return new StockUI(stockbl);
	}
}
