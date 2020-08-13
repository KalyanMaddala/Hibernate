package com.nt.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="PERSON_DETAILS")
public class Person implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length=10)
	@Type(type="int")
	private int pid;
	@Column(length=15)
	@Type(type="string")
	private String pname;
	@Column(length=15)
	@Type(type="string")
	private String paddrs;
	@OneToOne(targetEntity = Passport.class,cascade =CascadeType.ALL,fetch = FetchType.LAZY ,mappedBy = "perosnDetails")
	private Passport  passportDetails;
	@OneToMany(targetEntity = Vehicle.class,cascade =CascadeType.ALL,fetch = FetchType.LAZY )
	@JoinColumn(name="person_id",referencedColumnName = "pid")
	private  Set<Vehicle> vehicles;

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
	public String getPaddrs() {
		return paddrs;
	}
	public void setPaddrs(String paddrs) {
		this.paddrs = paddrs;
	}
	public Passport getPassportDetails() {
		return passportDetails;
	}
	public void setPassportDetails(Passport passportDetails) {
		this.passportDetails = passportDetails;
	}
	
	
	public Set<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(Set<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs + "]";
	}
	
	

}
