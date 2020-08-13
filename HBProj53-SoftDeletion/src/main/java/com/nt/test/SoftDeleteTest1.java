package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class SoftDeleteTest1 {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		BankAccount ac1=null;
		boolean flag=false;
		Query  query=null;
		int count=0;
		
		//get Session
		ses=HibernateUtil.getSession();
	
		try {
			//begin Tx
			tx=ses.beginTransaction();
			//prepare HQL query
			query=ses.createQuery("update BankAccount set status='closed' where acno=:id");
			//set query param value
			query.setParameter("id",1001);
			//execute query
			count=query.executeUpdate();
			flag=true;
		}
		catch(HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		catch(Exception e) {
			flag=false;
			e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println(count+" no.of Record(s) deleted(soft)");
			}
			else {
				tx.rollback();
				System.out.println("Record not deleted");
			}
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
