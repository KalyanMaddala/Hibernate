package com.nt.entity;

import java.io.Serializable;
import java.util.Set;

public class College implements Serializable {
	private int cid;
	private String name;
	private String location;
	private  Set<Student>  students;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "College [cid=" + cid + ", name=" + name + ", location=" + location + "]";
	}

}
