/*
 *   Created by IntelliJ IDEA Ultimate, 2020
 *   User: Abhishek
 *   Date: 19-05-2020
 *   Time: 10:06 AM
 */


package com.hibernate.create;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class CreateApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ConfigurationClass configurationClass = new ConfigurationClass();
        SessionFactory sessionFactory = configurationClass
                .configurationMethod("hibernate.cnf.xml",
                        Student.class);

        Session session = sessionFactory.getCurrentSession();
        System.out.print("First Name: ");
        String firstName = scanner.next();
        System.out.print("Last Name: ");
        String lastName = scanner.next();
        System.out.print("Email: ");
        String email = scanner.next();

        try {
            Student student = new Student(firstName, lastName, email);
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
