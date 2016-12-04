/**
 * 单据PO
 * @author raychen
 * @date 2015/10/21
 */
package org.cross.elscommon.po;

import java.io.Serializable;

import org.cross.elscommon.util.ApproveType;
import org.cross.elscommon.util.ReceiptType;

@SuppressWarnings("serial")
public class ReceiptPO implements Serializable {

	/**
	 * 单据编号
	 */
	private String number;

	/**
	 * 单据类型
	 */
	private ReceiptType type;

	/**
	 * 单据生成时间
	 */
	private String time;

	/**
	 * 是否已被审批
	 */
	private ApproveType approveState;

	/**
	 * 生成单据的机构
	 */
	private String orgNum;

	/**
	 * 生成单据的人员Number
	 */
	private String perNum;

	public ReceiptPO(String number, ReceiptType type, String time,
			String orgNum, String perNum) {
		super();
		this.number = number;
		this.type = type;
		this.time = time;
		this.approveState = ApproveType.UNCHECKED;
		this.orgNum = orgNum;
		this.perNum = perNum;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public ReceiptType getType() {
		return type;
	}

	public void setType(ReceiptType type) {
		this.type = type;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public ApproveType getApproveState() {
		return approveState;
	}

	public void setApproveState(ApproveType approveState) {
		this.approveState = approveState;
	}

	public String getOrgNum() {
		return orgNum;
	}

	public void setOrgNum(String orgNum) {
		this.orgNum = orgNum;
	}

	public String getPerNum() {
		return perNum;
	}

	public void setPerNum(String perNum) {
		this.perNum = perNum;
	}

}
