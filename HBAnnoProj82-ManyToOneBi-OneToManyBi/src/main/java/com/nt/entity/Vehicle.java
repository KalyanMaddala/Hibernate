package com.nt.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.annotations.Type;

@Entity
@Table(name="VEHICLE1")
public class Vehicle implements Serializable {
    @Id
    @SequenceGenerator(name = "gen1",sequenceName = "VID_SEQ",initialValue = 1000,allocationSize = 1)
    @GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
    @Column(length = 10)
    @Type(type="int")
	private int vid;
    
    @Column(length = 15)
    @Type(type="string")
	private String modelName;
    @Column(length = 15)
    @Type(type="string")
	private String company;
    
	@ManyToOne(targetEntity = Person.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="person_id",referencedColumnName = "pid")
	@LazyToOne(LazyToOneOption.PROXY)
	private Person owner;
	
	public Vehicle() {
		System.out.println("Vehicle:: 0-param constructor");
	}
	
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Person getOwner() {
		return owner;
	}
	public void setOwner(Person owner) {
		this.owner = owner;
	}
	@Override
	public String toString() {
		return "Vehicle [vid=" + vid + ", modelName=" + modelName + ", company=" + company + "]";
	}
	
	

}
