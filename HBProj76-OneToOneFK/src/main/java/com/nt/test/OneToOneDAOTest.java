package com.nt.test;

import com.nt.dao.OneToOneFkDAO;
import com.nt.factory.OneToOneFKDAOFactory;
import com.nt.utility.HibernateUtil;

public class OneToOneDAOTest {

	public static void main(String[] args) {
		OneToOneFkDAO dao=null;
		//get DAO
		dao=OneToOneFKDAOFactory.getInstance();
		//invoke methods
		//dao.saveDataUsingChild();
		dao.loadDataUsingChild();
		
		//close SessionFactory
		HibernateUtil.closeSessionFactory();
		

	}//main
}//class
