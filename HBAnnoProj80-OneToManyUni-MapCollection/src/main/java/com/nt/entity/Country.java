package com.nt.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;

@Entity
@Table(name="COUNTRY3")
public class Country implements Serializable {
	@Id
	@Column(length=10)
	@Type(type="int")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	@Column(length=15)
	@Type(type="string")
	private String cname;
	
	@Column(length=15)
	@Type(type="string")
	private String currency;
	
	@OneToMany(targetEntity =TouristPlace.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
	@JoinColumn(name = "country_id",referencedColumnName = "cid")
	@LazyCollection(LazyCollectionOption.EXTRA)
	@Fetch(FetchMode.SELECT)
	@MapKeyColumn(name = "map_index",length = 10)
	private Map<String,TouristPlace> places;
	
	public Country() {
		System.out.println("Country:: 0-param constructor");
	}
	
    //setters && getters
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Map<String,TouristPlace> getPlaces() {
		return places;
	}

	public void setPlaces(Map<String,TouristPlace> places) {
		this.places = places;
	}

	@Override
	public String toString() {
		return "Country [cid=" + cid + ", cname=" + cname + ", currency=" + currency + "]";
	}
	
	

}
