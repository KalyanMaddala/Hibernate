package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="VEHICLE_DETAILS")
public class Vehicle {
	@Id
	@SequenceGenerator(name="gen2",sequenceName = "REGNO_SEQ",initialValue = 90001,allocationSize = 1)
	@GeneratedValue(generator = "gen2",strategy = GenerationType.SEQUENCE)
	@Column(name="regNo",length = 10)
	@Type(type="long")
	private long regNo;
	@Column(name="model",length = 15)
	@Type(type="string")
	private String model;
	@Column(name="company",length = 15)
	@Type(type="string")
	private String company;
	
	public long getRegNo() {
		return regNo;
	}
	public void setRegNo(long regNo) {
		this.regNo = regNo;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "Vehicle [regNo=" + regNo + ", model=" + model + ", company=" + company + "]";
	}
	
	

}
