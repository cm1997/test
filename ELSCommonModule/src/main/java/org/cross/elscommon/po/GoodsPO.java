/**
 * 快件PO类
 * @author danni
 * @date 2015/10/24
 */
package org.cross.elscommon.po;

import java.io.Serializable;
import java.util.ArrayList;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.GoodsState;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.StockType;

public class GoodsPO implements Serializable {

	/**
	 * 快件类型
	 */
	private StockType goodsType;

	/**
	 * 当前位置,城市
	 */
	private City placeCity;

	/**
	 * 当前位置,机构
	 */
	private OrganizationType placeOrg;

	/**
	 * 状态
	 */
	private GoodsState state;

	/**
	 * 实际重量
	 */
	private int weight;

	/**
	 * 体积
	 */
	private int volume;

	/**
	 * 订单编号
	 */
	private String orderNum;

	/**
	 * 所属仓库
	 */
	private String stockNum;

	/**
	 * 所属小间
	 */
	private String stockAreaNum;

	private String transNum;

	private String delNum;

	private String arriNum;

	public GoodsPO(StockType goodsType, City placeCity,
			OrganizationType placeOrg, GoodsState state, int weight,
			int volume, String orderNum) {
		super();
		this.goodsType = goodsType;
		this.placeCity = placeCity;
		this.placeOrg = placeOrg;
		this.state = state;
		this.weight = weight;
		this.volume = volume;
		this.orderNum = orderNum;
	}

	public StockType getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(StockType goodsType) {
		this.goodsType = goodsType;
	}

	public City getPlaceCity() {
		return placeCity;
	}

	public void setPlaceCity(City placeCity) {
		this.placeCity = placeCity;
	}

	public OrganizationType getPlaceOrg() {
		return placeOrg;
	}

	public void setPlaceOrg(OrganizationType placeOrg) {
		this.placeOrg = placeOrg;
	}

	public GoodsState getState() {
		return state;
	}

	public void setState(GoodsState state) {
		this.state = state;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getStockNum() {
		return stockNum;
	}

	public void setStockNum(String stockNum) {
		this.stockNum = stockNum;
	}

	public String getStockAreaNum() {
		return stockAreaNum;
	}

	public void setStockAreaNum(String stockAreaNum) {
		this.stockAreaNum = stockAreaNum;
	}

	public String getTransNum() {
		return transNum;
	}

	public void setTransNum(String transNum) {
		this.transNum = transNum;
	}

	public String getDelNum() {
		return delNum;
	}

	public void setDelNum(String delNum) {
		this.delNum = delNum;
	}

	public String getArriNum() {
		return arriNum;
	}

	public void setArriNum(String arriNum) {
		this.arriNum = arriNum;
	}

}
