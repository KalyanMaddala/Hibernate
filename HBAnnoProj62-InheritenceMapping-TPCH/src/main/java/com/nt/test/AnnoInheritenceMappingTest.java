package com.nt.test;

import com.nt.dao.PaymentDAO;
import com.nt.factory.PaymentDAOFactory;
import com.nt.utility.HibernateUtil;

public class AnnoInheritenceMappingTest {

	public static void main(String[] args) {
		PaymentDAO dao=null;
		//get dAO
		dao=PaymentDAOFactory.getInstance();
		//invoke methods
		//dao.saveData();
		dao.loadData();
		
		//close Session Factoru
		HibernateUtil.closeSessionFactory();
	}//main
}//class
