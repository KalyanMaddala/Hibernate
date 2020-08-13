package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name="BANKACCOUNT")
@Entity
@NamedQuery(name = "HQL_WITHDRAW",query = "UPDATE BankAccount SET balance=balance-:amount WHERE  acno=:acid")
@NamedQuery(name = "HQL_DEPOSITE",query = "UPDATE BankAccount SET balance=balance+:amount WHERE  acno=:acid")
public class BankAccount implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int acno;
	private String holderName;
	private float balance;
	public int getAcno() {
		return acno;
	}
	public void setAcno(int acno) {
		this.acno = acno;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "BankAccount [acno=" + acno + ", holderName=" + holderName + ", balance=" + balance + "]";
	}
	
	

}
