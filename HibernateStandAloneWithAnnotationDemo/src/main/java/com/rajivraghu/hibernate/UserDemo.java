package com.rajivraghu.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.rajivraghu.hibernate.model.Credential;
import com.rajivraghu.hibernate.model.User;

public class UserDemo {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session currentSession = sessionFactory.openSession();
		currentSession.beginTransaction();
		Credential cred = new Credential();
		cred.setPassword("pass2124");
		cred.setUserName("rrr");
		
		User usr = new User();
		usr.setUserName("Rajiv");
		usr.setPhone("9591");
		cred.setUser(usr);
		usr.setCred(cred);
		currentSession.save(cred);
		currentSession.getTransaction().commit();
		User dbUser = (User) currentSession.get(User.class, 215050);
		System.out.println(dbUser.getCred().getUserName());
		
	}

}
