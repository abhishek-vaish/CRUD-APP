/*
 *   Created by IntelliJ IDEA Ultimate, 2020
 *   User: Abhishek
 *   Date: 20-05-2020
 *   Time: 09:26 AM
 */


package com.hibernate.create;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ConfigurationClass {
    public SessionFactory configurationMethod(String configurationFile, Class classObject) {
        SessionFactory sessionFactory = new Configuration()
                .configure(configurationFile)
                .addAnnotatedClass(classObject)
                .buildSessionFactory();
        return sessionFactory;
    }
}
