package com.nt.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="PASSPORT_DETAILS")
public class Passport implements Serializable {
	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "PSPTNO_SEQ",initialValue = 10000,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	@Column(length=10)
	@Type(type="int")
	private int psptNo;
	
	@Column(length=15)
	@Type(type="string")
	private String regionOffice;
	
	@Column(length=10)
	@Type(type="string")
	private String country;
	
	@Type(type="date")
	private Date expiryDate;
	@OneToOne(targetEntity = Person.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "person_id",referencedColumnName = "pid")
	private  Person perosnDetails;
	public int getPsptNo() {
		return psptNo;
	}
	public void setPsptNo(int psptNo) {
		this.psptNo = psptNo;
	}
	public String getRegionOffice() {
		return regionOffice;
	}
	public void setRegionOffice(String regionOffice) {
		this.regionOffice=regionOffice;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Person getPerosnDetails() {
		return perosnDetails;
	}
	public void setPerosnDetails(Person perosnDetails) {
		this.perosnDetails = perosnDetails;
	}
	@Override
	public String toString() {
		return "Passport [psptNo=" + psptNo + ", regionOffice=" +regionOffice + ", country=" + country + ", expiryDate="
				+ expiryDate + "]";
	}
	

}
