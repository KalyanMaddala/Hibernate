package com.nt.dao;

public interface OneToManyBiDAO {
	public void saveDataUsingParents();
	public void saveDataUsingChilds();
	public  void loadDataUsingParents();
	public  void loadDataUsingParentHavingJoins();
	public  void loadDataUsingChildHavingJoins();
	public  void loadDataUsingParentsWithFetchJoins();
	public  void loadDataUsingParentHavingQBC();
	public void  loadDataUsingParentHavingSCalarJoins();

}
