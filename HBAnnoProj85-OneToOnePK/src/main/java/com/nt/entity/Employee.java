package com.nt.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="EmpDetails")
public class Employee implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 10)
	@Type(type="int")
	private int empNo;
	@Column(length = 15)
	@Type(type="string")
	private String empName;
	@Column(length = 15)
	@Type(type="string")
	private String  empAddrs;
	@Column(length = 15)
	@Type(type="int")
	private int deptNo;
	@OneToOne(targetEntity = PaySlip.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn(name = "payId",referencedColumnName = "empNo")
	private PaySlip  paymentDetials;
	
	
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpAddrs() {
		return empAddrs;
	}
	public void setEmpAddrs(String empAddrs) {
		this.empAddrs = empAddrs;
	}
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	
	
	public PaySlip getPaymentDetials() {
		return paymentDetials;
	}
	public void setPaymentDetials(PaySlip paymentDetials) {
		this.paymentDetials = paymentDetials;
	}
	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", empAddrs=" + empAddrs + ", deptNo=" + deptNo
				+ "]";
	}

}
