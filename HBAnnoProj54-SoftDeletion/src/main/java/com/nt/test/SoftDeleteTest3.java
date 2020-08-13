package com.nt.test;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class SoftDeleteTest3 {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		BankAccount ac1=null;
		boolean flag=false;
		int count=0;
		CriteriaBuilder builder=null;
		CriteriaUpdate<BankAccount> ctUpdate=null;
		Root<BankAccount>  root=null;
		Query query=null;
		
		//get Session
		ses=HibernateUtil.getSession();
		try {
			//begin Tx
			tx=ses.beginTransaction();
			//execute JPA QBC Delete logic
			builder=ses.getCriteriaBuilder();
			ctUpdate=builder.createCriteriaUpdate(BankAccount.class);
			root=ctUpdate.from(BankAccount.class);
			ctUpdate.set("status","closed");
			ctUpdate.where(builder.equal(root.get("acno"), 1003));
			query=ses.createQuery(ctUpdate);
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
