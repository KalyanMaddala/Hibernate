package com.nt.test;

import com.nt.dao.ManyToOneDAO;
import com.nt.factory.ManyToOneDAOFactory;
import com.nt.utility.HibernateUtil;

public class ManyToOneTest {

	public static void main(String[] args) {
		ManyToOneDAO dao=null;
		// get DAO
		dao=ManyToOneDAOFactory.getInstance();
		//invoke method
		 //dao.saveDataUsingChilds();
		//dao.loadDataUsingChilds();
		//dao.deleteAllChildsWithItsParent();
		//dao.deleteAllChildsWithOutDeletingTheirParent();
		//dao.deleteOneChildOfAParent();
		//dao.addNewChildToExistingParent();
		//dao.moveExistingChildToNewParent();
		dao.moveExistingChildToExistingParent();
		
		//close Session factory
		HibernateUtil.closeSessionFactory();

	}

}
