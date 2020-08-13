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
	   //dao.saveData();
	   dao.loadData();
	   //dao.deleteAParentAndItsChilds();
	   //dao.deleteAChildFromCollectionOfChildsBeloginingToAParent();
	  // dao.deleteAllChildsOfAParent();
	  // dao.addAChildToExistingChildsOfAParent();
	   //close SessionFactory
	   HibernateUtil.closeSessionFactory();
	
}
}
