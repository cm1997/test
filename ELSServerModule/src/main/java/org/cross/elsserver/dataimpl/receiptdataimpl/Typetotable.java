package org.cross.elsserver.dataimpl.receiptdataimpl;

import org.cross.elscommon.util.ReceiptType;

public class Typetotable {
	public static String gettable(ReceiptType type){
		switch (type) {
		
		case ORDER:	
			return "receiptOrder";
		case TRANS:
			return "receipttrans";
		case ARRIVE:
			return "receiptarrive";
		case STOCKIN:
			return "receiptstockin";
		case STOCKOUT:
			return "receiptstockout";
		case MONEYIN:
			return "receiptmoneyin";
		case MONEYOUT:
			return "receiptmoneyout";
		case TOTALMONEYIN:
			return "receipttotalmoneyin";
		case DELIVER:
			return "receiptDeliver";
		default:
			return null;
		}
	}
}
