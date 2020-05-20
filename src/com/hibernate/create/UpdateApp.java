/*
 *   Created by IntelliJ IDEA Ultimate, 2020
 *   User: Abhishek
 *   Date: 20-05-2020
 *   Time: 09:24 AM
 */


package com.hibernate.create;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UpdateApp {
    public static void main(String[] args) {
        ConfigurationClass configurationClass = new ConfigurationClass();
        SessionFactory sessionFactory = configurationClass
                .configurationMethod("hibernate.cnf.xml",
                        Student.class);

        Session session = sessionFactory.getCurrentSession();

        int id = 1;

        session.beginTransaction();
        Student student = session.get(Student.class, id);
        student.setLastName("Gupta");
        session.update(student);
        session.getTransaction().commit();

    }
}
