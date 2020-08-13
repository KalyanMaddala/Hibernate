package com.nt.dao;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Passport;
import com.nt.entity.Person;
import com.nt.utility.HibernateUtil;

public class OneToOneDAOImpl implements OneToOneDAO {

	
	@Override
	public void saveDataUsingParent() {
		Session ses=null;
		Person per=null;
		Passport pspt=null;
		Transaction tx=null;
		boolean flag=false;
	  //get Session	
		ses=HibernateUtil.getSession();
		//prepare objects
		per=new Person();
		per.setPname("ramesh");
		per.setPaddrs("hyd");
		pspt=new Passport();
		pspt.setRegionOffice("hyd");
		pspt.setCountry("india");
		pspt.setExpiryDate(new Date(2041,10,30));
		per.setPassportDetails(pspt);
		pspt.setPerosnDetails(per);
		try {
			tx=ses.beginTransaction();
			   ses.save(per);
			flag=true;
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Objects are saved");
			}
			else {
				tx.rollback();
				System.out.println("Objects are not saved");
			}
			//close session
			HibernateUtil.closeSession(ses);
		}//finally
	}//method

	@Override
	public void saveDataUsingChild() {
		Session ses=null;
		Person per=null;
		Passport pspt=null;
		Transaction tx=null;
		boolean flag=false;
	  //get Session	
		ses=HibernateUtil.getSession();
		//prepare objects
		per=new Person();
		per.setPname("suresh");
		per.setPaddrs("hyd");
		pspt=new Passport();
		pspt.setRegionOffice("hyd");
		pspt.setCountry("india");
		pspt.setExpiryDate(new Date(2060,11,2));
		per.setPassportDetails(pspt);
		pspt.setPerosnDetails(per);
		try {
			tx=ses.beginTransaction();
			   ses.save(pspt);
			flag=true;
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Objects are saved");
			}
			else {
				tx.rollback();
				System.out.println("Objects are not saved");
			}
			//close session
			HibernateUtil.closeSession(ses);
		}//finally
		
	}
	
	 
}//class
