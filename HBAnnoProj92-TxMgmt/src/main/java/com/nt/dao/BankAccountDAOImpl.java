package com.nt.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.utility.HibernateUtil;

public class BankAccountDAOImpl implements BankAccountDAO {

	@Override
	public boolean transferMoney(int srcAcno, int destAcno, float amt) {
		Session ses=null;
		Transaction tx=null;
		Query query1=null,query2=null;
		int result1=0,result2=0;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		   //get Access to named queries
		  query1=ses.getNamedQuery("HQL_WITHDRAW");
		  //set query param values
		  query1.setParameter("amount",amt);
		  query1.setParameter("acid",srcAcno);
		  query2=ses.getNamedQuery("HQL_DEPOSITE");
		  query2.setParameter("amount",amt);
		  query2.setParameter("acid",destAcno);
		try {
			//begin the Tx
			 tx=ses.beginTransaction();
			    //execute queries
			 result1=query1.executeUpdate();
			 result2=query2.executeUpdate();
			 if(result1==0 || result2==0)
				   flag=false;
			 else
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
			}
			else {
				tx.rollback();
			}
			HibernateUtil.closeSession(ses);
		}//finally
		return flag;
	}//method
}//class
