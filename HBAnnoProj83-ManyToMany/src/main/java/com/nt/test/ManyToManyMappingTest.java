package com.nt.test;

import com.nt.dao.ManyToManyDAO;
import com.nt.factory.ManyToManyDAOFactory;
import com.nt.utility.HibernateUtil;

public class ManyToManyMappingTest {

	public static void main(String[] args) {
		ManyToManyDAO dao=null;
		//get DAO
		dao=ManyToManyDAOFactory.getInstance();
		//invoke method
		dao.saveData();
		
		HibernateUtil.closeSessionFactory();

	}

}
