package com.nt.factory;

import com.nt.dao.OneToOneFkDAO;
import com.nt.dao.OneToOneFkDAOImpl;

public class OneToOneFKDAOFactory {
	
	public   static   OneToOneFkDAO getInstance() {
		return new  OneToOneFkDAOImpl();
	}

}
