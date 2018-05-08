package com.rajivraghu.hibernate.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

@Entity
@NamedQueries({ @NamedQuery(name="byId", query="from Bank where bankId = :bankId") })
@Table(name = "BANK")
public class Bank {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	
	Integer bankId;
	@Column(name="BANK_NAME")
	String bankName;
	@Column(name="BANK_MANAGER")
	String bankManager;

	
	@Column(name="IS_INTERNATIONAL")
	@Type(type="yes_no")
	private boolean  isInternational;
	
	@Column(name="CREATED_DATE")
	private Date createdDate;
	
	@Embedded
	Address address = new Address();
	
	@ElementCollection
	@CollectionTable(name="BANK_CONTACT",joinColumns=@JoinColumn(name="BANK_ID"))
	@Column(name="CONTACT_NAME")
	private List<String> contacts;
	
	@ElementCollection
	@CollectionTable(name="BANK_EMPLOYEES",joinColumns=@JoinColumn(name="BANK_ID"))
	@Column(name="EMPLOYEE_NAME")
	@MapKeyColumn(name="EMPLOYEE_DESIGNATION")
	private Map<String,String> bankEmployees;
	
	
	@Embedded
	@ElementCollection
	@CollectionTable(name="BANK_HELP_INFO",joinColumns=@JoinColumn(name="BANK_ID"))
	private List<HelpInfo> helpInfos;
	
	@Transient
	private boolean valid;
	
	
	
	public Integer getBankId() {
		return bankId;
	}
	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankManager() {
		return bankManager;
	}
	public void setBankManager(String bankManager) {
		this.bankManager = bankManager;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public boolean isInternational() {
		return isInternational;
	}
	public void setInternational(boolean isInternational) {
		this.isInternational = isInternational;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public List<String> getContacts() {
		return contacts;
	}
	public void setContacts(List<String> contacts) {
		this.contacts = contacts;
	}
	public Map<String, String> getBankEmployees() {
		return bankEmployees;
	}
	public void setBankEmployees(Map<String, String> bankEmployees) {
		this.bankEmployees = bankEmployees;
	}
	public List<HelpInfo> getHelpInfos() {
		return helpInfos;
	}
	public void setHelpInfos(List<HelpInfo> helpInfos) {
		this.helpInfos = helpInfos;
	}
	
	

}
