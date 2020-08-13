package com.nt.dao;

public class InheritenceMappingDAOFactory {
	
	public static InheritenceMappingDAO getInstance() {
		return  new InheritenceMappingDAOImpl();
	}

}
