//package org.cross.elsclient.blimpl.initialblimpl;
//
//import java.util.ArrayList;
//
//import org.cross.elsclient.blimpl.personnelblimpl.Personnel;
//import org.cross.elsclient.vo.PersonnelVO;
//import org.cross.elscommon.util.ResultMessage;
//
//public class MockPersonnel extends Personnel{
//	public ResultMessage createPersonnel(ArrayList<PersonnelVO> vo){
//		ResultMessage resultMessage = ResultMessage.FAILED;
//		for (int i = 0; i < vo.size(); i++) {
//			resultMessage = add(vo.get(i));
//		}
//		return resultMessage;
//	}
//}
