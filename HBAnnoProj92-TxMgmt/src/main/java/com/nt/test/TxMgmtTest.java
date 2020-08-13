package com.nt.test;

import com.nt.dao.BankAccountDAO;
import com.nt.factory.BankDAOFactory;
import com.nt.utility.HibernateUtil;

public class TxMgmtTest {

	public static void main(String[] args) {
		BankAccountDAO dao=null;
		//get DAO
		dao=BankDAOFactory.getInstance();
		//invoke methods
		try {
			System.out.println("Money Transffered??"+dao.transferMoney(1001,1008,5000));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close Session Factory
		HibernateUtil.closeSessionFactory();

	}//main
}//class
