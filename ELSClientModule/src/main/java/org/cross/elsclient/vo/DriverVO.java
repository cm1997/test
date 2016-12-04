package org.cross.elsclient.vo;

import org.cross.elscommon.po.SalaryPO;
import org.cross.elscommon.util.PositionType;

public class DriverVO extends PersonnelVO {

	/**
	 * 行驶证颁发时间
	 */
	public String licenceStart;
	/**
	 * 行驶证到期时间
	 */
	public String licenceEnd;

	public DriverVO(String number, String name, PositionType position, String orgNum, String sex, String id,
			String phone, String birthday, SalaryPO salary, String licenceStart, String licenceEnd) {
		super(number, name, position, orgNum, sex, id, phone, birthday);
		this.licenceStart = licenceStart;
		this.licenceEnd = licenceEnd;
	}

}
