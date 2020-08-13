package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.SQLDelete;

@Entity
@FilterDef(name = "AVOID_INACTIVE_ACCOUNTS",
                     parameters = {@ParamDef(name = "type1", type = "string"),
                    		                  @ParamDef(name = "type2", type = "string"),
                    		                  @ParamDef(name = "type3", type = "string")
                                               }
                    )
@Filter(name = "AVOID_INACTIVE_ACCOUNTS",condition = "STATUS NOT IN(:type1,:type2,:type3)")
public class BankAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
