package com.nt.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Programmer;
import com.nt.entity.Project;
import com.nt.utility.HibernateUtil;

public class ManyToManyDAOImpl implements ManyToManyDAO {

	@Override
	public void saveDataUsingParents() {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		Programmer p1=null,p2=null,p3=null;
		Project proj1=null,proj2=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare objects
		p1=new Programmer();
		p1.setPname("jani"); p1.setSalary(90000);
		p2=new Programmer();
		p2.setPname("ravi"); p2.setSalary(80000);
		p3=new Programmer();
		p3.setPname("mahesh"); p3.setSalary(70000);
		
		proj1=new Project();
		proj1.setProjName("OpenFx"); proj1.setTeamSize(10);
		proj2=new Project();
		proj2.setProjName("CitiBank"); proj2.setTeamSize(16);
		//add Projects to Programmers
		p1.getProjects().add(proj1); p1.getProjects().add(proj2);
		p2.getProjects().add(proj1); p2.getProjects().add(proj2);
		p3.getProjects().add(proj2);
		//add Programmers to Projects
		proj1.getProgrammers().add(p1); proj1.getProgrammers().add(p2);
		proj2.getProgrammers().add(p1); proj2.getProgrammers().add(p2); proj2.getProgrammers().add(p3);
	
		try {
			tx=ses.beginTransaction();
			  ses.save(p1); ses.save(p2); ses.save(p3);
			flag=true;
		}
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("parent to child objects are saved");
			}
			else {
				tx.rollback();
				System.out.println("Parent to child objects are not saved");
			}
			//close Session
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
	@Override
	public void saveDataUsingChilds() {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		Programmer p1=null,p2=null,p3=null;
		Project proj1=null,proj2=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare objects
		p1=new Programmer();
		p1.setPname("jani"); p1.setSalary(90000);
		p2=new Programmer();
		p2.setPname("ravi"); p2.setSalary(80000);
		p3=new Programmer();
		p3.setPname("mahesh"); p3.setSalary(70000);
		
		proj1=new Project();
		proj1.setProjName("OpenFx"); proj1.setTeamSize(10);
		proj2=new Project();
		proj2.setProjName("CitiBank"); proj2.setTeamSize(16);
		//add Projects to Programmers
		p1.getProjects().add(proj1); p1.getProjects().add(proj2);
		p2.getProjects().add(proj1); p2.getProjects().add(proj2);
		p3.getProjects().add(proj2);
		//add Programmers to Projects
		proj1.getProgrammers().add(p1); proj1.getProgrammers().add(p2);
		proj2.getProgrammers().add(p1); proj2.getProgrammers().add(p2); proj2.getProgrammers().add(p3);
	
		try {
			tx=ses.beginTransaction();
			 ses.save(proj1); ses.save(proj2);
			flag=true;
		}
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("child to parent objects are saved");
			}
			else {
				tx.rollback();
				System.out.println("child to parent objects are not saved");
			}
			//close Session
			HibernateUtil.closeSession(ses);
		}//finally
		
	}//method
	
	@Override
	public void loadDataUsingParents() {
		Session ses=null;
		Query query=null;
		List<Programmer> list=null;
		//get Session
		ses=HibernateUtil.getSession();
		
		try {
			//prepare Query
		query=ses.createQuery("from Programmer");
		list=query.getResultList();
		list.forEach(prgmr->{
			System.out.println("Parent::"+prgmr);
			Set<Project> childs=prgmr.getProjects();
			childs.forEach(proj->{
				System.out.println("Child::"+proj);
			});
		});
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			//close session
			HibernateUtil.closeSession(ses);
		}
	}//method
	
	@Override
	public void transferParentFromExistingChildToNewChild() {
		Session ses=null;
		Transaction tx=null;
		Programmer p1=null;
		Set<Project> childs=null;
		Project oldProj=null,anotherProj=null;
		boolean flag=true;
		// Get Session
		ses=HibernateUtil.getSession();
		try {
			//begin tx
			tx=ses.beginTransaction();
			//Load Old project
			oldProj=ses.get(Project.class,84);
			
		//Load Parent
		p1=ses.get(Programmer.class,3);
		//Load Another  Child object
		anotherProj=ses.get(Project.class,83);
		oldProj.getProgrammers().remove(p1);
		anotherProj.getProgrammers().add(p1);
		ses.update(anotherProj);
			flag=true;
		}
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Programmer is transfered to another Project");
			}
			else {
				tx.rollback();
				System.out.println("Programmer is not transfered to another Project");
			}
			HibernateUtil.closeSession(ses);
		}
	}//method
	
}//class
