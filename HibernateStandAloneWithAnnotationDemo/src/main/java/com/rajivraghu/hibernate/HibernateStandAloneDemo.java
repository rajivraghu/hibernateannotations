package com.rajivraghu.hibernate;

import java.lang.reflect.Field;
import java.util.List;

import org.hibernate.Session;

import com.rajivraghu.hibernate.model.Student;

/**
 * Class used to perform CRUD operation on database with Hibernate API's
 * 
 */
public class HibernateStandAloneDemo {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {

		HibernateStandAloneDemo application = new HibernateStandAloneDemo();

		/*
		 * Save few objects with hibernate
		 */
		int studentId1 = application.saveStudent("Shankarww", "shanmugh", "Social");
/*		int studentId2 = application.saveStudent("Joshua", "Brill", "Science");
		int studentId3 = application.saveStudent("Peter", "Pan", "Physics");
		int studentId4 = application.saveStudent("Bill", "Laurent", "Maths");

		
		 * Retrieve all saved objects
		 
		List<Student> students = application.getAllStudents();
		System.out.println("List of all persisted students >>>");
		for (Student student : students) {
			System.out.println("Persisted Student :" + student);
		}

		
		 * Update an object
		 
		application.updateStudent(studentId4, "ARTS");

		
		 * Deletes an object
		 
		application.deleteStudent(studentId2);

		
		 * Retrieve all saved objects
		 
		List<Student> remaingStudents = application.getAllStudents();
		System.out.println("List of all remained persisted students >>>");
		for (Student student : remaingStudents) {
			System.out.println("Persisted Student :" + student);
		}*/

	}

	/**
	 * This method saves a Student object in database
	 * @throws Exception 
	 */
	public int saveStudent(String firstName, String lastName, String section) throws Exception {
		Student student = new Student();
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setSection(section);
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(student);
	    /*Student dbStudent = (Student)session.get(Student.class, 100);
	    dbStudent.setFirstName("kko");*/
	   /* Student dbInvnewobj=new Student();
	    dbInvnewobj=(Student) ObjectCloner.deepCopy(dbStudent);
	    session.saveOrUpdate(dbInvnewobj);*/
		session.getTransaction().commit();
		session.close();
		/*
		
		System.out.println("student id"+student.getId());
		
		
		Session session2 = HibernateUtil.getSessionFactory().openSession();
		session2.beginTransaction();
		session2.delete(student);
		student.setFirstName("sss");
		session2.update(student);
		session2.getTransaction().commit();
		session2.close();
		*/
		
		//System.out.println(dbInvnewobj.toString());

		return 0;
		
		
		
		
	}

	/**
	 * This method returns list of all persisted Student objects/tuples from
	 * database
	 * @throws Exception 
	 */
	
	

	
	public Object swap(Object dbObj, Object instanceObj){
		
		try
		{
			
			Field[] instanceFields =instanceObj.getClass().getDeclaredFields();
			for (Field inst : instanceFields){
				inst.setAccessible(true);
				Field dbField=dbObj.getClass().getDeclaredField(inst.getName());//db field
				dbField.setAccessible(true);//make it modifiable
				//System.out.println(dbField.get(dbObj));
			    dbField.set(dbObj, inst.get(instanceObj));
	            }
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	return dbObj;
		}
	
	public List<Student> getAllStudents() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		@SuppressWarnings("unchecked")
		List<Student> employees = (List<Student>) session.createQuery(
				"FROM Student s ORDER BY s.firstName ASC").list();

		session.getTransaction().commit();
		session.close();
		return employees;
	}

	/**
	 * This method updates a specific Student object
	 */
	public void updateStudent(int id, String section) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Student student = (Student) session.get(Student.class, id);
		student.setSection(section);
		//session.update(student);//No need to update manually as it will be updated automatically on transaction close.
		session.getTransaction().commit();
		session.close();
	}

	/**
	 * This method deletes a specific Student object
	 */
	public void deleteStudent(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Student student = (Student) session.get(Student.class, id);
		session.delete(student);
		session.getTransaction().commit();
		session.close();
	}
}
