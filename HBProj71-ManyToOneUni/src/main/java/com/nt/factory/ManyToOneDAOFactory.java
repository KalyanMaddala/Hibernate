package com.nt.factory;

import com.nt.dao.ManyToOneDAO;
import com.nt.dao.ManyToOneDAOImpl;

public class ManyToOneDAOFactory {
	
	public  static  ManyToOneDAO  getInstance() {
		return  new ManyToOneDAOImpl();
	}

}
