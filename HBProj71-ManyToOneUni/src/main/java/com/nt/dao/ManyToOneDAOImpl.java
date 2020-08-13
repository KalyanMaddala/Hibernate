package com.nt.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Department;
import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class ManyToOneDAOImpl implements ManyToOneDAO {

	@Override
	public void saveDataUsingChilds() {
		Session ses=null;
		Department dept=null;
		Employee emp1=null,emp2=null;
		Transaction tx=null;
		boolean flag=false;
		//get SEssion
		ses=HibernateUtil.getSession();
		//prepare Objects
		emp1=new Employee();
		emp1.setEname("ram"); emp1.setDesg("CLERK");
		emp1.setSalary(8000);
		
		emp2=new Employee();
		emp2.setEname("raj"); emp2.setDesg("MANAGER");
		emp2.setSalary(18000);
		
		dept=new Department();
		dept.setDname("IT"); dept.setLocation("HYD");
		//assign parent to childs
		emp1.setDept(dept); emp2.setDept(dept);
		
		try {
			//begin Tx
			tx=ses.beginTransaction();  
			  ses.save(emp1);
			  ses.save(emp2);
			 flag=true;
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Child to parent objects are saved");
			}
			else {
				tx.rollback();
				System.out.println("Child to Parent objects are not saved");
			}
			HibernateUtil.closeSession(ses);
		}//finally
	}//method

	@Override
	public void loadDataUsingChilds() {
		Session ses=null;
		Query query=null;
		List<Employee> list=null;
		//get Session 
		ses=HibernateUtil.getSession();
		try {
			query=ses.createQuery("from Employee");
			list=query.getResultList();
			list.forEach(emp->{
				System.out.println("Child ::"+emp);
				Department dept=emp.getDept();
				System.out.println("Parent ::"+dept);
			});
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			//close sesion
			HibernateUtil.closeSession(ses);
		}
		
	}//method

	@Override
	public void deleteAllChildsWithItsParent() {
	    Session ses=null;
	    Query query=null;
	    List<Employee> list=null;
	    Transaction tx=null;
	    boolean flag=false;
	    //get Session
	    ses=HibernateUtil.getSession();
	  
	    try {
	    	//begin Tx
	    	tx=ses.beginTransaction();
	    	//get All childs of a parent
	    	query=ses.createQuery("from Employee where dno=:deptNo");
	    	query.setParameter("deptNo", 100);
	    	list=query.list();
	    	 for(Employee emp:list) {
	    		 ses.delete(emp);
	    	 }
	    	   flag=true;
	    }//try
	    catch(HibernateException he) {
	    	he.printStackTrace();
	    	flag=false;
	    }
	    finally {
	    	if(flag) {
	    		tx.commit();
	    		System.out.println("All Childs of a Parent with Parent is deleted");
	    	}
	    	else {
	    		tx.rollback();
	    		System.out.println("All Childs of a Parent with  Parent not deleted");
	    	}
	    	
	    	//close Session
	    	HibernateUtil.closeSession(ses);
	    }//finally
	}//method
	
	@Override
	public void deleteAllChildsWithOutDeletingTheirParent() {
		/*  executing this  logic with cascade="none" completes the 
		 *   task but not recomanded becoz changing cascade="none" in the
		 *   middle of the App's execution is bad pratice
		  Session ses=null;
		   Query query=null;
		   List<Employee> list=null;
		   Transaction tx=null;
		   boolean flag=false;
		   //get Session
		   ses=HibernateUtil.getSession();
		   try {
		   	//begin Tx
		   	tx=ses.beginTransaction();
		   	//get All childs of a parent
		   	query=ses.createQuery("from Employee where dno=:deptNo");
		   	query.setParameter("deptNo", 1);
		   	list=query.list();
		   	 for(Employee emp:list) {
		   		 ses.delete(emp);
		   	 }
		   	   flag=true;
		   }//try
		   catch(HibernateException he) {
		   	he.printStackTrace();
		   	flag=false;
		   }
		   finally {
		   	if(flag) {
		   		tx.commit();
		   		System.out.println("All Childs of a Parent with Parent is deleted");
		   	}
		   	else {
		   		tx.rollback();
		   		System.out.println("All Childs of a Parent with  Parent not deleted");
		   	}
		   	
		   	//close Session
		   	HibernateUtil.closeSession(ses);
		   }//finally
		*/		
		 Session ses=null;
		 Transaction tx=null;
		 boolean flag=false;
		 Query query=null;
		 int count=0;
		 //get Session 
		 ses=HibernateUtil.getSession();
		try {
			//begin tx
			tx=ses.beginTransaction();
		 //execute HQL Delete Query
		 query=ses.createQuery("delete from Employee where dno=:deptNo");
		  query.setParameter("deptNo",101);
		  count=query.executeUpdate();
		flag=true;
		 }//try
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println(count+" no.of Only childs of A Parent are deleted");
			}
			else {
				tx.rollback();
				System.out.println("Only childs of A Parent are not deleted");
			}
			//close Session
			HibernateUtil.closeSession(ses);
		}
	}//method
	
	@Override
	public void deleteOneChildOfAParent() {
		 Session ses=null;
		 Transaction tx=null;
		 boolean flag=false;
		 Query query=null;
		 int count=0;
		 //get Session 
		 ses=HibernateUtil.getSession();
		try {
			//begin tx
			tx=ses.beginTransaction();
		 //execute HQL Delete Query
		 query=ses.createQuery("delete from Employee where empNo=:eno");
		 query.setParameter("eno",1);
		 count=query.executeUpdate();
		 flag=true;
	}//try
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Specific child of a Parent is deleted");
			}
			else {
				tx.rollback();
				System.out.println("Specific child of a Parent is not deleted");
			}
			//close Session
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
	@Override
	public void addNewChildToExistingParent() {
		 Session ses=null;
		 Transaction tx=null;
		 boolean flag=false;
		 Query query=null;
		 Department dept=null;
		 Employee emp=null;
		 //get Session 
		 ses=HibernateUtil.getSession();
		try {
			//begin tx
			tx=ses.beginTransaction();
			  //load Existing parent
			dept=ses.get(Department.class,102);
			//create new child object
			emp=new Employee();
			emp.setEname("jani"); emp.setDesg("MANAGER");
			emp.setSalary(90000); 
			//assign parent to child
			emp.setDept(dept);
			//save child
			ses.save(emp);
			flag=true;
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("One New child is added to Exiting Parent");
			}
			else {
				tx.rollback();
				System.out.println("One New child is not added to Exiting Parent");
			}
			
			//close Session
			HibernateUtil.closeSession(ses);
		}
		
	}//method
	
	@Override
	public void moveExistingChildToNewParent() {
		 Session ses=null;
		 Transaction tx=null;
		 boolean flag=false;
		 Department dept=null;
		 Employee emp=null;
		 //get Session 
		 ses=HibernateUtil.getSession();
		 try {
			 //begin Tx
			 tx=ses.beginTransaction();
			 //load Existing child
			 emp=ses.get(Employee.class, 2);
			 //create new Parent
			 dept=new Department();
			 dept.setDname("Accounts"); dept.setLocation("hyd");
			 //assing new parent to child
			 emp.setDept(dept);
			   ses.save(emp);
			 flag=true;
		   }//try
		 catch(HibernateException he) {
			 he.printStackTrace();
			 flag=false;
		 }
		 finally {
			 if(flag) {
				 tx.commit();
				 System.out.println("Existing Child is moved to new Parent");
			 }
			 else {
				 tx.rollback();
				 System.out.println("Existing Child is not moved to new Parent");
			 }
			 //close Session
			 HibernateUtil.closeSession(ses);
		 }//finally
		
	}//method
	
	@Override
	public void moveExistingChildToExistingParent() {
		 Session ses=null;
		 Transaction tx=null;
		 boolean flag=false;
		 Department dept=null;
		 Employee emp=null;
		 //get Session 
		 ses=HibernateUtil.getSession();
		 try {
			 //begin Tx
			 tx=ses.beginTransaction();
			 //load Existing child
			 emp=ses.get(Employee.class, 3);
			 //load existing parent
			 dept=ses.get(Department.class, 103);
			 //assing new parent to child
			 emp.setDept(dept);
			   ses.update(emp);
			 flag=true;
		   }//try
		 catch(HibernateException he) {
			 he.printStackTrace();
			 flag=false;
		 }
		 finally {
			 if(flag) {
				 tx.commit();
				 System.out.println("Existing Child is moved to existing Parent");
			 }
			 else {
				 tx.rollback();
				 System.out.println("Existing Child is not moved to existing Parent");
			 }
			 //close Session
			 HibernateUtil.closeSession(ses);
		 }//finally
		
		
	}
	
}//class
