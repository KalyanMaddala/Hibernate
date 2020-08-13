package com.nt.factory;

import com.nt.dao.BankAccountDAO;
import com.nt.dao.BankAccountDAOImpl;

public class BankDAOFactory {
	
	public static  BankAccountDAO  getInstance() {
		 return  new BankAccountDAOImpl();
	}

}
