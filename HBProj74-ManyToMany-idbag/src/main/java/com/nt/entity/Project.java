package com.nt.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Project implements Serializable{
     private int projId;
     private List<Programmer> programmers=new  ArrayList();
     private String projName;
     private  int teamSize;
     
	public int getProjId() {
		return projId;
	}
	public void setProjId(int projId) {
		this.projId = projId;
	}
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	public List<Programmer> getProgrammers() {
		return programmers;
	}
	public void setProgrammers(List<Programmer> programmers) {
		this.programmers = programmers;
	}
	
    @Override
	public String toString() {
		return "Project [projId=" + projId + ", projName=" + projName + ", teamSize="
				+ teamSize + "]";
	}
	
   
}
