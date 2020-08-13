package com.nt.entity;

public class Employee extends Person {
	private String desg;
	private float salary;
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
		return "Employee [desg=" + desg + ", salary=" + salary + ", toString()=" + super.toString() + "]";
	}
	
	
	
	

}
