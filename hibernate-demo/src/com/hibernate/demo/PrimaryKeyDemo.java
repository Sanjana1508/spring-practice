package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
		System.out.println("Creating 3 Student objects");
		Student tempStudent1 = new Student("John","Doe","john@yahoo.com");
		Student tempStudent2 = new Student("Mary","Public","mary@yahoo.com");
		Student tempStudent3 = new Student("Bonita","Applebum","bonita@yahoo.com");
		session.beginTransaction();
		System.out.println("Saving the student objects");
		session.save(tempStudent1);
		session.save(tempStudent2);
		session.save(tempStudent3);
		session.getTransaction().commit();
		System.out.println("Done");
		}
		finally {
		factory.close();
		}
	}

}
