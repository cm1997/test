package org.cross.elscommon.po;

import java.io.Serializable;

import org.cross.elscommon.util.SalaryType;

@SuppressWarnings("serial")
public class SalaryPO implements Serializable{

	private SalaryType type;

	private double salaryByMonth;

	private double addOnce;

	private double addNum;

	private String perNum;

	public SalaryPO(SalaryType type, double salaryByMonth, double addOnce,
			double addNum, String perNum) {
		super();
		this.type = type;
		this.salaryByMonth = salaryByMonth;
		this.addOnce = addOnce;
		this.addNum = addNum;
		this.perNum = perNum;
	}

	public SalaryType getType() {
		return type;
	}

	public void setType(SalaryType type) {
		this.type = type;
	}

	public double getSalaryByMonth() {
		return salaryByMonth;
	}

	public void setSalaryByMonth(double salaryByMonth) {
		this.salaryByMonth = salaryByMonth;
	}

	public double getAddOnce() {
		return addOnce;
	}

	public void setAddOnce(double addOnce) {
		this.addOnce = addOnce;
	}

	public double getAddNum() {
		return addNum;
	}

	public void setAddNum(double addNum) {
		this.addNum = addNum;
	}

	public String getPerNum() {
		return perNum;
	}

	public void setPerNum(String perNum) {
		this.perNum = perNum;
	}

}
