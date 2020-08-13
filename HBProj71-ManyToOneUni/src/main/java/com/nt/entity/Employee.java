package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Id;

public class Employee implements Serializable {
	private int empNo;
	private  String ename;
	private  String desg;
	private  float salary;
	private  Department dept;
	
	public Employee() {
		System.out.println("Employee:: 0-param constructor");
	}
	
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
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
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	
	
	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", ename=" + ename + ", desg=" + desg + ", salary=" + salary + "]";
	}
	
	
	

}
