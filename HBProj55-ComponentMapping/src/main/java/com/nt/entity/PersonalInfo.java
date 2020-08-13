package com.nt.entity;

import java.io.Serializable;

public class PersonalInfo implements Serializable {
	private int pid;
	private String pname;
	private  String addrs;
	private JobDetails details;
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
	public String getAddrs() {
		return addrs;
	}
	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}
	public JobDetails getDetails() {
		return details;
	}
	public void setDetails(JobDetails details) {
		this.details = details;
	}
	@Override
	public String toString() {
		return "PersonalInfo [pid=" + pid + ", pname=" + pname + ", addrs=" + addrs + ", details=" + details + "]";
	}

	
}
