package ru.polinabevad.bugtracker.services.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import ru.polinabevad.bugtracker.core.Message;
import ru.polinabevad.bugtracker.core.People;
import ru.polinabevad.bugtracker.core.Task;

import javax.persistence.Entity;
import javax.tools.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class HibernateMain {

    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration()
                    .addAnnotatedClass(Task.class)
                    .addAnnotatedClass(People.class)
                    .addAnnotatedClass(Message.class);
            configuration.configure();

            System.out.println("hibernate.connection.username = " + configuration.getProperties().getProperty("hibernate.connection.username"));
            System.out.println("hibernate.connection.password = " + configuration.getProperties().getProperty("hibernate.connection.password"));
            System.out.println("hibernate.c3p0.min_size = " + configuration.getProperties().getProperty("hibernate.c3p0.min_size"));
            System.out.println("hibernate.c3p0.max_size = " + configuration.getProperties().getProperty("hibernate.c3p0.max_size"));
            System.out.println("hibernate.hbm2ddl.auto = " + configuration.getProperties().getProperty("hibernate.hbm2ddl.auto"));
            System.out.println("hibernate.c3p0.timeout = " + configuration.getProperties().getProperty("hibernate.c3p0.timeout"));
            System.out.println("hibernate.c3p0.max_statements = " + configuration.getProperties().getProperty("hibernate.c3p0.max_statements"));

            return configuration.buildSessionFactory(
                    new StandardServiceRegistryBuilder()
                            .applySettings(configuration.getProperties())
                            .build());
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}