package com.rajivraghu.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TRANSACTION")
public class Transaction {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ID_SEQ")
	@SequenceGenerator(name="ID_SEQ",sequenceName="ID_SEQ")
	@Column(name="TRANSCATION_ID")
	private Integer transactionId;
	@Column(name="TRANSCATION_TYPE")
	private String transactionType;
	@Column(name="TRANSCATION_DESC")
	private String transactionDescription;
	
	@Column(name="ACCOUNT_ID")
	private Integer accountId;
	
	public Integer getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getTransactionDescription() {
		return transactionDescription;
	}
	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}
	
	
	
	
	
}
