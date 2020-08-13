package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Employee;

public class SaveObjectTest {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Employee emp=null;
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;
		//Activate Hibernate F/w (or) boot strap hibernate
		cfg=new Configuration();
		//Locate and read hibernate cfg file
		cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		System.out.println(cfg.getProperties());
		//cfg.configure();
		//build SessionFactory
		factory=cfg.buildSessionFactory();
		try {
			Thread.sleep(20000);
			System.out.println("1");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		// create Session
		ses=factory.openSession();
		//create Entity class object
		emp=new Employee();
		 emp.setEname("raja9");
		 emp.setEadd("hyd");emp.setEsalary(9000.0f);
		 emp.setAge(23);
		//save Object
		try {
			//begin Tx
			tx=ses.beginTransaction();   //calls  con.setAutoCommit(false) to begin Tx
			    idVal=(Integer) ses.save(emp);
			    System.out.println("Generated id value::"+idVal);
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
			//perform Tx mgmt
			if(flag) {
				tx.commit(); //commits Tx by calling con.commit()
				System.out.println("Object is saved (Record in inserted) ");
				try {
					Thread.sleep(10000);
					System.out.println("2");
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
			else {
				tx.rollback(); //rollbacks Tx by calling con.rollback() 
				System.out.println("Object is not saved (Record not inserted)");
			}
			//close objs
			ses.close();   //close the connection with Db s/w
			factory.close(); // releases all services that are hold by factory   and deactivates  HB f/w
		}//finally  */

	}//main
}//class
