//package org.cross.elsclient.blimpl.initialblimpl;
//
//import org.cross.elsclient.blimpl.accountblimpl.MockLog;
//import org.cross.elsclient.demo.StockInfoUI.returnAct;
//import org.cross.elsclient.vo.InitialVO;
//import org.cross.elscommon.util.ResultMessage;
//
//public class Initial {
//
//	public ResultMessage createLog(String log){
//		MockLog mockLog = new MockLog(log);
//		return mockLog.createLog();
//	}
//
//	public ResultMessage addInitial(InitialVO vo) {
//		MockAccount mockAccount = new MockAccount();
//		MockOrganization mockOrganization = new MockOrganization();
//		MockPersonnel mockPersonnel = new MockPersonnel();
//		MockStock mockStock = new MockStock();
//		MockVehicle mockVehicle = new MockVehicle();
//		
//		mockAccount.createAccount(vo.accounts);
//		mockOrganization.createOragination(vo.organizations);
//		mockPersonnel.createPersonnel(vo.personnels);
//		mockStock.createStock(vo.stocks);
//		mockVehicle.createVehicle(vo.vehicles);
//		
//		if((mockAccount != null)&&(mockOrganization != null)&&(mockPersonnel != null)&&
//				(mockStock != null)&&(mockVehicle != null))
//			return ResultMessage.SUCCESS;
//		
//		return ResultMessage.FAILED;
//	}
//	
//}
