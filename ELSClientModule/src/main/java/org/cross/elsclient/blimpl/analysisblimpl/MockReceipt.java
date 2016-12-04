//package org.cross.elsclient.blimpl.analysisblimpl;
//
//import java.util.ArrayList;
//
//import org.cross.elsclient.blimpl.receiptblimpl.Receipt;
//import org.cross.elsclient.vo.PersonnelVO;
//import org.cross.elsclient.vo.ReceiptVO;
//import org.cross.elsclient.vo.Receipt_MoneyInVO;
//import org.cross.elsclient.vo.Receipt_MoneyOutVO;
//import org.cross.elscommon.util.OrganizationType;
//import org.cross.elscommon.util.PositionType;
//import org.cross.elscommon.util.ReceiptType;
//
//public class MockReceipt extends Receipt{
//
//	/**
//	 * 根据类型查找单据
//	 */
//	public ArrayList<ReceiptVO> findByType(ReceiptType type){
//		if (type == ReceiptType.MONEYIN) {
//			ArrayList<ReceiptVO> vo = new ArrayList<ReceiptVO>();
//			Receipt_MoneyInVO vvo = new Receipt_MoneyInVO(".....", 200, new PersonnelVO("id1", "小明", PositionType.STOCKKEEPER, OrganizationType.STOCK,"S00001"), "00000");
//			vo.add(vvo);
//			return vo;
//		}else if(type == ReceiptType.MONEYOUT){
//			PersonnelVO per = new PersonnelVO("id1", "小明", PositionType.STOCKKEEPER, OrganizationType.STOCK,"S00001");
//			ArrayList<ReceiptVO> vo = new ArrayList<ReceiptVO>();
//			Receipt_MoneyOutVO vvo = new Receipt_MoneyOutVO("00000", "time", 91,per, "id2", "条目1", "无备注");
//			vo.add(vvo);
//			return vo;
//		}
//		return null;
//	}
//	
//}
