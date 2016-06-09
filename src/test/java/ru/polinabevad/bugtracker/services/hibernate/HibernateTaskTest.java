package ru.polinabevad.bugtracker.services.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import ru.polinabevad.bugtracker.core.People;
import ru.polinabevad.bugtracker.core.Task;

import java.util.ArrayList;

public class HibernateTaskTest extends Assert {
    @Test
    public void test1() {
        SessionFactory sessionFactory = HibernateMain.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.close();
    }

    @Test
    public void test2() {
        TaskService service = new TaskService();
        Task task1 = new Task("Первая задача");
        Task task2 = new Task("Первая задача");
        Task task3 = new Task("Первая задача");
        //TODO: реализовать еще PeopleService и т.п.
        // People userAuthor = new People("TestAuthor");
        //People userAppointer = new People("TestAppointer");
        //task1.setTaskAuthor(userAuthor);
        //task1.setTaskAppointer(userAppointer);
        System.out.println("Добавляем задачи в базу");

        service.persist(task1);
        service.persist(task2);
        service.persist(task3);
        ArrayList<Task> tasks1 = service.findAll();

    }

    @Test
    public void test3() {


    }
}
