package com.nt.test;

import com.nt.dao.OneToManyDAO;
import com.nt.factory.OneToManyDAOFactory;
import com.nt.utility.HibernateUtil;

public class OneToManyUniTest {
   public static void main(String[] args) {
	   OneToManyDAO dao;
	   //get DAO
	   dao=OneToManyDAOFactory.getInstance();
	   //use DAO 
	   dao.saveData();
	   //dao.deleteOneChildFromCollectionOfChildsBeloggingToAParent();
	   
	   //close SessionFactory
	   HibernateUtil.closeSessionFactory();
	
}
}
