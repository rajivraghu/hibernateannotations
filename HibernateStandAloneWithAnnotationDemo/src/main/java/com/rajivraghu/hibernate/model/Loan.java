package com.rajivraghu.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="LOAN")
public class Loan {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ID_SEQ")
	@SequenceGenerator(name="ID_SEQ", sequenceName="ID_SEQ")
	@Column(name="LOAN_ID")
	private Integer loanId;
	@Column(name="LOAN_TYPE")
	private String loanType;
	@Column(name="LOAN_AMOUNT")
	private Integer loanAmount;
	
	@ManyToOne
	@JoinColumn(name="ACCOUNT_ID")
	Account account ;
	
	
	public Integer getLoanId() {
		return loanId;
	}
	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public Integer getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(Integer loanAmount) {
		this.loanAmount = loanAmount;
	}
	
	
	
	
	
	
}
