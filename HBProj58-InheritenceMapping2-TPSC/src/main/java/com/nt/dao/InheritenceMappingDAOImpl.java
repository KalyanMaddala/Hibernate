package com.nt.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Customer;
import com.nt.entity.Employee;
import com.nt.entity.Person;
import com.nt.utility.HibernateUtil;

public class InheritenceMappingDAOImpl implements InheritenceMappingDAO {

	@Override
	public void saveData() {
		Session ses=null;
		Person per=null;
		Employee emp=null;
		Customer cust=null;
		Transaction tx=null;
		boolean flag=false;
	//get Session
		ses=HibernateUtil.getSession();
		try {
			//begin Tx
			tx=ses.beginTransaction();
			  per=new Person();
			  per.setPname("rajesh");
			  per.setCompany("HCL");
			  
			  emp=new Employee();
			  emp.setPname("jani");
			  emp.setCompany("Wipro");
			  emp.setDesg("MANAGER");
			  emp.setSalary(8000);
			  
			  cust=new Customer();
			  cust.setPname("karan");
			  cust.setCompany("InfoSys");
			  cust.setAddrs("hyd");
			  cust.setBillAmt(9000);
			  
			  //save objs
			  ses.save(per); ses.save(emp); ses.save(cust);
			
			flag=true;
			
		}
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		finally{	
			if(flag) {
				tx.commit();
				System.out.println("Objects  saved");
			}
			else {
				tx.rollback();
				System.out.println("Objects  not saved");
			}
			
			//close session
			HibernateUtil.closeSession(ses);
		}

	}

	@Override
	public void showData() {
		Session ses=null;
		Query query1=null,query2=null,query3=null;
		List<Person> list1=null;
		List<Employee> list2=null;
		List<Customer> list3=null;
		try {
			//get Session
			ses=HibernateUtil.getSession();
			//prepare query
			query1=ses.createQuery("from Person");
			list1=query1.getResultList();
			list1.forEach(per->{
				System.out.println(per);
			});
			System.out.println(".............................");
			query2=ses.createQuery("from Employee");
			list2=query2.getResultList();
			list2.forEach(emp->{
				System.out.println(emp);
			});
			System.out.println("........................");
			query3=ses.createQuery("from Customer");
			list3=query3.getResultList();
			list3.forEach(cust->{
				System.out.println(cust);
			});
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close Session
			HibernateUtil.closeSession(ses);
		}
		
	}//method
}//class
