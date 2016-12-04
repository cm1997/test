/**
 * 结果消息枚举
 * @author Polaris Chen
 * @date 2015/10/19
 */
package org.cross.elscommon.util;

public enum ResultMessage {
	SUCCESS, // 成功
	FAILED, // 失败
	WRONG, // 错误
	EXIST, // 已存在
	NOT_EXIST, // 不存在
	TOO_LONG, // 输入过长
	TOO_SHORT, // 输入过短
	UNVALID, // 含有非法字符
	NULL; // 输入为空

	public String toString() {
		switch (this) {
		case TOO_LONG:
			return "输入过长";
		case TOO_SHORT:
			return "输入过短";
		case UNVALID:
			return "含有非法字符";
		case NULL:
			return "输入为空";
		default:
			return null;
		}
	}

}
