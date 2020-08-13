package com.nt.entity;

import java.io.Serializable;

import org.hibernate.annsotations.Polymorphism;


public class Person implements Serializable {
	private int pid;
	private String pname;
	private String company;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", company=" + company + "]";
	}

	

}
