package com.nt.test;

import com.nt.dao.InheritenceMappingDAO;
import com.nt.dao.InheritenceMappingDAOFactory;
import com.nt.utility.HibernateUtil;

public class InheritenceMappingTest {

	public static void main(String[] args) {
		InheritenceMappingDAO dao=null;
		//get DAO
		dao=InheritenceMappingDAOFactory.getInstance();
		//save objects
		//dao.saveData();
		dao.showData();
		
		//close Sessionfactory
		HibernateUtil.closeSessionFactory();
				

	}

}
