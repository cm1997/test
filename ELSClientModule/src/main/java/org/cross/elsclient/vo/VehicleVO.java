/**
 * 车辆VO类
 * @author raychen
 * @data 2015/10/21
 */
package org.cross.elsclient.vo;

import java.awt.Image;

import org.cross.elscommon.util.VehicleType;

public class VehicleVO {

	/**
	 * 车辆编号
	 */
	public String number;

	/**
	 * 车牌号
	 */
	public String licence;

	/**
	 * 营业厅编号
	 */
	public String businessHallNum;

	/**
	 * 发动机号
	 */
	public String engineNumber;

	/**
	 * 底盘号
	 */
	public String baseNumber;

	/**
	 * 购买时间
	 */
	public String buyTime;

	/**
	 * 服役时间
	 */
	public String lastTime;

	/**
	 * 车辆图片
	 */
	public Image image;

	/**
	 * 是否正在被使用
	 */
	public boolean inUse;

	public VehicleVO(String number, String licence, String businessHallNum,
			String engineNumber, String apparatusNumber, String buyTime,
			String lastTime, Image image, boolean inUse) {
		super();
		this.number = number;
		this.licence = licence;
		this.businessHallNum = businessHallNum;
		this.engineNumber = engineNumber;
		this.baseNumber = apparatusNumber;
		this.buyTime = buyTime;
		this.lastTime = lastTime;
		this.image = image;
		this.inUse = inUse;
	}

}
