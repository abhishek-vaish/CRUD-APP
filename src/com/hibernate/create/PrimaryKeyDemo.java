/*
 *   Created by IntelliJ IDEA Ultimate, 2020
 *   User: Abhishek
 *   Date: 19-05-2020
 *   Time: 01:17 PM
 */


package com.hibernate.create;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cnf.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = null;

        try {
            Student student1 = new Student("Abhishek", "Vaish", "abhishekv5055@gmail.com");
            Student student2 = new Student("Bilal", "Azhar", "bilal.azhar@gmail.com");
            Student student3 = new Student("Rohit", "Gupta", "rohit.gupta@gmail.com");
            transaction = session.beginTransaction();
            session.save(student1);
            session.save(student2);
            session.save(student3);
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            throw e;
        } finally {
            sessionFactory.close();
        }
    }
}
