package org.cross.elsclient.ui.managerui.constant;

import java.awt.Dimension;
import java.awt.Font;
import java.rmi.RemoteException;

import org.cross.elsclient.blservice.constantblservice.ConstantBLService;
import org.cross.elsclient.ui.component.ELSComfirmDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.component.InfoItemLabel;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.LogUtil;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.vo.ConstantVO;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.ResultMessage;

public class ConstantUpdatePanel extends ELSInfoPanel {
	ConstantVO vo;
	ConstantBLService bl;
	
	public ConstantUpdatePanel(ConstantBLService bl) {
		this.bl = bl;
		init();
	}
	
	@Override
	public void init() {
		super.init();
		vo = bl.show();
		
		setTitle("更改业务常量");
		addNormalItem("城市距离", "");
		itemLabels.get(0).nameLabel.setFont(itemLabels.get(0).nameLabel.getFont().deriveFont(Font.BOLD));
		addEditableItem("北京-上海", vo.distance_Beijing_Shanghai+"",true,InfoType.NUM,"BToS");
		addEditableItem("北京-南京", vo.distance_Beijing_Nanjing+"",true,InfoType.NUM,"BToN");
		addEditableItem("北京-广州", vo.distance_Beijing_Guangzhou+"",true,InfoType.NUM,"BToG");
		addEditableItem("南京-广州", vo.distance_Nanjing_Guangzhou+"",true,InfoType.NUM,"NToG");
		addEditableItem("南京-上海", vo.distance_Nanjing_Shanghai+"",true,InfoType.NUM,"NToS");
		addEditableItem("广州-上海", vo.distance_Shanghai_Guangzhou+"",true,InfoType.NUM,"GToS");
		addNormalItem("", "");
		addEditableItem("价格(元/(kilo*kg))", vo.price+"",true,InfoType.NUM,"price");
		addEditableItem("预估时间(hour/km)", vo.timeBykilo+"",true,InfoType.NUM,"time");
		addNormalItem("", "");
		addNormalItem("初始工资(元/月)","");
//		findItem("title").nameLabel.setFont(itemLabels.get(11).nameLabel.getFont().deriveFont(Font.BOLD));
		addEditableItem("快递员", vo.baseMoneyForCOURIER+"",true,InfoType.NUM,"cour");
		addEditableItem("营业厅业务员", vo.baseMoneyForBUSINESSHALLCLERK+"",true,InfoType.NUM,"bus");
		addEditableItem("中转中心业务员", vo.baseMoneyForTRANSITCENTERCLERK+"",true,InfoType.NUM,"trans");
		addEditableItem("仓库管理员", vo.baseMoneyForSTOCKKEEPER+"",true,InfoType.NUM,"stock");
		addEditableItem("财务人员", vo.baseMoneyForCOUNTER+"",true,InfoType.NUM,"coun");
		addEditableItem("总经理", vo.baseMoneyForMANAGER+"",true,InfoType.NUM,"mana");
		addEditableItem("系统管理员", vo.baseMoneyForADMINISTRATOR+"",true,InfoType.NUM,"admin");
		
		
		for (InfoItemLabel infoItemLabel : itemLabels) {
			infoItemLabel.nameLabel.setMaximumSize(new Dimension(170, UIConstant.MANAGETABLE_ITEM_HEIGHT));
		}
	
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认修改");
		cancelBtn.setText("取消修改");
		
		container.packHeight();

	}
	
	@Override
	protected void confirm() throws RemoteException {
		// TODO Auto-generated method stub
		super.confirm();
		
		if(isAllLegal()){
//			vo.distance_Beijing_Shanghai = Double.valueOf(findItem("BToS").toString());
//			vo.distance_Beijing_Nanjing = Double.valueOf(findItem("BToN").toString());
//			vo.distance_Beijing_Guangzhou = Double.valueOf(findItem("BToG").toString());
//			vo.distance_Nanjing_Guangzhou = Double.valueOf(findItem("NToG").toString());
//			vo.distance_Nanjing_Shanghai = Double.valueOf(findItem("NToS").toString());
//			vo.distance_Shanghai_Guangzhou = Double.valueOf(findItem("SToG").toString());
			
			vo.price = Double.valueOf(findItem("price").toString());
			vo.timeBykilo = Double.valueOf(findItem("time").toString());
			
			vo.baseMoneyForCOURIER = Double.valueOf(findItem("cour").toString());
			vo.baseMoneyForBUSINESSHALLCLERK = Double.valueOf(findItem("bus").toString());
			vo.baseMoneyForTRANSITCENTERCLERK = Double.valueOf(findItem("trans").toString());
			vo.baseMoneyForSTOCKKEEPER = Double.valueOf(findItem("stock").toString());
			vo.baseMoneyForCOUNTER = Double.valueOf(findItem("coun").toString());
			vo.baseMoneyForMANAGER = Double.valueOf(findItem("mana").toString());
			vo.baseMoneyForADMINISTRATOR = Double.valueOf(findItem("admin").toString());
			
			if(bl.update(vo)==ResultMessage.SUCCESS){
				LogUtil.addLog("更新业务常量");
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"更新成功");
				back();
			}else{
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"更新失败");
			}
		}
	}
	
	@Override
	protected void cancel() {
		super.cancel();
		if(ELSComfirmDialog.showConfirmDlg(GetPanelUtil.getFunctionPanel(this), "取消更新", "确认退出更新界面？")){
			back();
		}
	}
}
