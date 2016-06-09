package ru.polinabevad.bugtracker.taskboard;

import org.junit.Assert;
import org.junit.Test;
import ru.polinabevad.bugtracker.core.People;
import ru.polinabevad.bugtracker.core.Status;
import ru.polinabevad.bugtracker.core.Task;

import java.util.Calendar;

/**
 *
 */
public class FilterTest extends Assert {
    @Test
    public void test1() {
        People userAuthor = new People();
        People userAppointer = new People();
        TaskList.tasks.createTask("Первая задача");
        TaskList.tasks.createTask("Вторая задача");
        TaskList.tasks.createTask("Третья задача");
        TaskList.tasks.createTask("А это тоже почти третья задача");

        Task task1 = TaskList.tasks.get(0);
        task1.setTaskAuthor(userAuthor);
        task1.setTaskStatus(Status.StatusType.CLOSE);
        task1.setTaskAppointer(userAppointer);


        Task task2 = TaskList.tasks.get(1);
        task2.setTaskAppointer(userAppointer);
        task2.setTaskStatus(Status.StatusType.WORK);

        Task task3 = TaskList.tasks.get(2);
        task3.setTaskAuthor(userAuthor);
        task3.setTaskStatus(Status.StatusType.WORK);

        Task task4 = TaskList.tasks.get(3);
        Calendar task4createDate = Calendar.getInstance();
        task4createDate.set(2016, 04, 05);
        task4.setCreateDate(task4createDate);

        System.out.println("Поиск задач по текущему автору:");
        Filter taskfindbyAuthor = new Filter();
        taskfindbyAuthor.getTasksByAuthor(userAuthor).forEach(System.out::println);

        System.out.println("Поиск задач по текущему исполнителю:");
        Filter taskfindbyAppointer = new Filter();
        taskfindbyAppointer.getTasksByAppointer(userAppointer).forEach(System.out::println);

        System.out.println("Поиск задач по статусу открыт:");
        Filter taskfindbyStatus = new Filter();
        taskfindbyStatus.getTasksByStatus(Status.StatusType.OPEN).forEach(System.out::println);
        System.out.println("Поиск задач по статусу закрыт:");
        taskfindbyStatus.getTasksByStatus(Status.StatusType.CLOSE).forEach(System.out::println);
        System.out.println("Поиск задач по статусу в работе:");
        taskfindbyStatus.getTasksByStatus(Status.StatusType.WORK).forEach(System.out::println);

        System.out.println("Поиск задач по названию, без учета регистра:");
        Filter taskfindbyName = new Filter();
        taskfindbyName.getTasksByName("Третья").forEach(System.out::println);

        System.out.println("Поиск задач по дате:");
        Filter taskfindbyCreateDate = new Filter();
        Calendar from = Calendar.getInstance();
        from.set(2016, 05, 05);
        Calendar to = Calendar.getInstance();
        to.set(2016, 05, 18);
        taskfindbyCreateDate.getTasksByCreateDate(from, to).forEach(System.out::println);
    }
}
