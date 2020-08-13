package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class SelectTestAfterSoftDeletion {

	public static void main(String[] args) {
		Session ses=null;
		Query query=null;
		List<BankAccount> list=null;
		//get Session
		ses=HibernateUtil.getSession();
		try {
			query=ses.createQuery("from BankAccount");
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
			//close jdbc objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
		

	}

}
