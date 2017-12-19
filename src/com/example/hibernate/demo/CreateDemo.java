package com.example.hibernate.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
        
        // create session factory
        SessionFactory factory = new Configuration()
        		.configure("hibernate.cfg.xml")
        		.addAnnotatedClass(Instructor.class)
        		.addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
 
        // create a session
        Session session = factory.getCurrentSession();
 
        try {
            // create the objects
            Instructor tempInstructor = new Instructor("Fouchimi", "Ousmane", "ousmanefouchimi@gmail.com");
            
            InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.love2code.com/youtube", "love 2 code !");
            
            // associate the objects
            
            tempInstructor.setInstructorDetail(tempInstructorDetail);
            
            // start a transaction
            session.beginTransaction();
            
            // save the instructor
            // Note: this will ALSO save the details of object
            // because of CascadeType.ALL
            //
            
            System.out.println("Saving instructor: " + tempInstructor);
            session.save(tempInstructor);
            
            // commit transaction
            session.getTransaction().commit();
            
            System.out.println("Done!");
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
        	session.close();
            factory.close();
        }
    }
}
