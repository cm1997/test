package org.cross.elscommon.util;

public enum ApproveType {
	
	APPROVED, //特快
	NOT_APPROVED,//标准快递
	UNCHECKED;//经济快递
	
	public String toString() {
		switch (this) {
		case APPROVED:
			return "审批通过";
		case NOT_APPROVED:
			return "审批未通过";
		case UNCHECKED:
			return "尚未审批";
		default:
			return null;
		}
	}

}
