package com.nt.entity;

import java.io.Serializable;
import java.util.Date;

public class Passport implements Serializable {
	private int psid;
	private String country;
	private Date expirtyDate;
	private Person personDetails;
	public int getPsid() {
		return psid;
	}
	public void setPsid(int psid) {
		this.psid = psid;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Date getExpirtyDate() {
		return expirtyDate;
	}
	public void setExpirtyDate(Date expirtyDate) {
		this.expirtyDate = expirtyDate;
	}
	public Person getPersonDetails() {
		return personDetails;
	}
	public void setPersonDetails(Person personDetails) {
		this.personDetails = personDetails;
	}
	
	@Override
	public String toString() {
		return "Passport [psid=" + psid + ", country=" + country + ", expirtyDate=" + expirtyDate + "]";
	}
	
	

}
