package com.nt.entity;

import java.io.Serializable;

public class Department implements Serializable {

	private int deptNo;
	private String dname;
	private String location;
	
	public Department() {
          System.out.println("Department:: 0-param constructor-->"+this.getClass());
	}
	
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public String toString() {
		return "Department [deptNo=" + deptNo + ", dname=" + dname + ", location=" + location + "]";
	}

	
}
