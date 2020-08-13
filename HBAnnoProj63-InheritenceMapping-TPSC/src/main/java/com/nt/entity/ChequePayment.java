package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="INH_CHEQUEPAYMENT2")
@PrimaryKeyJoinColumn(name="PAYMENT_ID",referencedColumnName ="TXID" )
public class ChequePayment extends Payment {
	@Column(length=16)
	@Type(type="long")
	private long chequeNo;
	@Column(length=10)
	@Type(type="string")
	private  String chequeType;
	@Column(length=10)
	@Type(type="string")
	private  String chequeBankName;
	
	public long getChequeNo() {
		return chequeNo;
	}
	public void setChequeNo(long chequeNo) {
		this.chequeNo = chequeNo;
	}
	public String getChequeType() {
		return chequeType;
	}
	public void setChequeType(String chequeType) {
		this.chequeType = chequeType;
	}
	public String getChequeBankName() {
		return chequeBankName;
	}
	public void setChequeBankName(String chequeBankName) {
		this.chequeBankName = chequeBankName;
	}
	@Override
	public String toString() {
		return "ChequePayment [chequeNo=" + chequeNo + ", chequeType=" + chequeType + ", chequeBankName="
				+ chequeBankName + ", toString()=" + super.toString() + "]";
	}
	
		
	

}
