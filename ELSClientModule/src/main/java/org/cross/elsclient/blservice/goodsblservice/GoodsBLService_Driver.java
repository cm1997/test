/**
 * 快件信息管理的驱动程序
 * @author danni
 * @date 2015/10/20
 */
package org.cross.elsclient.blservice.goodsblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.po.HistoryPO;
import org.cross.elscommon.util.City;
import org.cross.elscommon.util.GoodsState;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elsclient.vo.GoodsVO;
import org.cross.elsclient.vo.HistoryVO;
import org.omg.PortableInterceptor.SUCCESSFUL;

public class GoodsBLService_Driver {
	
	public void drive(GoodsBLService goodsBLService) throws RemoteException{
//		System.out.println("~~~增加快件信息~~~");
//		ResultMessage addResultMessage = goodsBLService.addGoods(new GoodsVO("12222332", "南京", "上海", "小明", "小明2",1, 22, 2, "书"));
//		if (addResultMessage == ResultMessage.SUCCESS) {
//			System.out.println("添加成功");
//		}else{
//			System.out.println("添加失败");
//		}
		
//		System.out.println("~~~删除快件信息~~~");
//		ResultMessage deleteResultMessage = goodsBLService.deleteGoods("12334523");
//		if (deleteResultMessage == ResultMessage.SUCCESS) {
//			System.out.println("删除成功");
//		}else{
//			System.out.println("删除失败");
//		}
		
//		System.out.println("~~~更新快件当前位置信息~~~");
//		ResultMessage updateLocateResultMessage = goodsBLService.updateGoodsLocate("657246256", "南京中转站");
//		if (updateLocateResultMessage == ResultMessage.SUCCESS) {
//			System.out.println("更新成功");
//		}else{
//			System.out.println("更新失败");
//		}
//		
//		System.out.println("~~~更新快件当前状态信息~~~");
//		ResultMessage updateStateResultMessage = goodsBLService.updateGoodsState("78554567", GoodsState.LIVE);
//		if (updateStateResultMessage == ResultMessage.SUCCESS) {
//			System.out.println("更新成功");
//		}else{
//			System.out.println("更新失败");
//		}
//		
//		System.out.println("~~~更新快件入库时间信息~~~");
//		ResultMessage updateInTimeResultMessage = goodsBLService.updateGoodsInTime("132566433", "2015/10/20/20/00");
//		if (updateInTimeResultMessage == ResultMessage.SUCCESS) {
//			System.out.println("更新成功");
//		}else{
//			System.out.println("更新失败");
//		}
		
//		System.out.println("~~~更新快件信息~~~");
//		ResultMessage updateResultMessage = goodsBLService.updateGoods(new GoodsVO(54, 22,City.NANJING));
//		if (updateResultMessage == ResultMessage.SUCCESS) {
//			System.out.println("更新成功");
//		}else{
//			System.out.println("更新失败");
//		}
		
		System.out.println("~~~查询快件信息~~~");
		ArrayList<HistoryVO> goodsInfo = goodsBLService.findGoods("R1201510200000002");
//		System.out.println("快件编号 ： " + goodsInfo.goodsIdentifier);
//		System.out.println("目的地 ：" + goodsInfo.destination);
//		System.out.println("出发地 ： " + goodsInfo.departurePalce);
//		System.out.println("收件人信息 ： " + goodsInfo.receptorInfo);
//		System.out.println("寄件人信息 ： " + goodsInfo.senderInfo);
//		System.out.println("当前位置 ： " + goodsInfo.currentLocate.toString());
		System.out.println("历史轨迹：  。。。。。。。");
//		System.out.println("快件当前状态 ： " + goodsInfo.state.toString());
//		System.out.println("快件实际重量 ： " + goodsInfo.weightOfGoods);
//		System.out.println("快件体积 ： " + goodsInfo.volumeOfGoods);
//		System.out.println("件内名称 ： " + goodsInfo.nameOfGoods);
		
		
		
	}
}
