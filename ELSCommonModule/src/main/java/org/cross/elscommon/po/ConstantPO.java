package org.cross.elscommon.po;

import java.io.Serializable;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.UserType;

public class ConstantPO implements Serializable {

	/**
	 * 价格常量 单位：每公里公斤
	 */
	private double price;

	/**
	 * 北京到上海的距离
	 */
	private double distance_Beijing_Shanghai;

	/**
	 * 北京到南京的距离
	 */
	private double distance_Beijing_Nanjing;

	/**
	 * 北京到广州的距离
	 */
	private double distance_Beijing_Guangzhou;

	/**
	 * 南京到广州的距离
	 */
	private double distance_Nanjing_Shanghai;

	/**
	 * 南京到上海的距离
	 */
	private double distance_Nanjing_Guangzhou;

	/**
	 * 广州到上海的距离
	 */
	private double distance_Shanghai_Guangzhou;

	/**
	 * 每公里预计时间，单位：秒
	 */
	private double timeBykilo;

	/**
	 * 底薪，快递员
	 */
	private double baseMoneyForCOURIER;

	/**
	 * 底薪，营业厅业务员
	 */
	private double baseMoneyForBUSINESSHALLCLERK;

	/**
	 * 底薪，中转中心业务员
	 */
	private double baseMoneyForTRANSITCENTERCLERK;

	/**
	 * 底薪，仓库管理人员
	 */
	private double baseMoneyForSTOCKKEEPER;

	/**
	 * 底薪，财务人员
	 */
	private double baseMoneyForCOUNTER;

	/**
	 * 底薪，总经理
	 */
	private double baseMoneyForMANAGER;

	/**
	 * 底薪，系统管理人员
	 */
	private double baseMoneyForADMINISTRATOR;

	/**
	 * 底薪，司机
	 */
	private double baseMoneyForDRIVER;

	/**
	 * 计次
	 */
	private double once;

	/**
	 * 提成
	 */
	private double num;

	public double getTimeBykilo() {
		return timeBykilo;
	}

	public void setTimeBykilo(double timeBykilo) {
		this.timeBykilo = timeBykilo;
	}

	public double getDistance(City c1, City c2) {
		if (c1 == City.BEIJING && c2 == City.GUANGZHOU || c2 == City.BEIJING && c1 == City.GUANGZHOU)
			return distance_Beijing_Guangzhou;
		if (c1 == City.BEIJING && c2 == City.SHANGHAI || c2 == City.BEIJING && c1 == City.SHANGHAI)
			return distance_Beijing_Shanghai;
		if (c1 == City.BEIJING && c2 == City.NANJING || c2 == City.BEIJING && c1 == City.NANJING)
			return distance_Beijing_Nanjing;
		if (c1 == City.NANJING && c2 == City.GUANGZHOU || c2 == City.NANJING && c1 == City.GUANGZHOU)
			return distance_Nanjing_Guangzhou;
		if (c1 == City.SHANGHAI && c2 == City.GUANGZHOU || c2 == City.SHANGHAI && c1 == City.GUANGZHOU)
			return distance_Shanghai_Guangzhou;
		if (c1 == City.NANJING && c2 == City.SHANGHAI || c2 == City.NANJING && c1 == City.SHANGHAI)
			return distance_Nanjing_Shanghai;
		return 0;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getOnce() {
		return once;
	}

	public void setOnce(double once) {
		this.once = once;
	}

	public double getNum() {
		return num;
	}

	public void setNum(double num) {
		this.num = num;
	}

	public double getDistance_Beijing_Shanghai() {
		return distance_Beijing_Shanghai;
	}

	public void setDistance_Beijing_Shanghai(double distance_Beijing_Shanghai) {
		this.distance_Beijing_Shanghai = distance_Beijing_Shanghai;
	}

	public double getDistance_Beijing_Nanjing() {
		return distance_Beijing_Nanjing;
	}

	public void setDistance_Beijing_Nanjing(double distance_Beijing_Nanjing) {
		this.distance_Beijing_Nanjing = distance_Beijing_Nanjing;
	}

	public double getDistance_Beijing_Guangzhou() {
		return distance_Beijing_Guangzhou;
	}

	public void setDistance_Beijing_Guangzhou(double distance_Beijing_Guangzhou) {
		this.distance_Beijing_Guangzhou = distance_Beijing_Guangzhou;
	}

	public double getDistance_Nanjing_Shanghai() {
		return distance_Nanjing_Shanghai;
	}

	public void setDistance_Nanjing_Shanghai(double distance_Nanjing_Shanghai) {
		this.distance_Nanjing_Shanghai = distance_Nanjing_Shanghai;
	}

	public double getDistance_Nanjing_Guangzhou() {
		return distance_Nanjing_Guangzhou;
	}

	public void setDistance_Nanjing_Guangzhou(double distance_Nanjing_Guangzhou) {
		this.distance_Nanjing_Guangzhou = distance_Nanjing_Guangzhou;
	}

	public double getDistance_Shanghai_Guangzhou() {
		return distance_Shanghai_Guangzhou;
	}

	public void setDistance_Shanghai_Guangzhou(double distance_Shanghai_Guangzhou) {
		this.distance_Shanghai_Guangzhou = distance_Shanghai_Guangzhou;
	}

	public void setBaseMoney(PositionType user, double money) {
		if (user == PositionType.ADMINISTRATOR)
			baseMoneyForADMINISTRATOR = money;
		if (user == PositionType.BUSINESSHALLCLERK)
			baseMoneyForBUSINESSHALLCLERK = money;
		if (user == PositionType.COUNTER)
			baseMoneyForCOUNTER = money;
		if (user == PositionType.COURIER)
			baseMoneyForCOURIER = money;
		if (user == PositionType.MANAGER)
			baseMoneyForMANAGER = money;
		if (user == PositionType.STOCKKEEPER)
			baseMoneyForSTOCKKEEPER = money;
		if (user == PositionType.TRANSITCENTERCLERK)
			baseMoneyForTRANSITCENTERCLERK = money;
		if (user == PositionType.DRIVER)
			baseMoneyForDRIVER = money;
	}

	public double getBaseMoney(PositionType user) {
		if (user == PositionType.ADMINISTRATOR)
			return baseMoneyForADMINISTRATOR;
		if (user == PositionType.BUSINESSHALLCLERK)
			return baseMoneyForBUSINESSHALLCLERK;
		if (user == PositionType.COUNTER)
			return baseMoneyForCOUNTER;
		if (user == PositionType.COURIER)
			return baseMoneyForCOURIER;
		if (user == PositionType.MANAGER)
			return baseMoneyForMANAGER;
		if (user == PositionType.STOCKKEEPER)
			return baseMoneyForSTOCKKEEPER;
		if (user == PositionType.TRANSITCENTERCLERK)
			return baseMoneyForTRANSITCENTERCLERK;
		if (user == PositionType.DRIVER)
			return baseMoneyForDRIVER;
		return 0;
	}

	public ConstantPO() {
		price = 1;
		timeBykilo = 1;
		baseMoneyForADMINISTRATOR = 4000;
		baseMoneyForBUSINESSHALLCLERK = 5000;
		baseMoneyForCOUNTER = 6000;
		baseMoneyForCOURIER = 3000;
		baseMoneyForMANAGER = 8000;
		baseMoneyForSTOCKKEEPER = 4000;
		baseMoneyForTRANSITCENTERCLERK = 6000;
		setBaseMoneyForDRIVER(3000);
		distance_Beijing_Guangzhou = 1888.8;
		distance_Beijing_Nanjing = 900;
		distance_Beijing_Shanghai = 1064.7;
		distance_Nanjing_Guangzhou = 1132;
		distance_Nanjing_Shanghai = 266;
		distance_Shanghai_Guangzhou = 1213;
	}

	public double getBaseMoneyForDRIVER() {
		return baseMoneyForDRIVER;
	}

	public void setBaseMoneyForDRIVER(double baseMoneyForDRIVER) {
		this.baseMoneyForDRIVER = baseMoneyForDRIVER;
	}
}
