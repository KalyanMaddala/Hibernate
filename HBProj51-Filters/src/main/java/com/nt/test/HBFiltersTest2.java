package com.nt.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class HBFiltersTest2 {

	public static void main(String[] args) {
		Session ses=null;
		List<BankAccount> list=null;
		Criteria criteria=null;
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
		//execute HB Criteria logic
		criteria=ses.createCriteria(BankAccount.class);
		//map results with Entity class
		list=criteria.list();
		list.forEach(ac->{
			System.out.println(ac);
		});
		System.out.println("......................................");
		ses.disableFilter("AVOID_INACTIVE_ACCOUNTS");
		//execute QBC Logic
		//execute HB Criteria logic
		criteria=ses.createCriteria(BankAccount.class);
		//map results with Entity class
		list=criteria.list();
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
