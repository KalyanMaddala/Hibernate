package com.nt.factory;

import com.nt.dao.PaymentDAO;
import com.nt.dao.PaymentDAOImpl;

public class PaymentDAOFactory {
	
	public static  PaymentDAO  getInstance() {
		return new   PaymentDAOImpl();
	}

}
