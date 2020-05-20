/*
 *   Created by IntelliJ IDEA Ultimate, 2020
 *   User: Abhishek
 *   Date: 19-05-2020
 *   Time: 10:06 AM
 */


package com.hibernate.create;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Scanner;

public class CreateApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ConfigurationClass configurationClass = new ConfigurationClass();
        SessionFactory sessionFactory = configurationClass
                .configurationMethod("hibernate.cnf.xml",
                        Student.class);

        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = null;
        System.out.print("First Name: ");
        String firstName = scanner.next();
        System.out.print("Last Name: ");
        String lastName = scanner.next();
        System.out.print("Email: ");
        String email = scanner.next();

        try {
            Student student = new Student(firstName, lastName, email);
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            throw e;
        } finally {
            sessionFactory.close();
        }
    }
}
