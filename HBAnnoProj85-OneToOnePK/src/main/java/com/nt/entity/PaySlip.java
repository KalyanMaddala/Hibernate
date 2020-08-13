package com.nt.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
@Entity
public class PaySlip implements Serializable {
	@Id
	@GenericGenerator(name = "gen1", strategy = "foreign",parameters =@Parameter(name="property",value="empDetails") )
	@GeneratedValue(generator = "gen1")
	@Column(length = 10)
	@Type(type="int")
	private int  payId;
	@Column(length = 15)
	@Type(type="string")
	private String company;
	@Column(length = 15)
	@Type(type="float")
	private float salary;
	@Column(length = 15)
	@Type(type="float")
	private float deductions;
	@OneToOne(targetEntity = Employee.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy="paymentDetials")
	private Employee empDetails;
	public int getPayId() {
		return payId;
	}
	public void setPayId(int payId) {
		this.payId = payId;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public float getDeductions() {
		return deductions;
	}
	public void setDeductions(float deductions) {
		this.deductions = deductions;
	}
	public Employee getEmpDetails() {
		return empDetails;
	}
	public void setEmpDetails(Employee empDetails) {
		this.empDetails = empDetails;
	}
	@Override
	public String toString() {
		return "PaySlip [payId=" + payId + ", company=" + company + ", salary=" + salary + ", deductions=" + deductions
				+ "]";
	}
	
	
	

}
