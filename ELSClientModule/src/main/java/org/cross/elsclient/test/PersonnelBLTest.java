/**
 * personnel全部写好了
 */
package org.cross.elsclient.test;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.PersonnelInfo;
import org.cross.elsclient.blimpl.blUtility.ReceiptInfo;
import org.cross.elsclient.blimpl.blUtility.SalaryInfo;
import org.cross.elsclient.blimpl.personnelblimpl.PersonnelBLImpl;
import org.cross.elsclient.blimpl.personnelblimpl.PersonnelInfoImpl;
import org.cross.elsclient.blimpl.receiptblimpl.ReceiptInfoImpl;
import org.cross.elsclient.blimpl.salaryblimpl.SalaryBLImpl;
import org.cross.elsclient.network.Datafactory;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.ConstantVO;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;
import org.cross.elscommon.dataservice.salarydataservice.SalaryDataService;
import org.cross.elscommon.po.SalaryPO;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.SalaryType;

public class PersonnelBLTest {

	public static void main(String[] args) throws RemoteException {
		
		ConstantVal.CONSTANT = new ConstantVO();
		
		DataFactoryService dataFactory = new Datafactory();
		SalaryInfo salaryInfo = new SalaryBLImpl(dataFactory.getSalaryData());
		PersonnelInfoImpl personnelInfo = new PersonnelInfoImpl(
				dataFactory.getPersonnelData(), salaryInfo);
		ReceiptInfoImpl receiptInfo = new ReceiptInfoImpl(dataFactory.getReceiptData());
		personnelInfo.receiptInfo = receiptInfo;
		receiptInfo.personnelInfo = personnelInfo;
		PersonnelBLImpl personnelBLImpl = new PersonnelBLImpl(
				dataFactory.getPersonnelData(), personnelInfo, receiptInfo,
				salaryInfo, dataFactory.getSalaryData());

//		System.out.println("---test-add---");
//		PersonnelVO newVO = new PersonnelVO("P29839", "cdn",
//				PositionType.ADMINISTRATOR, "O00932", "女", null, null, null);
//		ResultMessage addMessage = personnelBLImpl.add(newVO);
//		if (addMessage == ResultMessage.SUCCESS) {
//			System.out.println("增加成功");
//		} else {
//			System.out.println("增加失败");
//		}
		System.out.println("---test-delete---");
		ResultMessage deleteMessage = personnelBLImpl.delete("P29839");
		if (deleteMessage == ResultMessage.SUCCESS) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
//		System.out.println("---test-update---");
//		PersonnelVO updateVO = new PersonnelVO("P29839", "cdn",
//				PositionType.ADMINISTRATOR, "O00932", "女", "321287199999378","1996-4-21", null);
//		ResultMessage updateMessage = personnelBLImpl.update(updateVO);
//		if (updateMessage == ResultMessage.SUCCESS) {
//			System.out.println("更新成功");
//		} else {
//			System.out.println("更新失败");
//		}
//
//		System.out.println("---test-show---");
//		ArrayList<PersonnelVO> shows = personnelBLImpl.show();
//		int size = shows.size();
//		// System.out.println(size);
//		for (int i = 0; i < size; i++) {
//			System.out.println(shows.get(i).name + " " + shows.get(i).number);
//		}
//
//		System.out.println("---test-findById---");
//		PersonnelVO idvo = personnelBLImpl.findById("P29839");
//		System.out.println(idvo.name + " " + idvo.number);
//
//		System.out.println("---test-findByName---");
//		ArrayList<PersonnelVO> namevo = personnelBLImpl.findByName("cdn");
//		int size2 = namevo.size();
//		System.out.println(size2);
//		for (int i = 0; i < size2; i++) {
//			System.out
//					.println(namevo.get(i).name + " " + namevo.get(i).number);
//		}
//
//		System.out.println("---test-findByOrg---");
//		ArrayList<PersonnelVO> orgvo = personnelBLImpl.findByOrg("O00932");
//		int size3 = orgvo.size();
//		for (int i = 0; i < size3; i++) {
//			System.out.println(orgvo.get(i).name + " " + orgvo.get(i).number);
//		}
//
//		System.out.println("---test-findByPosition---");
//		ArrayList<PersonnelVO> povo = personnelBLImpl
//				.findByPosition(PositionType.ADMINISTRATOR);
//		int size4 = povo.size();
//		for (int i = 0; i < size4; i++) {
//			System.out.println(povo.get(i).name + " " + povo.get(i).number);
//		}
	}
}
