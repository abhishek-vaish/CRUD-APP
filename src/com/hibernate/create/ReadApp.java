/*
 *   Created by IntelliJ IDEA Ultimate, 2020
 *   User: Abhishek
 *   Date: 19-05-2020
 *   Time: 12:52 PM
 */


package com.hibernate.create;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ReadApp {
    public static void main(String[] args) {

        ConfigurationClass configurationClass = new ConfigurationClass();
        SessionFactory sessionFactory = configurationClass
                .configurationMethod("hibernate.cnf.xml",
                        Student.class);

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            Query query = session.createQuery("from Student");
            List list = query.list();
            System.out.println(list);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
