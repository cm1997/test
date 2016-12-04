/**
 * 快件信息的VO
 * @author danni
 * @date 2015/10/21
 */
package org.cross.elsclient.vo;

import java.util.ArrayList;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.GoodsState;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.StockType;

public class GoodsVO {
	/**
	 * 快件类型
	 */
	public StockType goodsType;
	
	/**
	 * 快件编号
	 */
	public String number;
	
	/**
	 * 当前位置,城市
	 */
	public City placeCity;
	
	/**
	 * 当前位置,机构
	 */
	public OrganizationType placeOrg;
	
	/**
	 * 状态
	 */
	public GoodsState state;
	
	/**
	 * 实际重量
	 */
	public int weight;
	
	/**
	 * 体积
	 */
	public int volume;
	
	/**
	 * 历史轨迹
	 */
	public ArrayList<HistoryVO> history;
	
	/**
	 * 订单编号
	 */
	public String orderNum;
	
	/**
	 * 所属仓库小间编号
	 */
	public String stockAreaNum;
	
	public String stockNum;
	
	public String delNum;
	
	public String transNum;
	
	public String arriNum;
	
	/**
	 * 构造方法
	 * 
	 */
	public GoodsVO(String number,StockType goodsType, City city, OrganizationType org, int weight, int volume){
		this.number = number;
		this.weight = weight;
		this.volume = volume;
		this.placeCity = city;
		this.placeOrg = org;
		this.goodsType = goodsType;
		
		this.state = GoodsState.LIVE;
		this.stockAreaNum = null;
		this.history = new ArrayList<HistoryVO>();
	}

}
