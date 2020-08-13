package com.nt.dao;

import java.util.HashSet;
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
		Set<TouristPlace>  childs=null;
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
		childs=new HashSet();
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
				Set<TouristPlace>  childs=ctry.getPlaces();
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

	@Override
	public void loadDataUsingParentWithQBC() {
		Session ses=null;
		Transaction tx=null;
		
		List<Country>  list=null;
		Criteria criteria=null;
		//get Session
		ses=HibernateUtil.getSession();
		
		try {
			//execute HQL Query
			criteria=ses.createCriteria(Country.class);
			list=criteria.list();
			list.forEach(ctry->{
				System.out.println("Parent:::"+ctry);
				Set<TouristPlace>  childs=ctry.getPlaces();
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
		
	}

	@Override
	public void deleteOneChildFromCollectionOfChildsBelongingToAParent() {
		Session ses=null;
		Transaction tx=null;
		Country country=null;
		Set<TouristPlace> childs=null;
		Criteria criteria=null;
		TouristPlace place=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//Load Parent
		country=ses.get(Country.class,1);
		//get childs of a prent
		childs=country.getPlaces();
		//Load child object
		place=ses.get(TouristPlace.class,102);
		try {
			tx=ses.beginTransaction();
			   childs.remove(place);
			flag=true;
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("One child from collection of childs beloging to a parent is deleted");
			}
			else {
				tx.rollback();
				System.out.println("One child from collection of childs beloging to a parent is not deleted");
			}
			//close session
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
}//class
