package org.example.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Util {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration()
                    .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect")
                    .setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
                    .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/new_schema?useSSL=false")
                    .setProperty("hibernate.connection.username", "root")
                    .setProperty("hibernate.connection.password", "1234")
                    .setProperty("hibernate.hbm2ddl.auto", "update")
                    .setProperty("hibernate.show_sql", "true")
                    .addAnnotatedClass(org.example.model.User.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
