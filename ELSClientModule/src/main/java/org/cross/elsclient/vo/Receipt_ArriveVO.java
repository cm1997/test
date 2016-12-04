/**
 * 到达单VO
 * @author raychen
 * @date 2015/10/21
 */
package org.cross.elsclient.vo;

import java.util.ArrayList;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.ReceiptType;

public class Receipt_ArriveVO extends ReceiptVO {

	/**
	 * 出发地(机构ID)
	 */
	public String startOrgID;

	/**
	 * 转运单编号
	 */
	public String transNum;
	/**
	 * 出发时间
	 */
	public String startTime;

	public Receipt_ArriveVO(String number, String time,
			String startOrgID, 
			String transNum,
			String startTime, String arriveOrgID, String perNum) {
		super(number, ReceiptType.ARRIVE, time, perNum, arriveOrgID);
		this.startOrgID = startOrgID;
		this.transNum = transNum;
		this.startTime = startTime;
	}

}
