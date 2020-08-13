package com.nt.test;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class HBFiltersTest3 {

	public static void main(String[] args) {
		Session ses=null;
		List<BankAccount> list=null;
		CriteriaBuilder ctBuilder=null;
		CriteriaQuery<BankAccount> ctQuery=null;
		Root<BankAccount> root=null;
		Query query=null;
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
		//execute JPACriteria logic
		ctBuilder=ses.getCriteriaBuilder();
		ctQuery=ctBuilder.createQuery(BankAccount.class);
		root=ctQuery.from(BankAccount.class);
		ctQuery.select(root);
		query=ses.createQuery(ctQuery);
		list=query.getResultList();
		list.forEach(ac->{
			System.out.println(ac);
		});
		System.out.println("......................................");
		ses.disableFilter("AVOID_INACTIVE_ACCOUNTS");
		//execute JPAQBC Logic
		ctBuilder=ses.getCriteriaBuilder();
		ctQuery=ctBuilder.createQuery(BankAccount.class);
		root=ctQuery.from(BankAccount.class);
		ctQuery.select(root);
		query=ses.createQuery(ctQuery);
		list=query.getResultList();
		list.forEach(ac->{
			System.out.println(ac);
		});
		System.out.println("......................................");
		
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
