package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {

			session.beginTransaction();
		
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
			
			System.out.println("\n\nStudents with last name Doe");
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where s.lastName = 'Doe' or s.firstName = 'Daffy'").getResultList();
			
			System.out.println("\n\nStudents with last name Doe or first name Daffy");
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where s.email"
					+ " like '%yahoo.com'").getResultList();
			
			System.out.println("\n\nStudents whose email ends with yahoo.com");
			displayStudents(theStudents);
			
			session.getTransaction().commit();
			System.out.println("Done");
		}
		finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
