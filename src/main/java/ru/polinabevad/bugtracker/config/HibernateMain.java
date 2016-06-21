package ru.polinabevad.bugtracker.config;

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