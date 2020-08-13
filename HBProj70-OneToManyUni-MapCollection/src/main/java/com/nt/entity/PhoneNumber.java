package com.nt.entity;

import java.io.Serializable;

public class PhoneNumber  implements Serializable {
	private long phoneNumber;
	private String numberType;
	private String provider;
	
	public PhoneNumber() {
		System.out.println("PhoneNumber:: 0-param constructor");
	}
	
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getNumberType() {
		return numberType;
	}
	public void setNumberType(String numberType) {
		this.numberType = numberType;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	
	@Override
	public String toString() {
		return "PhoneNumber [phoneNumber=" + phoneNumber + ", numberType=" + numberType + ", provider=" + provider
				+ "]";
	}
	
	

}
