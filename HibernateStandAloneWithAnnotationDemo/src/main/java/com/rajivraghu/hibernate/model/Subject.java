package com.rajivraghu.hibernate.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="SUBJECT")
public class Subject {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ID_SEQ")
	@SequenceGenerator(name="ID_SEQ", schema="ID_SEQ")
	@Column(name="SUBJECT_ID")
	private Integer subjectId;
	
	@Column(name="SUBJECT_NAME")
	private String subjectName;
	
    @ManyToMany(cascade=CascadeType.ALL, mappedBy="subjects")
	private List<CollegeStudent> students = new ArrayList<CollegeStudent>();


	public String getSubjectName() {
		return subjectName;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public List<CollegeStudent> getStudents() {
		return students;
	}

	public void setStudents(List<CollegeStudent> students) {
		this.students = students;
	}
    
    
    
}
