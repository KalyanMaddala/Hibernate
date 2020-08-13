package com.nt.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.College;
import com.nt.entity.Student;
import com.nt.utility.HibernateUtil;

public  class OneToManyBiDAOImpl implements OneToManyBiDAO {

	@Override
	public void saveDataUsingParents() {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		College clg=null;
		Student st1=null,st2=null;
		Set<Student> childs=null;
		//get Session
		ses=HibernateUtil.getSession();
		try {
			tx=ses.beginTransaction();
			   //prepare objects
			    clg=new College();
			    clg.setName("CBIET"); clg.setLocation("HYD");
			    st1=new Student();
			    st1.setSname("raj"); st1.setCourse("java");
			    st2=new Student();
			    st2.setSname("ravi"); st2.setCourse("oracle");
			    //assing parent to chids
			    st1.setCollege(clg);
			    st2.setCollege(clg);
			    //assign childs to parent
			    childs=new HashSet();
			    childs.add(st1); childs.add(st2);
			    clg.setStudents(childs);
			   
			     ses.save(clg);  //parent to child
			    
			flag=true;
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Parent to Child objects are saved");
			}
			else {
				tx.rollback();
				System.out.println("Parent to Child Objects are not saved");
			}
			//close SEssion
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
	@Override
	public void saveDataUsingChilds() {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		College clg=null;
		Student st1=null,st2=null;
		Set<Student> childs=null;
		//get Session
		ses=HibernateUtil.getSession();
		try {
			tx=ses.beginTransaction();
			   //prepare objects
			    clg=new College();
			    clg.setName("JBIET"); clg.setLocation("HYD");
			    st1=new Student();
			    st1.setSname("ramesh"); st1.setCourse("java");
			    st2=new Student();
			    st2.setSname("jani"); st2.setCourse("oracle");
			    //assing parent to chids
			    st1.setCollege(clg);
			    st2.setCollege(clg);
			    //assign childs to parent
			    childs=new HashSet();
			    childs.add(st1); childs.add(st2);
			    clg.setStudents(childs);
			   
			     ses.save(st1);
			     ses.save(st2);
			    
			flag=true;
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println(" Child  to Parent  objects are saved");
			}
			else {
				tx.rollback();
				System.out.println(" Child to Parent Objects are not saved");
			}
			//close SEssion
			HibernateUtil.closeSession(ses);
		}//finally
		
	}//method
	
	public void loadDataUsingParents() {
		List<College> list=null;
		Query query=null;
		Session ses=null;
		//get Session
		ses=HibernateUtil.getSession();
		try {
		//prepare and execute HQL
		query=ses.createQuery("from College");
		list=query.getResultList();
		list.forEach(clg->{
			System.out.println("parent::"+clg);
			Set<Student> childs=clg.getStudents();
			childs.forEach(st->{
				System.out.println("child::"+st);
			});
			
		});
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession(ses);
		}
	}//method

	@Override
	public void loadDataUsingParentHavingJoins() {
		Session ses=null;
		Query query=null;
		List<Object[]> list=null;
		//get Session
		ses=HibernateUtil.getSession();
		try {
		//prepare and execute HQL Query with joins
		query=ses.createQuery("select clg.cid,clg.name,st.sid,st.sname from College clg full join clg.students  st");
			list=query.getResultList();
			list.forEach(row->{
				for(Object val:row) {
					System.out.print(val+"  ");
				}
				System.out.println();
			});
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			//close Session
			HibernateUtil.closeSession(ses);
		}
		
	}//method

	@Override
	public void loadDataUsingChildHavingJoins() {
		Session ses=null;
		Query query=null;
		List<Object[]> list=null;
		//get Session
		ses=HibernateUtil.getSession();
		try {
		//prepare and execute HQL Query with joins
		query=ses.createQuery("select clg.cid,clg.name,st.sid,st.sname from Student st full join st.college  clg");
			list=query.getResultList();
			list.forEach(row->{
				for(Object val:row) {
					System.out.print(val+"  ");
				}
				System.out.println();
			});
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			//close Session
			HibernateUtil.closeSession(ses);
		}
	}//method
	
	@Override
	public void loadDataUsingParentsWithFetchJoins() {
		List<College> list=null;
		Query query=null;
		Session ses=null;
		//get Session
		ses=HibernateUtil.getSession();
		try {
		//prepare and execute HQL
		query=ses.createQuery("select clg from College clg inner join fetch clg.students st");
		list=query.getResultList();
		list.forEach(clg->{
			System.out.println("parent::"+clg);
			Set<Student> childs=clg.getStudents();
			childs.forEach(st->{
				System.out.println("child::"+st);
			});
			
		});
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession(ses);
		}
	}//method
	
	@Override
	public void loadDataUsingParentHavingQBC() {
		List<College> list=null;
		Query query=null;
		Session ses=null;
		Criteria criteria=null;
	
		//get Session
		ses=HibernateUtil.getSession();
		try {
			//prepare and use QBC
			criteria=ses.createCriteria(College.class);
			criteria.setFetchMode("students",FetchMode.JOIN);
			list=criteria.list();
			list.forEach(clg->{
				System.out.println("parent::"+clg);
				Set<Student> childs=clg.getStudents();
				childs.forEach(st->{
					System.out.println("Child::"+st);
				});
			});
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
          HibernateUtil.closeSession(ses);			
		}
	}//method
	
	@Override
	public void loadDataUsingParentHavingSCalarJoins() {
		Session ses=null;
		Query query=null;
		List<Object[]> list=null;
		//get Session
		ses=HibernateUtil.getSession();
		try {
		//prepare and execute HQL Query with joins
		query=ses.createQuery("select clg.cid,clg.name,clg.location,st.sid,st.sname,st.course from College clg inner join clg.students  st");
			list=query.getResultList();
			list.forEach(row->{
				for(Object val:row) {
					System.out.print(val+"  ");
				}
				System.out.println();
			});
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			//close Session
			HibernateUtil.closeSession(ses);
		}
		
	}
	
}//class
