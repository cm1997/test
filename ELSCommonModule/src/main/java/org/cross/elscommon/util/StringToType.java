package org.cross.elscommon.util;

public class StringToType {
	
	public static GoodsState toGoodsState(String state){
		switch (state) {
		case "完好":
			return GoodsState.LIVE;
		case "部分损坏":
			return GoodsState.LITTLEDIE;
		case "损坏":
			return GoodsState.DIE;
		case "遗失":
			return GoodsState.MISSING;
		default:
			return null;
		}
	}
	
	public static City toCity(String city){
		switch (city) {
		case "北京":
			return City.BEIJING;
		case "上海":
			return City.SHANGHAI;
		case "南京":
			return City.NANJING;
		case "广州":
			return City.GUANGZHOU;
		default:
			return null;
		}
	}
	
	public static StockType toGoodsType(String goodsType){
		switch (goodsType) {
		case "标准快递仓库":
		case "标准快件":
			return StockType.COMMON;
		case "特快仓库":
		case "特快快件":
			return StockType.Fast;
		case "经济快递仓库":
		case "经济快件":
			return StockType.ECONOMICAL;
		default:
			return null;
		}
	}
	
	public static VehicleType toVehicleType(String vehicle){
		switch (vehicle) {
		case "汽车":
			return VehicleType.CAR;
		case "飞机":
			return VehicleType.PLANE;
		case "火车":
			return VehicleType.TRAIN;
		default:
			return null;
		}
	}
	
	public static OrganizationType toOrg(String org){
		switch (org) {
		case "营业厅":
			return OrganizationType.BUSINESSHALL;
		case "中转中心":
			return OrganizationType.TRANSITCENTER;
		case "总部":
			return OrganizationType.HEADQUARTERS;
		default:
			return null;
		}
	}
	
	public static StockOperationType toStockOperation(String stockop){
		switch (stockop) {
		case "出库":	
			return StockOperationType.STOCKOUT;
		case "入库":
			return StockOperationType.STOCKIN;
		default:
			return null;
		}
	}
	
	public static ReceiptType toReceiptType(String receipt){
		switch (receipt) {
		case "订单":
			return ReceiptType.ORDER;
		case "到达单":
			return ReceiptType.ARRIVE;
		case "入库单":
			return ReceiptType.STOCKIN;
		case "出库单":
			return ReceiptType.STOCKOUT;
		case "收款单":
			return ReceiptType.MONEYIN;
		case "付款单":
			return ReceiptType.MONEYOUT;
		case "转运单":
			return ReceiptType.TRANS;
		case "总收款单":
			return ReceiptType.TOTALMONEYIN;
		case "派件单":
			return ReceiptType.DELIVER;
		default:
			return null;
		}
	}
	
	public static PositionType toPositionType(String position){
		switch (position) {
		case "快递员":
			return PositionType.COURIER;
		case "司机":
			return PositionType.DRIVER;
		case "营业厅业务员":
			return PositionType.BUSINESSHALLCLERK;
		case "中转中心业务员":
			return PositionType.TRANSITCENTERCLERK;
		case "仓库管理人员":
			return PositionType.STOCKKEEPER;
		case "财务人员":
			return PositionType.COUNTER;
		case "总经理":
			return PositionType.MANAGER;
		case "系统管理员":
			return PositionType.ADMINISTRATOR;
		default:
			return null;
		}
	}
	
	public static UserType toUserType(String user){
		switch (user) {
		case "快递员":
			return UserType.COURIER;
		case "营业厅业务员":
			return UserType.BUSINESSHALLCLERK;
		case "中转中心业务员":
			return UserType.TRANSITCENTERCLERK;
		case "仓库管理人员":
			return UserType.STOCKKEEPER;
		case "财务人员":
			return UserType.COUNTER;
		case "高级财务人员":
			return UserType.SUPERCOUNTER;
		case "总经理":
			return UserType.MANAGER;
		case "系统管理员":
			return UserType.ADMINISTRATOR;
		default:
			return null;
		}
	}
	
	public static ApproveType toApproveType(String approve){
		switch (approve) {
		case "尚未审批":
			return ApproveType.UNCHECKED;
		case "审批通过":
			return ApproveType.APPROVED;
		case "审批未通过":
			return ApproveType.NOT_APPROVED;
		default:
			return null;
		}
	}
	
	public static SalaryType toSalaryType(String salary){
		switch (salary) {
		case "按月":
			return SalaryType.BYMONTHONLY;
		case "计次":
			return SalaryType.ADDONCE;
		case "提成":
			return SalaryType.ADDNUM;
		default:
			return null;
		}
	}
}
