package ru.polinabevad.bugtracker.services.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import ru.polinabevad.bugtracker.core.People;
import ru.polinabevad.bugtracker.core.Task;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.ArrayList;

public class HibernateTaskTest extends Assert {
    @Test
    public void test1() {
        SessionFactory sessionFactory = HibernateMain.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.close();
    }

    // Создаем задачи и проверяем как заносятся в базу. Стандартным конструктором заполняются поля:
    //Taskname, taskId, taskCreateDate
    @Test
    public void test2() {
        TaskService service = new TaskService();
        //MessageService servicemess = new MessageService();
        PeopleService service1 = new PeopleService();

        People user1 = new People("TestUser1");
        People user2 = new People("TestUser2");

        Task task1 = new Task("Первая задача", user1, user2);
        Task task2 = new Task("Вторая задача", user1, user2);
        Task task3 = new Task("Третья задача", user2, user1);
        Task task4 = new Task("Четвертая задача", user2, user1);

        task2.setTaskStatus(Task.StatusType.WORK);
        task3.setTaskStatus(Task.StatusType.CLOSE);
        task4.setTaskStatus(Task.StatusType.CHECK);
        //task1.createMessage("Текст сообщения");

        System.out.println("Добавляем задачи в базу");

        service.persist(task1);
        service.persist(task2);
        service.persist(task3);
        service.persist(task4);

        ArrayList<Task> tasks1 = service.findAll();
        ArrayList<People> people1 = service1.findAll();
    }

}
