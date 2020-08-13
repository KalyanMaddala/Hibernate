package com.nt.test;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class HBFiltersTest1 {

	public static void main(String[] args) {
		Session ses=null;
		List<BankAccount> list=null;
		NativeQuery query=null;
		Filter filter1=null;
		try {
		// Get Session
		ses=HibernateUtil.getSession();
		//enable Filter
		filter1=ses.enableFilter("AVOID_INACTIVE_ACCOUNTS");
		//set param values
		filter1.setParameter("type1","blocked");
		filter1.setParameter("type2","closed");
		filter1.setParameter("type3","disabled");
		//execute NativeSQL query
		query=ses.createSQLQuery("SELECT * FROM BANKACCOUNT");
		//map results with Entity class
		query.addEntity(BankAccount.class);
		list=query.getResultList();
		list.forEach(ac->{
			System.out.println(ac);
		});
		System.out.println("......................................");
		ses.disableFilter("AVOID_INACTIVE_ACCOUNTS");
		//execute HQL query
		query=ses.createSQLQuery("SELECT * FROM BANKACCOUNT");
		query.addEntity(BankAccount.class);
		list=query.getResultList();
		list.forEach(ac->{
			System.out.println(ac);
		});
		
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
		
	
		

	}//main
}//class
