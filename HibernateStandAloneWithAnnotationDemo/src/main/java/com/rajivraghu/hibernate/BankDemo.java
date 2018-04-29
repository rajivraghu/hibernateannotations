package com.rajivraghu.hibernate;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.hibernate.Session;

import com.rajivraghu.hibernate.model.Address;
import com.rajivraghu.hibernate.model.Bank;
import com.rajivraghu.hibernate.model.HelpInfo;

public class BankDemo {
	
	public static void main(String[] args) {
		/** start **/
		BankDemo application = new BankDemo();
		Bank bank = new Bank();
		Address add = new Address();
		bank.setBankName("Icici");
		bank.setBankManager("Raj");
		add.setLine1("line1");
		add.setLine2("line2");
		add.setLine3("line3");
		bank.setAddress(add);
		bank.setInternational(true);
		bank.setCreatedDate(new Date());
		List<String> contacts = new ArrayList<String>();
		contacts.add("Joe");
		contacts.add("Raghu");
		Map<String, String> bankEmployees = new HashMap<String, String>();
		bankEmployees.put("Shankar", "Director");
		bankEmployees.put("Rajiv", "Manager");
		bankEmployees.put("Raghu", "Assistant Manager");
		List<HelpInfo> helpInfos = new ArrayList<HelpInfo>();
		
		HelpInfo helpInfo = helpInfo();
		HelpInfo helpInfo1 = helpInfo1();
		helpInfos.add(helpInfo1);
		helpInfos.add(helpInfo);
		
		bank.setHelpInfos(helpInfos);
		bank.setBankEmployees(bankEmployees);
		bank.setContacts(contacts);
		application.saveBank(bank);
		/** hello **/
		/*  Locale locale = new Locale("fr");
          NumberFormat numberFormat = NumberFormat.getInstance(locale);
          String formattedValue = numberFormat.format(1000000);
          System.out.println(formattedValue);*/
	}




	private static HelpInfo helpInfo1() {
		HelpInfo helpinfo1 = new HelpInfo();
		helpinfo1.setPhoneNumber("456");
		helpinfo1.setFaxNumber("F-456");
		helpinfo1.setEmailId("xyz@help");
		return helpinfo1;
	}

	private static HelpInfo helpInfo() {
		HelpInfo helpinfo = new HelpInfo();
		helpinfo.setPhoneNumber("123");
		helpinfo.setFaxNumber("F-123");
		helpinfo.setEmailId("abc@help");
		return helpinfo;
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
