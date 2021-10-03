package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;
import com.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Course tempCourse = new Course("Pacman1 - How to score one million points");
			
			System.out.println("Saving the course : "+tempCourse);
			session.save(tempCourse);
			System.out.println("Saved the course : "+tempCourse);
			
			Student tempStudent1 = new Student("John1","Doe1","john@gmail.com");
			Student tempStudent2 = new Student("Mary1","Public1","mary@gmail.com");
			
			tempCourse.addStudents(tempStudent1);
			tempCourse.addStudents(tempStudent2);
			
			System.out.println("\nSaving the students");
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("Saved the students : "+tempCourse.getStudents());
			
			session.getTransaction().commit();
			System.out.println("Done");
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
