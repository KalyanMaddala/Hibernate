package com.nt.entity;

import java.io.Serializable;

public class JobDetails implements Serializable {
	private int deptno;
	private String company;
	private String desg;
	private float salary;

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDesg() {
		return desg;
	}

	public void setDesg(String desg) {
		this.desg = desg;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "JobDetails [deptno=" + deptno + ", company=" + company + ", desg=" + desg + ", salary=" + salary + "]";
	}
	
	
}
