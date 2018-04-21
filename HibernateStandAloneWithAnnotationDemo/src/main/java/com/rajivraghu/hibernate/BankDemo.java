package com.rajivraghu.hibernate;

import java.text.NumberFormat;
import java.util.Locale;

import org.hibernate.Session;

import com.rajivraghu.hibernate.model.Address;
import com.rajivraghu.hibernate.model.Bank;

public class BankDemo {
	
	public static void main(String[] args) {

		BankDemo application = new BankDemo();
		Bank bank = new Bank();
		Address add = new Address();
		bank.setBankName("HDFC");
		bank.setBankManager("Raj");
		add.setLine1("line1");
		add.setLine2("line2");
		add.setLine3("line3");
		bank.setAddress(add);
		application.saveBank(bank);
		
		/*  Locale locale = new Locale("fr");
          NumberFormat numberFormat = NumberFormat.getInstance(locale);
          String formattedValue = numberFormat.format(1000000);
          System.out.println(formattedValue);*/
	}
	
	
	
	
	public int saveBank(Bank bank){
		
	Session s=	HibernateUtil.getSessionFactory().openSession();
	s.beginTransaction();
	Integer id=(Integer) s.save(bank);
	s.getTransaction().commit();
	s.close();
	return id;	
	}

}
