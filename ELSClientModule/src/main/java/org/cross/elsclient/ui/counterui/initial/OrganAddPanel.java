package org.cross.elsclient.ui.counterui.initial;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.ui.component.ELSComfirmDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.OrganizationVO;
import org.cross.elscommon.util.City;
import org.cross.elscommon.util.NumberType;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.StringToType;

public class OrganAddPanel extends ELSInfoPanel{
	ArrayList<OrganizationVO> vos;
	OrganizationVO vo;
	String number;
	
	public OrganAddPanel(ArrayList<OrganizationVO> vos) {
		super();
		this.vos = vos;
		init();
	}
	
	@Override
	public void init() {
		super.init();
		
		String citys[] = City.toStrings();
		String organs[] = OrganizationType.toStrings();
		
		setTitle("新增机构");
		number = ConstantVal.numberbl.getPostNumber(NumberType.ORGANIZATION);
		addEditableItem("机构编号",number,false,"id");
		addComboxItem("机构地区", citys, true,"city");
		addComboxItem("机构类型", organs,true,"type");
	
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认添加");
		cancelBtn.setText("取消添加");
		setBackPanel("add");
	}
	
	@Override
	protected void confirm() throws RemoteException {
		super.confirm();
		if(isAllLegal()){
			String id = findItem("id").toString();
			City city = StringToType.toCity(findItem("city").toString());
			OrganizationType type = StringToType.toOrg(findItem("type").toString());
			vo = new OrganizationVO(city,type,id);
			vos.add(vo);
			ConstantVal.numberbl.addone(NumberType.ORGANIZATION, number);
			((InitialManagePanel)GetPanelUtil.getSubFunctionPanel(this, "initial").getComponent(1)).refresh();
			ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this), "添加成功");
			back();
		}
	}
	
	@Override
	protected void cancel() {
		// TODO Auto-generated method stub
		super.cancel();
		if(ELSComfirmDialog.showConfirmDlg(GetPanelUtil.getFunctionPanel(this),
				"取消添加", "确认退出新增界面？")){
			
			back();
		}
	}
}
