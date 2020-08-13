package com.nt.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Project implements Serializable{
     private int projId;
     private Set<Programmer> programmers=new  HashSet();
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
	public Set<Programmer> getProgrammers() {
		return programmers;
	}
	public void setProgrammers(Set<Programmer> programmers) {
		this.programmers = programmers;
	}
	
    @Override
	public String toString() {
		return "Project [projId=" + projId + ", projName=" + projName + ", teamSize="
				+ teamSize + "]";
	}
	
   
}
