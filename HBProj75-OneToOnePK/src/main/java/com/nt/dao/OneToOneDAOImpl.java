package com.nt.dao;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.LibraryMembership;
import com.nt.entity.Student;
import com.nt.utility.HibernateUtil;

public class OneToOneDAOImpl implements OneToOneDAO {

	@Override
	public void saveDataUsingParent() {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		Student st=null;
		LibraryMembership lib=null;
		//prepare objects
		st=new Student();
		st.setSname("rajesh"); st.setCourse("java");
		lib=new LibraryMembership();
		lib.setDoj(new Date()); lib.setType("GOLD");
		st.setLibraryDetails(lib);  lib.setStudentDetails(st);
		
		//get Session
		ses=HibernateUtil.getSession();
		try {
			//begin Tx
			tx=ses.beginTransaction();
			     ses.save(st);
			flag=true;
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("parent to child objs are saved");
			}
			else {
				System.out.println("Parent to child objs are not saved");
				tx.rollback();
			}
			//close objs
			HibernateUtil.closeSession(ses);
		}//finally

	}//method
}//class
