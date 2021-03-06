package com.nt.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Country;
import com.nt.entity.TouristPlace;
import com.nt.utility.HibernateUtil;

public class OneToManyDAOImpl implements OneToManyDAO {

	@Override
	public void saveDataUsingParent() {
		Session ses=null;
		Transaction tx=null;
		Country country=null;
		TouristPlace place1=null,place2=null;
		List<TouristPlace>  childs=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare objects
		country=new Country();
		country.setCname("USA"); country.setCurrency("dollar"); 
		place1=new TouristPlace();
		place1.setPlaceName("Nayagara "); place1.setLocation("Newyork");
		place2=new TouristPlace();
		place2.setPlaceName("SOL"); place2.setLocation("NewYork");
		childs=new ArrayList();
		childs.add(place1); childs.add(place2);
		country.setPlaces(childs);
		
		try {
			//begin Tx
			tx=ses.beginTransaction();
			  ses.save(country);  
			flag=true;
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Tx Committed");
			}
			else {
				tx.rollback();
				System.out.println("Tx rolledback");
			}
			HibernateUtil.closeSession(ses);
		}//finally
	}//method

	@Override
	public void loadDataUsingParent() {
		Session ses=null;
		Transaction tx=null;
		
		List<Country>  list=null;
		Query query=null;
		//get Session
		ses=HibernateUtil.getSession();
		
		try {
			//execute HQL Query
			query=ses.createQuery("from Country");
			list=query.getResultList();
			list.forEach(ctry->{
				System.out.println("Parent:::"+ctry);
				List<TouristPlace>  childs=ctry.getPlaces();
				childs.forEach(place->{
					System.out.println("child::"+place);
				});
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
