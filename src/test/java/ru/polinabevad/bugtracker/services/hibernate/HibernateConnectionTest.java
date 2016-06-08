package ru.polinabevad.bugtracker.services.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 */
public class HibernateConnectionTest extends Assert {
    @Test
    public void test1() {
        SessionFactory sessionFactory = HibernateMain.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.close();
    }

}
