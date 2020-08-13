package com.nt.dao;

public interface OneToManyDAO {
	public void saveDataUsingParent();
	public  void loadDataUsingParent();
	public  void loadDataUsingParentWithQBC();
	public void deleteOneChildFromCollectionOfChildsBelongingToAParent();

}
