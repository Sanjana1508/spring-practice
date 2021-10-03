package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			int theId=1;
			
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("demo: Instructor : "+tempInstructor);
			
			System.out.println("demo: Courses : "+tempInstructor.getCourses());
			
			
			session.getTransaction().commit();
			session.close();
			
			System.out.println("\nsession is closed\n");
			
			System.out.println("demo: Courses : "+tempInstructor.getCourses());
			
			System.out.println("demo: Done");
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
