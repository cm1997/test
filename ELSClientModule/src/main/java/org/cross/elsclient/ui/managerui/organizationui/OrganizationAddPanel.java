package org.cross.elsclient.ui.managerui.organizationui;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.organizationblservice.OrganizationBLService;
import org.cross.elsclient.ui.component.ELSComfirmDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.LogUtil;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.OrganizationVO;
import org.cross.elscommon.util.City;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.NumberType;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;

public class OrganizationAddPanel extends ELSInfoPanel{
	OrganizationVO vo;
	OrganizationBLService bl;
	String number;
	
	public OrganizationAddPanel(OrganizationBLService bl){
		this.bl = bl;
		init();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		
		String[] types = {"营业厅","中转中心", "总部"};
		String[] area = {"北京","上海", "南京","广州"};
		
		setTitle("新增机构");
		number =  ConstantVal.numberbl.getPostNumber(NumberType.ORGANIZATION);
		addEditableItem("机构编号",number,false,"id");
		addComboxItem("机构地区", area, true,"city");
		addComboxItem("机构类型", types,true,"type");
		
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认添加");
		cancelBtn.setText("取消添加");
	}
	
	@Override
	protected void confirm() {
		if(isAllLegal()){
			String id = findItem("id").toString();
			City city = StringToType.toCity(findItem("city").toString());
			OrganizationType type = StringToType.toOrg(findItem("type").toString());
			vo = new OrganizationVO(city,type,id);
			try {
				if(bl.add(vo)==ResultMessage.SUCCESS){
					LogUtil.addLog("新增机构");
					ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"添加成功");
					ConstantVal.numberbl.addone(NumberType.ORGANIZATION, number);
					back();
				}else{
					ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"添加失败");
				}
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	protected void cancel() {
		if(ELSComfirmDialog.showConfirmDlg(GetPanelUtil.getFunctionPanel(this), "取消新增", "确认退出新增界面？")){
			back();
		}
	}
}
