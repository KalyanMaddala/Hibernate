package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;
import org.hibernate.annotations.Type;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="INH_PAYMENT2")
public abstract class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(length = 5)
	@Type(type="int")
	private int txId;
	@Column(length=10)
	@Type(type="string")
	private  String payeeName;
	@Column(scale = 10,precision = 2)
	@Type(type="float")
	private float amount;
	public int getTxId() {
		return txId;
	}
	public void setTxId(int txId) {
		this.txId = txId;
	}
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Payment [txId=" + txId + ", payeeName=" + payeeName + ", amount=" + amount + "]";
	}

	
}
