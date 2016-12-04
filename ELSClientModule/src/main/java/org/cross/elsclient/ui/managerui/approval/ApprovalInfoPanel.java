package org.cross.elsclient.ui.managerui.approval;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.ui.component.ELSComfirmDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.LogUtil;
import org.cross.elsclient.vo.ReceiptVO;
import org.cross.elscommon.util.ApproveType;

public class ApprovalInfoPanel extends ELSInfoPanel {
	ReceiptBLService receiptbl;
	ReceiptVO vo;
	
	public ApprovalInfoPanel(ReceiptVO vo,ReceiptBLService receiptbl) {
		super();
		this.vo = vo;
		this.receiptbl = receiptbl;
		init();
	}
	
	@Override
	public void init() {
		super.init();
		setTitle("单据信息");
		addNormalItem("单据编号", vo.number);
		addNormalItem("单据类型", vo.type.toString());
		addNormalItem("建单时间", vo.time);
		addNormalItem("状态", vo.approveState.toString());
		
		if(vo.approveState==ApproveType.UNCHECKED){
			this.addConfirmAndCancelBtn();
			confirmBtn.setText("审批通过");
			cancelBtn.setText("审批不通过");
		}
		container.packHeight();
	}
	
	@Override
	protected void confirm() throws RemoteException {
		super.confirm();
		if(ELSComfirmDialog.showConfirmDlg(GetPanelUtil.getMainFrame(this), "审批单据", "确认审批通过该单据？")){
			LogUtil.addLog("审批单据通过");
			receiptbl.check(vo, ApproveType.APPROVED);
			ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(ApprovalInfoPanel.this), "审批通过");
			back();
		}
	}
	
	@Override
	protected void cancel() {
		// TODO Auto-generated method stub
		super.cancel();
		if(ELSComfirmDialog.showConfirmDlg(GetPanelUtil.getMainFrame(this), "审批单据", "确认审批不通过该单据？")){
			try {
				LogUtil.addLog("审批单据不通过");
				receiptbl.check(vo, ApproveType.NOT_APPROVED);
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(ApprovalInfoPanel.this), "审批不通过");
				back();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
