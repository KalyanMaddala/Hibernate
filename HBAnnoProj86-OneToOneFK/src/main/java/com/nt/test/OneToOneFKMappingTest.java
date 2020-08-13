package com.nt.test;

import com.nt.dao.OneToOneDAO;
import com.nt.factory.OneToOneDAOFactory;
import com.nt.utility.HibernateUtil;

public class OneToOneFKMappingTest {

	public static void main(String[] args) {
		OneToOneDAO dao=null;
	      //get DAO
		dao=OneToOneDAOFactory.getInstance();
		//invoke methods
		//dao.saveDataUsingParent();
		dao.saveDataUsingChild();
		
		//close sessionfactroy
		HibernateUtil.closeSessionFactory();
	}

}
