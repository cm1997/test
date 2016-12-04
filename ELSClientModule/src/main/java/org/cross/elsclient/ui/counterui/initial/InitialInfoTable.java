package org.cross.elsclient.ui.counterui.initial;

import org.cross.elsclient.ui.component.EditTableItemLabel;
import org.cross.elsclient.vo.InitialVO;

public class InitialInfoTable extends InitialManageTable{
	InitialVO vo;
	EditTableItemLabel label;
	boolean isEditable;
	
	public InitialInfoTable(String []name,int[] itemWidth,InitialVO vo) {
		super(name, itemWidth);
		this.vo = vo;
		isEditable = false;
	}
	
	@Override
	public void init() {
		super.init();
	}
	
	@Override
	public void refresh() {
		removeAll();
		init();
		String item[] = {vo.id,vo.perNumber,vo.time};
		if(isEditable){
			label = new EditTableItemLabel();
			label.init(item, itemWidth);
			container.add(label);
			packHeight();
			validate();
			repaint();
		}else{
			addItemLabel(item);
		}
		
	}
	
//	@Override
//	public void addItemLabel(String[] item) {
//		super.addItemLabel(item);
//	}
	
}
