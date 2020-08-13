package com.nt.test;



import org.hibernate.Cache;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.InsurancePolicy;

public class GetObjectTest {

	public static void main(String[] args) {
		Session ses=null;
		InsurancePolicy policy=null;
		Configuration cfg=null;
		SessionFactory factory=null;
		Transaction tx=null;
		//crreate Configuration,SessionFactory, Session objs
		cfg=new Configuration();
		cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		factory=cfg.buildSessionFactory();
		ses=factory.openSession();
		
		try {
			tx=ses.beginTransaction();
			 System.out.println("tx object class name::"+tx.getClass());
			//Load object
			policy=ses.get(InsurancePolicy.class,9001);  //get DB and keeps L2,L1 caches
			System.out.println(policy);
			System.out.println("...............");
		
			policy=ses.get(InsurancePolicy.class,9001); //gets L1Cache
			System.out.println(policy);
			System.out.println("...........................");
		
			ses.clear();  //removes form L1 cache
			policy=ses.get(InsurancePolicy.class,9001); //gets from L2 Cache and keeps L1 cache
			System.out.println(policy);
		
			System.out.println("..............................");
			try {
				Thread.sleep(21000);  //Removes from L2 cache
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			ses.clear();
			policy=ses.get(InsurancePolicy.class,9001); //gets from L2 Cache and keeps L1 cache
			System.out.println(policy);
			
			Cache cache=factory.getCache();
			cache.evict(InsurancePolicy.class);
			ses.evict(policy);
			policy=ses.get(InsurancePolicy.class,9001); //gets from L2 Cache and keeps L1 cache
			System.out.println(policy);
			
			
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close  objs
		   ses.close();
		   factory.close();
		}

	}//main
}//class
