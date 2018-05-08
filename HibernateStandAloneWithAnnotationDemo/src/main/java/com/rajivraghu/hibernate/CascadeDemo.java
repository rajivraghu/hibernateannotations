package com.rajivraghu.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.rajivraghu.hibernate.model.House;
import com.rajivraghu.hibernate.model.Room;

public class CascadeDemo {

	
	
	public static void main(String[] args) {
		
		
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session currentSession = sessionFactory.openSession();
		currentSession.beginTransaction();
		
		House home = new House();
		home.setHouseName("Siri");
		
		Room room = new Room();
		room.setRoomName("Bed");
		
		
		List<Room>  roomList= new ArrayList<Room>(); 
		roomList.add(room);
		
		currentSession.save(home);
		
		currentSession.getTransaction().commit();
		currentSession.close();
		
	}
}
