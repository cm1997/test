/**
 * 车辆PO类
 * @author raychen
 * @data 2015/10/21
 */
package org.cross.elscommon.po;

import java.awt.Image;
import java.io.Serializable;

import org.cross.elscommon.util.VehicleType;

public class VehiclePO implements Serializable {

	/**
	 * 车辆代号
	 */
	private String number;

	/**
	 * 发动机号
	 */
	private String engineNum;

	/**
	 * 底盘号
	 */
	private String baseNum;

	/**
	 * 购买时间
	 */
	private String buyTime;

	/**
	 * 服役时间
	 */
	private String lastTime;

	/**
	 * 车辆图片
	 */
	private Image image;

	/**
	 * 是否被使用
	 */
	private boolean state;

	private String licence;

	private String orgNum;

	public VehiclePO(String number, String engineNum, String baseNum,
			String buyTime, String lastTime, Image image, boolean state,
			String licence, String orgNum) {
		super();
		this.number = number;
		this.engineNum = engineNum;
		this.baseNum = baseNum;
		this.buyTime = buyTime;
		this.lastTime = lastTime;
		this.image = image;
		this.state = state;
		this.licence = licence;
		this.orgNum = orgNum;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEngineNum() {
		return engineNum;
	}

	public void setEngineNum(String engineNum) {
		this.engineNum = engineNum;
	}

	public String getBaseNum() {
		return baseNum;
	}

	public void setBaseNum(String baseNum) {
		this.baseNum = baseNum;
	}

	public String getBuyTime() {
		return buyTime;
	}

	public void setBuyTime(String buyTime) {
		this.buyTime = buyTime;
	}

	public String getLastTime() {
		return lastTime;
	}

	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getLicence() {
		return licence;
	}

	public void setLicence(String licence) {
		this.licence = licence;
	}

	public String getOrgNum() {
		return orgNum;
	}

	public void setOrgNum(String orgNum) {
		this.orgNum = orgNum;
	}

}
