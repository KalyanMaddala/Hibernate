package com.nt.factory;

import com.nt.dao.OneToOneDAO;
import com.nt.dao.OneToOneDAOImpl;

public class OneToOneDAOFactory {
	public  static  OneToOneDAO  getInstance() {
		return new OneToOneDAOImpl();
	}

}
