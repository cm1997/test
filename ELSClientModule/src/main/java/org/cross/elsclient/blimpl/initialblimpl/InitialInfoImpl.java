package org.cross.elsclient.blimpl.initialblimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.AccountInfo;
import org.cross.elsclient.blimpl.blUtility.OrganizationInfo;
import org.cross.elsclient.blimpl.blUtility.PersonnelInfo;
import org.cross.elsclient.blimpl.blUtility.StockInfo;
import org.cross.elsclient.blimpl.blUtility.UserInfo;
import org.cross.elsclient.blimpl.blUtility.VehicleInfo;
import org.cross.elsclient.blimpl.userblimpl.UserInfoImpl;
import org.cross.elsclient.vo.AccountVO;
import org.cross.elsclient.vo.InitialVO;
import org.cross.elsclient.vo.OrganizationVO;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elsclient.vo.StockVO;
import org.cross.elsclient.vo.UserVO;
import org.cross.elsclient.vo.VehicleVO;
import org.cross.elscommon.dataservice.initialdataservice.InitialDataService;
import org.cross.elscommon.dataservice.salarydataservice.SalaryDataService;
import org.cross.elscommon.po.AccountPO;
import org.cross.elscommon.po.InitialPO;
import org.cross.elscommon.po.OrganizationPO;
import org.cross.elscommon.po.PersonnelPO;
import org.cross.elscommon.po.SalaryPO;
import org.cross.elscommon.po.StockPO;
import org.cross.elscommon.po.VehiclePO;

public class InitialInfoImpl implements InitialInfo {
	public OrganizationInfo organizationInfo;
	public PersonnelInfo personnelInfo;
	public VehicleInfo vehicleInfo;
	public StockInfo stockInfo;
	public AccountInfo accountInfo;
	public UserInfo userinfo;
	
	public InitialDataService initdata;
	public SalaryDataService sal;

	public InitialInfoImpl(InitialDataService initdata, SalaryDataService salaryDataService) {
		this.initdata = initdata;
		this.sal = salaryDataService;
	}

	public InitialInfoImpl(OrganizationInfo organizationInfo,
			PersonnelInfo personnelInfo, VehicleInfo vehicleInfo,
			StockInfo stockInfo, AccountInfo accountInfo) {
		this.organizationInfo = organizationInfo;
		this.personnelInfo = personnelInfo;
		this.vehicleInfo = vehicleInfo;
		this.stockInfo = stockInfo;
		this.accountInfo = accountInfo;
	}

	@Override
	public InitialVO toInitialVO(InitialPO po) throws RemoteException {
		if (po == null) {
			return null;
		}
		ArrayList<OrganizationVO> orgVOs = new ArrayList<OrganizationVO>();
		ArrayList<OrganizationPO> orgpos = initdata.findInitOrganizations(po.getNumber());
		for (int i = 0; i < orgpos.size(); i++) {
			orgVOs.add(organizationInfo.toOrganizationVO(orgpos.get(i)));
		}
		ArrayList<PersonnelVO> personnelVOs = new ArrayList<PersonnelVO>();
		ArrayList<PersonnelPO> perpos = initdata.findInitPersonnels(po.getNumber());
		for (int i = 0; i < perpos.size(); i++) {
			SalaryPO salary = sal.findbyPerNum(perpos.get(i).getNumber());
			personnelVOs.add(personnelInfo.toPersonnelVO(perpos.get(i), salary));
		}
		ArrayList<VehicleVO> vehicleVOs = new ArrayList<VehicleVO>();
		ArrayList<VehiclePO> vepos = initdata.findInitVehicles(po.getNumber());
		for (int i = 0; i < vepos.size(); i++) {
			vehicleVOs.add(vehicleInfo.toVehicleVO(vepos.get(i)));
		}
		ArrayList<StockVO> stockVOs = new ArrayList<StockVO>();
		ArrayList<StockPO> stockpos = initdata.findInitStocks(po.getNumber());
		for (int i = 0; i < stockpos.size(); i++) {
			stockVOs.add(stockInfo.toStockVO(stockpos.get(i)));
		}
		ArrayList<AccountVO> accountVOs = new ArrayList<AccountVO>();
		ArrayList<AccountPO> accpos = initdata.findInitAccounts(po.getNumber());
		for (int i = 0; i < accpos.size(); i++) {
			accountVOs.add(accountInfo.toAccountVO(accpos.get(i)));
		}
		System.out.println("in:"+po.getPerNum());
		UserVO uservo = userinfo.findUserByNum(po.getPerNum());
		String perName = uservo.name;
		InitialVO vo = new InitialVO(po.getNumber(), po.getName(), orgVOs, personnelVOs, vehicleVOs, stockVOs, accountVOs, po.getTime(), perName, po.getPerNum());
		return vo;
	}

	@Override
	public InitialPO toInitialPO(InitialVO vo) {
		if (vo == null) {
			return null;
		}
		InitialPO po = new InitialPO(vo.id, vo.time, vo.initialName,
				vo.perNumber);
		return po;
	}

}
