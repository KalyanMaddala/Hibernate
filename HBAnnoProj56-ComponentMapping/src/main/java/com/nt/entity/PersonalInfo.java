package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PERSONAL_INFO")
public class PersonalInfo implements Serializable {
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE)
	private int pid;
	private String pname;
	private  String addrs;
	@Embedded
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
