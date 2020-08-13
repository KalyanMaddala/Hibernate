package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.nt.entity.PersonalInfo;
import com.nt.utility.HibernateUtil;

public class ComponentMappingSelectTest {

	public static void main(String[] args) {
		Session ses=null;
		List<PersonalInfo> list=null;
		Query query=null,query1=null;
		//get Session
		ses=HibernateUtil.getSession();
		try {
			//Load objects
			query=ses.createQuery("from PersonalInfo");
			list=query.list();
			list.forEach(info->{
				System.out.println(info);
			});
			System.out.println("..........................");
			query1=ses.createQuery("from PersonalInfo where details.desg=:role");
			query1.setParameter("role", "MANAGER");
			list=query1.list();
			list.forEach(info->{
				System.out.println(info);
			});
			
		}//try
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
		}//finally

	}//main
}//class
