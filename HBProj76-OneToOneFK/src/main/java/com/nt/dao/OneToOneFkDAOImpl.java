package com.nt.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Passport;
import com.nt.entity.Person;
import com.nt.utility.HibernateUtil;

public class OneToOneFkDAOImpl implements OneToOneFkDAO {

	@Override
	public void saveDataUsingChild() {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		Person per=null;
		Passport pspt=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare objects
		 per=new Person();
		 per.setPname("karan"); per.setPaddrs("hyd");
		 pspt=new Passport();
		 pspt.setCountry("India"); pspt.setExpirtyDate(new Date(2030,10,20));
		 pspt.setPersonDetails(per); 
		try {
			//begin Tx
			tx=ses.beginTransaction();
			  ses.save(pspt);
			flag=true;
		}
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Parent to child objs are saved");
			}
			else {
				tx.rollback();
				System.out.println("Parent to child objs are not saved");
			}
			//close Session
			HibernateUtil.closeSession(ses);
		}//finally
    }//method
	
	@Override
	public void loadDataUsingChild() {
		Session ses=null;
	    List<Passport> list=null;
	    Query query=null;
		//get Session
		ses=HibernateUtil.getSession();
		try {
		//create Query
		query=ses.createQuery("from Passport");
	   //execut query
		 list=query.getResultList();
		list.forEach(pspt->{
			System.out.println("child ::"+pspt);
			Person per=pspt.getPersonDetails();
			System.out.println("Parent::"+per);
		});
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession(ses);
		}
	}//method
	
}//class
