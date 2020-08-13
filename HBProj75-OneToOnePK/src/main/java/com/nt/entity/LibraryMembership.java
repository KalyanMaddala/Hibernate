package com.nt.entity;

import java.io.Serializable;
import java.util.Date;

public class LibraryMembership implements Serializable{
	private int lid;
	private  Date doj;
	private String type;

	private Student studentDetails;
	
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Student getStudentDetails() {
		return studentDetails;
	}
	public void setStudentDetails(Student studentDetails) {
		this.studentDetails = studentDetails;
	}
	
	@Override
	public String toString() {
		return "LibraryMembership [lid=" + lid + ", doj=" + doj + ", type=" + type + "]";
	}
}
