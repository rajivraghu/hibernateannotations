package com.rajivraghu.hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="IDENTIFICATIONS")
public class Identification {

	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="ID_SEQ")
	@SequenceGenerator(name="ID_SEQ",sequenceName="ID_SEQ")
	@Column(name="ID")
	private Integer id;
	@Column(name="IDENTIFICATION")
	private String identification;
	@Column(name="ID_NUMBER")
	private String number;
	
	@ManyToOne
	@JoinColumn(name="P_ID")
	Person person;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	@Override
	public String toString() {
		return "Identification [id=" + id + ", identification=" + identification + ", number=" + number + "]";
	}

	
	
	
}
