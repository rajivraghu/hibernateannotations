package com.rajivraghu.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.rajivraghu.hibernate.model.CollegeStudent;
import com.rajivraghu.hibernate.model.Subject;

public class CollegeStudentSubjectDemo {
	
	public static void main(String[] args) {
		/** Many to many ; bidirectional **/
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session currentSession = sessionFactory.openSession();
		currentSession.beginTransaction();
		CollegeStudent stu = new CollegeStudent();
		stu.setName("Shankar shan");
		
		CollegeStudent stu1 = new CollegeStudent();
		stu1.setName("Sandeep mahesh");
		
		
		Subject sub = new Subject();
		sub.setSubjectName("Maths");
		
		 List<CollegeStudent> students = new ArrayList<CollegeStudent>();
		 students.add(stu);
		 students.add(stu1);
		 sub.setStudents(students);
		
		Subject sub1 = new Subject();
		sub1.setSubjectName("Physics");
		sub1.setStudents(students);
		
		List<Subject> subjects = new ArrayList<Subject>();
		subjects.add(sub);
		subjects.add(sub1);
		stu.setSubjects(subjects);
		stu1.setSubjects(subjects);
		
		currentSession.save(stu);
		currentSession.save(stu1);
		currentSession.getTransaction().commit();
		Subject object = (Subject) currentSession.get(Subject.class, sub.getSubjectId());
		List<CollegeStudent> studentList = object.getStudents();
		currentSession.close();
		
	}

}
