package org.cross.elsclient.ui.counterui.initial;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.ui.component.ELSComfirmDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.AccountVO;
import org.cross.elsclient.vo.StockAreaVO;
import org.cross.elsclient.vo.StockVO;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.NumberType;
import org.cross.elscommon.util.StockType;

public class StockAddPanel extends ELSInfoPanel{
	ArrayList<StockVO> vos;
	StockVO vo;
	String number;
	
	public StockAddPanel(ArrayList<StockVO> vos) {
		super();
		this.vos = vos;
		init();
	}
	
	@Override
	public void init() {
		super.init();
		
		setTitle("新增仓库");
		number = ConstantVal.numberbl.getPostNumber(NumberType.STOCK);
		addEditableItem("仓库编号", number, true,InfoType.ID,"id");
		addEditableItem("特快仓库数量", "", true,InfoType.NUM,"fastNum");
		addEditableItem("特快仓库容量", "", true,InfoType.NUM,"fastCap");
		addEditableItem("标准仓库数量", "", true,InfoType.NUM,"normalNum");
		addEditableItem("标准仓库容量", "", true,InfoType.NUM,"normalCap");
		addEditableItem("经济仓库数量", "", true,InfoType.NUM,"ecoNum");
		addEditableItem("经济仓库容量", "", true,InfoType.NUM,"ecoCap");
		addEditableItem("所属机构", "", true,InfoType.ORGANIZATION,"organ");
		
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认添加");
		cancelBtn.setText("取消添加");
		setBackPanel("add");
	}
	
	@Override
	protected void confirm() throws RemoteException {
		super.confirm();
		if(isAllLegal()){
			String id = itemLabels.get(0).toString();
			int fastNum = Integer.valueOf(findItem("fastNum").toString());
			int fastCap = Integer.valueOf(findItem("fastCap").toString());
			int commonNum = Integer.valueOf(findItem("normalNum").toString());
			int commonCap = Integer.valueOf(findItem("normalCap").toString());
			int ecoNum = Integer.valueOf(findItem("ecoNum").toString());
			int ecoCap = Integer.valueOf(findItem("ecoCap").toString());
			String orgNum = findItem("organ").toString();
			int totalNum = fastNum+commonNum+ecoNum;
			
			ArrayList<StockAreaVO> areas = new ArrayList<>();
			StockAreaVO area;
			for(int i = 0;i<fastNum;i++) {
				String number = ConstantVal.getNumber().getPostNumber(NumberType.STOCKAREA);
				area = new StockAreaVO(number,
						id, StockType.Fast, fastCap, 0, null);
				ConstantVal.numberbl.addone(NumberType.STOCKAREA, number);
				areas.add(area);
			}
			for(int i = 0;i<commonNum;i++) {
				String number = ConstantVal.getNumber().getPostNumber(NumberType.STOCKAREA);
				area = new StockAreaVO(number,
						id, StockType.COMMON, commonCap, 0, null);
				ConstantVal.numberbl.addone(NumberType.STOCKAREA, number);
				areas.add(area);
			}
			for(int i = 0;i<ecoNum;i++) {
				String number = ConstantVal.getNumber().getPostNumber(NumberType.STOCKAREA);
				area = new StockAreaVO(number,
						id, StockType.ECONOMICAL, ecoCap, 0, null);
				ConstantVal.numberbl.addone(NumberType.STOCKAREA, number);
				areas.add(area);
			}
			vo = new StockVO(id, totalNum, 0, 0, 0, 0, 0, 0, orgNum, areas);
			vos.add(vo);
			ConstantVal.numberbl.addone(NumberType.STOCK, number);
			((InitialManagePanel)GetPanelUtil.getSubFunctionPanel(this, "initial").getComponent(1)).refresh();
			ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(StockAddPanel.this), "添加成功");
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
