/*
 *   Created by IntelliJ IDEA Ultimate, 2020
 *   User: Abhishek
 *   Date: 21-05-2020
 *   Time: 01:43 PM
 */


package com.hibernate.oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cnf.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetails.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        Instructor instructor = new Instructor("Abhishek", "Vaish", "abhishekv5055@gmail.com");
        InstructorDetails instructorDetails = new InstructorDetails("@abhishekVaish", "Designing");

        instructor.setInstructorId(instructorDetails);

        session.save(instructor);
        session.getTransaction().commit();

        sessionFactory.close();
    }
}
