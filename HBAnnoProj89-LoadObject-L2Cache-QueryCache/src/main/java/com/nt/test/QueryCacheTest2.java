package com.nt.test;



import java.util.List;

import org.hibernate.Cache;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.nt.entity.InsurancePolicy;

public class QueryCacheTest2 {

	public static void main(String[] args) {
		Session ses=null;
		InsurancePolicy policy=null;
		Configuration cfg=null;
		SessionFactory factory=null;
		NativeQuery query=null;
		List<InsurancePolicy> list=null;
		Cache cache=null;
		//crreate Configuration,SessionFactory, Session objs
		cfg=new Configuration();
		cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		factory=cfg.buildSessionFactory();
		ses=factory.openSession();
		
		try {
			//prepare Criteria
			query=ses.createSQLQuery("select * from InsurancePolicy");
			query.setCacheable(true);
			query.addEntity(InsurancePolicy.class);
			//execute HQL
			list=query.list();
			list.forEach(ip->{
				System.out.println(ip);
			});
			System.out.println(".........................................");
			list=query.list();
			list.forEach(ip->{
				System.out.println(ip);
			});
			//dislable query cache
			cache=factory.getCache();
			//cache.evictQueryRegion("region1");
			cache.evictQueryRegions();
			
			System.out.println(".........................................");
			list=query.list();
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
