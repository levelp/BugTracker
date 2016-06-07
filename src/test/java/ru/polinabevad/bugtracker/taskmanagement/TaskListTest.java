package ru.polinabevad.bugtracker.taskmanagement;

import org.junit.Assert;
import org.junit.Test;

import ru.polinabevad.bugtracker.profile.User;
import ru.polinabevad.bugtracker.profile.UserType;
import ru.polinabevad.bugtracker.taskboard.TaskList;

/**
 *
 */
public class TaskListTest extends Assert{
    @Test
    public void test1() {
        TaskList.tasks.createTask("Первая задача");
        TaskList.tasks.createTask("Вторая задача");
        TaskList.tasks.createTask("Третья задача");
        Task task3 = (Task)TaskList.tasks.get(2);
        assertEquals("Номер задачи должен быть три", 3, task3.getTaskNumber());

        //проверяем что с таким же названием как предыдущая запишется с новым номером
        TaskList.tasks.createTask("Третья задача");
        Task task4 = (Task)TaskList.tasks.get(3);
        assertEquals("Номер задачи должен быть четыре", 4, task4.getTaskNumber());
        TaskList.tasks.getTasksList();

        //Проверка поиска по имени и номеру
        System.out.println("===============");
        Task taskfindbyNumber = TaskList.tasks.getTaskByNumber(2);

        System.out.println("Задача найдена по номеру:2 " + taskfindbyNumber);
        Task taskfindbyName = TaskList.tasks.getTaskByName("Третья");
        System.out.println("Задача найдена по названию: Третья. " + taskfindbyName);
        System.out.println("===============");

        //Проверка удаленных В списке не должна выдаться задача под номером 2
        User testAdmin = new User();
        testAdmin.changeUserType("admin");
        assertEquals("Задача №2 удалена.", TaskList.tasks.getTaskByNumber(2).deleteTask(testAdmin));

        TaskList.tasks.getTasksList();
        System.out.println("===============");
        //Проверка удаления от неадмина
        User testUser = new User();
        assertEquals("У юзера нет прав на удаление", TaskList.tasks.getTaskByNumber(3).deleteTask(testUser));
        //задача 3 должна остаться на месте.
        TaskList.tasks.getTasksList();
    }

}
