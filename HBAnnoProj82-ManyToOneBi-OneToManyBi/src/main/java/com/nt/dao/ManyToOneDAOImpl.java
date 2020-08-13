package com.nt.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Person;
import com.nt.entity.Vehicle;
import com.nt.utility.HibernateUtil;

public class ManyToOneDAOImpl implements ManyToOneDAO {

	@Override
	public void saveData() {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		Vehicle vehicle1=null,vehicle2=null; 
		Person person=null;
		Set<Vehicle> childs=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare object
		person=new Person();
		person.setPname("karan"); person.setPaddrs("hyd");
		vehicle1=new Vehicle();
		vehicle1.setModelName("Swift");vehicle1.setCompany("Maruthi-Suzuki");
		vehicle2=new Vehicle();
		vehicle2.setModelName("Q8");vehicle2.setCompany("Audi");
		//set parent to childs
		vehicle1.setOwner(person);
		vehicle2.setOwner(person);
		//set childs to parent
		childs=new HashSet();
		childs.add(vehicle1); childs.add(vehicle2);
		person.setVehicles(childs);
		try {
			//begin Tx
			tx=ses.beginTransaction();
			  ses.save(person);
			flag=true;
		}
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
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
		}
	}//finally

	@Override
	public void loadData() {
		Session ses=null;
		Query query=null;
		List<Vehicle> list=null;
	
	   //get Session 
		ses=HibernateUtil.getSession();
		try {
		//prepare and execute HQL Query
		query=ses.createQuery("from Vehicle");
		list=query.getResultList();
		list.forEach(v->{
			System.out.println("child::"+v);
			//get access to the parent
				/*Person per=v.getOwner();
				System.out.println("Parent::"+per); */
		});
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			//close session
			HibernateUtil.closeSession(ses);
		}
	}
}//class
