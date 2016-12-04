package org.cross.elsclient.test;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.OrganizationInfo;
import org.cross.elsclient.blimpl.blUtility.SalaryInfo;
import org.cross.elsclient.blimpl.goodsblimpl.GoodsBLImpl;
import org.cross.elsclient.blimpl.goodsblimpl.GoodsInfoImpl;
import org.cross.elsclient.blimpl.organizationblimpl.OrganizationInfoImpl;
import org.cross.elsclient.blimpl.personnelblimpl.PersonnelInfoImpl;
import org.cross.elsclient.blimpl.receiptblimpl.ReceiptBLImpl;
import org.cross.elsclient.blimpl.receiptblimpl.ReceiptInfoImpl;
import org.cross.elsclient.blimpl.salaryblimpl.SalaryBLImpl;
import org.cross.elsclient.blimpl.stockblimpl.StockInfoImpl;
import org.cross.elsclient.blservice.goodsblservice.GoodsBLService;
import org.cross.elsclient.network.Datafactory;
import org.cross.elsclient.vo.GoodsVO;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elsclient.vo.ReceiptVO;
import org.cross.elsclient.vo.Receipt_ArriveVO;
import org.cross.elsclient.vo.Receipt_DeliverVO;
import org.cross.elsclient.vo.Receipt_MoneyInVO;
import org.cross.elsclient.vo.Receipt_MoneyOutVO;
import org.cross.elsclient.vo.Receipt_OrderVO;
import org.cross.elsclient.vo.Receipt_StockInVO;
import org.cross.elsclient.vo.Receipt_StockOutVO;
import org.cross.elsclient.vo.Receipt_TotalMoneyInVO;
import org.cross.elsclient.vo.Receipt_TransVO;
import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;
import org.cross.elscommon.util.City;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StockType;

public class ReceiptBLTest {
	public static void main(String[] args) throws RemoteException {
		// 新建单据
		// ·订单
		String goodsNum1 = "R0000001";
		String goodsNum2 = "R0000002";
		String courierNum = "U001"; // 建单快递员编号
		String orgNum = "O001"; // 订单所属营业厅
		Receipt_OrderVO order1 = new Receipt_OrderVO("R0000001", "2015-10-01 19:30", 20, "2015-10-01 18:00",
				"2015-10-03", "陈丹妮", "13333333333", null, "江苏省南京市南京大学仙林校区", "南京大学", "陈睿", "南京大学", "江苏省南京市南京大学仙林校区",
				"18351000000", null, courierNum, orgNum);
		Receipt_OrderVO order2 = new Receipt_OrderVO("R0000002", "2015-10-01 19:31", 30, "2015-10-01 18:01",
				"2015-10-03", "陈丹妮", "13333333333", null, "江苏省南京市南京大学仙林校区", "南京大学", "陈睿", "南京大学", "江苏省南京市南京大学仙林校区",
				"18351000000", null, courierNum, orgNum);

		GoodsVO goods1 = new GoodsVO(goodsNum1, StockType.COMMON, City.NANJING, OrganizationType.BUSINESSHALL, 20, 20);
		GoodsVO goods2 = new GoodsVO(goodsNum2, StockType.Fast, City.NANJING, OrganizationType.BUSINESSHALL, 10, 30);

		// 到达单
		String transNum = "T0000001";
		String arriPerNum = "U002"; // 到达单生成者编号
		Receipt_ArriveVO arrive1 = new Receipt_ArriveVO("R0000003", "2015-12-08 23:58", "O001", "R0000011",
				"2015-12-08 20:01", "O002", arriPerNum);
		Receipt_ArriveVO arrive2 = new Receipt_ArriveVO("R0000004", "2015-12-08 23:59", "O001", "R0000011",
				"2015-12-08 20:01", "O003", arriPerNum);
		DataFactoryService dataFactory = new Datafactory();

		// 收款单
		String moneyInPerNum = "U003";
		ArrayList<String> orders = new ArrayList<String>();
		orders.add("R0000001");
		orders.add("R0000002");
		Receipt_MoneyInVO moneyIn1 = new Receipt_MoneyInVO("2015-12-08 19:38", 20, courierNum, "R0000005", orders,
				orgNum, moneyInPerNum);

		// 付款单
		String receiverID1 = "332431425216241327";
		String receiverID2 = "648327462854542689";
		String senderID = "736287697009809809";
		String moneyOutPerNum = "U004";
		String headquatersNum = "O002";
		Receipt_MoneyOutVO moneyOut1 = new Receipt_MoneyOutVO("R0000007", "2015-12-09 14:00", 2000, receiverID1,
				senderID, "人员工资", "快递员工资", moneyOutPerNum, headquatersNum);
		Receipt_MoneyOutVO moneyOut2 = new Receipt_MoneyOutVO("R0000008", "2015-12-09 14:01", 2100, receiverID2,
				senderID, "人员工资", "快递员工资", moneyOutPerNum, headquatersNum);

		// 入库单
		String stockInPerNum = "U005";
		String stockOrg = "O003";
		String targetOrgID = "O004";
		String commonAreaNum = "SA0000001";
		String fastAreaNum = "SA0000002";
		Receipt_StockInVO stockIn1 = new Receipt_StockInVO("R0000009", "2015-12-09 00:07 ", goodsNum1, targetOrgID,
				commonAreaNum, stockInPerNum, stockOrg);
		Receipt_StockInVO stockIn2 = new Receipt_StockInVO("R0000010", "2015-12-09 00:08 ", goodsNum2, targetOrgID,
				fastAreaNum, stockInPerNum, stockOrg);

		// 装车单
		String transPerNum = "U006";
		String observerNum = "P007";
		String driverNum = "P008";
		String vehicleNum = "V001";
		Receipt_TransVO trans1 = new Receipt_TransVO("R0000011", "2015-12-09 12:11", orders, 100, transNum, vehicleNum,
				stockOrg, targetOrgID, observerNum, driverNum, transPerNum);

		// 出库单
		String stockOutPerNum = "U009";
		String vehicle = "汽车";
		Receipt_StockOutVO stockOut1 = new Receipt_StockOutVO("R0000013", "2015-12-09 13:01", goodsNum1, targetOrgID,
				vehicle, transNum, stockOutPerNum, stockOrg);
		Receipt_StockOutVO stockOut2 = new Receipt_StockOutVO("R0000014", "2015-12-09 13:01", goodsNum2, targetOrgID,
				vehicle, transNum, stockOutPerNum, stockOrg);

		// 总收款单
		String totalMoneyPerNum = "U010";
		String receiver = "3652653156928780187";
		ArrayList<Receipt_MoneyInVO> receipt_Moneyins = new ArrayList<Receipt_MoneyInVO>();
		receipt_Moneyins.add(moneyIn1);
		Receipt_TotalMoneyInVO totalMoney1 = new Receipt_TotalMoneyInVO("R0000015", "2015-12-09 17:18", receiver, 100,
				receipt_Moneyins, totalMoneyPerNum, headquatersNum);
		// 派件单
		String deliverPerNum = "U011";
		String posterNum = "U012";
		Receipt_DeliverVO deliver1 = new Receipt_DeliverVO("R0000017", "2015-12-10 11:00", goodsNum1, "cdn", posterNum,
				deliverPerNum, targetOrgID);
		Receipt_DeliverVO deliver2 = new Receipt_DeliverVO("R0000018", "2015-12-10 11:01", goodsNum2, "cdn", posterNum,
				deliverPerNum, targetOrgID);

		// -------------------------------------------------------------------------------

		GoodsInfoImpl goodsInfo = new GoodsInfoImpl(dataFactory.getGoodsData());
		GoodsBLService goodsbl = new GoodsBLImpl(dataFactory.getGoodsData(), goodsInfo);

		OrganizationInfo orgInfo = new OrganizationInfoImpl(dataFactory.getOrganizationData());
		StockInfoImpl stockInfo = new StockInfoImpl(goodsInfo, orgInfo, dataFactory.getStockData());
		SalaryInfo salaryInfo = new SalaryBLImpl(dataFactory.getSalaryData());
		PersonnelInfoImpl personnelInfo = new PersonnelInfoImpl(dataFactory.getPersonnelData(), salaryInfo);
		ReceiptInfoImpl receiptInfo = new ReceiptInfoImpl(dataFactory.getReceiptData());
		receiptInfo.goodsInfo = goodsInfo;
		receiptInfo.stockInfo = stockInfo;
		personnelInfo.receiptInfo = receiptInfo;
		ReceiptBLImpl receiptBLImpl = new ReceiptBLImpl(dataFactory.getReceiptData(), receiptInfo, goodsInfo);

//		System.out.println("---test - add---");
//		ArrayList<String> orderNumbers = new ArrayList<String>();
//		orderNumbers.add("R0000001");
//		orderNumbers.add("R0000002");
//		orderNumbers.add("R0000003");
//		Receipt_MoneyInVO newVO = new Receipt_MoneyInVO("2015-10-10-11:11", 20, "灿海", "M00002", orderNumbers,
//				"O0000001", "P00001");
		// ReceiptVO newVO = new ReceiptVO("0001", ReceiptType.ARRIVE,
		// "2015-10-10-11:11");
//		ResultMessage addMessage = receiptBLImpl.add(totalMoney1);
////		ResultMessage addgoods = goodsbl.addGoods(goods2);
//		if (addMessage == ResultMessage.SUCCESS ) {
//			System.out.println("增加成功");
//		} else {
//			System.out.println("增加失败");
//		}
//		 System.out.println("---test - delete---");
//		 ResultMessage delMessage = receiptBLImpl.delete("R0000001",
//		 ReceiptType.ORDER);
//		 if (delMessage == ResultMessage.SUCCESS) {
//		 System.out.println("删除成功");
//		 } else {
//		 System.out.println("删除失败");
//		 }
//		 System.out.println("---test - update---");
//		 order2.moneyinNum = "R0000005";
//		 ResultMessage updateMessage = receiptBLImpl.update(order2);
//		 if (updateMessage == ResultMessage.SUCCESS) {
//		 System.out.println("更新成功");
//		 } else {
//		 System.out.println("更新失败");
//		 }
//		 System.out.println("---test - show---");
//		 ArrayList<ReceiptVO> shows = receiptBLImpl.show();
//		 if (shows == null) {
//		 System.out.println("是空的");
//		 } else {
//		 int size = shows.size();
//		 for (int i = 0; i < size; i++) {
//		 System.out.println(shows.get(i).number + " "
//		 + shows.get(i).type.toString());
//		 }
//		 }
//		 System.out.println("---test - findByID---");
//		 ReceiptVO idVO = receiptBLImpl.findByID("R0000015");
//		 if (idVO == null) {
//		 System.out.println("查找失败");
//		 } else {
//		 System.out.println(idVO.number + " " + idVO.time + " "
//		 + idVO.type.toString());
//		 }
		//
		// System.out.println("---test - check---");
		//
//		 System.out.println("---test - findByTime---");
//		 ArrayList<ReceiptVO> timeVOs = receiptBLImpl.findByTime(
//		 "2015-10-10 11:10:09", "2015-12-10 11:19:09");
//		 if (timeVOs == null) {
//		 System.out.println("查找失败");
//		 } else {
//		 int size2 = timeVOs.size();
//		 for (int i = 0; i < size2; i++) {
//		 System.out.println(timeVOs.get(i).number + " "
//		 + timeVOs.get(i).type.toString());
//		 }
//		 }
//		 System.out.println("---test - findByType---");
//		 ArrayList<ReceiptVO> typeVO = receiptBLImpl
//		 .findByType(ReceiptType.MONEYIN);
//		 int size3 = typeVO.size();
//		 for (int i = 0; i < size3; i++) {
//		 System.out.println(typeVO.get(i).number + " " + typeVO.get(i).time
//		 + " " + typeVO.get(i).type);
//		 }
//		 System.out.println("---test - findByTimeAndType---");
//		 ArrayList<ReceiptVO> tatVO = receiptBLImpl.findByTimeAndType(
//		 "2015-10-1", "2015-10-2", ReceiptType.ORDER);
//		 for (int i = 0; i < tatVO.size(); i++) {
//		 System.out.println(tatVO.get(i).number + " " + tatVO.get(i).time
//		 + " " + tatVO.get(i).type);
//		 }
		//
//		 System.out.println("---test - findByUser---");
//		 ArrayList<ReceiptVO> urVO = receiptBLImpl.findByUser("U003");
//		 for (int i = 0; i < urVO.size(); i++) {
//		 System.out.println(urVO.get(i).number + " " + urVO.get(i).time
//		 + " " + urVO.get(i).type);
//		 }
		//
//		 System.out.println("---test - findByOrgan---");
//		 ArrayList<ReceiptVO> orVO = receiptBLImpl.findByOrgan("O002");
//		 for (int i = 0; i < orVO.size(); i++) {
//		 System.out.println(orVO.get(i).number + " " + orVO.get(i).time
//		 + " " + orVO.get(i).type);
//		 }
	}
}
