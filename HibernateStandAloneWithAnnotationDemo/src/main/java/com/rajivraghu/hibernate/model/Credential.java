package com.rajivraghu.hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="CREDENTIALS")
public class Credential {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ID_SEQ")
	@SequenceGenerator(name="ID_SEQ", sequenceName="ID_SEQ")
	@Column(name="CREDENTIAL_ID")
	private Integer credentialId;
	
	@Column(name="userName")
	private String userName;

	@Column(name="PASSWORD")
	private String password;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="USER_ID")
   private User user = new User();

	public Integer getCredentialId() {
		return credentialId;
	}

	public void setCredentialId(Integer credentialId) {
		this.credentialId = credentialId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
