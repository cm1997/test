package org.cross.elsclient.vo;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.PositionType;

public class ConstantVO {
	/**
	 * 价格常量 单位：每公里公斤
	 */
	public double price;

	/**
	 * 北京到上海的距离
	 */
	public double distance_Beijing_Shanghai;

	/**
	 * 北京到南京的距离
	 */
	public double distance_Beijing_Nanjing;

	/**
	 * 北京到广州的距离
	 */
	public double distance_Beijing_Guangzhou;

	/**
	 * 南京到广州的距离
	 */
	public double distance_Nanjing_Shanghai;

	/**
	 * 南京到上海的距离
	 */
	public double distance_Nanjing_Guangzhou;

	/**
	 * 广州到上海的距离
	 */
	public double distance_Shanghai_Guangzhou;

	/**
	 * 预计每公里时间
	 */
	public double timeBykilo;

	/**
	 * 底薪
	 */
	public double baseMoneyForCOURIER;

	public double baseMoneyForBUSINESSHALLCLERK;

	public double baseMoneyForTRANSITCENTERCLERK;

	public double baseMoneyForSTOCKKEEPER;

	public double baseMoneyForCOUNTER;

	public double baseMoneyForMANAGER;

	public double baseMoneyForADMINISTRATOR;

	public double baseMoneyForDriver;

	public double num;

	public double once;

	public ConstantVO() {
		price = 23;
		distance_Beijing_Guangzhou = 1888.8;
		distance_Beijing_Nanjing = 900;
		distance_Beijing_Shanghai = 1064.7;
		distance_Nanjing_Guangzhou = 1132;
		distance_Nanjing_Shanghai = 266;
		distance_Shanghai_Guangzhou = 1213;
		timeBykilo = 0.06;
		baseMoneyForCOURIER = 0;
		baseMoneyForBUSINESSHALLCLERK = 0;
		baseMoneyForTRANSITCENTERCLERK = 0;
		baseMoneyForSTOCKKEEPER = 0;
		baseMoneyForCOUNTER = 0;
		baseMoneyForMANAGER = 0;
		baseMoneyForADMINISTRATOR = 0;
		baseMoneyForDriver = 0;
		num = 0;
		once = 0;

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
			return baseMoneyForDriver;
		return 0;
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
}


	


