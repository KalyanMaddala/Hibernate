package com.nt.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.PhoneNumber;
import com.nt.entity.UserInfo;
import com.nt.utility.HibernateUtil;

public class OneToManyDAOImpl implements OneToManyDAO {

	@Override
	public void saveData() {
		Session ses = null;
		UserInfo user = null;
		PhoneNumber ph1 = null, ph2 = null;
		Map<String, PhoneNumber> childs = null;
		Transaction tx = null;
		boolean flag = false;
		// get Session
		ses = HibernateUtil.getSession();
		// prepare objects
		// parent object
		user = new UserInfo();
		user.setName("rajesh");
		user.setAddrs("hyd");
		// child objects
		ph1 = new PhoneNumber();
		ph1.setPhoneNumber(993199999L);
		ph1.setNumberType("office");
		ph1.setProvider("airtel");

		ph2 = new PhoneNumber();
		ph2.setPhoneNumber(881148888L);
		ph2.setNumberType("residence");
		ph2.setProvider("idea");
		// add Child objects to Collection
		childs = new HashMap();
		childs.put("hydPhone", ph1);
		childs.put("blorePhone", ph2);
		// set Childs Collection to parent
		user.setPhones(childs);
		try {
			tx = ses.beginTransaction();
			ses.save(user);
			flag = true;
		} // try
		catch (HibernateException he) {
			flag = false;
			he.printStackTrace();
		} finally {
			if (flag) {
				tx.commit();
				System.out.println("parent and child objects are saved");
			} else {
				tx.rollback();
				System.out.println("Parent and child objects are not saved");
			}
			// close Session
			HibernateUtil.closeSession(ses);
		} // finally
	}// method

	@Override
	public void deleteOneChildFromCollectionOfChildsBeloggingToAParent() {
		Session ses=null;
		UserInfo user=null;
		Map<String,PhoneNumber> childs=null;
		Transaction tx=null;
		boolean flag=false;
		//get SEssion
		ses=HibernateUtil.getSession();
		//Load Parent object
		user=ses.get(UserInfo.class,1);
		//get All Childs 
		childs=user.getPhones();
		try {
			//begin Tx
			tx=ses.beginTransaction();
			  childs.remove("blorePhone");
			  flag=true;
		}//try
		catch(HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		catch(Exception e) {
			flag=false;
			e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("One PhoneNumber of User is deleted");
			}
			else {
				tx.rollback();
				System.out.println("One PhoneNumber of User is not deleted");
			}
		}
		//close SEssion
		HibernateUtil.closeSession(ses);
	}//method
		
	}// class
