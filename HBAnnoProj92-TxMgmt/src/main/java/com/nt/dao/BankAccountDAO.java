package com.nt.dao;

public interface BankAccountDAO {
	
	public  boolean transferMoney(int srcAcno,int destAcno,float amt);

}
