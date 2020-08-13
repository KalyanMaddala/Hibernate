package com.nt.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.PhoneNumber;
import com.nt.entity.UserInfo;
import com.nt.utility.HibernateUtil;

public class OneToManyDAOImpl implements OneToManyDAO {

	@Override
	public void saveData() {
		Session ses=null;
		UserInfo user=null;
		PhoneNumber ph1=null,ph2=null;
		Set<PhoneNumber>  childs=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare objects
		//parent object
		user=new UserInfo();
		user.setName("rajesh");
		user.setAddrs("hyd");
	    //child objects
		ph1=new PhoneNumber();
		ph1.setPhoneNumber(993199999L);
		ph1.setNumberType("office");
		ph1.setProvider("airtel");
		
		ph2=new PhoneNumber();
		ph2.setPhoneNumber(881148888L);
		ph2.setNumberType("residence");
		ph2.setProvider("idea");
		//add Child objects to Collection
		childs=new HashSet();
		childs.add(ph1); childs.add(ph2);
		//set Childs Collection to parent
		user.setPhones(childs);
		try {
			tx=ses.beginTransaction();
			  ses.save(user);
			flag=true;
		}//try
		catch(HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("parent and child objects are saved");
			}
			else {
				tx.rollback();
				System.out.println("Parent and child objects are not saved");
			}
			//close Session 
			HibernateUtil.closeSession(ses);
		}//finally
	}//method

	@Override
	public void loadData() {
		Session ses=null;
		List<UserInfo> list=null;
		Query query=null;
		//get Session
		ses=HibernateUtil.getSession();
		try {
		//Load objects
		query=ses.createQuery("from UserInfo");
		//execute query
		list=query.list();
		//proces result
		if(list!=null) {
		list.forEach(user->{
			System.out.println("parent::"+user);
			Set<PhoneNumber> childs=user.getPhones();
			if(childs!=null) {
			childs.forEach(ph->{
				System.out.println("Child ::"+ph);
			});
			}  //if
		});
		}//if
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			//close SessionFactory
			HibernateUtil.closeSession(ses);
		}
	}//methd
	
	@Override
	public void deleteAParentAndItsChilds() {
		Session ses=null;
		Transaction tx=null;
		UserInfo user=null;
		boolean flag=false;
	    //get Session
		ses=HibernateUtil.getSession();
		//Load a parent object
		user=ses.get(UserInfo.class,2);
		try {
			//begin Tx
			tx=ses.beginTransaction();
			   ses.delete(user);
            flag=true;			   
		}
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Parent and Associated Childs are deleted");
			}
			else {
				tx.rollback();
				System.out.println("Parent and Associated Childs are not deleted");
			}
			//close SEssion
			HibernateUtil.closeSession(ses);
		}//finally
		
	}//main
	
	@Override
	public void deleteAChildFromCollectionOfChildsBeloginingToAParent() {
		Session ses=null;
	    UserInfo info=null;
	    Set<PhoneNumber> childs=null;
	    PhoneNumber ph=null;
	    Transaction tx=null;
	    boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//Load Parent object
		info=ses.get(UserInfo.class, 3);
		//get All childs of a Parent
		childs=info.getPhones();
		//Load a child obj from Db s/w
		ph=ses.get(PhoneNumber.class,99399999L);
		try {
			//begin Tx
			tx=ses.beginTransaction();
			  childs.remove(ph);
			flag=true;  
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("One child from Collection of Childs is deleted");
			}
			else {
				tx.rollback();
				System.out.println("One child from Collection of Childs is not deleted");
			}
		}//finally
		
	}//method
	
	@Override
	public void deleteAllChildsOfAParent() {
	   Session ses=null;
	   UserInfo user=null;
	   Set<PhoneNumber> childs=null;
	   Transaction tx=null;
	   boolean flag=false;
	   //get Session 
	   ses=HibernateUtil.getSession();
	   try {
		   //Load a Parent object
		   user=ses.get(UserInfo.class,4);
		   //get All childs of Parent
		   childs=user.getPhones();
		   //begin Tx
		   tx=ses.beginTransaction();
		    childs.removeAll(childs);
		   flag=true;
	   }
	   catch(HibernateException he) {
		   he.printStackTrace();
		   flag=false;
	   }
	   finally {
		   if(flag) {
			   tx.commit();
			   System.out.println("All Childs of a Parent are deleted");
		   }
		   else {
			   tx.rollback();
			   System.out.println("All Childs of a Parent are not deleted");
		   }
		   //close SEssion
		   HibernateUtil.closeSession(ses);
	   }
		
	}//method
	
	@Override
	public void addAChildToExistingChildsOfAParent() {
		Session ses=null;
		   UserInfo user=null;
		   Set<PhoneNumber> childs=null;
		   PhoneNumber ph1=null;
		   Transaction tx=null;
		   boolean flag=false;
		   //get Session 
		   ses=HibernateUtil.getSession();
		   try {
			   tx=ses.beginTransaction();
			   //Load a Parent object
			   user=ses.get(UserInfo.class,1);
			   //get All childs of Parent
			   childs=user.getPhones();
			   //create new child object
			   ph1=new PhoneNumber();
			   ph1.setPhoneNumber(65466654);
			   ph1.setNumberType("personal");
			   ph1.setProvider("jio");
			   //add new Child to existing collection of childs
			   childs.add(ph1);
			   flag=true;
		   }//try
		   catch(HibernateException he) {
			   he.printStackTrace();
			   flag=false;
		   }
		   finally {
			   if(flag) {
				   tx.commit();
				   System.out.println("New Child to Existing child is added");
			   }
			   else {
				   tx.rollback();
				   System.out.println("New Child to Existing child is not added");
			   }
			   //close session
			   HibernateUtil.closeSession(ses);
		   }//finally
	}//method
	
}//class
