package org.cross.elsclient.blimpl.personnelblimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.PersonnelInfo;
import org.cross.elsclient.blimpl.blUtility.ReceiptInfo;
import org.cross.elsclient.blimpl.blUtility.SalaryInfo;
import org.cross.elsclient.blservice.personnelblservice.PersonnelBLService;
import org.cross.elsclient.vo.DriverVO;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elscommon.dataservice.personneldataservice.PersonnelDataService;
import org.cross.elscommon.dataservice.salarydataservice.SalaryDataService;
import org.cross.elscommon.po.PersonnelPO;
import org.cross.elscommon.po.SalaryPO;
import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.ResultMessage;

public class PersonnelBLImpl implements PersonnelBLService {

	public PersonnelDataService personnelData;
	SalaryDataService salaryDataService;
	ReceiptInfo receiptInfo;
	PersonnelInfo personnelInfo;
	SalaryInfo salaryInfo;

	public PersonnelBLImpl(PersonnelDataService personnelData,
			PersonnelInfo personnelInfo, ReceiptInfo receiptInfo,
			SalaryInfo salaryInfo, SalaryDataService salaryDataService) {
		this.personnelData = personnelData;
		this.personnelInfo = personnelInfo;
		this.receiptInfo = receiptInfo;
		this.salaryInfo = salaryInfo;
		this.salaryDataService = salaryDataService;
	}

	@Override
	public PersonnelVO findById(String id) throws RemoteException {
		
		PersonnelPO po = personnelData.findById(id);
		PersonnelVO vo = personnelInfo.toPersonnelVO(po, salaryInfo.findbyPerNum(id));
		return vo;
	}

	@Override
	public ArrayList<PersonnelVO> findByName(String name) throws RemoteException {
		ArrayList<PersonnelVO> vos = new ArrayList<PersonnelVO>();
		ArrayList<PersonnelPO> pos = personnelData.findByName(name);
		if (pos == null) {
			return null;
		}
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			SalaryPO salary = salaryInfo.findbyPerNum(pos.get(i).getNumber());
			vos.add(personnelInfo.toPersonnelVO(pos.get(i), salary));
		}
		return vos;
	}

	@Override
	public ResultMessage add(PersonnelVO vo) throws RemoteException {
		PersonnelPO po = personnelInfo.toPersonnelPO(vo);
		this.salaryDataService.insert(vo.salary);
		return personnelData.insert(po);
	}

	@Override
	public ResultMessage delete(String id) throws RemoteException {
		this.salaryDataService.delete(id);
		return personnelData.delete(id);
	}

	@Override
	public ResultMessage update(PersonnelVO vo) throws RemoteException {
		PersonnelPO po = personnelInfo.toPersonnelPO(vo);
		salaryDataService.update(vo.salary);
		return personnelData.update(po);
	}

	@Override
	public ArrayList<PersonnelVO> show() throws RemoteException {
		ArrayList<PersonnelVO> vos = new ArrayList<PersonnelVO>();
		ArrayList<PersonnelPO> pos = personnelData.show();
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			SalaryPO salary = salaryInfo.findbyPerNum(pos.get(i).getNumber());
			vos.add(personnelInfo.toPersonnelVO(pos.get(i), salary));
		}
		return vos;
	}

	@Override
	public ArrayList<PersonnelVO> findByOrg(String number)
			throws RemoteException {
		ArrayList<PersonnelVO> vos = new ArrayList<PersonnelVO>();
		ArrayList<PersonnelPO> pos = personnelData.findByOrg(number);
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			SalaryPO salary = salaryInfo.findbyPerNum(pos.get(i).getNumber());
			vos.add(personnelInfo.toPersonnelVO(pos.get(i), salary));
		}
		return vos;
	}

	@Override
	public ArrayList<PersonnelVO> findByPosition(PositionType position)
			throws RemoteException {
		ArrayList<PersonnelVO> vos = new ArrayList<PersonnelVO>();
		ArrayList<PersonnelPO> pos = personnelData.findByPosition(position);
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			SalaryPO salary = salaryInfo.findbyPerNum(pos.get(i).getNumber());
			vos.add(personnelInfo.toPersonnelVO(pos.get(i), salary));
		}
		return vos;
	}
}
