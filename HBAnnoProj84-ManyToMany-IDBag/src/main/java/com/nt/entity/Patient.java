package com.nt.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="PATIENTS1")
public class Patient implements Serializable{
	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "PATID_SEQ",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	@Column(length = 10)
	@Type(type="int")
	private int patId;
	@Column(length = 10)
	@Type(type="string")
	private String patName;
	@Column(length = 10)
	@Type(type="string")
	private String problem; 
	@ManyToMany(targetEntity = Doctor.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@GenericGenerator(name = "gen2",strategy = "increment")
	@JoinTable(name = "DOCTORS_PATIENTS1",
    joinColumns = @JoinColumn(columnDefinition = "patient_id",referencedColumnName = "patId"),
     inverseJoinColumns = @JoinColumn(columnDefinition = "doctor_id",referencedColumnName = "docId")
   )
	@CollectionId(columns = @Column(name = "doc_pat_id",length = 5,nullable = true),
    type = @Type(type="int"),
   generator = "gen2")
	private List<Doctor> doctors=new ArrayList();
	
	public int getPatId() {
		return patId;
	}
	public void setPatId(int patId) {
		this.patId = patId;
	}
	public String getPatName() {
		return patName;
	}
	public void setPatName(String patName) {
		this.patName = patName;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public List<Doctor> getDoctors() {
		return doctors;
	}
	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}
	
	@Override
	public String toString() {
		return "Patient [patId=" + patId + ", patName=" + patName + ", problem=" + problem + "]";
	}
	

}
