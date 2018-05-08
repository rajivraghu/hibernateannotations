package com.rajivraghu.hibernate;

import org.hibernate.Query;
import org.hibernate.Session;

import com.rajivraghu.hibernate.model.Bank;

public class NamedQueryDemo {
	
	
	public static void main(String[] args) {
		
		Session s=	HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		Query namedQuery = s.getNamedQuery("byId");
		namedQuery.setInteger("bankId", 160050);
		Bank bank = (Bank) namedQuery.uniqueResult();
		System.out.println(bank.getBankName());
		s.getTransaction().commit();
		s.close();
		
	}

}
