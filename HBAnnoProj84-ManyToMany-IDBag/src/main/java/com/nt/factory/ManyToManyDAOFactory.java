package com.nt.factory;

import com.nt.dao.ManyToManyDAO;
import com.nt.dao.ManyToManyDAOImpl;

public class ManyToManyDAOFactory {
	
	public  static ManyToManyDAO  getInstance() {
		return new ManyToManyDAOImpl();
	}

}
