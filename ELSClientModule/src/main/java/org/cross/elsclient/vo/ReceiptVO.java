/**
 * 单据VO类
 * @author raychen
 * @date 2015/10/21
 */
package org.cross.elsclient.vo;

import org.cross.elscommon.util.ApproveType;
import org.cross.elscommon.util.ReceiptType;

public class ReceiptVO {
	
	/**
	 * 单据编号
	 */
	public String number;
	
	/**
	 * 单据类型
	 */
	public ReceiptType type;
	
	/**
	 * 单据生成时间
	 */
	public String time;
	
	/**
	 * 是否已被审批
	 */
	public ApproveType approveState;
	
	public String perNum;
	
	public String orgNum;
	
	/**
	 * 构造方法
	 * @param number
	 * @param type
	 * @param time
	 */
	public ReceiptVO(String number, ReceiptType type, String time, String perNum, String orgNum){
		this.number = number;
		this.type = type;
		this.time = time;
		this.perNum = perNum;
		this.orgNum = orgNum;
		
		this.approveState = ApproveType.UNCHECKED;
	}
	
	/**
	 * 默认构造方法
	 */
	public ReceiptVO(){
		
	}
	
	public void print(){
		System.out.println("单据公有信息：编号："+number+" ,类型："+type.toString()+" ,创建时间："+time);
	}
}
