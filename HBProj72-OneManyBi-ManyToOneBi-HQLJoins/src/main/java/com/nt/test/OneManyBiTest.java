package com.nt.test;

import org.hibernate.HibernateException;

import com.nt.dao.OneToManyBiDAO;
import com.nt.factory.OneToManyBiDAOFactory;
import com.nt.utility.HibernateUtil;

public class OneManyBiTest {

	public static void main(String[] args) {
		OneToManyBiDAO dao=null;
		//get DAO
		dao=OneToManyBiDAOFactory.getInstance();
		try {
			//dao.saveDataUsingParents();
			//dao.saveDataUsingChilds();
			//dao.loadDataUsingParents();
			//dao.loadDataUsingParentHavingJoins();
			//dao.loadDataUsingChildHavingJoins();
			//dao.loadDataUsingParentsWithFetchJoins();
			dao.loadDataUsingParentHavingQBC();
			//dao.loadDataUsingParentHavingSCalarJoins();
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		//close SessionFactory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
