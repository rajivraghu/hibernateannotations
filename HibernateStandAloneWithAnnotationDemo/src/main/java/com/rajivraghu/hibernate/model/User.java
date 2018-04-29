package com.rajivraghu.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="FINANCE_USER")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator="ID_SEQ")
	@SequenceGenerator(name = "ID_SEQ" ,sequenceName="ID_SEQ" )
	@Column(name="USER_ID")
	private Integer userId;
	
	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="PHONE")
	private String phone;

	@OneToOne(mappedBy="user")
	private Credential cred;
	
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Credential getCred() {
		return cred;
	}

	public void setCred(Credential cred) {
		this.cred = cred;
	}
	
	
	

}
