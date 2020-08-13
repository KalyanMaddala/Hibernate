package com.nt.dao;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Passport;
import com.nt.entity.Person;
import com.nt.entity.Vehicle;
import com.nt.utility.HibernateUtil;

public class OneToOneDAOImpl implements OneToOneDAO {

	
	@Override
	public void saveDataUsingParent() {
		Session ses=null;
		Person per=null;
		Passport pspt=null;
		Transaction tx=null;
		boolean flag=false;
		Vehicle v1=null,v2=null;
		Set<Vehicle> childs=null;
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
		
		v1=new Vehicle();
		v1.setModel("Q8");
		v1.setCompany("Audi");
		
		v2=new Vehicle();
		v2.setModel("S-Class");
		v2.setCompany("M-Benz");
		childs=new HashSet();
		childs.add(v1); childs.add(v2);
		
		
		
		per.setPassportDetails(pspt);
		pspt.setPerosnDetails(per);
		per.setVehicles(childs);
		
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

	
	
	 
}//class
