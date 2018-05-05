package com.rajivraghu.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.rajivraghu.hibernate.model.FourWheeler;
import com.rajivraghu.hibernate.model.TwoWheeler;
import com.rajivraghu.hibernate.model.Vehicle;

public class VehicleDemo {

	
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session currentSession = sessionFactory.openSession();
		currentSession.beginTransaction();
		
		Vehicle v = new Vehicle();
		v.setVehicleName("New vehicle");
		
		TwoWheeler two = new  TwoWheeler();
		two.setVehicleName("Unicorn 160cc");
		two.setTwoWheelSteering("twooo");
		
		FourWheeler four = new FourWheeler();
		four.setVehicleName("Creta");
		four.setForWheelSteering("fourrrr");
		
		currentSession.save(v);
		currentSession.save(two);
		currentSession.save(four);
		
		currentSession.getTransaction().commit();
		currentSession.close();
	}
}
