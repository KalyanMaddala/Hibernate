package com.nt.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "PAYMENT_TYPE",discriminatorType = DiscriminatorType.STRING,length = 10)
@Table(name="INH_PAYMENT1")
public abstract class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int txId;
	private  String payeeName;
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
