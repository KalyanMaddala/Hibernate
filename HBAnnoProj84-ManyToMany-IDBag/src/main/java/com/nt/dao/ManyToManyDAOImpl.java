package com.nt.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Doctor;
import com.nt.entity.Patient;
import com.nt.utility.HibernateUtil;

public class ManyToManyDAOImpl implements ManyToManyDAO {

	@Override
	public void saveData() {
		Session ses=null;
		Doctor doc1=null,doc2=null;
		Patient pat1=null,pat2=null,pat3=null;
		Transaction tx=null;
		boolean flag=false;
		// get Session
		ses=HibernateUtil.getSession();
		//prepare objects
		pat1=new Patient();
		pat1.setPatName("ramesh"); pat1.setProblem("heart");
		pat2=new Patient();
		pat2.setPatName("suresh"); pat2.setProblem("knee");
		pat3=new Patient();
		pat3.setPatName("lokesh"); pat3.setProblem("kidney");
		doc1=new Doctor();
		doc1.setDocName("baba"); doc1.setDepartment("Phyisician");
		doc2=new Doctor();
		doc2.setDocName("dhanvatanri"); doc2.setDepartment("all rounder");
		//add patients to Doctors
		doc1.getPatients().add(pat1); doc1.getPatients().add(pat2);doc1.getPatients().add(pat3);
		doc2.getPatients().add(pat1); doc2.getPatients().add(pat3);
		//add Doctors to Patients
		pat1.getDoctors().add(doc1); pat1.getDoctors().add(doc2);
		pat2.getDoctors().add(doc1);
		pat3.getDoctors().add(doc1); pat3.getDoctors().add(doc2);
		try {
			//begin Tx
			tx=ses.beginTransaction();
			   ses.save(pat1); ses.save(pat2); ses.save(pat3);
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
		}//method
	}//class

}
