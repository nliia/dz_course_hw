package ru.itis.kpfu.controllers;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Liia on 01.11.2016.
 */
public class Util {
    private static final SessionFactory sessionFactory;
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
/*            sessionFactory = new AnnotationConfiguration().configure(new File("hibernate.cfg.xml"))
                    .buildSessionFactory();*/
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
