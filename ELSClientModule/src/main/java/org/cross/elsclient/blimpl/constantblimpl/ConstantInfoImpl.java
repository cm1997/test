package org.cross.elsclient.blimpl.constantblimpl;

import org.cross.elsclient.blimpl.blUtility.ConstantInfo;
import org.cross.elsclient.vo.ConstantVO;
import org.cross.elscommon.po.ConstantPO;
import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.UserType;

public class ConstantInfoImpl implements ConstantInfo{
	@Override
	public ConstantVO toConstantVO(ConstantPO po) {
		ConstantVO vo = new ConstantVO();
		vo.baseMoneyForADMINISTRATOR = po.getBaseMoney(PositionType.ADMINISTRATOR);
		vo.baseMoneyForBUSINESSHALLCLERK = po.getBaseMoney(PositionType.BUSINESSHALLCLERK);
		vo.baseMoneyForCOUNTER = po.getBaseMoney(PositionType.COUNTER);
		vo.baseMoneyForCOURIER = po.getBaseMoney(PositionType.COURIER);
		vo.baseMoneyForMANAGER = po.getBaseMoney(PositionType.MANAGER);
		vo.baseMoneyForSTOCKKEEPER = po.getBaseMoney(PositionType.STOCKKEEPER);
		vo.baseMoneyForTRANSITCENTERCLERK = po.getBaseMoney(PositionType.TRANSITCENTERCLERK);
		vo.baseMoneyForDriver = po.getBaseMoney(PositionType.DRIVER);
		vo.distance_Beijing_Guangzhou = po.getDistance_Beijing_Guangzhou();
		vo.distance_Beijing_Nanjing = po.getDistance_Beijing_Nanjing();
		vo.distance_Beijing_Shanghai = po.getDistance_Beijing_Shanghai();
		vo.distance_Nanjing_Guangzhou = po.getDistance_Nanjing_Guangzhou();
		vo.distance_Nanjing_Shanghai = po.getDistance_Nanjing_Shanghai();
		vo.distance_Shanghai_Guangzhou = po.getDistance_Shanghai_Guangzhou();
		vo.price = po.getPrice();
		vo.timeBykilo = po.getTimeBykilo();
		vo.once = po.getOnce();
		vo.num = po.getNum();
		return vo;
	}

	@Override
	public ConstantPO toConstantPO(ConstantVO vo) {
		ConstantPO po = new ConstantPO();
		po.setBaseMoney(PositionType.ADMINISTRATOR, vo.baseMoneyForADMINISTRATOR);
		po.setBaseMoney(PositionType.BUSINESSHALLCLERK, vo.baseMoneyForBUSINESSHALLCLERK);
		po.setBaseMoney(PositionType.COUNTER, vo.baseMoneyForCOUNTER);
		po.setBaseMoney(PositionType.COURIER, vo.baseMoneyForCOURIER);
		po.setBaseMoney(PositionType.MANAGER, vo.baseMoneyForMANAGER);
		po.setBaseMoney(PositionType.STOCKKEEPER, vo.baseMoneyForSTOCKKEEPER);
		po.setBaseMoney(PositionType.TRANSITCENTERCLERK, vo.baseMoneyForTRANSITCENTERCLERK);
		po.setBaseMoney(PositionType.DRIVER, vo.baseMoneyForDriver);
		
		po.setPrice(vo.price);
		po.setTimeBykilo(vo.timeBykilo);
		
		po.setDistance_Beijing_Guangzhou(vo.distance_Beijing_Guangzhou);
		po.setDistance_Beijing_Nanjing(vo.distance_Beijing_Nanjing);
		po.setDistance_Beijing_Shanghai(vo.distance_Beijing_Shanghai);
		po.setDistance_Nanjing_Guangzhou(vo.distance_Nanjing_Guangzhou);
		po.setDistance_Nanjing_Shanghai(vo.distance_Nanjing_Shanghai);
		po.setDistance_Shanghai_Guangzhou(vo.distance_Shanghai_Guangzhou);
		
		po.setOnce(vo.once);
		po.setNum(vo.num);
		return po;
	}

}
