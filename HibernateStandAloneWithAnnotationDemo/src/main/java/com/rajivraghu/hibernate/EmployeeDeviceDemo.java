package com.rajivraghu.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.rajivraghu.hibernate.model.Device;
import com.rajivraghu.hibernate.model.Employee;

public class EmployeeDeviceDemo {
	
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session currentSession = sessionFactory.openSession();
		currentSession.beginTransaction();
		/*** Employee - Device Uni directional ; ManyToOne Mapping ; here we save the child device first. Parent gets automatically saved */
		Employee emp =new Employee();
		emp.setEmployeeName("Rajiv");
		Device d1 = new Device();
		d1.setDeviceType("MOBILE");
		d1.setEmployee(emp);
		Device d2 = new Device();
		d2.setDeviceType("Laptop");
		d2.setEmployee(emp);
		d1.setEmployee(emp);
		currentSession.save(d1);
		currentSession.save(d2);
		currentSession.getTransaction().commit();
		
	}

}
