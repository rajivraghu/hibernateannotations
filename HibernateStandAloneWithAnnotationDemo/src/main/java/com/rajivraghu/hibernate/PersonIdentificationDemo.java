package com.rajivraghu.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.rajivraghu.hibernate.model.Identification;
import com.rajivraghu.hibernate.model.Person;

public class PersonIdentificationDemo {

	
	public static void main(String[] args) {
	
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		openSession.beginTransaction();
		Person p = new Person();
		Identification id = new Identification();
		id.setIdentification("PAN");
		id.setNumber("P123");
		id.setPerson(p);
		
		Identification id1 = new Identification();
		id1.setIdentification("Aadhar");
		id1.setNumber("A345");
		id1.setPerson(p);
		List<Identification> ids= new ArrayList<Identification>();
		ids.add(id);
		ids.add(id1);
		
		p.setName("Rajiv");
		p.setIds(ids);
		//openSession.save(p);
		openSession.save(id);
		openSession.save(id1);
		openSession.getTransaction().commit();
		/** Fetching of childs from parent **/
		
		Person object = (Person) openSession.get(Person.class, p.getPersonId());
		System.out.println("Fetching of child from parent"+object.getIds().get(0).toString());
		System.out.println("Fetching of child from parent"+object.getIds().get(1).toString());
		
		Identification ident = (Identification) openSession.get(Identification.class, id.getId());
		System.out.println("Fetching of parent from child"+ident.getPerson().toString());
		
	}
	
	
	
}
