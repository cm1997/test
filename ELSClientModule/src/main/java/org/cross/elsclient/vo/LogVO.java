/**
 * 系统日志VO
 * @author Polaris Chen
 * @date 2015/10/19
 */
package org.cross.elsclient.vo;

public class LogVO {

	/**
	 * 编号
	 */
	public String id;

	/**
	 * 操作时间
	 */
	public String time;

	/**
	 * 操作人员
	 */
	public String operator;

	/**
	 * 操作内容
	 */
	public String content;

	/**
	 * 构造方法
	 * 
	 * @param id
	 * @param time
	 * @param operator
	 * @param content
	 */
	public LogVO(String id, String time, String operator, String content) {
		this.id = id;
		this.time = time;
		this.operator = operator;
		this.content = content;
	}
}
