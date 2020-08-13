package com.nt.entity;

public class Customer extends Person {
	private String addrs;
	private  float billAmt;
	public String getAddrs() {
		return addrs;
	}
	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}
	public float getBillAmt() {
		return billAmt;
	}
	public void setBillAmt(float billAmt) {
		this.billAmt = billAmt;
	}
	
	@Override
	public String toString() {
		return "Customer [addrs=" + addrs + ", billAmt=" + billAmt + ", toString()=" + super.toString() + "]";
	}
	
	

}
