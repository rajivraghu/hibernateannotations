package com.rajivraghu.hibernate.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="CollegeStudent")
public class CollegeStudent {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ID_SEQ")
	@SequenceGenerator(name="ID_SEQ", schema="ID_SEQ")
	@Column(name="STUDENT_ID")
	private Integer studentId;
	
	@Column(name="STUDENT_NAME")
	private String Name;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="STUDENT_SUB" ,joinColumns=@JoinColumn(name="STUDENT_ID") ,inverseJoinColumns=@JoinColumn(name="SUBJECT_ID"))
	List<Subject> subjects = new ArrayList<Subject>();

	
	
	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
	
	
	

}
