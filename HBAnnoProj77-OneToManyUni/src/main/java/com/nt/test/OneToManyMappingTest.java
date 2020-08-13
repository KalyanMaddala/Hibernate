package com.nt.test;

import com.nt.dao.OneToManyDAO;
import com.nt.factory.OneToManyDAOFactory;
import com.nt.utility.HibernateUtil;

public class OneToManyMappingTest {

	public static void main(String[] args) {
		OneToManyDAO dao=null;
		//get DAO
		dao=OneToManyDAOFactory.getInstance();
		//invoke method
		//dao.saveDataUsingParent();
		//dao.loadDataUsingParent();
		//dao.loadDataUsingParentWithQBC();
		dao.deleteOneChildFromCollectionOfChildsBelongingToAParent();
		
		
		//close Sessionfactory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
