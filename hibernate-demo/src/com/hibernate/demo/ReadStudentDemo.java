package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating new Student object");
			Student tempStudent = new Student("Daffy","Duck","daffy@yahoo.com");
			
			session.beginTransaction();
			
			System.out.println("Saving the student object");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			session.getTransaction().commit();
			
			System.out.println("saved Student.Generated Id = "+tempStudent.getId());
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Getting Student with id : "+tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("Get complete : "+myStudent);
			
			session.getTransaction().commit();
			System.out.println("Done");
		}
		finally {
			factory.close();
		}
	}

}
