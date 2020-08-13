package com.nt.dao;

public interface ManyToManyDAO {
   public void saveDataUsingParents();
   public void saveDataUsingChilds();
   public void  loadDataUsingParents();
   public void transferParentFromExistingChildToNewChild();
}
