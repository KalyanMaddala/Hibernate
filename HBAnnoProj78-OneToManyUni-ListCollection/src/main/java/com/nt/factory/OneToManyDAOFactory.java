package com.nt.factory;

import com.nt.dao.OneToManyDAO;
import com.nt.dao.OneToManyDAOImpl;

public class OneToManyDAOFactory {
     public  static  OneToManyDAO getInstance() {
    	 return  new OneToManyDAOImpl();
     }
}
