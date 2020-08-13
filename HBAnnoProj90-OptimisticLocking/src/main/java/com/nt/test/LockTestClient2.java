package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class LockTestClient2 {

	public static void main(String[] args) {
		Session ses=null;
		InsurancePolicy policy= null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		try {
			//Load object
			 policy=ses.get(InsurancePolicy.class, 9001);
			 System.out.println(policy);
			 //Thread.sleep(30000);  //Run second client in this sleep time
			 //begin Tx
			 tx=ses.beginTransaction();
			    policy.setTenure(30);
            flag=true;			    
		}//try
		catch(HibernateException he) {
			 he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Object Modified");
			}
			else {
				tx.rollback();
				System.out.println("Object is not Modified");
			}
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}

	}

}
