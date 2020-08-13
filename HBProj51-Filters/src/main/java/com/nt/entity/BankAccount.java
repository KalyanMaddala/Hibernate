package com.nt.entity;


public class BankAccount {
	private  int acno;
	private String holderName;
	private  float balance;
	private  String status;
	
	public BankAccount() {
		System.out.println("BankAccount::0-param constructor");
	}
	
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BankAccount [acno=" + acno + ", holderName=" + holderName + ", balance=" + balance + ", status="
				+ status + "]";
	}
	
	

}
