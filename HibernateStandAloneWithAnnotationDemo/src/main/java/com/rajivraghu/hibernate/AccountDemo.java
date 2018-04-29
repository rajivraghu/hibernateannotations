package com.rajivraghu.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.rajivraghu.hibernate.model.Account;
import com.rajivraghu.hibernate.model.Loan;
import com.rajivraghu.hibernate.model.Transaction;

public class AccountDemo {
	
	
	
	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session currentSession = sessionFactory.openSession();
		currentSession.beginTransaction();
		
		Account acc = new Account();
		acc.setAccountNumber("994545");
		acc.setAccountType("Savings");
		
		Transaction trans1 = new Transaction();
		trans1.setTransactionType("Online shopping");
		trans1.setTransactionDescription("oneplus 6");
		
		Transaction trans2 = new Transaction();
		trans2.setTransactionType("Online shopping");
		trans2.setTransactionDescription("iphone X");
		
		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions.add(trans1);
		transactions.add(trans2);
		
		Loan loan = new Loan();
		loan.setLoanAmount(100000);
		loan.setLoanType("Personal loan");
		
		
		Loan loan1 = new Loan();
		loan1.setLoanAmount(200000);
		loan1.setLoanType("Personal loan");
		
		List<Loan> loans = new ArrayList<Loan>();
		loans.add(loan);
		loans.add(loan1);
		
		acc.setLoans(loans);
		
		acc.setTransactions(transactions);
		currentSession.save(acc);
		currentSession.getTransaction().commit();
		
		
		
	}

}
