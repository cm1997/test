/**
 * 快件信息管理
 * @author danni
 * @date 2015/10/19
 */
package org.cross.elsclient.blservice.goodsblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.util.GoodsState;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elsclient.vo.GoodsVO;
import org.cross.elsclient.vo.HistoryVO;

public interface GoodsBLService {
	/**	 增加快件信息
	 * @return 是否增加成功
	 * @throws RemoteException 
	 */
	public ResultMessage addGoods(GoodsVO goods) throws RemoteException;
	
	/**
	 * 更新快件信息
	 * @return 是否跟新成功（当前位置和状态）
	 * @throws RemoteException 
	 */
	public ResultMessage updateGoods(GoodsVO goodsvo) throws RemoteException;
	
	/**
	 * 查询快件信息
	 * @param id
	 * @return 快件信息
	 * @throws RemoteException 
	 */
	public ArrayList<HistoryVO> findGoods(String id) throws RemoteException;

	/**
	 *根据单号查快件
	 * @throws RemoteException 
	 */
	public GoodsVO searchGoods(String goodsID) throws RemoteException;
}
