package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;
import com.hibernate.demo.entity.Student;

public class AddCoursesForMaryDemo {

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
			
			int theId = 1;
			Student tempStudent = session.get(Student.class, theId);
			
			System.out.println("Student : "+tempStudent);
			System.out.println("Courses : "+tempStudent.getCourses());
			
			/*Course tempCourse1= new Course("Rubik's cude");
			Course tempCourse2= new Course("Atari 2600");
			
			tempCourse1.addStudents(tempStudent);
			tempCourse2.addStudents(tempStudent);
			
			System.out.println("Saving the courses");
			session.save(tempCourse1);
			session.save(tempCourse2);*/
			
			session.getTransaction().commit();
			System.out.println("Done");
			
		}
		finally {
			session.close();
			factory.close();
		}
	}
}
