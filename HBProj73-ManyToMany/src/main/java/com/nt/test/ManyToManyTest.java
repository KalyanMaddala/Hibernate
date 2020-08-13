package com.nt.test;

import com.nt.dao.ManyToManyDAO;
import com.nt.factory.ManyToManyDAOFactory;
import com.nt.utility.HibernateUtil;

public class ManyToManyTest {

	public static void main(String[] args) {
		ManyToManyDAO dao=null;
	   //get DAO
		dao=ManyToManyDAOFactory.getInstance();
		//invoke method
		//dao.saveDataUsingParents();
		//dao.saveDataUsingChilds();
		//dao.loadDataUsingParents();
		dao.transferParentFromExistingChildToNewChild();
		//close Session factory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
