package com.nt.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CASH")
public class CashPayment extends Payment {
	private String denominations;
	private  String witness;
	private  String location;
	public String getDenominations() {
		return denominations;
	}
	


	public void setDenominations(String denominations) {
		this.denominations = denominations;
	}
	public String getWitness() {
		return witness;
	}
	public void setWitness(String witness) {
		this.witness = witness;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	@Override
	public String toString() {
		return "CashPayment [denominations=" + denominations + ", witness=" + witness + ", location=" + location
				+ ", toString()=" + super.toString() + "]";
	}
		
	

}
