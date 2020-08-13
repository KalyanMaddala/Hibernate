package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.JobDetails;
import com.nt.entity.PersonalInfo;
import com.nt.utility.HibernateUtil;

public class ComponentMappingSaveObjectTest {

	public static void main(String[] args) {
		Session ses=null;
		PersonalInfo info=null;
		JobDetails details=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare objects
		details=new JobDetails();
		details.setDeptno(103);
		details.setCompany("HCL");
		details.setDesg("MANAGER");
		details.setSalary(90000);
		info=new PersonalInfo();
		info.setPname("naresh");
		info.setAddrs("hyd");
		info.setDetails(details);
		try {
			//begin Tx
			tx=ses.beginTransaction();
			  ses.save(info);
			 flag=true;
		}
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Object is saved");
			}
			else {
				tx.rollback();
				System.out.println("Object is not saved");
			}
		}//finally
		//close objs
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();
	}//main
}//class
