package com.nt.factory;

import com.nt.dao.OneToManyBiDAO;
import com.nt.dao.OneToManyBiDAOImpl;

public class OneToManyBiDAOFactory {
	
	public static OneToManyBiDAO   getInstance() {
		return new OneToManyBiDAOImpl();
	}

}
