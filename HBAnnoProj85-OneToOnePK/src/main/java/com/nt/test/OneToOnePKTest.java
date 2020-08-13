package com.nt.test;

import com.nt.dao.OneToOneDAO;
import com.nt.factory.OneToOneDAOFactory;
import com.nt.utility.HibernateUtil;

public class OneToOnePKTest {

	public static void main(String[] args) {
		OneToOneDAO dao=null;
		//get DAO
		dao=OneToOneDAOFactory.getInstance();
		//invoke method
		dao.saveData();
		//close SesionFactory
		HibernateUtil.closeSessionFactory();
	}
}
