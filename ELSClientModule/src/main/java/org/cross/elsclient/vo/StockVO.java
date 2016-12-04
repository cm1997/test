/**
 * 库存的VO
 * @author danni
 * @date 2015/10/19
 */
package org.cross.elsclient.vo;

import java.util.ArrayList;

import org.cross.elscommon.po.StockAreaPO;
import org.cross.elscommon.po.StockOperationPO;

public class StockVO {
	/**
	 * 仓库编号
	 */
	public String number;

	/**
	 * 仓库总间数
	 */
	public int totalAreas;

	/**
	 * 仓库已用间数
	 */
	public int usedAreas;

	/**
	 * 出库数量
	 */
	public int outNum;

	/**
	 * 入库数量
	 */
	public int inNum;

	/**
	 * 出库金额
	 */
	public double outMoney;

	/**
	 * 入库金额
	 */
	public double inMoney;

	/**
	 * 库存数量
	 */
	public int numInStock;

	/**
	 * 所属机构num
	 */
	public String orgNum;
	
	/**
	 * 仓库中的小间间
	 */
	public ArrayList<StockAreaVO> stockAreaVOs;

	public StockVO(String number, int totalAreas, int usedAreas, int outNum,
			int inNum, double outMoney, double inMoney, int numInStock,
			String orgNum,ArrayList<StockAreaVO> areaVOs) {
		super();
		this.number = number;
		this.totalAreas = totalAreas;
		this.usedAreas = usedAreas;
		this.outNum = outNum;
		this.inNum = inNum;
		this.outMoney = outMoney;
		this.inMoney = inMoney;
		this.numInStock = numInStock;
		this.orgNum = orgNum;
		this.stockAreaVOs = areaVOs;
	}

}
