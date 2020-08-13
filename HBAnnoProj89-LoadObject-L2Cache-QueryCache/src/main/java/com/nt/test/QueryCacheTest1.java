package com.nt.test;



import java.util.List;

import org.hibernate.Cache;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.entity.InsurancePolicy;

public class QueryCacheTest1 {

	public static void main(String[] args) {
		Session ses=null;
		InsurancePolicy policy=null;
		Configuration cfg=null;
		SessionFactory factory=null;
		Criteria criteria=null;
		List<InsurancePolicy> list=null;
		Cache cache=null;
		//crreate Configuration,SessionFactory, Session objs
		cfg=new Configuration();
		cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		factory=cfg.buildSessionFactory();
		ses=factory.openSession();
		
		try {
			//prepare Criteria
			criteria=ses.createCriteria(InsurancePolicy.class);
			criteria.setCacheable(true);
			//execute HQL
			list=criteria.list();
			list.forEach(ip->{
				System.out.println(ip);
			});
			System.out.println(".........................................");
			list=criteria.list();
			list.forEach(ip->{
				System.out.println(ip);
			});
			//dislable query cache
			cache=factory.getCache();
			//cache.evictQueryRegion("region1");
			cache.evictQueryRegions();
			
			System.out.println(".........................................");
			list=criteria.list();
			list.forEach(ip->{
				System.out.println(ip);
			});
			
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
