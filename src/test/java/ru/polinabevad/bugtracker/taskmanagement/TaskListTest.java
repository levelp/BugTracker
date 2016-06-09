package ru.polinabevad.bugtracker.taskmanagement;

import org.junit.Assert;
import org.junit.Test;

import ru.polinabevad.bugtracker.core.Task;
import ru.polinabevad.bugtracker.core.People;
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
        Task task3 = TaskList.tasks.get(2);
        assertEquals("Номер задачи должен быть два", 2, TaskList.tasks.getIndex(task3));

        //проверяем что с таким же названием как предыдущая запишется с новым номером
        TaskList.tasks.createTask("Третья задача");
        Task task4 = TaskList.tasks.get(3);
        assertEquals("Номер задачи должен быть три", 3, TaskList.tasks.getIndex(task4));
        TaskList.tasks.printTasksList();

        //Проверка поиска по имени и номеру
        System.out.println("===============");
        Task taskfindbyNumber = TaskList.tasks.get(1);

        System.out.println("Задача найдена по номеру:2 " + taskfindbyNumber);
        System.out.println("===============");

        //Проверка удаленных В списке не должна выдаться задача под номером 2
        People testAdmin = new People();
        testAdmin.changeUserType("admin");
        assertEquals("Задача удалена.", TaskList.tasks.get(1).deleteTask(testAdmin));
        System.out.println("Задача 2 не должна отображаться, удалена:");
        TaskList.tasks.printTasksList();
        System.out.println("===============");

        //Проверка удаления от неадмина
        People testUser = new People();
        assertEquals("У юзера нет прав на удаление", TaskList.tasks.get(2).deleteTask(testUser));
        System.out.println("Задача 3 должна остаться на месте");
        TaskList.tasks.printTasksList();


    }

}
