package org.cross.elsclient.blimpl.initialblimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.AccountInfo;
import org.cross.elsclient.blimpl.blUtility.OrganizationInfo;
import org.cross.elsclient.blimpl.blUtility.PersonnelInfo;
import org.cross.elsclient.blimpl.blUtility.SalaryInfo;
import org.cross.elsclient.blimpl.blUtility.StockInfo;
import org.cross.elsclient.blimpl.blUtility.VehicleInfo;
import org.cross.elsclient.blservice.initialblservice.InitialBLService;
import org.cross.elsclient.vo.AccountVO;
import org.cross.elsclient.vo.InitialVO;
import org.cross.elsclient.vo.OrganizationVO;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elsclient.vo.StockVO;
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
import org.cross.elscommon.util.ResultMessage;

public class InitialBLImpl implements InitialBLService {

	InitialDataService initialData;
	InitialInfoImpl initialInfo;
	
	OrganizationInfo orgInfo;
	PersonnelInfo personnelInfo;
	VehicleInfo vehicleInfo;
	StockInfo stockInfo;
	AccountInfo accountInfo;
	SalaryInfo salaryInfo;

	public InitialBLImpl(InitialDataService initialData,
			InitialInfoImpl initialInfo, OrganizationInfo organizationInfo,
			PersonnelInfo personnelInfo, VehicleInfo vehicleInfo,
			StockInfo stockInfo, AccountInfo accountInfo, SalaryInfo salaryInfo, SalaryDataService sal) {
		this.initialData = initialData;
		this.initialInfo = initialInfo;
		this.orgInfo = organizationInfo;
		this.personnelInfo = personnelInfo;
		this.vehicleInfo = vehicleInfo;
		this.stockInfo = stockInfo;
		this.accountInfo = accountInfo;
		this.salaryInfo = salaryInfo;
		
		this.initialInfo.initdata = initialData;
		this.initialInfo.sal = sal;
	}

	@Override
	public ArrayList<InitialVO> show() throws RemoteException {
		ArrayList<InitialVO> initialVOs = new ArrayList<InitialVO>();
		ArrayList<InitialPO> initialPOs = initialData.show();
		if (initialPOs == null) {
			return null;
		}
		int size = initialPOs.size();
		for (int i = 0; i < size; i++) {
			initialVOs.add(initialInfo.toInitialVO(initialPOs.get(i)));
		}
		return initialVOs;
	}

	@Override
	public ResultMessage addInitial(InitialVO vo) throws RemoteException {
		InitialPO po = initialInfo.toInitialPO(vo);
		for (int i = 0; i < vo.accounts.size(); i++) {
			accountInfo.addacc(accountInfo.toAccountPO(vo.accounts.get(i)));
			initialData.insertInitAccount(accountInfo.toAccountPO(vo.accounts.get(i)), vo.id);
		}
		for (int i = 0; i < vo.stocks.size(); i++) {
			stockInfo.addsto(vo.stocks.get(i));
			initialData.insertInitStock(stockInfo.toStockPO(vo.stocks.get(i)), vo.id);
		}
		for (int i = 0; i < vo.vehicles.size(); i++) {
			vehicleInfo.addVeh(vehicleInfo.toVehiclePO(vo.vehicles.get(i)));
			initialData.insertInitVehicle(vehicleInfo.toVehiclePO(vo.vehicles.get(i)), vo.id);
		}
		for (int i = 0; i < vo.personnels.size(); i++) {
			personnelInfo.addPer(vo.personnels.get(i));
			initialData.insertInitPersonnel(personnelInfo.toPersonnelPO(vo.personnels.get(i)), vo.id);
		}
		for (int i = 0; i < vo.organizations.size(); i++) {
			orgInfo.addOrg(orgInfo.toOrganizationPO(vo.organizations.get(i)));
			initialData.insertInitOrganization(orgInfo.toOrganizationPO(vo.organizations.get(i)), vo.id);
		}
		return initialData.insert(po);
	}

	@Override
	public ArrayList<OrganizationVO> showOrganization(String initialID)
			throws RemoteException {
		ArrayList<OrganizationPO> orgPos = initialData
				.findInitOrganizations(initialID);
		ArrayList<OrganizationVO> orgVos = orgInfo.toOrgVOs(orgPos);
		return orgVos;
	}

	@Override
	public ArrayList<PersonnelVO> showPersonnel(String initialID) throws RemoteException {
		ArrayList<PersonnelPO> personnelPOs = initialData.findInitPersonnels(initialID);
		ArrayList<PersonnelVO> personnelVOs = new ArrayList<PersonnelVO>();
		if (personnelPOs == null) {
			return null;
		}
		int size = personnelPOs.size();
		for (int i = 0; i < size; i++) {
			SalaryPO salary = salaryInfo.findbyPerNum(personnelPOs.get(i).getNumber());
			personnelVOs.add(personnelInfo.toPersonnelVO(personnelPOs.get(i), salary));
		}
		return personnelVOs;
	}

	@Override
	public ArrayList<VehicleVO> showVehicle(String initialID)
			throws RemoteException {
		ArrayList<VehiclePO> vehiclePOs = initialData
				.findInitVehicles(initialID);
		ArrayList<VehicleVO> vehicleVOs = vehicleInfo.toVehVOs(vehiclePOs);
		return vehicleVOs;
	}

	@Override
	public ArrayList<StockVO> showStock(String initialID)
			throws RemoteException {
		ArrayList<StockPO> stockPOs = initialData.findInitStocks(initialID);
		ArrayList<StockVO> stockVOs = stockInfo.toStockVO(stockPOs);

		return stockVOs;
	}

	@Override
	public ArrayList<AccountVO> showAccount(String initialID)
			throws RemoteException {
		ArrayList<AccountPO> accountPOs = initialData
				.findInitAccounts(initialID);
		ArrayList<AccountVO> accountVOs = accountInfo.toAccVOs(accountPOs);

		return accountVOs;
	}

}
