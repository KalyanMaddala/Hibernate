package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="TOURISTPLACE2")
public class TouristPlace implements Serializable {
	@Id
	@Column(length=10)
	@Type(type="int")
	@SequenceGenerator(name = "gen1",sequenceName = "TPID_SEQ",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private int tpid;
	@Column(length=15)
	@Type(type="string")
	private String placeName;
	@Column(length=15)
	@Type(type="string")
	private String location;
	
	public TouristPlace() {
		System.out.println("TouristPlace:: 0-param constructor");
	}
	
	public int getTpid() {
		return tpid;
	}
	public void setTpid(int tpid) {
		this.tpid = tpid;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public String toString() {
		return "TouristPlace [tpid=" + tpid + ", placeName=" + placeName + ", location=" + location + "]";
	}
	
	

}
