/**
 * 库存管理业务逻辑接口
 * @author danni
 * @date 2015/10/19
 */
package org.cross.elsclient.blservice.stockblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StockState;
import org.cross.elscommon.util.StockType;
import org.cross.elsclient.vo.StockAreaVO;
import org.cross.elsclient.vo.StockCheckVO;
import org.cross.elsclient.vo.StockOperationVO;
import org.cross.elsclient.vo.StockSeeVO;
import org.cross.elsclient.vo.StockVO;

public interface StockBLService {
	/**
	 * 增加仓库
	 * @throws RemoteException 
	 */
	public ResultMessage addStock(StockVO vo) throws RemoteException;
//	
//	/**
//	 * 删除仓库
//	 * @throws RemoteException 
//	 */
//	public ResultMessage deleteStock(String stockID) throws RemoteException;
//	
	/**
	 * 根据当前时间生成库存快照
	 * @return 该时间节点的库存快照信息
	 * @throws RemoteException 
	 */
	public ArrayList<StockCheckVO> showStockCheck(String stockID) throws RemoteException;
	
	/**
	 * 库存查看
	 * @param time1
	 * @param time2
	 * @return 商品库存列表
	 * @throws RemoteException 
	 */
	public StockSeeVO showStockInfo(String stockID,String time1,String time2) throws RemoteException;
	
	/**
	 * 寻找仓库
	 * @param ID
	 * @return 该仓库管理人员管理的仓库
	 * @throws RemoteException 
	 */
	public StockVO findStock(String ID) throws RemoteException;
	
	/**
	 * 导出库存盘点信息表格
	 * @return 是否导出成功
	 */
	public ResultMessage exportStockCheck();
	
	/**
	 * 查询特定仓库容量信息，包括总共、已用、已用占的百分比
	 * @param stock
	 * @return 特定仓库已用容量
	 * @throws RemoteException 
	 */
	public ArrayList<StockAreaVO> stockCapacity(String id,StockType type) throws RemoteException;
	
	/**
	 * 快件入库
	 * @param 快件id
	 * @return 是否入库称成功
	 * @throws RemoteException 
	 */
	public ResultMessage intoStock(String goodsID,String stockID,String time,String stockAreaNum) throws RemoteException;
	
	/**
	 * 快件出库
	 * @param 快件id
	 * @return 是否出库成功
	 * @throws RemoteException 
	 */
	public ResultMessage outStock(String goodsID,String stockID,String time) throws RemoteException;
	
	/**
	 * 库存报警
	 * @throws RemoteException 
	 */
	public StockState stockAlert(String stockAreaID,StockType stockType) throws RemoteException;
	
	/**
	 * 库存调整
	 * @throws RemoteException 
	 */
	public ResultMessage stockAdjust(String stockID,StockType stockType) throws RemoteException;

	/**
	 * 得到可调整的仓库
	 * @throws RemoteException 
	 */
	public ArrayList<String> getChangeableArea(String stockID) throws RemoteException;
	
	/**
	 * 根据机构查找仓库
	 */
	public StockVO findStockByOrg(String orgNum) throws RemoteException;
	/**
	 * 得到需要调整的仓库
	 */
	public ArrayList<String> getNeedChange(String stockID) throws RemoteException;
}
