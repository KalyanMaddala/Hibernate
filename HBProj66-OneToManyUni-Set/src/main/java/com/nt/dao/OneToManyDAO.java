package com.nt.dao;

public interface OneToManyDAO {
	
	public  void  saveData();
	public  void loadData();
	public void deleteAParentAndItsChilds();
	public void  deleteAChildFromCollectionOfChildsBeloginingToAParent();
	public void deleteAllChildsOfAParent();
	public void  addAChildToExistingChildsOfAParent();

}
