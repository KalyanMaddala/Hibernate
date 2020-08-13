package com.nt.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.entity.PaySlip;
import com.nt.utility.HibernateUtil;

public class OneToOneDAOImpl implements OneToOneDAO {

	@Override
	public void saveData() {
		Session ses=null;
		Employee emp1=null;
		PaySlip slip1=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare objects
		emp1=new Employee();
		emp1.setEmpName("rajesh"); emp1.setEmpAddrs("hyd");
		emp1.setDeptNo(8901); 
		slip1=new PaySlip();
		slip1.setCompany("HCL"); slip1.setSalary(90000);
		slip1.setDeductions(5678);
		emp1.setPaymentDetials(slip1);
		slip1.setEmpDetails(emp1);
		try {
			tx=ses.beginTransaction();
			  ses.save(emp1);
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
		}

	}//main
}//class
