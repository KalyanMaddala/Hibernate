package com.nt.test;

import com.nt.dao.ManyToOneDAO;
import com.nt.factory.ManyToOneDAOFactory;
import com.nt.utility.HibernateUtil;

public class ManyToOneMappingTest {

	public static void main(String[] args) {
		ManyToOneDAO dao=null;
		//get DAO
		dao=ManyToOneDAOFactory.getInstance();
		//invoke methods
		//dao.saveData();
		//dao.loadData();
		
		//close SessionFactory
		HibernateUtil.closeSessionFactory();

	}//main
}//class
