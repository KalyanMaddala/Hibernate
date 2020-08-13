package com.nt.dao;

public interface ManyToOneDAO {
    public void saveDataUsingChilds();
    public  void  loadDataUsingChilds();
    public  void deleteAllChildsWithItsParent();
    public  void deleteAllChildsWithOutDeletingTheirParent();
    public  void  deleteOneChildOfAParent();
    public   void  addNewChildToExistingParent();
    public   void  moveExistingChildToNewParent();
    public  void  moveExistingChildToExistingParent();
}
