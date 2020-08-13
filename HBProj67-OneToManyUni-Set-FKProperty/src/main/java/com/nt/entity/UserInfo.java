package com.nt.entity;

import java.io.Serializable;
import java.util.Set;

public class UserInfo implements Serializable{
	private int userId;
	private String name;
	private String addrs;
	private Set<PhoneNumber> phones;
	
	public UserInfo() {
		System.out.println("UserInfo:: 0-param constructor");
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddrs() {
		return addrs;
	}
	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}
	public Set<PhoneNumber> getPhones() {
		return phones;
	}
	public void setPhones(Set<PhoneNumber> phones) {
		this.phones = phones;
	}
	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", name=" + name + ", addrs=" + addrs;
	}
	
	

}
