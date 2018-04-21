package com.rajivraghu.hibernate;

import java.lang.reflect.Field;

import com.rajivraghu.hibernate.model.Student;

public class Sample {

	
	
	public static void main(String[] args) {
		System.out.println("hello");
		System.out.println("hello");
		Student DBStudent = new Student();
		DBStudent.setId(100);
		DBStudent.setFirstName("FN");
		DBStudent.setLastName("LN");
		DBStudent.setSection("ASec");
		DBStudent.updateBaseAudit("Rajiv");
		DBStudent.setAuditSubModule("RO");	
		DBStudent.setAuditAction("ACT");
		
		Student newStudent = new Student();
		newStudent.setFirstName("Raghu");
		newStudent.setLastName("Chandramarutha");
		newStudent.setId(22);
		swap(DBStudent,newStudent);
		System.out.println("done");
		
	}
	
	
	public static void swap(Student DBStudent, Student newStudent){
		
		try
		{
			
			Field[] instanceFields =DBStudent.getClass().getSuperclass().getDeclaredFields();
			for (Field inst : instanceFields){
				inst.setAccessible(true);
				Field dbField=newStudent.getClass().getSuperclass().getDeclaredField(inst.getName());//db field
				dbField.setAccessible(true);//make it modifiable
				dbField.set(newStudent, inst.get(DBStudent));
	            }
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

