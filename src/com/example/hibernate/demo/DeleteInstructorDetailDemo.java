package com.example.hibernate.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

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
          
            // start a transaction
            session.beginTransaction();
            
            // get instructor detail object
            int theId = 5;
            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
            
            // print the instructor detail
            System.out.println("tempInstructorDetail: " + tempInstructorDetail);
            
            // print the associated instructor
        	System.out.println("The associated instructor: " + tempInstructorDetail.getInstructor());
        	
        	//remove the associated object reference
        	// break bi-directional link
        	
        	tempInstructorDetail.getInstructor().setInstructorDetail(null);
        	
        	// Now let's delete the instructor detail
        	System.out.println("Deleting tempInstructorDetail: " + tempInstructorDetail);
        	session.delete(tempInstructorDetail);
            
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
