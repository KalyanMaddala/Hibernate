package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="INH_CASHPAYMENT2")
@PrimaryKeyJoinColumn(name="PAYMENT_ID",referencedColumnName ="TXID" )
public class CashPayment extends Payment {
	@Column(length=30)
	@Type(type="string")
	private String denominations;
	@Column(length=10)
	@Type(type="string")
	private  String witness;
	@Column(length=10)
	@Type(type="string")
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
